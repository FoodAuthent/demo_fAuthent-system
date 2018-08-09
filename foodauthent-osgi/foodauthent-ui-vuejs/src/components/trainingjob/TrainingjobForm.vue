<template>
  <div class="container" id="app2">
    <div class="panel panel-default">
      <div class="panel-heading">Create new Training Job</div>
      <div class="panel-body">
        <vue-form-generator :schema="schema" :model="model" :options="formOptions">
        </vue-form-generator>
         <div class="button-div"> <b-button variant="primary" @click="save()">Save</b-button></div>
      </div>
    </div>

   <div class="panel panel-default">
      <div class="panel-heading">Request Parameters</div>
      <div class="panel-body">
        <pre v-if="model" v-html="prettyJSON(model)"></pre>
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
import jsonschema from "@/schema/createTrainingJob.json";
import { EndpointUrl } from "../../config.js";

export default {
  data() {
    return {
      schema: jsonschema,
      model: {},
      response: "",
      endpointurl: EndpointUrl.TRAININGJOBURL,
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
      //var ApiClient = require("../../generated/rest-client/src/ApiClient.js");
      //var apiClient = new ApiClient();
      //var WorkflowApi = require("../../generated/rest-client/src/api/WorkflowApi.js");
      //var workflowApi = new WorkflowApi(apiClient);
      //var callback = function(error, data, response) {
      //  if (error) {
      //    this.response = result.data;
      //    console.error(error);
      //  } else {
      //    this.reponse = result.data;
      //    console.log("API called successfully. Returned data: " + data);
      //  }
      //};
      //workflowApi.createTrainingJob(
      //  this.model["workflow-id"],
      //  this.model["fingerprintset-id"],
      //  callback
      //    );

      this.response = "";
      //TODO: do better and use auto-generated js-client
      let urlWithParams =
        this.endpointurl +
        "?workflow-id=" +
        this.model["workflow-id"] +
        "&fingerprintset-id=" +
        this.model["fingerprintset-id"];
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
