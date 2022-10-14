<template>
  <div>
    <!---搞一个input窗口--->
    <h1>{{msg}}</h1>
    <div> customerName</div>
    <input id="customerName"></input>
    <div>loginPwd</div>
    <input id="loginPwd"></input>
    <!--更改用户信息customerId, customerName,email, birthday, phone, address-->
    <div>customerId</div>
    <input id="customerId"></input>
    <div>email</div>
    <input id="email"></input>
    <div>birthday</div>
    <input id="birthday">
    <div>phone</div>
    <input id="phone"></input>
    <div>address</div>
    <input id="address"></input>
    <!--获取到用户输入的信息-->
    <button @click="log()">登录</button>
    <button @click="register()">注册</button>
    <button @click="namecheck()">重名检测</button>
    <button @click="logout()">退出登录</button>
    <button @click="getinfo()">获取用户全部信息</button>
    <button @click="modifyInfo()">更改信息</button>
    <button @click="checkPwd">再次输入密码，检查正确性</button>
    <button @click="modifyPwd">输入新密码并点击修改</button>
    <button @click="deleteCustomer()">删除该用户并退出登录</button>
    <button @click="allorders()">输入customerId获取所有订单</button>

    <div>productId</div>
    <input id="productId"></input>
    <button @click="checkbox()">输入cId pId并勾选</button>
    <button @click="buyall()">点击购买所有勾选的产品</button>
    <button @click="addProduct()">点击加入购物车</button>
    <button @click="checkProduct">检查物品是否在购物车</button>
    <button @click="deleteProduct">从购物车中删除</button>
    <button @click="plusProduct()">某个商品多买一个</button>
    <button @click="minusProduct">某个商品少买一个</button>
    <button @click="deleteOrder">删除订单</button>
    <h1>{{login_msg}}</h1>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Customer",


  data(){
    return {
      token:null,
      //里面定义一些json数据信息
      msg:"hello vue",
      books:[ /*一个json数据列表*/
      ],
      customerName:null,
      loginPwd:null,
      login_msg:""
    }
  },
  methods:{
    log(){
      //定义了一个函数来执行
      //根据input框的id来获取相关的文本值
      this.customerName= document.getElementById("customerName").value;
      this.loginPwd = document.getElementById("loginPwd").value;

      let data = {
        "customerName":this.customerName,
        "loginPwd":this.loginPwd
      }
      console.log(data)
      axios.post('http://localhost:9090/customer/login',data).then((res)=>{
        //判断登录情况
        console.log(res)
        console.log(res.data)
        console.log(res.data.success)
        if (res.data.success){
          this.token = res.data.token
        }else {
          this.token=null
        }


        //回调函数 跳转到正常的页面
      })
      //axios发送一个post请求到指定的url
    },
    logout(){
      axios({
        method:"post",
        url:"http://localhost:9090/customer/logout",
        headers:{
          token:this.token
        },
        params: {
          "customerId":1
        }
      }).then(res=>{
        console.log(res.data);
        this.token = null
      })
    },
    getinfo(){
      axios({
        method:"post",
        url:"http://localhost:9090/customer/info",
        headers:{
          token:this.token
        },
        params: {"customerId":1}
      }).then(res=>{
        console.log(res.data);
      })
    },
    modifyInfo(){
      axios({
        method:"post",
        url:"http://localhost:9090/customer/modifyInfo",
        headers:{
          token:this.token
        },
        data:{
            customerId: 1,
            customerName: "zjh",
            email: "zjh@163.com",
            birthday:2022-10-10,
            phone: 123456789,
            address: "thu"
        }
      }).then(res=>{
        console.log(res.data);
      })
    },
    register(){
      //定义了一个函数来执行
      //根据input框的id来获取相关的文本值
      this.customerName= document.getElementById("customerName").value;
      this.loginPwd = document.getElementById("loginPwd").value;

      let data = {
        "customerName":this.customerName,
        "loginPwd":this.loginPwd
      }
      axios.post('http://localhost:9090/customer/register',data).then((res)=>{
        //判断登录情况
        console.log(res); //res应该是一个数字
        if(res===true){
          this.login_msg = "success sign";
        }else {
          this.login_msg = "fail";
        }
        //回调函数 跳转到正常的页面
      })
      //axios发送一个post请求到指定的url
    },
    namecheck(){
      this.customerName= document.getElementById("customerName").value;
      let data = {
        "customerName":this.customerName,
      }
      axios.post('http://localhost:9090/customer/namecheck',data).then((res)=>{
        console.log(res)
        if (res.data===true){
          this.login_msg="重名";
        }else {
          this.login_msg="没有重名";
        }
      })
    },
    checkPwd(){
      axios({
        method:"post",
        url:"http://localhost:9090/customer/checkPwd",
        headers:{
          token:this.token
        },
        params: {
          "customerId":1,
          "loginPwd":"12345"
        }
      }).then(res=>{
        console.log(res.data);
      })
    },
    modifyPwd(){
      axios({
        method:"post",
        url:"http://localhost:9090/customer/modifyPwd",
        headers:{
          token:this.token
        },
        params: {
          "customerId":1, //因为现在数据库里就一个所以就直接放这里了
          "loginPwd":1212
        }
      }).then(res=>{
        console.log(res.data);
      })
    },
    deleteCustomer(){
      axios({
        method:"post",
        url:"http://localhost:9090/customer/deleteCustomer",
        headers:{
          token:this.token
        },
        params: {
          "customerId":1, //因为现在数据库里就一个所以就直接放这里了
        }
      }).then(res=>{
        console.log(res.data);
      })
    },
    allorders(){
      axios({
        method:"post",
        url:"http://localhost:9090/order/all",
        headers:{
          token:this.token
        },
        params: {
          "customerId":1,
        }
      }).then(res=>{
        console.log(res.data);
      })
    },
    checkbox(){
      axios({
        method:"post",
        url:"http://localhost:9090/cart/checkbox",
        headers:{
          token:this.token
        },
        params: {
          "customerId":1,
          "productId":1
        }
      }).then(res=>{
        console.log(res.data);
      })
    },
    buyall(){
      axios({
        method:"post",
        url:"http://localhost:9090/cart/buyAll",
        headers:{
          token:this.token
        },
        params: {
          "customerId":1,
        }
      }).then(res=>{
        console.log(res.data);
      })
    },
    addProduct(){
      axios({
        method:"post",
        url:"http://localhost:9090/cart/add",
        headers:{
          token:this.token
        },
        params: {
          "customerId":1,
          "productId":3
        }
      }).then(res=>{
        console.log(res.data);
      })
    },
    checkProduct(){
      axios({
        method:"post",
        url:"http://localhost:9090/cart/check",
        headers:{
          token:this.token
        },
        params: {
          "customerId":1,
          "productId":3
        }
      }).then(res=>{
        console.log(res.data);
      })
    },
    deleteProduct(){
      axios({
        method:"post",
        url:"http://localhost:9090/cart/delProduct",
        headers:{
          token:this.token
        },
        params: {
          "customerId":1,
          "productId":3
        }
      }).then(res=>{
        console.log(res.data);
      })
    },
    plusProduct(){
      axios({
        method:"post",
        url:"http://localhost:9090/cart/plusProduct",
        headers:{
          token:this.token
        },
        params: {
          "customerId":1,
          "productId":2
        }
      }).then(res=>{
        console.log(res.data);
      })
    },
    minusProduct(){
      axios({
        method:"post",
        url:"http://localhost:9090/cart/minusProduct",
        headers:{
          token:this.token
        },
        params: {
          "customerId":1,
          "productId":2
        }
      }).then(res=>{
        console.log(res.data);
      })
    },
    deleteOrder(){
        axios({
          method:"post",
          url:"http://localhost:9090/order/deleteById",
          headers:{
            token:this.token
          },
          params: {
            "customerId":1,
            "orderId":2
          }
        }).then(res=>{
          console.log(res.data);
        })
    }
  },



  created() {

    const that = this
    axios.get('http://localhost:9090/customer').then(function (resp){
      console.log(resp)
      that.books = resp.data //回调函数
      //如果还用this的话this变成了回调的对象
    })
  },


}
</script>

<style scoped>

</style>