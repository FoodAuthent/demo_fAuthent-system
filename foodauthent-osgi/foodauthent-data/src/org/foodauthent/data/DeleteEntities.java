package org.foodauthent.data;

import static org.foodauthent.rest.client.FASystemClientUtil.entities;
import static org.foodauthent.rest.client.FASystemClientUtil.files;
import static org.foodauthent.rest.client.FASystemClientUtil.fingerprints;
import static org.foodauthent.rest.client.FASystemClientUtil.models;
import static org.foodauthent.rest.client.FASystemClientUtil.products;
import static org.foodauthent.rest.client.FASystemClientUtil.samples;
import static org.foodauthent.rest.client.FASystemClientUtil.sops;
import static org.foodauthent.rest.client.FASystemClientUtil.workflows;

import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.foodauthent.model.Fingerprint;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.FingerprintSetPageResult;
import org.foodauthent.model.Model;
import org.foodauthent.model.ModelPageResult;
import org.foodauthent.model.Prediction;
import org.foodauthent.model.PredictionJob;
import org.foodauthent.model.PredictionJobPageResult;
import org.foodauthent.model.PredictionPageResult;
import org.foodauthent.model.Product;
import org.foodauthent.model.ProductPageResult;
import org.foodauthent.model.SOP;
import org.foodauthent.model.SOPPageResult;
import org.foodauthent.model.Sample;
import org.foodauthent.model.SamplePageResult;
import org.foodauthent.model.TrainingJob;
import org.foodauthent.model.TrainingJobPageResult;
import org.foodauthent.model.Workflow;
import org.foodauthent.model.WorkflowPageResult;
import org.foodauthent.rest.client.FASystemClient;

/**
 * 
 * @author Martin Horn, University of Konstanz
 */
public class DeleteEntities {

    private static final Integer MAX_RESULTS = Integer.valueOf(1000);

    private DeleteEntities() {
	// utility class
    }

    public static void clearAllWorkflows(FASystemClient c) {
	final Response response = workflows(c).findWorkflowByKeyword(1, MAX_RESULTS, null);
	if (response.getStatus() == 200 && response.getMediaType().isCompatible(MediaType.APPLICATION_JSON_TYPE)) {
	    List<Workflow> workflows = response.readEntity(WorkflowPageResult.class).getResults();
	    workflows.stream().forEach(wf -> {
		entities(c).removeEntity(wf.getFaId());
		files(c).removeFileMetadataAndData(wf.getFileId());
	    });
	}
    }

    public static void clearAllProducts(FASystemClient c) {
	final Response response = products(c).findProductByKeyword(1, MAX_RESULTS, null);
	if (response.getStatus() == 200 && response.getMediaType().isCompatible(MediaType.APPLICATION_JSON_TYPE)) {
	    final List<Product> products = response.readEntity(ProductPageResult.class).getResults();
	    products.stream().forEach(p -> entities(c).removeEntity(p.getFaId()));
	}
    }

    public static void clearAllFingerprintSetsAndFingerprints(FASystemClient c) {
	final Response response = fingerprints(c).findFingerprintSetByKeyword(1, MAX_RESULTS, null);
	if (response.getStatus() == 200 && response.getMediaType().isCompatible(MediaType.APPLICATION_JSON_TYPE)) {
	    final List<FingerprintSet> fpset = response.readEntity(FingerprintSetPageResult.class).getResults();
	    fpset.forEach(fps -> {
		// remove fingerprint set itself
		entities(c).removeEntity(fps.getFaId());
		// remove fingerprints
		fps.getFingerprintIds().forEach(fpid -> {
		    Fingerprint fp = fingerprints(c).getFingerprintById(fpid).readEntity(Fingerprint.class);
		    entities(c).removeEntity(fpid);
		    if (fp != null && fp.getFileId() != null) {
			files(c).removeFileMetadataAndData(fp.getFileId());
		    }
		});
	    });
	}
    }

    public static void clearAllSamples(FASystemClient c) {
	final Response response = samples(c).findSampleByKeyword(1, MAX_RESULTS, null);
	if (response.getStatus() == 200 && response.getMediaType().isCompatible(MediaType.APPLICATION_JSON_TYPE)) {
	    final List<Sample> samples = response.readEntity(SamplePageResult.class).getResults();
	    samples.forEach(s -> entities(c).removeEntity(s.getFaId()));
	}
    }

    public static void clearAllModelsAndTrainingJobs(FASystemClient c) {
	final Response response = workflows(c).findTrainingJobs(1, MAX_RESULTS, null);
	if (response.getStatus() == 200 && response.getMediaType().isCompatible(MediaType.APPLICATION_JSON_TYPE)) {
	    final List<TrainingJob> trainJobs = response.readEntity(TrainingJobPageResult.class).getResults();
	    trainJobs.forEach(j -> {
		entities(c).removeEntity(j.getFaId());
	    });

	    List<Model> models = models(c).findModelByKeyword(1, MAX_RESULTS, null).readEntity(ModelPageResult.class)
		    .getResults();
	    models.forEach(m -> {
		entities(c).removeEntity(m.getFaId());
		if (m.getFileId() != null) {
		    files(c).removeFileMetadataAndData(m.getFileId());
		}
	    });
	}
    }

    public static void clearAllPredictionsAndPredictionJobs(FASystemClient c) {
	final Response response = workflows(c).findPredictionJobs(1, MAX_RESULTS, null);
	if (response.getStatus() == 200 && response.getMediaType().isCompatible(MediaType.APPLICATION_JSON_TYPE)) {
	    List<PredictionJob> predJobs = response.readEntity(PredictionJobPageResult.class).getResults();
	    predJobs.forEach(j -> {
		entities(c).removeEntity(j.getFaId());
	    });

	    List<Prediction> preds = workflows(c).findPredictionByKeyword(1, MAX_RESULTS, null)
		    .readEntity(PredictionPageResult.class).getResults();
	    preds.forEach(p -> {
		entities(c).removeEntity(p.getFaId());
	    });
	}
    }

    public static void clearAllSops(FASystemClient c) {
	final Response response = sops(c).findSOPByKeyword(1, MAX_RESULTS, null);
	if (response.getStatus() == 200 && response.getMediaType().isCompatible(MediaType.APPLICATION_JSON_TYPE)) {
	    List<SOP> sops = response.readEntity(SOPPageResult.class).getResults();
	    sops.forEach(sop -> {
		entities(c).removeEntity(sop.getFaId());
		if (sop.getFileId() != null)
		    files(c).removeFileMetadataAndData(sop.getFileId());
	    });
	}
    }
}
