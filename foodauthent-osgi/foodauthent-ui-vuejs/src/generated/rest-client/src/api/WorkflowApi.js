/**
 * FoodAuthent Swagger API
 * This is the FoodAuthent API Description [www.foodauthent.net]
 *
 * OpenAPI spec version: 1.0.0
 * Contact: api@foodauthent.net
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 *
 * Swagger Codegen version: 3.3.3
 *
 * Do not edit the class manually.
 *
 */

(function(root, factory) {
  if (typeof define === 'function' && define.amd) {
    // AMD. Register as an anonymous module.
    define(['../ApiClient', '../model/Prediction', '../model/PredictionJob', '../model/PredictionJobPageResult', '../model/PredictionPageResult', '../model/TrainingJob', '../model/TrainingJobPageResult', '../model/Workflow', '../model/WorkflowPageResult'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'), require('../model/Prediction'), require('../model/PredictionJob'), require('../model/PredictionJobPageResult'), require('../model/PredictionPageResult'), require('../model/TrainingJob'), require('../model/TrainingJobPageResult'), require('../model/Workflow'), require('../model/WorkflowPageResult'));
  } else {
    // Browser globals (root is window)
    if (!root.FoodAuthentSwaggerApi) {
      root.FoodAuthentSwaggerApi = {};
    }
    root.FoodAuthentSwaggerApi.WorkflowApi = factory(root.FoodAuthentSwaggerApi.ApiClient, root.FoodAuthentSwaggerApi.Prediction, root.FoodAuthentSwaggerApi.PredictionJob, root.FoodAuthentSwaggerApi.PredictionJobPageResult, root.FoodAuthentSwaggerApi.PredictionPageResult, root.FoodAuthentSwaggerApi.TrainingJob, root.FoodAuthentSwaggerApi.TrainingJobPageResult, root.FoodAuthentSwaggerApi.Workflow, root.FoodAuthentSwaggerApi.WorkflowPageResult);
  }
}(this, function(ApiClient, Prediction, PredictionJob, PredictionJobPageResult, PredictionPageResult, TrainingJob, TrainingJobPageResult, Workflow, WorkflowPageResult) {
  'use strict';

  /**
   * Workflow service.
   * @module api/WorkflowApi
   * @version 1.0.0
   */

  /**
   * Constructs a new WorkflowApi. 
   * @alias module:api/WorkflowApi
   * @class
   * @param {module:ApiClient} [apiClient] Optional API client implementation to use,
   * default to {@link module:ApiClient#instance} if unspecified.
   */
  var exports = function(apiClient) {
    this.apiClient = apiClient || ApiClient.instance;


    /**
     * Callback function to receive the result of the createPredictionJob operation.
     * @callback module:api/WorkflowApi~createPredictionJobCallback
     * @param {String} error Error message, if any.
     * @param {module:model/PredictionJob} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Starts a prediction for a fingerprint.
     * @param {String} workflowId TODO
     * @param {String} fingerprintsetId TODO
     * @param {String} modelId The model to be used for prediction. Needs to be compatible with the selected workflow!!
     * @param {module:api/WorkflowApi~createPredictionJobCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/PredictionJob}
     */
    this.createPredictionJob = function(workflowId, fingerprintsetId, modelId, callback) {
      var postBody = null;

      // verify the required parameter 'workflowId' is set
      if (workflowId === undefined || workflowId === null) {
        throw new Error("Missing the required parameter 'workflowId' when calling createPredictionJob");
      }

      // verify the required parameter 'fingerprintsetId' is set
      if (fingerprintsetId === undefined || fingerprintsetId === null) {
        throw new Error("Missing the required parameter 'fingerprintsetId' when calling createPredictionJob");
      }

      // verify the required parameter 'modelId' is set
      if (modelId === undefined || modelId === null) {
        throw new Error("Missing the required parameter 'modelId' when calling createPredictionJob");
      }


      var pathParams = {
      };
      var queryParams = {
        'workflow-id': workflowId,
        'fingerprintset-id': fingerprintsetId,
        'model-id': modelId,
      };
      var collectionQueryParams = {
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = ['jwtAuth'];
      var contentTypes = [];
      var accepts = ['application/json'];
      var returnType = PredictionJob;

      return this.apiClient.callApi(
        '/workflow/prediction/job', 'POST',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the createTrainingJob operation.
     * @callback module:api/WorkflowApi~createTrainingJobCallback
     * @param {String} error Error message, if any.
     * @param {module:model/TrainingJob} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Starts creating a model for a set of fingerprints.
     * @param {String} workflowId TODO
     * @param {String} fingerprintsetId TODO
     * @param {module:api/WorkflowApi~createTrainingJobCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/TrainingJob}
     */
    this.createTrainingJob = function(workflowId, fingerprintsetId, callback) {
      var postBody = null;

      // verify the required parameter 'workflowId' is set
      if (workflowId === undefined || workflowId === null) {
        throw new Error("Missing the required parameter 'workflowId' when calling createTrainingJob");
      }

      // verify the required parameter 'fingerprintsetId' is set
      if (fingerprintsetId === undefined || fingerprintsetId === null) {
        throw new Error("Missing the required parameter 'fingerprintsetId' when calling createTrainingJob");
      }


      var pathParams = {
      };
      var queryParams = {
        'workflow-id': workflowId,
        'fingerprintset-id': fingerprintsetId,
      };
      var collectionQueryParams = {
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = ['jwtAuth'];
      var contentTypes = [];
      var accepts = ['application/json'];
      var returnType = TrainingJob;

      return this.apiClient.callApi(
        '/workflow/training/job', 'POST',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the createWorkflow operation.
     * @callback module:api/WorkflowApi~createWorkflowCallback
     * @param {String} error Error message, if any.
     * @param {String} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Creates/adds a new workflow.
     * Creates/adds a new workflow.
     * @param {Object} opts Optional parameters
     * @param {module:model/Workflow} opts.workflow TODO
     * @param {module:api/WorkflowApi~createWorkflowCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link String}
     */
    this.createWorkflow = function(opts, callback) {
      opts = opts || {};
      var postBody = opts['workflow'];


      var pathParams = {
      };
      var queryParams = {
      };
      var collectionQueryParams = {
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = ['jwtAuth'];
      var contentTypes = ['application/json'];
      var accepts = ['application/json'];
      var returnType = String;

      return this.apiClient.callApi(
        '/workflow', 'POST',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the findPredictionByKeyword operation.
     * @callback module:api/WorkflowApi~findPredictionByKeywordCallback
     * @param {String} error Error message, if any.
     * @param {module:model/PredictionPageResult} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Finds Prediction by some key words or return all Predictions.
     * Muliple keywords can be provided with comma separated strings, e.g. keyword1, keyword2.
     * @param {Object} opts Optional parameters
     * @param {Number} opts.pageNumber the page number starting at 1
     * @param {Number} opts.pageSize entries per page, minimum 1
     * @param {Array.<String>} opts.keywords Keywords to search for
     * @param {module:api/WorkflowApi~findPredictionByKeywordCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/PredictionPageResult}
     */
    this.findPredictionByKeyword = function(opts, callback) {
      opts = opts || {};
      var postBody = null;


      var pathParams = {
      };
      var queryParams = {
        'pageNumber': opts['pageNumber'],
        'pageSize': opts['pageSize'],
      };
      var collectionQueryParams = {
        'keywords': {
          value: opts['keywords'],
          collectionFormat: 'multi'
        },
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = ['jwtAuth'];
      var contentTypes = [];
      var accepts = ['application/json'];
      var returnType = PredictionPageResult;

      return this.apiClient.callApi(
        '/prediction', 'GET',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the findPredictionJobs operation.
     * @callback module:api/WorkflowApi~findPredictionJobsCallback
     * @param {String} error Error message, if any.
     * @param {module:model/PredictionJobPageResult} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Finds predictions jobs by some key words or return all predictions jobs suitable for prediction.
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     * @param {Object} opts Optional parameters
     * @param {Number} opts.pageNumber the page number starting at 1
     * @param {Number} opts.pageSize entries per page, minimum 1
     * @param {Array.<String>} opts.keywords Keywords to search for
     * @param {module:api/WorkflowApi~findPredictionJobsCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/PredictionJobPageResult}
     */
    this.findPredictionJobs = function(opts, callback) {
      opts = opts || {};
      var postBody = null;


      var pathParams = {
      };
      var queryParams = {
        'pageNumber': opts['pageNumber'],
        'pageSize': opts['pageSize'],
      };
      var collectionQueryParams = {
        'keywords': {
          value: opts['keywords'],
          collectionFormat: 'multi'
        },
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = ['jwtAuth'];
      var contentTypes = [];
      var accepts = ['application/json'];
      var returnType = PredictionJobPageResult;

      return this.apiClient.callApi(
        '/workflow/prediction/job', 'GET',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the findPredictionWorkflows operation.
     * @callback module:api/WorkflowApi~findPredictionWorkflowsCallback
     * @param {String} error Error message, if any.
     * @param {module:model/WorkflowPageResult} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Finds workflows by some key words or return all workflows suitable for prediction.
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     * @param {Object} opts Optional parameters
     * @param {Number} opts.pageNumber the page number starting at 1
     * @param {Number} opts.pageSize entries per page, minimum 1
     * @param {Array.<String>} opts.keywords Keywords to search for
     * @param {module:api/WorkflowApi~findPredictionWorkflowsCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/WorkflowPageResult}
     */
    this.findPredictionWorkflows = function(opts, callback) {
      opts = opts || {};
      var postBody = null;


      var pathParams = {
      };
      var queryParams = {
        'pageNumber': opts['pageNumber'],
        'pageSize': opts['pageSize'],
      };
      var collectionQueryParams = {
        'keywords': {
          value: opts['keywords'],
          collectionFormat: 'multi'
        },
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = ['jwtAuth'];
      var contentTypes = [];
      var accepts = ['application/json'];
      var returnType = WorkflowPageResult;

      return this.apiClient.callApi(
        '/workflow/prediction', 'GET',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the findPredictionsByFingerprintSetId operation.
     * @callback module:api/WorkflowApi~findPredictionsByFingerprintSetIdCallback
     * @param {String} error Error message, if any.
     * @param {module:model/PredictionPageResult} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * get predictions (filtered by keywords) for a specific fingerprint set
     * @param {String} fingerprintsetId 
     * @param {Object} opts Optional parameters
     * @param {Number} opts.pageNumber the page number starting at 1
     * @param {Number} opts.pageSize entries per page, minimum 1
     * @param {Array.<String>} opts.keywords Keywords to search for
     * @param {module:api/WorkflowApi~findPredictionsByFingerprintSetIdCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/PredictionPageResult}
     */
    this.findPredictionsByFingerprintSetId = function(fingerprintsetId, opts, callback) {
      opts = opts || {};
      var postBody = null;

      // verify the required parameter 'fingerprintsetId' is set
      if (fingerprintsetId === undefined || fingerprintsetId === null) {
        throw new Error("Missing the required parameter 'fingerprintsetId' when calling findPredictionsByFingerprintSetId");
      }


      var pathParams = {
        'fingerprintset-id': fingerprintsetId
      };
      var queryParams = {
        'pageNumber': opts['pageNumber'],
        'pageSize': opts['pageSize'],
      };
      var collectionQueryParams = {
        'keywords': {
          value: opts['keywords'],
          collectionFormat: 'multi'
        },
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = ['jwtAuth'];
      var contentTypes = [];
      var accepts = ['application/json'];
      var returnType = PredictionPageResult;

      return this.apiClient.callApi(
        '/prediction/relation/{fingerprintset-id}', 'GET',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the findTrainingJobs operation.
     * @callback module:api/WorkflowApi~findTrainingJobsCallback
     * @param {String} error Error message, if any.
     * @param {module:model/TrainingJobPageResult} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Finds training jobs by some key words or return all training jobs.
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     * @param {Object} opts Optional parameters
     * @param {Number} opts.pageNumber the page number starting at 1
     * @param {Number} opts.pageSize entries per page, minimum 1
     * @param {Array.<String>} opts.keywords Keywords to search for
     * @param {module:api/WorkflowApi~findTrainingJobsCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/TrainingJobPageResult}
     */
    this.findTrainingJobs = function(opts, callback) {
      opts = opts || {};
      var postBody = null;


      var pathParams = {
      };
      var queryParams = {
        'pageNumber': opts['pageNumber'],
        'pageSize': opts['pageSize'],
      };
      var collectionQueryParams = {
        'keywords': {
          value: opts['keywords'],
          collectionFormat: 'multi'
        },
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = ['jwtAuth'];
      var contentTypes = [];
      var accepts = ['application/json'];
      var returnType = TrainingJobPageResult;

      return this.apiClient.callApi(
        '/workflow/training/job', 'GET',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the findTrainingWorkflows operation.
     * @callback module:api/WorkflowApi~findTrainingWorkflowsCallback
     * @param {String} error Error message, if any.
     * @param {module:model/WorkflowPageResult} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Finds workflows by some key words or return all workflows suitable for training models.
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     * @param {Object} opts Optional parameters
     * @param {Number} opts.pageNumber the page number starting at 1
     * @param {Number} opts.pageSize entries per page, minimum 1
     * @param {Array.<String>} opts.keywords Keywords to search for
     * @param {module:api/WorkflowApi~findTrainingWorkflowsCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/WorkflowPageResult}
     */
    this.findTrainingWorkflows = function(opts, callback) {
      opts = opts || {};
      var postBody = null;


      var pathParams = {
      };
      var queryParams = {
        'pageNumber': opts['pageNumber'],
        'pageSize': opts['pageSize'],
      };
      var collectionQueryParams = {
        'keywords': {
          value: opts['keywords'],
          collectionFormat: 'multi'
        },
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = ['jwtAuth'];
      var contentTypes = [];
      var accepts = ['application/json'];
      var returnType = WorkflowPageResult;

      return this.apiClient.callApi(
        '/workflow/training', 'GET',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the findWorkflowByKeyword operation.
     * @callback module:api/WorkflowApi~findWorkflowByKeywordCallback
     * @param {String} error Error message, if any.
     * @param {module:model/WorkflowPageResult} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Finds Workflow by some key words or return all Workflows.
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     * @param {Object} opts Optional parameters
     * @param {Number} opts.pageNumber the page number starting at 1
     * @param {Number} opts.pageSize entries per page, minimum 1
     * @param {Array.<String>} opts.keywords Keywords to search for
     * @param {module:api/WorkflowApi~findWorkflowByKeywordCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/WorkflowPageResult}
     */
    this.findWorkflowByKeyword = function(opts, callback) {
      opts = opts || {};
      var postBody = null;


      var pathParams = {
      };
      var queryParams = {
        'pageNumber': opts['pageNumber'],
        'pageSize': opts['pageSize'],
      };
      var collectionQueryParams = {
        'keywords': {
          value: opts['keywords'],
          collectionFormat: 'multi'
        },
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = ['jwtAuth'];
      var contentTypes = [];
      var accepts = ['application/json'];
      var returnType = WorkflowPageResult;

      return this.apiClient.callApi(
        '/workflow', 'GET',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the getPredictionJob operation.
     * @callback module:api/WorkflowApi~getPredictionJobCallback
     * @param {String} error Error message, if any.
     * @param {module:model/PredictionJob} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Lets one to ask for the status of a particular job.
     * @param {String} jobId TODO
     * @param {module:api/WorkflowApi~getPredictionJobCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/PredictionJob}
     */
    this.getPredictionJob = function(jobId, callback) {
      var postBody = null;

      // verify the required parameter 'jobId' is set
      if (jobId === undefined || jobId === null) {
        throw new Error("Missing the required parameter 'jobId' when calling getPredictionJob");
      }


      var pathParams = {
        'job-id': jobId
      };
      var queryParams = {
      };
      var collectionQueryParams = {
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = ['jwtAuth'];
      var contentTypes = [];
      var accepts = ['application/json'];
      var returnType = PredictionJob;

      return this.apiClient.callApi(
        '/workflow/prediction/job/{job-id}', 'GET',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the getPredictionResult operation.
     * @callback module:api/WorkflowApi~getPredictionResultCallback
     * @param {String} error Error message, if any.
     * @param {module:model/Prediction} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Get a specific prediction result.
     * @param {String} predictionId TODO
     * @param {module:api/WorkflowApi~getPredictionResultCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/Prediction}
     */
    this.getPredictionResult = function(predictionId, callback) {
      var postBody = null;

      // verify the required parameter 'predictionId' is set
      if (predictionId === undefined || predictionId === null) {
        throw new Error("Missing the required parameter 'predictionId' when calling getPredictionResult");
      }


      var pathParams = {
        'prediction-id': predictionId
      };
      var queryParams = {
      };
      var collectionQueryParams = {
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = ['jwtAuth'];
      var contentTypes = [];
      var accepts = ['application/json'];
      var returnType = Prediction;

      return this.apiClient.callApi(
        '/prediction/{prediction-id}', 'GET',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the getTrainingJob operation.
     * @callback module:api/WorkflowApi~getTrainingJobCallback
     * @param {String} error Error message, if any.
     * @param {module:model/TrainingJob} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Lets one to ask for the status of a particular job.
     * @param {String} jobId TODO
     * @param {module:api/WorkflowApi~getTrainingJobCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/TrainingJob}
     */
    this.getTrainingJob = function(jobId, callback) {
      var postBody = null;

      // verify the required parameter 'jobId' is set
      if (jobId === undefined || jobId === null) {
        throw new Error("Missing the required parameter 'jobId' when calling getTrainingJob");
      }


      var pathParams = {
        'job-id': jobId
      };
      var queryParams = {
      };
      var collectionQueryParams = {
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = ['jwtAuth'];
      var contentTypes = [];
      var accepts = ['application/json'];
      var returnType = TrainingJob;

      return this.apiClient.callApi(
        '/workflow/training/job/{job-id}', 'GET',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the getWorkflowById operation.
     * @callback module:api/WorkflowApi~getWorkflowByIdCallback
     * @param {String} error Error message, if any.
     * @param {module:model/Workflow} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Get the workflow an id.
     * TODO
     * @param {String} workflowId 
     * @param {module:api/WorkflowApi~getWorkflowByIdCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/Workflow}
     */
    this.getWorkflowById = function(workflowId, callback) {
      var postBody = null;

      // verify the required parameter 'workflowId' is set
      if (workflowId === undefined || workflowId === null) {
        throw new Error("Missing the required parameter 'workflowId' when calling getWorkflowById");
      }


      var pathParams = {
        'workflow-id': workflowId
      };
      var queryParams = {
      };
      var collectionQueryParams = {
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = ['jwtAuth'];
      var contentTypes = [];
      var accepts = ['application/json'];
      var returnType = Workflow;

      return this.apiClient.callApi(
        '/workflow/{workflow-id}', 'GET',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the removeWorkflowById operation.
     * @callback module:api/WorkflowApi~removeWorkflowByIdCallback
     * @param {String} error Error message, if any.
     * @param data This operation does not return a value.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Delete a workflow specified by id.
     * @param {String} workflowId 
     * @param {module:api/WorkflowApi~removeWorkflowByIdCallback} callback The callback function, accepting three arguments: error, data, response
     */
    this.removeWorkflowById = function(workflowId, callback) {
      var postBody = null;

      // verify the required parameter 'workflowId' is set
      if (workflowId === undefined || workflowId === null) {
        throw new Error("Missing the required parameter 'workflowId' when calling removeWorkflowById");
      }


      var pathParams = {
        'workflow-id': workflowId
      };
      var queryParams = {
      };
      var collectionQueryParams = {
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = ['jwtAuth'];
      var contentTypes = [];
      var accepts = [];
      var returnType = null;

      return this.apiClient.callApi(
        '/workflow/{workflow-id}', 'DELETE',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }
  };

  return exports;
}));
