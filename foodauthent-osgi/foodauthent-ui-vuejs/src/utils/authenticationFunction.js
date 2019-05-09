import router from '@/router'
import store from '@/store'
var MyObject = function () {
    var varDn = '';
    var generatedPassword = '';
    var ApiClient = require("../generated/rest-client/src/ApiClient.js");
    var apiClient = new ApiClient();
    //only for test---
    apiClient.basePath = window.location.origin + "/v0/foodauthent";
    //Authentication Api
    var AuthenticationApi = require("../generated/rest-client/src/api/AuthenticationApi.js");
    var authenticationApi = new AuthenticationApi(apiClient);
    //User Api
    var UserApi = require("../generated/rest-client/src/api/UserApi.js");
    var userApi = new UserApi(apiClient);

    var loginFunction = function (json, self) {
        console.log('Login function');
        console.log(json);
        var callback = function (error, data, response) {
            console.log("data:", data);
            console.log("response:", response);
            if (error) {
                console.error(error);
                self.infoError = 5;
            } else {
                self.response = data.results;
                console.log("Response login", self.response);
                localStorage.setItem('token', data);
                store.commit('LOGIN_USER');
                router.push('/')
                console.log("API called successfully. Returned data: ", data);
            }
        };
        var userAuthenticationRequest = json;
        authenticationApi.authenticateUserJSONWebToken(
            userAuthenticationRequest,
            callback
        );
    };

    /** ONLY FOR TEST */
    var testLogin = function (json, self) {
        console.log("login fake json", json);
        fetch('https://jsonplaceholder.typicode.com/users/1')
            .then(response => response.json())
            .then(json => {
                console.log("JSON", json);
                console.log("token", json.company.catchPhrase);
                localStorage.setItem('token', "fake test token");
                store.commit('LOGIN_USER');
                router.push('/')
            }, () => {
                self.infoError = true
                self.password = ''
            })
    }
    /** */
   
    var registerUser = function(json,self){
    	console.log("Save user and generate password");
    	saveUser(json, self, generatePassword);
    	console.log("RegisterUser end");
    }
    

    var saveUser = function (json, self, callbackGeneratePassword) {
        console.log('Save User');
        var callback = function (error, data, response) {
            console.log("data:", data);
            console.log("response:", response);
            if (error) {
                console.error(error);
                self.infoError = 5;
            } else {
                self.response = data.results;
                varDn = data.dn;
                console.log("API called successfully. Returned data: ", data);
                callbackGeneratePassword(self, changePassword);
            }
        };
        var userCreateRequest = json;
         userApi.createUser(
            userCreateRequest,
            callback
        );
    };
    
    var generatePassword = function (self, changePasswordCallback) {
        console.log('generatePassword');
        var callback = function (error, data, response) {
            console.log("data:", data);
            console.log("response:", response);
            if (error) {
                console.error(error);
                self.infoError = 5;
            } else {
            	generatedPassword = data;
                console.log("API called successfully. Returned data: ", data);
                changePasswordCallback(self);
            }
        };
        var dn = varDn;
	    var opt = {
                length: 8
      	    };
         userApi.generatePassword(
            dn,
            opt,
            callback
        );
    };
    
    var changePassword = function (self) {
        console.log('changePassword', generatedPassword);
        var callback = function (error, data, response) {
            console.log("data:", data);
            console.log("response:", response);
            if (error) {
                console.error(error);
                self.infoError = 5;
            } else {
                console.log("API called successfully. Returned data: ", data);
                router.push('/login');
            }
        };
        var dn = varDn;
        var changePasswordRequest = {
      	  "current": generatedPassword,
      	  "new": self.password
      	};
        console.log("Password change",changePasswordRequest );
         userApi.setPassword(
         dn, 
         changePasswordRequest, 
         callback
        );
    };



    return {
        loginFunction: loginFunction,
        registerUser: registerUser,
        testLogin: testLogin,
    }
}();

export default MyObject;
