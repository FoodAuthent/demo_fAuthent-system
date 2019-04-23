<template>

<div id="app">
		  <div class="row">
		    <div class="col-2">
		     <img src="./assets/logo.png">
		    </div>
		    <div class="col-10">	      
			     <ul class="login">
			      <li v-if="!loggedIn"><router-link :to="{ path: '/login' }">Login</router-link></li>
			      <li v-if="!loggedIn"><router-link :to="{ path: '/register' }">Register</router-link></li>
			      <li v-if="loggedIn"><router-link :to="{ path: '/logout' }">Logout</router-link></li>
			    </ul>
		    </div>
		  </div>
    <router-view></router-view>
</div>

</template>

<script>
export default {
    name: 'App',
         computed: {
		    loggedIn() {
		      return this.$store.state.isLogged;
		    }
		  }
}

</script>

<style>

@import './assets/styles/custom.css';
#app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    /** text-align: center; */
    color: #2c3e50;
    /**margin-top: 60px;*/
}

</style>