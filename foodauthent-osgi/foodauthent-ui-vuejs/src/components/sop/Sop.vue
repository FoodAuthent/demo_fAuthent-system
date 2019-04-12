<template>

<div class="page-container">
    <md-app>
        <md-app-toolbar class="md-primary">
            <span class="md-title">SOP</span>
        </md-app-toolbar>
        <md-app-drawer md-permanent="full">
            <!--  <md-toolbar class="md-transparent" md-elevation="0">
          Navigation
        </md-toolbar> -->
            <md-list v-for="route in this.$router.options.routes">
                <md-list-item>
                    <md-icon>label</md-icon>
                    <router-link :to="route.path" class="md-list-item-text">{{route.name}}</router-link>
                </md-list-item>
            </md-list>
        </md-app-drawer>

        <md-app-content>
            <b-card no-body>
                <b-tabs card>
                    <b-tab title="Results" active>
                        <generalTable :items="items" :fields="fields" :schema.sync="schema" :currentPage="currentPage" :perPage.sync="perPage" :filter.sync="filter" :resultsCount="resultsCount" :selected="selected" :pageCount="pageCount" :refresh="loadTableData" :myPaginationHandler="myPaginationHandler"
                        :pageOptionsPerPage.sync="pageOptionsPerPage" :search="search" :handleDeleteOk="handleDeleteOk" :myRowClickHandler="myRowClickHandler" :handleEditOk="handleEditOk" :itemsMetadata.sync="itemsMetadata" :pageType="pageType" :schemaIdHolder="schemaIdHolder">
                            <slot></slot>
                        </generalTable>
                    </b-tab>
                    <b-tab title="Form">
                        <generalForm :schema="schema" :model="model" :schemas="schemas" :options="formOptions" :save="save" :pageType="pageType" :schemaIdHolder="schemaIdHolder"></generalForm>
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
var deleteSop = require("@/utils/sopFunction.js").default.deleteSop;
var findSopById = require("@/utils/sopFunction.js").default.findSopById;
var saveSop = require("@/utils/sopFunction.js").default.saveSop;
var saveFile = require("@/utils/fileFunction.js").default.saveFile;
import jsonschema from "@/generated/schema/sop.json";
var getModelSchemas = require("@/utils/commonFunction.js").default.getModelSchemas;
var getCustomMetadata = require("@/utils/commonFunction.js").default.getCustomMetadata;

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
            pageType: "sop",
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
                console.log("POST BODY", JSON.stringify(this.model, undefined, 4));
                saveSop(JSON.stringify(this.model, undefined, 4), self);
                self.model = {}
            },
            myRowClickHandler(record, index) {
		       console.log(record); // This will be the item data for the row
		       this.selected = record;
            },
            handleEditOk() {
                let self = this;
                console.log("This is the model", self.model);
            },
            handleDeleteOk() {
                let self = this;
                console.log("gtin:", self.selected["fa-id"]);
                deleteSop(self.selected["fa-id"], self);
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