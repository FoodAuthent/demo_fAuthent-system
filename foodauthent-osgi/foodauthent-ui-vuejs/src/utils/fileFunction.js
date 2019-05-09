var fileApi;
function setUpApi(){
	  var ApiClient = require("../generated/rest-client/src/ApiClient.js");
	  var apiClient = new ApiClient();
	  
	  if(localStorage.getItem('token')){
		  console.log("Inside the token set");
		  var headerToken = {Authorization: 'Bearer ' + localStorage.getItem('token')};
		  apiClient.defaultHeaders = headerToken;  
	  }
	  //only for test---
	  apiClient.basePath = window.location.origin + "/v0/foodauthent";
	  //only for test---
	  var FileApi = require("../generated/rest-client/src/api/FileApi.js");
	  fileApi = new FileApi(apiClient);
}

var MyObject = function () {
	
	
	
	  var getAllFiles = function (self) {
		setUpApi();
	    console.log('Get Files');
	    console.log('self Filter ',self.filter);
	    console.log('self perPage ',self.perPage);
	    console.log('self currentPage ',self.currentPage);
	    var filterArray = null;
	    if(self.filter !== null){
	    var filterArray = self.filter.replace(/^\s+|\s+$/g,"").split(/\s*,\s*/);	
	    }
	    console.log('Filter ',filterArray);
	    var callback = function (error, data, response) {
	      console.log("data:", data);
	      console.log("response:", response);
	      if(data !== undefined && data !== null){
	    	  self.resultsCount = data.resultCount; 
	      }else{
	    	  self.resultsCount = 0;
	      }
	      if(response.body !== null){
	    	  self.pageCount = response.body.pageCount; 
	      }else{
	    	  self.pageCount = 0;
	      }
	      if (error) {
	        //this.response = data;
	        console.error(error);
	      } else {
	        var jsonResult = data.results;
	        var length = jsonResult.length;
	        for (var i = 0; i < length; i++) {
	          // console.log(jsonResult[i]);
	          jsonResult[i]['actions'] = '';
	        }
	        self.items = data.results;
	        console.log("API called successfully. Returned data: ", data);
	      }
	    };
	    var opt = {
	      pageNumber: self.currentPage,
	      pageSize: self.perPage,
	      keywords: filterArray
	    };
	    fileApi.getAllFiles(
	      opt,
	      callback
	    );
	  };

  var getFile = function (fileIdJson, self) {
	setUpApi();
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
	setUpApi();
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
	setUpApi();
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
		setUpApi();
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
			setUpApi();
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
    exportFile: exportFile,
    getAllFiles: getAllFiles
    
  }
}();

export default MyObject;