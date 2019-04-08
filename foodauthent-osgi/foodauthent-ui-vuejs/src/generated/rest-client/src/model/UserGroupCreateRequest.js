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
    define(['../ApiClient', '../model/UserGroupBase'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'), require('./UserGroupBase'));
  } else {
    // Browser globals (root is window)
    if (!root.FoodAuthentSwaggerApi) {
      root.FoodAuthentSwaggerApi = {};
    }
    root.FoodAuthentSwaggerApi.UserGroupCreateRequest = factory(root.FoodAuthentSwaggerApi.ApiClient, root.FoodAuthentSwaggerApi.UserGroupBase);
  }
}(this, function(ApiClient, UserGroupBase) {
  'use strict';



  /**
   * The UserGroupCreateRequest model module.
   * @module model/UserGroupCreateRequest
   * @version 1.0.0
   */

  /**
   * Constructs a new <code>UserGroupCreateRequest</code>.
   * UserGroup Object for creating new groups
   * @alias module:model/UserGroupCreateRequest
   * @class
   * @extends module:model/UserGroupBase
   * @implements module:model/UserGroupBase
   * @param members {} list of members user dn
   * @param name {} unique group name
   */
  var exports = function(members, name) {
    var _this = this;

    UserGroupBase.call(_this, members);
    _this['name'] = name;
  };

  /**
   * Constructs a <code>UserGroupCreateRequest</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:model/UserGroupCreateRequest} obj Optional instance to populate.
   * @return {module:model/UserGroupCreateRequest} The populated <code>UserGroupCreateRequest</code> instance.
   */
  exports.constructFromObject = function(data, obj) {
    if (data) {
      obj = obj || new exports();
      UserGroupBase.constructFromObject(data, obj);
      if (data.hasOwnProperty('name')) {
        obj['name'] = ApiClient.convertToType(data['name'], 'String');
      }
    }
    return obj;
  }

  exports.prototype = Object.create(UserGroupBase.prototype);
  exports.prototype.constructor = exports;

  /**
   * unique group name
   * @member {String} name
   */
  exports.prototype['name'] = undefined;

  // Implement UserGroupBase interface:
  /**
   * verbose description
   * @member {String} description
   */
exports.prototype['description'] = undefined;

  /**
   * list of members user dn
   * @member {Array.<String>} members
   */
exports.prototype['members'] = undefined;



  return exports;
}));

