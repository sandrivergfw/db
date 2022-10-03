<template>
  <div>
    <h1>商品详情</h1>
    <div>brand</div>
    <input id="brand"></input>
    <div>price1</div>
    <input id="price1"></input>
    <div>price2</div>
    <input id="price2"></input>
    <div>size</div>
    <input id="size"></input>
    <div>按照什么排序</div>
    <input id="sortIndex"></input>
    <div>升序or降序</div>
    <input id="order"></input>
    <button @click="findAll()">展示所有产品</button>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Products",
  data() {
    return {
      brand: null,
      price1: null,
      price2: null,
      size: null,
      sales: null,
      sortIndex: null, //排序标准
      order: null //升序或降序，只能是DESC和ASC取值
    }
  },
  methods:{
    findAll(){
      let data={
        brand:document.getElementById("brand").value,
        price1:document.getElementById("price1").value,
        price2:document.getElementById("price2").value,
        size:document.getElementById("size").value,
        sales:null,
        sortIndex:document.getElementById("sortIndex").value, //sales或者price
        order:document.getElementById("order").value//DESC或ASC
      }
      console.log(data)
      axios.post("http://localhost:9090/products/filter",data).then(res=>{
        console.log(res.data)
      })
    }
  }
}
</script>

<style scoped>

</style>