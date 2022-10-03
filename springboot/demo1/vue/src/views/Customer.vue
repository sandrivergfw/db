<template>
  <div>
    <!---搞一个input窗口--->
    <h1>{{msg}}</h1>
    <div> customerId</div>
    <input id="customerName"></input>
    <div>loginPwd</div>
    <input id="loginPwd"></input>
    <!--获取到用户输入的信息-->
    <button @click="log()">登录</button>
    <button @click="register()">注册</button>
    <button @click="namecheck()">重名检测</button>
    <h1>{{login_msg}}</h1>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Customer",
  data(){
    return {
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
        if (res!==null){
          this.login_msg = "success login,token="+res.data;
          //this.$router.push('/mainIndex')
        }else {
          this.login_msg = "fail"
        }

        //回调函数 跳转到正常的页面
      })
      //axios发送一个post请求到指定的url
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
    }
  },
  created() {

    const that = this
    axios.get('http://localhost:9090/customer').then(function (resp){
      console.log(resp)
      that.books = resp.data //回调函数
      //如果还用this的话this变成了回调的对象
    })
  }
}
</script>

<style scoped>

</style>