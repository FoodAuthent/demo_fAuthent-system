/*
 * TODO	
 */
package org.foodauthent.api;

import org.foodauthent.model.ObjectEvent;
import org.foodauthent.model.Prediction;
import org.foodauthent.model.PredictionJob;
import org.foodauthent.model.PredictionJobPageResult;
import org.foodauthent.model.PredictionPageResult;
import org.foodauthent.model.PublishMetadata;
import org.foodauthent.model.TrainingJob;
import org.foodauthent.model.TrainingJobPageResult;
import org.foodauthent.model.Workflow;
import org.foodauthent.model.WorkflowPageResult;

import org.foodauthent.common.exception.FAExceptions;

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
     * @param async Whether to run the workflow asynchronously
     *
     * @return the result
     * @throws InitJobException Exception thrown when a job could not be initialized.
     */
    PredictionJob createPredictionJob(java.util.UUID workflowId, java.util.UUID fingerprintsetId, java.util.UUID modelId, Boolean async) throws FAExceptions.InitJobException;
        
    /**
     * 
     *
     * @param workflowId TODO
     * @param fingerprintsetIds One or more fingerprintset-ids referencing the fingerprint sets to learn the model on. Each fingerprintset represents one class! 
     * @param async Whether to run the workflow asynchronously
     *
     * @return the result
     * @throws InitJobException Exception thrown when a job could not be initialized.
     */
    TrainingJob createTrainingJob(java.util.UUID workflowId, java.util.List<java.util.UUID> fingerprintsetIds, Boolean async) throws FAExceptions.InitJobException;
        
    /**
     * Creates/adds a new workflow.
     *
     * @param workflow TODO
     *
     * @return the result
     */
    java.util.UUID createWorkflow(Workflow workflow);
        
    /**
     * Muliple keywords can be provided with comma separated strings, e.g. keyword1, keyword2.
     *
     * @param pageNumber the page number starting at 1
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     *
     * @return the result
     */
    PredictionPageResult findPredictionByKeyword(Integer pageNumber, Integer pageSize, java.util.List<String> keywords);
        
    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param pageNumber the page number starting at 1
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     *
     * @return the result
     */
    PredictionJobPageResult findPredictionJobs(Integer pageNumber, Integer pageSize, java.util.List<String> keywords);
        
    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param pageNumber the page number starting at 1
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     *
     * @return the result
     */
    WorkflowPageResult findPredictionWorkflows(Integer pageNumber, Integer pageSize, java.util.List<String> keywords);
        
    /**
     * get predictions (filtered by keywords) for a specific fingerprint set
     *
     * @param fingerprintsetId 
     * @param pageNumber the page number starting at 1
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     *
     * @return the result
     */
    PredictionPageResult findPredictionsByFingerprintSetId(java.util.UUID fingerprintsetId, Integer pageNumber, Integer pageSize, java.util.List<String> keywords);
        
    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param pageNumber the page number starting at 1
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     *
     * @return the result
     */
    TrainingJobPageResult findTrainingJobs(Integer pageNumber, Integer pageSize, java.util.List<String> keywords);
        
    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param pageNumber the page number starting at 1
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     *
     * @return the result
     */
    WorkflowPageResult findTrainingWorkflows(Integer pageNumber, Integer pageSize, java.util.List<String> keywords);
        
    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param pageNumber the page number starting at 1
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     *
     * @return the result
     */
    WorkflowPageResult findWorkflowByKeyword(Integer pageNumber, Integer pageSize, java.util.List<String> keywords);
        
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
        
    /**
     * 
     *
     * @param predictionId TODO
     * @param sellable TODO
     * @param publishMetadata TODO
     *
     * @return the result
     */
    ObjectEvent publishPredictionResult(java.util.UUID predictionId, Boolean sellable, PublishMetadata publishMetadata);
        
}
