var MyObject = function () {
  var getModels = function (self) {
    var ApiClient = require("../generated/rest-client/src/ApiClient.js");
    var apiClient = new ApiClient();

    //only for test---
    apiClient.basePath = "http://" + window.location.hostname + ":9090/v0/foodauthent";
    //only for test---

    var ModelApi = require("../generated/rest-client/src/api/ModelApi.js");
    var modelApi = new ModelApi(apiClient);
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
    modelApi.findModelByKeyword(
      opt,
      callback
    );
  };
  var saveModel = function (json, self) {
    console.log('Save Model');
    var ApiClient = require("../generated/rest-client/src/ApiClient.js");
    var apiClient = new ApiClient();
    //only for test---
    apiClient.basePath = "http://" + window.location.hostname + ":9090/v0/foodauthent";
    //only for test---
    var ModelApi = require("../generated/rest-client/src/api/ModelApi.js");
    var modelApi = new ModelApi(apiClient);
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
      model: json
    };
    modelApi.createModel(
      opt,
      callback
    );
  };


  return {
    getModels: getModels,
    saveModel: saveModel
  }
}();

export default MyObject;