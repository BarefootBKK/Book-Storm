<template>
  <div>
    <ShopHeader></ShopHeader>
    <GoodsDetailNav></GoodsDetailNav>
    <div class="shop-item-path">
      <div class="shop-nav-container">
        <Breadcrumb>
          <BreadcrumbItem to="/">首页</BreadcrumbItem>
          <BreadcrumbItem to="/goodsList">手机壳</BreadcrumbItem>
          <BreadcrumbItem>手机保护套</BreadcrumbItem>
        </Breadcrumb>
      </div>
    </div>
    <!-- 商品信息展示 -->
    <ShowGoods></ShowGoods>
    <!-- 商品详细展示 -->
    <ShowGoodsDetail></ShowGoodsDetail>
    <Spin size="large" fix v-if="isLoading"></Spin>
  </div>
</template>

<script>
  import Search from '@/views/Search';
  import GoodsDetailNav from '@/views/nav/GoodsDetailNav';
  import ShopHeader from '@/views/header/ShopHeader';
  import ShowGoods from '@/views/goodsDetail/ShowGoods';
  import ShowGoodsDetail from '@/views/goodsDetail/ShowGoodsDetail';

  export default {
    name: 'GoodsDetail',
    beforeRouteEnter(to, from, next) {
      window.scrollTo(0, 0);
      next();
    },
    data() {
      return {
        tagsColor: ['blue', 'green', 'red', 'yellow'],
        bookId: 0,
      };
    },
    computed: {
      isLoading(){
        return this.$store.getters.isLoading
      }
    },
    created() {
      this.initBookDetail()
    },
    methods: {
      initBookDetail() {
        const bookId = this.$route.query.id
        this.$store.dispatch('setBookId', bookId).then(() => {
        }).catch(error => {
        })
      }
    },
    components: {
      Search,
      ShopHeader,
      GoodsDetailNav,
      ShowGoods,
      ShowGoodsDetail
    },
  };
</script>

<style scoped>
  .shop-item-path {
    height: 38px;
    background-color: rgb(236, 235, 235);
    line-height: 38px;
    color: #2c2c2c;
  }

  .shop-nav-container {
    margin: 0px auto;
    width: 80%;
  }
</style>
