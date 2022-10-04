<template>
  <div class="common-layout">
    <link href="../assets/icons/font_2cf2621a7by/iconfont.css"> 
    <el-container class="std_container">
      <el-header>
        <el-row type="flex" align="middle">
          <el-col :span="1" class="logo_box">
            <img src="../assets/computer_logo.png" alt="" class="logo">
          </el-col>
          <el-col :span="1" :offset="1" class="header_bottons">
            电脑
          </el-col>
          <el-col :span="1" :offset="1" class="header_bottons">
            商城
          </el-col>
          <el-col :span="1" :offset="1" class="header_bottons">
            支持
          </el-col>
          <el-col :span="2" :offset="14">
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
        <el-aside width="350px">
          <el-col :span="20" :offset="2">
            <div class="side-top-block"></div>
            <el-affix :offset="30">
              <el-menu
                class="side-menu"
                default-active="1"
                @open="handleOpen"
                @close="handleClose"
              >
                <el-menu-item index="1">
                  <i class="iconfont icon-mima_password"></i>
                  <span class="side-menu-item-text">账号概览</span>
                </el-menu-item>
                <el-menu-item index="2">
                  <i class="iconfont icon-mima_password"></i>
                  <span class="side-menu-item-text">账号详情</span>
                </el-menu-item>
                <el-menu-item index="3">
                  <i class="iconfont icon-mima_password"></i>
                  <span class="side-menu-item-text">安全</span>
                </el-menu-item>
                <el-menu-item index="4">
                  <i class="iconfont icon-mima_password"></i>
                  <span class="side-menu-item-text">付款方式</span>
                </el-menu-item>
                <el-menu-item index="5">
                  <i class="iconfont icon-mima_password"></i>
                  <span class="side-menu-item-text">购物车</span>
                </el-menu-item>
                <el-menu-item index="6">
                  <i class="iconfont icon-mima_password"></i>
                  <span class="side-menu-item-text">历史订单</span>
                </el-menu-item>
              </el-menu>
            </el-affix>
          </el-col>


        </el-aside>
        <el-main>主体</el-main>
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
// 最外部element plus框架
.common-layout {
  height: 100%;
}
.std_container {
  height: 1500px;
  background: url('../assets/pictures/background1.jpg');
  background-position: center;
  background-repeat: repeat;
}

// 左上角logo
.logo {
  height: 40px;
  width: 40px;
  border-radius: 50%;
  box-shadow: 0 0 10px #ddd;
}
.logo_box {
  margin-left: 0 !important;
}
// 标题
.el-header {
  height: 50px !important;
  width: 100%;
  background-color: rgba(119, 123, 127, 0.392);

  border-bottom-style: solid;
  border-bottom-width: 1px;
  border-bottom-color: rgb(126, 124, 124);
  .el-row {
    height: 100%;
    .el-col {
      text-align: center;
      font-weight:bold;
      font-size: 20px;
    }
  }
}
// 标题按钮样式
.header_bottons {
  color: rgb(168, 168, 168);
  transition:color 0.6s linear // 渐变颜色
}
.header_bottons:hover {
  color: rgb(255, 255, 255);
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
  color: rgb(216, 212, 212);
  font-weight:bold;
  font-size: 20px;
}

// 主体
.el-main {
  height: 100%;
}

// 侧边导航栏
.side-top-block {
  height: 80px;
}
.side-menu {
  background-color: rgba(10, 17, 33, 0.9);
}
.side-menu-item-text {
  color: #fff;
  margin-left: 20px;
}
.el-menu-item {
  background-color: rgba(10, 17, 33, 0.9);
}
.el-menu-item:hover {
  background-color: rgba(27, 47, 92, 0.9);
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