<template>
  <div class="info-form">
     <Form ref="formValidate" :model="formValidate" :rules="ruleValidate" :label-width="80" >
        <FormItem label="用户名" prop="name">
            <i-input v-model="formValidate.name" clearable size="large" placeholder="请输入你的姓名"></i-input>
        </FormItem>
        <FormItem label="邮箱" prop="mail">
            <i-input v-model="formValidate.mail" clearable size="large" placeholder="请输入你的邮箱"></i-input>
        </FormItem>
        <FormItem label="密码" prop="password">
            <i-input type="password" v-model="formValidate.password" clearable size="large" placeholder="请输入你的密码"></i-input>
        </FormItem>
        <FormItem label="确认密码" prop="repassword">
            <i-input type="password" v-model="formValidate.repassword" clearable size="large" placeholder="请再次输入你的密码"></i-input>
        </FormItem>
        <Button type="info" size="large" long @click="handleSubmit('formValidate')">注册</Button>
    </Form>
  </div>
</template>

<script>
  export default {
    name: 'InputInfo',
    data() {
      const validatePassCheck = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.formValidate.password) {
          callback(new Error('两次输入的密码不一样'));
        } else {
          callback();
        }
      };
      return {
        formValidate: {
          name: '',
          mail: '',
          password: '',
          repassword: ''
        },
        ruleValidate: {
          name: [
            {required: true, message: '用户名不能为空', trigger: 'blur'}
          ],
          mail: [
            {required: true, message: '邮箱不能为空', trigger: 'blur'},
            {type: 'email', message: '邮箱格式错误', trigger: 'blur'}
          ],
          password: [
            {required: true, message: '密码不能为空', trigger: 'blur'},
            {type: 'string', min: 6, message: '密码长度不能小于6', trigger: 'blur'}
          ],
          repassword: [
            {validator: validatePassCheck, trigger: 'blur'}
          ]
        },
        phone:0,
      };
    },
    created() {
    },
    mounted(){
      this.phone = this.$route.query.phone
    },
    methods: {
      handleSubmit(name) {
        const father = this;
        this.$refs[name].validate((valid) => {
          if (valid) {
            const data = {
              username: this.formValidate.name,
              password: this.formValidate.password,
              email: this.formValidate.mail,
              phone: this.phone
            };
            //
            this.$store.dispatch('register', data).then(respose => {
              this.$store.dispatch('setNextSignUpStep', 2);
              this.$router.push({path: '/SignUp/signUpDone'});
            }).catch(error => {
              this.$Message.error(error)
            })
          } else {
            this.$Message.error('注册失败');
          }
        });
      }
    },
  };
</script>

<style scoped>
  .info-form {
    width: 90% !important;
  }
</style>
