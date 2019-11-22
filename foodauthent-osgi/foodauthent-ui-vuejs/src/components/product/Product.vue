<template>

<div class="page-container">
    <md-app>
        <md-app-toolbar class="md-primary">
            <span class="md-title">PRODUCT</span>
        </md-app-toolbar>
      <!--   <md-app-drawer md-permanent="full">
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
                        :pageOptionsPerPage.sync="pageOptionsPerPage" :model.sync="model" :search="search" :myRowClickHandler="myRowClickHandler" :handleEditOk="handleEditOk" :itemsMetadata.sync="itemsMetadata" :pageType="pageType" :entity="entity" :schemaIdHolder="schemaIdHolder" :hasEdit="hasEdit">
                        </generalTable>
                    </b-tab>
                    <b-tab title="Create new">
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
var getProducts = require("@/utils/productFunction.js").default.getProducts;
var findProductByGtin = require("@/utils/productFunction.js").default.findProductByGtin;
var saveProducts = require("@/utils/productFunction.js").default.saveProducts;
var findProductById = require("@/utils/productFunction.js").default.findProductById;
var updateProducts = require("@/utils/productFunction.js").default.updateProducts;
import jsonschema from "@/generated/schema/product.json";



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
            pageType: "product",
            entity: "product",
            hasEdit: true,
            loading: false,
            schemas: schemas,
            showSuccess: false,
            showError: false,
            itemsMetadata: {},
            resultsCount: 1,
            selected: {},
            schemaIdHolder: {
			    schemaID: "withOutSchema"
			},
            formOptions: {
		        validateAfterLoad: true,
		        validateAfterChanged: true
		    },
            pageCount: 0,
            schema: jsonschema,
            pageOptionsPerPage: [5, 10, 25, 50, 100]
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
                    getProducts(self);
            },
            //not used
            searchByGtin() {
                const regex = /\b\d{8}(?:\d{4,6})?\b/;
                let self = this;
                var str = self.filter;
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
                self.loading = true;
                console.log("POST BODY", JSON.stringify(self.model, undefined, 4));
                saveProducts(JSON.stringify(self.model, undefined, 4), self);
                self.model = {}
            },
             cancel() {
                let self = this;
                self.model = {};
            },
            myRowClickHandler(record, index) {
		       console.log(record); // This will be the item data for the row
		       this.selected = record;
            },
            handleEditOk(modelUpdate) {
                let self = this;
                delete modelUpdate["actions"];
                updateProducts(JSON.stringify(modelUpdate, undefined, 4), self);
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