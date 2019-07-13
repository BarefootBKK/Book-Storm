<template>
  <div>
    <div class="add-container">
      <div class="add-title">
        <h1>添加收货地址</h1>
      </div>
      <div class="add-box">
        <Form :model="formData" label-position="left" :label-width="100" :rules="infoRule">
          <FormItem label="收件人" prop="name">
            <i-input v-model="formData.name" size="large"></i-input>
          </FormItem>
          <FormItem label="收件地区" prop="address">
            <Distpicker :province="formData.province" :city="formData.city" :area="formData.area"
                        @province="getProvince" @city="getCity" @area="getArea"></Distpicker>
          </FormItem>
          <FormItem label="收件地址" prop="address">
            <i-input v-model="formData.address" size="large"></i-input>
          </FormItem>
          <FormItem label="手机号码" prop="phone">
            <i-input v-model="formData.phone" size="large"></i-input>
          </FormItem>
          <FormItem label="邮政编码" prop="zipCode">
            <i-input v-model="formData.zipCode" size="large"></i-input>
          </FormItem>
        </Form>
      </div>
      <div class="add-submit">
        <Button type="primary" @click="handleAddAddress">添加地址</Button>
      </div>
    </div>
  </div>
</template>

<script>
  import Distpicker from 'v-distpicker';
  import request from '@/utils/request'

  export default {
    name: 'AddAddress',
    data() {
      return {
        formData: {
          name: '',
          address: '',
          phone: '',
          zipCode: '',
          province: '广东省',
          city: '广州市',
          area: '天河区'
        },
        infoRule: {
          name: [
            {required: true, message: '请输入姓名', trigger: 'blur'}
          ],
          address: [
            {required: true, message: '请输入地址', trigger: 'blur'}
          ],
          zipCode: [
            {required: true, message: '请输入邮政编码', trigger: 'blur'}
          ],
          phone: [
            {required: true, message: '手机号不能为空', trigger: 'blur'},
            {type: 'string', pattern: /^1[3|4|5|7|8][0-9]{9}$/, message: '手机号格式出错', trigger: 'blur'}
          ]
        }
      };
    },
    methods: {
      handleAddAddress() {
        const data = {
          username: this.$store.getters.username,
          userId: this.$store.getters.userInfo.id,
          address: this.formData.address,
          city: this.formData.city,
          district: this.formData.area,
          name: this.formData.name,
          phone: this.formData.phone,
          province: this.formData.province,
          zipCode: this.formData.postalcode
        }
        request.post('/user/address', data).then(response => {
          // TODO:
          this.$store.dispatch('setUserInfo', response.data.data)
          this.$Message.success('添加成功！')
        }).catch(error => {
          this.$Message.error(error)
        })
      },
      getProvince(data) {
        this.formData.province = data.value;
      },
      getCity(data) {
        this.formData.city = data.value;
      },
      getArea(data) {
        this.formData.area = data.value;
      }
    },
    components: {
      Distpicker
    }
  };
</script>

<style scoped>
  .add-container {
    margin: 15px auto;
    width: 60%;
    min-width: 600px;
  }

  .add-title {
    margin-bottom: 15px;
    text-align: center;
  }

  .add-submit {
    display: flex;
    justify-content: center;
  }
</style>
