<template>
  <div class="common-layout" :class="{blured:isActive}">
    <link href="../assets/icons/font_2cf2621a7by/iconfont.css">
    <el-container>
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
  import { ref, unref } from 'vue';

  const imgwarp = [
    {url:require("../assets/pictures/laptops/1.jpg")},
    {url:require("../assets/pictures/laptops/2.jpg")},
    {url:require("../assets/pictures/laptops/3.jpg")},
    {url:require("../assets/pictures/laptops/4.jpg")},
    {url:require("../assets/pictures/laptops/5.jpg")},
    {url:require("../assets/pictures/laptops/6.jpg")},
  ]

  // 模糊页面特效
</script>

<style lang="less" scoped>
// 最外部element plus框架 ******************************************
.common-layout {
  height: 100%;
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