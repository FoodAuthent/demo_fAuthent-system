<template>

<div class="container" id="sopContainer">
    <b-alert
      :show="showSuccess"
      dismissible
      variant="success"
      @dismissed="showSuccess=0"
    >
        <p>Operation success</p>
    </b-alert>
    <b-alert :show="showError" dismissible variant="danger" @dismissed="showError=false">
        <p>There is a problem {{response}}</p>
    </b-alert>

    <div class="panel panel-default">
        <div class="panel panel-default">
            <div class="panel-heading">SOP FORM</div>
            <div class="panel-body">
                <vue-form-generator :schema="schema" :model="model" :options="formOptions">
                </vue-form-generator>
            </div>
        </div>
        <div role="tablist">
            <b-card no-body class="mb-1" v-for="(currentschema, key, index) in schemas">
                <b-card-header header-tag="header" class="p-1" role="tab">
                    <b-btn block v-b-toggle="'accordion'+key" variant="info">{{currentschema.title}}</b-btn>
                </b-card-header>
                <b-collapse :id="'accordion'+key" visible accordion="my-accordion" role="tabpanel">
                    <b-card-body>
                        <vue-form-generator :schema="currentschema" :model="currentschema.model" :options="formOptions">
                        </vue-form-generator>
                        <pre v-if="model" v-html="JSON.stringify(currentschema.model, undefined, 4)"></pre>
                    </b-card-body>
                </b-collapse>
            </b-card>
        </div>


        <div class="button-div">
            <b-button variant="primary" @click="save()">Save</b-button>
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

var saveSop = require("@/utils/sopFunction.js").default.saveSop;
var saveFile = require("@/utils/fileFunction.js").default.saveFile;
import jsonschema from "@/generated/schema/sop.json";
var getModelSchemas = require("@/utils/commonFunction.js").default.getModelSchemas;

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

            var buttton = [{
                classes: "btn-location",

                label: currentField.idprovider,

                onclick: getFun(currentField.idprovider)
            }];

            currentField.buttons = buttton;
        }
    }
}
var schemas = []
var vueObject = {
    schema: jsonschema,
    schemas: schemas,
    model: {},
    response: "",
    showSuccess: 0,
    showError: 0,
    formOptions: {
        validateAfterLoad: true,
        validateAfterChanged: true
    }
}
export default {
    data() {
            return vueObject;
        },
        mounted() {
            getModelSchemas("sop", schemas);
            console.log("Schemas", schemas);
        },

        methods: {
            loadFile() {
                    console.log("FILE:", this.file);
                },
                save() {
                    let self = this;
                    console.log("POST BODY", JSON.stringify(self.model, undefined, 4));
                    saveSop(JSON.stringify(self.model, undefined, 4), self);
                    self.model={};
                }
        },

        components: {
            "vue-form-generator": VueFormGenerator.component
        }
};

</script>