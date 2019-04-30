<template>
  <div class="login-form">
    <h2 class="login-heading">Register</h2>
    <form action="#" @submit.prevent="register">
    
    <b-alert @dismissed="infoError=false" dismissible  variant="danger" :show="infoError">Register failed. Please try again.</b-alert>
    
    <div class="mb-more">
    <label for="parentDn">Parent Dn</label>
    
    <b-form-select id="parentDn" v-model="model.parentDn" :options="options"></b-form-select>
		
	</div>

   <!-- </div>
      <div class="mb-more">
        <label for="parentDn">Parent Dn</label>
        <input type="text" name="parentDn" id="parentDn" class="login-input" v-model="model.parentDn">
      </div> -->

      <div class="mb-more">
        <label for="userName">UserName</label>
        <input type="text" name="userName" id="userName" class="login-input" v-model="model.userName">
      </div>
      
      <div class="mb-more">
        <label for="userName">Password</label>
        <input type="password" name="password" id="password" class="login-input" v-model="password">
      </div>

      <div class="mb-more">
        <label for="email">Name</label>
        <input type="text" name="givenName" id="givenName" class="login-input" v-model="model.givenName">
      </div>

      <div class="mb-more">
        <label for="lastName">Last Name</label>
        <input type="text" name="lastName" id="lastName" class="login-input" v-model="model.lastName">
      </div>

      <div class="mb-more">
        <button type="submit" class="btn-submit">Create Account</button>
      </div>

    </form>
  </div>
</template>

<script>
var registerUser = require("@/utils/authenticationFunction.js").default.registerUser;
import router from '@/router'
export default {
    data() {
        return {
            model: {
                parentDn: '',
                userName: '',
                givenName: '',
                lastName: ''
            },
            password:'',
		    options: [
		      { text: 'Please select one', value: '' },
		      { text: 'Users', value: 'ou=users,dc=foodauthent,dc=org' },
		     // { text: 'Groups', value: 'ou=groups,dc=foodauthent,dc=org' }
		    ]
        }
    },
    methods: {
        register() {
            let self = this;
            this.infoError = false
            console.log("POST BODY", JSON.stringify(self.model, undefined, 4));
            registerUser(JSON.stringify(this.model, undefined, 4), self);
        }
    }
}
</script>
