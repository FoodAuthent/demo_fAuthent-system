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
    define(['../ApiClient', '../model/Product', '../model/ProductPageResult'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'), require('../model/Product'), require('../model/ProductPageResult'));
  } else {
    // Browser globals (root is window)
    if (!root.FoodAuthentSwaggerApi) {
      root.FoodAuthentSwaggerApi = {};
    }
    root.FoodAuthentSwaggerApi.ProductApi = factory(root.FoodAuthentSwaggerApi.ApiClient, root.FoodAuthentSwaggerApi.Product, root.FoodAuthentSwaggerApi.ProductPageResult);
  }
}(this, function(ApiClient, Product, ProductPageResult) {
  'use strict';

  /**
   * Product service.
   * @module api/ProductApi
   * @version 1.0.0
   */

  /**
   * Constructs a new ProductApi. 
   * @alias module:api/ProductApi
   * @class
   * @param {module:ApiClient} [apiClient] Optional API client implementation to use,
   * default to {@link module:ApiClient#instance} if unspecified.
   */
  var exports = function(apiClient) {
    this.apiClient = apiClient || ApiClient.instance;


    /**
     * Callback function to receive the result of the createProduct operation.
     * @callback module:api/ProductApi~createProductCallback
     * @param {String} error Error message, if any.
     * @param {String} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Create a new product entity.
     * @param {Object} opts Optional parameters
     * @param {module:model/Product} opts.product TODO
     * @param {module:api/ProductApi~createProductCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link String}
     */
    this.createProduct = function(opts, callback) {
      opts = opts || {};
      var postBody = opts['product'];


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
        '/product', 'POST',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the findProductByGtin operation.
     * @callback module:api/ProductApi~findProductByGtinCallback
     * @param {String} error Error message, if any.
     * @param {module:model/Product} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Find product by gtin.
     * @param {String} gtin The gtin to find the product for.
     * @param {module:api/ProductApi~findProductByGtinCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/Product}
     */
    this.findProductByGtin = function(gtin, callback) {
      var postBody = null;

      // verify the required parameter 'gtin' is set
      if (gtin === undefined || gtin === null) {
        throw new Error("Missing the required parameter 'gtin' when calling findProductByGtin");
      }


      var pathParams = {
      };
      var queryParams = {
        'gtin': gtin,
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
      var returnType = Product;

      return this.apiClient.callApi(
        '/product/findByGtin', 'GET',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the findProductByKeyword operation.
     * @callback module:api/ProductApi~findProductByKeywordCallback
     * @param {String} error Error message, if any.
     * @param {module:model/ProductPageResult} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Finds Products by some key words or return all Products.
     * Muliple keywords can be provided with comma separated strings, e.g, keyword1, keyword2.
     * @param {Object} opts Optional parameters
     * @param {Number} opts.pageNumber the page number starting at 0
     * @param {Number} opts.pageSize entries per page, minimum 1
     * @param {Array.<String>} opts.keywords Keywords to search for
     * @param {module:api/ProductApi~findProductByKeywordCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/ProductPageResult}
     */
    this.findProductByKeyword = function(opts, callback) {
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
      var returnType = ProductPageResult;

      return this.apiClient.callApi(
        '/product', 'GET',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the removeProductByGtin operation.
     * @callback module:api/ProductApi~removeProductByGtinCallback
     * @param {String} error Error message, if any.
     * @param data This operation does not return a value.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Delete a product specified by gtin.
     * @param {String} gtin 
     * @param {module:api/ProductApi~removeProductByGtinCallback} callback The callback function, accepting three arguments: error, data, response
     */
    this.removeProductByGtin = function(gtin, callback) {
      var postBody = null;

      // verify the required parameter 'gtin' is set
      if (gtin === undefined || gtin === null) {
        throw new Error("Missing the required parameter 'gtin' when calling removeProductByGtin");
      }


      var pathParams = {
        'gtin': gtin
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
      var accepts = [];
      var returnType = null;

      return this.apiClient.callApi(
        '/product/{gtin}', 'DELETE',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the updatedProduct operation.
     * @callback module:api/ProductApi~updatedProductCallback
     * @param {String} error Error message, if any.
     * @param data This operation does not return a value.
     * @param {String} response The complete HTTP response.
     */

    /**
     * update a new product entity.
     * TODO
     * @param {Object} opts Optional parameters
     * @param {module:model/Product} opts.product TODO
     * @param {module:api/ProductApi~updatedProductCallback} callback The callback function, accepting three arguments: error, data, response
     */
    this.updatedProduct = function(opts, callback) {
      opts = opts || {};
      var postBody = opts['product'];


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
      var accepts = [];
      var returnType = null;

      return this.apiClient.callApi(
        '/product', 'PUT',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }
  };

  return exports;
}));
