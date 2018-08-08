<template>
  <div id="productTable">
  <!-- SEARCH -->
   <b-form-group horizontal label="SEARCH" class="mb-50">
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
         :items="test"
         :fields="fields"
         :current-page="currentPage"
         :per-page="perPage"
         :filter="filter"
         @row-clicked="myRowClickHandler"
>
  <template slot="actions" scope="test">
   <!-- <b-btn size="sm" @click="log(environment.item)">Details</b-btn> -->
    <b-btn size="sm" v-b-modal.modal1>Details</b-btn>
  </template>
</b-table>

<!-- PAGINATION -->
<b-pagination :total-rows="test.length" :per-page="perPage" v-model="currentPage" />

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
      test: [],
      selected: {},
      //fields: [ 'id', 'title', 'body', 'actions' ],
      fields: [
        { key: 'fa-id', sortable: true },
        { key: 'gtin', sortable: true },
        { key: 'brand', sortable: true },
        { key: 'actions', sortable: false }
      ],
      endpointurl : EndpointUrl.PRODUCTURL,
      currentPage: 1,
      perPage: 10,
      sortBy: 'id',
      sortDesc: false,
      filter: null
    }
  },
    mounted() {
    var self = this
    const url = self.endpointurl;
    axios.get(url, {
      dataType: 'json',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      mode: 'no-cors',
      credentials: 'include'
    })
    .then(function (response) {
      console.log(JSON.stringify(response.data))
      self.test = response.data
    })
    .catch(function (error) {
      console.log(error)
    })},
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

