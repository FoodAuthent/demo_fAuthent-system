<template>

<div id="app">
<div>
  <b-navbar toggleable="lg" style="list-style: none;" type="dark">
    <b-navbar-brand :to="{ name: 'Home' }"><img src="./assets/logo.png"></b-navbar-brand>

	<!--  Experiments  -->
        <b-nav-item-dropdown right v-if="loggedIn">
        <template slot="button-content"><em>Experiments</em></template>
            <md-list v-if="route.meta.Experiments" v-for="route in this.$router.options.routes">
                <md-list-item>
                    <b-dropdown-item><router-link :to="route.path"">{{route.name}}</router-link></b-dropdown-item>
                </md-list-item>
            </md-list>
        </b-nav-item-dropdown>
        
        <!--  Analytics  -->
        <b-nav-item-dropdown right v-if="loggedIn">
        <template slot="button-content"><em>Analytics</em></template>
            <md-list v-if="route.meta.Analytics" v-for="route in this.$router.options.routes">
                <md-list-item>
                    <b-dropdown-item><router-link :to="route.path"">{{route.name}}</router-link></b-dropdown-item>
                </md-list-item>
            </md-list>
        </b-nav-item-dropdown>
        
        <!--  Tracing  -->
        <b-nav-item-dropdown right v-if="loggedIn">
        <template slot="button-content"><em>Tracing</em></template>
            <md-list v-if="route.meta.Tracing" v-for="route in this.$router.options.routes">
                <md-list-item>
                    <b-dropdown-item><router-link :to="route.path"">{{route.name}}</router-link></b-dropdown-item>
                </md-list-item>
            </md-list>
        </b-nav-item-dropdown>      

     <!--   <b-nav-item-dropdown right>
          <template slot="button-content"><em>USER</em></template>
          <b-dropdown-item v-if="!loggedIn"><router-link :to="{ path: '/login' }">Login</router-link></b-dropdown-item>
          <b-dropdown-item v-if="!loggedIn"><router-link :to="{ path: '/register' }">Register</router-link></b-dropdown-item>
          <b-dropdown-item v-if="loggedIn"><router-link :to="{ path: '/logout' }">Logout</router-link></b-dropdown-item>
        </b-nav-item-dropdown> -->

        <b-nav-item v-if="!loggedIn"><router-link :to="{ path: '/login' }">LOGIN</router-link></b-nav-item>
        <b-nav-item v-if="!loggedIn"><router-link :to="{ path: '/register' }">REGISTER</router-link></b-nav-item>
        <b-nav-item v-if="loggedIn"><router-link :to="{ path: '/logout' }">LOGOUT</router-link></b-nav-item>

  </b-navbar>
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
