<template>
  <div>
    <ShopHeader></ShopHeader>
    <div class="goods-container">
      <div class="goods-list">
        <book-item v-for="(item, index) in bookList" :key="index" :product="item"></book-item>
      </div>
      <div class="goods-page">
        <Page :total="pageSize" show-sizer></Page>
      </div>
    </div>
  </div>
</template>

<script>
  import ShopHeader from '@/views/header/ShopHeader';
  import request from '@/utils/request'
  import BookItem from '@/components/BookItem'

  export default {
    name: 'Merchant',
    data(){
      return {
        bookList:[],
        pageNum:0,
        pageSize:0
      }
    },
    created() {
      this.loadStoreBook()
    },
    computed: {
    },
    methods: {
      loadStoreBook(){
        request.get(`/book/store?storeId=${this.$store.getters.storeInfo.id}`).then(response => {
          this.bookList = response.data.data.list
          this.pageNum = response.data.data.pageNum
          this.pageSize = response.data.data.pageSize
        })
      }
    },
    components: {
      ShopHeader,
      BookItem
    },
  };
</script>

<style scoped>
  .text-danger {
    color: #A94442;
  }

  .seckill-price {
    margin-right: 5px;
    font-size: 25px;
    font-weight: bold;
  }

  .goods-container {
    margin: 15px auto;
    width: 80%;
  }

  .goods-list {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
  }

  .goods-show-info {
    width: 240px;
    padding: 10px;
    margin: 15px 0px;
    border: 1px solid #fff;
    cursor: pointer;
  }

  .goods-show-info:hover {
    border: 1px solid #ccc;
    box-shadow: 0px 0px 15px #ccc;
  }

  .goods-show-price {
    margin-top: 6px;
  }

  .goods-show-detail {
    font-size: 12px;
    margin: 6px 0px;
  }

  .goods-show-num {
    font-size: 12px;
    margin-bottom: 6px;
    color: #009688;
  }

  .goods-show-num span {
    color: #005AA0;
    font-weight: bold;
  }

  .goods-show-seller {
    font-size: 12px;
    color: #E4393C;
  }

  .goods-page {
    margin-top: 20px;
    display: flex;
    justify-content: flex-end;
  }
</style>
