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
    
        mapper.addMixIn(FileMetadata.class, FileMetadataMixIn.class);
        mapper.addMixIn(FileMetadata.FileMetadataBuilder.class, FileMetadataMixIn.FileMetadataMixInBuilder.class);
        mapper.addMixIn(Fingerprint.class, FingerprintMixIn.class);
        mapper.addMixIn(Fingerprint.FingerprintBuilder.class, FingerprintMixIn.FingerprintMixInBuilder.class);
        mapper.addMixIn(FingerprintSet.class, FingerprintSetMixIn.class);
        mapper.addMixIn(FingerprintSet.FingerprintSetBuilder.class, FingerprintSetMixIn.FingerprintSetMixInBuilder.class);
        mapper.addMixIn(FingerprintSetPageResult.class, FingerprintSetPageResultMixIn.class);
        mapper.addMixIn(FingerprintSetPageResult.FingerprintSetPageResultBuilder.class, FingerprintSetPageResultMixIn.FingerprintSetPageResultMixInBuilder.class);
        mapper.addMixIn(Model.class, ModelMixIn.class);
        mapper.addMixIn(Model.ModelBuilder.class, ModelMixIn.ModelMixInBuilder.class);
        mapper.addMixIn(ModelPageResult.class, ModelPageResultMixIn.class);
        mapper.addMixIn(ModelPageResult.ModelPageResultBuilder.class, ModelPageResultMixIn.ModelPageResultMixInBuilder.class);
        mapper.addMixIn(PredictionJob.class, PredictionJobMixIn.class);
        mapper.addMixIn(PredictionJob.PredictionJobBuilder.class, PredictionJobMixIn.PredictionJobMixInBuilder.class);
        mapper.addMixIn(PredictionJobPageResult.class, PredictionJobPageResultMixIn.class);
        mapper.addMixIn(PredictionJobPageResult.PredictionJobPageResultBuilder.class, PredictionJobPageResultMixIn.PredictionJobPageResultMixInBuilder.class);
        mapper.addMixIn(Prediction.class, PredictionMixIn.class);
        mapper.addMixIn(Prediction.PredictionBuilder.class, PredictionMixIn.PredictionMixInBuilder.class);
        mapper.addMixIn(PredictionPageResult.class, PredictionPageResultMixIn.class);
        mapper.addMixIn(PredictionPageResult.PredictionPageResultBuilder.class, PredictionPageResultMixIn.PredictionPageResultMixInBuilder.class);
        mapper.addMixIn(PredictionWorkflowInput.class, PredictionWorkflowInputMixIn.class);
        mapper.addMixIn(PredictionWorkflowInput.PredictionWorkflowInputBuilder.class, PredictionWorkflowInputMixIn.PredictionWorkflowInputMixInBuilder.class);
        mapper.addMixIn(PredictionWorkflowOutput.class, PredictionWorkflowOutputMixIn.class);
        mapper.addMixIn(PredictionWorkflowOutput.PredictionWorkflowOutputBuilder.class, PredictionWorkflowOutputMixIn.PredictionWorkflowOutputMixInBuilder.class);
        mapper.addMixIn(Product.class, ProductMixIn.class);
        mapper.addMixIn(Product.ProductBuilder.class, ProductMixIn.ProductMixInBuilder.class);
        mapper.addMixIn(ProductPageResult.class, ProductPageResultMixIn.class);
        mapper.addMixIn(ProductPageResult.ProductPageResultBuilder.class, ProductPageResultMixIn.ProductPageResultMixInBuilder.class);
        mapper.addMixIn(SOP.class, SOPMixIn.class);
        mapper.addMixIn(SOP.SOPBuilder.class, SOPMixIn.SOPMixInBuilder.class);
        mapper.addMixIn(SOPPageResult.class, SOPPageResultMixIn.class);
        mapper.addMixIn(SOPPageResult.SOPPageResultBuilder.class, SOPPageResultMixIn.SOPPageResultMixInBuilder.class);
        mapper.addMixIn(Tag.class, TagMixIn.class);
        mapper.addMixIn(Tag.TagBuilder.class, TagMixIn.TagMixInBuilder.class);
        mapper.addMixIn(TagPageResult.class, TagPageResultMixIn.class);
        mapper.addMixIn(TagPageResult.TagPageResultBuilder.class, TagPageResultMixIn.TagPageResultMixInBuilder.class);
        mapper.addMixIn(TrainingJob.class, TrainingJobMixIn.class);
        mapper.addMixIn(TrainingJob.TrainingJobBuilder.class, TrainingJobMixIn.TrainingJobMixInBuilder.class);
        mapper.addMixIn(TrainingJobPageResult.class, TrainingJobPageResultMixIn.class);
        mapper.addMixIn(TrainingJobPageResult.TrainingJobPageResultBuilder.class, TrainingJobPageResultMixIn.TrainingJobPageResultMixInBuilder.class);
        mapper.addMixIn(TrainingWorkflowInput.class, TrainingWorkflowInputMixIn.class);
        mapper.addMixIn(TrainingWorkflowInput.TrainingWorkflowInputBuilder.class, TrainingWorkflowInputMixIn.TrainingWorkflowInputMixInBuilder.class);
        mapper.addMixIn(TrainingWorkflowOutput.class, TrainingWorkflowOutputMixIn.class);
        mapper.addMixIn(TrainingWorkflowOutput.TrainingWorkflowOutputBuilder.class, TrainingWorkflowOutputMixIn.TrainingWorkflowOutputMixInBuilder.class);
        mapper.addMixIn(Workflow.class, WorkflowMixIn.class);
        mapper.addMixIn(Workflow.WorkflowBuilder.class, WorkflowMixIn.WorkflowMixInBuilder.class);
        mapper.addMixIn(WorkflowPageResult.class, WorkflowPageResultMixIn.class);
        mapper.addMixIn(WorkflowPageResult.WorkflowPageResultBuilder.class, WorkflowPageResultMixIn.WorkflowPageResultMixInBuilder.class);
        mapper.addMixIn(WorkflowParameter.class, WorkflowParameterMixIn.class);
        mapper.addMixIn(WorkflowParameter.WorkflowParameterBuilder.class, WorkflowParameterMixIn.WorkflowParameterMixInBuilder.class);
    	
    }
}
