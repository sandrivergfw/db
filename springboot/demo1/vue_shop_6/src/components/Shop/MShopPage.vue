<template>
  <div class="common-layout" :class="{blured:isActive}">
    <link href="../../assets/icons/font_2cf2621a7by/iconfont.css">
    <el-container>
      <el-main>
        <!--主体页面 :offset="index > 0 ? 2 : 0"-->
        <div class="productBox">
          <div
            v-for="(o) in datas"
            :key="o.productId"
            class="productItem"
          >
            <el-card 
              :body-style="{ padding: '0px' }" 
              class="productCard"
              shadow="hover"
              v-if="o.productId"
            >
              <template #header>
                <div class="card-header">
                  <img
                    :src="o.pictureSrc"
                    class="image"
                    @click="goDetail(o.productId)"
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

<script lang="ts">
  import {
    ArrowDown,
    Check,
    CircleCheck,
    CirclePlus,
    CirclePlusFilled,
    Plus,
  } from '@element-plus/icons-vue'
  import { useRouter } from 'vue-router';
  import {onMounted, onUnmounted, reactive, ref, unref} from 'vue';
  import axios from "axios";
  import { h } from 'vue'
  import { ElNotification } from 'element-plus'
  import * as url from "url";
  import qs from 'qs';

  export default ({
    setup(){
      // 切换页面的路由
      const router = useRouter()
      function goDetail(id: any) {
        let productInfo = router.resolve({
          name:'ProductInfo',
          params:{id: id}
        })
        window.open(productInfo.href)
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
      // 商品展示
      const todos = ref()

      axios.get("http://localhost:9090/products").then(res=>{
        todos.value=res.data;
        console.log(todos.value);
        for (const i in todos.value) {
          // 解析商品图片的地址
          todos.value[i].pictureSrc = require('../../assets/pictures/products/'+todos.value[i].picture);
        }
        console.log(todos.value);
      })

      //滚动事件处理函数
      function scrollHandle() {
        //console.log('滚了');
        const scrollHeight = document.body.scrollHeight;
        const scrollTop =
            document.body.scrollTop || document.documentElement.scrollTop;
        const clientHeight = document.body.clientHeight;

        const distance = scrollHeight - scrollTop - clientHeight;

        console.log(distance);
        if (distance <= 200) {
          console.log("快到底了");
          loadMore(); //多次触发没关系，加载完之前只能有一个实际执行
        }
      }

      onMounted(() => {
        //组件挂载时，添加scroll监听
        window.addEventListener("scroll", scrollHandle, false);
      });
      onUnmounted(() => {
        //组件卸载时，停止监听
        window.removeEventListener("scroll", scrollHandle, false);
      });

      const datas = ref([] as any[]);

      let readyForLoad = true; //默认允许加载一次
      let count = 1;

      loadMore(); //初始加载一次
      function loadMore() {
        if (readyForLoad) {
          //需要加载才进来，防止重复
          readyForLoad = false; //进来了就"锁上"
          axios.get("http://localhost:9090/products").then(res=>{
            datas.value = [...datas.value, ...res.data];
            for (const i in datas.value) {
              // 解析商品图片的地址
              datas.value[i].pictureSrc = require('../../assets/pictures/products/'+datas.value[i].picture);
            }
            readyForLoad = true; //加载完了才"开锁"，允许再次触发
          })
        }
      }

      // 购买商品
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
          axios.post("http://localhost:9090/cart/check", qs.stringify(data)).then(res1 => {
            console.log("是否已经加入购物车" + res1.data);
            if (!res1.data) {
              axios.post("http://localhost:9090/cart/add", qs.stringify(data)).then(res => {
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
      return {
        goDetail, blurThePage, purchase,
        haveToken, isActive,
        todos, datas,
        ArrowDown
      }
    }
  })

</script>

<style lang="less" scoped>
// 最外部element plus框架 ******************************************
.common-layout {
  height: 100%;
}

// 主体 ******************************************
.el-main {
  //height: 1500px;
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
      height: 420px;
      .image {
        height: 260px;
        width: 260px;
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