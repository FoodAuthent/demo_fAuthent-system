<template>

<div id="sampleTable">
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
                        <!--<b-form-input v-model="filter" placeholder="Type to Search for id or keyword" />-->
                        <b-form-input v-model="filterVal" @change="onSearch" placeholder="Type to Search for id or keyword" />
                        <b-input-group-append>
                            <b-btn :disabled="!filterVal" variant="primary" @click="search">Search</b-btn>
                            <b-btn :disabled="!filterVal" @click="clearSearch">Clear</b-btn>
                        </b-input-group-append>
                    </b-input-group>
                </b-form-group>
            </b-col>
        </b-row>
        <b-row>
            <!-- TABLE -->
            <b-table bordered striped hover show-empty responsive :items="items" :fields="fields" :current-page="currentPage" :per-page="perPage" @row-clicked="myRowClickHandler">
                <template slot="actions" slot-scope="row">
                    <div class="widewidth">
                       <b-btn size="sm" v-b-modal.modalEdit @click.stop="info(row.item, row.index, $event.target)">
                           <md-icon>update</md-icon>
                        </b-btn> 
                        <b-btn size="sm"  @click.stop="dowloadFile(row.item, row.index, $event.target)">
                            <md-icon>get_app</md-icon>
                        </b-btn>
                        <b-btn size="sm" v-b-modal.modalDelete @click.stop="showDelete(row.item, row.index, $event.target)">
                            <md-icon>delete_forever</md-icon>
                        </b-btn>
                    </div>
                </template>
            </b-table>
        </b-row>
    </b-container>



    <!-- PAGINATION -->
    <b-pagination v-on:input="myPaginationHandler(currentPage)" :total-rows="resultsCount" :per-page.sync="perPage" v-model="currentPage" />

    <!-- MODAL FILE UPDATE -->
    <b-modal id="modalEdit" title="update file" @ok="handleEditOk">
       <!-- <vue-form-generator :schema="schema" :model="model" :options="formOptions"> </vue-form-generator>-->
           <b-form-file
		      v-model="file"
		      :state="Boolean(file)"
		      placeholder="Choose a file..."
		      drop-placeholder="Drop file here..."
		    ></b-form-file>
    <!--<div class="mt-3">Selected file: {{ file ? file.name : '' }}</div>-->
    </b-modal>
    

    <!-- MODAL Delete -->
    <b-modal id="modalDelete" title="Delete" @ok="handleDeleteOk">
        <p>Are you sure do you want to delete this record?</p>
        <pre v-if="selected" v-html="JSON.stringify(itemsDelete, undefined, 4)"></pre>
    </b-modal>

</div>

</template>

<script>
var schemaIdHolder = {
    "schemaID": "withOutSchema"
};

var getModelSchemas = require("@/utils/commonFunction.js").default.getModelSchemas;
var deleteEntity = require("@/utils/commonFunction.js").default.deleteEntity;
var downloadFile = require("@/utils/fileFunction.js").default.downloadFile;
var deleteFile = require("@/utils/fileFunction.js").default.deleteFile; 
var updateFile = require("@/utils/fileFunction.js").default.updateFile; 

export default {
    props: {
        items: Array,
        fields: Array,
        currentPage: Number,
        perPage: Number,
        filter: Array,
        resultsCount: Number,
        selected: Object,
        pageCount: Number,
        schema: Object,
        model: Object,
        pageType: String,
        schemaIdHolder: Object,
        pageOptionsPerPage: Array,
        search: {
            type: Function,
            required: true
        },
        myPaginationHandler: {
            type: Function,
            required: true
        },
        myRowClickHandler: {
            type: Function,
            required: true
        },
        loadTableData: {
            type: Function,
            required: true
        }
    },
    data() {
        return {
            filterVal: '',
            itemsDelete: null,
            file: null
             }
    },
    mounted() {
        this.onProp(this.filter);
        this.$watch('filter', this.onProp);
        if(this.pageType != 'noType'){
        getModelSchemas(this.pageType, {}, this.schemaIdHolder);
        }
    },
    methods: {
        onProp(filter) {
                this.filterVal = filter;
            },
            onSearch() {
                this.$emit('update:filter', this.filterVal)
            },
            clearSearch() {
                this.$emit('update:filter', null);
                this.$emit('update:filterVal', null)
                document.getElementById("refreshTable").click();
            },
            perPagehandler(newObjectState) {
                let self = this;
                self.currentPage = 1; //just a workaround to go back in page 1
                self.perPage = newObjectState;
                self.$emit('update:perPage', newObjectState);
                document.getElementById("refreshTable").click();
            },
            info(item, index, button) {
                this.model = item;
                console.log("Model modal", this.model);
                this.$root.$emit('bv::show::modal', 'modalEdit', button);
            },
             showDelete(item, index, button) {
                let self = this;
               console.log("ITEM", item);
               self.itemsDelete = item
                console.log("General selected", self.itemsDelete);
                this.$root.$emit('bv::show::modal', 'modalDelete', button);
            },
            handleEditOk() {
            let self = this;
			//console.log("FILE MODEL ", self.model);
			console.log("FILE UPDATE ");
			var fileId = self.model['fa-id'];
			updateFile(fileId, self.file, self);
            },
               handleDeleteOk() {
                let self = this;
                console.log("fa-id:", self.itemsDelete["fa-id"]);
                deleteFile(self.itemsDelete["fa-id"], self);
            },
           dowloadFile(item, index, button) {
               let self = this;
               console.log("DWNLOAD ITEM", item);
              downloadFile(item["fa-id"], item["uploadName"], self);
            },
            onFiltered(filteredItems) {
                // Trigger pagination to update the number of buttons/pages due to filtering
                this.totalRows = filteredItems.length;
                this.currentPage = 1;
            }
    }
}

</script>