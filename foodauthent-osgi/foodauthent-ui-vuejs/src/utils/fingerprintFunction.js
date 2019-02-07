var Fingerprints = function () {

  var ApiClient = require("../generated/rest-client/src/ApiClient.js");
  var apiClient = new ApiClient();
  // only for test---
  apiClient.basePath = "http://" + window.location.hostname + ":9090/v0/foodauthent";
  // only for test---
  var FingerprintApi = require("../generated/rest-client/src/api/FingerprintApi.js");
  var fingerprintApi = new FingerprintApi(apiClient);
////////////
  var CustomMetadataApi = require("@/generated/rest-client/src/api/CustomMetadataApi.js");
  var customMetadataApi = new CustomMetadataApi(apiClient);

  var getModelSchemas = function(modelID,schemas){
	  var getCustomMetadataSchemasCallback = function (error, data, response) {
		  if (error) {
	        console.error("getCustomMetadataSchemasCallback error",error);
	      } else {
	        var schemasArray = data;
	        
	        var length = schemasArray.length;
	        for (var i = 0; i < length; i++) {
		        	let schemaID = schemasArray[i];
	        		var getCustomMetadataSchemaCallback = function (schemaerror, schemadata, schemaresponse) {
	        			
	        			  if (schemaerror) {
	        		        console.error("getCustomMetadataSchemaCallback error",schemaerror);
	        		      } else {
	        		        
	        		        var title = schemadata.title;
	        		        var nestedSchema = schemadata.properties;
	        		        var nestedSchemaKeys = Object.keys(schemadata.properties);
	        		        var nestedlength = nestedSchemaKeys.length;
	        		        
	        		        for (var nestedindex = 0; nestedindex < nestedlength; nestedindex++) {
	        		        		var currentSchema = nestedSchema[nestedSchemaKeys[nestedindex]];
	        		        		var newUISchema = {"fields" : []}
	    	        		        	var newUIFields = []
	        		        		var newtitle = schemadata.title;
	        		        		
	    	        		        var fields = currentSchema.properties;
	    	        		        var fieldsKeys = Object.keys(currentSchema.properties);
	    	        		        var fieldslength = fieldsKeys.length;
	    	        		        for (var fieldsindex = 0; fieldsindex < fieldslength; fieldsindex++) {
	    	        		        		//TODO make Field JSON element
	    	        		        		var currentField = fields[fieldsKeys[fieldsindex]];
	    	        		        		//console.log(currentField);
	    	        		        		var UIField ;
	    	        		        		switch(currentField.type){
	    	        		        		case 'string':
	    	        		        			UIField= {
		    	        		        		    "label" : currentField.title,
		    	        		        		    "model" : currentField.$id.substring(currentField.$id.lastIndexOf("/")+1,currentField.$id.length),
		    	        		        		    "required" : false,
		    	        		        		    "type" : "input",
		    	        		        		    "inputType" : "text"
		    	        		        		  }
	    	        		        		}
	    	        		        		newUISchema["fields"].push(UIField);
	    	        		        		newUISchema["title"] = currentSchema.title;
	    	        		        		
	    	        		        }
	    	        		        
	    	        		        schemas.push(newUISchema);
	        		        }
	        		        
	        		        
	        		      }
	        		  }
	        		customMetadataApi.getCustomMetadataSchema(modelID,schemaID,getCustomMetadataSchemaCallback);
	        }
	        
	        
	      }
	  }
	  customMetadataApi.getCustomMetadataSchemas(modelID,getCustomMetadataSchemasCallback);
  }
  //////////////
 

  
  var getFingerprints = function (self) {
	    console.log('Get Fingerprints');
	    console.log('self Filter ',self.filter);
	    var filterArray = null;
	    if(self.filter !== null){
	    var filterArray = self.filter.replace(/^\s+|\s+$/g,"").split(/\s*,\s*/);	
	    }
	    console.log('Filter ',filterArray);
	    var callback = function (error, data, response) {
	      console.log("data:", data);
	      console.log("response:", response);
	      self.resultsCount = data.resultCount;
	      self.pageCount = response.body.pageCount;
	      console.log("Page count", response.body.pageCount);
	      if (error) {
	        // this.response = data;
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
	    fingerprintApi.findFingerprintSetByKeyword(
	      opt,
	      callback
	    );
	  };

 

  var saveFingerprints = function (json, self) {
    console.log("saveFingerprints");
    var callback = function (error, data, response) {
      console.log("data:", data);
      console.log("response:", response);
      if (error) {
        // this.response = data;
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
  
	  
	  var findFingerprintById = function (self) {
		    console.log('Search Fingerprint for id: ',self.filter);
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
		        // this.response = data;
		        console.error(error);
		      } else {
		        var jsonResult = [];
		        jsonResult.push(response.body);
		        jsonResult[0]['actions'] = '';
		        self.items = jsonResult;
		        // console.log("Items For ID are: ",self.items);
		        console.log("API called successfully. Returned data: ", data);
		      }
		    };
		    var fingerprintsetId = self.filter;
		    fingerprintApi.getFingerprintSetById(
		      fingerprintsetId,
		      callback
		    );
		  };


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
    // opt,
    // callback
    // );
  };

  return {
    getFingerprints: getFingerprints,
    saveFingerprints: saveFingerprints,
    deleteFingerprint: deleteFingerprint,
    findFingerprintById: findFingerprintById,
    getModelSchemas:getModelSchemas
  }

}();

export default Fingerprints;