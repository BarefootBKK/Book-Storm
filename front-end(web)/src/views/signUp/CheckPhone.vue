<template>
  <div class="info-form">
    <Form ref="formValidate" :model="formValidate" :label-width="80" :rules="ruleValidate">
      <br>
      <FormItem label="手机号" prop="phone" >
          <i-input v-model="formValidate.phone" clearable size="large"  placeholder="请输入手机号" icon="ios-phone-portrait"></i-input>
      </FormItem>
      <br>
      <FormItem label="验证码" prop="checkNum">
          <i-input v-model="formValidate.checkNum" size="large"  placeholder="请输入验证码">
            <Button slot="append" @click="getcheckNum">获取验证码</Button>
          </i-input>
      </FormItem>
      <br><br>
      <Button type="info" size="large" long @click="handleSubmit('formValidate')" >验证手机号</Button>
    </Form>
  </div>
</template>

<script>
import store from '@/vuex/store';
export default {
  name: 'CheckPhone',
  data () {
    return {
      formValidate: {
        phone: '',
        checkNum: ''
      },
      ruleValidate: {
        phone: [
          { required: true, message: '手机号不能为空', trigger: 'blur' },
          { type: 'string', pattern: /^1[3|4|5|7|8][0-9]{9}$/, message: '手机号格式出错', trigger: 'blur' }
        ],
        checkNum: [
          { required: true, message: '必须填写验证码', trigger: 'blur' },
          { type: 'string', min: 4, max: 4, message: '验证码长度错误', trigger: 'blur' }
        ]
      }
    };
  },
  methods: {
    getcheckNum () {
      if (this.formValidate.phone.length === 11) {
        this.$Message.success({
          content: '验证码为: 1234',
          duration: 6,
          closable: true
        });
      } else {
        this.$Message.error({
          content: '请输入正确的手机号',
          duration: 6,
          closable: true
        });
      }
    },
    handleSubmit (name) { // 提交验证
      const that = this
      this.$refs[name].validate((valid) => {
        if (valid) {
          that.$store.dispatch('setNextSignUpStep', 1)
          that.$router.push({ path: '/SignUp/inputInfo', query: { phone: this.formValidate.phone } });
        } else {
          that.$Message.error({
            content: '请填写正确的信息',
            duration: 6,
            closable: true
          });
        }
      });
    }
  },
  store
};
</script>

<style scoped>
.info-form {
  width: 90% !important;
}
</style>
