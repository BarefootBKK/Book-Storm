<template>
  <div class="container">
    <Layout class="layout">
      <Sider class="side-bar" :style="{height: 'calc(100vh - 35px)', background: '#fff', overflow: 'auto'}" ref="side"
             :collapsed-width="78">
        <Menu active-name="1-2" theme="light" width="auto" @on-select="onSelect">
          <div class="user-icon">
            <div class="user-img">
              <img v-if="hasAvatar" :src="avatar">
              <img v-else :src="userAvatar">
            </div>
            <p>{{username}}</p>
          </div>
          <Submenu name="0">
            <template slot="title">
              <Icon type="location"></Icon>
              <span>个人中心</span>
            </template>
            <MenuItem name="info">个人资料</MenuItem>
          </Submenu>
          <Submenu name="1">
            <template slot="title">
              <Icon type="location"></Icon>
              <span>收货地址</span>
            </template>
            <MenuItem name="myAddress">我的收货地址</MenuItem>
            <MenuItem name="addAddress">添加收货地址</MenuItem>
          </Submenu>
          <Submenu name="2">
            <template slot="title">
              <Icon type="clipboard"></Icon>
              <span>购物订单</span>
            </template>
            <MenuItem name="myOrder">我的订单</MenuItem>
          </Submenu>
          <Submenu name="3">
            <template slot="title">
              <Icon type="ios-cart"></Icon>
              <span>购物车</span>
            </template>
            <MenuItem name="myShoppingCart">我的购物车</MenuItem>
          </Submenu>
        </Menu>
      </Sider>
      <Layout class="layout">
        <Header :style="{background: '#fff'}">
          <h2>{{activeTitle}}</h2>
        </Header>
        <Content class="content">
          <transition mode="out-in">
            <router-view></router-view>
          </transition>
        </Content>
        <Footer class="layout-footer-center">2018 &copy; Book Storm</Footer>
      </Layout>
    </Layout>
  </div>
</template>

<script>
  export default {
    name: 'Home',
    data() {
      return {
        activeTitle: '我的订单',
        bar: {
          'myAddress': '我的收货地址',
          'addAddress': '添加收货地址',
          'myOrder': '我的订单',
          'myShoppingCart': '我的购物车',
          'info': '个人资料'
        },
        userAvatar: require('../assets/avatar.png'),
        avatar: this.$store.getters.userInfo.avatar,
        username: this.$store.getters.username
      };
    },
    computed: {
      hasAvatar() {
        return this.avatar && this.avatar !== ''
      }
    },
    methods: {
      onSelect(name) {
        this.activeTitle = this.bar[name];
        this.$router.push(`/home/${name}`);
      }
    }
  };
</script>

<style lang="scss" scoped>
  .side-bar a {
    color: #232323;
  }

  .user-icon {
    height: 200px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
  }

  .user-icon span {
    font-size: 96px;
  }

  .user-img {
    margin-bottom: 15px;
    width: 96px;
    height: 96px;
    border-radius: 48px;
    border: 1px solid #d4d6db;
    overflow: hidden;
  }

  div .user-img {
    span {
      img {
        height: 100%;
      }

      span {
        height: 100%;
        width: 100%;
      }
    }
  }

  .user-img img {
    width: 100%;
  }

  .content {
    /*    margin: 15px;*/
    background-color: #ffffff;
    padding: 15px;
  }

  .layout-footer-center {
    padding: 0px 15px;
    padding-bottom: 15px;
    text-align: center;
  }

</style>
