<template>

<div class="container" id="container">
    <b-alert :show="showSuccess" dismissible variant="success" @dismissed="showSuccess=false">
        <p>Operation success</p>
    </b-alert>
    <b-alert :show="showError" dismissible variant="danger" @dismissed="showError=false">
        <p>There is a problem {{response}}</p>
    </b-alert>
    <div class="panel panel-default">
        <div class="panel panel-default">
            <div class="panel-heading">FORM</div>
            <div class="panel-body">
                <vue-form-generator :schema="schema" :model="model" :options="formOptions">
                </vue-form-generator>
            </div>
        </div>
        <div role="tablist">
            <b-card no-body class="mb-1" v-for="(currentschema, key, index) in schemas">
                <b-card-header header-tag="header" class="p-1" role="tab">
                    <b-btn block v-b-toggle="'accordion'+key" variant="info">{{currentschema.title}}</b-btn>
                </b-card-header>
                <b-collapse :id="'accordion'+key" visible=false accordion="my-accordion" role="tabpanel">
                    <b-card-body>
                        <vue-form-generator :schema="currentschema" :model="currentschema.model" :options="formOptions">
                        </vue-form-generator>
                        <pre v-if="model" v-html="JSON.stringify(currentschema.model, undefined, 4)"></pre>
                    </b-card-body>
                </b-collapse>
            </b-card>
        </div>

        <div class="button-div">
            <b-button variant="primary" @click="save">Save</b-button>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading">Model</div>
        <div class="panel-body">
            <pre v-if="model" v-html="JSON.stringify(model, undefined, 4)"></pre>
        </div>
    </div>

    <div id="response">
        <h1>Response</h1>
        <p> {{response}}</p>
    </div>
</div>

</template>

<script>
import VueFormGenerator from "vue-form-generator";
import "vue-form-generator/dist/vfg.css";

export default {
    props: {
        showSuccess: Number,
        showError: Number,
        schema: Object,
        schemas: Array,
        model: Object,
        formOptions: Object,
        save: {
            type: Function,
            required: true
        }
    },
    data() {
        return {}
    },
    methods: {
        handleDeleteOk() {
                console.log("fa-id:", this.selected["fa-id"]);
            },
         handleEditOk() {
                console.log("HandleEditOK");
            },
         clearSearch() {
                this.filter = null;
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
    },
        components: {
        "vue-form-generator": VueFormGenerator.component
    }
}

</script>