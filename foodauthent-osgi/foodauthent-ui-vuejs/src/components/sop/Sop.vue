<template>

<div class="page-container">
    <md-app>
        <md-app-toolbar class="md-primary">
            <span class="md-title">SOP</span>
        </md-app-toolbar>
    <!--    <md-app-drawer md-permanent="full">
            <md-list v-for="route in this.$router.options.routes">
                <md-list-item>
                    <md-icon>label</md-icon>
                    <router-link :to="route.path" class="md-list-item-text">{{route.name}}</router-link>
                </md-list-item>
            </md-list>
        </md-app-drawer> -->

        <md-app-content>
            <b-card no-body>
                <b-tabs card>
                    <b-tab title="Results" active>
                         <generalTable :items="items" :fields="fields" :schema.sync="schema" :currentPage="currentPage" :perPage.sync="perPage" :filter.sync="filter" :resultsCount="resultsCount" :selected="selected" :pageCount="pageCount" :refresh="loadTableData" :myPaginationHandler="myPaginationHandler"
                        :pageOptionsPerPage.sync="pageOptionsPerPage" :model.sync="model" :search="search" :myRowClickHandler="myRowClickHandler" :handleEditOk="handleEditOk" :itemsMetadata.sync="itemsMetadata" :pageType="pageType" :schemaIdHolder="schemaIdHolder" :hasEdit="hasEdit">
                        </generalTable>
                    </b-tab>
                    <b-tab id="SopForm" title="Create new">
                        <generalForm :schema="schema" :model="model" :schemas="schemas" :options="formOptions" :save="save" :cancel="cancel" :pageType="pageType" :schemaIdHolder="schemaIdHolder" :response="response" :showSuccess="showSuccess" :showError="showError" :loading="loading"></generalForm>
                    </b-tab>
                </b-tabs>
            </b-card>
        </md-app-content>
    </md-app>

</div>


</template>

<script>
import generalTable from '@/components/general/GeneralTable';
import generalForm from '@/components/general/GeneralForm';

var getSops = require("@/utils/sopFunction.js").default.getSops;
var deleteSop = require("@/utils/commonFunction.js").default.deleteEntity;
var findSopById = require("@/utils/sopFunction.js").default.findSopById;
var saveSop = require("@/utils/sopFunction.js").default.saveSop;
var saveFile = require("@/utils/fileFunction.js").default.saveFile;
import jsonschema from "@/generated/schema/sop.json";
var getModelSchemas = require("@/utils/commonFunction.js").default.getModelSchemas;
var getCustomMetadata = require("@/utils/commonFunction.js").default.getCustomMetadata;
var deleteFile = require("@/utils/fileFunction.js").default.deleteFile;

console.log(jsonschema.fields);

var schemas = [];

export default {
    data() {
        return {
            items: [],
            fields: jsonschema.fields,
            currentPage: 1,
            perPage: 10,
            filter: null,
            model: {},
            response: "",
            pageType: "sop",
            hasEdit: false,
            loading: false,
            schemas: schemas,
            itemsMetadata: {},
            resultsCount: 1,
            selected: {},
            showSuccess: false,
            showError: false,
            schemaIdHolder: {
			    schemaID: "withOutSchema"
			},
            pageCount: 0,
            schema: jsonschema,
            pageOptionsPerPage: [5, 10, 25, 50, 100],
            formOptions: {
		        validateAfterLoad: true,
		        validateAfterChanged: true
		    }
        };
    },
    mounted() {
     if(this.$route.query.faid != null || typeof this.$route.query.faid !== 'undefined'){
    this.filter = this.$route.query.faid;
    }
        this.loadTableData();
    },
    methods: {
           search() {
                let self = this;
                //check if it is a valid UUID
                var re = new RegExp("^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$");
                if (re.test(self.filter)) {
                    findSopById(self);
                } else {
                    getSops(self);
                }
            },
            myPaginationHandler(page) {
                let self = this;
                self.currentPage = page;
                getSops(self);
                self.currentPage = 1;
            },
            loadTableData() {
                console.log("Load table data");
                let self = this;
                console.log("current page", self.currentPage);
                console.log("per page", self.perPage);
                getSops(self);
            },
            save() {
                let self = this;
                self.loading = true;
                console.log("POST BODY", JSON.stringify(self.model, undefined, 4));
                saveSop(JSON.stringify(self.model, undefined, 4), self);
                self.model = {};
            },
            cancel() {
                let self = this;
                if(self.model["file-id"] != "" && self.model["file-id"] != null){
                deleteFile(self.model["file-id"]);
                }
                self.model = {};
            },
            myRowClickHandler(record, index) {
		       console.log(record); // This will be the item data for the row
		       this.selected = record;
            },
            handleEditOk() {
                let self = this;
                console.log("This is the model", self.model);
            },
                myRowClickHandler(record, index) {
                this.selected = record;
            }
    },
    components: {
        generalTable,
        generalForm
    }
}

</script>