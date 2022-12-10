<template>
  <div id="main-header">
    <el-header>
      <!--顶部导航栏-->
      <el-row type="flex" align="middle">
        <el-col :span="3" class="logo_box" @click="goHome">
          <img src="../assets/computer_logo.png" alt="" class="logo" >
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
                <el-dropdown-item @click="goLogin" v-if="!haveToken">
                  <el-icon class="iconfont icon-yonghu_user"></el-icon>
                  登陆账户
                </el-dropdown-item>
                <el-dropdown-item @click="goRegister" v-if="!haveToken">
                  <el-icon class="iconfont icon-tianjia_add"></el-icon>
                  注册账户
                </el-dropdown-item>
                <el-dropdown-item @click="goUserPage" v-if="haveToken">
                  <el-icon class="iconfont icon-yinliu_drainage"></el-icon>
                  个人页面
                </el-dropdown-item>
                <el-dropdown-item @click="logOut" v-if="haveToken">
                  <el-icon class="iconfont icon-tuichu_exit"></el-icon>
                  退出登陆
                </el-dropdown-item>
              </el-dropdown-menu>
            </template>
          </el-dropdown>
        </el-col>
      </el-row>
    </el-header>
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
function goHome() {
  router.push({
    path: '/home'
  })
}
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

// 检查token
let haveToken = false;
if (localStorage.getItem("token") != null) {
  haveToken = true;
}

// 模糊页面特效
const isActive = ref(false)
function blurThePage(){
  isActive.value = !isActive.value;
  console.log(isActive.value)
}
</script>

<style lang="less" scoped>

// 左上角logo
.logo {
  height: 55px;
  width: 110px;
  transform: scale(2);
}
.logo_box {
  margin-left: 0 !important;
  height: 55px;
  overflow: hidden;
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

</style>
