package org.foodauthent.data;

import static java.util.Arrays.asList;
import static org.foodauthent.data.DeleteEntities.clearAllFingerprintSetsAndFingerprints;
import static org.foodauthent.data.DeleteEntities.clearAllModelsAndTrainingJobs;
import static org.foodauthent.data.DeleteEntities.clearAllPredictionsAndPredictionJobs;
import static org.foodauthent.data.DeleteEntities.clearAllProducts;
import static org.foodauthent.data.DeleteEntities.clearAllSamples;
import static org.foodauthent.data.DeleteEntities.clearAllSops;
import static org.foodauthent.data.DeleteEntities.clearAllWorkflows;
import static org.foodauthent.data.ListFiles.listBfrOilFingerprintFiles;
import static org.foodauthent.data.PopulateFiles.populateFilesWithMetadata;
import static org.foodauthent.data.PopulateModels.populateFingerprintSets;
import static org.foodauthent.data.PopulateModels.populateFingerprints;
import static org.foodauthent.data.PopulateModels.populatePredictionWorkflowOneClassClassification;
import static org.foodauthent.data.PopulateModels.populatePredictionWorkflowOpenChromRandomForest;
import static org.foodauthent.data.PopulateModels.populateProducts;
import static org.foodauthent.data.PopulateModels.populateSamples;
import static org.foodauthent.data.PopulateModels.populateTrainingWorkflowOpenChromRandomForest;
import static org.foodauthent.data.PopulateModels.predict;
import static org.foodauthent.data.PopulateModels.train;
import static org.foodauthent.data.ReadModels.readBfrOilFileMetadata;
import static org.foodauthent.data.ReadModels.readBfrOilFingerprintSets;
import static org.foodauthent.data.ReadModels.readBfrOilFingerprints;
import static org.foodauthent.data.ReadModels.readBfrOilSamples;
import static org.foodauthent.data.ReadModels.readEFOilFileMetadata;
import static org.foodauthent.data.ReadModels.readEFOilFingerprintSets;
import static org.foodauthent.data.ReadModels.readEFOilSamples;
import static org.foodauthent.data.ReadModels.readOilProducts;
import static org.foodauthent.rest.client.FASystemClientUtil.info;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Supplier;

import org.foodauthent.model.FaModel;
import org.foodauthent.model.FileMetadata;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.SystemInfo;
import org.foodauthent.model.json.ObjectMapperUtil;
import org.foodauthent.rest.client.FASystemClient;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Application that populates data to a foodauthent system.
 * 
 * @author Martin Horn, Unversity of Konstanz
 */
public class PopulateDataApp {

    public static void main(String[] args) throws JsonProcessingException {

	// config - TODO parse from args
	boolean runTrainingAndPredictionJobs = true;
	FASystemClient c = new FASystemClient("localhost", 9090);

	doit("Delete all entities", () -> {
	    clearAllProducts(c);
	    clearAllWorkflows(c);
	    clearAllFingerprintSetsAndFingerprints(c);
	    clearAllSamples(c);
	    clearAllModelsAndTrainingJobs(c);
	    clearAllPredictionsAndPredictionJobs(c);
	    clearAllSops(c);
	});

	// log("System Info after Initialisation");
	// log(info().getInfo().readEntity(SystemInfo.class));

	List<UUID> trainingwfIds = doitWithRes("Populate training workflows", () -> {
	    return asList(populateTrainingWorkflowOpenChromRandomForest(c),
		    PopulateModels.populateTrainingWorkflowOneClassClassification(c));
	});

	List<UUID> predictionwfIds = doitWithRes("Populate prediction workflows", () -> {
	    return asList(populatePredictionWorkflowOpenChromRandomForest(c),
		    populatePredictionWorkflowOneClassClassification(c));
	});

	doit("Populate products", () -> {
	    populateProducts(readOilProducts(), c);
	});

	doit("Populate samples", () -> {
	    populateSamples(readBfrOilSamples(), c);
	    populateSamples(readEFOilSamples(), c);
	});

	doit("Populate fingerprint files", () -> {
	    List<FileMetadata> metaList = readBfrOilFileMetadata();
	    List<File> files = listBfrOilFingerprintFiles();
	    populateFilesWithMetadata(files, metaList, c);
	    
	    metaList = readEFOilFileMetadata();
	    files = ListFiles.listEFOilFingerprintFiles();
	    populateFilesWithMetadata(files, metaList, c);

	});

	doit("Populate fingerprints", () -> {
	    populateFingerprints(readBfrOilFingerprints(), c);
	    populateFingerprints(ReadModels.readEFOilFingerprints(), c);
	});

	
	Map<String, UUID> fingerprintsetIds = doitWithRes("Populate fingerprint sets", () -> {
	    Map<String, UUID> ids = new HashMap<>();
	    List<FingerprintSet> fpsets = readBfrOilFingerprintSets();
	    List<UUID> uuids = populateFingerprintSets(fpsets, c);
	    for (int i = 0; i < fpsets.size(); i++) {
		ids.put("bfr_" + fpsets.get(i).getClassLabel(), uuids.get(i));
	    }

	    fpsets = readEFOilFingerprintSets();
	    uuids = populateFingerprintSets(fpsets, c);
	    for (int i = 0; i < fpsets.size(); i++) {
		ids.put("ef_" + fpsets.get(i).getClassLabel(), uuids.get(i));
	    }
	    return ids;
	});
	

	if (runTrainingAndPredictionJobs) {
	    Map<String, UUID> modelIds = doitWithRes("Train models", () -> {
		Map<String, UUID> ids = new HashMap<>();
		//ids.put("multi_class_oils", train(trainingwfIds.get(0), new ArrayList(fingerprintsetIds.values()), c));
		ids.put("one_class_kürbis",
			train(trainingwfIds.get(1), asList(fingerprintsetIds.get("bfr_kürbis")), c));
		ids.put("one_class_raps", train(trainingwfIds.get(1), asList(fingerprintsetIds.get("bfr_raps")), c));
		ids.put("one_class_sonnenblumen",
			train(trainingwfIds.get(1), asList(fingerprintsetIds.get("bfr_sonnenlbumen")), c));
		return ids;
	    });

	    doit("Run predictions", () -> {
		//predict(predictionwfIds.get(0), fingerprintsetIds.get("bfr_kürbis"), modelIds.get("multi_class_oils"), c);
		predict(predictionwfIds.get(0), fingerprintsetIds.get("bfr_raps"), modelIds.get("multi_class_oils"), c);
		predict(predictionwfIds.get(1), fingerprintsetIds.get("bfr_kürbis"), modelIds.get("one_class_kürbis"), c);
		predict(predictionwfIds.get(1), fingerprintsetIds.get("bfr_raps"), modelIds.get("one_class_kürbis"), c);
	    });
	}

	log("System Info");
	log(info(c).getInfo().readEntity(SystemInfo.class));
    }

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static void doit(String message, Runnable op) {
	long start = System.currentTimeMillis();
	System.out.print(sdf.format(new Date(start)) + "  " + message + " ... ");
	op.run();
	long end = System.currentTimeMillis();
	System.out.println("done (" + (end - start) / 1000 + " sec)");
    }

    private static <T> T doitWithRes(String message, Supplier<T> op) {
	long start = System.currentTimeMillis();
	System.out.print(sdf.format(new Date(start)) + "  " + message + " ... ");
	T res = op.get();
	long end = System.currentTimeMillis();
	System.out.println("done (" + (end - start) / 1000 + " sec)");
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
