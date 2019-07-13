import {getStore, setStore} from "@/utils/localStorage";
import request from "@/utils/request";

const book = {
  state: {
    bookId: getStore('bookId'),
    bookInfo: {
      id: 'loginbg.png',
      bookImg: [
        'http://img3m1.ddimg.cn/65/14/27864011-1_w_9.jpg',
      ],
      title: '三体',
      bookName: '三体',
      outline: '', // 概述
      detail: '', // 图书详情
      author: '刘慈欣',
      press: '机械工业出版社',
      publishDate: '2019-1',
      version: '第三版',
      isbn: '',
      price: 100,
      pages: 100,
      catalog: '',
      marketPrice: 99,
      dealMount: 11111, // 交易数量
      lookMount: 22222, // 查看数量
      discount: 0, // 优惠
      storeMount: 100, // 库存
      storeTime: '', // 库存日期
      packStyle: '', //包装类型
      description: '',
      content: '.。。。。。。。。。',
      remarksNum: 0, // 评论数
    },
    storeInfo: getStore('storeInfo'),
    comments: [
      {
        commentId: 0,
        userId: 0,
        username: '',
        date: '',
        content: '',
        flag: ''
      }
    ]
  },
  mutations: {
    SET_BOOK_ID: (state, id) => {
      state.bookId = id
      setStore('bookId', id)
    },
    SET_BOOK_INFO: (state, info) => {
      state.bookInfo = info
      setStore('bookInfo', info)
    },
    SET_STORE_INFO: (state, info) => {
      state.storeInfo = info
      setStore('storeInfo', info)
    },
    SET_COMMENTS: (state, list) => {
      state.comments = list
      setStore('comments', list)
    }
  },
  actions: {
    setBookId({commit}, bookId) {
      commit('SET_BOOK_ID', bookId)
    },
    setBookInfo({commit}, info) {
      commit('SET_BOOK_INFO', info)
    },
    setBookStore({commit}, info) {
      commit('SET_STORE_INFO', info)
    },
    setBookComments({commit}, list) {
      commit('SET_COMMENTS', list)
    },
    setCommentList({commit}, info) {
      commit('SET_COMMENTS', info)
    },
    loadBookInfo({commit}, bookId) {
      return new Promise((resolve, reject) => {
        request({
          url: `/bookInfo?id=${bookId}`,
          method: 'get'
        }).then(response => {
          const data = response.data.data
          commit('SET_BOOK_INFO', data)
          resolve(data)
        }).catch(error => {
          reject(error)
        })
      })
    },
    loadStoreInfo({commit}, storeId) {
      return new Promise((resolve, reject) => {
        request({
          url: `/store?id=${storeId}`,
          method: 'get'
        }).then(response => {
          commit('SET_STORE_INFO', response.data)
          resolve()
        }).catch(error => {
          reject(error)
        })
      })
    },
    loadBookComments({commit}, bookId) {
      return new Promise((resolve, reject) => {
        request({
          url: `/comment/book?bookId=${bookId}`,
          method: 'get'
        }).then(response => {
          commit('SET_COMMENTS', response.data)
          resolve()
        }).catch(error => {
          reject(error)
        })
      })
    }
  }
}

export default book
