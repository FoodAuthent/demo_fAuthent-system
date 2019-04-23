import router from '@/router'
import store from '@/store'
var MyObject = function () {

  var ApiClient = require("../generated/rest-client/src/ApiClient.js");
  var apiClient = new ApiClient();
  //only for test---
  apiClient.basePath = window.location.origin + "/v0/foodauthent";
  //only for test---
  //Authentication Api
  var AuthenticationApi = require("../generated/rest-client/src/api/AuthenticationApi.js");
  var authenticationApi = new AuthenticationApi(apiClient);
  //User Api
  var UserApi = require("../generated/rest-client/src/api/UserApi.js");
  var userApi = new UserApi(apiClient);
 
  
var test = function(self){
if(self.username == 'test' && self.password == 'test'){
console.log("user ok");
fetch('https://jsonplaceholder.typicode.com/users/1')
  .then(response => response.json())
  .then(json => {
	  	  console.log("JSON", json);
		  console.log("token", json.company.catchPhrase);
          localStorage.setItem('token', json.company.catchPhrase);
          store.commit('LOGIN_USER')
          router.push('/')
      }, () => {
          self.infoError = true
          self.password = ''
      })		
	} else{
		console.log("user not ok");
        self.infoError = 5
        self.password = ''
	}
  }
  
  var loginFunction = function(self){
	    console.log('Login');
	    console.log('Username ',self.username);
	    console.log('Password ',self.password);
	    var callback = function (error, data, response) {
	      console.log("data:", data);
	      console.log("response:", response);
	      if(response.body !== null){
	    	  console.log("User is: ",response);
	    	  localStorage.setItem('user', response)
	      }
	      if (error) {
	        self.infoError = true;
	        console.error(error);
	      } else {
	        console.log("API called successfully. Returned data: ", data);
	        router.push('/');
	      }
	    };
	    var opt = {
	      username: self.username,
	      password: self.password
	      };
	    userApi.getUser(
	      opt,
	      callback
	    );
	  };
  
  var retrieveToken = function (self) {
	    console.log('Retrieve Token');
	    console.log('Username ',self.username);
	    console.log('Password ',self.password);
	    var callback = function (error, data, response) {
	      console.log("data:", data);
	      console.log("response:", response);
	      if(response.body !== null){
	    	  console.log("Response token is: ",response);
	      }
	      if (error) {
	        //this.response = data;
	        console.error(error);
	      } else {
	        console.log("API called successfully. Returned data: ", data);
	      }
	    };
	    var opt = {
	      username: self.username,
	      password: self.password
	      };
	    authenticationApi.authenticateUserJSONWebToken(
	      opt,
	      callback
	    );
	  };
	  
	  var saveUser = function (json, self) {
		    console.log('Save User');
		    var callback = function (error, data, response) {
		      console.log("data:", data);
		      console.log("response:", response);
		      if (error) {
		        console.error(error);
		        self.showError = 5;
		      } else {
		        self.response = data.results;
		        self.showSuccess = 5;
		        console.log("API called successfully. Returned data: ", data);
		      }
		    };
		    var opt = {
		      model: json
		    };
		    userApi.createUser(
		      opt,
		      callback
		    );
		  };
  
  

  return {
	  test: test,
	  retrieveToken: retrieveToken,
	  saveUser: saveUser
  }
}();

export default MyObject;