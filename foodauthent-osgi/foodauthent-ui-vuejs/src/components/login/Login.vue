<template>
  <div class="login-form">
    <h2 class="login-heading">Login</h2>
    
    <form action="#" @submit.prevent="login">
    <b-alert show variant="warning">Autentication is fake, use User: test - Password: test</b-alert>
    <b-alert @dismissed="infoError=false" dismissible  variant="danger" :show="infoError">Login failed. Please try again.</b-alert>
 
      <div class="mb-more">
      <div class="form-group">
        <label for="email">Username/Email</label>
        <input type="text" name="username" id="username" class="login-input" v-model="username">
        </div>
      </div>

      <div class="mb-more">
      <div class="form-group">
        <label for="password">Password</label>
        <input type="password" name="password" id="password" class="login-input" v-model="password">
       </div>
      </div>

      <div class="mb-more">
        <button type="submit" class="btn-submit" :disabled="loggingIn">Login</button>
      </div>

    </form>
  </div>
</template>


<script>
var test = require("@/utils/authenticationFunction.js").default.test;
import router from '@/router'

    export default {
        name: 'login',

        data () {
            return {
                infoError: false,
                username: '',
                password: ''
            }
        },

        beforeCreate () {
            if (this.$store.state.isLogged) {
                this.$router.push('/')
            }
        },

        methods: {
            login () {
            console.log("Inside login page");
                this.infoError = false
                let self = this;
				test(self);
            }
        }
    }
</script>

