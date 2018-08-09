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
    // AMD.
    define(['expect.js', '../../src/index'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    factory(require('expect.js'), require('../../src/index'));
  } else {
    // Browser globals (root is window)
    factory(root.expect, root.FoodAuthentSwaggerApi);
  }
}(this, function(expect, FoodAuthentSwaggerApi) {
  'use strict';

  var instance;

  beforeEach(function() {
    instance = new FoodAuthentSwaggerApi.Fingerprint();
  });

  var getProperty = function(object, getter, property) {
    // Use getter method if present; otherwise, get the property directly.
    if (typeof object[getter] === 'function')
      return object[getter]();
    else
      return object[property];
  }

  var setProperty = function(object, setter, property, value) {
    // Use setter method if present; otherwise, set the property directly.
    if (typeof object[setter] === 'function')
      object[setter](value);
    else
      object[property] = value;
  }

  describe('Fingerprint', function() {
    it('should create an instance of Fingerprint', function() {
      // uncomment below and update the code to test Fingerprint
      //var instane = new FoodAuthentSwaggerApi.Fingerprint();
      //expect(instance).to.be.a(FoodAuthentSwaggerApi.Fingerprint);
    });

    it('should have the property faId (base name: "fa-id")', function() {
      // uncomment below and update the code to test the property faId
      //var instane = new FoodAuthentSwaggerApi.Fingerprint();
      //expect(instance).to.be();
    });

    it('should have the property metadata (base name: "metadata")', function() {
      // uncomment below and update the code to test the property metadata
      //var instane = new FoodAuthentSwaggerApi.Fingerprint();
      //expect(instance).to.be();
    });

    it('should have the property additionalProperties (base name: "additional-properties")', function() {
      // uncomment below and update the code to test the property additionalProperties
      //var instane = new FoodAuthentSwaggerApi.Fingerprint();
      //expect(instance).to.be();
    });

  });

}));