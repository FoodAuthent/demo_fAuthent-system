var MyObject = function () {
  var ApiClient = require("../generated/rest-client/src/ApiClient.js");
  var apiClient = new ApiClient();
  //only for test---
  apiClient.basePath = window.location.origin + "/v0/foodauthent";
  //only for test---
  var ModelApi = require("../generated/rest-client/src/api/ModelApi.js");
  var modelApi = new ModelApi(apiClient);
  
  
  var getModels = function (self) {
	    console.log('Get Models');
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
	    modelApi.findModelByKeyword(
	      opt,
	      callback
	    );
	  };
	  

  
  var saveModel = function (json, self) {
    console.log('Save Model');
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
      model: json
    };
    modelApi.createModel(
      opt,
      callback
    );
  };

    var deleteModel = function (id, self) {
    console.log('Delete model');
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
    //   opt,
    //   callback
    // );
  };
  
  
	  
	  var findModelById = function (self) {
		    console.log('Search Model for Id: ',self.filter);
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
		    var modelId = self.filter;
		    modelApi.getModelById(
		      modelId,
		      callback
		    );
		  };
  
  var updateModel = function (json, self) {
	    console.log('Update Model');
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
	      product: json
	    };
	    console.log("json:", json);
	    alert("When the Api will support this features it will work and update this id: "+json["fa-id"]);
	    // productApi.updateModel(
	    //   opt,
	    //   callback
	    // );
	  };


  return {
    getModels: getModels,
    saveModel: saveModel,
    deleteModel: deleteModel,
    updateModel: updateModel,
    findModelById: findModelById
  }
}();

export default MyObject;