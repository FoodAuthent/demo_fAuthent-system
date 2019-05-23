<template>

<div class="page-container">
    <md-app>
        <md-app-toolbar class="md-primary">
            <span class="md-title">HOME</span>
        </md-app-toolbar>

        <md-app-drawer md-permanent="full">
        
            <md-toolbar class="md-transparent" md-elevation="0">
          Experiments
        </md-toolbar>
            <md-list v-if="route.meta.Experiments" v-for="route in this.$router.options.routes">
                <md-list-item>
                    <md-icon>label</md-icon>
                  <!--  <span class="md-list-item-text">Experiments</span> -->
                    <router-link :to="route.path" class="md-list-item-text">{{route.name}}</router-link>
                </md-list-item>
            </md-list>
  			<hr>
            <md-toolbar class="md-transparent" md-elevation="0">
          Analytics
        </md-toolbar>
            <md-list v-if="route.meta.Analytics" v-for="route in this.$router.options.routes">
                <md-list-item>
                    <md-icon>label</md-icon>
                  <!--  <span class="md-list-item-text">Analytics</span> -->
                    <router-link :to="route.path" class="md-list-item-text">{{route.name}}</router-link>
                </md-list-item>
            </md-list>
       
        
     <hr>
           <md-toolbar class="md-transparent" md-elevation="0">
          Tracing
        </md-toolbar>
            <md-list v-if="route.meta.Tracing" v-for="route in this.$router.options.routes">
                <md-list-item>
                    <md-icon>label</md-icon>
                <!--    <span class="md-list-item-text">Tracing</span> -->
                    <router-link :to="route.path" class="md-list-item-text">{{route.name}}</router-link>
                </md-list-item>
            </md-list>
         <hr>
         <md-toolbar class="md-transparent" md-elevation="0">
          Misc
        </md-toolbar>
            <md-list v-if="route.meta.Misc" v-for="route in this.$router.options.routes">
                <md-list-item>
                    <md-icon>label</md-icon>
                    <router-link :to="route.path" class="md-list-item-text">{{route.name}}</router-link>
                </md-list-item>
            </md-list>
        </md-app-drawer>
        <md-app-content>
		<div id="tableInfo"> 
				<table class="table table-striped">
				  <tbody>
				    <tr v-for="(value, key) in items">
				      <td>{{ key }}</td>
				      <td>{{ value }}</td>
				    </tr>
				  </tbody>
				</table>
		</div>
        </md-app-content>
    </md-app>

</div>

</template>


<script>
var getInfo = require("@/utils/commonFunction.js").default.getInfo;
export default {
    name: "Sop",
    data() {
        return {
            items: []
        };
    },
    mounted() {
        this.loadTableData();
    },
    methods: {
        loadTableData() {
                console.log("Load table data");
                let self = this;
                getInfo(self);
            }
    }
};

</script>
<style lang="scss" scoped>

.md-app {
    /*max-height: px; */
    border: 1px solid rgba(#000, .12);
}

.md-drawer {
    max-width: 250px;
}

</style>
