/*
 * TODO	
 */
package org.foodauthent.api;

import org.foodauthent.model.Prediction;
import org.foodauthent.model.PredictionJob;
import org.foodauthent.model.TrainingJob;
import org.foodauthent.model.Workflow;

/**
 * 
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface WorkflowService {

    /**
     * 
     *
     * @param workflowId TODO
     * @param fingerprintsetId TODO
     * @param modelId The model to be used for prediction. Needs to be compatible with the selected workflow!!
     *
     * @return the result
     */
    PredictionJob createPredictionJob(java.util.UUID workflowId, java.util.UUID fingerprintsetId, java.util.UUID modelId);
        
    /**
     * 
     *
     * @param workflowId TODO
     * @param fingerprintsetId TODO
     *
     * @return the result
     */
    TrainingJob createTrainingJob(java.util.UUID workflowId, java.util.UUID fingerprintsetId);
        
    /**
     * Creates/adds a new workflow.
     *
     * @param workflow TODO
     *
     * @return the result
     */
    java.util.UUID createWorkflow(Workflow workflow);
        
    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param keywords Keywords to search for
     *
     * @return the result
     */
    java.util.List<java.util.UUID> findPredictionWorkflows(java.util.List<String> keywords);
        
    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param keywords Keywords to search for
     *
     * @return the result
     */
    java.util.List<java.util.UUID> findTrainingWorkflows(java.util.List<String> keywords);
        
    /**
     * 
     *
     * @param jobId TODO
     *
     * @return the result
     */
    PredictionJob getPredictionJob(java.util.UUID jobId);
        
    /**
     * 
     *
     * @param predictionId TODO
     *
     * @return the result
     */
    Prediction getPredictionResult(java.util.UUID predictionId);
        
    /**
     * 
     *
     * @param jobId TODO
     *
     * @return the result
     */
    TrainingJob getTrainingJob(java.util.UUID jobId);
        
    /**
     * TODO
     *
     * @param workflowId 
     *
     * @return the result
     */
    Workflow getWorkflowById(java.util.UUID workflowId);
        
}
