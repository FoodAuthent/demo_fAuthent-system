<template>

<div id="predictionTable">
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
                        <b-form-input v-model="filter" placeholder="Type to Search" />
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
        				 
		 <!-- LINK for model since it is not present in jsonschema it is hardcoded -->
		 <template slot="model-id" slot-scope="data">
		 			<b-button variant="link"v-b-modal.linkModal @click="linkFunction(data.value, 'model-id')" >{{ data.value }}</b-button>
		 </template> 
        
    </b-table>

    <!-- PAGINATION -->
    <b-pagination v-on:input="myPaginationHandler(currentPage)" :total-rows="resultsCount" :per-page="perPage" v-model="currentPage" />


    
        <!-- MODAL LINK -->
        <b-modal id="linkModal" scrollable size="xl" title="INFO">
        <div class="panel panel-default">
        <!-- TABLE TO DISPLAY THE RESULT 
        <b-table responsive :items="itemLink"></b-table> -->
        <!-- JSON RESULT -->
        <div class="panel-body">
             <pre v-html="JSON.stringify(itemLink, undefined, 4)"></pre>
         </div>
        </div>
    </b-modal>

</div>

</template>

<script>
var getTrainingJobs = require("@/utils/workflowFunction.js").default.getTrainingJobs;
var findTrainingJobsByKeyword = require("@/utils/workflowFunction.js").default.findTrainingJobsByKeyword;
var findTrainingJobsById = require("@/utils/workflowFunction.js").default.findTrainingJobsById;
var getLinkInfo = require("@/utils/commonFunction.js").default.getLinkInfo;
export default {
    name: "Workflow",
    data() {
        return {
            items: [],
            selected: {},
            prediction: {},
            fields: [],
            currentPage: 1,
            resultsCount: 1,
            itemLink: null,
            pageCount: 0,
            perPage: 10,
            sortBy: "id",
            sortDesc: false,
            filter: null,
            pageOptionsPerPage: [10, 25, 50, 100]
        };
    },
    mounted() {
        this.loadTableData();
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
                getTrainingJobs(self);
            },
            search() {
                let self = this;
                //check if it is a valid UUID
                var re = new RegExp("^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$");
                if (re.test(self.filter)) {
                    findTrainingJobsById(self);
                } else {
                    findTrainingJobsByKeyword(self);
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
                getPredictionJobs(self);
                self.currentPage = 1;
            },
            myRowClickHandler(record, index) {
                // 'record' will be the row data from items
                // `index` will be the visible row number (available in the v-model 'shownItems')
                //console.log(record); // This will be the item data for the row
                this.selected = record;
            },
            onFiltered(filteredItems) {
                // Trigger pagination to update the number of buttons/pages due to filtering
                this.totalRows = filteredItems.length;
                this.currentPage = 1;
            },
	         linkFunction(faId,infoType){
	            let self = this;
	            console.log("faId: ", faId);
	            console.log("infoType: ", infoType);
				getLinkInfo(faId,infoType,self );
            }
    }
};

</script>
