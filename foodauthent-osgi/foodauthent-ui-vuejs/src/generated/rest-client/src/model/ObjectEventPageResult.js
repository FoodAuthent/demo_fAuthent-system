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
    define(['../ApiClient', '../model/ObjectEvent'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'), require('./ObjectEvent'));
  } else {
    // Browser globals (root is window)
    if (!root.FoodAuthentSwaggerApi) {
      root.FoodAuthentSwaggerApi = {};
    }
    root.FoodAuthentSwaggerApi.ObjectEventPageResult = factory(root.FoodAuthentSwaggerApi.ApiClient, root.FoodAuthentSwaggerApi.ObjectEvent);
  }
}(this, function(ApiClient, ObjectEvent) {
  'use strict';



  /**
   * The ObjectEventPageResult model module.
   * @module model/ObjectEventPageResult
   * @version 1.0.0
   */

  /**
   * Constructs a new <code>ObjectEventPageResult</code>.
   * @alias module:model/ObjectEventPageResult
   * @class
   */
  var exports = function() {
    var _this = this;

  };

  /**
   * Constructs a <code>ObjectEventPageResult</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:model/ObjectEventPageResult} obj Optional instance to populate.
   * @return {module:model/ObjectEventPageResult} The populated <code>ObjectEventPageResult</code> instance.
   */
  exports.constructFromObject = function(data, obj) {
    if (data) {
      obj = obj || new exports();
      if (data.hasOwnProperty('pageNumber')) {
        obj['pageNumber'] = ApiClient.convertToType(data['pageNumber'], 'Number');
      }
      if (data.hasOwnProperty('pageCount')) {
        obj['pageCount'] = ApiClient.convertToType(data['pageCount'], 'Number');
      }
      if (data.hasOwnProperty('resultCount')) {
        obj['resultCount'] = ApiClient.convertToType(data['resultCount'], 'Number');
      }
      if (data.hasOwnProperty('results')) {
        obj['results'] = ApiClient.convertToType(data['results'], [ObjectEvent]);
      }
    }
    return obj;
  }

  /**
   * @member {Number} pageNumber
   */
  exports.prototype['pageNumber'] = undefined;
  /**
   * @member {Number} pageCount
   */
  exports.prototype['pageCount'] = undefined;
  /**
   * @member {Number} resultCount
   */
  exports.prototype['resultCount'] = undefined;
  /**
   * @member {Array.<module:model/ObjectEvent>} results
   */
  exports.prototype['results'] = undefined;



  return exports;
}));


