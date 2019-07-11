package org.foodauthent.impl.file;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.input.TeeInputStream;
import org.foodauthent.api.internal.exception.FARuntimeException;
import org.foodauthent.api.internal.persistence.Blob;
import org.foodauthent.api.internal.persistence.PersistenceService;
import org.foodauthent.impl.custommetadata.CustomMetadataServiceImpl;
import org.foodauthent.model.FileMetadata;
import org.foodauthent.model.FileMetadata.ContentTypeEnum;
import org.foodauthent.model.Fingerprint;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.Product;
import org.foodauthent.model.ProductIngredientStatement;
import org.foodauthent.model.SOP;
import org.foodauthent.model.Sample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

public class IsaImporter {

    private static final String TAB = "\t";
    private static final String PDF_SUFFIX = ".pdf";
    private static final String STUDY = "study";
    private static final String INVESTIGATION = "investigation";
    private static final String NMR_SPECTROSCOPY = "nmr_spectroscopy";

    private static final Logger LOG = LoggerFactory.getLogger(IsaImporter.class);

    public static UUID importIsaFile(UUID fileId, InputStream in, PersistenceService persistenceService)
	    throws IOException {

	ZipEntry entry;
	final List<List<String>> investigationRaws = new ArrayList<List<String>>();
	final List<List<String>> studyRows = new ArrayList<List<String>>();
	final List<List<String>> assayRows = new ArrayList<List<String>>();
	final Map<String, UUID> fingerprint_files = new HashMap<String, UUID>();

	final Path isaFilePath = Files.createTempFile("isa", "zip");
	Files.copy(in, isaFilePath, StandardCopyOption.REPLACE_EXISTING);
	
	UUID sop_pdf_UUID = null;
	try (final ZipInputStream zipStream = new ZipInputStream(new FileInputStream(isaFilePath.toString()))) {
	    while ((entry = zipStream.getNextEntry()) != null) {
		final InputStreamReader isr = new InputStreamReader(zipStream, StandardCharsets.UTF_8);
		final BufferedReader br = new BufferedReader(isr);
		if (entry.getName().toLowerCase().contains(NMR_SPECTROSCOPY)) {

		    // br.lines().forEach(s ->a_rows.add(s.split("\t")));
		    br.lines().forEach(row -> assayRows.add(Arrays.asList(row.split(TAB))));
		    // a_rows.forEach(r -> Arrays.asList(r).forEach(c->System.out.print(c)));
		} else if (entry.getName().toLowerCase().contains(INVESTIGATION)) {
		    br.lines().forEach(row -> investigationRaws.add(Arrays.asList(row.split(TAB))));
		    // br.lines().forEach(s ->i_rows.add(s.split("\t")));
		    // i_rows.forEach(r -> Arrays.asList(r).forEach(c->System.out.print(c)));
		} else if (entry.getName().toLowerCase().contains(STUDY)) {
		    br.lines().forEach(s -> studyRows.add(Arrays.asList(s.split(TAB))));
		    // s_rows.forEach(r -> Arrays.asList(r).forEach(c->System.out.print(c)));
		} else if (entry.getName().toLowerCase().contains(PDF_SUFFIX)) {
		    Path p = Files.createTempFile(entry.getName().replace(PDF_SUFFIX, ""), PDF_SUFFIX);
		    Files.copy(zipStream, p, StandardCopyOption.REPLACE_EXISTING);
		    FileInputStream temp_in = new FileInputStream(p.toString());
		    // upload sop pdf file
		    FileMetadata fileMeta = FileMetadata.builder().setUploadName(entry.getName())
			    // .setName(entry.getName())
			    .setName(entry.getName()).setDate(LocalDate.now())
			    .setContentType(ContentTypeEnum.OCTET_STREAM)
			    .setDescription("Document for Standard Operating Procedures(sop)")
			    .setType(org.foodauthent.model.FileMetadata.TypeEnum.SOP_PDF).setVersion(0).build();
		    try {

			// persistenceService.replace(fileMeta);
			sop_pdf_UUID = persistenceService.save(fileMeta).getFaId();

			// new uuid for the blob (the same id as the one of metadata!)
			final UUID pdf_id = persistenceService.save(new Blob(sop_pdf_UUID, temp_in));

			LOG.info("new PDF FILE: " + pdf_id);

		    } catch (Exception e) {
			throw new FARuntimeException(e);
		    } finally {
			IOUtils.closeQuietly(temp_in);
			Files.delete(p);
		    }

		} else { // Save all other files and their names (assumption: bruker-files

		    // don't save the same file multiple times
		    if (fingerprint_files.containsKey(entry.getName()))
			continue;

		    FileMetadata fileMeta = FileMetadata.builder()
			    .setUploadName(entry.getName())
			    .setName(entry.getName())
			    .setDate(LocalDate.now())
			    .setContentType(ContentTypeEnum.ZIP)
			    .setDescription("raw data of fingerprint")
			    .setType(org.foodauthent.model.FileMetadata.TypeEnum.FINGERPRINT_BRUKER)
			    .setVersion(0)
			    .build();
		    try {

			UUID file_meta_ID = persistenceService.save(fileMeta).getFaId();
			UUID file_ID = persistenceService.save(new Blob(file_meta_ID, zipStream));
			// new uuid for the blob (the same id as the one of metadata!)
			fingerprint_files.put(entry.getName(), file_ID);
			LOG.info("BRUKER ID: " + file_ID);
		    } catch (Exception e) {
			throw new FARuntimeException(e);
		    }
		}
		zipStream.closeEntry();

	    }
	} catch (IOException e) {
	    LOG.error(e.getMessage(), e);
	} 

	List<Sample> samples = new ArrayList<>();

	// Find Product-id by looking for GTIN
	// if nothing found, create ew product

	// Sample FKs: Product-id, SOP-id
	List<String> column_names = new ArrayList<String>();
	for (List<String> row : studyRows) {
	    row.replaceAll(x -> x = x.replace("\"", ""));
	    if (row.contains("Source Name")) {

		column_names = row;
		continue;
	    }

	    Map<String, String> table_values = new HashMap<String, String>();

	    for (int i = 0; i < column_names.size(); i++) {
		table_values.put(column_names.get(i), row.get(i));

	    }
	    // table_values.forEach((key,value)->LOG.info(key + " " + value));
	    // PRODUCT --------------------------------------------------
	    UUID productId;
	    try {
		productId = persistenceService.findProductByGtin(table_values.get("Characteristics[GTIN]")).getFaId();

	    } catch (NoSuchElementException e) {
		// LOG.info("NoSuchElementException: "+e);
		// Create new product
		ProductIngredientStatement ingredientStatement = ProductIngredientStatement.builder()
			.setText(table_values.get("Characteristics[IngredientStatement]")).build();
		Product p = Product.builder().setBrand(table_values.get("Characteristics[Brand]"))
			.setComment(table_values.get("Comment[notes]"))
			.setCompanyName(table_values.get("Characteristics[CompanyName]"))
			.setCountryOfOrigin(table_values.get("Characteristics[CountryOfOrigin]"))
			.setGtin(table_values.get("Characteristics[GTIN]"))
			.setLabelDescription(table_values.get("Characteristics[LabelDescription]"))
			.setProductClassification(table_values.get("Characteristics[ProductClassification]"))
			.setRegionOfOriginClaims(table_values.get("Characteristics[RegionOfOrigin-Claims]"))
			.setTargetMarket(table_values.get("Characteristics[TargetMarket]"))
			.setIngredientStatement(ingredientStatement).build();
		productId = persistenceService.save(p).getFaId();
		LOG.info("Product ID: " + productId);

	    }

	    // SOP----------------------------------------
	    // Foreign Key: File
	    // one SOP per product?
	    UUID sopId = null;
	    if (sop_pdf_UUID != null) {
		SOP sop = SOP.builder()
			.setDescription("SOP FOR GTIN: " + table_values.getOrDefault("Characteristics[GTIN]", "-"))
			.setFileId(sop_pdf_UUID).setName("SOP NAME").setProductId(productId).build();
		sopId = persistenceService.save(sop).getFaId();
	    }
	    LOG.info("SOP: " + sopId);
	    // Create one SOP for all the sample

	    // SAMPLE-------------------------------------
	    // Foreign Key: Product-id , SOP-ID

	    Sample sample = Sample.builder().setApplication("Foodauthent")
		    .setBestBeforeDate(table_values.get("Characteristics[BestBeforeDate]"))
		    .setComments(Arrays.asList(table_values.get("Comment[notes]")))
		    .setDateOfSampleDrawing(table_values.get("Characteristics[DateOfSampleDrawing]"))
		    .setLot(table_values.get("Characteristics[Lot]")).setProductId(productId)
		    .setSampleId(table_values.get("Sample Name"))
		    .setSamplingPlace(table_values.get("Characteristics[SamplingPlace]")).setSopId(sopId).build();
	    UUID sampleId = persistenceService.save(sample).getFaId();
	    LOG.info("SAMPLE: " + sampleId);
	    // Product p =
	    // products().findProductByGtin("4260304330227").readEntity(Product.class);
	    // Object o = r.getEntity();

	    // CUSTOM-METADATA
	    // add to Sample the investigation metadata

	    // FINGERPRINTSET:-------------------------
	    // Foreign Key: List of Fingerprints
	    List<String> assay_col_names = new ArrayList<String>();
	    List<UUID> fingerId_list = new ArrayList<UUID>();
	    for (List<String> assay_row : assayRows) {
		assay_row.replaceAll(x -> x = x.replace("\"", ""));

		// TODO: File from each row
		// LOG.info(table_values.get("Sample Name") +" <--> "+
		// assay_row.get(0) + " =>" +table_values.get("Sample
		// Name").equals(assay_row.get(0)));

		// Custom Metadata: all the assay-metadata
		if (assay_row.contains("Sample Name")) {
		    assay_col_names = assay_row;
		    continue;
		}
		if (!table_values.get("Sample Name").equals(assay_row.get(0))) {
		    continue;
		}
		// Fingerprint
		// Foreign keys: SampleID, SopID, FileID

		int index = assay_col_names.indexOf("Derived Spectral Data File");

		Fingerprint finger = Fingerprint.builder().setSampleId(sampleId).setSopId(sopId)
			.setFileId(fingerprint_files.get(assay_row.get(index))).build();
		UUID fingerprint_id = persistenceService.save(finger).getFaId();
		LOG.info("FINGERPRINT: " + fingerprint_id);
		String body = "{ \"metaboliteprofiling_nmr\" : {";
		for (int i = 0; i < assay_col_names.size(); i++) {
		    if (assay_col_names.get(i).equals("Term Source REF")
			    || assay_col_names.get(i).equals("Term Accession Number"))
			continue;
		    body += "\"" + assay_col_names.get(i) + "\" : \"" + assay_row.get(i) + "\",";
		}

		body = body.substring(0, body.lastIndexOf(',')) + "}}";
		saveCustomMetadata("sample", "foodauthent_v0", fingerprint_id, body, persistenceService);

		fingerId_list.add(fingerprint_id);
	    }
	    FingerprintSet fingerSet = FingerprintSet.builder().setFingerprintIds(fingerId_list)
		    .setName(table_values.get("Sample Name").replace(" ", "") + "_assay")
		    .setDescription("Fingerprint Set of Sample with ID: " + sampleId)
		    .setClassLabel(table_values.get("Characteristics[ProductClassification]")).build();

	    UUID fingerSetID = persistenceService.save(fingerSet).getFaId();
	    LOG.info("FINGERPRINT-SET " + fingerSetID);
	    // CUSTOM METADATA for Fingerprint-set
	    // Investigation
	    String inv_body = "{ \"investigation\" : {";
	    for (List<String> investigation_row : investigationRaws) {
		investigation_row.replaceAll(x -> x = x.replace("\"", ""));
		investigation_row.replaceAll(x -> x = x.replace("\\", "/"));

		if (investigation_row.size() < 2) {
		    continue;
		}
		inv_body += "\"" + investigation_row.get(0) + "\" : \"" + investigation_row.get(1) + "\",";

	    }
	    inv_body = inv_body.substring(0, inv_body.lastIndexOf(',')) + "}}";
	    LOG.info("Investigation Body: " + inv_body);
	    saveCustomMetadata("sample", "foodauthent_v0", fingerSetID, inv_body, persistenceService);

	}
	final FileInputStream isaInputStream = new FileInputStream(isaFilePath.toString());
	final UUID isaFileId = persistenceService.save(new Blob(fileId, isaInputStream));
	return isaFileId;
    }

    private static void saveCustomMetadata(String modelId, String schemaId, UUID faId, String body,
	    PersistenceService persistenceService) {
	ObjectMapper mapper = new ObjectMapper();
	String response = "ok";

	// Save CustomMetadata
	URL url = CustomMetadataServiceImpl.class
		.getResource("/json-schemas/" + "sample" + "/" + "foodauthent_v0" + ".json");

	try {
	    final JsonNode jsonNode = mapper.readTree(body);
	    final JsonNode schemaNode = mapper.readValue(IOUtils.toString(url, StandardCharsets.UTF_8), JsonNode.class);
	    final JsonSchema schema = JsonSchemaFactory.byDefault().getJsonSchema(schemaNode);
	    final ProcessingReport report = schema.validate(jsonNode);
	    if (!report.isSuccess()) {
		throw new RuntimeException(report.toString());
	    }
	    persistenceService.saveCustomModel("sample", "foodauthent_v0", faId, jsonNode);
	} catch (Exception e) {
	    // TODO
	    response = "not ok";
	    // throw new RuntimeException(e);
	}

    }
}
