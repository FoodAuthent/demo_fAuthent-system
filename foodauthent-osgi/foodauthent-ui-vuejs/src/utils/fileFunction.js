var MyObject = function () {
	  var ApiClient = require("../generated/rest-client/src/ApiClient.js");
	  var apiClient = new ApiClient();
	  //only for test---
	  apiClient.basePath = window.location.origin + "/v0/foodauthent";
	  //only for test---
	  var FileApi = require("../generated/rest-client/src/api/FileApi.js");
	  var fileApi = new FileApi(apiClient);

	
  var getFile = function (fileIdJson, self) {
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
  var createFileMetadata = function (fileJson, file, self) {
    console.log('Create File Metadata');
    var callback = function (error, data, response) {
      console.log("createFileMetadata data:", data);
      console.log("createFileMetadata response:", response);
      if (error) {
        console.error(error);
      } else {
        self.value = data;
        console.log("createFileMetadata API called successfully. Returned data: ", data);
        uploadFile(data, file, self);
      }
    };
    var fileMetadata = fileJson;
    fileApi.createFileMetadata(
      fileMetadata,
      callback
    );
  };

  var uploadFile = function (varFileId, fileJson, self) {
    console.log('Upload file');
    var callback2 = function (error, data, response) {
      console.log("uploadFile data:", data);
      console.log("uploadFile response:", response);
      if (error) {
        console.error(error);
      } else {
        self.value = data;
        console.log("uploadFile API called successfully. Returned data: ", data);
      }
    };
    var fileId = varFileId;
    var upFile = fileJson;
    fileApi.saveFileData(
      fileId,
      upFile,
      callback2
    );
  };
  
  var importFile = function (varFileId, self) {
	    console.log('Upload file');
	    var callback = function (error, data, response) {
	      console.log("ImportFile data:", data);
	      console.log("ImportFile response:", response);
	      if (error) {
	        console.error(error);
	      } else {
	        self.value = data;
	        console.log("Import file API called successfully. Returned data: ", data);
	      }
	    };
	    var fileId = varFileId;
	    fileApi.importFile(
	      fileId,
	      callback
	    );
	  };
	  
	  var exportFile = function (varFileId, self) {
		    console.log('Upload file');
		    var callback = function (error, data, response) {
		      console.log("ImportFile data:", data);
		      console.log("ImportFile response:", response);
		      if (error) {
		        console.error(error);
		      } else {
		        self.value = data;
		        console.log("Import file API called successfully. Returned data: ", data);
		      }
		    };
		    var fileType = varFileId;
		    var faObjectSet = "";
		    fileApi.importFile(
		    	fileType,
		    	faObjectSet,
		      callback
		    );
		  };
  
  

  return {
    getFile: getFile,
    createFileMetadata: createFileMetadata,
    uploadFile: uploadFile,
    importFile: importFile,
    exportFile: exportFile
    
  }
}();

export default MyObject;