<template>
  <div id="app">
    <Header></Header>
    <router-view class="main"/>
    <Footer v-if="excludeRoutes.indexOf($route.name) == -1"></Footer>
  </div>
</template>

<script>
  import Header from '@/views/header/Header';
  import Footer from '@/views/footer/Footer';

  export default {
    name: 'App',
    data() {
      return {
        excludeRoutes: ['HomeIndex', 'MyAddress', 'AddAddress', 'MyOrder', 'MyShoppingCart']
      };
    },
    components: {
      Header,
      Footer
    }
  }
</script>

<style lang="scss">
  @import "style/index";
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    color: #2c3e50;
    height: 100%;
    width: 100%;
    //min-width: 1020px;
  }

  html, body {
    height: 100%;
    width: 100%;
  }

  .main{
    position: relative;
    top: 60px;
  }
</style>
