<template>
  <div class="common-layout" :class="{blured:isActive}">
    <link href="../../assets/icons/font_2cf2621a7by/iconfont.css">
    <el-container>
      <el-header>
        <!--顶部导航栏-->
        <el-row type="flex" align="middle">
          <el-col :span="3" class="logo_box" @click="goHome">
            <img src="../../assets/computer_logo.png" alt="" class="logo">
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
        <!--主体页面 :offset="index > 0 ? 2 : 0"-->
        <div class="productBox">
          <div
            v-for="(o) in todos"
            :key="o.productId"
            class="productItem"
          >
            <el-card 
              :body-style="{ padding: '0px' }" 
              class="productCard"
              shadow="hover"
            >
              <template #header>
                <div class="card-header">
                  <img
                    src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                    class="image"
                  />
                </div>
              </template>
              <div style="padding: 14px">
                <span>{{o.productName}}</span>
                <div class="bottom">
                  <time class="time">{{ o.brand }}</time>
                  <el-button class="button" type="primary" @click="purchase(o)">加入购物车</el-button>
                </div>
                <span>￥{{o.price}}</span>
              </div>
            </el-card>
          </div>
        </div>

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
  import axios from "axios";
  import { h } from 'vue'
  import { ElNotification } from 'element-plus'
  import * as url from "url";
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
			path: '/userPage/overview'
		})
	}
  function goHome() {
    router.push({
			path: '/home'
		})
  }

  // 模糊页面特效
  const isActive = ref(false)
  function blurThePage(){
		isActive.value = !isActive.value;
    console.log(isActive.value)
	}
  // 商品展示
  const todos = ref()

  axios.get("http://localhost:9090/products").then(res=>{
    console.log(res.data);
    todos.value=res.data;
    console.log(todos.value);
  })

  function purchase(o: any) {
    if (localStorage.getItem('token') == null) {
      router.push({
        path: '/login'
      })
    } else {
      let data = {
        "customerId": localStorage.getItem('customerId'),
        "productId": o.productId,
      }
      axios.post("http://localhost:9090/cart/check", data).then(res1 => {
        console.log("是否已经加入购物车" + res1.data);
        if (!res1.data) {
          axios.post("http://localhost:9090/cart/add", data).then(res => {
            console.log("是否加入购物车成功" + res.data);
            if (res.data) {
              ElNotification({
                title: '成功',
                message: '商品已加入购物车',
                duration: 1500,
              })
            } else {
              ElNotification({
                title: '失败',
                message: '商品未加入购物车',
                duration: 1500,
              })
            }
          })
        } else ElNotification({
          title: '成功',
          message: '商品已加入购物车',
          duration: 1500,
        })
      })
    }
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
  height: 1500px;
  padding: 0;
  //background-image: url('../assets/pictures/background1.jpg');
  //background-image: linear-gradient(to bottom right, #3d50fc, #7AFFAF);
  background-color: rgb(255, 255, 255);
  background-position: center;
  .time {
    font-size: 12px;
    color: #999;
  }

  .bottom {
    margin-top: 13px;
    line-height: 12px;
    display: flex;
    justify-content: space-between;
    align-items: center;
  }

  .button {
    padding: 10px;
    min-height: auto;
  }

}

.productBox {
  display: flex;
  justify-content: center;
  flex-wrap: wrap;
  .productItem {
    width: 300px;
    margin: 20px;

    .productCard {
      height: 250px;
      .image {
        height: 100px;
        width: 100px;
        display: block;
      }
      .card-header {
        display: flex;
        justify-content: space-between;
        align-items: center;
      }
    }
  }
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