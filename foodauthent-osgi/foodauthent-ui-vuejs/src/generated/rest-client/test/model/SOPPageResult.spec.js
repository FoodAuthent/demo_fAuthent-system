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
    instance = new FoodAuthentSwaggerApi.SOPPageResult();
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

  describe('SOPPageResult', function() {
    it('should create an instance of SOPPageResult', function() {
      // uncomment below and update the code to test SOPPageResult
      //var instane = new FoodAuthentSwaggerApi.SOPPageResult();
      //expect(instance).to.be.a(FoodAuthentSwaggerApi.SOPPageResult);
    });

    it('should have the property pageNumber (base name: "pageNumber")', function() {
      // uncomment below and update the code to test the property pageNumber
      //var instane = new FoodAuthentSwaggerApi.SOPPageResult();
      //expect(instance).to.be();
    });

    it('should have the property pageCount (base name: "pageCount")', function() {
      // uncomment below and update the code to test the property pageCount
      //var instane = new FoodAuthentSwaggerApi.SOPPageResult();
      //expect(instance).to.be();
    });

    it('should have the property resultCount (base name: "resultCount")', function() {
      // uncomment below and update the code to test the property resultCount
      //var instane = new FoodAuthentSwaggerApi.SOPPageResult();
      //expect(instance).to.be();
    });

    it('should have the property results (base name: "results")', function() {
      // uncomment below and update the code to test the property results
      //var instane = new FoodAuthentSwaggerApi.SOPPageResult();
      //expect(instance).to.be();
    });

  });

}));
