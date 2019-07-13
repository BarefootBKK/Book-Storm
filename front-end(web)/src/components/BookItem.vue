<template>
  <div class="goods-show-info">
    <div class="goods-show-img">
      <router-link :to="'/book?id=' + product.id"><img :src="product.imageUrl"/></router-link>
    </div>
    <div class="goods-show-price">
      <router-link :to="'/book?id=' + product.id">
                  <span>
                    <Icon type="social-yen text-danger"></Icon>
                    <span class="seckill-price text-danger">{{product.price}}</span>
                  </span>
      </router-link>
    </div>
    <div class="goods-show-detail">
      <router-link :to="'/book?id=' + product.id">
        <span>{{product.name}}</span>
      </router-link>
    </div>
    <div class="goods-show-num">
      <router-link :to="'/book?id=' + product.id">
        销量 <span>{{product.dealMount}}</span>
      </router-link>
    </div>
    <div class="goods-show-seller">
      <router-link :to="'/book?id=' + product.id">
        <span>{{product.press}}</span>
      </router-link>
    </div>
  </div>
</template>

<script>
  export default {
    name: "BookItem",
    props: {
      product: Object
    },
    data() {
      return {
        //product: this.product
      }
    },
    computed: {
      remarks() {
        if (this.product.commentList) {
          return this.product.commentList.length
        }
        return 0
      }
    }
  }
</script>

<style lang="scss" scoped>
  @import "../style/index";

  .text-danger {
    color: #A94442;
  }

  .seckill-price {
    margin-right: 5px;
    font-size: 25px;
    font-weight: bold;
  }

  .goods-show-info {
    width: 206px;
    padding: 10px;
    margin-top: 8px;
    margin-left: 2px;
    border: 1px solid #fff;
  }

  .goods-show-info:hover {
    border: 1px solid $color-primary;
    box-shadow: 0px 0px 15px #ccc;
  }

  .goods-show-img {
    height: 186px;
    width: 186px;
    overflow: hidden;
    display: flex;
    align-items: center;
    justify-content: center;

    img {
      width: 100%;
    }
  }

  .goods-show-price {
    margin-top: 6px;
  }

  .goods-show-detail {
    height: 4.5rem;
    font-size: 12px;
    margin: 6px 0px;
    overflow: hidden;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 4;

    span {
      color: $color-font-normal;
    }
  }

  .goods-show-num {
    font-size: 12px;
    margin-bottom: 6px;

    span {
      color: #009688;
    }
  }

  .goods-show-num span {
    color: #005AA0;
    font-weight: bold;
  }

  .goods-show-seller {
    font-size: 12px;

    span {
      color: #E4393C;
    }
  }
</style>
