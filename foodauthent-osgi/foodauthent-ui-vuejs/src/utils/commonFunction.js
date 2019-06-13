var entityApi;
var customMetadataApi;
var sampleApi
function setUpApi(){
	  var ApiClient = require("../generated/rest-client/src/ApiClient.js");
	  var apiClient = new ApiClient();
	  
	  if(localStorage.getItem('token')){
		  var headerToken = {Authorization: 'Bearer ' + localStorage.getItem('token')};
		  apiClient.defaultHeaders = headerToken;  
	  }
	  //only for test---
	  apiClient.basePath = window.location.origin + "/v0/foodauthent";
	  //only for test---
	  var CustomMetadataApi = require("@/generated/rest-client/src/api/CustomMetadataApi.js");
	  customMetadataApi = new CustomMetadataApi(apiClient);
	  
	  var EntityApi = require("@/generated/rest-client/src/api/EntityApi.js");
	  entityApi = new EntityApi(apiClient);
	  
	  var SampleApi = require("@/generated/rest-client/src/api/SampleApi.js");
	  sampleApi = new SampleApi(apiClient);
	  	  
}

var MyObject = function () {


	  var getModelSchemas = function(modelID,schemas,schemaIdHolder){
		  setUpApi();
		  if (typeof schemas !== 'undefined' && schemas.length > 0) {
//			  schemas.splice(0,schemas.length);
			  schemas = [];
			}
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
		    	        		        		// TODO make Field JSON element
		    	        		        		var currentField = fields[fieldsKeys[fieldsindex]];
		    	        		        		//console.log("nestedSchemaKeys",nestedSchemaKeys[nestedindex]);
		    	        		        		var UIField ;
//		    	        		        		switch(currentField.type){
//		    	        		        		case 'string':
		    	        		        			UIField= {
			    	        		        		    "label" : fieldsKeys[fieldsindex],
			    	        		        		    "model" : fieldsKeys[fieldsindex],
			    	        		        		    "required" : false,
			    	        		        		    "type" : "input",
			    	        		        		    "inputType" : "text"
			    	        		        		  }
		    	        		        		//}
		    	        		        		newUISchema["fields"].push(UIField);
		    	        		        		newUISchema["title"] = currentSchema.title;
		    	        		        		newUISchema["model"] = {};
		    	        		        		newUISchema["modelID"] = modelID;
		    	        		        		newUISchema["schemaID"] = schemaID;
		    	        		        		newUISchema["key"] = nestedSchemaKeys[nestedindex]
		    	        		        		
		    	        		        }
		    	        		        schemas.push(newUISchema);
		        		        }
		        		        
		        		        
		        		      }
		        		  }
	        		if(schemaIdHolder ==undefined || schemaIdHolder.schemaID != "withOutSchema"){
		        		customMetadataApi.getCustomMetadataSchema(modelID,schemaID,getCustomMetadataSchemaCallback);
		        		}else{
		        			schemaIdHolder.schemaID = schemaID;
		        			console.log("schemaIdHolder.schemaID",schemaIdHolder.schemaID);
		        		}
		        }
		        
		        
		      }
		  }
		  customMetadataApi.getCustomMetadataSchemas(modelID,getCustomMetadataSchemasCallback);
	  }
	  // ////////////
	  
	  // ///////////SAVE METADATA
		  var saveCustomMetadata = function (schemas, faId) {
			  setUpApi();
			  var dataModel = {}
			  var schemaID ;
			  var modelID ;
			  for(var index = 0; index < schemas.length;index++){
				  var currentSchema = schemas[index];
				  var model= currentSchema.model;
				  var schemaID = currentSchema.schemaID;
				  var modelID = currentSchema.modelID;
				  dataModel[currentSchema.key] = currentSchema.model ;
			  }
			    var callback = function (error, data, response) {
			      console.log("data:", data);
			      console.log("response:", response);
			      if (error) {
			        console.error(error);
			        self.showError = true;
			      } else {
			        self.response = response;
			        console.log("Data", data);
			        saveMetadata(data);
			        //self.showSuccess = 5;
			        console.log("API called successfully. Returned data: ", data);
			      }
			    };
			    var opt = {
			      body : dataModel
			    };
			    customMetadataApi.saveCustomMetadata(
			    modelID,
			    schemaID,
			    faId,
			      opt,
			      callback
			    );
			  };
	  // ////////////
			  
			  /////////////GET METADATA
			  var getCustomMetadata = function (modelID, schemaID, faID, self) {
				  setUpApi();
				    var callback = function (error, data, response) {
				      console.log("data:", data);
				      console.log("response:", response);
				      if (error) {
				        console.error(error);
				        self.showError = true;
				      } else {
					        var jsonResult = data.results;
					        console.log("Data custom ", data);
					        self.itemsMetadata = data;
					        console.log("Data items ", self.itemsMetadata);
					        console.log("API called successfully. Returned data: ", data);
					      }
					    };
				    customMetadataApi.getCustomMetadata(
				    modelID,
				    schemaID,
				    faID,
				    callback
				    );
				  };
		  // ////////////
	 
  var renderCustomField = function (self, jsonschema) {
    //console.log(jsonschema.fields);

    function getFun(val) {
      return function () {
        this.$root.$emit("bv::show::modal", val);
      };
    }

    if (jsonschema.fields) {
      for (var i = 0; i < self.jsonschema.fields.length; i++) {
        var currentField = jsonschema.fields[i];

        if (currentField.idprovider) {
          console.log("Provider: ", currentField.idprovider);

          var buttton = [{
            classes: "btn-location",

            label: currentField.idprovider,

            onclick: getFun(currentField.idprovider)
          }];

          currentField.buttons = buttton;
        }
      }
    }
  };
  
  var deleteEntity = function (faId, self) {
	  setUpApi();
	    console.log('Delete Entity',faId);
	    var callback = function (error, data, response) {
	      console.log("data:", data);
	      console.log("response:", response);
	      if (error) {
	        console.error(error);
	        self.showError = true;
	      } else {
	        self.response = response;
	        self.showSuccess = 5;
	        console.log("API called successfully. Returned data: ", data);
	      }
	    };
	     entityApi.removeEntity(
	       faId,
	       callback
	     );
	  };
	  
	  var getInfo = function (self) {
		  var ApiClient = require("../generated/rest-client/src/ApiClient.js");
		  var apiClient = new ApiClient();
		  var InfoApi = require("@/generated/rest-client/src/api/InfoApi.js");
		  var infoApi = new InfoApi(apiClient);
			setUpApi();
		    var callback = function (error, data, response) {
		      console.log("data:", data);
		      console.log("response:", response);
		      if (error) {
		        //this.response = data;
		        console.error(error);
		      } else {
//		        var jsonResult = data.results;|
		        self.items = data;
		        console.log("API called successfully. Returned data: ", data);
		      }
		    };
		    infoApi.getInfo(
		      callback
		    );
		  };
		  
		var getLinkInfo = function(faId, infoType, self){
		var generalApi;
		  var ApiClient = require("../generated/rest-client/src/ApiClient.js");
		  var apiClient = new ApiClient();
		  if(localStorage.getItem('token')){
			  var headerToken = {Authorization: 'Bearer ' + localStorage.getItem('token')};
			  apiClient.defaultHeaders = headerToken;  
		  }
		  //only for test---
		  apiClient.basePath = window.location.origin + "/v0/foodauthent";
		  //only for test---
		  if(infoType == 'file-id'){
		  var FileApi = require("@/generated/rest-client/src/api/FileApi.js");
		  generalApi = new FileApi(apiClient);
		  }else if(infoType == 'fingerprint-id' || infoType == 'fingerprint-ids' || infoType == 'fingerprintset-ids'){
		  var FingerprintApi = require("@/generated/rest-client/src/api/FingerprintApi.js");
		  generalApi = new FingerprintApi(apiClient);
		}else if(infoType == 'model-id'){
		  var ModelApi = require("@/generated/rest-client/src/api/ModelApi.js");
		  generalApi = new ModelApi(apiClient);
		}else if(infoType == 'product-id'){
		  var ProductApi = require("@/generated/rest-client/src/api/ProductApi.js");
		  generalApi = new ProductApi(apiClient);
		}else if(infoType == 'sop-id'){
		  var SopApi = require("@/generated/rest-client/src/api/SopApi.js");
		  generalApi = new SopApi(apiClient);
		}else if (infoType == 'workflow-id' || infoType == 'prediction-id'){
			  var WorkflowApi = require("@/generated/rest-client/src/api/WorkflowApi.js");
			  generalApi = new WorkflowApi(apiClient);
		}else{
			console.log("This type of data doesnt exist", infoType);
		}
		    console.log('Get LINK info');
		    var callback = function (error, data, response) {
		      console.log("data:", data);
		      console.log("response:", response);
		      if (error) {
		        //this.response = data;
		        console.error(error);
		      } else {
		        var jsonResult = [];
		        jsonResult.push(response.body);
//		        self.itemLink = data.results;
		        if(infoType == 'fingerprint-id' || infoType == 'fingerprint-ids' || infoType == 'fingerprintset-ids'){
		        	findSampleById (jsonResult[0]['sample-id'],self);
		        }else{
		        	self.itemLink = jsonResult;
		        }
				document.body.classList.remove("modal-open");
		        console.log("API called successfully. Returned data: ", data);
		      }
		    };
			  if(infoType == 'file-id'){
				  generalApi.getFileMetadata(faId,callback);
				  }else if(infoType == 'fingerprint-id' || infoType == 'fingerprint-ids' || infoType == 'fingerprintset-ids'){
					  generalApi.getFingerprintById(faId,callback);
				}else if(infoType == 'model-id'){
					generalApi.getModelById(faId,callback);
				}else if(infoType == 'product-id'){
					generalApi.getProductById(faId,callback);
				}else if(infoType == 'sop-id'){
					generalApi.getSOPById(faId,callback);
				}else if(infoType == 'workflow-id'){
					generalApi.getWorkflowById(faId,callback);
				}else if(infoType == 'prediction-id'){
					generalApi.getPredictionResult(faId,callback);
				} else {
				console.log('Something goes wrong, this type doesnt exist',infoType);
				}
 
		  };
		  
		  var findSampleById = function (faId, self) {
			  setUpApi();
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
			        var jsonResult = [];
			        jsonResult.push(response.body);
			        jsonResult[0]['actions'] = '';
			        self.itemLink  = jsonResult;
			        console.log("API called successfully. Returned data: ", data);
			      }
			    };
			    var sampleId = faId;
			    sampleApi.getSampleById(
			      sampleId,
			      callback
			    );
			  };

  return {
    renderCustomField: renderCustomField,
    getModelSchemas: getModelSchemas,
    saveCustomMetadata : saveCustomMetadata,
    getCustomMetadata: getCustomMetadata,
    deleteEntity: deleteEntity,
    getInfo: getInfo,
    getLinkInfo: getLinkInfo
  }
}();

export default MyObject;