package org.foodauthent.fakx;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.TransformerException;

import org.foodauthent.model.FaModel;
import org.foodauthent.model.Fingerprint;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.Model;
import org.foodauthent.model.Prediction;
import org.foodauthent.model.Product;
import org.foodauthent.model.SOP;
import org.foodauthent.model.Tag;
import org.foodauthent.model.Workflow;
import org.jdom2.JDOMException;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.unirostock.sems.cbarchive.ArchiveEntry;
import de.unirostock.sems.cbarchive.CombineArchive;
import de.unirostock.sems.cbarchive.CombineArchiveException;

/**
 * Reads/writes contents to FAKX file with structure:
 * 
 * <ul>
 * <li>sops/
 * <li>products/
 * <li>tags/
 * <li>models/
 * <li>predictions/
 * <li>workflows/
 * <li>fingerprints/
 * <li>fingerprintsets/
 * </ul>
 */
public class FAKX {

	private static ObjectMapper MAPPER = new ObjectMapper();

	private static URI jsonURI = URI.create("application/json");
	private static URI binaryURI = URI.create("application/octet-stream");

	public static Archive read(File file) {

		List<SOP> sop = new ArrayList<>();
		List<Product> product = new ArrayList<>();
		List<Tag> tag = new ArrayList<>();
		List<Model> model = new ArrayList<>();
		List<Prediction> prediction = new ArrayList<>();
		List<Workflow> workflow = new ArrayList<>();
		List<Fingerprint> fingerprint = new ArrayList<>();
		List<FingerprintSet> fingerprintset = new ArrayList<>();
		List<File> files = new ArrayList<>();

		try (CombineArchive ca = new CombineArchive(file)) {
			
			for (ArchiveEntry entry : ca.getEntriesWithFormat(jsonURI)) {
				
				String folder = entry.getPath().getParent().toString();
				
				if (folder.equals("sops")) {
					sop.add(readModel(entry, SOP.class));
				} else if (folder.equals("products")) {
					product.add(readModel(entry, Product.class));
				} else if (folder.equals("tags")) {
					tag.add(readModel(entry, Tag.class));
				} else if (folder.equals("models")) {
					model.add(readModel(entry, Model.class));
				} else if (folder.equals("predictions")) {
					prediction.add(readModel(entry, Prediction.class));
				} else if (folder.equals("workflows")) {
					workflow.add(readModel(entry, Workflow.class));
				} else if (folder.equals("fingerprints")) {
					fingerprint.add(readModel(entry, Fingerprint.class));
				} else if (folder.equals("fingerprintsets")) {
					fingerprintset.add(readModel(entry, FingerprintSet.class));
				}
			}
			
			// Read files
			for (ArchiveEntry entry : ca.getEntriesWithFormat(binaryURI)) {
				File tempFile = File.createTempFile("file", "");
				entry.extractFile(tempFile);
				files.add(tempFile);
			}
 
		} catch (IOException | JDOMException | ParseException | CombineArchiveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Archive.Builder builder = new Archive.Builder();
		Archive archive = builder.sop(sop).product(product).tag(tag).model(model).prediction(prediction)
				.workflow(workflow).fingerprint(fingerprint).fingerprintset(fingerprintset).build();
		return archive;
	}

	/**
	 * Writes contents to FAKX with structure:
	 * 
	 * <ul>
	 * <li>sops/
	 * <li>products/
	 * <li>tags/
	 * <li>models/
	 * <li>predictions/
	 * <li>workflows/
	 * <li>fingerprints/
	 * <li>fingerprintsets/
	 * </ul>
	 */
	public static void write(Archive archive, File file)
			throws IOException, JDOMException, ParseException, CombineArchiveException, TransformerException {

		try (CombineArchive ca = new CombineArchive(file)) {

			archive.getSOP().forEach(it -> writeModel(ca, it, "sops/" + it.getFaId() + ".json"));
			archive.getProduct().forEach(it -> writeModel(ca, it, "products/" + it.getFaId() + ".json"));
			archive.getTag().forEach(it -> writeModel(ca, it, "tags/" + it.getFaId() + ".json"));
			archive.getModel().forEach(it -> writeModel(ca, it, "models/" + it.getFaId() + ".json"));
			archive.getPrediction().forEach(it -> writeModel(ca, it, "predictions/" + it.getFaId() + ".json"));
			archive.getWorkflow().forEach(it -> writeModel(ca, it, "workflows/" + it.getFaId() + ".json"));
			archive.getFingerprint().forEach(it -> writeModel(ca, it, "fingerprints/" + it.getFaId() + ".json"));
			archive.getFingerprintSet().forEach(it -> writeModel(ca, it, "fingerprintsets/" + it.getFaId() + ".json"));

			for (File it : archive.getFile()) {
				ca.addEntry(it, "files/" + it.getName(), binaryURI);
			}

			ca.pack();
		}
	}
	
	private static <T> T readModel(ArchiveEntry entry, Class<T> valueType) throws IOException {
		
		File tempFile = File.createTempFile("model", ".json");
		entry.extractFile(tempFile);
		T model = MAPPER.readValue(tempFile, valueType);
		tempFile.delete();
		
		return model;
	}

	private static void writeModel(CombineArchive archive, FaModel model, String targetName) {
		File tempFile;
		try {
			tempFile = File.createTempFile("model", ".json");
			MAPPER.writeValue(tempFile, model);
			archive.addEntry(tempFile, targetName, jsonURI);
			tempFile.delete();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
