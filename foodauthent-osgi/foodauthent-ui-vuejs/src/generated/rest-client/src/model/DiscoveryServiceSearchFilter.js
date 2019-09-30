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
    define(['../ApiClient', '../model/BizTransaction'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'), require('./BizTransaction'));
  } else {
    // Browser globals (root is window)
    if (!root.FoodAuthentSwaggerApi) {
      root.FoodAuthentSwaggerApi = {};
    }
    root.FoodAuthentSwaggerApi.DiscoveryServiceSearchFilter = factory(root.FoodAuthentSwaggerApi.ApiClient, root.FoodAuthentSwaggerApi.BizTransaction);
  }
}(this, function(ApiClient, BizTransaction) {
  'use strict';



  /**
   * The DiscoveryServiceSearchFilter model module.
   * @module model/DiscoveryServiceSearchFilter
   * @version 1.0.0
   */

  /**
   * Constructs a new <code>DiscoveryServiceSearchFilter</code>.
   * DiscoveryServiceTransactionFilter
   * @alias module:model/DiscoveryServiceSearchFilter
   * @class
   */
  var exports = function() {
    var _this = this;

  };

  /**
   * Constructs a <code>DiscoveryServiceSearchFilter</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:model/DiscoveryServiceSearchFilter} obj Optional instance to populate.
   * @return {module:model/DiscoveryServiceSearchFilter} The populated <code>DiscoveryServiceSearchFilter</code> instance.
   */
  exports.constructFromObject = function(data, obj) {
    if (data) {
      obj = obj || new exports();
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
        obj['quantityList'] = ApiClient.convertToType(data['quantityList'], ['String']);
      }
      if (data.hasOwnProperty('action')) {
        obj['action'] = ApiClient.convertToType(data['action'], 'String');
      }
      if (data.hasOwnProperty('bizTransactionList')) {
        obj['bizTransactionList'] = ApiClient.convertToType(data['bizTransactionList'], [BizTransaction]);
      }
      if (data.hasOwnProperty('disposition')) {
        obj['disposition'] = ApiClient.convertToType(data['disposition'], 'String');
      }
      if (data.hasOwnProperty('eventType')) {
        obj['eventType'] = ApiClient.convertToType(data['eventType'], 'String');
      }
      if (data.hasOwnProperty('interfaceId')) {
        obj['interfaceId'] = ApiClient.convertToType(data['interfaceId'], 'String');
      }
      if (data.hasOwnProperty('gtin')) {
        obj['gtin'] = ApiClient.convertToType(data['gtin'], 'String');
      }
      if (data.hasOwnProperty('bricks')) {
        obj['bricks'] = ApiClient.convertToType(data['bricks'], ['String']);
      }
      if (data.hasOwnProperty('eventTimeFrom')) {
        obj['eventTimeFrom'] = ApiClient.convertToType(data['eventTimeFrom'], 'Date');
      }
      if (data.hasOwnProperty('eventTimeTo')) {
        obj['eventTimeTo'] = ApiClient.convertToType(data['eventTimeTo'], 'Date');
      }
    }
    return obj;
  }

  /**
   * List of epcs
   * @member {Array.<String>} epcList
   */
  exports.prototype['epcList'] = undefined;
  /**
   * The business step of which this event was a part
   * @member {String} bizStep
   */
  exports.prototype['bizStep'] = undefined;
  /**
   * The read point at which the event took place.
   * @member {String} readPoint
   */
  exports.prototype['readPoint'] = undefined;
  /**
   * Represents quantity of entities sharing a common EPC class, but where the individual identities of the entities are not specified.
   * @member {Array.<String>} quantityList
   */
  exports.prototype['quantityList'] = undefined;
  /**
   * Event action.
   * @member {String} action
   */
  exports.prototype['action'] = undefined;
  /**
   * An unordered list of business transactions that define the context of this event(A BusinessTransaction identifies a particular business transaction. An example of a business transaction is a specific purchase order)
   * @member {Array.<module:model/BizTransaction>} bizTransactionList
   */
  exports.prototype['bizTransactionList'] = undefined;
  /**
   * The business condition of the objects associated with the EPCs, presumed to hold until contradicted by a subsequent event
   * @member {String} disposition
   */
  exports.prototype['disposition'] = undefined;
  /**
   * EPCIS eventType, for Foodauthent system could be only ObjectEvent
   * @member {String} eventType
   */
  exports.prototype['eventType'] = undefined;
  /**
   * interfaceId
   * @member {String} interfaceId
   */
  exports.prototype['interfaceId'] = undefined;
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
   * start date and time for the research. It’s an ISO 8601 format
   * @member {Date} eventTimeFrom
   */
  exports.prototype['eventTimeFrom'] = undefined;
  /**
   * end date and time for the research. It’s an ISO 8601 format
   * @member {Date} eventTimeTo
   */
  exports.prototype['eventTimeTo'] = undefined;



  return exports;
}));

