var objectEventApi;
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
	  var ObjectEventApi = require("../generated/rest-client/src/api/ObjectEventApi.js");
	  objectEventApi = new ObjectEventApi(apiClient);
}

var MyObject = function () {
  
  
  var getObjectEvent = function (self) {
	  setUpApi();
	    console.log('Get ObjectEvent');
	    console.log('self Filter ',self.filter);
	    var filterArray = null;
	    if(self.filter !== null){
//	    var filterArray = self.filter.replace(/^\s+|\s+$/g,"").split(/\s*,\s*/);
	    var filterArray = self.filter.split(" ");
	    console.log("Filter are: ",filterArray);
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
	    objectEventApi.findObjectEventByKeyword(
	      opt,
	      callback
	    );
	  };
	  
	  var findObjectEventById = function (self) {
		  setUpApi();
		    console.log('Search ObjectEvent for Id: ',self.filter);
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
		        var jsonResult = [];
		        jsonResult.push(response.body);
		        jsonResult[0]['actions'] = '';
		        self.items = jsonResult;
		        console.log("Items For Id are: ",self.items);
		        console.log("API called successfully. Returned data: ", data);
		      }
		    };
		    var objecteventId = self.filter;
		    objectEventApi.getObjectEventById(
		      objecteventId,
		      callback
		    );
		  };
	  

  
  var saveObjectEvent = function (json, self) {
	  setUpApi();
    console.log('Save ObjectEvent');
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
     objectEvent: json
    };
    objectEventApi.createObjectEvent(
      opt,
      callback
    );
  };

  return {
	getObjectEvent: getObjectEvent,
    saveObjectEvent: saveObjectEvent,
    findObjectEventById: findObjectEventById
  }
}();

export default MyObject;