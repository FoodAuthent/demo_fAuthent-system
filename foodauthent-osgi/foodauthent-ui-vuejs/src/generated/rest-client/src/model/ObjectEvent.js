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
    define(['../ApiClient', '../model/ArrayStringItem', '../model/BizTransaction'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'), require('./ArrayStringItem'), require('./BizTransaction'));
  } else {
    // Browser globals (root is window)
    if (!root.FoodAuthentSwaggerApi) {
      root.FoodAuthentSwaggerApi = {};
    }
    root.FoodAuthentSwaggerApi.ObjectEvent = factory(root.FoodAuthentSwaggerApi.ApiClient, root.FoodAuthentSwaggerApi.ArrayStringItem, root.FoodAuthentSwaggerApi.BizTransaction);
  }
}(this, function(ApiClient, ArrayStringItem, BizTransaction) {
  'use strict';



  /**
   * The ObjectEvent model module.
   * @module model/ObjectEvent
   * @version 1.0.0
   */

  /**
   * Constructs a new <code>ObjectEvent</code>.
   * Object Event Transaction
   * @alias module:model/ObjectEvent
   * @class
   */
  var exports = function() {
    var _this = this;

  };

  /**
   * Constructs a <code>ObjectEvent</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:model/ObjectEvent} obj Optional instance to populate.
   * @return {module:model/ObjectEvent} The populated <code>ObjectEvent</code> instance.
   */
  exports.constructFromObject = function(data, obj) {
    if (data) {
      obj = obj || new exports();
      if (data.hasOwnProperty('fa-id')) {
        obj['fa-id'] = ApiClient.convertToType(data['fa-id'], 'String');
      }
      if (data.hasOwnProperty('epcList')) {
        obj['epcList'] = ApiClient.convertToType(data['epcList'], [ArrayStringItem]);
      }
      if (data.hasOwnProperty('bizStep')) {
        obj['bizStep'] = ApiClient.convertToType(data['bizStep'], 'String');
      }
      if (data.hasOwnProperty('readPoint')) {
        obj['readPoint'] = ApiClient.convertToType(data['readPoint'], 'String');
      }
      if (data.hasOwnProperty('quantityList')) {
        obj['quantityList'] = ApiClient.convertToType(data['quantityList'], [ArrayStringItem]);
      }
      if (data.hasOwnProperty('action')) {
        obj['action'] = ApiClient.convertToType(data['action'], 'String');
      }
      if (data.hasOwnProperty('disposition')) {
        obj['disposition'] = ApiClient.convertToType(data['disposition'], 'String');
      }
      if (data.hasOwnProperty('bizTransactionList')) {
        obj['bizTransactionList'] = ApiClient.convertToType(data['bizTransactionList'], [BizTransaction]);
      }
      if (data.hasOwnProperty('gtin')) {
        obj['gtin'] = ApiClient.convertToType(data['gtin'], 'String');
      }
      if (data.hasOwnProperty('bricks')) {
        obj['bricks'] = ApiClient.convertToType(data['bricks'], [ArrayStringItem]);
      }
      if (data.hasOwnProperty('eventTime')) {
        obj['eventTime'] = ApiClient.convertToType(data['eventTime'], 'Date');
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
   * List of epcs
   * @member {Array.<module:model/ArrayStringItem>} epcList
   */
  exports.prototype['epcList'] = undefined;
  /**
   * EPCIS bizStep
   * @member {String} bizStep
   */
  exports.prototype['bizStep'] = undefined;
  /**
   * Read point
   * @member {String} readPoint
   */
  exports.prototype['readPoint'] = undefined;
  /**
   * List of quantity
   * @member {Array.<module:model/ArrayStringItem>} quantityList
   */
  exports.prototype['quantityList'] = undefined;
  /**
   * EPCIS Action
   * @member {String} action
   */
  exports.prototype['action'] = undefined;
  /**
   * EPCIS Disposition
   * @member {String} disposition
   */
  exports.prototype['disposition'] = undefined;
  /**
   * List of bizTransactions
   * @member {Array.<module:model/BizTransaction>} bizTransactionList
   */
  exports.prototype['bizTransactionList'] = undefined;
  /**
   * Global Trade Item Number
   * @member {String} gtin
   */
  exports.prototype['gtin'] = undefined;
  /**
   * bricks
   * @member {Array.<module:model/ArrayStringItem>} bricks
   */
  exports.prototype['bricks'] = undefined;
  /**
   * When the event happened
   * @member {Date} eventTime
   */
  exports.prototype['eventTime'] = undefined;



  return exports;
}));


