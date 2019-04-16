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
    define(['../ApiClient', '../model/PredictionInstance'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'), require('./PredictionInstance'));
  } else {
    // Browser globals (root is window)
    if (!root.FoodAuthentSwaggerApi) {
      root.FoodAuthentSwaggerApi = {};
    }
    root.FoodAuthentSwaggerApi.Prediction = factory(root.FoodAuthentSwaggerApi.ApiClient, root.FoodAuthentSwaggerApi.PredictionInstance);
  }
}(this, function(ApiClient, PredictionInstance) {
  'use strict';



  /**
   * The Prediction model module.
   * @module model/Prediction
   * @version 1.0.0
   */

  /**
   * Constructs a new <code>Prediction</code>.
   * @alias module:model/Prediction
   * @class
   */
  var exports = function() {
    var _this = this;

  };

  /**
   * Constructs a <code>Prediction</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:model/Prediction} obj Optional instance to populate.
   * @return {module:model/Prediction} The populated <code>Prediction</code> instance.
   */
  exports.constructFromObject = function(data, obj) {
    if (data) {
      obj = obj || new exports();
      if (data.hasOwnProperty('fa-id')) {
        obj['fa-id'] = ApiClient.convertToType(data['fa-id'], 'String');
      }
      if (data.hasOwnProperty('prediction-map')) {
        obj['prediction-map'] = ApiClient.convertToType(data['prediction-map'], Object);
      }
      if (data.hasOwnProperty('workflow-id')) {
        obj['workflow-id'] = ApiClient.convertToType(data['workflow-id'], 'String');
      }
      if (data.hasOwnProperty('fingerprintset-id')) {
        obj['fingerprintset-id'] = ApiClient.convertToType(data['fingerprintset-id'], 'String');
      }
      if (data.hasOwnProperty('model-id')) {
        obj['model-id'] = ApiClient.convertToType(data['model-id'], 'String');
      }
      if (data.hasOwnProperty('class-labels')) {
        obj['class-labels'] = ApiClient.convertToType(data['class-labels'], ['String']);
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
   * The predictions for each individual fingerprint. The map key is the fingerprint-id.
   * @member {Object.<String, module:model/PredictionInstance>} prediction-map
   */
  exports.prototype['prediction-map'] = undefined;
  /**
   * Workflow used for the prediction.
   * @member {String} workflow-id
   */
  exports.prototype['workflow-id'] = undefined;
  /**
   * Id of the set the prediction has been done for.
   * @member {String} fingerprintset-id
   */
  exports.prototype['fingerprintset-id'] = undefined;
  /**
   * The model that has been used for the prediction.
   * @member {String} model-id
   */
  exports.prototype['model-id'] = undefined;
  /**
   * available class labels
   * @member {Array.<String>} class-labels
   */
  exports.prototype['class-labels'] = undefined;



  return exports;
}));


