<template>

<div id="fingerprintTable">
    <b-container fluid>
        <!-- UPDATE -->
        <b-row>
            <b-col>
                <b-btn id="refreshTable" variant="primary" size="sm" @click="loadTableData">
                    <md-icon>autorenew</md-icon>
                </b-btn>
            </b-col>
            <!-- PER PAGE -->
            <b-col class="my-1">
                <b-form-group horizontal label="PER PAGE" class="mb-0">
                    <b-form-select @change="perPagehandler($event)" :options="pageOptionsPerPage" v-model="perPage" />
                </b-form-group>
            </b-col>
            <!-- SEARCH -->
            <b-col class="my-1 col-sm-6">
                <b-form-group horizontal label="SEARCH" class="mb-50">
                    <b-input-group>
                        <b-form-input v-model="filter" placeholder="Type to Search for id or keyword" />
                        <b-input-group-append>
                            <b-btn :disabled="!filter" variant="primary" @click="search">Search</b-btn>
                            <b-btn :disabled="!filter" @click="clearSearch">Clear</b-btn>
                        </b-input-group-append>
                    </b-input-group>
                </b-form-group>
            </b-col>
        </b-row>
    </b-container>

    <!-- TABLE -->
    <b-table bordered striped hover responsive show-empty :sort-by.sync="sortBy" :sort-desc.sync="sortDesc" :items="items" :fields="fields" :current-page="currentPage" :per-page="perPage" @row-clicked="myRowClickHandler">
        <template slot="actions" slot-scope="row">
            <b-btn size="sm" v-b-modal.modalEdit @click.stop="info(row.item, row.index, $event.target)">
                <md-icon>edit</md-icon>
            </b-btn>
            <b-btn size="sm" v-b-modal.modalMeta @click.stop="showMetadata(row.item, row.index, $event.target)">
                <md-icon>search</md-icon>
            </b-btn>
            <b-btn size="sm" v-b-modal.modalDelete>
                <md-icon>delete_forever</md-icon>
            </b-btn>
        </template>
    </b-table>

    <!-- PAGINATION -->
    <b-pagination v-on:input="myPaginationHandler(currentPage)" :total-rows="resultsCount" :per-page="perPage" v-model="currentPage" />

    <!-- MODAL DETAILS -->
    <b-modal id="modalEdit" title="Edit" @ok="handleEditOk">
        <vue-form-generator :schema="schema" :model="model" :options="formOptions"> </vue-form-generator>
    </b-modal>

    <!-- MODAL METADATA -->
    <b-modal id="modalMeta" size="lg" title="Metadata" @ok="handleMetadataOk">
        <div class="panel panel-default">
            <div class="panel-heading">Metadata</div>
            <div class="panel-body">
                <pre v-if="model" v-html="JSON.stringify(itemsMetadata, undefined, 4)"></pre>
            </div>
        </div>
    </b-modal>

    <!-- MODAL Delete -->
    <b-modal id="modalDelete" title="Delete" @ok="handleDeleteOk">
        <p>Are you sure do you want to delete this record?</p>
        <pre v-if="selected" v-html="JSON.stringify(selected, undefined, 4)"></pre>
    </b-modal>

</div>

</template>

<script>

var getFingerprints = require("@/utils/fingerprintFunction.js").default.getFingerprints;
var deleteFingerprints = require("@/utils/fingerprintFunction.js").default.deleteFingerprints;
var findFingerprintSetById = require("@/utils/fingerprintFunction.js").default.findFingerprintById;
var getModelSchemas = require("@/utils/commonFunction.js").default.getModelSchemas;
var getCustomMetadata = require("@/utils/commonFunction.js").default.getCustomMetadata;
var schemaIdHolder = {
    "schemaID": "withOutSchema"
};
import jsonschema from "@/generated/schema/fingerprintset.json";
export default {
    name: "Fingerprints",
    data() {
        return {
            model: {},
            schema: jsonschema,
            itemsMetadata: {},
            formOptions: {
                validateAfterLoad: true,
                validateAfterChanged: true
            },
            items: [],
            selected: {},
            fields: [],
            currentPage: 1,
            resultsCount: 1,
            pageCount: 0,
            perPage: 10,
            sortBy: "id",
            shownItems: null,
            sortDesc: false,
            filter: null,
            pageOptionsPerPage: [10, 25, 50, 100]
        };
    },
    mounted() {
        this.loadTableData();
        getModelSchemas("fingerprintset", {}, schemaIdHolder);
    },
    computed: {
        sortOptions() {
            // Create an options list from our fields
            return this.fields.filter(f => f.sortable).map(f => {
                return {
                    text: f.label,
                    value: f.key
                };
            });
        }
    },
    methods: {
        loadTableData() {
                let self = this;
                getFingerprints(self);
            },
            search() {
                let self = this;
                //check if it is a valid UUID
                var re = new RegExp("^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$");
                if (re.test(self.filter)) {
                    findFingerprintSetById(self);
                } else {
                    getFingerprints(self);
                }
            },
            clearSearch() {
                this.filter = "";
                document.getElementById("refreshTable").click();
            },
            //Manage when the number of items displayed on the table change
            perPagehandler(newObjectState) {
                let self = this;
                self.currentPage = 0; //just a workaround to go back in page 1
                self.perPage = newObjectState;
                document.getElementById("refreshTable").click();
                // self.loadTableData();
            },
            //Manage the pagination, when a page number is pressed this call the API to get the results for the new page
            myPaginationHandler(page) {
                let self = this;
                self.currentPage = page;
                getFingerprints(self);
                self.currentPage = 1;
            },
            handleDeleteOk() {
                let self = this;
                console.log("fa-id:", this.selected["fa-id"]);
                deleteFingerprints(this.selected["fa-id"], self);
            },
            handleEditOk() {},
            myRowClickHandler(record, index) {
                this.selected = record;
            },
            info(item, index, button) {
                this.model = item;
                this.$root.$emit('bv::show::modal', 'modalEdit', button);
            },
            showMetadata(item, index, button) {
                let self = this;
                console.log("Call showMetadata");
                console.log("schemaIdHolder", schemaIdHolder.schemaID);
                getCustomMetadata("fingerprintset", schemaIdHolder.schemaID, item["fa-id"], self);
            },
            handleMetadataOk() {
                console.log("inside metadata table");
            },
            // onFiltered(filteredItems) {
            // Trigger pagination to update the number of buttons/pages due to filtering
            //  this.totalRows = filteredItems.length;
            // this.currentPage = 1;
            // }
    }
};

</script>
<style lang="scss" scoped>

.md-table + .md-table {
    margin-top: 16px;
}

.md-app {
    /*max-height: px; */
    border: 1px solid rgba(#000, 0.12);
}

.md-drawer {
    max-width: 250px;
}

</style>
