var MyObject = function () {
  var ApiClient = require("../generated/rest-client/src/ApiClient.js");
  var apiClient = new ApiClient();
  //only for test---
  apiClient.basePath = "http://" + window.location.hostname + ":9090/v0/foodauthent";
  //only for test---
  var ProductApi = require("../generated/rest-client/src/api/ProductApi.js");
  var productApi = new ProductApi(apiClient);

  var getProducts = function (self) {
    console.log('Get Products');
    var callback = function (error, data, response) {
      console.log("data:", data);
      console.log("response:", response);
      self.resultsCount = data.resultCount;
      self.pageCount = response.body.pageCount;
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
          // console.log(jsonResult[i]);
        }
        self.items = data.results;
        console.log("API called successfully. Returned data: ", data);
      }
    };
    var opt = {
      pageNumber: self.currentPage,
      pageSize: self.perPage
    };
    productApi.findProductByKeyword(
      opt,
      callback
    );
  };
  var saveProducts = function (json, self) {
    console.log('Save Products');
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
    productApi.createProduct(
      opt,
      callback
    );
  };

    var deleteProducts = function (id, self) {
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
    alert("When the Api will support thie features it will work and delete this id: "+id);
    // productApi.deleteProduct(
    //   opt,
    //   callback
    // );
  };
  
    var updateProducts = function (json, self) {
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
  
   
  var findProductByKeyword = function (self) {
	  	//var filterArray = self.filter.split(",");
	  	var filterArray = self.filter.replace(/^\s+|\s+$/g,"").split(/\s*,\s*/);
	    //console.log('Search Products for Keywords: ',filterArray);
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
	        //this.response = data;
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
	    productApi.findProductByKeyword(
	      opt,
	      callback
	    );
	  };
	  
	  var findProductByGtin = function (self) {
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
    findProductByKeyword: findProductByKeyword,
    findProductByGtin: findProductByGtin
  }
}();

export default MyObject;