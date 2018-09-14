var MyObject = function () {

  var ApiClient = require("../generated/rest-client/src/ApiClient.js");
  var apiClient = new ApiClient();
  //only for test---
  apiClient.basePath = "http://" + window.location.hostname + ":9090/v0/foodauthent";
  //only for test---
  var SopApi = require("../generated/rest-client/src/api/SopApi.js");
  var sopApi = new SopApi(apiClient);

  var getSops = function (self) {

    var callback = function (error, data, response) {
      console.log("data:", data);
      console.log("response:", response);
      if (error) {
        //this.response = data;
        console.error(error);
      } else {
        var jsonResult = data.results;
        var length = jsonResult.length;
        for (var i = 0; i < length; i++) {
          // console.log(jsonResult[i]);
          jsonResult[i]['actions'] = '';
          console.log(jsonResult[i]);
        }
        self.items = data.results;
        console.log("API called successfully. Returned data: ", data);
      }
    };
    var opt = {
      pageNumber: 0,
      pageSize: 100
    };
    sopApi.findSOPByKeyword(
      opt,
      callback
    );
  };
  var saveSop = function (json, self) {
    console.log('Save Sop');
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
    var sop = json;
    sopApi.createNewSOP(
      sop,
      callback
    );
  };

  var deleteSop = function (id, self) {
    console.log('Delete Products');
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
  
  var updateSop = function (json, self) {
	    console.log('Update Products');
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
	      product: json
	    };
	    console.log("json:", json);
	    alert("When the Api will support this features it will work and update this id: "+json["fa-id"]);
	    // productApi.updateProduct(
	    //   opt,
	    //   callback
	    // );
	  };


  return {
    getSops: getSops,
    saveSop: saveSop,
    deleteSop: deleteSop,
    updateSop: updateSop
  }
}();

export default MyObject;