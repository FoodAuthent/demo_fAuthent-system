<template>
  <div id="productTable">
    <b-container fluid>
    <!-- User Interface controls -->
    <b-row>
      <b-col md="6" class="my-1">
    <!-- SEARCH -->
   <b-form-group horizontal label="SEARCH" class="mb-50">
          <b-input-group>
            <b-form-input v-model="filter" placeholder="Type to Search" />
            <b-input-group-append>
              <b-btn :disabled="!filter" @click="filter = ''">Clear</b-btn>
            </b-input-group-append>
          </b-input-group>
        </b-form-group>
      </b-col>
      <b-col md="6" class="my-1">
      <b-form-group horizontal label="PER PAGE" class="mb-0">
          <b-form-select :options="pageOptions" v-model="perPage" />
        </b-form-group>
      </b-col>
      </b-row>
  </b-container>

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

<!-- PAGINATION -->
<b-pagination :total-rows="items.length" :per-page="perPage" v-model="currentPage" />

<!-- MODAL DETAILS -->
  <b-modal id="modal1" title="Details">
    <p class="my-1"> {{ selected }}</p>
  </b-modal>

  </div>
</template>


<script>
import axios from 'axios'
 import {EndpointUrl} from '../../config.js'
 export default {
  name: 'Product',
  data () {
    return {
      items: [],
      selected: {},
      fields: [ ],
      //fields: [
       // { key: 'id', sortable: true },
       // { key: 'title', sortable: true },
       // { key: 'body', sortable: true },
       // { key: 'actions', sortable: false }
      //],
      endpointurl : EndpointUrl.PRODUCTURL,
      currentPage: 1,
      perPage: 10,
      sortBy: 'id',
      sortDesc: false,
      filter: null,
      pageOptions: [ 1, 10, 15 ]
    }
  },
    mounted() {
    let self = this;
    fetch(self.endpointurl+'?pageNumber=0&pageSize='+self.perPage)
    .then((j) => {return j.json();
    })
      .then ((r) => {
      if(!r.results){
      self.items.push(r);
      }else{
      self.items = r.results;
      }
      })
        },
  computed: {
    sortOptions () {
      // Create an options list from our fields
      return this.fields
        .filter(f => f.sortable)
        .map(f => { return { text: f.label, value: f.key } })
    }
  },
  methods: {
  myRowClickHandler(record, index) {
    // 'record' will be the row data from items
    // `index` will be the visible row number (available in the v-model 'shownItems')
    //console.log(record); // This will be the item data for the row
    this.selected = record
  },
    onFiltered (filteredItems) {
      // Trigger pagination to update the number of buttons/pages due to filtering
      this.totalRows = filteredItems.length
      this.currentPage = 1
    }
}
}
</script>

<style lang="scss" scoped>
  .md-table + .md-table {
    margin-top: 16px
  }
    .md-app {
    /*max-height: px; */
    border: 1px solid rgba(#000, .12);
  }

  .md-drawer {
  max-width: 250px;
  }
</style>

