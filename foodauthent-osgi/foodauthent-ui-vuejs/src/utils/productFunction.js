var MyObject = function () {
  var getProducts = function (self) {
    var ApiClient = require("../generated/rest-client/src/ApiClient.js");
    var apiClient = new ApiClient();

    //only for test---
    apiClient.basePath = "http://" + window.location.hostname + ":9090/v0/foodauthent";
    //only for test---

    var ProductApi = require("../generated/rest-client/src/api/ProductApi.js");
    var productApi = new ProductApi(apiClient);
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
    productApi.findProductByKeyword(
      opt,
      callback
    );
  };
  var saveProducts = function (json, self) {
    console.log('Save Products');
    var ApiClient = require("../generated/rest-client/src/ApiClient.js");
    var apiClient = new ApiClient();
    //only for test---
    apiClient.basePath = "http://" + window.location.hostname + ":9090/v0/foodauthent";
    //only for test---
    var ProductApi = require("../generated/rest-client/src/api/ProductApi.js");
    var productApi = new ProductApi(apiClient);
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
      product: json
    };
    productApi.createProduct(
      opt,
      callback
    );
  };


  return {
    getProducts: getProducts,
    saveProducts: saveProducts
  }
}();

export default MyObject;