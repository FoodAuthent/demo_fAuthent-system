var MyObject = function () {
  var ApiClient = require("../generated/rest-client/src/ApiClient.js");
  var apiClient = new ApiClient();
  //only for test---
  apiClient.basePath = window.location.origin + "/v0/foodauthent";
  //only for test---
  var WorkflowApi = require("../generated/rest-client/src/api/WorkflowApi.js");
  var workflowApi = new WorkflowApi(apiClient);
  
  
  var getWorkflows = function (self) {
	    console.log('Get Workflows');
	    console.log('self Filter ',self.filter);
	    var filterArray = null;
	    if(self.filter !== null){
	    var filterArray = self.filter.replace(/^\s+|\s+$/g,"").split(/\s*,\s*/);	
	    }
	    console.log('Filter ',filterArray);
	    var callback = function (error, data, response) {
	      console.log("data:", data);
	      console.log("response:", response);
	      if(data !== undefined && data !== null){
	    	  self.resultsCount = data.resultCount; 
	      }else{
	    	  self.resultsCount = 0;
	      }
	      if(response.body !== null){
	    	  self.pageCount = response.body.pageCount; 
	      }else{
	    	  self.pageCount = 0;
	      }
	      console.log("Page count", response.body.pageCount);
	      if (error) {
	        //this.response = data;
	        console.error(error);
	      } else {
	        var jsonResult = data.results;
	        var length = jsonResult.length;
	        for (var i = 0; i < length; i++) {
	          // console.log(jsonResult[i]);
	          jsonResult[i]['actions'] = '';
	        }
	        self.items = data.results;
	        console.log("API called successfully. Returned data: ", data);
	      }
	    };
	    var opt = {
	      pageNumber: self.currentPage,
	      pageSize: self.perPage,
	      keywords: filterArray
	    };
	    workflowApi.findWorkflowByKeyword(
	      opt,
	      callback
	    );
	  };

  

var findWorkflowById = function (self) {
    console.log('Search Workflow for ID: ',self.filter);
    var callback = function (error, data, response) {
      console.log("data:", data);
      console.log("response:", response);
      if(data !== undefined && data !== null){
    	  self.resultsCount = data.resultCount; 
      }else{
    	  self.resultsCount = 0;
      }
      if(response.body !== null){
    	  self.pageCount = response.body.pageCount; 
      }else{
    	  self.pageCount = 0;
      }
      if (error) {
        //this.response = data;
        console.error(error);
        self.items=[];
      } else {
        var jsonResult = [];
        jsonResult.push(response.body);
        jsonResult[0]['actions'] = '';
        self.items = jsonResult;
        console.log("Items For ID are: ",self.items);
        console.log("API called successfully. Returned data: ", data);
      }
    };
    var workflowId = self.filter;
    workflowApi.getWorkflowById(
     workflowId,
      callback
    );
  };


  var getPredictions = function (self) {
    console.log('Get  Prediction');
    var callback = function (error, data, response) {
      console.log("data:", data);
      console.log("response:", response);
      if(data !== undefined && data !== null){
    	  self.resultsCount = data.resultCount; 
      }else{
    	  self.resultsCount = 0;
      }
      if(response.body !== null){
    	  self.pageCount = response.body.pageCount; 
      }else{
    	  self.pageCount = 0;
      }
      if (error) {
        //this.response = data;
        console.error(error);
      } else {
        self.items = data.results;
        console.log("API called successfully. Returned data: ", data);
      }
    };
    var opt = {
      pageNumber: self.currentPage,
      pageSize: self.perPage
    };
    workflowApi.findPredictionWorkflows(
      opt,
      callback
    );
  };
  
  var findPredictionByKeyword = function (self) {
	  	var filterArray = self.filter.replace(/^\s+|\s+$/g,"").split(/\s*,\s*/);
	    console.log('Search Prediction for Keywords: ',filterArray);
	    var callback = function (error, data, response) {
	      if(data !== undefined && data !== null){
	    	  self.resultsCount = data.resultCount; 
	      }else{
	    	  self.resultsCount = 0;
	      }
	      if(response.body !== null){
	    	  self.pageCount = response.body.pageCount; 
	      }else{
	    	  self.pageCount = 0;
	      }
	      if (error) {
	        console.error(error);
	      } else {
	        var jsonResult = data.results;
	        var length = jsonResult.length;
	        for (var i = 0; i < length; i++) {
	          jsonResult[i]['actions'] = '';
	        }
	        self.items = data.results;
	        //console.log("Items For KEYWORDS are: ",self.items);
	        console.log("API called successfully. Returned data: ", data);
	      }
	    };
	    var opt = {
	      pageNumber: self.currentPage,
	      pageSize: self.perPage,
	      keywords: filterArray
	    };
	     workflowApi.findPredictionWorkflows(
	      opt,
	      callback
	    );
	  };
	  
	  var findPredictionById = function (self) {
		    console.log('Search Prediction for ID: ',self.filter);
		    var callback = function (error, data, response) {
		      console.log("data:", data);
		      console.log("response:", response);
		      if(data !== undefined && data !== null){
		    	  self.resultsCount = data.resultCount; 
		      }else{
		    	  self.resultsCount = 0;
		      }
		      if(response.body !== null){
		    	  self.pageCount = response.body.pageCount; 
		      }else{
		    	  self.pageCount = 0;
		      }
		      if (error) {
		        //this.response = data;
		        console.error(error);
		        self.items=[];
		      } else {
		        var jsonResult = [];
		        jsonResult.push(response.body);
		        jsonResult[0]['actions'] = '';
		        self.items = jsonResult;
		        console.log("Items For GTIN are: ",self.items);
		        console.log("API called successfully. Returned data: ", data);
		      }
		    };
		    var predictionId = self.filter;
		    workflowApi.getPredictionResult(
		      predictionId,
		      callback
		    );
		  };

  var getPredictionJobs = function (self) {
    console.log('Get Prediction Job');
    var callback = function (error, data, response) {
      console.log("data:", data);
      console.log("response:", response);
      if(data !== undefined && data !== null){
    	  self.resultsCount = data.resultCount; 
      }else{
    	  self.resultsCount = 0;
      }
      if(response.body !== null){
    	  self.pageCount = response.body.pageCount; 
      }else{
    	  self.pageCount = 0;
      }
      if (error) {
        //this.response = data;
        console.error(error);
      } else {
        self.items = data.results;
        console.log("API called successfully. Returned data: ", data);
      }
    };
    var opt = {
    pageNumber: self.currentPage,
    pageSize: self.perPage
    };
    workflowApi.findPredictionJobs(
      opt,
      callback
    );
  };
  
  
  
  var findPredictionJobsByKeyword = function (self) {
	  	var filterArray = self.filter.replace(/^\s+|\s+$/g,"").split(/\s*,\s*/);
	    console.log('Search Prediction for Keywords: ',filterArray);
	    var callback = function (error, data, response) {
	      if(data !== undefined && data !== null){
	    	  self.resultsCount = data.resultCount; 
	      }else{
	    	  self.resultsCount = 0;
	      }
	      if(response.body !== null){
	    	  self.pageCount = response.body.pageCount; 
	      }else{
	    	  self.pageCount = 0;
	      }
	      if (error) {
	        console.error(error);
	      } else {
	        var jsonResult = data.results;
	        var length = jsonResult.length;
	        for (var i = 0; i < length; i++) {
	          jsonResult[i]['actions'] = '';
	        }
	        self.items = data.results;
	        //console.log("Items For KEYWORDS are: ",self.items);
	        console.log("API called successfully. Returned data: ", data);
	      }
	    };
	    var opt = {
	      pageNumber: self.currentPage,
	      pageSize: self.perPage,
	      keywords: filterArray
	    };
	     workflowApi.findPredictionJobs(
	      opt,
	      callback
	    );
	  };
  
 
  var findPredictionJobById = function (self) {
	    console.log('Search Prediction for ID: ',self.filter);
	    var callback = function (error, data, response) {
	      console.log("data:", data);
	      console.log("response:", response);
	      if(data !== undefined && data !== null){
	    	  self.resultsCount = data.resultCount; 
	      }else{
	    	  self.resultsCount = 0;
	      }
	      if(response.body !== null){
	    	  self.pageCount = response.body.pageCount; 
	      }else{
	    	  self.pageCount = 0;
	      }
	      if (error) {
	        //this.response = data;
	        console.error(error);
	        self.items=[];
	      } else {
	        var jsonResult = [];
	        jsonResult.push(response.body);
	        jsonResult[0]['actions'] = '';
	        self.items = jsonResult;
	        console.log("Items For GTIN are: ",self.items);
	        console.log("API called successfully. Returned data: ", data);
	      }
	    };
	    var jobId = self.filter;
	    workflowApi.getPredictionJob(
	      jobId,
	      callback
	    );
	  };
	  

  var getTrainingJobs = function (self) {
    console.log('Get Trainingjob');
    var callback = function (error, data, response) {
      console.log("data:", data);
      console.log("response:", response);
      if(data !== undefined && data !== null){
    	  self.resultsCount = data.resultCount; 
      }else{
    	  self.resultsCount = 0;
      }
      if(response.body !== null){
    	  self.pageCount = response.body.pageCount; 
      }else{
    	  self.pageCount = 0;
      }
      if (error) {
        //this.response = data;
        console.error(error);
      } else {
        self.items = data.results;
        console.log("API called successfully. Returned data: ", data);
      }
    };
    var opt = {
      pageNumber: self.currentPage,
      pageSize: self.perPage
    };
    workflowApi.findTrainingJobs(
      opt,
      callback
    );
  };
  
  
  var findTrainingJobsByKeyword = function (self) {
	  	var filterArray = self.filter.replace(/^\s+|\s+$/g,"").split(/\s*,\s*/);
	    console.log('Search Training JOb for Keywords: ',filterArray);
	    var callback = function (error, data, response) {
	      if(data !== undefined && data !== null){
	    	  self.resultsCount = data.resultCount; 
	      }else{
	    	  self.resultsCount = 0;
	      }
	      if(response.body !== null){
	    	  self.pageCount = response.body.pageCount; 
	      }else{
	    	  self.pageCount = 0;
	      }
	      if (error) {
	        console.error(error);
	      } else {
	        var jsonResult = data.results;
	        var length = jsonResult.length;
	        for (var i = 0; i < length; i++) {
	          jsonResult[i]['actions'] = '';
	        }
	        self.items = data.results;
	        //console.log("Items For KEYWORDS are: ",self.items);
	        console.log("API called successfully. Returned data: ", data);
	      }
	    };
	    var opt = {
	      pageNumber: self.currentPage,
	      pageSize: self.perPage,
	      keywords: filterArray
	    };
	     workflowApi.findTrainingJobs(
	      opt,
	      callback
	    );
	  };
	  
	  
	  
	  var findPredictionJobById = function (self) {
		    console.log('Search Training Job for ID: ',self.filter);
		    var callback = function (error, data, response) {
		      console.log("data:", data);
		      console.log("response:", response);
		      if(data !== undefined && data !== null){
		    	  self.resultsCount = data.resultCount; 
		      }else{
		    	  self.resultsCount = 0;
		      }
		      if(response.body !== null){
		    	  self.pageCount = response.body.pageCount; 
		      }else{
		    	  self.pageCount = 0;
		      }
		      if (error) {
		        //this.response = data;
		        console.error(error);
		        self.items=[];
		      } else {
		        var jsonResult = [];
		        jsonResult.push(response.body);
		        jsonResult[0]['actions'] = '';
		        self.items = jsonResult;
		        console.log("Items For ID are: ",self.items);
		        console.log("API called successfully. Returned data: ", data);
		      }
		    };
		    var jobId = self.filter;
		    workflowApi.getTrainingJob(
		      jobId,
		      callback
		    );
		  };


  var saveWorkflow = function (json, self) {
    console.log('Save Workflow');
    var callback = function (error, data, response) {
      console.log("data:", data);
      console.log("response:", response);
      if (error) {
        console.error(error);
        self.showError = 5;
      } else {
        self.response = data.results;
        self.showSuccess = 5;
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
    var callback = function (error, data, response) {
      console.log("data:", data);
      console.log("response:", response);
      if (error) {
        console.error(error);
        self.showError = 5;
      } else {
        self.response = data.results;
        self.showSuccess = 5;
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
    var callback = function (error, data, response) {
      console.log("data:", data);
      console.log("response:", response);
      if (error) {
        console.error(error);
        self.showError = 5;
      } else {
        self.response = data.results;
        self.showSuccess = 5;
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

  var deleteWorkflow = function (id, self) {
    console.log('Delete Products');
    var callback = function (error, data, response) {
      console.log("data:", data);
      console.log("response:", response);
      if (error) {
        console.error(error);
        self.showError = true;
      } else {
        self.response = data.results;
        self.showSuccess = true;
        console.log("API called successfully. Returned data: ", data);
      }
    };
    var opt = {
      id: id
    };
    alert("When the Api will support thie features it will work and delete this id: " + id);
    // productApi.createProduct(
    //   opt,
    //   callback
    // );
  };


  return {
    getWorkflows: getWorkflows,
    getPredictions: getPredictions,
    getPredictionJobs: getPredictionJobs,
    getTrainingJobs: getTrainingJobs,
    savePredictionJob: savePredictionJob,
    saveTrainingJob: saveTrainingJob,
    saveWorkflow: saveWorkflow,
    deleteWorkflow: deleteWorkflow,
    findPredictionById: findPredictionById,
    findPredictionByKeyword: findPredictionByKeyword,
    findPredictionJobById: findPredictionJobById,
    findPredictionJobsByKeyword: findPredictionJobsByKeyword,
    findTrainingJobsByKeyword: findTrainingJobsByKeyword,
    findPredictionJobById: findPredictionJobById,
    findWorkflowById: findWorkflowById
  }
}();

export default MyObject;