<template>
  <div>
    <Card style="padding-right: 40%">
      <p slot="title">修改个人资料</p>
      <Form ref="infoForm" :model="infoForm" label-position="left" :label-width="100" :rules="infoRules">
        <FormItem label="昵称" prop="nickName">
          <Input v-model="infoForm.nickName"></Input>
        </FormItem>
        <FormItem label="真实姓名" prop="realName">
          <Input v-model="infoForm.realName"></Input>
        </FormItem>
        <FormItem label="手机号码" prop="phone">
          <Input v-model="infoForm.phone"></Input>
        </FormItem>
        <FormItem label="邮箱" prop="email">
          <Input v-model="infoForm.email"></Input>
        </FormItem>
        <FormItem>
          <Button type="primary" @click.native.prevent="handleUpdateUserInfo">保存</Button>
        </FormItem>
      </Form>
    </Card>
    <Card style="padding-right: 40%">
      <p slot="title">修改密码</p>
      <Form ref="passwordForm" :model="passwordForm" label-position="left" :label-width="100" :rules="pwdRules">
        <FormItem label="密码" prop="password">
          <i-input type="password" v-model="passwordForm.password" clearable size="large"
                   placeholder="请输入你的密码"></i-input>
        </FormItem>
        <FormItem label="确认密码" prop="repassword">
          <i-input type="password" v-model="passwordForm.repassword" clearable size="large"
                   placeholder="请再次输入你的密码"></i-input>
        </FormItem>
        <FormItem>
          <Button type="primary" @click.native.prevent="handleUpdatePassword">提交</Button>
        </FormItem>
      </Form>
    </Card>
  </div>
</template>

<script>
  import request from '@/utils/request'

  export default {
    name: "UserInfo",
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
        infoRules: {
          nickName: [{required: true, message: '昵称不能为空', trigger: 'blur'}],
          phone: [
            {required: true, message: '手机号不能为空', trigger: 'blur'},
            {type: 'string', pattern: /^1[3|4|5|7|8][0-9]{9}$/, message: '手机号格式出错', trigger: 'blur'}
          ],
          realName: [{required: true, message: '真实姓名不能为空', trigger: 'blur'}],
          email: [
            {required: true, message: '邮箱不能为空', trigger: 'blur'},
            {type: 'email', message: '邮箱格式错误', trigger: 'blur'}
          ],
          gender: [{required: true, message: '昵称不能为空', trigger: 'blur'}],
        },
        infoForm: {
          nickName: '',
          phone: '',
          realName: '',
          email: '',
          gender: '',
        },
        passwordForm: {
          password: '',
          repassword: ''
        },
        pwdRules: {
          password: [
            {required: true, message: '密码不能为空', trigger: 'blur'},
            {type: 'string', min: 6, message: '密码长度不能小于6', trigger: 'blur'}
          ],
          repassword: [
            {validator: validatePassCheck, trigger: 'blur'}
          ]
        }
      }
    },
    created() {
      this.infoForm.nickName = this.$store.getters.userInfo.nickName
      this.infoForm.phone = this.$store.getters.userInfo.phone
      this.infoForm.realName = this.$store.getters.userInfo.realName
      this.infoForm.email = this.$store.getters.userInfo.email
      this.infoForm.gender = this.$store.getters.userInfo.gender
    },
    methods: {
      handleUpdateUserInfo() {
        const userInfo = this.$store.getters.userInfo.id
        request.post(
          {
            url: `/info/${userInfo}`,
            data: this.infoForm
          }
        ).then(response => {
          this.$store.dispatch('setUserInfo', response.data.data)
        }).catch(error => {
          this.$Message.error({
            content: `更新失败：${error}`
          })
        })
      }
    }
  }
</script>

<style lang="scss" scoped>

  div.ivu-card-body {
    form {
      width: 20rem;
    }
  }
</style>
