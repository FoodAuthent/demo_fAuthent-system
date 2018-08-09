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
    define(['../ApiClient', '../model/WorkflowParameter'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'), require('./WorkflowParameter'));
  } else {
    // Browser globals (root is window)
    if (!root.FoodAuthentSwaggerApi) {
      root.FoodAuthentSwaggerApi = {};
    }
    root.FoodAuthentSwaggerApi.WorkflowModuleInput = factory(root.FoodAuthentSwaggerApi.ApiClient, root.FoodAuthentSwaggerApi.WorkflowParameter);
  }
}(this, function(ApiClient, WorkflowParameter) {
  'use strict';




  /**
   * The WorkflowModuleInput model module.
   * @module model/WorkflowModuleInput
   * @version 1.0.0
   */

  /**
   * Constructs a new <code>WorkflowModuleInput</code>.
   * Input for a workflow module.
   * @alias module:model/WorkflowModuleInput
   * @class
   */
  var exports = function() {
    var _this = this;




  };

  /**
   * Constructs a <code>WorkflowModuleInput</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:model/WorkflowModuleInput} obj Optional instance to populate.
   * @return {module:model/WorkflowModuleInput} The populated <code>WorkflowModuleInput</code> instance.
   */
  exports.constructFromObject = function(data, obj) {
    if (data) {
      obj = obj || new exports();

      if (data.hasOwnProperty('workflow-URI')) {
        obj['workflow-URI'] = ApiClient.convertToType(data['workflow-URI'], 'String');
      }
      if (data.hasOwnProperty('module-type')) {
        obj['module-type'] = ApiClient.convertToType(data['module-type'], 'String');
      }
      if (data.hasOwnProperty('module-parameters')) {
        obj['module-parameters'] = ApiClient.convertToType(data['module-parameters'], [WorkflowParameter]);
      }
    }
    return obj;
  }

  /**
   * URI of the workflow to use.
   * @member {String} workflow-URI
   */
  exports.prototype['workflow-URI'] = undefined;
  /**
   * The type of the module.
   * @member {module:model/WorkflowModuleInput.ModuleTypeEnum} module-type
   */
  exports.prototype['module-type'] = undefined;
  /**
   * The parameters required for the module.
   * @member {Array.<module:model/WorkflowParameter>} module-parameters
   */
  exports.prototype['module-parameters'] = undefined;


  /**
   * Allowed values for the <code>module-type</code> property.
   * @enum {String}
   * @readonly
   */
  exports.ModuleTypeEnum = {
    /**
     * value: "read"
     * @const
     */
    "read": "read",
    /**
     * value: "transform_signal"
     * @const
     */
    "transform_signal": "transform_signal",
    /**
     * value: "binning"
     * @const
     */
    "binning": "binning",
    /**
     * value: "transform_sample"
     * @const
     */
    "transform_sample": "transform_sample",
    /**
     * value: "predict"
     * @const
     */
    "predict": "predict",
    /**
     * value: "train"
     * @const
     */
    "train": "train"  };


  return exports;
}));


