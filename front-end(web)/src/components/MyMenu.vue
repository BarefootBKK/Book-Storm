<template>
  <div ref="menu" class="menu trans_500" :class="{active: menuActive}">
    <div class="menu_content d-flex flex-column align-items-center justify-content-center text-center">
      <div ref="menuCloser" @click="menuCloseHandle" class="menu_close_container">
        <div class="menu_close"></div>
      </div>
      <div class="logo menu_logo">
        <a href="#">
          <div class="logo_container d-flex flex-row align-items-start justify-content-start">
            <div class="logo_image">
              <div><img src="../assets/logo.png" alt=""></div>
            </div>
            <div class="logo_content">
              <div class="logo_text logo_text_not_ie">The Conference</div>
              <div class="logo_sub">August 25, 2018 - Miami Marina Bay</div>
            </div>
          </div>
        </a>
      </div>
      <ul>
        <li class="menu_item"><a href="index.html">Home</a></li>
        <li class="menu_item"><a href="#">About us</a></li>
        <li class="menu_item"><a href="#">Speakers</a></li>
        <li class="menu_item"><a href="#">Tickets</a></li>
        <li class="menu_item"><a href="news.html">News</a></li>
        <li class="menu_item"><a href="contact.html">Contact</a></li>
      </ul>
    </div>
  </div>
</template>

<script>
  export default {
    name: "Menu",
    props: {
      propActive: {
        type: Boolean,
        default: false
      },
    },
    data() {
      return {}
    },
    computed: {
      // 改变 menu 显示状态，是通过设置其css class 属性 active 值来显示/关闭 menu，此处监听全局 menu 状态
      menuActive() {
        return this.$store.getters.menuActive
      }

    },
    mounted() {
    },
    methods: {
      menuCloseHandle() {
        if (!this.menuActive) {
          this.$store.dispatch('setMenuStatus', true)
        } else {
          this.$store.dispatch('setMenuStatus', false)
        }
      }
    },
    watch: {
      propActive: function (val) {
        this.menuActive = val
      }
    }
  }
</script>

<style scoped>

</style>
