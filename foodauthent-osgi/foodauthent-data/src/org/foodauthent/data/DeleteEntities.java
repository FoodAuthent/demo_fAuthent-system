package org.foodauthent.data;

import static org.foodauthent.rest.client.FASystemClient.entities;
import static org.foodauthent.rest.client.FASystemClient.files;
import static org.foodauthent.rest.client.FASystemClient.fingerprints;
import static org.foodauthent.rest.client.FASystemClient.models;
import static org.foodauthent.rest.client.FASystemClient.products;
import static org.foodauthent.rest.client.FASystemClient.samples;
import static org.foodauthent.rest.client.FASystemClient.sops;
import static org.foodauthent.rest.client.FASystemClient.workflows;

import java.util.List;

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

/**
 * 
 * @author Martin Horn, University of Konstanz
 */
public class DeleteEntities {

    private DeleteEntities() {
	// utility class
    }
    
    public static void clearAllWorkflows() {
	List<Workflow> workflows = workflows().findWorkflowByKeyword(1, 1000, null)
		.readEntity(WorkflowPageResult.class).getResults();
	workflows.stream().forEach(wf -> {
	    entities().removeEntity(wf.getFaId());
	    files().removeFileMetadataAndData(wf.getFileId());
	});
    }
   
    public static void clearAllProducts() {
	List<Product> products = products().findProductByKeyword(1, 1000, null)
		.readEntity(ProductPageResult.class).getResults();
	products.stream().forEach(p -> entities().removeEntity(p.getFaId()));
    }
    
    public static void clearAllFingerprintSetsAndFingerprints() {
	List<FingerprintSet> fpset = fingerprints().findFingerprintSetByKeyword(1, Integer.MAX_VALUE, null)
		.readEntity(FingerprintSetPageResult.class).getResults();
	fpset.forEach(fps -> {
	    // remove fingerprint set itself
	    entities().removeEntity(fps.getFaId());
	    // remove fingerprints
	    fps.getFingerprintIds().forEach(fpid -> {
		Fingerprint fp = fingerprints().getFingerprintById(fpid).readEntity(Fingerprint.class);
		entities().removeEntity(fpid);
		if (fp != null) {
		    files().removeFileMetadataAndData(fp.getFileId());
		}
	    });
	});
    }
    
    public static void clearAllSamples() {
	List<Sample> samples = samples().findSampleByKeyword(1, Integer.MAX_VALUE, null)
		.readEntity(SamplePageResult.class).getResults();
	samples.forEach(s -> entities().removeEntity(s.getFaId()));
    }
    
    public static void clearAllModelsAndTrainingJobs() {
	List<TrainingJob> trainJobs = workflows().findTrainingJobs(1, Integer.MAX_VALUE, null)
		.readEntity(TrainingJobPageResult.class).getResults();
	trainJobs.forEach(j -> {
	    entities().removeEntity(j.getFaId());
	});
	
	List<Model> models = models().findModelByKeyword(1, Integer.MAX_VALUE, null).readEntity(ModelPageResult.class)
		.getResults();
	models.forEach(m -> {
	    entities().removeEntity(m.getFaId());
	    files().removeFileMetadataAndData(m.getFileId());
	});
    }
   
    public static void clearAllPredictionsAndPredictionJobs() {
	List<PredictionJob> predJobs = workflows().findPredictionJobs(1, Integer.MAX_VALUE, null)
		.readEntity(PredictionJobPageResult.class).getResults();
	predJobs.forEach(j -> {
	    entities().removeEntity(j.getFaId());
	});
	
	List<Prediction> preds = workflows().findPredictionByKeyword(1, Integer.MAX_VALUE, null)
		.readEntity(PredictionPageResult.class).getResults();
	preds.forEach(p -> {
	    entities().removeEntity(p.getFaId());
	});

    }
    
    public static void clearAllSops() {
	List<SOP> sops = sops().findSOPByKeyword(1, Integer.MAX_VALUE, null).readEntity(SOPPageResult.class)
		.getResults();
	sops.forEach(sop -> {
	    entities().removeEntity(sop.getFaId());
	    files().removeFileMetadataAndData(sop.getFileId());
	});
    }
}
