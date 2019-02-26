var MyObject = function () {
	  var ApiClient = require("../generated/rest-client/src/ApiClient.js");
	  var apiClient = new ApiClient();
	  // only for test---
	  apiClient.basePath = window.location.origin + "/v0/foodauthent";
	  // only for test---
	
// ///////////GET METADATA SCHEMA
	  var CustomMetadataApi = require("@/generated/rest-client/src/api/CustomMetadataApi.js");
	  var customMetadataApi = new CustomMetadataApi(apiClient);

	  var getModelSchemas = function(modelID,schemas,schemaIdHolder){
		  console.log("Schema at begin",schemas);
		  if (typeof schemas !== 'undefined' && schemas.length > 0) {
			  console.log("Schema inside if",schemas);
//			  schemas.splice(0,schemas.length);
			  schemas = [];
			}
		  console.log("Schema outside if",schemas);
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
		    	        		        		console.log("nestedSchemaKeys",nestedSchemaKeys[nestedindex]);
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
		    	        		        console.log("schemas before push",schemas);
		    	        		        schemas.push(newUISchema);
		        		        }
		        		        
		        		        
		        		      }
		        		  }
	        		if(schemaIdHolder ==undefined || schemaIdHolder.schemaID != "withOutSchema"){
	        			console.log("inside if", schemaID);
		        		customMetadataApi.getCustomMetadataSchema(modelID,schemaID,getCustomMetadataSchemaCallback);
		        		}else{
		        			schemaIdHolder.schemaID = schemaID;
		        		}
	        		console.log("ouside if", schemaIdHolder.schemaID);
		        }
		        
		        
		      }
		  }
		  customMetadataApi.getCustomMetadataSchemas(modelID,getCustomMetadataSchemasCallback);
	  }
	  // ////////////
	  
	  // ///////////SAVE METADATA
		  var saveCustomMetadata = function (schemas, faId) {
			  console.log("faId",faId);
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
			    console.log('Save Custom Metadata Schemas ',schemas);
			    var callback = function (error, data, response) {
			      console.log("data:", data);
			      console.log("response:", response);
			      if (error) {
			        console.error(error);
			        self.showError = true;
			      } else {
			        self.response = data.results;
			        console.log("Data", data);
			        saveMetadata(data);
			        self.showSuccess = true;
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
				    console.log('Get Custom Metadata', modelID, schemaID, faID);
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
    console.log(jsonschema.fields);

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

  return {
    renderCustomField: renderCustomField,
    getModelSchemas: getModelSchemas,
    saveCustomMetadata : saveCustomMetadata,
    getCustomMetadata: getCustomMetadata
  }
}();

export default MyObject;