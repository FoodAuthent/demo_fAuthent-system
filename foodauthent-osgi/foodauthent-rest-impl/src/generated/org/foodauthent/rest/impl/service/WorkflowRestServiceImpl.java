/*
 * TODO	
 */
package org.foodauthent.rest.impl.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

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
@Component(service = WorkflowRestService.class, immediate = true)
public class WorkflowRestServiceImpl implements WorkflowRestService {

	@Reference(cardinality = ReferenceCardinality.MANDATORY)
    private WorkflowService service;


    /**
     *
     * @param workflowId TODO
     * @param fingerprintsetId TODO
     * @param modelId The model to be used for prediction. Needs to be compatible with the selected workflow!!
     * @param objecteventIds One or more objectevent-ids 
     * @param async Whether to run the workflow asynchronously
     * @return the response
     */
    public Response createPredictionJob(java.util.UUID workflowId, java.util.UUID fingerprintsetId, java.util.UUID modelId, java.util.List<java.util.UUID> objecteventIds, Boolean async) {
        try { 
            Object res = service.createPredictionJob(workflowId, fingerprintsetId, modelId, objecteventIds, async);
            return Response.ok(res).build();
         } 
        catch(FAExceptions.InitJobException e) {
           return Response.status(500).entity(e.getMessage()).build();
        }
    }

    /**
     *
     * @param workflowId TODO
     * @param fingerprintsetIds One or more fingerprintset-ids referencing the fingerprint sets to learn the model on. Each fingerprintset represents one class! 
     * @param async Whether to run the workflow asynchronously
     * @return the response
     */
    public Response createTrainingJob(java.util.UUID workflowId, java.util.List<java.util.UUID> fingerprintsetIds, Boolean async) {
        try { 
            Object res = service.createTrainingJob(workflowId, fingerprintsetIds, async);
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
     * Muliple keywords can be provided with comma separated strings, e.g. keyword1, keyword2.
     *
     * @param pageNumber the page number starting at 1
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     * @return the response
     */
    public Response findPredictionByKeyword(Integer pageNumber, Integer pageSize, java.util.List<String> keywords) {
        
            Object res = service.findPredictionByKeyword(pageNumber, pageSize, keywords);
            return Response.ok(res).build();
    }

    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param pageNumber the page number starting at 1
     * @param pageSize entries per page, minimum 1
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
     * @param pageNumber the page number starting at 1
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     * @return the response
     */
    public Response findPredictionWorkflows(Integer pageNumber, Integer pageSize, java.util.List<String> keywords) {
        
            Object res = service.findPredictionWorkflows(pageNumber, pageSize, keywords);
            return Response.ok(res).build();
    }

    /**
     * get predictions (filtered by keywords) for a specific fingerprint set
     *
     * @param fingerprintsetId 
     * @param pageNumber the page number starting at 1
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     * @return the response
     */
    public Response findPredictionsByFingerprintSetId(java.util.UUID fingerprintsetId, Integer pageNumber, Integer pageSize, java.util.List<String> keywords) {
        
            Object res = service.findPredictionsByFingerprintSetId(fingerprintsetId, pageNumber, pageSize, keywords);
            return Response.ok(res).build();
    }

    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param pageNumber the page number starting at 1
     * @param pageSize entries per page, minimum 1
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
     * @param pageNumber the page number starting at 1
     * @param pageSize entries per page, minimum 1
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
     * @param pageNumber the page number starting at 1
     * @param pageSize entries per page, minimum 1
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

    /**
     *
     * @param predictionId TODO
     * @param sellable TODO
     * @param publishMetadata TODO
     * @return the response
     */
    public Response publishPredictionResult(java.util.UUID predictionId, Boolean sellable, PublishMetadata publishMetadata) {
        
            Object res = service.publishPredictionResult(predictionId, sellable, publishMetadata);
            return Response.ok(res).build();
    }
}

