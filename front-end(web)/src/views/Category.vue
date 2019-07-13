<template>
  <div>
    <Search></Search>
    <GoodsListNav></GoodsListNav>
    <div class="container">
      <div class="bread-crumb">
        <Breadcrumb>
          <BreadcrumbItem to="/">
            <Icon type="ios-home-outline"></Icon>
            首页
          </BreadcrumbItem>
          <BreadcrumbItem :to="'/category?name=' + searchItem">
            <Icon type="bag"></Icon>
            {{searchItem}}
          </BreadcrumbItem>
        </Breadcrumb>
      </div>
      <!-- 商品标签导航 -->
      <GoodsClassNav :query="searchItem"></GoodsClassNav>
      <!-- 商品展示容器 -->
      <div class="goods-box">
        <div class="as-box">
          <div class="item-as-title">
            <span>商品精选</span>
            <span>广告</span>
          </div>
          <div class="item-as" v-for="(item,index) in asItems" :key="index">
            <div class="item-as-img">
              <img :src="item.img" alt="">
            </div>
            <div class="item-as-price">
              <span>
                <Icon type="social-yen text-danger"></Icon>
                <span class="seckill-price text-danger">{{item.price}}</span>
              </span>
            </div>
            <div class="item-as-intro">
              <span>{{item.intro}}</span>
            </div>
            <div class="item-as-selled">
              已有<span>{{item.num}}</span>人评价
            </div>
          </div>
        </div>
        <div class="goods-list-box">
          <div class="goods-list-tool">
            <ul>
              <li v-for="(item,index) in goodsTool" :key="index" @click="orderBy(item.en, index)"><span
                :class="{ 'goods-list-tool-active': isAction[index]}">{{item.title}} <Icon
                :type="icon[index]"></Icon></span></li>
            </ul>
          </div>
          <div class="goods-list">
            <book-item v-for="(item, index) in orderGoodsList" :product="item" :key="index"></book-item>
          </div>
          <div class="goods-page">
            <Page :total="totalNum" show-sizer></Page>
          </div>
        </div>
      </div>
    </div>
    <Spin size="large" fix v-if="isLoading"></Spin>
  </div>
</template>

<script>
  import Search from '@/views/Search';
  import GoodsListNav from '@/views/nav/GoodsListNav';
  import GoodsClassNav from '@/views/nav/GoodsClassNav';
  import BookItem from '@/components/BookItem'
  import {orderListBy, reverseOrderListBy} from "@/utils/sort";
  import request from '@/utils/request'

  export default {
    name: 'GoodsList',
    beforeRouteEnter(to, from, next) {
      window.scrollTo(0, 0);
      next();
    },
    data() {
      return {
        searchItem: '',
        isAction: [true, false, false],
        icon: ['arrow-up-a', 'arrow-down-a', 'arrow-down-a'],
        goodsTool: [
          {title: '综合', en: 'dealMount'},
          {title: '浏览数', en: 'lookMount'},
          {title: '价格', en: 'price'}
        ],
        isLoading: true,
        sortOrderBy: 'sale',
        pageSize: 0,
        pageNum: 0,
        totalNum: 0,
        inverseOrder: false,
        currentSortIndex: 0,
      };
    },
    computed: {
      asItems() {
        return this.$store.getters.adsItems
      },
      orderGoodsList() {
        const list = this.$store.getters.goodsList.list
        if (!list) {
          return []
        }
        if (!this.inverseOrder) {
          return orderListBy(list, this.sortOrderBy)
        } else {
          return reverseOrderListBy(list, this.sortOrderBy)
        }
      }
    },
    created() {
      this.initGoodsList()
    },
    mounted() {
    },
    methods: {
      initGoodsList() {
        this.isLoading = true
        this.searchItem = this.$route.query.name;

        request.get(`/index/items?name="${this.searchItem}"`).then(response => {
          const data = response.data.data
          this.$store.dispatch('setBookList', data)
          this.pageSize = data.pageSize
          this.pageNum = data.pageNum
          this.totalNum = data.total
          this.isLoading = false
        }).catch(error => {
          this.isLoading = false
        })
      },
      orderBy(data, index) {
        this.isLoading = true
        this.icon = ['arrow-down-a', 'arrow-down-a', 'arrow-down-a'];
        this.isAction = [false, false, false];
        this.isAction[index] = true;
        this.icon[index] = 'arrow-up-a';
        this.sortOrderBy = data

        if (this.currentSortIndex === index) {
          this.inverseOrder = !this.inverseOrder
        } else {
          this.inverseOrder = false
        }
        this.currentSortIndex = index
        this.isLoading = false
      }
    },
    components: {
      Search,
      GoodsListNav,
      GoodsClassNav,
      BookItem
    },
    //store
  };
</script>

<style scoped>
  .container {
    margin: 15px auto;
    width: 93%;
    min-width: 1000px;
  }

  .goods-box {
    display: flex;
  }

  /* ---------------侧边广告栏开始------------------- */
  .as-box {
    width: 200px;
    border: 1px solid #ccc;
  }

  .item-as-title {
    width: 100%;
    height: 36px;
    color: #B1191A;
    line-height: 36px;
    font-size: 18px;
  }

  .item-as-title span:first-child {
    margin-left: 20px;
  }

  .item-as-title span:last-child {
    float: right;
    margin-right: 15px;
    font-size: 10px;
    color: #ccc;
  }

  .item-as {
    width: 160px;
    margin: 18px auto;
  }

  .item-as-img {
    width: 160px;
    height: 160px;
    margin: 0px auto;
  }

  .item-as-price span {
    font-size: 18px;
  }

  .item-as-intro {
    margin-top: 5px;
    font-size: 12px;
  }

  .item-as-selled {
    margin-top: 5px;
    font-size: 12px;
  }

  .item-as-selled span {
    color: #005AA0;
  }

  /* ---------------侧边广告栏结束------------------- */

  /* ---------------商品栏开始------------------- */
  .goods-list-box {
    margin-left: 15px;
    width: calc(100% - 215px);
  }

  .goods-list-tool {
    width: 100%;
    height: 38px;
    border: 1px solid #ccc;
    background-color: #F1F1F1;
  }

  .goods-list-tool ul {
    padding-left: 15px;
    list-style: none;
  }

  .goods-list-tool li {
    cursor: pointer;
    float: left;
  }

  .goods-list-tool span {
    padding: 5px 8px;
    border: 1px solid #ccc;
    border-left: none;
    line-height: 36px;
    background-color: #fff;
  }

  .goods-list-tool span:hover {
    border: 1px solid #E4393C;
  }

  .goods-list-tool i:hover {
    color: #E4393C;
  }

  .goods-list-tool-active {
    color: #fff;
    border-left: 1px solid #ccc;
    background-color: #E4393C !important;
  }

  .goods-list {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
  }

  .goods-page {
    margin-top: 20px;
    display: flex;
    justify-content: flex-end;
  }

  /* ---------------商品栏结束------------------- */
</style>
