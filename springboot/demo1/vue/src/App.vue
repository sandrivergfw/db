<!--入口-->
<template>
  <div id="app">
    <router-link to="/Customer">customer</router-link>
    <br>
    <router-link to="/Products">products</router-link>
    <br>
    <router-link to="/Cart">cart</router-link>
    <router-view/>

  </div>
</template>

<style>
#app{
  height: 100%;
}

</style>
