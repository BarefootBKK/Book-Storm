const getters = {
  isLoading: state => state.appState.isLoading,
  signUpStep: state => state.appState.signUpStep,
  username: state => state.user.username,
  token: state => state.user.token,
  userInfo: state => state.user.userInfo,
  shoppingCartList: state => state.user.shoppingCartList,
  newShoppingItem: state => state.user.newShoppingItem,
  address: state => state.user.userInfo.addressList,
  lastOrderId: state => state.user.lastOrderId,
  marketing: state => state.portal.marketing,
  categoryList: state => state.portal.categoryList,
  indexContents: state => state.portal.indexContents,
  goodsList: state => state.portal.goodsList,
  adsItems: state => state.portal.adsItems,
  bookId: state => state.book.bookId,
  bookInfo: state => state.book.bookInfo,
  storeInfo: state => state.book.storeInfo,
  comments: state => state.book.comments,
}

export default getters
