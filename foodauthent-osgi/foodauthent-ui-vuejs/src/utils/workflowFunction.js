var MyObject = function () {
  var getWorkflows = function (self) {
    var ApiClient = require("../generated/rest-client/src/ApiClient.js");
    var apiClient = new ApiClient();

    //only for test---
    apiClient.basePath = "http://" + window.location.hostname + ":9090/v0/foodauthent";
    //only for test---

    var WorkflowApi = require("../generated/rest-client/src/api/WorkflowApi.js");
    var workflowApi = new WorkflowApi(apiClient);
    var callback = function (error, data, response) {
      console.log("data:", data);
      console.log("response:", response);
      if (error) {
        //this.response = data;
        console.error(error);
      } else {
        self.items = data.results;
        console.log("API called successfully. Returned data: ", data);
      }
    };
    var opt = {
      pageNumber: 0,
      pageSize: 100
    };
    workflowApi.findWorkflowByKeyword(
      opt,
      callback
    );
  };

  var getPredictions = function (self) {
    var ApiClient = require("../generated/rest-client/src/ApiClient.js");
    var apiClient = new ApiClient();

    //only for test---
    apiClient.basePath = "http://" + window.location.hostname + ":9090/v0/foodauthent";
    //only for test---

    var WorkflowApi = require("../generated/rest-client/src/api/WorkflowApi.js");
    var workflowApi = new WorkflowApi(apiClient);
    var callback = function (error, data, response) {
      console.log("data:", data);
      console.log("response:", response);
      if (error) {
        //this.response = data;
        console.error(error);
      } else {
        self.items = data.results;
        console.log("API called successfully. Returned data: ", data);
      }
    };
    var opt = {
      pageNumber: 0,
      pageSize: 100
    };
    workflowApi.findPredictionWorkflows(
      opt,
      callback
    );
  };

  var getPredictionJobs = function (self) {
    var ApiClient = require("../generated/rest-client/src/ApiClient.js");
    var apiClient = new ApiClient();

    //only for test---
    apiClient.basePath = "http://" + window.location.hostname + ":9090/v0/foodauthent";
    //only for test---

    var WorkflowApi = require("../generated/rest-client/src/api/WorkflowApi.js");
    var workflowApi = new WorkflowApi(apiClient);
    var callback = function (error, data, response) {
      console.log("data:", data);
      console.log("response:", response);
      if (error) {
        //this.response = data;
        console.error(error);
      } else {
        self.items = data.results;
        console.log("API called successfully. Returned data: ", data);
      }
    };
    var opt = {
      pageNumber: 0,
      pageSize: 100
    };
    workflowApi.findPredictionJobs(
      opt,
      callback
    );
  };

    var getTrainingJobs = function (self) {
    var ApiClient = require("../generated/rest-client/src/ApiClient.js");
    var apiClient = new ApiClient();

    //only for test---
    apiClient.basePath = "http://" + window.location.hostname + ":9090/v0/foodauthent";
    //only for test---

    var WorkflowApi = require("../generated/rest-client/src/api/WorkflowApi.js");
    var workflowApi = new WorkflowApi(apiClient);
    var callback = function (error, data, response) {
      console.log("data:", data);
      console.log("response:", response);
      if (error) {
        //this.response = data;
        console.error(error);
      } else {
        self.items = data.results;
        console.log("API called successfully. Returned data: ", data);
      }
    };
    var opt = {
      pageNumber: 0,
      pageSize: 100
    };
    workflowApi.findTrainingJobs(
      opt,
      callback
    );
  };


  var saveWorkflow = function (json, self) {
    console.log('Save Workflow');
    var ApiClient = require("../generated/rest-client/src/ApiClient.js");
    var apiClient = new ApiClient();
    //only for test---
    apiClient.basePath = "http://" + window.location.hostname + ":9090/v0/foodauthent";
    //only for test---
    var WorkflowApi = require("../generated/rest-client/src/api/WorkflowApi.js");
    var workflowApi = new WorkflowApi(apiClient);
    var callback = function (error, data, response) {
      console.log("data:", data);
      console.log("response:", response);
      if (error) {
        console.error(error);
      } else {
        self.response = data.results;
        console.log("API called successfully. Returned data: ", data);
      }
    };
    var opt = {
      workflow: json
    };
    workflowApi.createWorkflow(
      opt,
      callback
    );
  };

    var savePredictionJob = function (json, self) {
    console.log('Save Prediction Job');
    var ApiClient = require("../generated/rest-client/src/ApiClient.js");
    var apiClient = new ApiClient();
    //only for test---
    apiClient.basePath = "http://" + window.location.hostname + ":9090/v0/foodauthent";
    //only for test---
    var WorkflowApi = require("../generated/rest-client/src/api/WorkflowApi.js");
    var workflowApi = new WorkflowApi(apiClient);
    var callback = function (error, data, response) {
      console.log("data:", data);
      console.log("response:", response);
      if (error) {
        console.error(error);
      } else {
        self.response = data.results;
        console.log("API called successfully. Returned data: ", data);
      }
    };
    //TO-DO set the right requested fields
    var opt = {
      product: json
    };
    workflowApi.createPredictionJob(
      opt,
      callback
    );
  };

  var saveTrainingJob = function (json, self) {
    console.log('Save Prediction Job');
    var ApiClient = require("../generated/rest-client/src/ApiClient.js");
    var apiClient = new ApiClient();
    //only for test---
    apiClient.basePath = "http://" + window.location.hostname + ":9090/v0/foodauthent";
    //only for test---
    var WorkflowApi = require("../generated/rest-client/src/api/WorkflowApi.js");
    var workflowApi = new WorkflowApi(apiClient);
    var callback = function (error, data, response) {
      console.log("data:", data);
      console.log("response:", response);
      if (error) {
        console.error(error);
      } else {
        self.response = data.results;
        console.log("API called successfully. Returned data: ", data);
      }
    };
    //TO-DO set the right requested fields
    var opt = {
      product: json
    };
    workflowApi.createTrainingJob(
      opt,
      callback
    );
  };


  return {
    getWorkflows: getWorkflows,
    getPredictions: getPredictions,
    getPredictionJobs: getPredictionJobs,
    getTrainingJobs: getTrainingJobs,
    savePredictionJob: savePredictionJob,
    saveTrainingJob: saveTrainingJob,
    saveWorkflow: saveWorkflow
  }
}();

export default MyObject;