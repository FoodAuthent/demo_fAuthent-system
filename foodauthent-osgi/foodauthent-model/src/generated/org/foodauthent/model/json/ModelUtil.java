/*
 * TODO	
 */
package org.foodauthent.model.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.foodauthent.model.*;
import org.foodauthent.model.json.mixin.*;

/**
 * TODO
 
 * @author Martin Horn, University of Konstanz
 */
public class ModelUtil {

    private ModelUtil() {
        //utility class
    }

    /**
     * TODO
     */
    public static final void addModelMixIns(final ObjectMapper mapper) {
    
        mapper.addMixIn(FingerprintMetadata.class, FingerprintMetadataMixIn.class);
        mapper.addMixIn(FingerprintMetadata.FingerprintMetadataBuilder.class, FingerprintMetadataMixIn.FingerprintMetadataMixInBuilder.class);
        mapper.addMixIn(Fingerprint.class, FingerprintMixIn.class);
        mapper.addMixIn(Fingerprint.FingerprintBuilder.class, FingerprintMixIn.FingerprintMixInBuilder.class);
        mapper.addMixIn(FingerprintRawData.class, FingerprintRawDataMixIn.class);
        mapper.addMixIn(FingerprintRawData.FingerprintRawDataBuilder.class, FingerprintRawDataMixIn.FingerprintRawDataMixInBuilder.class);
        mapper.addMixIn(FingerprintSet.class, FingerprintSetMixIn.class);
        mapper.addMixIn(FingerprintSet.FingerprintSetBuilder.class, FingerprintSetMixIn.FingerprintSetMixInBuilder.class);
        mapper.addMixIn(MetadataEntries.class, MetadataEntriesMixIn.class);
        mapper.addMixIn(MetadataEntries.MetadataEntriesBuilder.class, MetadataEntriesMixIn.MetadataEntriesMixInBuilder.class);
        mapper.addMixIn(PredictionJob.class, PredictionJobMixIn.class);
        mapper.addMixIn(PredictionJob.PredictionJobBuilder.class, PredictionJobMixIn.PredictionJobMixInBuilder.class);
        mapper.addMixIn(Prediction.class, PredictionMixIn.class);
        mapper.addMixIn(Prediction.PredictionBuilder.class, PredictionMixIn.PredictionMixInBuilder.class);
        mapper.addMixIn(PredictionWorkflowInput.class, PredictionWorkflowInputMixIn.class);
        mapper.addMixIn(PredictionWorkflowInput.PredictionWorkflowInputBuilder.class, PredictionWorkflowInputMixIn.PredictionWorkflowInputMixInBuilder.class);
        mapper.addMixIn(PredictionWorkflowOutput.class, PredictionWorkflowOutputMixIn.class);
        mapper.addMixIn(PredictionWorkflowOutput.PredictionWorkflowOutputBuilder.class, PredictionWorkflowOutputMixIn.PredictionWorkflowOutputMixInBuilder.class);
        mapper.addMixIn(Product.class, ProductMixIn.class);
        mapper.addMixIn(Product.ProductBuilder.class, ProductMixIn.ProductMixInBuilder.class);
        mapper.addMixIn(SOP.class, SOPMixIn.class);
        mapper.addMixIn(SOP.SOPBuilder.class, SOPMixIn.SOPMixInBuilder.class);
        mapper.addMixIn(Tag.class, TagMixIn.class);
        mapper.addMixIn(Tag.TagBuilder.class, TagMixIn.TagMixInBuilder.class);
        mapper.addMixIn(TrainingJob.class, TrainingJobMixIn.class);
        mapper.addMixIn(TrainingJob.TrainingJobBuilder.class, TrainingJobMixIn.TrainingJobMixInBuilder.class);
        mapper.addMixIn(Workflow.class, WorkflowMixIn.class);
        mapper.addMixIn(Workflow.WorkflowBuilder.class, WorkflowMixIn.WorkflowMixInBuilder.class);
        mapper.addMixIn(WorkflowParameter.class, WorkflowParameterMixIn.class);
        mapper.addMixIn(WorkflowParameter.WorkflowParameterBuilder.class, WorkflowParameterMixIn.WorkflowParameterMixInBuilder.class);
    	
    }
}
