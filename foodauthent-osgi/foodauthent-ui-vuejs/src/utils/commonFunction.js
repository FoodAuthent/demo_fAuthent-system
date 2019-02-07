var MyObject = function () {
	  var ApiClient = require("../generated/rest-client/src/ApiClient.js");
	  var apiClient = new ApiClient();
	  //only for test---
	  apiClient.basePath = "http://" + window.location.hostname + ":9090/v0/foodauthent";
	  //only for test---
	
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
    getModelSchemas: getModelSchemas
  }
}();

export default MyObject;