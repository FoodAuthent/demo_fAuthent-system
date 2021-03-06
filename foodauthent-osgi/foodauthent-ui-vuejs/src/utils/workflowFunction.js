var workflowApi;
function setUpApi(){
	  var ApiClient = require("../generated/rest-client/src/ApiClient.js");
	  var apiClient = new ApiClient();
	  
	  if(localStorage.getItem('token')){
		  console.log("Inside the token set");
		  var headerToken = {Authorization: 'Bearer ' + localStorage.getItem('token')};
		  apiClient.defaultHeaders = headerToken;  
	  }
	  //only for test---
	  apiClient.basePath = window.location.origin + "/v0/foodauthent";
	  //only for test---
	  var WorkflowApi = require("../generated/rest-client/src/api/WorkflowApi.js");
	  workflowApi = new WorkflowApi(apiClient);
}


var MyObject = function () {

  var getWorkflows = function (self) {
	  setUpApi();
	    console.log('Get Workflows');
	    var filterArray = null;
	    if(self.filter !== null){
//	    var filterArray = self.filter.replace(/^\s+|\s+$/g,"").split(/\s*,\s*/);
	    var filterArray = self.filter.split(" ");
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
	setUpApi();
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
	  setUpApi();
    console.log('Get  Prediction');
    var filterArray = null;
    if(self.filter !== null){
//    var filterArray = self.filter.replace(/^\s+|\s+$/g,"").split(/\s*,\s*/);
      var filterArray = self.filter.split(" ");
    }
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
      pageSize: self.perPage,
      keywords: filterArray
    };
    workflowApi.findPredictionByKeyword(
      opt,
      callback
    );
  };
  
  var findPredictionByKeyword = function (self) {
	  setUpApi();
	    var filterArray = null;
	    if(self.filter !== null){
//	    var filterArray = self.filter.replace(/^\s+|\s+$/g,"").split(/\s*,\s*/);
	    var filterArray = self.filter.split(" ");
	    }
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
	     workflowApi.findPredictionByKeyword(
	      opt,
	      callback
	    );
	  };
	  
	  var findPredictionById = function (self) {
		  setUpApi();
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
	  setUpApi();
    console.log('Get Prediction Job');
    var filterArray = null;
    if(self.filter !== null){
//    var filterArray = self.filter.replace(/^\s+|\s+$/g,"").split(/\s*,\s*/);
      var filterArray = self.filter.split(" ");
    }
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
        console.log("ITEM for prediction job are: ",self.items);
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
  
  
  
  var findPredictionJobsByKeyword = function (self) {
	  setUpApi();
	    var filterArray = null;
	    if(self.filter !== null){
//	    var filterArray = self.filter.replace(/^\s+|\s+$/g,"").split(/\s*,\s*/);
	    var filterArray = self.filter.split(" ");
	    }
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
	  setUpApi();
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
	  setUpApi();
    console.log('Get Trainingjob');
    var filterArray = null;
    if(self.filter !== null){
//    var filterArray = self.filter.replace(/^\s+|\s+$/g,"").split(/\s*,\s*/);
      var filterArray = self.filter.split(" ");
    }
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
      pageSize: self.perPage,
      keywords: filterArray
    };
    workflowApi.findTrainingJobs(
      opt,
      callback
    );
  };
  
  
  var findTrainingJobsByKeyword = function (self) {
	  setUpApi();
	    var filterArray = null;
	    if(self.filter !== null){
//	    var filterArray = self.filter.replace(/^\s+|\s+$/g,"").split(/\s*,\s*/);
	    var filterArray = self.filter.split(" ");
	    }
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
	  
	  
	  
	  var findTriningJobById = function (self) {
		  setUpApi();
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
	  setUpApi();
    console.log('Save Workflow');
    var callback = function (error, data, response) {
      console.log("data:", data);
      console.log("response:", response);
      if (error) {
        console.error(error);
        self.response = response.error.message;
        self.showError = true;
        self.loading = false;
      } else {
        self.response = data.results;
        self.showSuccess = 5;
        self.loading = false;
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
  
  
  var updatePrediction =  function (json, self) {
	  setUpApi();
	    console.log('Update prediction');
	    var idsObjectEvent =[];  
	    var tempArrayObjecEvent = json["objectevent-ids"];
	    for (var key in tempArrayObjecEvent) {
	        if (tempArrayObjecEvent.hasOwnProperty(key)) {           
	        	idsObjectEvent.push(tempArrayObjecEvent[key]["objectevent-id"]);
	        }
	    }
	    json["objectevent-ids"] = idsObjectEvent;
	    var callback = function (error, data, response) {
	      console.log("data:", data);
	      console.log("response:", response);
	      if (error) {
	        console.error(error);
	        self.showError = true;
	      } else {
	        self.response = data;
	        self.showSuccess = 5;
	        console.log("API called successfully. Returned data: ", data);
	      }
	    };
	    var opt = {
	      prediction: json
	    };
	    console.log("json:", json);
	    workflowApi.updatedPrediction(
	       opt,
	       callback
	     );
	  };

  var savePredictionJob = function (workflowId, fingerprintsetId, modelId, self) {
	  setUpApi();
    console.log('Save Prediction Job');
    var callback = function (error, data, response) {
      console.log("data:", data);
      console.log("response:", response);
      if (error) {
    	console.log("the error is: ",error)
        //console.error(error);
    	if(response){
        self.response = response.error.message;
    	} else {
    	self.response = "Error please try again: "+ error;	
    	}
        self.showError = true;
        self.loading = false;
      } else {
        self.response = data.results;
        self.showSuccess = 5;
        self.loading = false;
        console.log("API called successfully. Returned data: ", data);
      } 
    };
    var opt = {
    		objecteventIds: idsObjectEvent,
    		async: true
    };
    workflowApi.createPredictionJob(
	  workflowId,
	  fingerprintsetId,
	  modelId,
      opt,
      callback
    );
  };

  var saveTrainingJob = function (workflowId, fingerprintsetIdsBefore, self) {
	  setUpApi();
    console.log('Save Training Job');
    //just a workaround, the back end wait for a list of UUID string, not object
    var idsFingerprintset =[]; 
    try {
        for (var key in fingerprintsetIdss) {
            if (fingerprintsetIdsBefore.hasOwnProperty(key)) {           
                idsFingerprintset.push(fingerprintsetIdsBefore[key]["fingerprintset-id"]);
            }
        }
    	}
    	catch(err) {
    	  self.response = err.message;
    	  self.showError = true;
    	  self.loading = false;
    	}

    var callback = function (error, data, response) {
      console.log("data:", data);
      console.log("response:", response);
      if (error) {
        console.error(error);
        self.response = response.error.message;
        self.showError = true;
        self.loading = false;
      } else {
        self.response = data.results;
        self.showSuccess = 5;
        self.loading = false;
        console.log("API called successfully. Returned data: ", data);
      }
    };
    var opt = {
    		async: true
    };
    var fingerprintsetIds = idsFingerprintset;
    workflowApi.createTrainingJob(
     workflowId,
     fingerprintsetIds,
     opt,
      callback
    );
  };

  var deleteWorkflow = function (id, self) {
	  setUpApi();
    console.log('Delete Products');
    var callback = function (error, data, response) {
      console.log("data:", data);
      console.log("response:", response);
      if (error) {
        console.error(error);
        self.showError = true;
      } else {
        self.response = data.results;
        self.showSuccess = 5;
        console.log("API called successfully. Returned data: ", data);
      }
    };
    var opt = {
      id: id
    };
    //alert("When the Api will support thie features it will work and delete this id: " + id);
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
    findTriningJobById: findTriningJobById,
    findWorkflowById: findWorkflowById,
    updatePrediction: updatePrediction
  }
}();

export default MyObject;