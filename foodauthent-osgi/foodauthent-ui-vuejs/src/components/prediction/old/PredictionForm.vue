<template>

<div class="container" id="app2">
    <div class="panel panel-default">
        <div class="panel-heading">Create new Prediction</div>
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
import jsonschema from '@/generated/schema/prediction.json';
import {
    EndpointUrl
}
from '../../config.js'
export default {
    data() {
            return {
                schema: jsonschema,
                model: {},
                response: "",
                endpointurl: EndpointUrl.PREDICTIONURL,
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
                this.$http.post(this.endpointurl, JSON.stringify(this.model, undefined, 4), {
                    headers: {
                        "content-type": "application/json"
                    }
                }).then(result => {
                    this.response = result.data;
                }, error => {
                    console.error(error);
                    this.response = error;
                });
            },
        },
        components: {
            "vue-form-generator": VueFormGenerator.component
        }
}

</script>
