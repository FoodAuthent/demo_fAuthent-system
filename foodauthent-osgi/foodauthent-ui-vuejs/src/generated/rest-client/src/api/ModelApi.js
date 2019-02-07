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
    define(['../ApiClient', '../model/Model', '../model/ModelPageResult'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'), require('../model/Model'), require('../model/ModelPageResult'));
  } else {
    // Browser globals (root is window)
    if (!root.FoodAuthentSwaggerApi) {
      root.FoodAuthentSwaggerApi = {};
    }
    root.FoodAuthentSwaggerApi.ModelApi = factory(root.FoodAuthentSwaggerApi.ApiClient, root.FoodAuthentSwaggerApi.Model, root.FoodAuthentSwaggerApi.ModelPageResult);
  }
}(this, function(ApiClient, Model, ModelPageResult) {
  'use strict';

  /**
   * Model service.
   * @module api/ModelApi
   * @version 1.0.0
   */

  /**
   * Constructs a new ModelApi. 
   * @alias module:api/ModelApi
   * @class
   * @param {module:ApiClient} [apiClient] Optional API client implementation to use,
   * default to {@link module:ApiClient#instance} if unspecified.
   */
  var exports = function(apiClient) {
    this.apiClient = apiClient || ApiClient.instance;


    /**
     * Callback function to receive the result of the createModel operation.
     * @callback module:api/ModelApi~createModelCallback
     * @param {String} error Error message, if any.
     * @param {String} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Creates/adds a new model.
     * Creates/adds a new model.
     * @param {Object} opts Optional parameters
     * @param {module:model/Model} opts.model TODO
     * @param {module:api/ModelApi~createModelCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link String}
     */
    this.createModel = function(opts, callback) {
      opts = opts || {};
      var postBody = opts['model'];


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

      var authNames = [];
      var contentTypes = ['application/json'];
      var accepts = ['application/json'];
      var returnType = String;

      return this.apiClient.callApi(
        '/model', 'POST',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the findModelByKeyword operation.
     * @callback module:api/ModelApi~findModelByKeywordCallback
     * @param {String} error Error message, if any.
     * @param {module:model/ModelPageResult} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Finds Models by some key words or return all Models.
     * Muliple keywords can be provided with comma separated strings, e.g. keyword1, keyword2.
     * @param {Object} opts Optional parameters
     * @param {Number} opts.pageNumber the page number starting at 0
     * @param {Number} opts.pageSize entries per page, minimum 1
     * @param {Array.<String>} opts.keywords Keywords to search for
     * @param {module:api/ModelApi~findModelByKeywordCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/ModelPageResult}
     */
    this.findModelByKeyword = function(opts, callback) {
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

      var authNames = [];
      var contentTypes = [];
      var accepts = ['application/json'];
      var returnType = ModelPageResult;

      return this.apiClient.callApi(
        '/model', 'GET',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the getModelById operation.
     * @callback module:api/ModelApi~getModelByIdCallback
     * @param {String} error Error message, if any.
     * @param {module:model/Model} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Get the model by id.
     * TODO
     * @param {String} modelId 
     * @param {module:api/ModelApi~getModelByIdCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/Model}
     */
    this.getModelById = function(modelId, callback) {
      var postBody = null;

      // verify the required parameter 'modelId' is set
      if (modelId === undefined || modelId === null) {
        throw new Error("Missing the required parameter 'modelId' when calling getModelById");
      }


      var pathParams = {
        'model-id': modelId
      };
      var queryParams = {
      };
      var collectionQueryParams = {
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = [];
      var contentTypes = [];
      var accepts = ['application/json'];
      var returnType = Model;

      return this.apiClient.callApi(
        '/model/{model-id}', 'GET',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }
  };

  return exports;
}));
