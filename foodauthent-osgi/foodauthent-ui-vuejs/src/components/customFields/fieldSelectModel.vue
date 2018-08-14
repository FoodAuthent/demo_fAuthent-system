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
        :test="schema.test"
        :buttonLabel="schema.buttonLabel">

<!-- MODAL SEARCH -->
 <!--<b-modal :id="schema.modalId" :title="schema.modalId" size="lg">-->
<b-modal :id="schema.idprovider" :title="schema.idprovider" size="lg" @show="loadData" @cancel="handleCancel">
<!-- Table -->
<template>
<div id="searchtable">
   <b-form-group horizontal label="SEARCH" class="mb-1">
          <b-input-group>
            <b-form-input v-model="filter" placeholder="Type to Search" />
            <b-input-group-append>
              <b-btn :disabled="!filter" @click="filter = ''">Clear</b-btn>
            </b-input-group-append>
          </b-input-group>
        </b-form-group>
<!-- TABLE -->

  <b-table bordered striped hover
          show-empty
         :sort-by.sync="sortBy"
         :sort-desc.sync="sortDesc"
         :items="items"
         :fields="fields"
         :current-page="currentPage"
         :per-page="perPage"
         :filter="filter"
         @row-clicked="myRowClickHandler"
>
</b-table>
<b-pagination :total-rows="items.length" :per-page="perPage" v-model="currentPage" />

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
export default {
  mixins: [VueFormGenerator.abstractField],
  data() {
    return {
      items: [],
      fields: null,
      currentPage: 1,
      perPage: 10,
      sortBy: "id",
      sortDesc: false,
      filter: null
    };
  },
  methods: {
    loadData() {
      let self = this;
      if (this.schema.idprovider == "select-product") {
        getProducts(self);
      } else if (this.schema.idprovider == "select-fingerprint") {
        getFingerprints(self);
      }  else if (this.schema.idprovider == "select-workflow") {
        getWorkflows(self);
      } else if (this.schema.idprovider == "select-model") {
        getModels(self);
      }else {
        alert("NO method found");
      }
    },
    myRowClickHandler(record, index) {
      this.value = record[this.schema.fieldName];
    },
    onFiltered(filteredItems) {
      this.totalRows = filteredItems.length;
      this.currentPage = 1;
    },
    handleCancel() {
      this.value = "";
    }
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
