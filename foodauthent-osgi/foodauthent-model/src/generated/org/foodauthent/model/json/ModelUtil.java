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
    
        mapper.addMixIn(Fingerprint.class, FingerprintMixIn.class);
        mapper.addMixIn(Fingerprint.FingerprintBuilder.class, FingerprintMixIn.FingerprintMixInBuilder.class);
        mapper.addMixIn(FingerprintSet.class, FingerprintSetMixIn.class);
        mapper.addMixIn(FingerprintSet.FingerprintSetBuilder.class, FingerprintSetMixIn.FingerprintSetMixInBuilder.class);
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
        mapper.addMixIn(WorkflowOutput.WorkflowOutputBuilder.class, WorkflowOutputMixIn.WorkflowOutputMixInBuilder.class);
    	
    }
}
