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
    define(['../ApiClient', '../model/PostalAddress'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'), require('./PostalAddress'));
  } else {
    // Browser globals (root is window)
    if (!root.FoodAuthentSwaggerApi) {
      root.FoodAuthentSwaggerApi = {};
    }
    root.FoodAuthentSwaggerApi.OrganizationalPostalAddress = factory(root.FoodAuthentSwaggerApi.ApiClient, root.FoodAuthentSwaggerApi.PostalAddress);
  }
}(this, function(ApiClient, PostalAddress) {
  'use strict';



  /**
   * The OrganizationalPostalAddress model module.
   * @module model/OrganizationalPostalAddress
   * @version 1.0.0
   */

  /**
   * Constructs a new <code>OrganizationalPostalAddress</code>.
   * organizational postal address object
   * @alias module:model/OrganizationalPostalAddress
   * @class
   * @extends module:model/PostalAddress
   * @implements module:model/PostalAddress
   * @param street {} street address part
   * @param postalCode {} postalCode address part
   * @param localityName {} locality/city address part
   */
  var exports = function(street, postalCode, localityName) {
    var _this = this;

    PostalAddress.call(_this, street, postalCode, localityName);
  };

  /**
   * Constructs a <code>OrganizationalPostalAddress</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:model/OrganizationalPostalAddress} obj Optional instance to populate.
   * @return {module:model/OrganizationalPostalAddress} The populated <code>OrganizationalPostalAddress</code> instance.
   */
  exports.constructFromObject = function(data, obj) {
    if (data) {
      obj = obj || new exports();
      PostalAddress.constructFromObject(data, obj);
      if (data.hasOwnProperty('recipientName')) {
        obj['recipientName'] = ApiClient.convertToType(data['recipientName'], 'String');
      }
    }
    return obj;
  }

  exports.prototype = Object.create(PostalAddress.prototype);
  exports.prototype.constructor = exports;

  /**
   * recipient address part
   * @member {String} recipientName
   */
  exports.prototype['recipientName'] = undefined;

  // Implement PostalAddress interface:
  /**
   * recipient address part
   * @member {String} otherRecipientInformation
   */
exports.prototype['otherRecipientInformation'] = undefined;

  /**
   * street address part
   * @member {String} street
   */
exports.prototype['street'] = undefined;

  /**
   * postalCode address part
   * @member {String} postalCode
   */
exports.prototype['postalCode'] = undefined;

  /**
   * locality/city address part
   * @member {String} localityName
   */
exports.prototype['localityName'] = undefined;

  /**
   * stateOrProvinceName address part
   * @member {String} stateOrProvinceName
   */
exports.prototype['stateOrProvinceName'] = undefined;

  /**
   * country address part
   * @member {String} country
   */
exports.prototype['country'] = undefined;



  return exports;
}));

