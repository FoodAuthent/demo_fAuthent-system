<template>

<div id="sampleTable">
    <b-container fluid>
        <!-- UPDATE -->
        <b-row>
            <b-col>
                <b-btn id="refreshTable" variant="primary" size="sm" @click="onClick">
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
                            <md-icon>edit</md-icon>
                        </b-btn>
                        <b-btn size="sm" v-b-modal.modalMeta @click.stop="showMetadata(row.item, row.index, $event.target)">
                            <md-icon>search</md-icon>
                        </b-btn>
                        <b-btn size="sm" v-b-modal.modalDelete>
                            <md-icon>delete_forever</md-icon>
                        </b-btn>
                    </div>
                </template>
            </b-table>
        </b-row>
    </b-container>



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

<script>

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
        pageOptionsPerPage: Array,
        search: {
            type: Function,
            required: true
        },
        handleDeleteOk: {
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
        onClick: {
            type: Function,
            required: true
        }
    },
    data() {
        return {
            filterVal: ''
        }
    },
    mounted() {
        this.onProp(this.filter);
        this.$watch('filter', this.onProp);
    },
    methods: {
        onProp(filter) {
                this.filterVal = filter
            },
            onSearch() {
                this.$emit('update:filter', this.filterVal)
            },
            handleEditOk() {
                console.log("HandleEditOK");
            },
            clearSearch() {
                this.$emit('update:filter', null);
                this.$emit('update:filterVal', null)
                document.getElementById("refreshTable").click();
            },
            perPagehandler(newObjectState) {
                let self = this;
                self.currentPage = 0; //just a workaround to go back in page 1
                self.perPage = newObjectState;
                document.getElementById("refreshTable").click();
            },
            myRowClickHandler(record, index) {
                console.log(record); // This will be the item data for the row
                this.selected = record;
            },
            info(item, index, button) {
                this.model = item;
                this.$root.$emit('bv::show::modal', 'modalEdit', button);
            },
            onFiltered(filteredItems) {
                // Trigger pagination to update the number of buttons/pages due to filtering
                this.totalRows = filteredItems.length;
                this.currentPage = 1;
            }
    }
}

</script>