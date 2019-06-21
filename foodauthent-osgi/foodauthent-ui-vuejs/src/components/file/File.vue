<template>

<div class="page-container">
    <md-app>
        <md-app-toolbar class="md-primary">
            <span class="md-title">File</span>
        </md-app-toolbar>
      <!--  <md-app-drawer md-permanent="full">
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
                        <generalTable :items="items" :fields="fields" :schema.sync="schema" :currentPage="currentPage" :perPage.sync="perPage" :filter.sync="filter" :resultsCount="resultsCount" :selected="selected" :pageCount="pageCount" :loadTableData="loadTableData" :myPaginationHandler="myPaginationHandler"
                        :pageOptionsPerPage.sync="pageOptionsPerPage" :search="search" :handleDeleteOk="handleDeleteOk" :myRowClickHandler="myRowClickHandler" :handleEditOk="handleEditOk"  :pageType="pageType" :schemaIdHolder="schemaIdHolder">
                            <slot></slot>
                        </generalTable>
                    </b-tab>
                    <b-tab title="Import File">
                        <generalForm :schema="schema" :model.sync="model" :schemas="schemas" :options="formOptions" :save="save" :pageType="pageType" :schemaIdHolder="schemaIdHolder" :response="response" :showSuccess="showSuccess" :showError="showError" :loading="loading"></generalForm>
                    </b-tab>
                </b-tabs>
            </b-card>
        </md-app-content>
    </md-app>

</div>


</template>

<script>
import generalTable from '@/components/file/FileTable';
import generalForm from '@/components/general/GeneralForm';

var getAllFiles = require("@/utils/fileFunction.js").default.getAllFiles;
var importFile = require("@/utils/fileFunction.js").default.importFile;
import jsonschema from "@/generated/schema/importfile.json";



console.log(jsonschema.fields);

var schemas = [];

export default {
    data() {
        return {
            items: [],
            fields: [],
            currentPage: 1,
            perPage: 10,
            filter: null,
            model: {},
            response: "",
            pageType: "noType",
            loading: false,
            schemas: schemas,
            itemsMetadata: {},
            resultsCount: 1,
            selected: {},
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
                getAllFiles(self);
            },
            myPaginationHandler(page) {
                let self = this;
                self.currentPage = page;
                getAllFiles(self);
                self.currentPage = 1;
            },
            loadTableData() {
                console.log("Load table data");
                let self = this;
                console.log("current page", self.currentPage);
                console.log("per page", self.perPage);
                getAllFiles(self);
            },
            save() {
                let self = this;
                self.loading = true;
                console.log("POST BODY", JSON.stringify(self.model, undefined, 4));
                console.log("FILE ID", self.model["file-id"]);
                importFile(self.model["file-id"], self);
                self.model = {}
            },
            myRowClickHandler(record, index) {
		       console.log(record); // This will be the item data for the row
		       this.selected = record;
            },
            handleDeleteOk() {
                let self = this;
                console.log("fa-id:", self.selected["fa-id"]);
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
