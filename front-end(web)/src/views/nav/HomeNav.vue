<template>
  <div>
    <div class="nav-body">
      <!-- 侧边导航 -->
      <div class="nav-side" ref="navSide">
        <ul v-for="(category, index) in categoryList" :key="index">
          <li @mouseenter="showDetail(index)" @mouseleave="hideDetail(index)">
            <router-link :to="'/category?name=' + category.name">
              <span class="nav-side-item">{{category.name}}</span>/
            </router-link>
          </li>
        </ul>
        <ul>
          <li>
            <router-link to="/category?name=all">
              <span class="nav-side-item">全部分类</span>
            </router-link>
          </li>
        </ul>
      </div>
      <div class="nav-content">
        <!-- 幻灯片 -->
        <div>
          <Carousel autoplay :autoplay-speed="3000" loop :height="440">
            <CarouselItem v-for="(item, index) in marketing.banner" :key="index">
              <a :href="item.targetUrl">
                <img :src="item.imgUrl">
              </a>
            </CarouselItem>
          </Carousel>
        </div>
      </div>
    </div>
    <transition name="fade">
      <div class="detail-item-panel panel-1" :duration="{ enter: 100, leave: 100 }"
           v-show="showItemPanel"
           @mouseenter="showDetail(currentShow)" ref="itemPanel" @mouseleave="hideDetail()">
        <div class="nav-detail-item">
          <span v-for="(item, index) in currentCategory" :key="index">
            <router-link :to="'/category?name=' + item">{{item}}</router-link>
          </span>
        </div>
      </div>
    </transition>
  </div>
</template>

<script>
  import store from '@/store';
  import request from '@/utils/request'

  export default {
    name: 'HomeNav',
    data() {
      return {
        showItemPanel: false,
        currentShow: 0,
        categoryList: [],
        cateChildrenList: [],
        marketing: {},
      };
    },
    computed: {
      currentCategory() {
        if (this.categoryList.length > 0) {
          return this.cateChildrenList[this.currentShow]
        } else {
          return []
        }
      }
    },
    created() {
      this.loadCategory()
      this.loadMarketing()
    },
    mounted() {
      this.setItemPanel()
    },
    updated() {
      this.setItemPanel()
    },
    methods: {
      loadCategory() {
        request('/index/category?pageSize=294&pageNum=0').then(response => {
          const categoryList = response.data.data.list
          let that = this
          let i = 0
          let children = []
          categoryList.forEach(item => {
            item.children.forEach(child => {
              children.push([])
              children[i].push(child.name)
            })
            i++
          })
          this.categoryList = categoryList.slice(0, 10)
          this.cateChildrenList = children
        }).catch(error => {
          this.$Message.error({
            content: error
          })
        })
      },
      loadMarketing() {
        request('/index/marketing').then(response => {
          let t = this.showItemPanel
          this.marketing = response.data.data
        }).catch(error => {
          this.$Message.error({
            content: error
          })
        })
      },
      showDetail(index) {
        this.currentShow = index;
        this.showItemPanel = true
      },
      hideDetail() {
        this.showItemPanel = false;
      },
      setItemPanel() {
        if (this.$refs.itemPanel) {
          this.$refs.itemPanel.style.left =
            this.$refs.navSide.offsetLeft + this.$refs.navSide.offsetWidth + 'px';
          this.$refs.itemPanel.style.top = this.$refs.navSide.offsetTop + 'px';
        }
      }
    },
    store
  };
</script>

<style lang="scss" scoped>
  $color-primary: #409EFF;

  div.ivu-carousel-item {
    a {
      img {
        height: 100%;
      }
    }
  }

  .nav-item {
    width: 680px;
    height: 36px;
    margin: 0 auto;
  }

  .nav-item ul {
    list-style: none;
    margin-left: 15px;
  }

  .nav-item li {
    float: left;
    font-size: 16px;
    font-weight: bold;
    margin-left: 30px;
  }

  .nav-item a {
    text-decoration: none;
    color: #555555;
  }

  .nav-item a:hover {
    color: #d9534f;
  }

  /*大的导航信息，包含导航，幻灯片等*/
  .nav-body {
    width: 1050px;
    height: 440px;
    margin: 0px auto;
    background-color: #fff;
  }

  .nav-side {
    width: 230px;
    height: 100%;
    padding: 0px;
    color: #fff;
    float: left;
    border: 1px solid $color-primary;
    border-right: none;
    background-color: $color-primary;

    ul {
      li {
        a {
          color: #fff;

          span {
            color: #fff;
          }
        }
      }
    }
  }

  .nav-side ul {
    width: 100%;
    padding: 10px 0 0;
    list-style: none;
  }

  .nav-side li {
    padding: 6px 7.5px 6px 15px;
    font-size: 14px;
    line-height: 18px;
  }

  .nav-side li:hover {
    background: #fff;

    a {
      color: $color-primary;

      span {
        color: $color-primary;
      }
    }
  }

  .nav-side-item:hover {
    cursor: pointer;
    color: #c81623;

  }

  /*导航内容*/
  .nav-content {
    width: 792px;
    margin-left: 15px;
    overflow: hidden;
    float: left;
  }

  /*导航图片*/
  .nav-show-img {
    margin-top: 10px;
    float: left;
  }

  .nav-show-img:nth-child(2) {
    margin-left: 12px;
  }

  /*显示商品*/
  .content {
    width: 100%;
  }

  /*显示商品详细信息*/
  .detail-item-panel {
    width: 815px;
    height: 440px;
    background-color: #fff;
    position: absolute;
    top: 168px;
    left: 389px;
    z-index: 99;
    border: 1px solid $color-primary;
    border-left: none;
  }

  .nav-detail-item {
    margin-left: 26px;
    margin-top: 15px;
    margin-bottom: 15px;
    cursor: pointer;
    color: #eee;
  }

  .nav-detail-item span {
    display: inline-block;
    padding: 6px 6px 6px 12px;
    margin-left: 15px;
    margin-top: 15px;
    font-size: 12px;
    background-color: $color-primary;

    a {
      color: #fff;
    }
  }

  .nav-detail-item span:hover {
    margin-left: 15px;
    background-color: #fff;

    a {
      color: $color-primary;
    }
  }

  .detail-item-panel ul {
    list-style: none;
  }

  .detail-item-panel li {
    line-height: 38px;
    margin-left: 40px;
  }

  .detail-item-title {
    padding-right: 6px;
    font-weight: bold;
    font-size: 12px;
    cursor: pointer;
    color: #555555;
  }

  .detail-item-title:hover {
    color: #d9534f;
  }

  .detail-item-row a {
    color: #555555;
  }

  .detail-item {
    font-size: 14px;
    padding-left: 12px;
    padding-right: 8px;
    cursor: pointer;
    border-left: 1px solid #ccc;
  }

  .detail-item:hover {
    color: #d9534f;
  }
</style>
