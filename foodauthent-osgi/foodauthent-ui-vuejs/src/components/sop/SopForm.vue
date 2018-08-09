<template>

  <div class="container" id="app2">

    <div class="panel panel-default">

      <div class="panel-heading">SOP FORM</div>

      <div class="panel-body">

        <vue-form-generator :schema="schema" :model="model" :options="formOptions">

        </vue-form-generator>

         <div class="button-div"> <b-button variant="primary" @click="save()">Save</b-button></div>

      </div>

    </div>



   <div class="panel panel-default">

      <div class="panel-heading">Model</div>

      <div class="panel-body">

        <pre v-if="model" v-html="prettyJSON(model)"></pre>

      </div>

    </div>



    <div id="response">

    <h1>Response</h1>

   <p> {{response}}</p>

    </div>

<!-- SEARCH PRODUCT -->
  <b-modal id="select-product" title="Product Search">

   <template>

   <div class="button-div"> <b-button variant="primary" @click="search()">Search</b-button></div>

    <b-table striped hover :items="items" :fields="fields"  @row-clicked="myRowClickHandler">

      <template slot="actions" slot-scope="items">

    <b-btn size="sm" @click="testFunction">Select</b-btn>

  </template>

    </b-table>

</template>

  </b-modal>

<!-- UPLOAD FILE -->

  <b-modal id="upload-file" title="Upload File">

   <template>

        <b-form-file v-model="file" :state="Boolean(file)" placeholder="Choose a file..."></b-form-file>

  </template>

    </b-table>

  </b-modal>

  

  </div>

</template>



<script>
import VueFormGenerator from "vue-form-generator";

import "vue-form-generator/dist/vfg.css";

import jsonschema from "@/generated/schema/sop.json";

import { EndpointUrl } from "../../config.js";

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

          label: "Search " + currentField.idprovider,

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
      fields: null,
      items: null,
      response: "",
      file: null,

      endpointurl: EndpointUrl.SOPURL,

      formOptions: {
        validateAfterLoad: true,

        validateAfterChanged: true
      }
    };
  },

  methods: {
    prettyJSON: function(json) {
      if (json) {
        json = JSON.stringify(json, undefined, 4);

        json = json
          .replace(/&/g, "&")
          .replace(/</g, "<")
          .replace(/>/g, ">");

        return json.replace(
          /("(\\u[a-zA-Z0-9]{4}|\\[^u]|[^\\"])*"(\s*:)?|\b(true|false|null)\b|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?)/g,
          function(match) {
            var cls = "number";

            if (/^"/.test(match)) {
              if (/:$/.test(match)) {
                cls = "key";
              } else {
                cls = "string";
              }
            } else if (/true|false/.test(match)) {
              cls = "boolean";
            } else if (/null/.test(match)) {
              cls = "null";
            }

            return '<span class="' + cls + '">' + match + "</span>";
          }
        );
      }
    },

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