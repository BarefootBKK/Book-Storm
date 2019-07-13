<template>
  <div class="container">
    <HomeNav></HomeNav>
    <!-- 商品显示区域 -->
    <div class="content">
      <div v-for="content in indexContents" class="item-class">
        <div class="item-class-head">
          <span class="item-class-title">{{content.title}}</span>
        </div>
        <div class="content-list">
          <book-item v-for="(item, index) in content.bookInfoList" :product="item" :key="index"></book-item>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import Search from '@/views/Search';
  import HomeNav from '@/views/nav/HomeNav';
  import BookItem from '@/components/BookItem'
  import request from "@/utils/request";

  export default {
    name: 'Index',
    data() {
      return {
        setIntervalObj: null,
        indexContents: {},
        marketing: {}
      };
    },
    computed: {},
    created() {
    },
    mounted() {
      this.getIndexContents()
      this.checkData()
    },
    methods: {
      getIndexContents() {
        request.get('/index/contents').then(response => {
          this.indexContents = response.data.data
        }).catch(error => {
          this.$Message.error({
            content: error,
          })
        })
      },
      checkData() {
        const d1 = this.indexContents
        const d2 = this.indexContents.items
        const d3 = this.marketing
        console.log('')
      }
    },
    components: {
      Search,
      HomeNav,
      BookItem
    },
    destroyed() {
      clearInterval(this.setIntervalObj);
    },
  }
  ;
</script>

<style lang="scss" scoped>
  $color-primary: #409EFF;

  .container {
    background-color: #F6F6F6;
  }

  .content {
    width: 1050px;
    margin: 10px auto;
  }

  .seckill-icon img {
    width: 35px;
    height: 35px;
    margin-top: 6px;
    margin-left: 15px;
    animation-name: shake-clock;
    animation-duration: 0.3s;
    animation-iteration-count: infinite; /*设置无线循环*/
  }

  /*定义闹钟震动动画关键帧*/
  @keyframes shake-clock {
    0% {
      transform: rotate(-8deg);
    }
    50% {
      transform: rotate(8deg);
    }
    100% {
      transform: rotate(-8deg);
    }
  }

  .seckill-item-img img {
    width: 130px;
    height: 130px;
    margin-left: 15px;
    margin-top: 15px;
    transition: margin-top 0.3s;
  }

  .seckill-item-img:hover img {
    margin-top: 6px;
    transition: margin-top 0.3s;
  }

  .seckill-item-info i:first-child {
    font-size: 14px;
  }

  /*****************************秒杀专栏结束*****************************/

  /*****************************商品专栏开始*****************************/
  .item-class {
    width: 100%;
    background-color: #fff;
    margin-top: 8px;
    border: 1px solid $color-primary;
  }

  .item-class-head {
    width: 100%;
    height: 50px;
    background-color: $color-primary;
  }

  .item-class-head ul {
    list-style: none;
    float: right;
    margin-right: 30px;
    line-height: 50px;
  }

  .item-class-head a {
    padding: 6px;
    margin-left: 15px;
    font-size: 12px;
    background-color: #6da6be;
    border: 1px solid #6da6be;
    text-decoration: none;
    color: #fff;
  }

  .item-class-eat-head a {
    background-color: #eeb955;
    border: 1px solid #eeb955;
  }

  .item-class-head a:hover {
    border: 1px solid #fff;
  }

  .item-class-head li {
    float: left;
  }

  .item-class-title {
    font-size: 25px;
    line-height: 50px;
    color: #fff;
    margin-left: 15px;
  }

  .content-list {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
  }

  .item-big-img img {
    margin-left: 0px;
    transition: margin-left 0.3s;
  }

  .item-big-img:hover img {
    margin-left: -15px;
    transition: margin-left 0.3s;
  }

  .item-four-detail img {
    margin-left: 0px;
    transition: margin-left 0.3s;
  }

  .item-four-detail:hover img {
    margin-left: -6px;
    transition: margin-left 0.3s;
  }

  .item-four-detail-img img {
    margin-left: 5px;
    width: 90px;
  }

  .item-content-bottom-img img {
    margin-left: 0px;
    transition: margin-left 0.3s;
  }

  .item-content-bottom-img:hover img {
    margin-left: -15px;
    transition: margin-left 0.3s;
  }

  /*****************************商品专栏结束*****************************/
</style>
