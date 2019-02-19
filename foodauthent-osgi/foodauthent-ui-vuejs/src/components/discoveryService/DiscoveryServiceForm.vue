<template>
  <div class="container" id="discoveryServiceContainer">
  <b-alert :show="showSuccess" dismissible variant="success" @dismissed="showSuccess=false">
    <p>Operation success</p>
  </b-alert>
  <b-alert :show="showError" dismissible variant="danger" @dismissed="showError=false">
     <p>There is a problem {{response}}</p>
  </b-alert>
    <div class="panel panel-default">
      <div class="panel-heading">DISCOVERY SERVICE FORM</div>
      <div class="panel-body">
        <vue-form-generator :schema="schema" :model="model" :options="formOptions">
        </vue-form-generator>
         <div class="button-div"> <b-button variant="primary" @click="save()">Save</b-button></div>
      </div>
    </div>

   <div class="panel panel-default">
      <div class="panel-heading">Model</div>
      <div class="panel-body">
        <pre v-if="model" v-html="JSON.stringify(model, undefined, 4)"></pre>
      </div>
    </div>

    <div id="response">
    <h1>Response</h1>
   <p> {{response}}</p>
    </div>

  <!--   <div class="panel panel-default">
      <div class="panel-heading">Schema</div>
      <div class="panel-body">
        <pre v-if="model" v-html="prettyJSON(schema)"></pre>
      </div>
    </div> -->
    
  </div>
  
  
  
</template>

<script>
import VueFormGenerator from "vue-form-generator";
import "vue-form-generator/dist/vfg.css";
var saveTransaction = require("@/utils/discoveryServiceFunction.js").default.saveTransaction;
import jsonschema from "@/generated/schema/discoveryservicetransaction.json";
export default {
  data() {
    return {
      schema: jsonschema,
      model: {},
      showSuccess: false,
      showError: false,
      response: "",
      formOptions: {
        validateAfterLoad: true,
        validateAfterChanged: true
      }
    };
  },
  methods: {
    save() {
      let self = this;
      console.log("POST BODY", JSON.stringify(this.model, undefined, 4));
      saveTransaction(JSON.stringify(this.model, undefined, 4), self);
      self.model={}
    }
  },
  components: {
    "vue-form-generator": VueFormGenerator.component
  }
};
</script>
<style>
.collapse{
margin: 15px;
}
</style>
