<template>
  <!-- 登录页面 -->
  <div>
    <Row class="container">
<!--      <i-col span="13" offset="2" class="login-img-box">
        <img src="static/img/sale.jpg" alt="">
      </i-col>-->
        <i-col span="7" class="login-box" >
        <div class="login-container">
          <div class="login-header">
            <p>欢迎登录</p>
          </div>
          <div class="form-box">
            <Form ref="loginForm" :model="loginForm" :rules="loginRule">
              <FormItem prop="username">
                <i-input type="text" v-model="loginForm.username" clearable size="large" placeholder="用户名" icon="md-person">
                  <Icon type="person" slot="prepend"></Icon>
                </i-input>
              </FormItem>
              <FormItem prop="password">
                <i-input type="password" v-model="loginForm.password" clearable size="large" placeholder="密码" icon="md-key">
                  <Icon type="ios-locked-outline" slot="prepend"></Icon>
                </i-input>
              </FormItem>
              <br>
              <FormItem>
                <Button type="info" shape="circle" size="large" @click.native.prevent="handleSubmit('formInline')" long >登 录</Button>
              </FormItem>
            </Form>
          </div>
          <div class="login-link">
            <Button type="info" shape="circle" size="small" to="SignUp" ghost>注 册</Button>
          </div>
        </div>
      </i-col>
    </Row>
  </div>
</template>

<script>
  import {usernameRule, passwordRule} from "@/utils/validator";

  export default {
    name: 'Login',
    data() {
      return {
        loginForm: {
          username: '',
          password: ''
        },
        loginRule: {
          username: [
            {required: true, validator: usernameRule, trigger: 'blur'}
          ],
          password: [
            {required: true, validator: passwordRule, trigger: 'blur'},
          ]
        }
      };
    },
    methods: {
      handleSubmit(name) {
        console.log(this.loginForm.username);
        this.$refs.loginForm.validate((valid) => {
          if (valid) {
            this.$store.dispatch('login', this.loginForm).then(result => {
              if (result.code === 200) {
                this.$Message.success('登录成功');
                this.$router.push('/');
              } else {
                this.$Message.error('用户名或密码错误');
              }
            });
          } else {
            this.$Message.error('请填写正确的用户名或密码');
          }
        });
      }
    },
  };
</script>

<style lang="scss" scoped>
  @import "../style/index";

  .container {
/*    margin-top: 30px;*/
    height: 485px;
    background-color: #fff;
    background-image: url("/static/img/loginbg.png");
    background-size: cover;
    background-position-y: 50%;
  }

/*  .login-img-box {
    height: 485px;
    overflow: hidden;
    display: flex;
    align-items: center;
    justify-content: center;
  }*/

/*  .login-img-box > img {
    width: 68%;
  }*/

  .login-box {
    height: 485px;
    display: flex;
    align-items: center;
    justify-content: center;
    position: relative;
    left: 70%;
  }

  .login-container {
    width: 80%;
    border: #3CA9C4 solid 2px;
    background: #ffffff;
  }

  .login-header {
    height: 50px;
    font-size: 20px;
    text-align: center;
    line-height: 50px;
    letter-spacing: 5px;
    color: #fff;
    background-color:#3CA9C4;
  }

  .form-box {
    width: 80%;
    margin: 30px auto;
  }

  .login-link {
    margin-top: 16px;
    margin-bottom: 8px;
    margin-right: 16px;
    text-align: end;

    a {
      margin-right: 8px;
      color: $color-font-link;

      &:hover {
        color: $color-primary;
      }
    }
  }
</style>
