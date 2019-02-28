<template>
  <div id="table">
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
  <b-table bordered striped hover show-empty
         :sort-by.sync="sortBy"
         :sort-desc.sync="sortDesc"
         :items="items"
         :fields="fields"
         :current-page="currentPage"
         :per-page="perPage"
         @row-clicked="myRowClickHandler"
>

  <template slot="actions" slot-scope="row">
    <b-btn size="sm" v-b-modal.modalEdit @click.stop="info(row.item, row.index, $event.target)"> <md-icon>edit</md-icon></b-btn>
    <b-btn class="btn btn-primary" v-b-modal.modalDelete > <md-icon>delete_forever</md-icon></b-btn>
  </template>
</b-table>

<!-- PAGINATION -->
<b-pagination v-on:input="myPaginationHandler(currentPage)" :total-rows="resultsCount" :per-page="perPage" v-model="currentPage" />

<!-- MODAL EDIT -->
  <b-modal id="modalEdit" title="edit" @ok="handleEditOk">
        <vue-form-generator :schema="schema" :model="model" :options="formOptions"> </vue-form-generator>
  </b-modal>

  <!-- MODAL Delete -->
  <b-modal id="modalDelete" title="Delete" @ok="handleDeleteOk">
    <p>Are you sure do you want to delete this record?</p>
    <pre v-if="selected" v-html="JSON.stringify(selected, undefined, 4)"></pre>
  </b-modal>

  </div>
</template>
export default {
  props: {
    model: {},
    schema: {},
    items: []
  }
}

<script>
</script>