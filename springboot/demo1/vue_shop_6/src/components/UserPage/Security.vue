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
                default-active="3"
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
                <el-menu-item index="3" @click="goSecurity" class="selected-menu-item">
                  <div class="selected-menu-tag menu-tag"></div>
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
              安全
            </el-col>
          </el-row>

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
  import { goMShopPage } from  './router_pages';

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

  // 检查token
  let haveToken = false;
  if (localStorage.getItem("token") != null) {
    haveToken = true;
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
.content-1 {
  height: 350px;
  margin-bottom: 50px;
}
.card-head{
  height: 70px;
  background-color: rgba(10, 15, 65, 0.805);
  .el-col {
    color: #fff;
    font-size: 20px;
    position: absolute;
	  left: 15%;
	  top: 50%;
	  transform: translate(-50%,-50%);
    text-align: center;
  }
}
.user-inf-box {
  height: 280px;
  background-color: rgba(11, 24, 75, 0.803);
  .user-inf {
    position: relative;
    top: 15%;
    height: 50px;
    .user-inf-name {
      color: rgb(222, 219, 219);
    }
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