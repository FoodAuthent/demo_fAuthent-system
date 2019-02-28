<template>

<div class="page-container">
    <md-app>
        <md-app-toolbar class="md-primary">
            <span class="md-title">ObjectEvent</span>
        </md-app-toolbar>
        <md-app-drawer md-permanent="full">
            <!--  <md-toolbar class="md-transparent" md-elevation="0">
          Navigation
        </md-toolbar> -->
            <md-list v-for="route in this.$router.options.routes">
                <md-list-item>
                    <md-icon>label</md-icon>
                    <router-link :to="route.path" class="md-list-item-text">{{route.name}}</router-link>
                </md-list-item>
            </md-list>
        </md-app-drawer>

        <md-app-content>
            <b-card no-body>
                <b-tabs card>
                    <b-tab title="Results" active>
                        <generalTable></generalTable>
                    </b-tab>
                    <b-tab title="Form">
                        <generalForm></generalForm>
                    </b-tab>
                </b-tabs>
            </b-card>
        </md-app-content>
    </md-app>

</div>

</template>

<script>

import generalTable from '@/components/general/GeneralTable';
import generalForm from '@/components/general/GeneralForm';

var getDataForTable = require("@/utils/objectEventFunction.js").default.getObjectEvent;
var findById = require("@/utils/objectEventFunction.js").default.findObjectEventById;
import jsonschema from "@/generated/schema/objectevent.json";

import VueFormGenerator from "vue-form-generator";
import "vue-form-generator/dist/vfg.css";

var saveObjectEvent = require("@/utils/objectEventFunction.js").default.saveObjectEvent;
var getModelSchemas = require("@/utils/commonFunction.js").default.getModelSchemas;

var schemas = []
var vueObject = {
    schema: jsonschema,
    schemas: schemas,
    model: {},
    response: "",
    showSuccess: false,
    showError: false,
    formOptions: {
        validateAfterLoad: true,
        validateAfterChanged: true
    },
    items: [],
    selected: {},
    sortBy: "name",
    fields: [],
    currentPage: 1,
    resultsCount: 1,
    pageCount: 0,
    perPage: 10,
    shownItems: null,
    sortDesc: false,
    filter: null,
    pageOptionsPerPage: [5, 10, 25, 50, 100]
}
export default {
    data() {
            return vueObject;
        },
        mounted() {
            this.loadTableData();
        },
        methods: {
            loadTableData() {
                    console.log("Load table data");
                    let self = this;
                    getDataForTable(self);
                },
                handleDeleteOk() {
                    //  let self = this;
                    // console.log("fa-id:", this.selected["fa-id"]);
                    // deleteModel(this.selected["fa-id"], self);
                },
                handleEditOk() {
                    //     let self = this;
                    //    console.log("This is the model", this.model);
                    //   updateModel(this.model, self);
                },
                search() {
                    console.log("search object event");
                    let self = this;
                    //check if it is a valid UUID
                    var re = new RegExp("^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$");
                    if (re.test(self.filter)) {
                        findById(self);
                    } else {
                        getDataForTable(self);
                    }
                },
                clearSearch() {
                    this.filter = null;
                    document.getElementById("refreshTable").click();
                },
                //Manage when the number of items displayed on the table change
                perPagehandler(newObjectState) {
                    let self = this;
                    self.currentPage = 0; //just a workaround to go back in page 1
                    self.perPage = newObjectState;
                    document.getElementById("refreshTable").click();
                    // self.loadTableData();
                },
                //Manage the pagination, when a page number is pressed this call the API to get the results for the new page
                myPaginationHandler(page) {
                    let self = this;
                    self.currentPage = page;
                    getModels(self);
                    self.currentPage = 1;
                },
                myRowClickHandler(record, index) {
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
                },
                save() {
                    let self = this;
                    saveObjectEvent(JSON.stringify(this.model, undefined, 4), self);
                    self.model = {}
                },
                editRecord(modelEdit) {
                    let self = this;
                    console.log("modelEdit", modelEdit);
                    self.model = modelEdit;
                    console.log("ONCLICK");
                    // document.getElementById("buttonMax").click();
                    console.log("modelEdit", modelEdit);
                    console.log("modelTest", self.model);

                }
        },
        computed: {
            sortOptions() {
                // Create an options list from our fields
                return this.fields.filter(f => f.sortable).map(f => {
                    return {
                        text: f.label,
                        value: f.key
                    };
                });
            }
        },
        components: {
            generalTable,
            generalForm,
            "vue-form-generator": VueFormGenerator.component
        }
};
</script>