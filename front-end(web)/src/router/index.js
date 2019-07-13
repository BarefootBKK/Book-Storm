import Vue from 'vue'
import VueRouter from 'vue-router'
import store from '../store'
import {getToken} from "@/utils/auth";
import iView from 'iview'

import Index from '@/views/Index';

const Login = resolve => require(['@/views/Login'], resolve);
const SignUp = resolve => require(['@/views/SignUp'], resolve);
const CheckPhone = resolve => require(['@/views/signUp/CheckPhone'], resolve);
const InputInfo = resolve => require(['@/views/signUp/InputInfo'], resolve);
const SignUpDone = resolve => require(['@/views/signUp/SignUpDone'], resolve);
const Category = resolve => require(['@/views/Category'], resolve);
const BookDetail = resolve => require(['@/views/BookDetail'], resolve);
const ShoppingCart = resolve => require(['@/views/ShoppingCart'], resolve);
const Order = resolve => require(['@/views/Order'], resolve);
const Pay = resolve => require(['@/views/Pay'], resolve);
const PayDone = resolve => require(['@/views/PayDone'], resolve);
const Freeback = resolve => require(['@/views/Freeback'], resolve);
const Home = resolve => require(['@/views/Home'], resolve);
const MyAddress = resolve => require(['@/views/home/MyAddress'], resolve);
const AddAddress = resolve => require(['@/views/home/AddAddress'], resolve);
const MyOrder = resolve => require(['@/views/home/MyOrder'], resolve);
const MyShoppingCart = resolve => require(['@/views/home/MyShoppingCart'], resolve);
const Info = resolve => require(['@/views/home/UserInfo'], resolve);
const Merchant = resolve => require(['@/views/Merchant'], resolve);
const Logout = resolve => require(['@/views/Logout'], resolve);
const Layout = resolve => require(['@/components/Layout'], resolve);

Vue.use(VueRouter)

const router = new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/', // 首页
      name: 'Index',
      component: Index
    },
    {
      path: '/Login', // 登录
      name: 'Login',
      component: Login
    },
    {
      path: '/logout', // 登录
      name: 'Logout',
      component: Logout
    },
    {
      path: '/SignUp', // 注册
      name: 'SignUp',
      component: SignUp,
      children: [
        {
          path: '/',
          name: 'index',
          component: CheckPhone
        },
        {
          path: 'checkPhone',
          name: 'CheckPhone',
          component: CheckPhone
        },
        {
          path: 'inputInfo',
          name: 'InputInfo',
          component: InputInfo
        },
        {
          path: 'signUpDone',
          name: 'SignUpDone',
          component: SignUpDone
        }
      ]
    },
    {
      path: '/category', // 商品列表
      name: 'Category',
      component: Category
    },
    {
      path: '/book', // 商品详情
      name: 'BookDetail',
      component: BookDetail
    },
    {
      path: '/shoppingCart', // 商品详情
      name: 'ShoppingCart',
      component: ShoppingCart
    },
    {
      path: '/order', // 订单页面
      name: 'Order',
      component: Order
    },
    {
      path: '/pay', // 支付页面
      name: 'Pay',
      component: Pay
    },
    {
      path: '/payDone', // 支付成功页面
      name: 'PayDone',
      component: PayDone
    },
    {
      path: '/freeback', // 反馈页面
      name: 'Freeback',
      component: Freeback
    },
    {
      path: '/home', // 主页
      name: 'Home',
      component: Home,
      children: [
        {
          path: '/',
          name: 'HomeIndex',
          component: MyOrder
        },
        {
          path: 'myAddress',
          name: 'MyAddress',
          component: MyAddress
        },
        {
          path: 'addAddress',
          name: 'AddAddress',
          component: AddAddress
        },
        {
          path: 'myOrder',
          name: 'MyOrder',
          component: MyOrder
        },
        {
          path: 'myShoppingCart',
          name: 'MyShoppingCart',
          component: MyShoppingCart
        },
        {
          path:'info',
          name:'Info',
          component: Info
        }
      ]
    },
    {
      path: '/merchant',
      name: 'Merchant',
      component: Merchant
    },
  ]
})

const whiteList = ['/', '/Index', '/category', '/book', '/Login', '/login', '/SignUp', '/SignUp/checkPhone', '/SignUp/inputInfo', '/SignUp/signUpDone', '/freeback',]
router.beforeEach((to, from, next) => {
  // authorized, permit all
  if (getToken()) {

    const _store = store

    store.dispatch('initUserData').then(res => { // 拉取用户信息
      next()
    }).catch((err) => {
      store.dispatch('logout').then(() => {
        iView.Message.error(err || 'Verification failed, please login again')
        next({path: '/login'})
      })
    })

    /*if (!store.getters.userInfo || store.getters.userInfo.length === 0) {

    } else {
      next()
    }*/
  } else {// unauthorized
    if (whiteList.indexOf(to.path) === -1) {
      next({
        path: '/login',
        //query: {redirect: to.fullPath}
      })
    } else {// to the path in white list
      next()// 一定要调用 next()
    }
  }
})

router.afterEach(() => {
})

export default router
