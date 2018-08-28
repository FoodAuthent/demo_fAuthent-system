var MyObject = function () {
  var ApiClient = require("../generated/rest-client/src/ApiClient.js");
  var apiClient = new ApiClient();
  //only for test---
  apiClient.basePath = "http://" + window.location.hostname + ":9090/v0/foodauthent";
  //only for test---
  var ModelApi = require("../generated/rest-client/src/api/ModelApi.js");
  var modelApi = new ModelApi(apiClient);

  var getModels = function (self) {
    console.log('Get Model');
    var callback = function (error, data, response) {
      console.log("data:", data);
      console.log("response:", response);
      if (error) {
        //this.response = data;
        console.error(error);
      } else {
        var jsonResult = data.results;
        // console.log("json results:",jsonResult);
        var length = jsonResult.length;
        for (var i = 0; i < length; i++) {
          // console.log(jsonResult[i]);
          jsonResult[i]['actions'] = '';
          console.log(jsonResult[i]);
        }
        self.items = data.results;
        console.log("API called successfully. Returned data: ", data);
      }
    };
    var opt = {
      pageNumber: 0,
      pageSize: 100
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
        self.showError = true;
      } else {
        self.response = data.results;
        self.showSuccess = true;
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


  return {
    getModels: getModels,
    saveModel: saveModel,
    deleteModel: deleteModel
  }
}();

export default MyObject;