<template>

<div class="container" id="container">
      <div class="d-flex align-items-center" v-if="loading">
    		<strong>Saving...</strong>
    		<b-spinner variant="success" class="ml-auto"></b-spinner>
  		</div>
    <b-alert :show="showSuccess" dismissible variant="success" @dismissed="showSuccess=false">
        <p>Operation success</p>
    </b-alert>
    <b-alert :show="showError" dismissible variant="danger" @dismissed="showError=false">
        <p>There is a problem {{response}}</p>
    </b-alert>
    <div class="panel panel-default">
        <div class="panel panel-default">
            <div class="panel-heading">Create New</div>
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
            <b-button variant="primary" @click="save">Save</b-button>
            <b-button variant="warning" @click="cancel">Cancel</b-button>
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
var getModelSchemas = require("@/utils/commonFunction.js").default.getModelSchemas;
import VueFormGenerator from "vue-form-generator";
import "vue-form-generator/dist/vfg.css";

export default {
    props: {
        showSuccess: Number,
        showError: Number,
        schema: Object,
        schemas: Array,
        model: Object,
        formOptions: Object,
        schemaIdHolder: Object,
        pageType: String,
        loading: Boolean,
        save: {
            type: Function,
            required: true
        },
        cancel: {
            type: Function,
            required: true
        }
    },
    data() {
        return {
            }
    },
    methods: {
        
    },
    mounted() {
    if(this.pageType != 'noType'){
    getModelSchemas(this.pageType, this.schemas);
    console.log("Schemas", this.schemas);
    }
    },
        components: {
        "vue-form-generator": VueFormGenerator.component
    }
}

</script>