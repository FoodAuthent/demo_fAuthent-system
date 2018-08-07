/*
 * TODO	
 */
package org.foodauthent.rest.impl.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.foodauthent.model.Prediction;
import org.foodauthent.model.PredictionJob;
import org.foodauthent.model.PredictionJobPageResult;
import org.foodauthent.model.PredictionPageResult;
import org.foodauthent.model.TrainingJob;
import org.foodauthent.model.TrainingJobPageResult;
import org.foodauthent.model.Workflow;
import org.foodauthent.model.WorkflowPageResult;

import org.foodauthent.api.WorkflowService;
import org.foodauthent.api.ServiceRegistry;

import org.foodauthent.rest.api.service.WorkflowRestService;

import org.foodauthent.common.exception.FAExceptions;

/**
 * FoodAuthent Swagger API
 *
 * <p>This is the FoodAuthent API Description [www.foodauthent.net]
 *
 * <p> 
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class WorkflowRestServiceImpl implements WorkflowRestService {

    private final WorkflowService service = ServiceRegistry.get(WorkflowService.class);


    /**
     *
     * @param workflowId TODO
     * @param fingerprintsetId TODO
     * @param modelId The model to be used for prediction. Needs to be compatible with the selected workflow!!
     * @return the response
     */
    public Response createPredictionJob(java.util.UUID workflowId, java.util.UUID fingerprintsetId, java.util.UUID modelId) {
        try { 
            Object res = service.createPredictionJob(workflowId, fingerprintsetId, modelId);
            return Response.ok(res).build();
         } 
        catch(FAExceptions.InitJobException e) {
           return Response.status(500).entity(e.getMessage()).build();
        }
    }

    /**
     *
     * @param workflowId TODO
     * @param fingerprintsetId TODO
     * @return the response
     */
    public Response createTrainingJob(java.util.UUID workflowId, java.util.UUID fingerprintsetId) {
        try { 
            Object res = service.createTrainingJob(workflowId, fingerprintsetId);
            return Response.ok(res).build();
         } 
        catch(FAExceptions.InitJobException e) {
           return Response.status(500).entity(e.getMessage()).build();
        }
    }

    /**
     * Creates/adds a new workflow.
     *
     * @param workflow TODO
     * @return the response
     */
    public Response createWorkflow(Workflow workflow) {
        
            Object res = service.createWorkflow(workflow);
            return Response.ok(res).build();
    }

    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param pageNumber 
     * @param pageSize 
     * @param keywords Keywords to search for
     * @return the response
     */
    public Response findModelByKeyword(Integer pageNumber, Integer pageSize, java.util.List<String> keywords) {
        
            Object res = service.findModelByKeyword(pageNumber, pageSize, keywords);
            return Response.ok(res).build();
    }

    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param pageNumber 
     * @param pageSize 
     * @param keywords Keywords to search for
     * @return the response
     */
    public Response findPredictionJobs(Integer pageNumber, Integer pageSize, java.util.List<String> keywords) {
        
            Object res = service.findPredictionJobs(pageNumber, pageSize, keywords);
            return Response.ok(res).build();
    }

    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param pageNumber 
     * @param pageSize 
     * @param keywords Keywords to search for
     * @return the response
     */
    public Response findPredictionWorkflows(Integer pageNumber, Integer pageSize, java.util.List<String> keywords) {
        
            Object res = service.findPredictionWorkflows(pageNumber, pageSize, keywords);
            return Response.ok(res).build();
    }

    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param pageNumber 
     * @param pageSize 
     * @param keywords Keywords to search for
     * @return the response
     */
    public Response findTrainingJobs(Integer pageNumber, Integer pageSize, java.util.List<String> keywords) {
        
            Object res = service.findTrainingJobs(pageNumber, pageSize, keywords);
            return Response.ok(res).build();
    }

    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param pageNumber 
     * @param pageSize 
     * @param keywords Keywords to search for
     * @return the response
     */
    public Response findTrainingWorkflows(Integer pageNumber, Integer pageSize, java.util.List<String> keywords) {
        
            Object res = service.findTrainingWorkflows(pageNumber, pageSize, keywords);
            return Response.ok(res).build();
    }

    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param pageNumber 
     * @param pageSize 
     * @param keywords Keywords to search for
     * @return the response
     */
    public Response findWorkflowByKeyword(Integer pageNumber, Integer pageSize, java.util.List<String> keywords) {
        
            Object res = service.findWorkflowByKeyword(pageNumber, pageSize, keywords);
            return Response.ok(res).build();
    }

    /**
     *
     * @param jobId TODO
     * @return the response
     */
    public Response getPredictionJob(java.util.UUID jobId) {
        
            Object res = service.getPredictionJob(jobId);
            return Response.ok(res).build();
    }

    /**
     *
     * @param predictionId TODO
     * @return the response
     */
    public Response getPredictionResult(java.util.UUID predictionId) {
        
            Object res = service.getPredictionResult(predictionId);
            return Response.ok(res).build();
    }

    /**
     *
     * @param jobId TODO
     * @return the response
     */
    public Response getTrainingJob(java.util.UUID jobId) {
        
            Object res = service.getTrainingJob(jobId);
            return Response.ok(res).build();
    }

    /**
     * TODO
     *
     * @param workflowId 
     * @return the response
     */
    public Response getWorkflowById(java.util.UUID workflowId) {
        
            Object res = service.getWorkflowById(workflowId);
            return Response.ok(res).build();
    }
}

