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
        <el-main style='overflow: scroll;overflow-y:hidden;overflow-x:hidden'>
          <div class="main-head-row">
            <span class="head-title">
              购物车
            </span>
            <span class="countCart">
              全部商品{{cartLength.cartLen}}
            </span>
          </div>
          <div class="sub-head-row">
            <span>
              购物车
            </span>
          </div>
          <el-scrollbar max-height="620px">
            <div class="productBox">
              <div
                  v-for="(o) in todos"
                  :key="o.productId"
                  class="productItem"
              >
                <span style="width: 50px" class="checkbox">
                  <input type="checkbox" v-model="o.isSelect" @click="selectCart(o)">
                </span>
                <span>
                  <img
                      :src="o.pictureSrc"
                      class="image"
                      alt="暂无图片"
                      style="cursor: pointer"
                  />
                </span>

                <span>{{o.productName}}</span>
                <span>{{ o.brand }}</span>
                <span>￥{{o.price}}</span>
                <span class="product_num">
                  <el-button class="button" type="primary" @click="minusProduct(o)">-</el-button>
                  <span>
                  {{o.num}}
                  </span>
                  <el-button class="button" type="primary" @click="plusProduct(o)">+</el-button>
                </span>
                <span>￥{{o.price*o.num}}</span>
                <span>
                  <el-button class="button" type="primary" @click="removeProduct(o)">移除</el-button>
                </span>
              </div>
            </div>
          </el-scrollbar>

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
  import {reactive, ref} from 'vue';
  import axios from "axios";
  import qs from 'qs';
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
  // 购物车展示
  const todos = ref()
  // 获取购物车初始信息
  let data = {
    customerId: localStorage.getItem('customerId'),
  }
  console.log(data.customerId);
  console.log(todos)
  // 声明为const的reactive对象可以实时显示更改
  const cartLength = reactive({
    cartLen: 0,
  });
  axios.post("http://localhost:9090/cart", data).then(res=>{
    console.log(res.data);
    todos.value=res.data;
    console.log(todos.value);
    // 计算购物车商品数量
    for (const i in todos.value) {
      // 解析商品图片的地址
      todos.value[i].pictureSrc = require('../../assets/pictures/products/'+todos.value[i].picture);
      cartLength.cartLen++;
    }
    console.log(cartLength.cartLen);
    console.log(todos.value);
  })

  // 从购物车移除
  function removeProduct(o: any) {
    console.log("removing: ", o.productId);
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
        cartLength.cartLen--;
        console.log(data.customerId);
        axios.post("http://localhost:9090/cart", data).then(res=>{
          console.log(res.data);
          todos.value=res.data;
          console.log(todos.value);
          for (const i in todos.value) {
            // 解析商品图片的地址
            todos.value[i].pictureSrc = require('../../assets/pictures/products/'+todos.value[i].picture);
          }
        })
      }
    })
  }

  // 勾选商品
  function selectCart(o: any){
    console.log("selecting: ", o.productId);
    let select_data = {
      "customerId": localStorage.getItem('customerId'),
      "productId": o.productId,
    }
    axios.post("http://localhost:9090/cart/checkbox", qs.stringify(select_data)).then(res_select=>{
      console.log(res_select.data);
    })
  }

  // 加减产品
  function minusProduct(o: any){
    console.log(o.productId);
    let minusPro_data = {
      "customerId": localStorage.getItem('customerId'),
      "productId": o.productId,
    }
    axios.post("http://localhost:9090/cart/minusProduct", qs.stringify(minusPro_data)).then(res=>{
      console.log("商品减一：", res.data)
      if (res.data && o.num!= 1) {
        o.num = o.num-1;
      }
    })
  }

  function plusProduct(o: any){
    console.log(o.productId);
    let plusPro_data = {
      "customerId": localStorage.getItem('customerId'),
      "productId": o.productId,
    }
    axios.post("http://localhost:9090/cart/plusProduct", qs.stringify(plusPro_data)).then(res=>{
      console.log("商品加一：", res.data)
      if (res.data) {
        o.num = o.num+1;
      }
    })
  }

</script>
  
<style lang="less" scoped>
// 最外部element plus框架 ******************************************
.common-layout {
  height: 100%;
}
.std_container {
  height: 1200px;
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
  display: flex;
  flex-direction: row;
  align-items: baseline;
  justify-content: flex-start;

  margin-top: 80px;
  margin-bottom: 20px;
  .head-title {
    color: rgb(0, 0, 0);
    font-size: 30px;
  }
  .countCart {
    margin-left: 20px;
    color: #ff0000;
    font-size: 18px;
    font-weight: bold;
  }
}
.sub-head-row {
  display: flex;
  flex-direction: row;
  align-items: baseline;
  justify-content: flex-start;

  margin-top: 20px;
  margin-bottom: 20px;

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
    span {
      width: 200px;
      .image {
        height: 100px;
        width: 100px;
        display: inline-block;
      }
    }

  }
  .productItem:hover {
    box-shadow: 0 0 10px #cccccc;
  }
  .product_num {
    width: 200px;
    span {
      margin: 0 10px;
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