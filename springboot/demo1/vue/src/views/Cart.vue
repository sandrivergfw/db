<template>
  <div>
    <div>排序方式</div>
    <input id="order"></input>
    <div>顾客ID</div>
    <input id="customerId"></input>
    <div>商品ID</div>
    <input id="productId"></input>
    <button @click="orderByTime()">按时间排序</button>
    <button @click="add()">添加到购物车</button>
    <button @click="delete_()">从购物车删除</button>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Cart",
  data() {
    return {
      order: null,
      customerId:null,
      productId:null
    }
  },
  methods:{
    orderByTime(){
      let data={
        order: document.getElementById("order").value
      }
      console.log(data)
      axios.post("http://localhost:9090/cart/orderByTime",data).then(res=>{
        console.log(res.data); //按时间排序的购物车列表
      })
    },
    add(){
      let data={
        customerId:document.getElementById("customerId").value,
        productId:document.getElementById("productId").value,
        order: document.getElementById("order").value
      }
      axios.post("http://localhost:9090/cart/add",data).then(res=>{
        console.log(res);
      })
    },
    delete_(){
      let data={
        customerId:document.getElementById("customerId").value,
        productId:document.getElementById("productId").value,
        order: document.getElementById("order").value
      }
      axios.post("http://localhost:9090/cart/delete",data).then(res=>{
        console.log(res);
      })
    }
  },
  created() {
    let data = {
      customerId:1
    }
    axios.post("http://localhost:9090/cart/",data).then(res=>{
      console.log(res);
    })
  }
}
</script>

<style scoped>

</style>