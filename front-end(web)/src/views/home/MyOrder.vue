<template>
  <div>
    <Tabs :value="currentPane" type="card">
      <TabPane :label="pane.title" :name="pane.title" v-for="(pane, i) in orderPanel" :key="i"
               @click="setCurrentIndex(i)">
        <Table border :columns="columns" :data="pane.orders" size="large" no-data-text="你还没有订单，快去购物吧">
          <template slot-scope="{ row, index }" slot="orderId">
            <span>{{row.orderId}}</span>
          </template>
          <template slot-scope="{ row, index }" slot="imageUrl">
            <div class="img-container">
              <img :src="row.imageUrl">
            </div>
          </template>
          <template slot-scope="{ row, index }" slot="bookName">
            <span>{{row.bookName}}</span>
          </template>
          <template slot-scope="{ row, index }" slot="mount">
            <span>{{row.mount}}</span>
          </template>
          <template slot-scope="{ row, index }" slot="totalPrice">
            <span>{{row.totalPrice}}</span>
          </template>
        </Table>
      </TabPane>
    </Tabs>

    <div class="page-size">
      <Page :total="pageTotal" show-sizer></Page>
    </div>
  </div>

</template>
<script>
  import request from '@/utils/request'

  export default {
    name: 'MyOrder',
    data() {
      return {
        currentPane: "未支付",
        columns: [
          {
            title: '订单编号',
            slot: 'orderId'
          },
          {
            title: '图片',
            slot: 'imageUrl'
          },
          {
            title: '图书信息',
            slot: 'bookName'
          },
          {
            title: '数量',
            slot: 'mount'
          },
          {
            title: '金额',
            slot: 'totalPrice'
          }
        ],
        orderPanel: [
          {
            title: '未支付',
            orders: []
          },
          {
            title: '未完成',
            orders: []
          },
          {
            title: '已完成',
            orders: []
          },
        ],
        orderList: [],
      }
    },
    created() {
      this.loadMyOrderList()
    },
    computed: {
      pageTotal() {
        const index = {"未支付": 0, "未完成": 1, "已完成": 2}
        return this.orderPanel[index[this.currentPane]].orders.length
      }
    },
    methods: {
      loadMyOrderList() {
        const username = this.$store.getters.username
        request.get(`/order/user?username=${username}`).then(response => {
          this.orderList = response.data.data.list
          this.computeShowOrder()
        }).catch(error => {
          this.$Message.error({
            content: `数据加载失败：${error}`
          })
        })
      },
      computeShowOrder() {
        if (this.orderList) {
          this.orderList.forEach(item => {
            this.orderPanel[parseInt(item.status)].orders.push(item)
          })
        }
        console.log(this.orderPanel)
      },
      setCurrentIndex(index) {
        //this.currentPane = index
        this.pageTotal = this.orderPanel[index].orders.length
        console.log(index)
      }
    }
  };
</script>

<style lang="scss" scoped>
  .page-size {
    margin: 15px 0px;
    display: flex;
    justify-content: flex-end;
    align-items: center;
  }
  .img-container{
    padding: 10%;

    img{
      width: 100%;
    }
  }
</style>
