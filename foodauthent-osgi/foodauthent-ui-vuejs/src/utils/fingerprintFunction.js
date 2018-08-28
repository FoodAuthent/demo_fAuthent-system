var Fingerprints = function () {

  var ApiClient = require("../generated/rest-client/src/ApiClient.js");
  var apiClient = new ApiClient();
  //only for test---
  apiClient.basePath = "http://" + window.location.hostname + ":9090/v0/foodauthent";
  //only for test---
  var FingerprintApi = require("../generated/rest-client/src/api/FingerprintApi.js");
  var fingerprintApi = new FingerprintApi(apiClient);

  var getFingerprints = function (self) {
    console.log("getFingerprints");
    var callback = function (error, data, response) {
      console.log("data:", data);
      console.log("response:", response);
      if (error) {
        //this.response = data;
        console.error(error);
      } else {
        if (data) {
          var jsonResult = data.results;
          var length = jsonResult.length;
          for (var i = 0; i < length; i++) {
            // console.log(jsonResult[i]);
            jsonResult[i]['actions'] = '';
            console.log(jsonResult[i]);
          }
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
    console.log("saveFingerprints");
    var callback = function (error, data, response) {
      console.log("data:", data);
      console.log("response:", response);
      if (error) {
        //this.response = data;
        console.error(error);
        self.showError = true;
      } else {
        if (data) {
          self.items = data.results;
          self.showSuccess = true;
          console.log("API called successfully. Returned data: ", data);
        } else {
          self.items = [];
        }

      }
    };
    var fingerprintSet = json;
    fingerprintApi.createFingerprintSet(
      fingerprintSet,
      callback
    );
  }

  var deleteFingerprint = function (id, self) {
    console.log('Delete fingerprint');
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
    getFingerprints: getFingerprints,
    saveFingerprints: saveFingerprints,
    deleteFingerprint: deleteFingerprint
  }

}();

export default Fingerprints;