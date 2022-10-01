<template>
  <div class="common-layout">
    <link href="../assets/icons/font_2cf2621a7by/iconfont.css"> 
    <el-container>
      <el-header>
        <el-row type="flex" align="middle">
          <el-col :span="1" class="logo_box">
            <img src="../assets/computer_logo.png" alt="" class="logo">
          </el-col>
          <el-col :span="1">
            电脑
          </el-col>
          <el-col :span="1">
            商城
          </el-col>
          <el-col :span="1">
            支持
          </el-col>
          <el-col :span="16">
            <el-dropdown trigger="click">
              <span class="el-dropdown-link">
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
                    购物车
                  </el-dropdown-item>
                  <el-dropdown-item :icon="CirclePlusFilled">
                    历史订单
                  </el-dropdown-item>
                </el-dropdown-menu>
              </template>
            </el-dropdown>
          </el-col>
        </el-row>
      </el-header>
      <el-main>主体页面</el-main>
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
</script>

<style lang="less">
.logo {
  height: 40px;
  width: 40px;
  border-radius: 50%;
  box-shadow: 0 0 10px #ddd;
}
.logo_box {
  margin-left: 0 !important;
}

.el-header {
  height: 50px !important;
  width: 100%;
  box-shadow: 0 0 10px #ddd;
  background-color: rgb(0, 0, 0);
  color: rgb(216, 212, 212);
  .el-row {
    height: 100%;
    .el-col {
      margin-left: 30px;
      text-align: center;
      font-weight:bold;
      font-size: 20px;
    }
  }

}

.el-dropdown-link {
  color: rgb(216, 212, 212);
  font-weight:bold;
  font-size: 20px;
}


.common-layout {
  height: 100%;
}

.el-main {
  height: 1000px;
  background-image: url('../assets/pictures/background1.jpg');
  background-position: center;
}

.el-footer {
  background-color: rgb(0, 0, 0);
  text-align: center;
  color: rgb(216, 212, 212);
}

</style>