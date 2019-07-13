<template>
  <div>
    <Row class="container">
<!--      <i-col span="12" offset="2" class="signup-img-box">
        <img src="static/img/signup-sale.png" alt="">
      </i-col>-->
      <i-col span="8" class="box">
<!--        <div class="sign-up-title">-->
<!--          <h1 align="center" >欢迎注册账号</h1>-->
<!--        </div>-->
        <div class="sign-up-step-box">
<!--          <div class="sign-up-title">-->
<!--            <h1 align="center" >欢迎注册账号</h1>-->
<!--          </div>-->
          <div class="signup-header">
            <p>欢迎注册账号</p>
          </div>
          <br>
          <Steps :current="signUpStep">
            <Step title="验证手机号" icon="iphone"></Step>
            <Step title="填写账号信息" icon="person-add"></Step>
            <Step title="注册成功" icon="ios-checkmark-outline"></Step>
          </Steps>
          <div class="sign-up-box">
            <transition mode="out-in">
              <router-view></router-view>
            </transition>
          </div>
        </div>
      </i-col>
    </Row>
  </div>
</template>

<script>
  export default {
    name: 'SignUp',
    data() {
      return {
        index: 0
      };
    },
    computed: {
      signUpStep() {
        return this.$store.getters.signUpStep
      }
    },
    mounted() {
      this.$store.dispatch('setNextSignUpStep', 0)
    },
    methods: {},
  };
</script>

<style scoped>


  .container {
/*    margin: 15px auto;*/
    height: 500px;
/*    overflow: hidden;*/
/*    background: #fff;*/
    background-image: url("/static/img/signupbg.png");
    background-size: cover;
    background-position-y: 50%;
  }

/*  .signup-img-box {
    height: 100%;
    display: flex;
    align-items: center;
    justify-content: center;;
  }*/

/*  .signup-img-box > img {
    height: 80%;
  }*/



  .sign-up-step-box {
    margin: 20px auto;
    width: 400px;
    height: 440px;
    border: 2px solid #2db7f5;
    background-color: #ffffff;
    position: relative;
    left: 200%;
  }

  .sign-up-title {
    width: 430px;
    /*margin: 15px auto;*/
    height: 80px;
    position: relative;
    right: 8%;
  }

  .signup-header {
    height: 50px;
    font-size: 20px;
    text-align: center;
    line-height: 50px;
    letter-spacing: 5px;
    color: #fff;
    background-color:#2db7f5;
  }

  .sign-up-box {
    margin: 40px auto;
    position: relative;
    left: 5%;
    width: 350px;
    display: flex;
    align-items: center;
  }
</style>
