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
    define(['../ApiClient', '../model/FileMetadata', '../model/ImportResult'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'), require('../model/FileMetadata'), require('../model/ImportResult'));
  } else {
    // Browser globals (root is window)
    if (!root.FoodAuthentSwaggerApi) {
      root.FoodAuthentSwaggerApi = {};
    }
    root.FoodAuthentSwaggerApi.FileApi = factory(root.FoodAuthentSwaggerApi.ApiClient, root.FoodAuthentSwaggerApi.FileMetadata, root.FoodAuthentSwaggerApi.ImportResult);
  }
}(this, function(ApiClient, FileMetadata, ImportResult) {
  'use strict';

  /**
   * File service.
   * @module api/FileApi
   * @version 1.0.0
   */

  /**
   * Constructs a new FileApi. 
   * @alias module:api/FileApi
   * @class
   * @param {module:ApiClient} [apiClient] Optional API client implementation to use,
   * default to {@link module:ApiClient#instance} if unspecified.
   */
  var exports = function(apiClient) {
    this.apiClient = apiClient || ApiClient.instance;


    /**
     * Callback function to receive the result of the callImport operation.
     * @callback module:api/FileApi~callImportCallback
     * @param {String} error Error message, if any.
     * @param {module:model/ImportResult} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Import a ZIP file
     * Import FoodAuthent components from an existing ZIP file and return the ids of the components.
     * @param {String} fileId 
     * @param {module:api/FileApi~callImportCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/ImportResult}
     */
    this.callImport = function(fileId, callback) {
      var postBody = null;

      // verify the required parameter 'fileId' is set
      if (fileId === undefined || fileId === null) {
        throw new Error("Missing the required parameter 'fileId' when calling callImport");
      }


      var pathParams = {
        'file-id': fileId
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
      var returnType = ImportResult;

      return this.apiClient.callApi(
        '/file/{file-id}/import', 'GET',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the createFileMetadata operation.
     * @callback module:api/FileApi~createFileMetadataCallback
     * @param {String} error Error message, if any.
     * @param {String} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Creates a new file by posting the file metadata first.
     * @param {module:model/FileMetadata} fileMetadata The actual metadata object.
     * @param {module:api/FileApi~createFileMetadataCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link String}
     */
    this.createFileMetadata = function(fileMetadata, callback) {
      var postBody = fileMetadata;

      // verify the required parameter 'fileMetadata' is set
      if (fileMetadata === undefined || fileMetadata === null) {
        throw new Error("Missing the required parameter 'fileMetadata' when calling createFileMetadata");
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
      var returnType = String;

      return this.apiClient.callApi(
        '/file', 'POST',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the getFileData operation.
     * @callback module:api/FileApi~getFileDataCallback
     * @param {String} error Error message, if any.
     * @param {File} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Let one download the actual file data.
     * @param {String} fileId 
     * @param {module:api/FileApi~getFileDataCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link File}
     */
    this.getFileData = function(fileId, callback) {
      var postBody = null;

      // verify the required parameter 'fileId' is set
      if (fileId === undefined || fileId === null) {
        throw new Error("Missing the required parameter 'fileId' when calling getFileData");
      }


      var pathParams = {
        'file-id': fileId
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
      var accepts = ['application/binary'];
      var returnType = File;

      return this.apiClient.callApi(
        '/file/{file-id}/data', 'GET',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the getFileMetadata operation.
     * @callback module:api/FileApi~getFileMetadataCallback
     * @param {String} error Error message, if any.
     * @param {module:model/FileMetadata} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Returns the file metadata.
     * @param {String} fileId 
     * @param {module:api/FileApi~getFileMetadataCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/FileMetadata}
     */
    this.getFileMetadata = function(fileId, callback) {
      var postBody = null;

      // verify the required parameter 'fileId' is set
      if (fileId === undefined || fileId === null) {
        throw new Error("Missing the required parameter 'fileId' when calling getFileMetadata");
      }


      var pathParams = {
        'file-id': fileId
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
      var returnType = FileMetadata;

      return this.apiClient.callApi(
        '/file/{file-id}', 'GET',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the saveFileData operation.
     * @callback module:api/FileApi~saveFileDataCallback
     * @param {String} error Error message, if any.
     * @param {String} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Uploads (and replaces) the actual file-data for the given file id
     * @param {String} fileId 
     * @param {File} filedata The binary file data.
     * @param {module:api/FileApi~saveFileDataCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link String}
     */
    this.saveFileData = function(fileId, filedata, callback) {
      var postBody = null;

      // verify the required parameter 'fileId' is set
      if (fileId === undefined || fileId === null) {
        throw new Error("Missing the required parameter 'fileId' when calling saveFileData");
      }

      // verify the required parameter 'filedata' is set
      if (filedata === undefined || filedata === null) {
        throw new Error("Missing the required parameter 'filedata' when calling saveFileData");
      }


      var pathParams = {
        'file-id': fileId
      };
      var queryParams = {
      };
      var collectionQueryParams = {
      };
      var headerParams = {
      };
      var formParams = {
        'filedata': filedata
      };

      var authNames = [];
      var contentTypes = ['multipart/form-data'];
      var accepts = ['application/json'];
      var returnType = String;

      return this.apiClient.callApi(
        '/file/{file-id}/data', 'PUT',
        pathParams, queryParams, collectionQueryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }
  };

  return exports;
}));
