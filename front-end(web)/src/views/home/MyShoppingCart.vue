<template>
  <div>
    <Table border ref="selection" :columns="columns" :data="shoppingCart" size="large" no-data-text="您的购物车没有商品，请先添加商品到购物车再点击购买"></Table>
    <div class="go-to">
      <Button @click="goTo" type="primary">去付款</Button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'MyShoppingCart',
  data () {
    return {
      goodsCheckList: [],
      columns: [
        {
          type: 'selection',
          width: 58,
          align: 'center'
        },
        {
          title: '图片',
          key: 'imageUrl',
          width: 86,
          render: (h, params) => {
            return h('div', [
              h('img', {
                attrs: {
                  src: params.row.imgUrl,
                  style: 'width:100%'
                }
              })
            ]);
          },
          align: 'center'
        },
        {
          title: '商品信息',
          key: 'info',
          align: 'center'
        },
        {
          title: '单价',
          width: 198,
          key: 'price',
          align: 'center'
        },
        {
          title: '数量',
          key: 'mount',
          width: 68,
          align: 'center'
        },
        {
          title: '金额',
          width: 198,
          key: 'totalPrice',
          align: 'center'
        }
      ],
    };
  },
  created () {
    this.$store.dispatch('loadShoppingCart')
  },
  computed: {
    shoppingCart() {
      const cart = []
      const shoppingCartList = this.$store.getters.shoppingCartList
      if (shoppingCartList) {

        shoppingCartList.forEach(item => {
          let cartItem = {}
          cartItem.bookId = item.bookInfo.id
          cartItem.storeId = item.bookInfo.storeId
          cartItem.mount = item.count
          cartItem.price = item.bookInfo.price
          cartItem.bookName = item.bookInfo.name
          cartItem.info = `${item.bookInfo.name} ${item.bookInfo.packStyle}`
          cartItem.imgUrl = item.bookInfo.imageUrl
          cartItem.totalPrice = cartItem.mount * cartItem.price
          cart.push(cartItem)
        })
      }
      return cart
    },
  },
  methods: {
    goTo () {
      this.$router.push('/order');
    }
  },
};
</script>

<style scoped>
.go-to {
  margin: 15px;
  display: flex;
  justify-content: flex-end;
}
</style>
