/*
 * TODO	
 */
package org.foodauthent.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.foodauthent.api.ServiceRegistry;
import org.foodauthent.api.WorkflowService;
import org.foodauthent.model.Workflow;

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
     * @param fingerprintsetId TODO
     * @return the response
     */
    @POST
    @Path("/workflow/prediction/job")
    @Produces({ "application/json" })
    public Response createPredictionJob(@QueryParam("workflow-id")java.util.UUID workflowId
, @QueryParam("fingerprintset-id")java.util.UUID fingerprintsetId
) {
	    Object res = service.createPredictionJob(workflowId, fingerprintsetId);    
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
    public Response createTrainingJob(@QueryParam("workflow-id")java.util.UUID workflowId
, @QueryParam("fingerprintset-id")java.util.UUID fingerprintsetId
) {
	    Object res = service.createTrainingJob(workflowId, fingerprintsetId);    
	   	return Response.ok(res).build();
    }

    /**
     * Creates/adds a new workflow.
     *
     * @param workflow TODO
     * @return the response
     */
    @POST
    @Path("/workflow")
    @Consumes({ "application/json" })
    public Response createWorkflow(Workflow workflow
) {
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
    public Response findPredictionWorkflows(@QueryParam("keywords")java.util.List<String> keywords
) {
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
    public Response findTrainingWorkflows(@QueryParam("keywords")java.util.List<String> keywords
) {
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
    public Response getPredictionJob(@PathParam("job-id") java.util.UUID jobId
) {
	    Object res = service.getPredictionJob(jobId);    
	   	return Response.ok(res).build();
    }

    /**
     *
     * @param predictionId TODO
     * @return the response
     */
    @GET
    @Path("/prediction/{prediction-id}")
    public Response getPredictionResult(@PathParam("prediction-id") java.util.UUID predictionId
) {
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
    public Response getTrainingJob(@PathParam("job-id") java.util.UUID jobId
) {
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
    public Response getWorkflowById(@PathParam("workflow-id") java.util.UUID workflowId
) {
	    Object res = service.getWorkflowById(workflowId);    
	   	return Response.ok(res).build();
    }

    /**
     * Uplloads the workflow file associated with the workflow of the given workflow-id. Upon upload, the workflow will be validated in order to make sure that it complies with the respective workflow inputs and outputs (as determined by the workflow&#39;s type parameter)
     *
     * @param workflowId 
     * @param upfile The file to upload.
     * @return the response
     */
    @PUT
    @Path("/workflow/{workflow-id}/file")
    @Consumes({ "multipart/form-data" })
    public Response saveWorkflowFile(@PathParam("workflow-id") java.util.UUID workflowId
, 
            @org.glassfish.jersey.media.multipart.FormDataParam("upfile") java.io.InputStream upfile,
            @org.glassfish.jersey.media.multipart.FormDataParam("upfile") org.glassfish.jersey.media.multipart.FormDataContentDisposition upfileDetail
) {
	    Object res = service.saveWorkflowFile(workflowId, upfile, upfileDetail);    
	   	return Response.ok(res).build();
    }
}

