<template>
<h1>I am logout</h1>
</template>

<script>
    export default {
        name: 'logout',
        mounted () {
            localStorage.removeItem('token')
            this.$store.commit('LOGOUT_USER')
            this.$router.push('login')
        }
    }
</script>

