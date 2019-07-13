import {clearStore, getStore, setStore} from '@/utils/localStorage'
import request, {fetch} from '@/utils/request'

const portal = {
  state: {
    // 首页营销 panel
    marketing: {
      banner: [{
        imgUrl: '',
        path: ''
      }],
      activities: [
        {
          imgUrl: '',
          path: ''
        }
      ]
    },

    // 分类标签
    categoryList: [
      {
        id: 0,
        navTitles: ["手机", "数码"],
        navTags: ['清洁用品', '美妆商城', '美妆馆', '妆比社', '全球购美妆', '宠物馆'],
        classNav: [
          {
            title: '面部护肤',
            tags: ['补水保湿', '卸妆', '洁面', '爽肤水', '乳液面霜', '精华', '眼霜', '防晒', '面膜', '剃须', '套装']
          },
          {
            title: '洗发护发',
            tags: ['洗发', '护发', '染发', '造型', '假发', '美发工具', '套装']
          }
        ]
      },
      {
        id: 1,
        navTitles: ["电脑", "办公"],
        navTags: ['赛事', '运动城', '户外馆', '健身房', '骑行馆', '钟表城'],
        classNav: [
          {
            title: '2017新品',
            tags: ['休闲鞋', '商务休闲鞋', '正装鞋', '帆布鞋', '凉鞋', '拖鞋', '功能鞋', '增高鞋', '工装鞋', '雨鞋']
          },
          {
            title: '运动鞋包',
            tags: ['跑步鞋', '休闲鞋', '篮球鞋', '帆布鞋', '板鞋', '拖鞋', '运动包']
          }
        ]
      }
    ],
    // 首页栏目内容
    indexContents: [
      {
        title: '',
        size: 0,
        items: [
          {
            imgUrl: '',
            path: '',
            title: '',
            authors: [],
            price: 0,
            originalPrice: 0,
            addition: ''
          }
        ]
      }
    ],
    adsItems: [
      {
        img: 'static/img/goodsList/item-as-img-1.jpg',
        price: 39.9,
        intro: 'SKSK 苹果7/7plus手机壳 iPhone 7 Plus保护套全包硬',
        num: 3140,
        sale: 9000
      },
      {
        img: 'static/img/goodsList/item-as-img-2.jpg',
        price: 36.6,
        intro: '狮普 苹果7/7 Plus手机壳 电镀 超薄 全包 防摔 保护外',
        num: 6160,
        sale: 8900
      },
      {
        img: 'static/img/goodsList/item-as-img-1.jpg',
        price: 38.6,
        intro: 'SKSK 苹果7/7plus手机壳 iPhone 7 Plus保护套全包硬',
        num: 9160,
        sale: 8800
      },
      {
        img: 'static/img/goodsList/item-as-img-2.jpg',
        price: 35.6,
        intro: '狮普 苹果7/7 Plus手机壳 电镀 超薄 全包 防摔 保护外',
        num: 6160,
        sale: 7990
      },
      {
        img: 'static/img/goodsList/item-as-img-1.jpg',
        price: 38.6,
        intro: 'SKSK 苹果7/7plus手机壳 iPhone 7 Plus保护套全包硬',
        num: 9160,
        sale: 7600
      },
      {
        img: 'static/img/goodsList/item-as-img-2.jpg',
        price: 35.6,
        intro: '狮普 苹果7/7 Plus手机壳 电镀 超薄 全包 防摔 保护外',
        num: 6160,
        sale: 6900
      }
    ],
    goodsList: [
      {
        id: '',
        img: 'static/img/goodsList/item-show-1.jpg',
        price: 36.60,
        intro: 'SKSK 苹果7/7plus手机壳 iPhone 7 Plus保护套全包硬壳男女磨砂防摔 火影红(苹',
        remarks: 6160,
        shopName: '元亨利配件专营店',
        sale: 9900
      }
    ],
    // sort goods list by sale/remarks/price
    orderBy: 'sale',
  },
  mutations: {
    SET_GOODS_LIST: (state, list) => {
      state.goodsList = list
      setStore('goodsList', list)
    },
    SET_MARKETING: (state, content) => {
      state.marketing = content
      setStore('marketing', content)
    },
    SET_CATEGORY_LIST: (state, content) => {
      state.categoryList = content
      setStore('categoryList', content)
    },
    SET_INDEX_CONTENTS: (state, content) => {
      state.indexContents = content
      setStore('indexContents', content)
    },
    SET_GOODS_ORDER_BY: (state, order) => {
      state.orderBy = order
    }
  },
  actions: {
    setBookList({commit}, list) {
      commit('SET_GOODS_LIST', list)
    },
    setSortOrder({commit}, order) {
      commit('SET_GOODS_ORDER_BY', order)
    },
    loadGoodsList({commit}) {
      /*const data = [
        {
          id: '',
          img: 'static/img/goodsList/item-show-1.jpg',
          price: 36.60,
          intro: 'SKSK 苹果7/7plus手机壳 iPhone 7 Plus保护套全包硬壳男女磨砂防摔 火影红(苹',
          remarks: 6160,
          shopName: '元亨利配件专营店',
          sale: 9900
        },
        {
          id: '',
          img: 'static/img/goodsList/item-show-2.jpg',
          price: 28.00,
          intro: '蒙奇奇 苹果6s手机壳磨砂防摔保护套 适用于iphone6/6s/6sPlus/6plus 6/6s 4.7英',
          remarks: 3000,
          shopName: 'monqiqi旗舰店',
          sale: 9600
        },
        {
          id: '',
          img: 'static/img/goodsList/item-show-3.jpg',
          price: 15.00,
          intro: 'BIAZE 苹果6/6s手机壳 苹果iphone6s 4.7英寸透明手机套 清爽系列',
          remarks: 2800,
          shopName: 'BIAZE官方旗舰店',
          sale: 8900
        },
        {
          img: 'static/img/goodsList/item-show-4.jpg',
          price: 29.90,
          intro: '慕臣 苹果6s手机壳全包防摔磨砂软保护套男女 适用于iPhone6splus',
          remarks: 9000,
          shopName: '歌乐力手配专营店',
          sale: 8600
        },
        {
          img: 'static/img/goodsList/item-show-5.jpg',
          price: 15.00,
          intro: 'BIAZE 苹果6/6s手机壳 苹果iphone6s 4.7英寸透明手机套 清爽系列',
          remarks: 6160,
          shopName: 'BIAZE官方旗舰店',
          sale: 8560
        },
        {
          img: 'static/img/goodsList/item-show-6.jpg',
          price: 28.00,
          intro: '慕臣 苹果6s手机壳全包防摔磨砂软保护套男女 适用于iPhone6splus',
          remarks: 9006,
          shopName: '歌乐力手配专营店',
          sale: 8530
        },
        {
          img: 'static/img/goodsList/item-show-7.jpg',
          price: 15.00,
          intro: 'BIAZE 苹果6/6s手机壳 苹果iphone6s 4.7英寸透明手机套 清爽系列',
          remarks: 8666,
          shopName: 'BIAZE官方旗舰店',
          sale: 8360
        },
        {
          img: 'static/img/goodsList/item-show-8.jpg',
          price: 29.90,
          intro: '慕臣 苹果6s手机壳全包防摔磨砂软保护套男女 适用于iPhone6splus',
          remarks: 6080,
          shopName: '歌乐力手配专营店',
          sale: 7560
        },
        {
          img: 'static/img/goodsList/item-show-1.jpg',
          price: 36.60,
          intro: 'SKSK 苹果7/7plus手机壳 iPhone 7 Plus保护套全包硬壳男女磨砂防摔 火影红(苹',
          remarks: 6160,
          shopName: '元亨利配件专营店',
          sale: 7360
        },
        {
          img: 'static/img/goodsList/item-show-2.jpg',
          price: 28.00,
          intro: '蒙奇奇 苹果6s手机壳磨砂防摔保护套 适用于iphone6/6s/6sPlus/6plus 6/6s 4.7英',
          remarks: 3000,
          shopName: 'monqiqi旗舰店',
          sale: 6960
        },
        {
          img: 'static/img/goodsList/item-show-3.jpg',
          price: 15.00,
          intro: 'BIAZE 苹果6/6s手机壳 苹果iphone6s 4.7英寸透明手机套 清爽系列',
          remarks: 2800,
          shopName: 'BIAZE官方旗舰店',
          sale: 6560
        },
        {
          img: 'static/img/goodsList/item-show-4.jpg',
          price: 29.90,
          intro: '慕臣 苹果6s手机壳全包防摔磨砂软保护套男女 适用于iPhone6splus',
          remarks: 9000,
          shopName: '歌乐力手配专营店',
          sale: 6360
        },
        {
          img: 'static/img/goodsList/item-show-5.jpg',
          price: 15.00,
          intro: 'BIAZE 苹果6/6s手机壳 苹果iphone6s 4.7英寸透明手机套 清爽系列',
          remarks: 6160,
          shopName: 'BIAZE官方旗舰店',
          sale: 5530
        },
        {
          img: 'static/img/goodsList/item-show-6.jpg',
          price: 28.00,
          intro: '慕臣 苹果6s手机壳全包防摔磨砂软保护套男女 适用于iPhone6splus',
          remarks: 9006,
          shopName: '歌乐力手配专营店',
          sale: 5560
        },
        {
          img: 'static/img/goodsList/item-show-7.jpg',
          price: 15.00,
          intro: 'BIAZE 苹果6/6s手机壳 苹果iphone6s 4.7英寸透明手机套 清爽系列',
          remarks: 8666,
          shopName: 'BIAZE官方旗舰店',
          sale: 5260
        },
        {
          img: 'static/img/goodsList/item-show-8.jpg',
          price: 29.90,
          intro: '慕臣 苹果6s手机壳全包防摔磨砂软保护套男女 适用于iPhone6splus',
          remarks: 6080,
          shopName: '歌乐力手配专营店',
          sale: 3560
        }
      ]
      commit('SET_GOODS_LIST', data)*/
      return new Promise((resolve, reject) => {
        request.get('/index/items').then(response => {
          commit('SET_GOODS_LIST', response.data.data)
          resolve()
        }).catch(error => {
          reject(error)
        })
      })
    },
    loadMarketing({commit}) {
      /*const data = {
        carouselItems: [
          'static/img/nav/1.jpg',
          'static/img/nav/2.jpg',
          'static/img/nav/3.jpg',
          'static/img/nav/4.jpg',
          'static/img/nav/5.jpg'
        ],
        activity: [
          'static/img/nav/nav_showimg1.jpg',
          'static/img/nav/nav_showimg2.jpg'
        ]
      };
      commit('SET_MARKETING', data);*/
      return new Promise((resolve, reject) => {
        request.get('/index/marketing').then(response => {
          commit('SET_MARKETING', response.data)
          resolve()
        }).catch(error => {
          reject(error)
        })
      })
    },
    loadCategoryList({commit}) {
      return new Promise((resolve, reject) => {
        request.get('/index/category').then(response => {
          commit('SET_CATEGORY_LIST', response)
          resolve()
        }).catch(error => {
          reject(error)
        })
      })
    },
    loadIndexContents({commit}) {/*
      /!*const data = [
        {
          title: '个性推荐',
          link: ['电脑馆', '游戏极品', '装机大师', '职场焕新', '女神频道', '虚拟现实', '二合一平板', '电子教育', '万物周刊'],
          detail: [
            {
              bigImg: 'static/img/index/computer/item-computer-1.jpg',
              itemFour: [
                {
                  title: '电脑馆',
                  intro: '笔记本999元限量秒！',
                  img: 'static/img/index/computer/item-computer-2.jpg'
                },
                {
                  title: '外设装备',
                  intro: '1000减618',
                  img: 'static/img/index/computer/item-computer-1-3.jpg'
                },
                {
                  title: '电脑配件',
                  intro: '联合满减最高省618',
                  img: 'static/img/index/computer/item-computer-1-4.jpg'
                },
                {
                  title: '办公生活',
                  intro: '5折神券 精品文具',
                  img: 'static/img/index/computer/item-computer-1-5.jpg'
                }
              ],
              itemContent: [
                'static/img/index/computer/item-computer-1-6.jpg',
                'static/img/index/computer/item-computer-1-7.jpg',
                'static/img/index/computer/item-computer-1-8.jpg'
              ]
            },
            {
              bigImg: 'static/img/index/computer/item-computer-2-1.jpg',
              itemFour: [
                {
                  title: '平板电脑',
                  intro: '爆款平板12期免息',
                  img: 'static/img/index/computer/item-computer-2-2.jpg'
                },
                {
                  title: '智能酷玩',
                  intro: '抢999减666神券',
                  img: 'static/img/index/computer/item-computer-2-3.jpg'
                },
                {
                  title: '娱乐影音',
                  intro: '大牌耳机低至5折',
                  img: 'static/img/index/computer/item-computer-2-4.jpg'
                },
                {
                  title: '摄影摄像',
                  intro: '大牌相机5折抢',
                  img: 'static/img/index/computer/item-computer-2-5.jpg'
                }
              ],
              itemContent: [
                'static/img/index/computer/item-computer-2-6.jpg',
                'static/img/index/computer/item-computer-2-7.jpg',
                'static/img/index/computer/item-computer-2-8.jpg'
              ]
            }
          ]
        },
        {
          title: '热门图书',
          link: ['休闲零食', '坚果', '牛奶', '饮料冲调', '食用油', '大米', '白酒', '红酒', '烧烤食材', '牛排', '樱桃'],
          detail: [
            {
              bigImg: 'static/img/index/eat/item-eat-1-1.jpg',
              itemFour: [
                {
                  title: '粮油调味',
                  intro: '买2免1',
                  img: 'static/img/index/eat/item-eat-1-2.jpg'
                },
                {
                  title: '饮料冲调',
                  intro: '第二件半价',
                  img: 'static/img/index/eat/item-eat-1-3.jpg'
                },
                {
                  title: '休闲零食',
                  intro: '满99减40',
                  img: 'static/img/index/eat/item-eat-1-4.jpg'
                },
                {
                  title: '中外名酒',
                  intro: '满199减100',
                  img: 'static/img/index/eat/item-eat-1-5.jpg'
                }
              ],
              itemContent: [
                'static/img/index/eat/item-eat-1-6.jpg',
                'static/img/index/eat/item-eat-1-7.jpg',
                'static/img/index/eat/item-eat-1-8.jpg'
              ]
            },
            {
              bigImg: 'static/img/index/eat/item-eat-2-1.jpg',
              itemFour: [
                {
                  title: '东家菜',
                  intro: '丰富好味',
                  img: 'static/img/index/eat/item-eat-2-2.jpg'
                },
                {
                  title: '东家菜',
                  intro: '丰富好味',
                  img: 'static/img/index/eat/item-eat-2-2.jpg'
                },
                {
                  title: '东家菜',
                  intro: '丰富好味',
                  img: 'static/img/index/eat/item-eat-2-2.jpg'
                },
                {
                  title: '东家菜',
                  intro: '丰富好味',
                  img: 'static/img/index/eat/item-eat-2-2.jpg'
                }
              ],
              itemContent: [
                'static/img/index/eat/item-eat-2-6.jpg',
                'static/img/index/eat/item-eat-2-7.jpg',
                'static/img/index/eat/item-eat-2-8.jpg'
              ]
            }
          ]
        }
      ]*!/
      const data = [
        {
          title: '推荐',
          items: [
            {
              id: '',
              img: 'static/img/goodsList/item-show-1.jpg',
              price: 36.60,
              intro: 'SKSK 苹果7/7plus手机壳 iPhone 7 Plus保护套全包硬壳男女磨砂防摔 火影红(苹',
              remarks: 6160,
              shopName: '元亨利配件专营店',
              sale: 9900
            },
            {
              id: '',
              img: 'static/img/goodsList/item-show-2.jpg',
              price: 28.00,
              intro: '蒙奇奇 苹果6s手机壳磨砂防摔保护套 适用于iphone6/6s/6sPlus/6plus 6/6s 4.7英',
              remarks: 3000,
              shopName: 'monqiqi旗舰店',
              sale: 9600
            },
            {
              id: '',
              img: 'static/img/goodsList/item-show-3.jpg',
              price: 15.00,
              intro: 'BIAZE 苹果6/6s手机壳 苹果iphone6s 4.7英寸透明手机套 清爽系列',
              remarks: 2800,
              shopName: 'BIAZE官方旗舰店',
              sale: 8900
            },
            {
              img: 'static/img/goodsList/item-show-4.jpg',
              price: 29.90,
              intro: '慕臣 苹果6s手机壳全包防摔磨砂软保护套男女 适用于iPhone6splus',
              remarks: 9000,
              shopName: '歌乐力手配专营店',
              sale: 8600
            },
            {
              img: 'static/img/goodsList/item-show-5.jpg',
              price: 15.00,
              intro: 'BIAZE 苹果6/6s手机壳 苹果iphone6s 4.7英寸透明手机套 清爽系列',
              remarks: 6160,
              shopName: 'BIAZE官方旗舰店',
              sale: 8560
            },
            {
              img: 'static/img/goodsList/item-show-6.jpg',
              price: 28.00,
              intro: '慕臣 苹果6s手机壳全包防摔磨砂软保护套男女 适用于iPhone6splus',
              remarks: 9006,
              shopName: '歌乐力手配专营店',
              sale: 8530
            },
            {
              img: 'static/img/goodsList/item-show-7.jpg',
              price: 15.00,
              intro: 'BIAZE 苹果6/6s手机壳 苹果iphone6s 4.7英寸透明手机套 清爽系列',
              remarks: 8666,
              shopName: 'BIAZE官方旗舰店',
              sale: 8360
            },
            {
              img: 'static/img/goodsList/item-show-8.jpg',
              price: 29.90,
              intro: '慕臣 苹果6s手机壳全包防摔磨砂软保护套男女 适用于iPhone6splus',
              remarks: 6080,
              shopName: '歌乐力手配专营店',
              sale: 7560
            },
            {
              img: 'static/img/goodsList/item-show-1.jpg',
              price: 36.60,
              intro: 'SKSK 苹果7/7plus手机壳 iPhone 7 Plus保护套全包硬壳男女磨砂防摔 火影红(苹',
              remarks: 6160,
              shopName: '元亨利配件专营店',
              sale: 7360
            },
            {
              img: 'static/img/goodsList/item-show-2.jpg',
              price: 28.00,
              intro: '蒙奇奇 苹果6s手机壳磨砂防摔保护套 适用于iphone6/6s/6sPlus/6plus 6/6s 4.7英',
              remarks: 3000,
              shopName: 'monqiqi旗舰店',
              sale: 6960
            },
            {
              img: 'static/img/goodsList/item-show-3.jpg',
              price: 15.00,
              intro: 'BIAZE 苹果6/6s手机壳 苹果iphone6s 4.7英寸透明手机套 清爽系列',
              remarks: 2800,
              shopName: 'BIAZE官方旗舰店',
              sale: 6560
            },
            {
              img: 'static/img/goodsList/item-show-4.jpg',
              price: 29.90,
              intro: '慕臣 苹果6s手机壳全包防摔磨砂软保护套男女 适用于iPhone6splus',
              remarks: 9000,
              shopName: '歌乐力手配专营店',
              sale: 6360
            },
            {
              img: 'static/img/goodsList/item-show-5.jpg',
              price: 15.00,
              intro: 'BIAZE 苹果6/6s手机壳 苹果iphone6s 4.7英寸透明手机套 清爽系列',
              remarks: 6160,
              shopName: 'BIAZE官方旗舰店',
              sale: 5530
            },
            {
              img: 'static/img/goodsList/item-show-6.jpg',
              price: 28.00,
              intro: '慕臣 苹果6s手机壳全包防摔磨砂软保护套男女 适用于iPhone6splus',
              remarks: 9006,
              shopName: '歌乐力手配专营店',
              sale: 5560
            },
            {
              img: 'static/img/goodsList/item-show-7.jpg',
              price: 15.00,
              intro: 'BIAZE 苹果6/6s手机壳 苹果iphone6s 4.7英寸透明手机套 清爽系列',
              remarks: 8666,
              shopName: 'BIAZE官方旗舰店',
              sale: 5260
            },
            {
              img: 'static/img/goodsList/item-show-8.jpg',
              price: 29.90,
              intro: '慕臣 苹果6s手机壳全包防摔磨砂软保护套男女 适用于iPhone6splus',
              remarks: 6080,
              shopName: '歌乐力手配专营店',
              sale: 3560
            }]
        }
      ]
      commit('SET_INDEX_CONTENTS', data)*/
      return new Promise((resolve, reject) => {
        request.get('/index/contents').then(response => {
          commit('SET_INDEX_CONTENTS', response.data)
          console.log(JSON.stringify(response.data))
          resolve()
        }).catch(error => {
          reject(error)
        })
      })
    }
  }
}

export default portal
