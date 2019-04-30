<template>
  <div class="login-form">
    <h2 class="login-heading">Login</h2>
     <b-button variant="danger" v-on:click="fakeLogin">Fake Login only for test</b-button>
     <b-button variant="warning" href="https://confluence.company-group.com/display/FTB/FOODAUTHENT+WORKSPACE" target="_blank">LDAP setting for local</b-button>
    
    <form action="#" @submit.prevent="login">
    <b-alert show variant="warning">Use this button if you dont have LDAP (ONLY FOR TEST) Click on the link to know how to set LDAP for your local</b-alert>
    <b-alert @dismissed="infoError=false" dismissible  variant="danger" :show="infoError">Login failed. Please try again.</b-alert>
 
      <div class="mb-more">
      <div class="form-group">
        <label for="user">User</label>
        <input type="text" name="user" id="user" class="login-input" v-model="model.user">
        </div>
      </div>

      <div class="mb-more">
      <div class="form-group">
        <label for="password">Password</label>
        <input type="password" name="password" id="password" class="login-input" v-model="model.password">
       </div>
      </div>

      <div class="mb-more">
        <button type="submit" class="btn-submit" :disabled="loggingIn">Login</button> 
      </div>

    </form>
  </div>
</template>


<script>
var testLogin = require("@/utils/authenticationFunction.js").default.testLogin;
var loginFunction = require("@/utils/authenticationFunction.js").default.loginFunction; 
var testLogin = require("@/utils/authenticationFunction.js").default.testLogin;  
import router from '@/router'
    export default {
        name: 'login',

        data () {
            return {
                infoError: false,
                model: {
                      user: '',
            		  password: '',      
                }
            }
        },

        beforeCreate () {
            if (this.$store.state.isLogged) {
                this.$router.push('/')
            }
        },

        methods: {
        //Only for test
        fakeLogin(){
        let self = this;
        testLogin(JSON.stringify(this.model, undefined, 4), self);
        },
        login(){
        let self = this;
        this.infoError = false
         console.log("POST BODY", JSON.stringify(self.model, undefined, 4));
         loginFunction(JSON.stringify(this.model, undefined, 4), self);
        }
        }
    }
</script>

