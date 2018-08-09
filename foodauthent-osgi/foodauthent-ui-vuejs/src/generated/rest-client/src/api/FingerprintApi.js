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
 * Swagger Codegen version: 2.3.1
 *
 * Do not edit the class manually.
 *
 */

(function(root, factory) {
  if (typeof define === 'function' && define.amd) {
    // AMD. Register as an anonymous module.
    define(['ApiClient', 'model/FingerprintSet', 'model/FingerprintSetPageResult'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'), require('../model/FingerprintSet'), require('../model/FingerprintSetPageResult'));
  } else {
    // Browser globals (root is window)
    if (!root.FoodAuthentSwaggerApi) {
      root.FoodAuthentSwaggerApi = {};
    }
    root.FoodAuthentSwaggerApi.FingerprintApi = factory(root.FoodAuthentSwaggerApi.ApiClient, root.FoodAuthentSwaggerApi.FingerprintSet, root.FoodAuthentSwaggerApi.FingerprintSetPageResult);
  }
}(this, function(ApiClient, FingerprintSet, FingerprintSetPageResult) {
  'use strict';

  /**
   * Fingerprint service.
   * @module api/FingerprintApi
   * @version 1.0.0
   */

  /**
   * Constructs a new FingerprintApi. 
   * @alias module:api/FingerprintApi
   * @class
   * @param {module:ApiClient} [apiClient] Optional API client implementation to use,
   * default to {@link module:ApiClient#instance} if unspecified.
   */
  var exports = function(apiClient) {
    this.apiClient = apiClient || ApiClient.instance;


    /**
     * Callback function to receive the result of the createFingerprintSet operation.
     * @callback module:api/FingerprintApi~createFingerprintSetCallback
     * @param {String} error Error message, if any.
     * @param {'String'} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Create a new fingerprint set.
     * TODO
     * @param {module:model/FingerprintSet} fingerprintSet A fingerprint set containing fingerprint metadata.
     * @param {module:api/FingerprintApi~createFingerprintSetCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link 'String'}
     */
    this.createFingerprintSet = function(fingerprintSet, callback) {
      var postBody = fingerprintSet;

      // verify the required parameter 'fingerprintSet' is set
      if (fingerprintSet === undefined || fingerprintSet === null) {
        throw new Error("Missing the required parameter 'fingerprintSet' when calling createFingerprintSet");
      }


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
      var returnType = 'String';

      return this.apiClient.callApi(
        '/fingerprintset', 'POST',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the findFingerprintSetByKeyword operation.
     * @callback module:api/FingerprintApi~findFingerprintSetByKeywordCallback
     * @param {String} error Error message, if any.
     * @param {module:model/FingerprintSetPageResult} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Finds fingerprint sets by some key words or return all fingerprint sets.
     * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     * @param {Object} opts Optional parameters
     * @param {Number} opts.pageNumber 
     * @param {Number} opts.pageSize 
     * @param {Array.<String>} opts.keywords Keywords to search for
     * @param {module:api/FingerprintApi~findFingerprintSetByKeywordCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/FingerprintSetPageResult}
     */
    this.findFingerprintSetByKeyword = function(opts, callback) {
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
      var returnType = FingerprintSetPageResult;

      return this.apiClient.callApi(
        '/fingerprintset', 'GET',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the getFingerprintSetById operation.
     * @callback module:api/FingerprintApi~getFingerprintSetByIdCallback
     * @param {String} error Error message, if any.
     * @param {module:model/FingerprintSet} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Get the fingerprintset by id.
     * TODO
     * @param {String} fingerprintsetId 
     * @param {module:api/FingerprintApi~getFingerprintSetByIdCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/FingerprintSet}
     */
    this.getFingerprintSetById = function(fingerprintsetId, callback) {
      var postBody = null;

      // verify the required parameter 'fingerprintsetId' is set
      if (fingerprintsetId === undefined || fingerprintsetId === null) {
        throw new Error("Missing the required parameter 'fingerprintsetId' when calling getFingerprintSetById");
      }


      var pathParams = {
        'fingerprintset-id': fingerprintsetId
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
      var returnType = FingerprintSet;

      return this.apiClient.callApi(
        '/fingerprintset/{fingerprintset-id}', 'GET',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }
  };

  return exports;
}));
