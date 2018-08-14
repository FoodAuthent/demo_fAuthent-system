var MyObject = function () {
  var getFile = function (self) {
    var ApiClient = require("../generated/rest-client/src/ApiClient.js");
    var apiClient = new ApiClient();

    //only for test---
    apiClient.basePath = "http://" + window.location.hostname + ":9090/v0/foodauthent";
    //only for test---

    var FileApi = require("../generated/rest-client/src/api/FileApi.js");
    var fileApi = new FileApi(apiClient);
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
    var fileId = "";
    fileApi.getFileData(
      fileId,
      callback
    );
  };
  var saveFile = function (json, self) {
    console.log('Save Products');
    var ApiClient = require("../generated/rest-client/src/ApiClient.js");
    var apiClient = new ApiClient();
    //only for test---
    apiClient.basePath = "http://" + window.location.hostname + ":9090/v0/foodauthent";
    //only for test---
    var FileApi = require("../generated/rest-client/src/api/FileApi.js");
    var fileApi = new FileApi(apiClient);
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
    var fileId = "";
    var file = new File();
    fileApi.saveFileData(
      fileId,
      file,
      callback
    );
  };


  return {
    getFile: getFile,
    saveFile: saveFile
  }
}();

export default MyObject;