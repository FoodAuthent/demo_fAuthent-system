var transactionApi;
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
	  var TransactionApi = require("../generated/rest-client/src/api/TransactionApi.js");
	  transactionApi = new TransactionApi(apiClient);
}

var MyObject = function () {
  
  
  var getTransaction = function (self) {
	  	setUpApi();
	    console.log('Get ObjectEvent');
	    console.log('self Filter ',self.filter);
	    var filterArray = null;
	    if(self.filter !== null){
	    var filterArray = self.filter.replace(/^\s+|\s+$/g,"").split(/\s*,\s*/);	
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
	    transactionApi.findTransactionByKeyword(
	      opt,
	      callback
	    );
	  };
	  
	  var findTransactionById = function (self) {
		    setUpApi();
		    console.log('Search Transaction for Id: ',self.filter);
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
		    var transactionId = self.filter;
		    transactionApi.getTransactionById(
		      transactionId,
		      callback
		    );
		  };
	  

  
  var saveTransaction = function (json, self) {
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
        self.showSuccess = true;
        self.loading = false;
        console.log("API called successfully. Returned data: ", data);
      }
    };
    var opt = {
     discoveryServiceTransaction: json
    };
    transactionApi.createTransaction(
      opt,
      callback
    );
  };


  return {
	getTransaction: getTransaction,
	saveTransaction: saveTransaction,
	findTransactionById: findTransactionById
  }
}();

export default MyObject;