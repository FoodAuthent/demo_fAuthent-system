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
    define(['../ApiClient'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'));
  } else {
    // Browser globals (root is window)
    if (!root.FoodAuthentSwaggerApi) {
      root.FoodAuthentSwaggerApi = {};
    }
    root.FoodAuthentSwaggerApi.FingerprintSetType = factory(root.FoodAuthentSwaggerApi.ApiClient);
  }
}(this, function(ApiClient) {
  'use strict';



  /**
   * The FingerprintSetType model module.
   * @module model/FingerprintSetType
   * @version 1.0.0
   */

  /**
   * Constructs a new <code>FingerprintSetType</code>.
   * Type of the fingerprint set. The referenced file musst reflect this type, too.
   * @alias module:model/FingerprintSetType
   * @class
   * @param name {module:model/FingerprintSetType.NameEnum} 
   */
  var exports = function(name) {
    var _this = this;

    _this['name'] = name;
  };

  /**
   * Constructs a <code>FingerprintSetType</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:model/FingerprintSetType} obj Optional instance to populate.
   * @return {module:model/FingerprintSetType} The populated <code>FingerprintSetType</code> instance.
   */
  exports.constructFromObject = function(data, obj) {
    if (data) {
      obj = obj || new exports();
      if (data.hasOwnProperty('name')) {
        obj['name'] = ApiClient.convertToType(data['name'], 'String');
      }
    }
    return obj;
  }

  /**
   * @member {module:model/FingerprintSetType.NameEnum} name
   */
  exports.prototype['name'] = undefined;


  /**
   * Allowed values for the <code>name</code> property.
   * @enum {String}
   * @readonly
   */
  exports.NameEnum = {
    /**
     * value: "bruker"
     * @const
     */
    "bruker": "bruker"  };


  return exports;
}));

