<template>
  <div class="container" id="fingerprintContainer">
      <b-alert :show="showSuccess" dismissible variant="success" @dismissed="showSuccess=false">
    <p>Operation success</p>
  </b-alert>
  <b-alert :show="showError" dismissible variant="danger" @dismissed="showError=false">
     <p>There is a problem {{response}}</p>
  </b-alert>
    <div class="panel panel-default">
      <div class="panel-heading">FINGERPRINT FORM</div>
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
import jsonschema from "@/generated/schema/fingerprint.json";

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
      showSuccess: false,
      showError: false,
      formOptions: {
        validateAfterLoad: true,
        validateAfterChanged: true
      }
    };
  },
  methods: {
    save() {
      console.log("URL", this.endpointurl);
      console.log(JSON.stringify(this.model, undefined, 4));
      this.response = "";
      this.$http
        .post(this.endpointurl, JSON.stringify(this.model, undefined, 4), {
          headers: { "content-type": "application/json" }
        })
        .then(
          result => {
            this.response = result.data;
          },
          error => {
            console.error(error);
            this.response = error;
          }
        );
    }
  },
  components: {
    "vue-form-generator": VueFormGenerator.component
  }
};
</script>


<style>
</style>
