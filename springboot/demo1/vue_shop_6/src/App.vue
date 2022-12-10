<template>
  <div id="app" :class="{blured:isActive}">
    <!-- header路由-->
    <main-header></main-header>
    <!-- 路由占位符 -->
    <router-view></router-view>
  </div>
</template>

<script>
import main_header from './/dectories/main_header.vue'
import isActive from './/dectories/main_header.vue'
  export default {
    name: 'app',
    components: {
      'main-header': main_header,
    },
    return: {
      isActive,
    },
  }
</script>

<style lang="less" scoped>
// 模糊特效
.blured {
  filter: blur(2px);
}
</style>
