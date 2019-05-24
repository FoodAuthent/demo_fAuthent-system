<template>

<div id="sampleTable">
    <b-container fluid>
        <!-- UPDATE -->
        <b-row>
            <b-col>
                <b-btn id="refreshTable" variant="primary" size="sm" @click="refresh">
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
									 

				<!-- THE IDs ARE LINKS -->
	 			<template v-for="(field, index) in fields" :slot="field.model" slot-scope="data">
			      <div v-if="checkLinkField(field.model)">
					      <div v-if="checkArray(data.value)">
							      <ul id="listOfIds">
									  <li v-for="(id, index) in data.value">
									   <b-button variant="link"v-b-modal.linkModal @click="linkFunction(id, field.model)" >{{ id }}</b-button>
									  </li>
								</ul>
					      </div>
					       <div v-else>
					        	<b-button variant="link"v-b-modal.linkModal @click="linkFunction(data.value, field.model)" >{{ data.value }}</b-button>
					      </div>
			      </div>
			       <div v-else>
			       		{{data.value}}
			       </div>
			    </template>
			    
					    
				<!-- ACTIONS edit-delete-info -->
                <template slot="actions" slot-scope="row" v-slot:actions>
                    <div class="widewidth">
                        <b-btn size="sm" v-b-modal.modalEdit @click.stop="info(row.item, row.index, $event.target)">
                            <md-icon>edit</md-icon>
                        </b-btn>
                        <b-btn size="sm" v-b-modal.modalMeta @click.stop="showMetadata(row.item, row.index, $event.target)">
                            <md-icon>search</md-icon>
                        </b-btn>
                        <b-btn size="sm" v-b-modal.modalDelete @click.stop="showDelete(row.item, row.index, $event.target)">
                            <md-icon>delete_forever</md-icon>
                        </b-btn>
                    </div>
                </template> 

                
            </b-table>
        </b-row>
    </b-container>
    
    <!-- PAGINATION -->
    <b-pagination v-on:input="myPaginationHandler(currentPage)" :total-rows="resultsCount" :per-page.sync="perPage" v-model="currentPage" />

    <!-- MODAL EDIT -->
    <b-modal id="modalEdit" title="edit" @ok="handleEditOk">
        <vue-form-generator :schema="schema" :model="model" :options="formOptions"> </vue-form-generator>
    </b-modal>
    
        <!-- MODAL METADATA -->
    <b-modal id="modalMeta" size="lg" title="Metadata" @ok="handleMetadataOk">
        <div class="panel panel-default">
            <div class="panel-heading">Metadata</div>
            <div class="panel-body">
                <pre v-html="JSON.stringify(itemsMetadata, undefined, 4)"></pre>
            </div>
        </div>
    </b-modal>

    <!-- MODAL Delete -->
    <b-modal id="modalDelete" title="Delete" @ok="handleDeleteOk">
        <p>Are you sure do you want to delete this record?</p>
        <pre v-if="selected" v-html="JSON.stringify(itemsDelete, undefined, 4)"></pre>
    </b-modal>
    
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
var schemaIdHolder = {
    "schemaID": "withOutSchema"
};

var getModelSchemas = require("@/utils/commonFunction.js").default.getModelSchemas;
var getCustomMetadata = require("@/utils/commonFunction.js").default.getCustomMetadata;
var getLinkInfo = require("@/utils/commonFunction.js").default.getLinkInfo;
var deleteEntity = require("@/utils/commonFunction.js").default.deleteEntity;
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
        itemsMetadata: Object,
        schema: Object,
        model: Object,
        pageType: String,
        schemaIdHolder: Object,
        pageOptionsPerPage: Array,
        search: {
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
        handleEditOk: {
            type: Function,
            required: true
            },
        refresh: {
            type: Function,
            required: true
        }
    },
    data() {
        return {
            filterVal: '',
            itemsDelete: null,
            itemLink: null
               }
    },
    mounted() {
        this.onProp(this.filter);
        this.$watch('filter', this.onProp);
        if(this.pageType != 'noType'){
        getModelSchemas(this.pageType, {}, this.schemaIdHolder);
        }
    },
    methods: {
        onProp(filter) {
                this.filterVal = filter;
            },
            onSearch() {
                this.$emit('update:filter', this.filterVal)
            },
            clearSearch() {
                this.$emit('update:filter', null);
                this.$emit('update:filterVal', null)
                document.getElementById("refreshTable").click();
            },
            perPagehandler(newObjectState) {
                let self = this;
                self.currentPage = 1; //just a workaround to go back in page 1
                self.perPage = newObjectState;
                self.$emit('update:perPage', newObjectState);
                document.getElementById("refreshTable").click();
            },
            info(item, index, button) {
                this.model = item;
                this.$root.$emit('bv::show::modal', 'modalEdit', button);
            },
            linkFunction(faId,infoType){
            let self = this;
            console.log("faId: ", faId);
            console.log("infoType: ", infoType);
			getLinkInfo(faId,infoType,self );
			document.body.classList.remove("modal-open");
            },
            checkLinkField(model){
            if(model !== undefined && model !== null && model != 'fa-id' && model != 'sample-id'){
             return model.includes("-id") || model.includes("-ids");
             }else{
             return false
             }
            },
            checkArray(field){
           	return  Array.isArray(field);
            },
             showDelete(item, index, button) {
                let self = this;
               console.log("ITEM", item);
               self.itemsDelete = item
                console.log("General selected", self.itemsDelete);
                this.$root.$emit('bv::show::modal', 'modalDelete', button);
            },
               handleDeleteOk() {
                let self = this;
                console.log("fa-id:", self.itemsDelete["fa-id"]);
                deleteEntity(self.itemsDelete["fa-id"], self);
            },
           showMetadata(item, index, button) {
               let self = this;
               console.log("ITEM", item);
               if(this.pageType != 'noType'){
               getCustomMetadata(this.pageType, this.schemaIdHolder.schemaID, item["fa-id"], self);
               }
            },
           //Manage the ok button to confirm the Metadata action
            handleMetadataOk() {
             let self = this;
             self.itemsMetadata = {};
            },
            onFiltered(filteredItems) {
                // Trigger pagination to update the number of buttons/pages due to filtering
                this.totalRows = filteredItems.length;
                this.currentPage = 1;
            }
    }
      
}

</script>
<style>
ul {
  list-style-type: none;
}
</style>