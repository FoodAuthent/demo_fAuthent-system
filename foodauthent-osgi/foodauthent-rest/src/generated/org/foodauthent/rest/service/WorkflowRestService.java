/*
 * TODO	
 */
package org.foodauthent.rest.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.foodauthent.model.Prediction;
import org.foodauthent.model.PredictionJob;
import org.foodauthent.model.TrainingJob;
import org.foodauthent.model.Workflow;

import org.foodauthent.api.WorkflowService;
import org.foodauthent.api.ServiceRegistry;

/**
 * FoodAuthent Swagger API
 *
 * <p>This is the FoodAuthent API Description [www.foodauthent.net]
 *
 * <p> 
 *
 * @author Martin Horn, University of Konstanz
 */
@Path("/v0/foodauthent")
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class WorkflowRestService{

	private final WorkflowService service = ServiceRegistry.get(WorkflowService.class);


    /**
     *
     * @param workflowId TODO
     * @param fingerprintId TODO
     * @return the response
     */
    @POST
    @Path("/workflow/prediction/job")
    @Produces({ "application/json" })
    public Response createPredictionJob(@QueryParam("workflow-id")java.util.UUID workflowId, @QueryParam("fingerprint-id")java.util.UUID fingerprintId) {
	    Object res = service.createPredictionJob(workflowId, fingerprintId);    
	   	return Response.ok(res).build();
    }

    /**
     *
     * @param workflowId TODO
     * @param fingerprintsetId TODO
     * @return the response
     */
    @POST
    @Path("/workflow/training/job")
    @Produces({ "application/json" })
    public Response createTrainingJob(@QueryParam("workflow-id")java.util.UUID workflowId, @QueryParam("fingerprintset-id")java.util.UUID fingerprintsetId) {
	    Object res = service.createTrainingJob(workflowId, fingerprintsetId);    
	   	return Response.ok(res).build();
    }

    /**
     * TODO
     *
     * @param workflow TODO
     * @return the response
     */
    @POST
    @Path("/workflow")
    @Consumes({ "application/json" })
    public Response createWorkflow(Workflow workflow) {
	    Object res = service.createWorkflow(workflow);    
	   	return Response.ok(res).build();
    }

    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param keywords Keywords to search for
     * @return the response
     */
    @GET
    @Path("/workflow/prediction")
    @Produces({ "application/json" })
    public Response findPredictionWorkflows(@QueryParam("keywords")java.util.List<String> keywords) {
	    Object res = service.findPredictionWorkflows(keywords);    
	   	return Response.ok(res).build();
    }

    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param keywords Keywords to search for
     * @return the response
     */
    @GET
    @Path("/workflow/training")
    @Produces({ "application/json" })
    public Response findTrainingWorkflows(@QueryParam("keywords")java.util.List<String> keywords) {
	    Object res = service.findTrainingWorkflows(keywords);    
	   	return Response.ok(res).build();
    }

    /**
     *
     * @param jobId TODO
     * @return the response
     */
    @GET
    @Path("/workflow/prediction/job/{job-id}")
    @Produces({ "application/json" })
    public Response getPredictionJob(@PathParam("job-id") java.util.UUID jobId) {
	    Object res = service.getPredictionJob(jobId);    
	   	return Response.ok(res).build();
    }

    /**
     *
     * @param predictionId TODO
     * @return the response
     */
    @GET
    @Path("/prediction")
    public Response getPredictionResult(@QueryParam("prediction-id")java.util.UUID predictionId) {
	    Object res = service.getPredictionResult(predictionId);    
	   	return Response.ok(res).build();
    }

    /**
     *
     * @param jobId TODO
     * @return the response
     */
    @GET
    @Path("/workflow/training/job/{job-id}")
    @Produces({ "application/json" })
    public Response getTrainingJob(@PathParam("job-id") java.util.UUID jobId) {
	    Object res = service.getTrainingJob(jobId);    
	   	return Response.ok(res).build();
    }

    /**
     * TODO
     *
     * @param workflowId 
     * @return the response
     */
    @GET
    @Path("/workflow/{workflow-id}")
    @Produces({ "application/json" })
    public Response getWorkflowById(@PathParam("workflow-id") java.util.UUID workflowId) {
	    Object res = service.getWorkflowById(workflowId);    
	   	return Response.ok(res).build();
    }
}

