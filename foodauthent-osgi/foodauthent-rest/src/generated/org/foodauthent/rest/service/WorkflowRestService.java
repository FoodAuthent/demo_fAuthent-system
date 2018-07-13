/*
 * TODO	
 */
package org.foodauthent.rest.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import java.io.File;
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
	  	try {
	   		return Response.ok(res).build();
	   	} catch(Exception e) {
	   		//TODO
	   		e.printStackTrace();
	   		throw e;
	   	}
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
	  	try {
	   		return Response.ok(res).build();
	   	} catch(Exception e) {
	   		//TODO
	   		e.printStackTrace();
	   		throw e;
	   	}
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
	  	try {
	   		return Response.ok(res).build();
	   	} catch(Exception e) {
	   		//TODO
	   		e.printStackTrace();
	   		throw e;
	   	}
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
	  	try {
	   		return Response.ok(res).build();
	   	} catch(Exception e) {
	   		//TODO
	   		e.printStackTrace();
	   		throw e;
	   	}
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
	  	try {
	   		return Response.ok(res).build();
	   	} catch(Exception e) {
	   		//TODO
	   		e.printStackTrace();
	   		throw e;
	   	}
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
	  	try {
	   		return Response.ok(res).build();
	   	} catch(Exception e) {
	   		//TODO
	   		e.printStackTrace();
	   		throw e;
	   	}
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
	  	try {
	   		return Response.ok(res).build();
	   	} catch(Exception e) {
	   		//TODO
	   		e.printStackTrace();
	   		throw e;
	   	}
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
	  	try {
	   		return Response.ok(res).build();
	   	} catch(Exception e) {
	   		//TODO
	   		e.printStackTrace();
	   		throw e;
	   	}
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
	  	try {
	   		return Response.ok(res).build();
	   	} catch(Exception e) {
	   		//TODO
	   		e.printStackTrace();
	   		throw e;
	   	}
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
	  	try {
	   		return Response.ok(res).build();
	   	} catch(Exception e) {
	   		//TODO
	   		e.printStackTrace();
	   		throw e;
	   	}
    }
}

