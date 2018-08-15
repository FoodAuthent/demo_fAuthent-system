var MyObject = function () {

    var ApiClient = require("../generated/rest-client/src/ApiClient.js");
    var apiClient = new ApiClient();
    apiClient.basePath = "http://" + window.location.hostname + ":9090/v0/foodauthent";
    var FileApi = require("../generated/rest-client/src/api/FileApi.js");
    var fileApi = new FileApi(apiClient);

  var getFile = function (fileIdJson,self) {
    console.log('Get File');
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
    var fileId = fileIdJson;
    fileApi.getFileData(
      fileId,
      callback
    );
  };
  var createFileMetadata = function (fileJson, self) {
    console.log('Create File Metadata');
    var callback = function (error, data, response) {
      console.log("data:", data);
      console.log("response:", response);
      if (error) {
        console.error(error);
      } else {
        self.value = response;
        console.log("API called successfully. Returned data: ", data);
      }
    };
    var fileMetadata = fileJson;
    fileApi.createFileMetadata(
      fileMetadata,
      callback
    );
  };

    var uploadFile = function (fileIdJson, fileJson, self) {
    console.log('Upload file');
    var callback = function (error, data, response) {
      console.log("data:", data);
      console.log("response:", response);
      if (error) {
        console.error(error);
      } else {
        self.value = data;
        console.log("API called successfully. Returned data: ", data);
      }
    };
    var fileId = "f55f28aa-73cb-4700-bec6-a8e741b69f52";
    var upFile = fileJson;
    fileApi.saveFileData(
      fileId,
      upFile,
      callback
    );
  };


  return {
    getFile: getFile,
    createFileMetadata: createFileMetadata,
    uploadFile: uploadFile
  }
}();

export default MyObject;