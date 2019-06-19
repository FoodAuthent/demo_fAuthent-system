var relationApi;
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
	  var RelationApi = require("../generated/rest-client/src/api/RelationApi.js");
	  relationApi = new RelationApi(apiClient);
}

var MyObject = function () {

  var getEntities = function (self) {
		setUpApi();
	    console.log('Get Relations');
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
	        self.entities = data;
	        if(data.includes(self.entity)){
	            self.hasRelation = true;
	            getSupportedEntities(self);
	         }
	        console.log("API called successfully. Returned data: ", data);
	      }
	    };
	    relationApi.getEntities(
	      callback
	    );
	  };
	  
 
	  var getSupportedEntities = function (self) {
			setUpApi();
		    console.log('Get SupportedEntities');
		    var entityName = self.entity;
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
		        self.relationItems = data;
		        console.log("API called successfully. Returned data: ", data);
		      }
		    };
		    relationApi.getSupportedEntities(
		      entityName,
		      callback
		    );
		  };
		  
		  
		  var getForeignKeyEntities = function (entityName, referencedEntity, faId, self) {
				setUpApi();
			    console.log('Get ForeignKeyEntities');
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
			        self.relationResult = data.results;
			        console.log("API called successfully. Returned data: ", data);
		            window.scrollTo(0, 0);
			      }
			    };
			    var opt = {
			  	      pageNumber: self.currentPage,
			  	      pageSize: self.perPage
			  	    };
			    relationApi.getForeignKeyEntities(
			     entityName,
			     faId,
			     referencedEntity,
			     opt,
			      callback
			    );
			  };

  
  return {
	  getEntities: getEntities,
	  getForeignKeyEntities: getForeignKeyEntities

  }
}();

export default MyObject;