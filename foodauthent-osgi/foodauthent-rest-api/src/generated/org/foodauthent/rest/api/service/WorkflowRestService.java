/*
 * TODO	
 */
package org.foodauthent.rest.api.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import org.foodauthent.auth.security.SecurityScheme;

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
     * @param async Whether to run the workflow asynchronously
     * @return the response
     */
    @POST
    @Path("/workflow/prediction/job")
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
    @Produces({ "application/json" })
    public Response createPredictionJob(@QueryParam("workflow-id")java.util.UUID workflowId
, @QueryParam("fingerprintset-id")java.util.UUID fingerprintsetId
, @QueryParam("model-id")java.util.UUID modelId
, @QueryParam("async")Boolean async
);

    /**
     *
     * @param workflowId TODO
     * @param fingerprintsetIds One or more fingerprintset-ids referencing the fingerprint sets to learn the model on. Each fingerprintset represents one class! 
     * @param async Whether to run the workflow asynchronously
     * @return the response
     */
    @POST
    @Path("/workflow/training/job")
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
    @Produces({ "application/json" })
    public Response createTrainingJob(@QueryParam("workflow-id")java.util.UUID workflowId
, @QueryParam("fingerprintset-ids")java.util.List<java.util.UUID> fingerprintsetIds
, @QueryParam("async")Boolean async
);

    /**
     * Creates/adds a new workflow.
     *
     * @param workflow TODO
     * @return the response
     */
    @POST
    @Path("/workflow")
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public Response createWorkflow(Workflow workflow
);

    /**
     * Muliple keywords can be provided with comma separated strings, e.g. keyword1, keyword2.
     *
     * @param pageNumber the page number starting at 1
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     * @return the response
     */
    @GET
    @Path("/prediction")
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
    @Produces({ "application/json" })
    public Response findPredictionByKeyword(@QueryParam("pageNumber")Integer pageNumber
, @QueryParam("pageSize")Integer pageSize
, @QueryParam("keywords")java.util.List<String> keywords
);

    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param pageNumber the page number starting at 1
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     * @return the response
     */
    @GET
    @Path("/workflow/prediction/job")
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
    @Produces({ "application/json" })
    public Response findPredictionJobs(@QueryParam("pageNumber")Integer pageNumber
, @QueryParam("pageSize")Integer pageSize
, @QueryParam("keywords")java.util.List<String> keywords
);

    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param pageNumber the page number starting at 1
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     * @return the response
     */
    @GET
    @Path("/workflow/prediction")
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
    @Produces({ "application/json" })
    public Response findPredictionWorkflows(@QueryParam("pageNumber")Integer pageNumber
, @QueryParam("pageSize")Integer pageSize
, @QueryParam("keywords")java.util.List<String> keywords
);

    /**
     * get predictions (filtered by keywords) for a specific fingerprint set
     *
     * @param fingerprintsetId 
     * @param pageNumber the page number starting at 1
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     * @return the response
     */
    @GET
    @Path("/prediction/relation/{fingerprintset-id}")
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
    @Produces({ "application/json" })
    public Response findPredictionsByFingerprintSetId(@PathParam("fingerprintset-id") java.util.UUID fingerprintsetId
, @QueryParam("pageNumber")Integer pageNumber
, @QueryParam("pageSize")Integer pageSize
, @QueryParam("keywords")java.util.List<String> keywords
);

    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param pageNumber the page number starting at 1
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     * @return the response
     */
    @GET
    @Path("/workflow/training/job")
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
    @Produces({ "application/json" })
    public Response findTrainingJobs(@QueryParam("pageNumber")Integer pageNumber
, @QueryParam("pageSize")Integer pageSize
, @QueryParam("keywords")java.util.List<String> keywords
);

    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param pageNumber the page number starting at 1
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     * @return the response
     */
    @GET
    @Path("/workflow/training")
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
    @Produces({ "application/json" })
    public Response findTrainingWorkflows(@QueryParam("pageNumber")Integer pageNumber
, @QueryParam("pageSize")Integer pageSize
, @QueryParam("keywords")java.util.List<String> keywords
);

    /**
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param pageNumber the page number starting at 1
     * @param pageSize entries per page, minimum 1
     * @param keywords Keywords to search for
     * @return the response
     */
    @GET
    @Path("/workflow")
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
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
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
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
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
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
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
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
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
    @Produces({ "application/json" })
    public Response getWorkflowById(@PathParam("workflow-id") java.util.UUID workflowId
);

    /**
     *
     * @param predictionId TODO
     * @param sellable TODO
     * @param publishMetadata TODO
     * @return the response
     */
    @POST
    @Path("/prediction/{prediction-id}/publish")
	@SecurityScheme({ "apiKeyId", "apiKeySecret", "jwtAuth" })
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public Response publishPredictionResult(@PathParam("prediction-id") java.util.UUID predictionId
, @QueryParam("sellable")Boolean sellable
, PublishMetadata publishMetadata
);
}

