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

    private DeleteEntities() {
	// utility class
    }
    
<<<<<<< .merge_file_qlwBOF
    public static void clearAllWorkflows() {
	List<Workflow> workflows = workflows().findWorkflowByKeyword(1, 1000, null)
=======
    public static void clearAllWorkflows(FASystemClient c) {
	List<Workflow> workflows = workflows(c).findWorkflowByKeyword(1, Integer.MAX_VALUE, null)
>>>>>>> .merge_file_bkY9fY
		.readEntity(WorkflowPageResult.class).getResults();
	workflows.stream().forEach(wf -> {
	    entities(c).removeEntity(wf.getFaId());
	    files(c).removeFileMetadataAndData(wf.getFileId());
	});
    }
   
<<<<<<< .merge_file_qlwBOF
    public static void clearAllProducts() {
	List<Product> products = products().findProductByKeyword(1, 1000, null)
=======
    public static void clearAllProducts(FASystemClient c) {
	List<Product> products = products(c).findProductByKeyword(1, Integer.MAX_VALUE, null)
>>>>>>> .merge_file_bkY9fY
		.readEntity(ProductPageResult.class).getResults();
	products.stream().forEach(p -> entities(c).removeEntity(p.getFaId()));
    }
    
    public static void clearAllFingerprintSetsAndFingerprints(FASystemClient c) {
	List<FingerprintSet> fpset = fingerprints(c).findFingerprintSetByKeyword(1, Integer.MAX_VALUE, null)
		.readEntity(FingerprintSetPageResult.class).getResults();
	fpset.forEach(fps -> {
	    // remove fingerprint set itself
	    entities(c).removeEntity(fps.getFaId());
	    // remove fingerprints
	    fps.getFingerprintIds().forEach(fpid -> {
		Fingerprint fp = fingerprints(c).getFingerprintById(fpid).readEntity(Fingerprint.class);
		entities(c).removeEntity(fpid);
		if (fp != null) {
		    files(c).removeFileMetadataAndData(fp.getFileId());
		}
	    });
	});
    }
    
    public static void clearAllSamples(FASystemClient c) {
	List<Sample> samples = samples(c).findSampleByKeyword(1, Integer.MAX_VALUE, null)
		.readEntity(SamplePageResult.class).getResults();
	samples.forEach(s -> entities(c).removeEntity(s.getFaId()));
    }
    
    public static void clearAllModelsAndTrainingJobs(FASystemClient c) {
	List<TrainingJob> trainJobs = workflows(c).findTrainingJobs(1, Integer.MAX_VALUE, null)
		.readEntity(TrainingJobPageResult.class).getResults();
	trainJobs.forEach(j -> {
	    entities(c).removeEntity(j.getFaId());
	});
	
	List<Model> models = models(c).findModelByKeyword(1, Integer.MAX_VALUE, null).readEntity(ModelPageResult.class)
		.getResults();
	models.forEach(m -> {
	    entities(c).removeEntity(m.getFaId());
	    if (m.getFileId() != null) {
		files(c).removeFileMetadataAndData(m.getFileId());
	    }
	});
    }
   
    public static void clearAllPredictionsAndPredictionJobs(FASystemClient c) {
	List<PredictionJob> predJobs = workflows(c).findPredictionJobs(1, Integer.MAX_VALUE, null)
		.readEntity(PredictionJobPageResult.class).getResults();
	predJobs.forEach(j -> {
	    entities(c).removeEntity(j.getFaId());
	});
	
	List<Prediction> preds = workflows(c).findPredictionByKeyword(1, Integer.MAX_VALUE, null)
		.readEntity(PredictionPageResult.class).getResults();
	preds.forEach(p -> {
	    entities(c).removeEntity(p.getFaId());
	});

    }
    
    public static void clearAllSops(FASystemClient c) {
	List<SOP> sops = sops(c).findSOPByKeyword(1, Integer.MAX_VALUE, null).readEntity(SOPPageResult.class)
		.getResults();
	sops.forEach(sop -> {
	    entities(c).removeEntity(sop.getFaId());
	    files(c).removeFileMetadataAndData(sop.getFileId());
	});
    }
}
