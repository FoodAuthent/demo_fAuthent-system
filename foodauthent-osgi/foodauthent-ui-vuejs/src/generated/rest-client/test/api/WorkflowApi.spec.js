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
    instance = new FoodAuthentSwaggerApi.WorkflowApi();
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

  describe('WorkflowApi', function() {
    describe('createPredictionJob', function() {
      it('should call createPredictionJob successfully', function(done) {
        //uncomment below and update the code to test createPredictionJob
        //instance.createPredictionJob(function(error) {
        //  if (error) throw error;
        //expect().to.be();
        //});
        done();
      });
    });
    describe('createTrainingJob', function() {
      it('should call createTrainingJob successfully', function(done) {
        //uncomment below and update the code to test createTrainingJob
        //instance.createTrainingJob(function(error) {
        //  if (error) throw error;
        //expect().to.be();
        //});
        done();
      });
    });
    describe('createWorkflow', function() {
      it('should call createWorkflow successfully', function(done) {
        //uncomment below and update the code to test createWorkflow
        //instance.createWorkflow(function(error) {
        //  if (error) throw error;
        //expect().to.be();
        //});
        done();
      });
    });
    describe('findModelByKeyword', function() {
      it('should call findModelByKeyword successfully', function(done) {
        //uncomment below and update the code to test findModelByKeyword
        //instance.findModelByKeyword(function(error) {
        //  if (error) throw error;
        //expect().to.be();
        //});
        done();
      });
    });
    describe('findPredictionJobs', function() {
      it('should call findPredictionJobs successfully', function(done) {
        //uncomment below and update the code to test findPredictionJobs
        //instance.findPredictionJobs(function(error) {
        //  if (error) throw error;
        //expect().to.be();
        //});
        done();
      });
    });
    describe('findPredictionWorkflows', function() {
      it('should call findPredictionWorkflows successfully', function(done) {
        //uncomment below and update the code to test findPredictionWorkflows
        //instance.findPredictionWorkflows(function(error) {
        //  if (error) throw error;
        //expect().to.be();
        //});
        done();
      });
    });
    describe('findTrainingJobs', function() {
      it('should call findTrainingJobs successfully', function(done) {
        //uncomment below and update the code to test findTrainingJobs
        //instance.findTrainingJobs(function(error) {
        //  if (error) throw error;
        //expect().to.be();
        //});
        done();
      });
    });
    describe('findTrainingWorkflows', function() {
      it('should call findTrainingWorkflows successfully', function(done) {
        //uncomment below and update the code to test findTrainingWorkflows
        //instance.findTrainingWorkflows(function(error) {
        //  if (error) throw error;
        //expect().to.be();
        //});
        done();
      });
    });
    describe('findWorkflowByKeyword', function() {
      it('should call findWorkflowByKeyword successfully', function(done) {
        //uncomment below and update the code to test findWorkflowByKeyword
        //instance.findWorkflowByKeyword(function(error) {
        //  if (error) throw error;
        //expect().to.be();
        //});
        done();
      });
    });
    describe('getPredictionJob', function() {
      it('should call getPredictionJob successfully', function(done) {
        //uncomment below and update the code to test getPredictionJob
        //instance.getPredictionJob(function(error) {
        //  if (error) throw error;
        //expect().to.be();
        //});
        done();
      });
    });
    describe('getPredictionResult', function() {
      it('should call getPredictionResult successfully', function(done) {
        //uncomment below and update the code to test getPredictionResult
        //instance.getPredictionResult(function(error) {
        //  if (error) throw error;
        //expect().to.be();
        //});
        done();
      });
    });
    describe('getTrainingJob', function() {
      it('should call getTrainingJob successfully', function(done) {
        //uncomment below and update the code to test getTrainingJob
        //instance.getTrainingJob(function(error) {
        //  if (error) throw error;
        //expect().to.be();
        //});
        done();
      });
    });
    describe('getWorkflowById', function() {
      it('should call getWorkflowById successfully', function(done) {
        //uncomment below and update the code to test getWorkflowById
        //instance.getWorkflowById(function(error) {
        //  if (error) throw error;
        //expect().to.be();
        //});
        done();
      });
    });
  });

}));
