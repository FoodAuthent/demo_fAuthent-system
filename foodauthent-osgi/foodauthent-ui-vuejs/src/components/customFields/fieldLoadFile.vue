<template>

<div class="field-wrap">
    <input class="form-control" type="text" v-model="value" :disabled="disabled" :maxlength="schema.max" :placeholder="schema.placeholder" :readonly="schema.readonly" :idprovider="schema.idprovider" :buttonLabel="schema.buttonLabel">

    <!-- MODAL FILE FORM -->
    <b-modal :id="schema.idprovider" :title="schema.idprovider" size="lg" @ok="loadFile" @cancel="handleCancel">
        <template>
            <div class="container" id="fileForm">
                <div class="panel panel-default">
                    <div class="panel-heading">FILE FORM</div>
                    <div class="panel-body">
                        <vue-form-generator :schema="schemaFile" :model="modelFile" :options="formFileOptions">
                        </vue-form-generator>
                        <b-form-file v-model="file" :state="Boolean(file)" placeholder="Choose a file..."></b-form-file>
                    </div>
                </div>
            </div>

            <div class="panel panel-default">

                <div class="panel-heading">Model</div>

                <div class="panel-body">

                    <pre v-if="modelFile" v-html="JSON.stringify(modelFile, undefined, 4)"></pre>

                </div>

            </div>
        </template>
    </b-modal>
</div>

</template>

<script>

import VueFormGenerator from "vue-form-generator";
import jsonschemafile from "@/generated/schema/filemetadata.json";
var createFileMetadata = require("@/utils/fileFunction.js").default.createFileMetadata;
var uploadFile = require("@/utils/fileFunction.js").default.uploadFile;
export default {
    mixins: [VueFormGenerator.abstractField],
    data() {
        return {
            schemaFile: jsonschemafile,
            modelFile: {},
            response: "",
            file: null,
            formFileOptions: {
                validateAfterLoad: true,
                validateAfterChanged: true
            }
        };
    },
    methods: {
        loadFile() {
                let self = this;
                console.log("Model file",self.modelFile);
                if (typeof self.modelFile !== 'undefined' || self.modelFile != null){
                createFileMetadata(JSON.stringify(self.modelFile, undefined, 4), self.file, self);
                }
                document.body.classList.remove("modal-open");
            },
            handleCancel() {
                this.value = "";
                document.body.classList.remove("modal-open");
            }
    },
    computed: {}
};

</script>
<style>

.field-wrap {
    width: 100%;
}

.input-group {
    flex-wrap: nowrap;
}

</style>
