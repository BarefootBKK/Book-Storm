<template>
  <div class="contain">
    <p><Icon type="md-checkmark"></Icon></p>
    <router-link to="/login"><Button type="success" size="large" long class="btn-success">注册成功</Button></router-link>
  </div>
</template>

<script>
export default {
  name: 'SignUpDone'
};
</script>

<style scoped>
.contain {
  width: 100%;
  height: 100%;
  text-align: center;
  background-color: #ffffff;
}
.container p {
  margin-top: 20px;
  font-size: 90px;
  color: #2d8cf0;
  text-align: center;
}

.btn-success {
  margin-top: 80px;
  position: relative;
  right: 5%;
}
</style>
