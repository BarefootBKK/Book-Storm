<template>

</template>

<script>
  import request from '@/utils/request'
  export default {
    name: "Logout",
    created() {
      this.$store.dispatch('logout').then(() => {
        this.$store.dispatch('logout')
        this.$Message.success({
          content: '退出登录成功',
          duration: 8
        })
        this.$router.push('/')
      }).catch(error => {
        this.$Message.error({
          content: `退出登录失败: ${error}`,
          duration: 8
        })
      })

      /*request({url: '/user/logout', method: 'get'}).then(() => {
        this.$store.dispatch('logout')
        this.$Message.success({
          content: '退出登录成功',
          duration: 8
        })
        this.$router.push('/')
      }).catch(error => {
        this.$Message.error({
          content: `退出登录失败: ${error}`,
          duration: 8
        })
      })*/
    }
  }
</script>

<style scoped>

</style>
