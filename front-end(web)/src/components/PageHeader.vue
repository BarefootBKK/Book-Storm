<template>
  <div>
    <header ref="header" :class="classScrolled" class="header" id="header">
      <div>
        <div class="header_top">
          <div class="container">
            <div class="row">
              <div class="col">
                <div class="header_top_content d-flex flex-row align-items-center justify-content-start">
                  <div>
                    <a href="#">
                      <div class="logo_container d-flex flex-row align-items-start justify-content-start">
                        <div class="logo_image">
                          <div><img src="../assets/logo.png" alt=""></div>
                        </div>
                        <div class="logo_content">
                          <div id="logo_text" class="logo_text logo_text_not_ie">The Conference</div>
                          <div class="logo_sub">August 25, 2018 - Miami Marina Bay</div>
                        </div>
                      </div>
                    </a>
                  </div>
                  <div class="header_social ml-auto">
                    <ul>
                      <li><a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a></li>
                      <li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
                      <li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
                      <li><a href="#"><i class="fa fa-dribbble" aria-hidden="true"></i></a></li>
                      <li><a href="#"><i class="fa fa-behance" aria-hidden="true"></i></a></li>
                      <li><a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a></li>
                    </ul>
                  </div>
                  <div ref="hamburger" @click="hamburgerHandle" class="hamburger ml-auto"><i class="fa fa-bars"
                                                                                             aria-hidden="true"></i>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="header_nav" id="header_nav_pin">
          <div class="header_nav_inner">
            <div class="header_nav_container">
              <div class="container">
                <div class="row">
                  <div class="col">
                    <div class="header_nav_content d-flex flex-row align-items-center justify-content-start">
                      <nav class="main_nav">
                        <ul>
                          <router-link v-for="item in pathTable" tag="li" :to="item.path" :key="item.id">
                            <a>{{item.name}}</a>
                          </router-link>
                        </ul>
                      </nav>
                      <div class="header_extra ml-auto">
                        <div ref="search" class="header_search" @click="searchClickHandle"><i class="fa fa-search"
                                                                                              aria-hidden="true"></i>
                        </div>
                        <div class="button header_button"><a href="#">Buy Tickets Now!</a></div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div ref="searchPanel" class="search_container" :class="{active: searchPanelActive}">
              <div class="container">
                <div class="row">
                  <div class="col">
                    <div class="search_content d-flex flex-row align-items-center justify-content-end">
                      <form action="#" id="search_container_form" class="search_container_form">
                        <input type="text" class="search_container_input" placeholder="Search" required="required">
                        <button class="search_container_button"><i class="fa fa-search" aria-hidden="true"></i>
                        </button>
                      </form>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </header>
    <my-menu></my-menu>
  </div>
</template>

<script>
  import MyMenu from './MyMenu'

  export default {
    name: "Header",
    data() {
      return {
        searchPanelActive: false,
        classScrolled: '',
        pathTable: [
          {id: 0, path: '/home', name: 'Home'},
          {id: 1, path: '#', name: 'About Us'},
          {id: 2, path: '/speaker', name: 'Speaker'},
          {id: 3, path: '/events', name: 'Events'},
          {id: 4, path: '/news', name: 'News'},
          {id: 5, path: '/contact', name: 'Contact'},
        ]
      }
    },
    computed: {
      menuActive() {
        return this.$store.getters.menuActive
      }
    },
    mounted() {
      window.addEventListener('scroll', this.setHeader)
      window.addEventListener('resize', this.setHeader)
    },
    methods: {
      // header：包括 顶部导航栏和顶部标题栏
      // setHeader：通过监听滚动事件，向下滚动时 顶部导航栏贴在顶部，而header-top 隐藏
      setHeader() {
        const top = document.body.scrollTop || document.documentElement.scrollTop || window.pageXOffset;
        if (top > 127) {
          this.classScrolled = 'scrolled'
        } else {
          this.classScrolled = ''
        }
      },
      searchClickHandle() {
        this.searchPanelActive = !this.searchPanelActive
      },
      hamburgerHandle() {
        // 如果 menu 为隐藏状态（not active），通过设置其 active 状态为 true 打开 menu, 打开 menu 的操作在 MyMenu.vue
        if (!this.menuActive) {
          this.$store.dispatch('setMenuStatus', true)
        } else {
          this.$store.dispatch('setMenuStatus', false)
        }
      },

    },
    components: {
      MyMenu,
    }
  }
</script>

<style scoped>

</style>
