<template>
  <div>
    <div class="item-intro-show">
      <div class="item-intro-detail" ref="itemIntroDetail">
        <div class="item-intro-nav item-tabs">
          <Tabs type="card" style="border:2px;">

            <TabPane label="图书详情">
              <div class="remarks-title">
                <span>图书详情</span>
              </div>
              <div class="item-param-container">
                <p>书名：{{bookInfo.name}}</p>
                <p>概述：{{bookInfo.outline}}</p>
                <p>定价：{{bookInfo.marketPrice}}</p>
                <p>作者：{{bookInfo.author}}</p>
                <p>出版社：{{bookInfo.press}}</p>
                <p>出版日期：{{bookInfo.publishDate}}</p>
                <p>ISBN：{{bookInfo.isbn}}</p>
                <p>装帧：{{bookInfo.packStyle}}</p>
                <p>开本：{{bookInfo.size}}</p>
              </div>
            </TabPane>
            <TabPane label="商品评价">
              <div class="remarks-container">
                <div class="remarks-box" v-for="(item,index) in comments" :key="index">
                  <div class="remarks-user">
                    <Avatar icon="person"/>
                    <span class="remarks-user-name">{{item.username}}</span>
                  </div>
                  <div class="remarks-content-box">
                    <!--<p>
                      <Rate disabled :value="item.values" allow-half class="remarks-star"></Rate>
                    </p>-->
                    <p class="remarks-content">{{item.content}}</p>
                    <p class="remarks-sub">
                      <!--<span class="remarks-item">{{item.goods}}</span>-->
                      <span class="remarks-time">{{item.date}}</span>
                    </p>
                  </div>
                </div>
                <div class="remarks-page">
                  <Page :total="1" size="small" show-elevator show-sizer></Page>
                </div>
              </div>
            </TabPane>
            <TabPane label="撰写评价" name="name1">
              <Form ref="commontForm" :model="commentForm" :rules="commentRules">
                <FormItem prop="content">
                  <Input type="textarea" :rows="7" size="large" v-model="commentForm.content"
                         placeholder="Enter something..."
                         style="width: 100%"/>
                </FormItem>
                <FormItem>
                  <Button type="primary" @click.native.prevent="handlePostComment">提 交</Button>
                </FormItem>
              </Form>
            </TabPane>
          </Tabs>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import ShowProductWarranty from '@/views/goodsDetail/ShowProductWarranty';
  import request from '@/utils/request'

  export default {
    name: 'ShowGoodsDetail',
    data() {
      return {
        tagsColor: ['blue', 'green', 'red', 'yellow'],
        commentRules: {
          content: [
            {required: true, trigger: 'blur'}
          ]
        },
        commentForm: {
          bookId: this.$store.getters.bookId,
          userId: this.$store.getters.userInfo.id,
          username: this.$store.getters.username,
          content: ''
        },
      };
    },
    computed: {
      comments() {
        return this.$store.getters.comments
      },
      bookInfo() {
        return this.$store.getters.bookInfo
      }
    },
    created() {
      this.initData()
    },
    methods: {
      initData() {
        const bookId = this.$store.getters.bookId
        request.get(`/comment/book?id=${bookId}`).then(response => {
          this.$store.dispatch('setBookComments', response.data.data)
        }).catch(error => {
          this.$Message.error({
            content: `拉取评论失败：${error}`
          })
        })
      },
      handlePostComment() {
        request.post('/comment/book', this.commentForm).then(response => {
          this.$store.dispatch('setBookComments', response.data.data)
        }).catch(error => {
          this.$Message.error({
            content: `发布评论失败：${error}`
          })
        })
      },
      changeHeight() {
        let heightCss = window.getComputedStyle(this.$refs.itemIntroGoods).height;
        console.log(heightCss);
        heightCss = parseInt(heightCss.substr(0, heightCss.length - 2)) + 89;
        this.$refs.itemIntroDetail.style.height = heightCss + 'px';
      }
    },
    updated() {
      /*this.$nextTick(() => {
        setTimeout(this.changeHeight, 100);
        setTimeout(this.changeHeight, 1000);
        setTimeout(this.changeHeight, 3000);
        setTimeout(this.changeHeight, 5000);
        setTimeout(this.changeHeight, 10000);
        setTimeout(this.changeHeight, 15000);
        setTimeout(this.changeHeight, 20000);
        setTimeout(this.changeHeight, 25000);
        setTimeout(this.changeHeight, 30000);
        setTimeout(this.changeHeight, 50000);
      });*/
    },
    components: {
      ShowProductWarranty
    },
  };
</script>

<style lang="scss" scoped>
  /***************商品详情介绍和推荐侧边栏开始***************/
  .item-intro-show {
    width: 80%;
    margin-top: 70px;
    margin-left: 120px;
    /*margin: 20px auto;*/
    display: flex;
    flex-direction: row;
    background-color: #fff;
  }

  .item-recommend-img img {
    width: 100%;
  }

  .item-intro-detail {
    margin-left: 30px;
    width: calc(80vw - 300px);
  }

  .item-intro-nav {
    width: 100%;
    background-color: #ffffff;
    border-bottom: 2px solid #3CA9C4;
  }

  .item-intro-nav ul {
    margin: 0px;
    padding: 0px;
    list-style: none;
  }

  .item-intro-nav li {
    float: left;
    height: 100%;
    width: 120px;
    line-height: 38px;
    text-align: center;
    color: #E4393C;
  }

  .item-intro-nav li:first-child {
    background-color: #E4393C;
    color: #fff;
  }

  .item-intro-img img {
    width: 100%;
  }

  /************* 商品参数 *************/
  .item-param-container {
    display: block;
    /*flex-wrap: wrap;
    flex-direction: row;
    justify-content: space-between;*/

    p{
      display: block;
      line-height: 1.4;
      margin: 1.12em 0
    }
  }

  .item-param-box {
    padding: 5px;
    padding-left: 30px;
    width: 240px;
    height: 36px;
    font-size: 14px;
    /* text-align: center; */
    /* background-color: #ccc; */
  }

  .item-param-title {
    color: #232323;
  }

  .item-param-content {
    color: #999;
  }

  .remarks-title {
    padding-left: 15px;
    height: 36px;
    font-size: 16px;
    font-weight: bolder;
    line-height: 36px;
    color: #666666;
    background-color: #F7F7F7;
  }

  .remarks-analyse-box {
    padding: 15px;
    display: flex;
    align-items: center;
  }

  .remarks-analyse-goods {
    margin-left: 15px;
    margin-right: 15px;
  }

  .remarks-analyse-num {
    font-size: 26px;
  }

  .remarks-analyse-title {
    font-size: 12px;
    line-height: 20px;
  }

  .remarks-bar {
    padding-left: 15px;
    height: 36px;
    line-height: 36px;
    color: #666666;
    background-color: #F7F7F7;
  }

  .remarks-bar span {
    margin-right: 15px;
  }

  .remarks-box {
    padding: 15px;
    display: flex;
    flex-direction: column;
    border-bottom: 1px #ccc dotted;
    border-top: 1px #ccc dotted;
  }

  .remarks-user {
    width: 180px;
  }

  .remarks-user-name {
    padding-left: 15px;
  }

  .remarks-content-box {
    width: calc(100% - 180px);
    padding-left: 15px;
  }

  .remarks-star {
    background-color: #fff;
  }

  .remarks-content {
    font-size: 14px;
    color: #232323;
    line-height: 28px;
  }

  .remarks-sub {
    margin-top: 15px;
    color: #ccc;
  }

/*  .remarks-time {
    margin-left: 15px;
  }*/

  .remarks-page {
    margin: 15px;
    display: flex;
    justify-content: flex-end;
  }

  /***************商品详情介绍和推荐侧边栏结束***************/
</style>

<style>
  /* 改变便签页样式 */
  .ivu-tabs-ink-bar {
    background-color: #3CA9C4 !important;
  }

  .item-tabs > .ivu-tabs > .ivu-tabs-bar .ivu-tabs-tab {
    border-radius: 10px;
    color: #999;
    height: 38px;
    background: #F7F7F7;
  }

  .item-tabs > .ivu-tabs > .ivu-tabs-bar .ivu-tabs-tab-active {
    color: #fff;
    background-color: #3CA9C4;
  }

  .item-tabs > .ivu-tabs > .ivu-tabs-bar .ivu-tabs-tab-active:before {
    content: '';
    display: block;
    width: 100%;
    height: 1px;
    color: #fff;
    background: #F7F7F7;
    position: absolute;
    top: 0;
    left: 0;
  }

  .ivu-rate-star-full:before, .ivu-rate-star-half .ivu-rate-star-content:before {
    color: #E4393C;
  }
</style>
