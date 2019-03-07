var MyObject = function () {

  var ApiClient = require("../generated/rest-client/src/ApiClient.js");
  var apiClient = new ApiClient();
  //only for test---
  apiClient.basePath = window.location.origin + "/v0/foodauthent";
  //only for test---
  var SopApi = require("../generated/rest-client/src/api/SopApi.js");
  var sopApi = new SopApi(apiClient);

  
  var getSops = function (self) {
	    console.log('Get SOPs');
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
	    sopApi.findSOPByKeyword(
	      opt,
	      callback
	    );
	  };
	  
 
  var saveSop = function (json, self) {
    console.log('Save Sop');
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
    var sop = json;
    sopApi.createNewSOP(
      sop,
      callback
    );
  };
  
 
	  
	  var findSopById = function (self) {
		    console.log('Search SOP for id: ',self.filter);
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
		       // var length = data.lenght;
		       // for (var i = 0; i < length; i++) {
		       //   jsonResult[i]['actions'] = '';
		       // }
		        self.items = jsonResult;
		        console.log("Items For GTIN are: ",self.items);
		        console.log("API called successfully. Returned data: ", data);
		      }
		    };
		    var sopId = self.filter;
		    sopApi.getSOPById(
		      sopId,
		      callback
		    );
		  };

  
  var deleteSop = function (id, self) {
	    var callback = function (error, data, response) {
	      console.log("data:", data);
	      console.log("response:", response);
	      if (error) {
	        console.error(error);
	        self.showError = 5;
	      } else {
	        //self.response = data.results;
	        self.showSuccess = 5;
	        console.log("API called successfully. Returned data: ", data);
	      }
	    };
	    sopApi.removeSOPById(
	       id,
	       callback
	     );
	  };
  
  var updateSop = function (json, self) {
	    console.log('Update Products');
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
	      sop: json
	    };
	    console.log("json:", json);
	    alert("When the Api will support this features it will work and update this id: "+json["fa-id"]);
	    // productApi.updateProduct(
	    //   opt,
	    //   callback
	    // );
	  };


  return {
    getSops: getSops,
    saveSop: saveSop,
    deleteSop: deleteSop,
    updateSop: updateSop,
    findSopById: findSopById
  }
}();

export default MyObject;