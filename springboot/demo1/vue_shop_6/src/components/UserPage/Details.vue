<template>
  <div class="common-layout">
    <link href="../../assets/icons/font_2cf2621a7by/iconfont.css"> 
    <el-container class="std_container">
      <el-container>
        <!--侧边导航栏-->
        <el-aside width="500px">
          <el-col :span="15" :offset="4">
            <div class="side-top-block"></div>
            <el-affix :offset="80">
              <el-menu
                class="side-menu"
                default-active="2"
                @open="handleOpen"
                @close="handleClose"
              >
                <el-menu-item index="1" @click="goOverView">
                  <div class="menu-tag"></div>
                  <i class="iconfont icon-yonghu_user menu-icon"></i>
                  <span class="side-menu-item-text">账号概览</span>
                </el-menu-item>
                <el-menu-item index="2" @click="goDetails" class="selected-menu-item">
                  <div class="menu-tag selected-menu-tag "></div>
                  <i class="iconfont icon-yinliu_drainage menu-icon"></i>
                  <span class="side-menu-item-text">账号详情</span>
                </el-menu-item>
                <el-menu-item index="3" @click="goSecurity">
                  <div class="menu-tag"></div>
                  <i class="iconfont icon-anquan_security menu-icon"></i>
                  <span class="side-menu-item-text">安全</span>
                </el-menu-item>
                <el-menu-item index="4" @click="goPayWay">
                  <div class="menu-tag"></div>
                  <i class="iconfont icon-huobi_currency menu-icon"></i>
                  <span class="side-menu-item-text">付款方式</span>
                </el-menu-item>
                <el-menu-item index="5" @click="goShopCart">
                  <div class="menu-tag"></div>
                  <i class="iconfont icon-a-gouwuche_shoppingcart menu-icon"></i>
                  <span class="side-menu-item-text">购物车</span>
                </el-menu-item>
                <el-menu-item index="6" @click="goHistory">
                  <div class="menu-tag"></div>
                  <i class="iconfont icon-qianbao_wallet menu-icon"></i>
                  <span class="side-menu-item-text">历史订单</span>
                </el-menu-item>
              </el-menu>
            </el-affix>
          </el-col>
        </el-aside>

        <!-- 主体 -->
        <el-main>
          <el-row class="main-head-row">
            <el-col>
              账号详情
            </el-col>
          </el-row>
          <div class="inputForm">
            <div class="inputBox">
              <input type="text" required v-model="customerDetails.customerName">
              <span>昵称</span>
            </div>
            <div class="inputBox">
              <input type="text" required v-model="customerDetails.email">
              <span>电子邮箱</span>
            </div>
            <div class="inputBox">
              <input type="text" required v-model="customerDetails.birthday">
              <span>出生日期</span>
            </div>
            <div class="inputBox">
              <input type="text" required v-model="customerDetails.address">
              <span>住址</span>
            </div>

            <div class="inputBox">
              <input type="password"
                     disabled="disabled"
                     required
              >
              <span>密码</span>

              <el-button text @click="dialogVisible = true"
              >修改密码</el-button
              >
              <el-dialog
                  v-model="dialogVisible"
                  class="changePwdBox"
                  width="600px"
                  title="修改密码"
                  :before-close="handlePwdChangeClose"
              >
                <div>
                  <el-form
                      :model="registerForm"
                      :rules="registerFormRule"
                      ref="registerFormRef"
                      label-width="0px"
                      class="register_form">
                    <!--用户名 </el-input>-->
                    <el-form-item prop="origin_password">
                      <el-input
                          v-model="registerForm.origin_password"
                          placeholder="Origin Password"
                          id="customerName"
                      ></el-input>
                      <!--注意icon图标的引用格式-->
                    </el-form-item>
                    <!--密码-->
                    <el-form-item prop="password">
                      <el-input v-model="registerForm.password" placeholder="New Password"
                                type="password" id="loginPwd"></el-input>
                    </el-form-item>
                    <el-form-item prop="password_again">
                      <el-input v-model="registerForm.password_again" placeholder="New Password Again"
                                type="password"></el-input>
                    </el-form-item>
                  </el-form>
                </div>
                <div class="closeChangePwdBox">
                  <el-button @click="changePwd" enable>确定</el-button>
                </div>
              </el-dialog>

            </div>
            <div class="inputBox">
              <input type="text" required v-model="customerDetails.phone">
              <span>电话</span>
            </div>
            <div class="deleteBox">
              <span>删除账户</span>
              <el-button class="deleteBot" round>删除</el-button>
            </div>
            <div class="saveBox">
              <span>保存编辑</span>
              <el-button
                  class="saveBot"
                  type="info"
                  round
                  @click="save_customerInfor"
              >保存</el-button>
            </div>
          </div>
        </el-main>
      </el-container>
      <el-footer>
        Powered By Vue3.0
      </el-footer>
    </el-container>
  </div>

</template>

<script lang="ts" setup>
  import {
    ArrowDown,
    Check,
    CircleCheck,
    CirclePlus,
    CirclePlusFilled,
    Plus,
  } from '@element-plus/icons-vue'
  import { useRouter } from 'vue-router';
  import {reactive, ref } from 'vue';
  import { goMShopPage } from  './router_pages';
  import {ElMessageBox, ElNotification, FormInstance} from 'element-plus'
  import axios from "axios";
  import qs from 'qs';

  let customerInfor = JSON.parse(localStorage.getItem("customerInfor")); // 可以忽略，人为保证不为null
  console.log(customerInfor);

  const customerDetails = reactive({
    'customerName': customerInfor.customerName,
    'email': customerInfor.email,
    'birthday': customerInfor.birthday,
    'address': customerInfor.address,
    'phone': customerInfor.phone,
  })

  // 检查token
  let haveToken = false;
  if (localStorage.getItem("token") != null) {
    haveToken = true;
  }

  // 修改密码服务
  // 修改密码的弹出框
  const dialogVisible = ref(false)
  const handlePwdChangeClose = (done: () => void) => {
    ElMessageBox.confirm('放弃修改密码？')
        .then(() => {
          done()
        })
        .catch(() => {
          // catch error
        })
  }
  // 这是表单的数据绑定对象
  const registerForm = reactive({
    origin_password: '',
    password: '',
    password_again: '',
  })
  // 这是表单的验证规则对象
  const registerFormRef = ref<FormInstance>()
  const validatePass1 = (rule: any, value: string, callback: any) => {
    if (value === '') {
      callback(new Error('请输入密码'))
    } else if (value.length < 6 || value.length > 20){
      callback(new Error('长度在 6 到 20 个字符之间'))
    } else{
      if (registerForm.password_again !== '') {
        if (!registerFormRef.value) return
        registerFormRef.value.validateField('password_again', () => null)
      }
      callback()
    }
  }
  const validatePass2 = (rule: any, value: string, callback: any) => {
    if (value === '') {
      callback(new Error('请再次输入密码'))
    } else if (value.length < 6 || value.length > 20) {
      callback(new Error('长度在 6 到 20 个字符之间'))
    } else if (value !== registerForm.password) {
      callback(new Error("两次输入密码不一致"))
    } else {
      callback()
    }
  }
  const registerFormRule = reactive({
    // 验证密码
    password: [
      { validator: validatePass1, trigger: 'blur'}
    ],
    // 再次验证密码
    password_again: [
      { validator: validatePass2, trigger: 'blur'}
    ]
  })
  function changePwd() {
    if (!registerFormRef.value) return
    registerFormRef.value.validate(
      (valid: boolean) => {
        let check_password_data = {
          "customerId": localStorage.getItem("customerId"),
          "loginPwd": registerForm.origin_password,
        }
        console.log(check_password_data);
        axios.post('http://localhost:9090/customer/checkPwd',
          qs.stringify(check_password_data)).then(res_check_password=>{

          if (res_check_password.data) {
            console.log("原密码正确");
            axios.post('http://localhost:9090/customer/modifyPwd',
              qs.stringify(check_password_data)).then(res_change_pwd=>{

                if (res_change_pwd.data) {
                  dialogVisible.value = false;
                  console.log("修改密码成功");
                  ElMessageBox.alert('修改密码成功', 'SUCCESS');
                } else {
                  console.log("修改密码失败");
                  ElMessageBox.alert('修改密码失败', 'ERROR');
                }
            })
          } else {
            console.log("原密码错误");
            ElMessageBox.alert('原密码不正确', 'ERROR');
          }
        })
      }
    );
  }

  // 保存修改的信息
  function save_customerInfor() {
    let save_data = {
      "customerId": localStorage.getItem("customerId"),
      "customerName": customerDetails.customerName,
      "phone": customerDetails.phone,
      "email": customerDetails.email,
      "address": customerInfor.address,
      "birthday": customerDetails.birthday,
    }
    axios.post('http://localhost:9090/customer/modifyInfo', save_data).then(res=>{
      console.log(save_data)
      console.log(customerInfor)
      console.log("修改信息成功: ", res.data);
      if (res.data) {
        let uId = {
          'customerId': localStorage.getItem("customerId"),
        }
        axios.post("http://localhost:9090/customer/info", qs.stringify(uId)).then(res=>{
          //console.log(res.data);
          localStorage.setItem('customerInfor', JSON.stringify(res.data));
        })
        ElNotification({
          title: '成功',
          message: '修改个人信息成功',
          duration: 1500,
        })
      }
    })
  }

	const router = useRouter()
  function goOverView() {
    router.push({
			path: '/userPage'
		})
  }
  function goSecurity() {
    router.push({
			path: '/userPage/security'
		})
  }
  function goDetails() {
    router.push({
			path: '/userPage/details'
		})
  }
  function goPayWay() {
    router.push({
			path: '/userPage/payway'
		})
  }
  function goShopCart() {
    router.push({
			path: '/userPage/shopcart'
		})
  }
  function goHistory() {
    router.push({
			path: '/userPage/history'
		})
  }

  const handleOpen = (key: string, keyPath: string[]) => {
    console.log(key, keyPath)
  }
  const handleClose = (key: string, keyPath: string[]) => {
    console.log(key, keyPath)
  }

  // 模糊特效
  const isActive = ref(false)
  function blurThePage(){
		isActive.value = !isActive.value;
    console.log(isActive.value)
	}
</script>
  
<style lang="less" scoped>
// 最外部element plus框架 ******************************************
.common-layout {
  height: 100%;
}
.std_container {
  height: 1500px;
  //background: url('../../assets/pictures/background1.jpg');
  //background-image: linear-gradient(to bottom right, #3d50fc, #7AFFAF);
  background-color: #fff;
  background-position: center;
  background-repeat: repeat;
}

// 主体
.el-main {
  height: 100%;
  margin: 0;
  padding: 0;
}
.main-head-row {
  margin-top: 80px;
  margin-bottom: 50px;
  .el-col {
    color: rgb(0, 0, 0);
    font-size: 30px;
  }
}

.inputForm {
  display: flex;
  justify-content: left;
  align-items: flex-start;
  min-height: 100vh;
  flex-direction: column;
  gap: 30px;
  //background-color: rgb(57, 110, 184);
  .inputBox {
    position: relative;
    width: 350px;
    input {
      width: 100%;
      padding: 15px;
      border: 1px solid rgb(0, 0, 0);
      //background: rgb(57, 110, 184);
      border-radius: 5px;
      outline: none;
      color: rgb(0, 0, 0);
      font-size: 1em;
    }
    span {
      position: absolute;
      left: 0;
      top: 0;
      padding: 15px;
      pointer-events: none;
      font-size: 1em;
      color: rgba(73, 73, 73, 0.25);
      text-transform: uppercase;
      transition: 0.5s;
    }
  }
  .inputBox input:valid ~ span,
  .inputBox input:focus ~ span
  {
    color: rgb(37, 111, 250);
    transform: translateX(10px) translateY(-7px);
    font-size: 0.65em;
    padding: 0 15px;
    //background-color: rgb(57, 110, 184);
    background-color: rgb(255, 255, 255);
    border-left: 1px solid rgb(37, 111, 250);
    border-right: 1px solid rgb(37, 111, 250);
  }
  .deleteBox {
    width: 350px;
    padding: 15px;
    border-top: 1px solid rgb(0, 0, 0);
    border-bottom: 1px solid rgb(0, 0, 0);
    .deleteBot {
      position: relative;
      left: 225px;
    }
  }
  .saveBox {
    width: 350px;
    padding: 15px;
    .saveBot {
      position: relative;
      left: 225px;
    }
  }
}

.changePwdBox {
  width: 30px;
  .closeChangePwdBox {
    margin-top: 150px;
    margin-left: 500px;
    width: 100px;
  }
}
.register_form{
  position: absolute;
  right: 0;
  bottom: 20%;
  width: 100%;
  padding: 0 20px;
  box-sizing: border-box;
  // 默认的box-sizing: content-box(边框和内边距宽度会增加到内容区的宽度上)
  .el-form-item {
    margin: 25px 80px;
  }
}


// 侧边导航栏
.side-top-block {
  height: 80px;
}
.side-menu {
  background-color: rgba(113, 118, 131, 0.9);
}
.side-menu-item-text {
  font-size: 18px;
  color: rgb(0, 0, 0);
  margin-left: 20px;
}
.el-menu-item {
  background-color: rgba(226, 227, 231, 0.9);
}
.el-menu-item:hover {
  background-color: rgba(87, 119, 199, 0.9);
}
.selected-menu-item {
  background-color: rgba(52, 79, 142, 0.9);
}
.menu-tag {
  height: 100%;
  width: 10px;
}
.selected-menu-tag {
  background-color: rgb(37, 111, 250);
}
.menu-icon {
  margin-left: 10px;
}
// 页脚
.el-footer {
  background-color: rgb(0, 0, 0);
  text-align: center;
  color: rgb(216, 212, 212);
}

// 模糊特效
.blured {
  filter: blur(2px);
}
</style>