<template>
  <div>
    <div class="address-box" v-for="(item, index) in address" :key="index">
      <div class="address-header">
        <span>{{item.name}}</span>
        <div class="address-action">
          <span @click="edit(index)"><Icon type="edit"></Icon> 修改</span>
          <span @click="del(item.id)"><Icon type="trash-a"></Icon> 删除</span>
        </div>
      </div>
      <div class="address-content">
        <p><span class="address-content-title"> 收 货 人 :</span> {{item.name}}</p>
        <p><span class="address-content-title">联系电话:</span> {{item.phone}}</p>
        <p><span class="address-content-title">收货地区:</span> {{item.province}} {{item.city}} {{item.district}}</p>
        <p><span class="address-content-title">收货地址:</span> {{item.address}}</p>
        <!--<p><span class="address-content-title">邮政编码:</span> {{item.zipCode}}</p>-->
      </div>
    </div>
    <Modal v-model="modal" width="530">
      <p slot="header">
        <Icon type="edit"></Icon>
        <span>修改地址</span>
      </p>
      <div>
        <Form :model="formData" label-position="left" :label-width="100" :rules="infoRule">
          <FormItem label="收件人" prop="name">
            <i-input v-model="formData.name" size="large"></i-input>
          </FormItem>
          <FormItem label="收件地区" prop="address">
            <Distpicker :province="formData.province" :city="formData.city" :area="formData.district"
                        @province="getProvince" @city="getCity" @area="getDistrict"></Distpicker>
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
      <div slot="footer">
        <Button type="primary" size="large" long @click="editAction">修改</Button>
      </div>
    </Modal>
  </div>
</template>

<script>
  import Distpicker from 'v-distpicker';
  import request from '@/utils/request'

  export default {
    name: 'MyAddress',
    data() {
      return {
        modal: false,
        formData: {
          name: '',
          address: '',
          phone: '',
          zipCode: '',
          province: '广东省',
          city: '广州市',
          district: '天河区'
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
    computed: {
      address() {
        return this.$store.getters.address
      }
    },
    created() {
    },
    methods: {
      edit(index) {
        this.modal = true;
        this.formData.province = this.address[index].province;
        this.formData.city = this.address[index].city;
        this.formData.district = this.address[index].district;
        this.formData.address = this.address[index].address;
        this.formData.name = this.address[index].name;
        this.formData.phone = this.address[index].phone;
        this.formData.zipCode = this.address[index].zipCode;

        this.formData.id = this.address[index].id;
      },
      editAction() {
        this.formData.userId = this.$store.getters.userInfo.id
        request.put('/user/address', this.formData).then(response => {
          this.$store.dispatch('setUserInfo', response.data.data)
          this.$Message.success('更新成功！')
          this.modal = false;
        }).catch(error => {
          this.$Message.error(error)
          this.modal = false;
        })
      },
      del(index) {
        this.$Modal.confirm({
          title: '信息提醒',
          content: '你确定删除这个收货地址',
          onOk: () => {
            request.delete(`/user/address?userId=${this.$store.getters.userInfo.id}&&addressId=${index}`).then(response => {
              this.$store.dispatch('setUserInfo', response.data.data)
              this.$Message.success('删除成功');
            }).catch(error => {
              this.$Message.error(error)
            })
          },
          onCancel: () => {
            this.$Message.info('取消删除');
          }
        });
      },
      getProvince(data) {
        this.formData.province = data.value;
      },
      getCity(data) {
        this.formData.city = data.value;
      },
      getDistrict(data) {
        this.formData.district = data.value;
      }
    },
    components: {
      Distpicker
    }
  };
</script>

<style scoped>
  .address-box {
    padding: 15px;
    margin: 15px;
    border-radius: 5px;
    box-shadow: 0px 0px 5px #ccc;
  }

  .address-header {
    height: 35px;
    display: flex;
    justify-content: space-between;
    color: #232323;
    font-size: 18px;
  }

  .address-content {
    font-size: 14px;
  }

  .address-content-title {
    color: #999;
  }

  .address-action span {
    margin-left: 15px;
    font-size: 14px;
    color: #2d8cf0;
    cursor: pointer;
  }
</style>
