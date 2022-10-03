<template>
  <!--只能有一个根节点,用一个div包裹-->
  <div>
    <!---搞一个input窗口--->
    <div> username</div>
    <input id="username"></input>
    <div>password</div>
    <input id="password"></input>
    <!--获取到用户输入的信息-->
    <button @click="log()">登录</button>
    <button @click="register()">注册</button>
    <button @click="namecheck()">重名检测</button>
    <h1>{{login_msg}}</h1>
  </div>
</template>

<script>
//json数据在export default内部
import axios from "axios";

export default {
  name: "Book",
  data(){
    return {
      //里面定义一些json数据信息
      msg:"hello vue",
      books:[ /*一个json数据列表*/
      ],
      username: null,
      password: null,
      login_msg:""
    }

  },
  methods:{
    log(){
      //定义了一个函数来执行
      //根据input框的id来获取相关的文本值
      this.username= document.getElementById("username").value;
      this.password = document.getElementById("password").value;

      let data = {
        "username":this.username,
        "password":this.password
      }
      axios.post('http://localhost:9090/user/login',data).then((res)=>{
        //判断登录情况
        console.log(this.username)
        console.log(this.password)
        if (res.data>1){
          this.login_msg = "success";
          this.$router.push('/mainIndex')
        }else {
          this.login_msg = "fail"
        }

        //回调函数 跳转到正常的页面

        console.log(res); //res应该是一个数字
      })
      //axios发送一个post请求到指定的url
    },
    register(){
      //定义了一个函数来执行
      //根据input框的id来获取相关的文本值
      this.username= document.getElementById("username").value;
      this.password = document.getElementById("password").value;

      let data = {
        "username":this.username,
        "password":this.password
      }
      axios.post('http://localhost:9090/user/register',data).then((res)=>{
        //判断登录情况
        if (res.data>0){
          this.login_msg = "success sign";
        }else {
          this.login_msg = "fail"
        }

        //回调函数 跳转到正常的页面

        console.log(res); //res应该是一个数字
      })
      //axios发送一个post请求到指定的url
    },
    namecheck(){
      this.username= document.getElementById("username").value;
      let data = {
        username:this.username
      }
      axios.post('http://localhost:9090/user/namecheck',data).then((res)=>{
        if (res.data>0){
          this.login_msg="重名";
        }else {
          this.login_msg="没有重名";
        }
      })
    }
  },
  created() {

    const that = this
    axios.get('http://localhost:9090/user').then(function (resp){
      console.log(resp)
      that.books = resp.data //回调函数
      //如果还用this的话this变成了回调的对象
    })
  }
}
</script>

<style scoped>

</style>