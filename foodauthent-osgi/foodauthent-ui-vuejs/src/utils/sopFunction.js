var MyObject = function () {
  var getSops = function (self) {
    var ApiClient = require("../generated/rest-client/src/ApiClient.js");
    var apiClient = new ApiClient();

    //only for test---
    apiClient.basePath = "http://" + window.location.hostname + ":9090/v0/foodauthent";
    //only for test---

    var SopApi = require("../generated/rest-client/src/api/SopApi.js");
    var sopApi = new SopApi(apiClient);
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
    sopApi.findSOPByKeyword(
      opt,
      callback
    );
  };
  var saveSop = function (json, self) {
    console.log('Save Sop');
    var ApiClient = require("../generated/rest-client/src/ApiClient.js");
    var apiClient = new ApiClient();
    //only for test---
    apiClient.basePath = "http://" + window.location.hostname + ":9090/v0/foodauthent";
    //only for test---
    var SopApi = require("../generated/rest-client/src/api/SopApi.js");
    var sopApi = new SopApi(apiClient);
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
    var sop = json;
    sopApi.createNewSOP(
      sop,
      callback
    );
  };


  return {
    getSops: getSops,
    saveSop: saveSop
  }
}();

export default MyObject;