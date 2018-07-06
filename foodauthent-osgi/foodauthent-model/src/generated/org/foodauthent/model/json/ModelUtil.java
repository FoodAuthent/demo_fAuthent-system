/*
 * TODO	
 */
package org.foodauthent.model.json;

import org.foodauthent.model.Fingerprint;
import org.foodauthent.model.FingerprintMetadata;
import org.foodauthent.model.FingerprintRawData;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.MetadataEntries;
import org.foodauthent.model.Prediction;
import org.foodauthent.model.PredictionJob;
import org.foodauthent.model.Product;
import org.foodauthent.model.SOP;
import org.foodauthent.model.Tag;
import org.foodauthent.model.TrainingJob;
import org.foodauthent.model.Workflow;
import org.foodauthent.model.WorkflowInput;
import org.foodauthent.model.WorkflowOutput;
import org.foodauthent.model.json.mixin.FingerprintMetadataMixIn;
import org.foodauthent.model.json.mixin.FingerprintMixIn;
import org.foodauthent.model.json.mixin.FingerprintRawDataMixIn;
import org.foodauthent.model.json.mixin.FingerprintSetMixIn;
import org.foodauthent.model.json.mixin.MetadataEntriesMixIn;
import org.foodauthent.model.json.mixin.PredictionJobMixIn;
import org.foodauthent.model.json.mixin.PredictionMixIn;
import org.foodauthent.model.json.mixin.ProductMixIn;
import org.foodauthent.model.json.mixin.SOPMixIn;
import org.foodauthent.model.json.mixin.TagMixIn;
import org.foodauthent.model.json.mixin.TrainingJobMixIn;
import org.foodauthent.model.json.mixin.WorkflowInputMixIn;
import org.foodauthent.model.json.mixin.WorkflowMixIn;
import org.foodauthent.model.json.mixin.WorkflowOutputMixIn;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * TODO
 * 
 * @author Martin Horn, University of Konstanz
 */
public class ModelUtil {

    private ModelUtil() {
	// utility class
    }

    /**
     * TODO
     */
    public static final void addModelMixIns(final ObjectMapper mapper) {

	mapper.addMixIn(FingerprintMetadata.class, FingerprintMetadataMixIn.class);
	mapper.addMixIn(FingerprintMetadata.FingerprintMetadataBuilder.class,
		FingerprintMetadataMixIn.FingerprintMetadataMixInBuilder.class);
	mapper.addMixIn(Fingerprint.class, FingerprintMixIn.class);
	mapper.addMixIn(Fingerprint.FingerprintBuilder.class, FingerprintMixIn.FingerprintMixInBuilder.class);
	mapper.addMixIn(FingerprintRawData.class, FingerprintRawDataMixIn.class);
	mapper.addMixIn(FingerprintRawData.FingerprintRawDataBuilder.class,
		FingerprintRawDataMixIn.FingerprintRawDataMixInBuilder.class);
	mapper.addMixIn(FingerprintSet.class, FingerprintSetMixIn.class);
	mapper.addMixIn(FingerprintSet.FingerprintSetBuilder.class,
		FingerprintSetMixIn.FingerprintSetMixInBuilder.class);
	mapper.addMixIn(MetadataEntries.class, MetadataEntriesMixIn.class);
	mapper.addMixIn(MetadataEntries.MetadataEntriesBuilder.class,
		MetadataEntriesMixIn.MetadataEntriesMixInBuilder.class);
	mapper.addMixIn(PredictionJob.class, PredictionJobMixIn.class);
	mapper.addMixIn(PredictionJob.PredictionJobBuilder.class, PredictionJobMixIn.PredictionJobMixInBuilder.class);
	mapper.addMixIn(Prediction.class, PredictionMixIn.class);
	mapper.addMixIn(Prediction.PredictionBuilder.class, PredictionMixIn.PredictionMixInBuilder.class);
	mapper.addMixIn(Product.class, ProductMixIn.class);
	mapper.addMixIn(Product.ProductBuilder.class, ProductMixIn.ProductMixInBuilder.class);
	mapper.addMixIn(SOP.class, SOPMixIn.class);
	mapper.addMixIn(SOP.SOPBuilder.class, SOPMixIn.SOPMixInBuilder.class);
	mapper.addMixIn(Tag.class, TagMixIn.class);
	mapper.addMixIn(Tag.TagBuilder.class, TagMixIn.TagMixInBuilder.class);
	mapper.addMixIn(TrainingJob.class, TrainingJobMixIn.class);
	mapper.addMixIn(TrainingJob.TrainingJobBuilder.class, TrainingJobMixIn.TrainingJobMixInBuilder.class);
	mapper.addMixIn(WorkflowInput.class, WorkflowInputMixIn.class);
	mapper.addMixIn(WorkflowInput.WorkflowInputBuilder.class, WorkflowInputMixIn.WorkflowInputMixInBuilder.class);
	mapper.addMixIn(Workflow.class, WorkflowMixIn.class);
	mapper.addMixIn(Workflow.WorkflowBuilder.class, WorkflowMixIn.WorkflowMixInBuilder.class);
	mapper.addMixIn(WorkflowOutput.class, WorkflowOutputMixIn.class);
	mapper.addMixIn(WorkflowOutput.WorkflowOutputBuilder.class,
		WorkflowOutputMixIn.WorkflowOutputMixInBuilder.class);

    }
}
