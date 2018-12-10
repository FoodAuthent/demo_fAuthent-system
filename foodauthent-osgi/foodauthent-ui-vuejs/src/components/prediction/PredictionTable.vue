<template>
  <div id="predictionTable">
 <b-container fluid>
    <!-- UPDATE -->
    <b-row>
        <b-col>
           <b-btn id="refreshTable" variant="primary" size="sm" @click="loadTableData"><md-icon>autorenew</md-icon></b-btn>
        </b-col>
              <!-- PER PAGE -->
      <b-col class="my-1">
      <b-form-group horizontal label="PER PAGE" class="mb-0">
          <b-form-select @change="perPagehandler($event)" :options="pageOptionsPerPage" v-model="perPage" />
        </b-form-group>
      </b-col>
        <!-- SEARCH -->
      <b-col class="my-1">
   <b-form-group horizontal label="SEARCH" class="mb-50">
          <b-input-group>
            <b-form-input v-model="filter" placeholder="Type to Search" />
            <b-input-group-append>
              <b-btn :disabled="!filter" @click="filter = ''">Clear</b-btn>
            </b-input-group-append>
          </b-input-group>
        </b-form-group>
      </b-col>
      </b-row>
  </b-container>

<!-- TABLE -->
  <b-table bordered striped hover show-empty
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

<!-- PAGINATION -->
<b-pagination v-on:input="myPaginationHandler(currentPage)" :total-rows="resultsCount" :per-page="perPage" v-model="currentPage" />

<!-- MODAL DETAILS -->
  <b-modal id="modal1" title="Details">
    <p class="my-1"> {{ selected }}</p>
  </b-modal>

  </div>
</template>


<script>
var getPredictions = require("@/utils/workflowFunction.js").default.getPredictions;
import jsonschema from "@/generated/schema/prediction.json";
export default {
  name: "Workflow",
  data() {
    return {
      model: {},
      schema: jsonschema,
      formOptions: {
        validateAfterLoad: true,
        validateAfterChanged: true
      },
      items: [],
      selected: {},
      fields: [],
      //fields: [
      // { key: 'id', sortable: true },
      // { key: 'title', sortable: true },
      // { key: 'body', sortable: true },
      // { key: 'actions', sortable: false }
      //],
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
  },
  computed: {
    sortOptions() {
      // Create an options list from our fields
      return this.fields.filter(f => f.sortable).map(f => {
        return { text: f.label, value: f.key };
      });
    }
  },
  methods: {
     loadTableData() {
      let self = this;
      getPredictions(self);
    },
    clearSearch(){
    this.filter = "";
    document.getElementById("refreshTable").click();
    },
    //Manage when the number of items displayed on the table change
    perPagehandler(newObjectState){
    let self = this;
    self.currentPage = 0; //just a workaround to go back in page 1
    self.perPage = newObjectState;
    document.getElementById("refreshTable").click();
   // self.loadTableData();
    },
    //Manage the pagination, when a page number is pressed this call the API to get the results for the new page
    myPaginationHandler(page){
    let self = this;
    self.currentPage = page;
    getPredictions(self);
    self.currentPage = 1;
    },
    myRowClickHandler(record, index) {
      // 'record' will be the row data from items
      // `index` will be the visible row number (available in the v-model 'shownItems')
      //console.log(record); // This will be the item data for the row
      this.selected = record;
    },
   info (item, index, button) {
      this.model = item;
      this.$root.$emit('bv::show::modal', 'modalEdit', button);
    },
    onFiltered(filteredItems) {
      // Trigger pagination to update the number of buttons/pages due to filtering
      this.totalRows = filteredItems.length;
      this.currentPage = 1;
    }
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
