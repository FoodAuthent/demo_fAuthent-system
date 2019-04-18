package org.foodauthent.data;

import static org.foodauthent.data.DeleteEntities.clearAllProducts;
import static org.foodauthent.data.DeleteEntities.clearAllWorkflows;
import static org.foodauthent.data.FASystem.info;
import static org.foodauthent.data.ListFiles.listBfrOilFingerprintFiles;
import static org.foodauthent.data.PopulateFiles.populateFileMetadata;
import static org.foodauthent.data.PopulateFiles.populateFiles;
import static org.foodauthent.data.PopulateModels.populateFingerprintSets;
import static org.foodauthent.data.PopulateModels.populateFingerprints;
import static org.foodauthent.data.PopulateModels.populateProducts;
import static org.foodauthent.data.PopulateModels.populateSamples;
import static org.foodauthent.data.PopulateModels.populateTestPedictionWorkflow;
import static org.foodauthent.data.PopulateModels.populateTestTrainingWorkflow;
import static org.foodauthent.data.PopulateModels.train;
import static org.foodauthent.data.ReadModels.readBfrOilFileMetadata;
import static org.foodauthent.data.ReadModels.readBfrOilFingerprintSets;
import static org.foodauthent.data.ReadModels.readBfrOilFingerprints;
import static org.foodauthent.data.ReadModels.readBfrOilSamples;
import static org.foodauthent.data.ReadModels.readOilProducts;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.foodauthent.model.FaModel;
import org.foodauthent.model.FileMetadata;
import org.foodauthent.model.SystemInfo;
import org.foodauthent.model.json.ObjectMapperUtil;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Application that populates data to a foodauthent system.
 * 
 * @author Martin Horn, Unversity of Konstanz
 */
public class PopulateDataApp {

    public static void main(String[] args) throws JsonProcessingException {
	doit("Delete all products and workflows", () -> {
	    clearAllProducts();
	    clearAllWorkflows();
	});
	
	//TODO delete blobs and all other missing entities
	UUID trainingwfId = doitWithRes("Populate training workflows", () -> {
	    return populateTestTrainingWorkflow();
	});
	
	UUID predictionwfId = doitWithRes("Populate prediction workflows", () -> {
	    return populateTestPedictionWorkflow();
	});

	doit("Populate products", () -> {
	    populateProducts(readOilProducts());
	});

	doit("Populate samples", () -> {
	    populateSamples(readBfrOilSamples());
	});

	doit("Populate fingerprint files", () -> {
	    List<FileMetadata> metaList = readBfrOilFileMetadata();
	    populateFileMetadata(metaList);
	    Map<String, UUID> name2uuidMap = metaList.stream()
		    .collect(Collectors.toMap(m -> m.getName(), m -> m.getFaId()));
	    populateFiles(listBfrOilFingerprintFiles(), name2uuidMap);
	});

	doit("Populate fingerprints", () -> {
	    populateFingerprints(readBfrOilFingerprints());
	});

	List<UUID> fingerprintsetIds = doitWithRes("Populate fingerprint sets", () -> {
	    return populateFingerprintSets(readBfrOilFingerprintSets());
	});

	UUID modelId = doitWithRes("Train models", () -> {
	    return train(trainingwfId, Arrays.asList(fingerprintsetIds.get(0), fingerprintsetIds.get(1)));
	});
	
	doit("Run prediction", () -> {
	    PopulateModels.predict(predictionwfId, fingerprintsetIds.get(0), modelId);
	});

	log("System Info");
	log(info().getInfo().readEntity(SystemInfo.class));
    }

    private static SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY hh:mm:ss");

    private static void doit(String message, Runnable op) {
	System.out.print(sdf.format(new Date(System.currentTimeMillis())) + "  " + message + " ... ");
	op.run();
	System.out.println("done");
    }

    private static <T> T doitWithRes(String message, Supplier<T> op) {
	System.out.print(sdf.format(new Date(System.currentTimeMillis())) + "  " + message + " ... ");
	T res = op.get();
	System.out.println("done");
	return res;
    }

    private static void log(String message) {
	System.out.println(message);
    }

    private static void log(FaModel model) throws JsonProcessingException {
	System.out
		.println(ObjectMapperUtil.getObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(model));
    }
}
