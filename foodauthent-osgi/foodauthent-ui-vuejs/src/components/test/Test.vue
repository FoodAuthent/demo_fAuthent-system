<template>

<div class="page-container">
    <md-app>
        <md-app-toolbar class="md-primary">
            <span class="md-title">TEST</span>
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
                        <generalTable :filter.sync="filter" :items="items" :fields="fields" :current-page="currentPage" :per-page="perPage" :filter.sync="filter" :resultsCount="resultsCount" :selected="selected" :pageCount="pageCount" :onClick="loadTableData" :myPaginationHandler="myPaginationHandler"
                        :pageOptionsPerPage="pageOptionsPerPage" :search="search">
                            <slot></slot>
                        </generalTable>
                    </b-tab>
                    <b-tab title="Form">
                        <generalForm :schema="schema" :model="model" :schemas.sync="schemas" :options="formOptions" :save="save"></generalForm>
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
var getProducts = require("@/utils/productFunction.js").default.getProducts;
var findProductByGtin = require("@/utils/productFunction.js").default.findProductByGtin;
var saveProducts = require("@/utils/productFunction.js").default.saveProducts;
import jsonschema from "@/generated/schema/product.json";
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
export default {
    name: 'Test',
    data() {
        return {
            items: [],
            fields: [],
            currentPage: 1,
            perPage: 10,
            filter: null,
            model: {},
            schemas: schemas,
            resultsCount: 1,
            selected: {},
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
        getModelSchemas("product", schemas);
        console.log("Schemas", schemas);
    },
    methods: {
        search() {
        console.log("inside search");
                const regex = /\b\d{8}(?:\d{4,6})?\b/;
                let self = this;
                var str = self.filter;
                console.log("Filter in search", str);
                let m;
                if ((m = regex.exec(str)) !== null) {
                    findProductByGtin(self);
                } else {
                    getProducts(self);
                }
            },
            myPaginationHandler(page) {
                let self = this;
                self.currentPage = page;
                getProducts(self);
                self.currentPage = 1;
            },
            loadTableData() {
                console.log("Load table data");
                let self = this;
                getProducts(self);
            },
            save() {
                let self = this;
                console.log("POST BODY", JSON.stringify(this.model, undefined, 4));
                saveProducts(JSON.stringify(this.model, undefined, 4), self);
                self.model = {}
            },
    },
    components: {
        generalTable,
        generalForm
    }
}

</script>