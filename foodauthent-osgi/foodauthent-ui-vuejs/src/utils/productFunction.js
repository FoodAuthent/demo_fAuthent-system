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
      pageNumber: 1,
      pageSize: 100
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


  return {
    getProducts: getProducts,
    saveProducts: saveProducts,
    deleteProducts: deleteProducts,
    updateProducts: updateProducts
  }
}();

export default MyObject;