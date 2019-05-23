var productApi;
var saveCustomMetadata = require("@/utils/commonFunction.js").default.saveCustomMetadata;
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
	  var ProductApi = require("../generated/rest-client/src/api/ProductApi.js");
	  productApi = new ProductApi(apiClient);
}


var MyObject = function () {
  
  var getProducts = function (self) {
	  setUpApi();
	    console.log('Get Products');
	    console.log('self Filter ',self.filter);
	    console.log('self perPage ',self.perPage);
	    console.log('self currentPage ',self.currentPage);
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
	    productApi.findProductByKeyword(
	      opt,
	      callback
	    );
	  };
	  
  
  var saveProducts = function (json, self) {
	  setUpApi();
    console.log('Save Products');
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
        console.log("Data", data);
        saveCustomMetadata(self.schemas,data);
        self.showSuccess = 5;
        self.loading = false;
        console.log("API called successfully. Returned data: ", data);
      }
    };
    var opt = {
      product: json
    };
    productApi.createProduct(
      opt,
      callback
    );
  };

    var deleteProducts = function (id, self) {
    	setUpApi();
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
     productApi.removeProductByGtin(
       id,
       callback
     );
  };
  
    var updateProducts = function (json, self) {
    	setUpApi();
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
      product: json
    };
    console.log("json:", json);
    alert("When the Api will support this features it will work and update this id: "+json["fa-id"]);
    // productApi.updateProduct(
    //   opt,
    //   callback
    // );
  };
 
	  
	  var findProductByGtin = function (self) {
		  setUpApi();
		    console.log('Search Products for Gtin: ',self.filter);
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
		    var gtin = self.filter;
		    productApi.findProductByGtin(
		      gtin,
		      callback
		    );
		  };


  return {
    getProducts: getProducts,
    saveProducts: saveProducts,
    deleteProducts: deleteProducts,
    updateProducts: updateProducts,
    findProductByGtin: findProductByGtin
  }
}();

export default MyObject;