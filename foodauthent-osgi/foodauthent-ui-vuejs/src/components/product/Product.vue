<template>
  <div class="page-container">
    <p>{{tabIndex}}</p>
      <md-app>
      <md-app-toolbar class="md-primary">
        <span class="md-title">Product</span>
      </md-app-toolbar>
    <md-app-drawer md-permanent="full">
     <!-- <md-toolbar class="md-transparent" md-elevation="0">
          Navigation
        </md-toolbar> -->
        <md-list v-for="route in this.$router.options.routes">
          <md-list-item>
            <md-icon>label</md-icon>
         <!-- <span class="md-list-item-text">Test</span> -->
            <router-link :to="route.path" class="md-list-item-text">{{route.name}}</router-link>
          </md-list-item>
        </md-list>
      </md-app-drawer>


      <md-app-content>
 <b-card no-body>
  <b-tabs card v-model="tabIndex">
    <b-tab title="Results" active>
  <productTable></productTable>
    </b-tab>
    <b-tab title="Form">
     <productForm></productForm>
    </b-tab>
  <b-tab title="Empty">

    </b-tab>
  </b-tabs>
</b-card>
      </md-app-content>
    </md-app>

  </div>
</template>

<script>
import productTable from "@/components/product/ProductTable";
import productForm from "@/components/product/ProductForm";
export default {
  name: "Product",
  data: () => ({
    tabIndex: 0
  }),
  mounted() {},
  methods: {},
  components: {
    productTable,
    productForm
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
