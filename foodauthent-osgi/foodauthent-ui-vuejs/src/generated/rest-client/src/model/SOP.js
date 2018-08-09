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
    define(['../ApiClient'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'));
  } else {
    // Browser globals (root is window)
    if (!root.FoodAuthentSwaggerApi) {
      root.FoodAuthentSwaggerApi = {};
    }
    root.FoodAuthentSwaggerApi.SOP = factory(root.FoodAuthentSwaggerApi.ApiClient);
  }
}(this, function(ApiClient) {
  'use strict';




  /**
   * The SOP model module.
   * @module model/SOP
   * @version 1.0.0
   */

  /**
   * Constructs a new <code>SOP</code>.
   * @alias module:model/SOP
   * @class
   */
  var exports = function() {
    var _this = this;






  };

  /**
   * Constructs a <code>SOP</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:model/SOP} obj Optional instance to populate.
   * @return {module:model/SOP} The populated <code>SOP</code> instance.
   */
  exports.constructFromObject = function(data, obj) {
    if (data) {
      obj = obj || new exports();

      if (data.hasOwnProperty('fa-id')) {
        obj['fa-id'] = ApiClient.convertToType(data['fa-id'], 'String');
      }
      if (data.hasOwnProperty('file-id')) {
        obj['file-id'] = ApiClient.convertToType(data['file-id'], 'String');
      }
      if (data.hasOwnProperty('name')) {
        obj['name'] = ApiClient.convertToType(data['name'], 'String');
      }
      if (data.hasOwnProperty('description')) {
        obj['description'] = ApiClient.convertToType(data['description'], 'String');
      }
      if (data.hasOwnProperty('product-id')) {
        obj['product-id'] = ApiClient.convertToType(data['product-id'], 'String');
      }
    }
    return obj;
  }

  /**
   * A global id within the FoodAuthent-system.
   * @member {String} fa-id
   */
  exports.prototype['fa-id'] = undefined;
  /**
   * Id referencing the file in the fa-system.
   * @member {String} file-id
   */
  exports.prototype['file-id'] = undefined;
  /**
   * A short SOP name
   * @member {String} name
   */
  exports.prototype['name'] = undefined;
  /**
   * A short description of the sop
   * @member {String} description
   */
  exports.prototype['description'] = undefined;
  /**
   * A reference to a product this sop is made for.
   * @member {String} product-id
   */
  exports.prototype['product-id'] = undefined;



  return exports;
}));


