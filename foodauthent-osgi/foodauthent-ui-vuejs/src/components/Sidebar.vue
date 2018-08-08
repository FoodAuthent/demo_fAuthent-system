<template>
      <md-app-drawer md-permanent="full">
        <md-toolbar class="md-transparent" md-elevation="0">
          Navigation
        </md-toolbar>
        <md-list v-for="route in this.$router.options.routes">
          <md-list-item>
            <md-icon>label</md-icon>
           <!-- <span class="md-list-item-text">SOP</span> -->
            <router-link :to="route.path" class="md-list-item-text">{{route.name}}</router-link>
          </md-list-item>
        </md-list>
      </md-app-drawer>
</template>


<style lang="scss" scoped>
  .md-drawer {
  max-width: 250px;
  }


</style>

<script>
export default {
  name: 'Normal'
}
</script>
