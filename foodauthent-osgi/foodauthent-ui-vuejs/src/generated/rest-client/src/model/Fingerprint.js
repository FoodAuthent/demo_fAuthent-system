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
    define(['ApiClient'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'));
  } else {
    // Browser globals (root is window)
    if (!root.FoodAuthentSwaggerApi) {
      root.FoodAuthentSwaggerApi = {};
    }
    root.FoodAuthentSwaggerApi.Fingerprint = factory(root.FoodAuthentSwaggerApi.ApiClient);
  }
}(this, function(ApiClient) {
  'use strict';




  /**
   * The Fingerprint model module.
   * @module model/Fingerprint
   * @version 1.0.0
   */

  /**
   * Constructs a new <code>Fingerprint</code>.
   * A fingerprint object representing its metadata.
   * @alias module:model/Fingerprint
   * @class
   */
  var exports = function() {
    var _this = this;




  };

  /**
   * Constructs a <code>Fingerprint</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:model/Fingerprint} obj Optional instance to populate.
   * @return {module:model/Fingerprint} The populated <code>Fingerprint</code> instance.
   */
  exports.constructFromObject = function(data, obj) {
    if (data) {
      obj = obj || new exports();

      if (data.hasOwnProperty('fa-id')) {
        obj['fa-id'] = ApiClient.convertToType(data['fa-id'], 'String');
      }
      if (data.hasOwnProperty('metadata')) {
        obj['metadata'] = ApiClient.convertToType(data['metadata'], 'String');
      }
      if (data.hasOwnProperty('additional-properties')) {
        obj['additional-properties'] = ApiClient.convertToType(data['additional-properties'], {'String': 'String'});
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
   * Placeholder for the actual metadata.
   * @member {String} metadata
   */
  exports.prototype['metadata'] = undefined;
  /**
   * Key-value-map for additional properties.
   * @member {Object.<String, String>} additional-properties
   */
  exports.prototype['additional-properties'] = undefined;



  return exports;
}));


