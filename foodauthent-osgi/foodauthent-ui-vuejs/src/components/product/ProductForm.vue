<template>
  <div class="container" id="app2">
    <b-alert :show="showSuccess" variant="success">{{messageSuccess}}</b-alert>
     <b-alert :show="showDanger" variant="danger">{{messageDanger}}</b-alert>
    <div class="panel panel-default">
      <div class="panel-heading">PRODUCT FORM</div>
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
  </div>
</template>

<script>
import VueFormGenerator from "vue-form-generator";
import "vue-form-generator/dist/vfg.css";
var saveProducts = require("@/utils/productFunction.js").default.saveProducts;
import jsonschema from "@/generated/schema/product.json";
export default {
  data() {
    return {
      schema: jsonschema,
      model: {},
      response: "",
      showSuccess: false,
      showDanger: false,
      messageSuccess: "",
      messageDanger: "",
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
      saveProducts(JSON.stringify(this.model, undefined, 4), self);
    }
  },
  components: {
    "vue-form-generator": VueFormGenerator.component
  }
};
</script>


<style>
</style>
