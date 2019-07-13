<template>
  <div>
    <div class="item-detail-show">
      <div class="item-detail-left">
        <div class="item-detail-big-img">
          <img :src="bookInfo.imageUrl" alt="">
        </div>
      </div>
      <div class="item-detail-right">
        <div class="item-detail-title">
          <p>{{bookInfo.name}}</p>
        </div>
        <div class="item-detail-tag">
          <p>
            <span v-for="(item,index) in bookInfo.tags" :key="index">【{{item}}】</span>
          </p>
        </div>
        <!-- book info -->
        <div class="item-basic-info">
          <span class="book-attr">作者:
            <router-link :to="'/search/author?query=' + bookInfo.author">{{bookInfo.author}}</router-link>
          </span>
          <span class="book-attr">出版社:
            <router-link :to="'/search/press?query=' + bookInfo.press">{{bookInfo.press}}</router-link>
          </span>
          <span class="book-attr">出版时间:{{bookInfo.publishDate}}</span>
          <div>

          </div>
        </div>

        <div class="item-detail-price-row">
          <div class="item-price-left">
            <div class="item-price-row">
              <p>
                <span class="item-price-title">售 价</span>
                <span class="item-price">￥{{price.toFixed(2)}}</span>
              </p>
            </div>
            <div class="item-price-row">
              <p>
                <span class="item-price-title">优 惠 价</span>
                <span class="item-price-full-cut" v-for="(item,index) in bookInfo.discount" :key="index">{{item}}</span>
              </p>
            </div>
            <div class="item-price-row">
              <p>
                <span class="item-price-title">促&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;销</span>
                <span class="item-price-full-cut" v-for="(item,index) in bookInfo.promotion"
                      :key="index">{{item}}</span>
              </p>
            </div>
          </div>
        </div>
        <div class="item-stat">
          <div class="item-stat-child">
            <p>累计评价</p>
            <p>
              <span class="item-stat-num">{{remarks}} 条</span>
            </p>
          </div>
          <div class="item-stat-child">
            <p>销量</p>
            <p>
              <span class="item-stat-num">{{bookInfo.dealMount}}</span>
            </p>
          </div>
        </div>
        <div class="add-buy-car-box">
          <div class="add-buy-car">
            <div style="display: flex">
              <InputNumber :min="1" :max="bookInfo.storeMount" v-model="count" size="large"></InputNumber>
              <div class="">
                <p>库存</p>
                <p>
                  <span class="item-stat-num">{{bookInfo.storeMount}} 条</span>
                </p>
              </div>
            </div>
            <Button type="info" size="large" @click="addShoppingCartBtn()">加入购物车</Button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import request from '@/utils/request'

  export default {
    name: 'ShowGoods',
    data() {
      return {
        price: 0,
        count: 1,
        selectBoxIndex: 0,
        imgIndex: 0
      };
    },
    computed: {
      bookInfo() {
        return this.$store.getters.bookInfo
      },
      remarks() {
        return this.$store.getters.comments.length
      },
      isLogin() {
        const token = this.$store.getters.token
        const username = this.$store.getters.username
        return token && token !== '' && username && username !== ''
      },
    },
    created() {
      this.initBookInfo()
    },
    mounted() {

    },
    methods: {
      initBookInfo() {
        this.$store.dispatch('setIsLoading', true)
        const bookId = this.$store.getters.bookId
        request.get(`/book?id=${bookId}`).then(response => {
          const data = response.data.data
          this.$store.dispatch('setBookInfo', data.bookInfo)
          this.$store.dispatch('setBookStore', data.store)
          this.$store.dispatch('setBookComments', response.data.data.commentList)
          this.price = this.bookInfo.price

          this.$store.dispatch('setIsLoading', false)
        }).catch(error => {
          this.$store.dispatch('setIsLoading', false)
        })
      },

      select(index1, index2) {
        this.selectBoxIndex = index1 * 3 + index2;
        this.price = this.bookInfo.setMeal[index1][index2].price;
      },
      showBigImg(index) {
        this.imgIndex = index;
      },
      addShoppingCartBtn() {
        if (!this.isLogin) {
          this.$Modal.confirm({
            title: 'Book Storm',
            content: '未登录，请先登录',
            onOk: () => {
              this.$router.push('/login')
            },
            onCancel: () => {
              this.$Message.info('登录之后才能加入购物车')
            }
          });
        } else {
          const bookId = this.$store.getters.bookId
          const data = {
            bookId: bookId,
            count: this.count,
            username: this.$store.getters.username
          };
          request.put(`/user/shoppingCart`, data).then(response => {
            data.book = this.bookInfo
            this.$store.dispatch('setNewShoppingCartItem', data)
            // update shopping cart
            const _data = response.data.data
            this.$store.dispatch('setShoppingCartList', _data)

            this.$router.push('/shoppingCart');
          }).catch(error => {
            this.$Message.error(error)
          })
        }
      }
    },
  };
</script>

<style lang="scss" scoped>
  /******************商品图片及购买详情开始******************/
  .item-detail-show {
    width: 80%;
    margin: 15px auto;
    display: flex;
    flex-direction: row;
    background-color: #fff;
  }

  .item-detail-left {
    width: 350px;
    margin-right: 30px;
  }

  .item-detail-big-img {
    width: 350px;
    height: 350px;
    box-shadow: 0px 0px 8px #ccc;
    cursor: pointer;
  }

  .item-detail-big-img img {
    width: 100%;
  }

  .item-detail-img-row {
    margin-top: 15px;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }

  .item-detail-img-small {
    width: 68px;
    height: 68px;
    box-shadow: 0px 0px 8px #ccc;
    cursor: pointer;
  }

  .item-detail-img-small img {
    width: 100%;
  }

  /*商品选购详情*/
  .item-detail-right {
    display: flex;
    flex-direction: column;
  }

  .item-detail-title p {
    color: #666;
    font-size: 20px;
  }

  .item-detail-express {
    font-size: 14px;
    padding: 2px 3px;
    border-radius: 3px;
    background-color: #e4393c;
    color: #fff;
  }

  /*商品标签*/
  .item-detail-tag {
    font-size: 12px;
    color: #e4393c;
  }

  /*价格详情等*/
  .item-detail-price-row {
    padding: 5px;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    background-color: #ffffff;
  }

  .item-price-left {
    display: flex;
    flex-direction: column;
  }

  .item-price-title {
    color: #999999;
    font-size: 14px;
    margin-right: 15px;
  }

  .item-price-row {
    margin: 5px 0px;
  }

  .item-price {
    color: #e4393c;
    font-size: 23px;
    cursor: pointer;
  }

  .item-price-full-cut {
    margin-right: 5px;
    padding: 3px;
    color: #e4393c;
    font-size: 12px;
    background-color: #ffdedf;
    border: 1px dotted #e4393c;
    cursor: pointer;
  }

  .item-stat {
    padding: 10px 10% 10px 0;
    border: 1px dotted #c9c9c9;
    border-width: 1px 0;
    display: flex;
    justify-content: space-around;
    align-items: center;
  }

  .item-stat-child {
    flex: 1;
    padding-left: 8px;
    border-left: 1px solid #ccc;
  }

  .item-stat-child p {
    color: #999999;
    font-size: 12px;
    line-height: 10px;
    text-align: center;
  }

  .item-stat-num {
    line-height: 18px;
    color: #005eb7;
  }

  .item-select-img img {
    width: 100%;
  }

  .item-select-intro p {
    margin: 0px;
    padding: 5px;
  }

  .add-buy-car-box {
    width: 100%;
    border-top: 1px dotted #ccc;
  }

  .add-buy-car {
    margin-top: 15px;
    position: relative;
    display: flex;
    flex-direction: row;
    justify-content: flex-start;

    div{
      margin-right: 8px;
    }
  }

  /******************商品图片及购买详情结束******************/
</style>
