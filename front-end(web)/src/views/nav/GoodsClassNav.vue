<template>
  <div class="item-class-show">
    <Row class="item-class-group" v-for="(items, index) in tagsInfo" :key="index">
      <i-col class="item-class-name" span="3">{{ items.tagName }} :</i-col>
      <i-col class="item-class-select" span="21">
        <a v-for="(item, subIndex) in items.tags" :key="subIndex" :href="'/category?name=' + item">
          <span>{{ item }}</span>
        </a>
      </i-col>
    </Row>
  </div>
</template>

<script>
  import request from '@/utils/request'

  export default {
    name: 'GoodsClassNav',
    props: {
      query: '',
    },
    data() {
      return {
        tagsInfo: [
          {
            tagName: '分类',
            tags: []
          },
          {
            tagName: '标签',
            tags: []
          }
        ]
      };
    },
    created() {
      this.loadCategory()
    },
    methods: {
      loadCategory() {
        request('/index/category?pageSize=294&pageNum=0').then(response => {
          const categoryList = response.data.data.list
          let that = this
          categoryList.forEach(item => {
            that.tagsInfo[0].tags.push(item.name)
            if (item.name == this.query) {
              item.children.forEach(child => {
                that.tagsInfo[1].tags.push(child.name)
              })
            }
          })
        }).catch(error => {
          this.$Message.error({
            content: error
          })
        })
      },
    }
  };
</script>

<style scoped>
  .item-class-show {
    display: flow-root;
    margin: 15px auto;
    width: 100%;
  }

  .item-class-group {
    margin-top: 1px;
    border-bottom: 1px solid #ccc;
  }

  .item-class-group:first-child {
    border-top: 1px solid #ccc;
  }

  .item-class-name {
    padding-left: 15px;
    line-height: 44px;
    color: #666;
    font-weight: bold;
    background-color: #f3f3f3;
  }

  .item-class-name:first-child {
    line-height: 43px;
  }

  .item-class-select span {
    margin-left: 15px;
    width: 160px;
    color: #005aa0;
    line-height: 45px;
    cursor: pointer;
    word-break: keep-all;
  }
</style>
