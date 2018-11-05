<template>
  <div id="workflowTable">
 <b-container fluid>
    <!-- UPDATE -->
    <b-row>
        <b-col>
           <b-btn variant="primary" size="sm" @click="loadTableData"><md-icon>autorenew</md-icon></b-btn>
        </b-col>
              <!-- PER PAGE -->
      <b-col class="my-1">
      <b-form-group horizontal label="PER PAGE" class="mb-0">
          <b-form-select :options="pageOptionsPerPage" v-model="perPage" />
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
  <template slot="actions" slot-scope="row">
    <b-btn size="sm" v-b-modal.modalEdit @click.stop="info(row.item, row.index, $event.target)"> <md-icon>edit</md-icon></b-btn>
    <b-btn size="sm" v-b-modal.modalDelete > <md-icon>delete_forever</md-icon></b-btn>
  </template>
</b-table>

<!-- MODAL DETAILS -->
  <b-modal id="modalEdit" title="Edit" @ok="handleEditOk">
    <p class="my-1"> {{ selected }}</p>
  </b-modal>
    <!-- MODAL Delete -->
  <b-modal id="modalDelete" title="Delete"  @ok="handleDeleteOk">
    <p>Are you sure do you want to delete this record?</p>
    <pre v-if="selected" v-html="JSON.stringify(selected, undefined, 4)"></pre>
  </b-modal>
  </div>
</template>


<script>
var getWorkflows = require("@/utils/workflowFunction.js").default.getWorkflows;
var deleteWorkflow = require("@/utils/workflowFunction.js").default
  .deleteWorkflow;
export default {
  name: "Workflow",
  data() {
    return {
      items: [],
      selected: {},
      fields: [],
      currentPage: 1,
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
        return { text: f.label, value: f.key };
      });
    }
  },
  methods: {
    loadTableData() {
      let self = this;
      getWorkflows(self);
    },
    handleDeleteOk() {
      let self = this;
      console.log("fa-id:", this.selected["fa-id"]);
      deleteProducts(this.selected["fa-id"], self);
    },
    handleEditOk() {

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
