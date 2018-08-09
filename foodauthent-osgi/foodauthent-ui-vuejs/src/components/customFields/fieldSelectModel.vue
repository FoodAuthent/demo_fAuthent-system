<template>
<div class="field-wrap">
        <input
        class="form-control"
        type="text"
        v-model="value"
        :disabled="disabled"
        :maxlength="schema.max"
        :placeholder="schema.placeholder"
        :endpoint="schema.endpoint"
        :readonly="schema.readonly"
        :buttonLabel="schema.buttonLabel">

        <b-btn v-b-modal.testModal>{{ schema.buttonLabel }}</b-btn>

      <!-- MODAL SEARCH -->
 <b-modal :id="schema.modalId" :title="schema.modalId" size="lg">
<template v-if="!items">
  <div>
    <b-form inline>
      <b-input class="mb-2 mr-sm-2 mb-sm-0" id="inlineFormInputName2" placeholder="product" />
       <b-btn variant="primary" @click="search">Search</b-btn>
    </b-form>
  </div>
</template>
<!-- Table -->
<template v-if="items">
<div id="searchtable"">
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

</div>
</template>
  </b-modal>
  </div>
</template>



<script>
import VueFormGenerator from "vue-form-generator";
var getProducts = require('@/utils/functions.js').default.getProducts;
   export default {
      mixins: [ VueFormGenerator.abstractField ],
    data() {
			return {
			model:{"value": ""},
      items: null,
      fields: null,
      currentPage: 1,
      perPage: 10,
      sortBy: 'id',
      sortDesc: false,
      filter: null,
      shownItems:""
			};
    },
  methods: {
    search(){
     let self = this;
     getProducts(self);
             },
    myRowClickHandler(record, index) {
    this.value = record[this.schema.fieldName];
  },
  onFiltered (filteredItems) {
      this.totalRows = filteredItems.length
      this.currentPage = 1
    }
  },
    computed: {
    sortOptions () {
      // Create an options list from our fields
      return this.fields
        .filter(f => f.sortable)
        .map(f => { return { text: f.label, value: f.key } })
    }
  }
   };

</script>


<style>

</style>
