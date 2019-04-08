/*
 * TODO	
 */
package org.foodauthent.rest.api.service;

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
@Path("/v0/foodauthent")
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface WorkflowRestService{


    /**
     *
     * @param workflowId TODO
     * @param fingerprintsetId TODO
     * @param modelId The model to be used for prediction. Needs to be compatible with the selected workflow!!
     * @return the response
     */
    @POST
    @Path("/workflow/prediction/job")
    @Produces({ "application/json" })
    public Response createPredictionJob(@QueryParam("workflow-id")java.util.UUID workflowId
, @QueryParam("fingerprintset-id")java.util.UUID fingerprintsetId
, @QueryParam("model-id")java.util.UUID modelId
);

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
);

    /**
     * Creates/adds a new workflow.
     *
     * @param workflow TODO
     * @return the response
     */
    @POST
    @Path("/workflow")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public Response createWorkflow(Workflow workflow
);

    /**
     * Muliple keywords can be provided with comma separated strings, e.g. keyword1, keyword2.
     *
     * @param pageNumber the page number starting at 0
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     * @return the response
     */
    @GET
    @Path("/prediction")
    @Produces({ "application/json" })
    public Response findModelByKeyword(@QueryParam("pageNumber")Integer pageNumber
, @QueryParam("pageSize")Integer pageSize
, @QueryParam("keywords")java.util.List<String> keywords
);

    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param pageNumber the page number starting at 0
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     * @return the response
     */
    @GET
    @Path("/workflow/prediction/job")
    @Produces({ "application/json" })
    public Response findPredictionJobs(@QueryParam("pageNumber")Integer pageNumber
, @QueryParam("pageSize")Integer pageSize
, @QueryParam("keywords")java.util.List<String> keywords
);

    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param pageNumber the page number starting at 0
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     * @return the response
     */
    @GET
    @Path("/workflow/prediction")
    @Produces({ "application/json" })
    public Response findPredictionWorkflows(@QueryParam("pageNumber")Integer pageNumber
, @QueryParam("pageSize")Integer pageSize
, @QueryParam("keywords")java.util.List<String> keywords
);

    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param pageNumber the page number starting at 0
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     * @return the response
     */
    @GET
    @Path("/workflow/training/job")
    @Produces({ "application/json" })
    public Response findTrainingJobs(@QueryParam("pageNumber")Integer pageNumber
, @QueryParam("pageSize")Integer pageSize
, @QueryParam("keywords")java.util.List<String> keywords
);

    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param pageNumber the page number starting at 0
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     * @return the response
     */
    @GET
    @Path("/workflow/training")
    @Produces({ "application/json" })
    public Response findTrainingWorkflows(@QueryParam("pageNumber")Integer pageNumber
, @QueryParam("pageSize")Integer pageSize
, @QueryParam("keywords")java.util.List<String> keywords
);

    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param pageNumber the page number starting at 0
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     * @return the response
     */
    @GET
    @Path("/workflow")
    @Produces({ "application/json" })
    public Response findWorkflowByKeyword(@QueryParam("pageNumber")Integer pageNumber
, @QueryParam("pageSize")Integer pageSize
, @QueryParam("keywords")java.util.List<String> keywords
);

    /**
     *
     * @param jobId TODO
     * @return the response
     */
    @GET
    @Path("/workflow/prediction/job/{job-id}")
    @Produces({ "application/json" })
    public Response getPredictionJob(@PathParam("job-id") java.util.UUID jobId
);

    /**
     *
     * @param predictionId TODO
     * @return the response
     */
    @GET
    @Path("/prediction/{prediction-id}")
    @Produces({ "application/json" })
    public Response getPredictionResult(@PathParam("prediction-id") java.util.UUID predictionId
);

    /**
     *
     * @param jobId TODO
     * @return the response
     */
    @GET
    @Path("/workflow/training/job/{job-id}")
    @Produces({ "application/json" })
    public Response getTrainingJob(@PathParam("job-id") java.util.UUID jobId
);

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
);

    /**
     * Delete a workflow specified by id.
     *
     * @param workflowId 
     * @return the response
     */
    @DELETE
    @Path("/workflow/{workflow-id}")
    public Response removeWorkflowById(@PathParam("workflow-id") java.util.UUID workflowId
);
}

