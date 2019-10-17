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
    define(['../ApiClient', '../model/DiscoveryServiceTransaction', '../model/ObjectEvent', '../model/ObjectEventPageResult'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'), require('../model/DiscoveryServiceTransaction'), require('../model/ObjectEvent'), require('../model/ObjectEventPageResult'));
  } else {
    // Browser globals (root is window)
    if (!root.FoodAuthentSwaggerApi) {
      root.FoodAuthentSwaggerApi = {};
    }
    root.FoodAuthentSwaggerApi.ObjectEventApi = factory(root.FoodAuthentSwaggerApi.ApiClient, root.FoodAuthentSwaggerApi.DiscoveryServiceTransaction, root.FoodAuthentSwaggerApi.ObjectEvent, root.FoodAuthentSwaggerApi.ObjectEventPageResult);
  }
}(this, function(ApiClient, DiscoveryServiceTransaction, ObjectEvent, ObjectEventPageResult) {
  'use strict';

  /**
   * ObjectEvent service.
   * @module api/ObjectEventApi
   * @version 1.0.0
   */

  /**
   * Constructs a new ObjectEventApi. 
   * @alias module:api/ObjectEventApi
   * @class
   * @param {module:ApiClient} [apiClient] Optional API client implementation to use,
   * default to {@link module:ApiClient#instance} if unspecified.
   */
  var exports = function(apiClient) {
    this.apiClient = apiClient || ApiClient.instance;


    /**
     * Callback function to receive the result of the convertObjectEventToTransaction operation.
     * @callback module:api/ObjectEventApi~convertObjectEventToTransactionCallback
     * @param {String} error Error message, if any.
     * @param {module:model/DiscoveryServiceTransaction} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Convert the ObjectEvent to Discovery Service Transaction.
     * @param {String} objecteventId 
     * @param {module:api/ObjectEventApi~convertObjectEventToTransactionCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/DiscoveryServiceTransaction}
     */
    this.convertObjectEventToTransaction = function(objecteventId, callback) {
      var postBody = null;

      // verify the required parameter 'objecteventId' is set
      if (objecteventId === undefined || objecteventId === null) {
        throw new Error("Missing the required parameter 'objecteventId' when calling convertObjectEventToTransaction");
      }


      var pathParams = {
        'objectevent-id': objecteventId
      };
      var queryParams = {
      };
      var collectionQueryParams = {
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = ['apiKeyId', 'apiKeySecret', 'jwtAuth'];
      var contentTypes = [];
      var accepts = ['application/json'];
      var returnType = 'DiscoveryServiceTransaction';

      return this.apiClient.callApi(
        '/epcis/objectEvent/{objectevent-id}/discovery', 'GET',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the createObjectEvent operation.
     * @callback module:api/ObjectEventApi~createObjectEventCallback
     * @param {String} error Error message, if any.
     * @param {String} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Creates/adds a new ObjectEvent.
     * Creates/adds a new ObjectEvent.
     * @param {Object} opts Optional parameters
     * @param {module:model/ObjectEvent} opts.objectEvent TODO
     * @param {module:api/ObjectEventApi~createObjectEventCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link String}
     */
    this.createObjectEvent = function(opts, callback) {
      opts = opts || {};
      var postBody = opts['objectEvent'];


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

      var authNames = ['apiKeyId', 'apiKeySecret', 'jwtAuth'];
      var contentTypes = ['application/json'];
      var accepts = ['application/json'];
      var returnType = 'String';

      return this.apiClient.callApi(
        '/epcis/objectEvent/', 'POST',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the findObjectEventByKeyword operation.
     * @callback module:api/ObjectEventApi~findObjectEventByKeywordCallback
     * @param {String} error Error message, if any.
     * @param {module:model/ObjectEventPageResult} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Finds Object Event by epcClass or return all Object Events.
     * Muliple keywords(epcClass) can be provided with comma separated strings, e.g, keyword1, keyword2.
     * @param {Object} opts Optional parameters
     * @param {Number} opts.pageNumber the page number starting at 1
     * @param {Number} opts.pageSize entries per page, minimum 1
     * @param {Array.<String>} opts.keywords Keywords to search for
     * @param {module:api/ObjectEventApi~findObjectEventByKeywordCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/ObjectEventPageResult}
     */
    this.findObjectEventByKeyword = function(opts, callback) {
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

      var authNames = ['apiKeyId', 'apiKeySecret', 'jwtAuth'];
      var contentTypes = [];
      var accepts = ['application/json'];
      var returnType = 'ObjectEventPageResult';

      return this.apiClient.callApi(
        '/epcis/objectEvent/', 'GET',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the getObjectEventById operation.
     * @callback module:api/ObjectEventApi~getObjectEventByIdCallback
     * @param {String} error Error message, if any.
     * @param {module:model/ObjectEvent} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Get the ObjectEvent an id.
     * @param {String} objecteventId 
     * @param {module:api/ObjectEventApi~getObjectEventByIdCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/ObjectEvent}
     */
    this.getObjectEventById = function(objecteventId, callback) {
      var postBody = null;

      // verify the required parameter 'objecteventId' is set
      if (objecteventId === undefined || objecteventId === null) {
        throw new Error("Missing the required parameter 'objecteventId' when calling getObjectEventById");
      }


      var pathParams = {
        'objectevent-id': objecteventId
      };
      var queryParams = {
      };
      var collectionQueryParams = {
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = ['apiKeyId', 'apiKeySecret', 'jwtAuth'];
      var contentTypes = [];
      var accepts = ['application/json'];
      var returnType = 'ObjectEvent';

      return this.apiClient.callApi(
        '/epcis/objectEvent/{objectevent-id}', 'GET',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }
  };

  return exports;
}));
