<template>
<div class="field-wrap">
        <input
        class="form-control"
        type="text"
        v-model="value"
        :disabled="disabled"
        :maxlength="schema.max"
        :placeholder="schema.placeholder"
        :readonly="schema.readonly"
        :idprovider="schema.idprovider"
        :buttonLabel="schema.buttonLabel">

<!-- MODAL SEARCH -->
 <!--<b-modal :id="schema.modalId" :title="schema.modalId" size="lg">-->
<b-modal :id="schema.idprovider" scrollable :title="schema.idprovider" size="xl" @show="loadData" @cancel="handleCancel" @ok="handleOk" @close="handleCancel">
<!-- Table -->
<template>
<div id="searchtable">
  <!-- <b-form-group horizontal label="SEARCH" class="mb-1">
          <b-input-group>
            <b-form-input v-model="filter" placeholder="Type to Search" />
            <b-input-group-append>
              <b-btn :disabled="!filter" @click="filter = ''">Clear</b-btn>
            </b-input-group-append>
          </b-input-group>
        </b-form-group> -->
       <!-- <b-btn id="refreshTableModal" isHidden=true variant="primary" size="sm" @click="loadData"><md-icon>autorenew</md-icon></b-btn> -->
         <b-form-group horizontal label="SEARCH" class="mb-50">
          <b-input-group>
            <b-form-input v-model="filter" placeholder="Search for gtin/id or keywords" />
            <b-input-group-append>
            <b-btn :disabled="!filter" variant="primary" @click="search">Search</b-btn>
              <b-btn :disabled="!filter" @click="clearSearch">Clear</b-btn>
            </b-input-group-append>
          </b-input-group>
        </b-form-group>
          
<!-- TABLE -->

  <b-table bordered striped hover show-empty responsive
         :sort-by.sync="sortBy"
         :sort-desc.sync="sortDesc"
         :items="items"
         :fields="fields"
         :current-page="currentPage"
         :per-page="perPage"

         @row-clicked="myRowClickHandler"
>
</b-table>
<!--<b-pagination :total-rows="items.length" :per-page="perPage" v-model="currentPage" /> -->
<!-- PAGINATION -->
<b-pagination v-on:input="myPaginationHandler(currentPage)" :total-rows="resultsCount" :per-page="perPage" v-model="currentPage" />

</div>
</template>
  </b-modal>
  </div>
</template>



<script>
import VueFormGenerator from "vue-form-generator";
var getProducts = require("@/utils/productFunction.js").default.getProducts;
var getFingerprints = require("@/utils/fingerprintFunction.js").default.getFingerprints;
var getWorkflows = require("@/utils/workflowFunction.js").default.getWorkflows;
var getModels = require("@/utils/modelFunction.js").default.getModels;
var getSops = require("@/utils/sopFunction.js").default.getSops;

var findProductByGtin = require("@/utils/productFunction.js").default.findProductByGtin;
var findFingerprintById = require("@/utils/fingerprintFunction.js").default.findFingerprintById;
var findWorkflowById = require("@/utils/workflowFunction.js").default.findWorkflowById;
var findModelById = require("@/utils/modelFunction.js").default.findModelById;
var findSopById = require("@/utils/sopFunction.js").default.findSopById;

const regex1 = new RegExp("^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$");
const regex2 = /\b\d{8}(?:\d{4,6})?\b/;
export default {
  mixins: [VueFormGenerator.abstractField],
  data() {
    return {
      items: [],
      fields: null,
      currentPage: 1,
      perPage: 10,
      sortBy: "id",
      resultsCount: 1,
      sortDesc: false,
      filter: null
    };
  },
  methods: {
    loadData() {
      let self = this;
      document.body.classList.add("modal-open");
      if (this.schema.idprovider == "select-product") {
        getProducts(self);
      } else if (this.schema.idprovider == "select-fingerprint") {
      //todo create another endpoint to retrieve fingerprint and not fingerprintSET
        getFingerprints(self);
      }  else if (this.schema.idprovider == "select-workflow") {
        getWorkflows(self);
      } else if (this.schema.idprovider == "select-model") {
        getModels(self);
      } else if (this.schema.idprovider == "select-sop") {
        getSops(self);
      } else {
        console.log("NO method found");
      }
      document.body.classList.remove("modal-open");
    },
    myRowClickHandler(record, index) {
      this.value = record[this.schema.fieldName];
    },
   // onFiltered(filteredItems) {
    //  this.totalRows = filteredItems.length;
    //  this.currentPage = 1;
   // },
   //Manage the pagination, when a page number is pressed this call the API to get the results for the new page
    myPaginationHandler(page){
    	let self = this;
    	self.currentPage = page;
    	getProducts(self);
    	self.currentPage = 1;
    },
    clearSearch(){
    	this.filter = null;
    	this.loadData();
    	//document.getElementById("refreshTableModal").click();
    },
    handleCancel() {
    this.value = "";
    console.log("Inside hadle cancel modal");
    document.body.classList.remove("modal-open");
    },
    handleOk(){
    console.log("Inside hadle ok modal");
    document.body.classList.remove("modal-open");
    },
    search() {
      let self = this;
      if (this.schema.idprovider == "select-product") {
        self.searchProduct();
      } else if (this.schema.idprovider == "select-fingerprint") {
        self.searchFingerprints();
      }  else if (this.schema.idprovider == "select-workflow") {
        self.searchWorkflow();
      } else if (this.schema.idprovider == "select-model") {
        self.searchModel();
      }else if (this.schema.idprovider == "select-sop") {
        self.searchSop();
      } else {
        alert("NO method found");
      }
    },
    searchProduct(){
    	let self = this;
		let m;
		//check if is a valid gtin
		if ((m = regex2.exec(self.filter)) !== null) {
			findProductByGtin(self);
		}else{
			getProducts(self);
		}
	},
	searchFingerprints(){
    	let self = this;
    	console.log("Inside search fingeprint select provider etc");
	    //fingerprint can be only searched by ID
	   		findFingerprintById(self);
    },
    searchWorkflow(){
    	let self = this;
	    //check if it is a valid UUID
		if (regex1.test(self.filter)) {
	    	findWorkflowById(self);
			} else {
	   		 getWorkflows(self);
			}
    },
    searchModel(){
    	let self = this;
	    //check if it is a valid UUID
		if (regex1.test(self.filter)) {
	    	findModelById(self);
			} else {
	   		getModels(self);
			}
    },
        searchSop(){
    	let self = this;
	    //check if it is a valid UUID
		if (regex1.test(self.filter)) {
	    	findSopById(self);
			} else {
	   		getSops(self);
			}
    },
  },
  computed: {
    sortOptions() {
      // Create an options list from our fields
      return this.fields.filter(f => f.sortable).map(f => {
        return { text: f.label, value: f.key };
      });
    }
  }
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
