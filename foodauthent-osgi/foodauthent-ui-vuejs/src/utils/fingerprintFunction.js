var Fingerprints = function () {
  var getFingerprints = function (self) {
    var ApiClient = require("../generated/rest-client/src/ApiClient.js");
    var apiClient = new ApiClient();


    //only for test---
    apiClient.basePath = "http://" + window.location.hostname + ":9090/v0/foodauthent";
    //only for test---

    var FingerprintApi = require("../generated/rest-client/src/api/FingerprintApi.js");
    var fingerprintApi = new FingerprintApi(apiClient);
    var callback = function (error, data, response) {
      console.log("data:", data);
      console.log("response:", response);
      if (error) {
        //this.response = data;
        console.error(error);
      } else {
        if (data) {
          self.items = data.results;
          console.log("API called successfully. Returned data: ", data);
        } else {
          self.items = [];
        }

      }
    };
    var opt = {
      pageNumber: 0,
      pageSize: 10
    };
    fingerprintApi.findFingerprintSetByKeyword(
      opt,
      callback
    );
  }

   var saveFingerprints = function (json, self) {
    var ApiClient = require("../generated/rest-client/src/ApiClient.js");
    var apiClient = new ApiClient();


    //only for test---
    apiClient.basePath = "http://" + window.location.hostname + ":9090/v0/foodauthent";
    //only for test---

    var FingerprintApi = require("../generated/rest-client/src/api/FingerprintApi.js");
    var fingerprintApi = new FingerprintApi(apiClient);
    var callback = function (error, data, response) {
      console.log("data:", data);
      console.log("response:", response);
      if (error) {
        //this.response = data;
        console.error(error);
      } else {
        if (data) {
          self.items = data.results;
          console.log("API called successfully. Returned data: ", data);
        } else {
          self.items = [];
        }

      }
    };
    var fingerprintSet =  json;
    fingerprintApi.createFingerprintSet(
      fingerprintSet,
      callback
    );
  }

  return {
    getFingerprints: getFingerprints,
    saveFingerprints: saveFingerprints
  }

}();

export default Fingerprints;