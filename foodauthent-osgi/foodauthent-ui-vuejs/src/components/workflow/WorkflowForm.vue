<template>

<div class="container" id="workflowContainer">
    <b-alert :show="showSuccess" dismissible variant="success" @dismissed="showSuccess=false">
        <p>Operation success</p>
    </b-alert>
    <b-alert :show="showError" dismissible variant="danger" @dismissed="showError=false">
        <p>There is a problem {{response}}</p>
    </b-alert>
    <div class="panel panel-default">
        <div class="panel-heading">WORKFLOW FORM</div>
        <div class="panel-body">
            <vue-form-generator :schema="schema" :model="model" :options="formOptions">
            </vue-form-generator>
            <div class="button-div">
                <b-button variant="primary" @click="save()">Save</b-button>
            </div>
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
var saveWorkflow = require("@/utils/workflowFunction.js").default.saveWorkflow;
import jsonschema from "@/generated/schema/workflow.json";
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
                },
                fields: [],
                items: []
            };
        },
        methods: {
            save() {
                let self = this;
                console.log("POST BODY", JSON.stringify(this.model, undefined, 4));
                saveWorkflow(JSON.stringify(this.model, undefined, 4), self);
            }
        },
        components: {
            "vue-form-generator": VueFormGenerator.component
        }
};

</script>
