<template>
  <div class="common-layout">
    <link href="../../assets/icons/font_2cf2621a7by/iconfont.css"> 
    <el-container class="std_container">
      <el-header>
        <el-row type="flex" align="middle">
          <el-col :span="3" class="logo_box">
            <img src="../../assets/computer_logo.png" alt="" class="logo"  @click="goHome">
          </el-col>
          <el-col :span="2" :offset="1" class="header_bottons">
            最新热卖
          </el-col>
          <el-col :span="2" :offset="1" class="header_bottons">
            轻薄本
          </el-col>
          <el-col :span="2" :offset="1" class="header_bottons">
            游戏本
          </el-col>
          <el-col :span="2" :offset="1" class="header_bottons">
            全能本
          </el-col>
          <el-col :span="2" :offset="1" class="header_bottons">
            电脑配件
          </el-col>
          <el-col :span="2" :offset="4">
            <el-dropdown trigger="click"  @visible-change="blurThePage">
              <span class="el-dropdown-link header_bottons">
                我的账户<el-icon class="el-icon--right"><arrow-down /></el-icon>
              </span>
              <template #dropdown>
                <el-dropdown-menu>
                  <el-dropdown-item :icon="Plus" @click="goLogin">
                    登陆账户
                  </el-dropdown-item>
                  <el-dropdown-item :icon="CirclePlusFilled" @click="goRegister">
                    注册账户
                  </el-dropdown-item>
                  <el-dropdown-item :icon="CirclePlusFilled" @click="goUserPage">
                    个人页面
                  </el-dropdown-item>
                  <el-dropdown-item :icon="CirclePlusFilled">
                    注销
                  </el-dropdown-item>
                </el-dropdown-menu>
              </template>
            </el-dropdown>
          </el-col>
        </el-row>
      </el-header>
      <el-container>
        <!--侧边导航栏-->
        <el-aside width="500px">
          <el-col :span="15" :offset="4">
            <div class="side-top-block"></div>
            <el-affix :offset="80">
              <el-menu
                class="side-menu"
                default-active="5"
                @open="handleOpen"
                @close="handleClose"
              >
                <el-menu-item index="1" @click="goOverView">
                  <div class="menu-tag"></div>
                  <i class="iconfont icon-yonghu_user menu-icon"></i>
                  <span class="side-menu-item-text">账号概览</span>
                </el-menu-item>
                <el-menu-item index="2" @click="goDetails">
                  <div class="menu-tag"></div>
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
                <el-menu-item index="5" @click="goShopCart" class="selected-menu-item">
                  <div class="selected-menu-tag menu-tag"></div>
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
              购物车
            </el-col>
          </el-row>
          <div class="productBox">
            <div
                v-for="(o) in todos"
                :key="o.productId"
                class="productItem"
            >
              <img
                  src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                  class="image"
              />
              <span>{{o.productName}}</span>
              <time class="time">{{ o.brand }}</time>
              <span>￥{{o.price}}</span>
              <span>{{o.num}}</span>
              <el-button class="button" type="primary" @click="removeProduct(o)">移除</el-button>
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
  import { ref } from 'vue';
  import axios from "axios";
  import qs from 'qs';

	const router = useRouter()
	function goLogin() {
		router.push({
			path: '/login'
		})
	}
  function goRegister() {
		router.push({
			path: '/register'
		})
	}
  function goUserPage() {
		router.push({
			path: '/userPage'
		})
	}
  function goHome() {
    router.push({
			path: '/home'
		})
  }
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
  // 购物车展示
  const todos = ref()
  function removeProduct(o: any) {
    console.log(o.productId);
    let remove_data = {
      "customerId": localStorage.getItem('customerId'),
      "productId": o.productId,
    }
    axios.post("http://localhost:9090/cart/delProduct", qs.stringify(remove_data)).then(res_remove=>{
      console.log("是否已从购物车移除"+res_remove.data);
      if (res_remove.data) {
        let data = {
          "customerId": localStorage.getItem('customerId'),
        }
        console.log(data.customerId);
        axios.post("http://localhost:9090/cart", data).then(res=>{
          console.log(res.data);
          todos.value=res.data;
          console.log(todos.value);
        })
      }
    })
  }

  let data = {
    customerId: localStorage.getItem('customerId'),
  }
  console.log(data.customerId);
  axios.post("http://localhost:9090/cart", data).then(res=>{
    console.log(res.data);
    todos.value=res.data;
    console.log(todos.value);
  })
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

// 左上角logo
.logo {
  height: 100px;
  width: 200px;
}
.logo_box {

  margin-left: 0 !important;
}
// 标题 ******************************************
.el-header {
  height: 55px !important;
  width: 100%;
  box-shadow: 0 0 10px #ddd;
  background-color: rgb(255, 255, 255);

  border-bottom-style: solid;
  border-bottom-width: 1px;
  border-bottom-color: rgb(222, 222, 222);
  .el-row {
    height: 100%;
    position: relative;
    top: -25px;
    .el-col {
      text-align: center;
      font-weight:bold;
      font-size: 20px;
    }
  }
}
// 标题按钮样式
.header_bottons {
  color: rgb(114, 114, 114);
  transition:color 0.6s linear // 渐变颜色
}
.header_bottons:hover {
  color: rgb(0, 0, 0);
}

// 下拉菜单
.el-dropdown-menu {
  width: 200px;
  .el-dropdown-item {
    font-size: 100px;
    height: 100px;
  }
}
.el-dropdown-link {
  color: rgb(114, 114, 114);
  font-weight:bold;
  font-size: 20px;
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
.content-1 {
  height: 350px;
  margin-bottom: 50px;
}

// 购物车展示
.productBox {
  display: flex;
  flex-direction: column;
  justify-content: center;
  flex-wrap: wrap;
  width: 800px;

  .productItem {
    width: 100%;
    padding: 0 20px;
    margin: 10px;

    display: flex;
    justify-content: space-between;
    align-items: center;
    //border: 1px solid #cccccc;
    .image {
      height: 100px;
      width: 100px;
      display: inline-block;
    }
  }
  .productItem:hover {
    box-shadow: 0 0 10px #cccccc;
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