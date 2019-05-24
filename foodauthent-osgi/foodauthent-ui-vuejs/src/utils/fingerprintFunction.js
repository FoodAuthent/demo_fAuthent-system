var fingerprintApi;
function setUpApi(){
	  var ApiClient = require("../generated/rest-client/src/ApiClient.js");
	  var apiClient = new ApiClient();
	  
	  if(localStorage.getItem('token')){
		  console.log("Inside the token set");
		  var headerToken = {Authorization: 'Bearer ' + localStorage.getItem('token')};
		  apiClient.defaultHeaders = headerToken;  
	  }
	  // only for test---
	  apiClient.basePath = window.location.origin + "/v0/foodauthent";
	  // only for test---
	  var FingerprintApi = require("../generated/rest-client/src/api/FingerprintApi.js");
	  fingerprintApi = new FingerprintApi(apiClient);
}

var Fingerprints = function () {
	
	var getFingerprints = function(self){
		setUpApi();
	    console.log('Get Fingerprint');
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
	      if (error) {
	        // this.response = data;
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
	    fingerprintApi.findFingerprintSetByKeyword(
	      opt,
	      callback
	    );
	  };


var findFingerprintById = function(self){
	setUpApi();
    console.log('Search Fingerprint for id: ',self.filter);
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
        // this.response = data;
        console.error(error);
      } else {
        var jsonResult = [];
        jsonResult.push(response.body);
        jsonResult[0]['actions'] = '';
        self.items = jsonResult;
        // console.log("Items For ID are: ",self.items);
        console.log("API called successfully. Returned data: ", data);
      }
    };
    var fingerprintId = self.filter;
    fingerprintApi.getFingerprintById(
    fingerprintId,
      callback
    );
  };

	
  var getFingerprintset = function (self) {
	    setUpApi();
	    console.log('Get Fingerprintset');
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
	      if (error) {
	        // this.response = data;
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
	    fingerprintApi.findFingerprintSetByKeyword(
	      opt,
	      callback
	    );
	  };


	  
  var saveFingerprints = function (json, self) {
	setUpApi();
    console.log("saveFingerprints");
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
    var fingerprintSet = json;
    fingerprintApi.createFingerprintSet(
      fingerprintSet,
      callback
    );
  };
  
	  
	  var findFingerprintSetById = function (self) {
		    setUpApi();
		    console.log('Search Fingerprint for id: ',self.filter);
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
		        // this.response = data;
		        console.error(error);
		      } else {
		        var jsonResult = [];
		        jsonResult.push(response.body);
		        jsonResult[0]['actions'] = '';
		        self.items = jsonResult;
		        // console.log("Items For ID are: ",self.items);
		        console.log("API called successfully. Returned data: ", data);
		      }
		    };
		    var fingerprintsetId = self.filter;
		    fingerprintApi.getFingerprintSetById(
		      fingerprintsetId,
		      callback
		    );
		  };


  var deleteFingerprint = function (id, self) {
	setUpApi();
    console.log('Delete fingerprint');
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
    alert("When the Api will support thie features it will work and delete this id: "+id);
    // productApi.createProduct(
    // opt,
    // callback
    // );
  };

  return {
	getFingerprintset: getFingerprintset,
	getFingerprints: getFingerprints,
    saveFingerprints: saveFingerprints,
    deleteFingerprint: deleteFingerprint,
    findFingerprintById: findFingerprintById,
    findFingerprintSetById: findFingerprintSetById
  }

}();

export default Fingerprints;