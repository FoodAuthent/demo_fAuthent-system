<template>

<div class="container" id="productContainer">
    <b-alert :show="showSuccess" dismissible variant="success" @dismissed="showSuccess=0">
        <p>Operation success</p>
    </b-alert>
    <b-alert :show="showError" dismissible variant="danger" @dismissed="showError=false">
        <p>There is a problem {{response}}</p>
    </b-alert>
    <div class="panel panel-default">
        <div class="panel panel-default">
            <div class="panel-heading">Product FORM</div>
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
                <b-collapse :id="'accordion'+key" visible=false accordion="my-accordion" role="tabpanel">
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
var saveProducts = require("@/utils/productFunction.js").default.saveProducts;
var getModelSchemas = require("@/utils/commonFunction.js").default.getModelSchemas;
import jsonschema from "@/generated/schema/product.json";
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
            getModelSchemas("product", schemas);
            console.log("Schemas", schemas);
        },
        methods: {
            save() {
                    let self = this;
                    // console.log("POST BODY", JSON.stringify(this.model, undefined, 4));
                    saveProducts(JSON.stringify(this.model, undefined, 4), self);
                    self.model = {}
                },
                editRecord(modelEdit) {
                    let self = this;
                    console.log("modelEdit", modelEdit);
                    self.model = modelEdit;
                    console.log("ONCLICK");
                    // document.getElementById("buttonMax").click();
                    console.log("modelEdit", modelEdit);
                    console.log("modelTest", self.model);

                }
        },
        components: {
            "vue-form-generator": VueFormGenerator.component
        }
};

</script>