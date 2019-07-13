<template>
  <div class="shop-box">
    <div class="shop-container">
      <div class="shop-title">
        <div class="shop-title-icon">
          <Icon type="fireball"></Icon>
          <i class="fa fa-fire"></i>
        </div>
        <div class="shop-title-content">
          <p style="">
            <router-link to="/merchant">{{ storeInfo.storeName }}</router-link>
          </p>
          <p>
            <router-link to="/merchant">{{ storeInfo.storePosition }}</router-link>
          </p>
        </div>
      </div>
      <div class="shop-another-item">
        <div class="shop-another-item-detail" v-for="(item, index) in storeInfo.showGoods" :key="index">
          <div class="shop-another-item-img">
            <img :src="item.img" alt="">
          </div>
          <div class="shop-anoter-item-intro">
            <p>{{ item.intro[0] }}</p>
            <p>{{ item.intro[1] }}</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'ShopHeader',
    data() {
      return {

      };
    },
    computed: {
      storeInfo(){
        return this.$store.getters.storeInfo
      }
    }
  };
</script>

<style lang="scss" scoped>
  @import "../../style/index";

  /* 店铺介绍 */
  .shop-box {
    width: 100%;
    height: 120px;
    //background-color: #484848;
    background-image: linear-gradient(to right, #4867c0, $color-primary, #4867c0);
  }

  .shop-container {
    width: 80%;
    height: 100%;
    margin: 0px auto;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
    color: #fff;
  }

  .shop-title {
    display: flex;
    flex-direction: row;
  }

  .shop-title-icon {
    font-size: 46px;
  }

  .shop-title-content {
    padding-top: 8px;
    margin-left: 15px;
  }

  .shop-title-content p {
    line-height: 26px;
    font-size: 20px;
  }

  .shop-title-content a {
    color: #fff;
  }

  .shop-another-item {
    display: flex;
    flex-direction: row;
  }

  .shop-another-item-detail {
    display: flex;
    flex-direction: row;
    align-items: center;
    margin-left: 15px;
  }

  .shop-another-item-img {
    height: 80px;
    border-radius: 40px;
    overflow: hidden;
  }

  .shop-another-item-img img {
    width: 80px;
  }

  .shop-anoter-item-intro {
    margin-left: 15px;
  }
</style>
