<template>
  <div class="container" id="app2">
    <div class="panel panel-default">
      <div class="panel-heading">TRAINING JOB FORM</div>
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
var saveTrainingJob = require("@/utils/workflowFunction.js").default.saveTrainingJob;
import jsonschema from "@/schema/createTrainingJob.json";


console.log(jsonschema.fields);

function getFun(val) {
  return function() {
    this.$root.$emit("bv::show::modal", val);
  };
}

if (jsonschema.fields) {
  for (var i = 0; i < jsonschema.fields.length; i++) {
    var currentField = jsonschema.fields[i];

    if (currentField.idprovider) {
      console.log("Provider: ", currentField.idprovider);

      var buttton = [
        {
          classes: "btn-location",

          label: currentField.idprovider,

          onclick: getFun(currentField.idprovider)
        }
      ];

      currentField.buttons = buttton;
    }
  }
}

export default {
  data() {
    return {
      schema: jsonschema,
      model: {},
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
      saveTrainingJob(JSON.stringify(this.model, undefined, 4), self);
    }
  },
  components: {
    "vue-form-generator": VueFormGenerator.component
  }
};
</script>


<style>
</style>
