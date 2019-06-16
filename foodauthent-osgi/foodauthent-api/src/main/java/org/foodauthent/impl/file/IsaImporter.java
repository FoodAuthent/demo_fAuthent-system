package org.foodauthent.impl.file;

//import static org.foodauthent.rest.client.FASystemClientUtil.files;
//import static org.foodauthent.rest.client.FASystemClientUtil.products;
//import static org.foodauthent.rest.client.FASystemClientUtil.samples;
//import static org.foodauthent.rest.client.FASystemClientUtil.sops;
//import static org.foodauthent.rest.client.FASystemClientUtil.fingerprints;
//import static org.foodauthent.rest.client.FASystemClientUtil.customMetadata;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.IOUtils;
import org.foodauthent.api.internal.exception.FARuntimeException;
import org.foodauthent.api.internal.persistence.Blob;
import org.foodauthent.api.internal.persistence.PersistenceService;
import org.foodauthent.impl.custommetadata.CustomMetadataServiceImpl;

//import javax.ws.rs.core.Response;

import org.foodauthent.model.FaModel;
import org.foodauthent.model.FileMetadata;
import org.foodauthent.model.Fingerprint;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.Product;
import org.foodauthent.model.ProductIngredientStatement;
import org.foodauthent.model.SOP;
import org.foodauthent.model.Sample;
import org.foodauthent.model.FileMetadata.TypeEnum;
//import org.foodauthent.model.json.ObjectMapperUtil;
//import org.foodauthent.rest.client.FASystemClient;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

public class IsaImporter {

    public static UUID importIsaFile(UUID fileId, InputStream upfile, PersistenceService persistenceService) {
	
	//FASystemClient c = new FASystemClient("localhost", 9090);

	//String fileName = "C:/Users/thsch/Documents/FA_ISA_CHEESE_EXAMPLE_archive.zip";
	    
	//ZipInputStream zipStream = new ZipInputStream(stream);

	ZipEntry entry;
	List<List<String>> investigation_rows = new ArrayList<List<String>>();
	List<List<String>> s_rows = new ArrayList<List<String>>();
	List<List<String>> assay_rows = new ArrayList<List<String>>();
	UUID sop_pdf_UUID = null;
	//try (FileInputStream fis = new FileInputStream(fileName);
	try (	BufferedInputStream bis = new BufferedInputStream(upfile);
		ZipInputStream zipStream = new ZipInputStream(upfile)) {
	    while ((entry = zipStream.getNextEntry()) != null) {
		 InputStreamReader isr = new InputStreamReader(zipStream, StandardCharsets.UTF_8);
		  BufferedReader br = new BufferedReader(isr);
		   if (entry.getName().toLowerCase().contains("nmr_spectroscopy")) {
		    
		    //br.lines().forEach(s ->a_rows.add(s.split("\t")));
		    br.lines().forEach(row ->assay_rows.add(Arrays.asList(row.split("\t"))));
		    //a_rows.forEach(r -> Arrays.asList(r).forEach(c->System.out.print(c)));
		} else if (entry.getName().toLowerCase().contains("investigation")) {
		    br.lines().forEach(row ->investigation_rows.add(Arrays.asList(row.split("\t"))));
		    //br.lines().forEach(s ->i_rows.add(s.split("\t")));
		    //i_rows.forEach(r -> Arrays.asList(r).forEach(c->System.out.print(c)));
		} else if (entry.getName().toLowerCase().contains("study")) {
		    br.lines().forEach(s ->s_rows.add(Arrays.asList(s.split("\t"))));
		    //s_rows.forEach(r -> Arrays.asList(r).forEach(c->System.out.print(c)));
		} else if (entry.getName().toLowerCase().contains(".pdf")) {
		    //Path p = Files.createTempFile(entry.getName().replace(".pdf", ""),".pdf");
		    //Files.copy(zipStream, p,StandardCopyOption.REPLACE_EXISTING);
		    //sop_pdf_file = p.toFile();
		    
		    //FILE--------------------------------------
		    // upload sop pdf file
		    FileMetadata fileMeta = FileMetadata.builder().setName(entry.getName())
			    .setDate(LocalDate.now())
			    .setDescription("Document for Standard Operating Procedures(sop)")
			    .setType(org.foodauthent.model.FileMetadata.TypeEnum.SOP_PDF)		
			    .setVersion(0).build();
		    UUID pdf_id = null;
		    try {
			    

			    //persistenceService.replace(fileMeta);
			sop_pdf_UUID= persistenceService.save(fileMeta).getFaId();

			    // new uuid for the blob (the same id as the one of metadata!)
			  pdf_id = persistenceService.save(new Blob(sop_pdf_UUID,zipStream ));

			    //return fileId;
			} catch (Exception e) {
			    throw new FARuntimeException(e);
			}finally {
			    System.out.println("new PDF FILE: " + pdf_id);
				      
			}
		    //sop_pdf_UUID = files(c).createFileMetadata(fileMeta).readEntity(UUID.class);
		    
		    //uploadFileData(sop_pdf_UUID,p.toFile());
		    
		    
		    
		}//end if pdf
		   zipStream.closeEntry();
				
		
	    }
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
	
	List<Sample> samples = new ArrayList<>();
	
	//Find Product-id by looking for GTIN
	// if nothing found, create ew product
	
	
	//Sample FKs: Product-id, SOP-id
	List<String> column_names = new ArrayList<String>();
	for(List<String> row : s_rows) {
	    row.replaceAll(x -> x = x.replace("\"", ""));
	    if(row.contains("Source Name")) {
		
		column_names = row;
		continue;
	    }
	    
	    Map<String,String> table_values = new HashMap<String,String>();
		
	    for(int i = 0; i < column_names.size();i++) {
		table_values.put(column_names.get(i), row.get(i));
		
	    }
	    //table_values.forEach((key,value)->System.out.println(key + " " + value));
	    //PRODUCT --------------------------------------------------
	    UUID productId;
	    try {
		productId = persistenceService.findProductByGtin(table_values.get("Characteristics[GTIN]")).getFaId();
		    
	    }catch(NoSuchElementException e) {
		//System.out.println("NoSuchElementException: "+e);
		//Create new product
		ProductIngredientStatement ingredientStatement = ProductIngredientStatement.builder()
			.setText(table_values.get("Characteristics[IngredientStatement]"))
			.build();
		Product p = Product.builder().setBrand(table_values.get("Characteristics[Brand]"))
			.setComment(table_values.get("Comment[notes]"))
			.setCompanyName(table_values.get("Characteristics[CompanyName]"))
			.setCountryOfOrigin(table_values.get("Characteristics[CountryOfOrigin]"))
			.setGtin(table_values.get("Characteristics[GTIN]"))
			.setLabelDescription(table_values.get("Characteristics[LabelDescription]"))
			.setProductClassification(table_values.get("Characteristics[ProductClassification]"))
			.setRegionOfOriginClaims(table_values.get("Characteristics[RegionOfOrigin-Claims]"))
			.setTargetMarket(table_values.get("Characteristics[TargetMarket]"))
			.setIngredientStatement(ingredientStatement)
			.build();
		productId = persistenceService.save(p).getFaId();
		System.out.println("Product ID: "+ productId);

	    }
	    
	   
	    
	    
	    //SOP----------------------------------------
	    //Foreign Key: File
	    // one SOP per product?
	    SOP sop = SOP.builder().setDescription("SOP FOR GTIN: "+table_values.getOrDefault("Characteristics[GTIN]","-") )
		    .setFileId(sop_pdf_UUID)
		    .setName("SOP NAME")
		    .setProductId(productId)
		    .build();
	    UUID sopId = persistenceService.save(sop).getFaId();
	    System.out.println("SOP: " + sopId);
	    //Create one SOP for all the sample
	    
	    
	    //SAMPLE-------------------------------------
	    //Foreign Key: Product-id , SOP-ID
	    
	    Sample sample = Sample.builder().setApplication("Foodauthent")
		    .setBestBeforeDate(table_values.get("Characteristics[BestBeforeDate]"))
		    .setComments(Arrays.asList(table_values.get("Comment[notes]")))
		    .setDateOfSampleDrawing(table_values.get("Characteristics[DateOfSampleDrawing]"))
		    .setLot(table_values.get("Characteristics[Lot]"))
		    .setProductId(productId)
		    .setSampleId(table_values.get("Sample Name"))
		    .setSamplingPlace(table_values.get("Characteristics[SamplingPlace]"))
		    .setSopId(sopId)
		    .build();
	    UUID sampleId = persistenceService.save(sample).getFaId();
	    System.out.println("SAMPLE: "+ sampleId);
	    //Product p = products().findProductByGtin("4260304330227").readEntity(Product.class);
	    //Object o = r.getEntity();
	    
	    
	    //CUSTOM-METADATA
	    // add to Sample the investigation metadata
	    
	    
	    //FINGERPRINTSET:-------------------------
	    //Foreign Key: List of Fingerprints
	    List<String> assay_col_names = new ArrayList<String>();
	    List<UUID> fingerId_list = new ArrayList<UUID>();
	    for(List<String> assay_row : assay_rows) {
		assay_row.replaceAll(x -> x = x.replace("\"", ""));
		    
		//TODO: File from each row
		//System.out.println(table_values.get("Sample Name") +" <--> "+ assay_row.get(0) + " =>" +table_values.get("Sample Name").equals(assay_row.get(0)));
		
		//Custom Metadata: all the assay-metadata
		if(assay_row.contains("Sample Name")) {
		    assay_col_names = assay_row;
		    continue;
		}
		if(!table_values.get("Sample Name").equals(assay_row.get(0))) {
		    continue;
		}
		Fingerprint finger = Fingerprint.builder().setSampleId(sampleId).setSopId(sopId).build();
		UUID fingerprint_id = persistenceService.save(finger).getFaId();
		System.out.println("FINGERPRINT: "+ fingerprint_id);
		String body = "{ \"metaboliteprofiling_nmr\" : {";
		for(int i = 0; i < assay_col_names.size();i++) {
		    if(assay_col_names.get(i).equals("Term Source REF") || assay_col_names.get(i).equals("Term Accession Number") )
			continue;
		    body += "\"" + assay_col_names.get(i) + "\" : \""+assay_row.get(i) + "\",";
		}
		
		body = body.substring(0, body.lastIndexOf(',')) + "}}";
		saveCustomMetadata("sample", "foodauthent_v0", fingerprint_id, body,persistenceService);
		
		fingerId_list.add(fingerprint_id);
	    }
	    FingerprintSet fingerSet = FingerprintSet.builder()
		    .setFingerprintIds(fingerId_list)
		    .setName(table_values.get("Sample Name").replace(" ", "")+"_assay")
		    .setDescription("Fingerprint Set of Sample with ID: "+sampleId)
		    .setClassLabel(table_values.get("Characteristics[ProductClassification]"))
		    .build();
	   
	    UUID fingerSetID = persistenceService.save(fingerSet).getFaId();
	    System.out.println("FINGERPRINT-SET " + fingerSetID);
	    // CUSTOM METADATA for Fingerprint-set
	    // Investigation
	    String inv_body = "{ \"investigation\" : {";
	    for(List<String> investigation_row : investigation_rows) {
		investigation_row.replaceAll(x -> x = x.replace("\"", ""));
		investigation_row.replaceAll(x -> x = x.replace("\\", "/"));
		    
		if(investigation_row.size() < 2) {
		    continue;
		}
		inv_body += "\"" + investigation_row.get(0) + "\" : \""+investigation_row.get(1) + "\",";
		
	    }
	    inv_body = inv_body.substring(0, inv_body.lastIndexOf(',')) + "}}";
	    System.out.println("Investigation Body: " + inv_body);
	    saveCustomMetadata("sample", "foodauthent_v0", fingerSetID, inv_body,persistenceService);
	    

	}
	return fileId;
    }
    private static void saveCustomMetadata(String modelId, String schemaId, UUID faId, String body, PersistenceService persistenceService) {
	ObjectMapper mapper = new ObjectMapper();
	String response = "ok";
	
	//Save CustomMetadata
	URL url = CustomMetadataServiceImpl.class.getResource("/json-schemas/" + "sample" + "/" + "foodauthent_v0" + ".json");
	
	try {
	    final JsonNode jsonNode = mapper.readTree(body);
	    final JsonNode schemaNode = mapper.readValue(  IOUtils.toString(url, StandardCharsets.UTF_8), JsonNode.class);
	    final JsonSchema schema = JsonSchemaFactory.byDefault().getJsonSchema(schemaNode);
	    final ProcessingReport report = schema.validate(jsonNode);
	    if (!report.isSuccess()) {
		throw new RuntimeException(report.toString());
	    }
	    persistenceService.saveCustomModel("sample", "foodauthent_v0", faId, jsonNode);
	} catch (Exception e) {
	    // TODO
	    response = "not ok";
	    //throw new RuntimeException(e);
	}

    }
}
