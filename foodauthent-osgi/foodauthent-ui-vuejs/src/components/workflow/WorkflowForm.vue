<template>
  <div class="container" id="app2">
    <div class="panel panel-default">
      <div class="panel-heading">WORKFLOW FORM</div>
      <div class="panel-body">
        <vue-form-generator :schema="schema" :model="model" @model-updated="testFunction" :options="formOptions">
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

    <!-- Product Search -->
  <b-modal id="modal10" title="Product Search">

   <template>
   <div class="button-div"> <b-button variant="primary" @click="search()">Search</b-button></div>
    <b-table striped hover :items="items" :fields="fields"  @row-clicked="myRowClickHandler">
      <template slot="actions" scope="items">
    <b-btn size="sm" @click="testFunction">Select</b-btn>
  </template>
    </b-table>

</template>
  </b-modal>

  </div>
</template>

<script>
import VueFormGenerator from "vue-form-generator";
import "vue-form-generator/dist/vfg.css";
//var getJSONSchema = require('@/generated/schema/workflow.js').default.getJSONSchema;
import jsonschema from '@/generated/schema/workflow.json';
import {EndpointUrl} from '../../config.js';
 export default {
    data() {
			return {
        //schema: getJSONSchema(),
        schema: jsonschema,
        model: {"product-id": "", "fa-id": "" },
        response: "",
        endpointurl : EndpointUrl.WORKFLOWURL,
        formOptions: {
            validateAfterLoad: true,
            validateAfterChanged: true
        },
        fields: [
        { key: 'first_name', sortable: true },
        { key: 'last_name', sortable: true },
        { key: 'age', sortable: true },
        { key: 'actions', sortable: false }
      ],
      items: null,
      productId: ""
			};
    },
      methods: {
        prettyJSON: function(json) {
            if (json) {
                json = JSON.stringify(json, undefined, 4);
                json = json.replace(/&/g, '&').replace(/</g, '<').replace(/>/g, '>');
                return json.replace(/("(\\u[a-zA-Z0-9]{4}|\\[^u]|[^\\"])*"(\s*:)?|\b(true|false|null)\b|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?)/g, function(match) {
                    var cls = 'number';
                    if (/^"/.test(match)) {
                        if (/:$/.test(match)) {
                            cls = 'key';
                        } else {
                            cls = 'string';
                        }
                    } else if (/true|false/.test(match)) {
                        cls = 'boolean';
                    } else if (/null/.test(match)) {
                        cls = 'null';
                    }
                    return '<span class="' + cls + '">' + match + '</span>';
                });
            }
        },
        search(){
          this.items = [
        { isActive: true, age: 40, first_name: 'Dickerson', last_name: 'Macdonald' },
        { isActive: false, age: 21, first_name: 'Larsen', last_name: 'Shaw' },
        { isActive: false, age: 89, first_name: 'Geneva', last_name: 'Wilson' },
        { isActive: true, age: 38, first_name: 'Jami', last_name: 'Carney' }
      ]
        },
          myRowClickHandler(record, index) {
    // 'record' will be the row data from items
    //console.log(record); // This will be the item data for the row
   console.log("First name: ",record.first_name);
   this.model["product-id"] = record.first_name;
   this.productId = record.first_name;
    //console.log("productId : ",this.productId);
  },
  testFunction(par1, par2){
  console.log("HERE",this.model);
  },
          save() {
          console.log("URL",this.endpointurl);
          console.log(JSON.stringify(this.model, undefined, 4));
            this.response = "";
                this.$http.post(this.endpointurl, JSON.stringify(this.model, undefined, 4), { headers: { "content-type": "application/json" } }).then(result => {
                    this.response = result.data;
                }, error => {
                    console.error(error);
                    this.response = error;
                });
            }
        },
      components: {
        "vue-form-generator": VueFormGenerator.component
    }
  }
</script>


<style>

</style>
