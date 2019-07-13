<template>
  <div id="header">
    <div class="logo-container">
      <img id="logo" src="../assets/logo.png"/>
    </div>
    <div id="searchPane">
      <el-form :inline="true" :model="searchForm">
        <el-input type="text" v-model="searchForm.query"></el-input>
      </el-form>
    </div>
    <div>
      <el-dropdown>
        <el-avatar :src="userAvatar" size=""></el-avatar>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item>个人中心</el-dropdown-item>
          <el-dropdown-item>购物车</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
  </div>
</template>

<script>
  export default {
    name: "Header",
    data() {
      return {
        searchForm: {
          query: ''
        },
        userAvatar: '../assets/avatar.png'
      }
    }
  }
</script>

<style lang="scss" scoped>
  #header {
    z-index: 999;
    position: relative;
    top: 0;
    left: 0;
    width: 100%;
    height: 40px;
    padding: 8px;
    overflow: visible;

    div {
      display: inline;
    }
  }

  #searchPane {
    width: 80px;
    horiz-align: center;
  }

  .logo-container {
    height: 30px;
    width: 30px;
    float: left;
    overflow: hidden;
  }


</style>
