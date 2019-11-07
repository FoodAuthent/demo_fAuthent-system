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
    define(['../ApiClient', '../model/BizTransaction', '../model/QuantityElement'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'), require('./BizTransaction'), require('./QuantityElement'));
  } else {
    // Browser globals (root is window)
    if (!root.FoodAuthentSwaggerApi) {
      root.FoodAuthentSwaggerApi = {};
    }
    root.FoodAuthentSwaggerApi.ObjectEvent = factory(root.FoodAuthentSwaggerApi.ApiClient, root.FoodAuthentSwaggerApi.BizTransaction, root.FoodAuthentSwaggerApi.QuantityElement);
  }
}(this, function(ApiClient, BizTransaction, QuantityElement) {
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
        obj['epcList'] = ApiClient.convertToType(data['epcList'], ['String']);
      }
      if (data.hasOwnProperty('bizStep')) {
        obj['bizStep'] = ApiClient.convertToType(data['bizStep'], 'String');
      }
      if (data.hasOwnProperty('readPoint')) {
        obj['readPoint'] = ApiClient.convertToType(data['readPoint'], 'String');
      }
      if (data.hasOwnProperty('quantityList')) {
        obj['quantityList'] = ApiClient.convertToType(data['quantityList'], [QuantityElement]);
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
      if (data.hasOwnProperty('eventType')) {
        obj['eventType'] = ApiClient.convertToType(data['eventType'], 'String');
      }
      if (data.hasOwnProperty('gtin')) {
        obj['gtin'] = ApiClient.convertToType(data['gtin'], 'String');
      }
      if (data.hasOwnProperty('bricks')) {
        obj['bricks'] = ApiClient.convertToType(data['bricks'], ['String']);
      }
      if (data.hasOwnProperty('eventTime')) {
        obj['eventTime'] = ApiClient.convertToType(data['eventTime'], 'Date');
      }
      if (data.hasOwnProperty('transaction-ids')) {
        obj['transaction-ids'] = ApiClient.convertToType(data['transaction-ids'], ['String']);
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
   * An unordered list of one or more EPCs(Electronic Product Code) naming the physical objects to which the event pertained. Each element of this list SHALL be a URI [RFC2396] denoting the unique identity for a physical object.
   * @member {Array.<String>} epcList
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
   * @member {Array.<module:model/QuantityElement>} quantityList
   */
  exports.prototype['quantityList'] = undefined;
  /**
   * Event action.
   * @member {module:model/ObjectEvent.ActionEnum} action
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
   * EPCIS eventType, for Foodauthent system could be only ObjectEvent
   * @member {String} eventType
   */
  exports.prototype['eventType'] = undefined;
  /**
   * Global Trade Item Number
   * @member {String} gtin
   */
  exports.prototype['gtin'] = undefined;
  /**
   * A brick identifies a category of consumer-related products
   * @member {Array.<String>} bricks
   */
  exports.prototype['bricks'] = undefined;
  /**
   * When the event happened
   * @member {Date} eventTime
   */
  exports.prototype['eventTime'] = undefined;
  /**
   * List of discovery service transaction related to this ObjecEvent
   * @member {Array.<String>} transaction-ids
   */
  exports.prototype['transaction-ids'] = undefined;


  /**
   * Allowed values for the <code>action</code> property.
   * @enum {String}
   * @readonly
   */
  exports.ActionEnum = {
    /**
     * value: "ADD"
     * @const
     */
    "ADD": "ADD",
    /**
     * value: "OBSERVE"
     * @const
     */
    "OBSERVE": "OBSERVE",
    /**
     * value: "DELETE"
     * @const
     */
    "DELETE": "DELETE"  };


  return exports;
}));


