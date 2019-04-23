<template>

<div class="page-container">
    <md-app>
        <md-app-toolbar class="md-primary">
            <span class="md-title">HOME</span>
        </md-app-toolbar>

        <md-app-drawer md-permanent="full">
            <!--<md-toolbar class="md-transparent" md-elevation="0">
          Navigation
        </md-toolbar>-->
            <md-list v-for="route in this.$router.options.routes">
                <md-list-item v-if="!route.meta.notdisplay">
                    <md-icon>label</md-icon>
                    <!-- <span class="md-list-item-text">SOP</span> -->
                    <router-link :to="route.path" class="md-list-item-text">{{route.name}}</router-link>
                </md-list-item>
            </md-list>
        </md-app-drawer>
        <md-app-content>

        </md-app-content>
    </md-app>

</div>

</template>

<script>
</script>
<style lang="scss" scoped>

.md-app {
    /*max-height: px; */
    border: 1px solid rgba(#000, .12);
}

.md-drawer {
    max-width: 250px;
}

</style>
