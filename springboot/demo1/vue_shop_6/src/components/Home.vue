<template>
  <div class="common-layout" :class="{blured:isActive}">
    <link href="../assets/icons/font_2cf2621a7by/iconfont.css">
    <el-container>
      <el-header>
        <!--顶部导航栏-->
        <el-row type="flex" align="middle">
          <el-col :span="3" class="logo_box">
            <img src="../assets/computer_logo.png" alt="" class="logo">
          </el-col>
          <el-col :span="2" :offset="1" class="header_bottons" @click="goMShopPage">
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
            <el-dropdown trigger="click" @visible-change="blurThePage"> 
              <!-- @visible-change 用dropdown是否可见作为触发 -->
              <span class="el-dropdown-link header_bottons">
                我的账户<el-icon class="el-icon--right"><arrow-down /></el-icon>
              </span>
              <template #dropdown>
                <el-dropdown-menu>
                  <el-dropdown-item @click="goLogin">
                    <el-icon class="iconfont icon-yonghu_user"></el-icon>
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
      <el-main>
        <!--主体页面-->
        <el-carousel :interval="4000" type="card" height="500px" class="rol-ad">
          <el-carousel-item v-for="item in imgwarp" :key="item.url">
            <!--<h3 text="2xl" justify="center">{{ item }}</h3>-->
            <img :src="item.url" class="bannerimg"/>
          </el-carousel-item>
        </el-carousel>

      </el-main>
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
  import { ref, unref } from 'vue';
  // 切换页面的路由
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
  function goMShopPage() {
    router.push({
			path: '/shop/mShopPage'
		})
  }


  const imgwarp = [
    {url:require("../assets/pictures/laptops/1.jpg")},
    {url:require("../assets/pictures/laptops/2.jpg")},
    {url:require("../assets/pictures/laptops/3.jpg")},
    {url:require("../assets/pictures/laptops/4.jpg")},
    {url:require("../assets/pictures/laptops/5.jpg")},
    {url:require("../assets/pictures/laptops/6.jpg")},
  ]

  // 模糊页面特效
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

// 主体 ******************************************
.el-main {
  height: 1000px;
  padding: 0;
  //background-image: url('../assets/pictures/background1.jpg');
  //background-image: linear-gradient(to bottom right, #3d50fc, #7AFFAF);
  background-color: rgb(255, 255, 255);
  background-position: center;
}
// 走马灯
.rol-ad {
  background-color: #e0e0e0;
}
.el-carousel__item h3 {
  color: #475669;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
  text-align: center;
}
.bannerimg{
  width: 100%;
  height: inherit;
}
.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}

// 页脚 ******************************************
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