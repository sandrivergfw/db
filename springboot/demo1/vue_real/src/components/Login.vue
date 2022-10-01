
<template>
	<div class="login_container">
		<link href="../assets/icons/font_2cf2621a7by/iconfont.css"> 
		<!-- 这里link引入icon的css文件时就不用ref了，有些浏览器用ref="stylesheet"会报错-->
		<div class="login_container">
		<div class="login_box">
			<div class="avator_box">
				<!--头像区域--> 
				<img src="../assets/logo.png" alt=""> 
			</div>

			<el-form 
			:model="loginForm" :rules="loginFormRule" ref="loginFormRef" 
			label-width="0px" class="login_form">
				<!--用户名-->
				<el-form-item prop="username">
					<el-input 
					v-model="loginForm.username" 
					placeholder="User Name"
					>
					<template #prefix>
            <i class="iconfont icon-yonghu_user"></i>
          </template>
					</el-input>
					<!--注意icon图标的引用格式-->
				</el-form-item>
				<!--密码-->
				<el-form-item prop="password">
					<el-input 
					v-model="loginForm.password" 
					placeholder="Password"
					show-password
					type="password"
					>
					<template #prefix>
            <i class="iconfont icon-mima_password"></i>
          </template>
					</el-input>
				</el-form-item>
				<!--按钮区域-->
				<el-form-item class="bots">
					<el-button type="primary" plain @click="login">登陆</el-button>
					<el-button type="info" plain @click="resetLoginForm">清除</el-button>
					<el-button text type="primary" plain @click="goRegister">注册账户</el-button>
				</el-form-item>
			</el-form>
		</div>
	</div>
	</div>
</template>

<script setup>
	import { ElIcon } from 'element-plus';
	import { ElMessage, ElMessageBox } from 'element-plus';
	import { reactive } from 'vue';
	import { ref, unref } from "vue"; // 引入组件
	import { useRouter } from 'vue-router';
  import axios from "axios";

	// 这是登陆表单的数据绑定对象
	const a = '123'

	const loginForm = reactive({
		username: '',
		password: '',
	})

	// 这是表单的验证规则对象
	const loginFormRule = reactive({
		// 验证用户名
		username: [
			{ min: 3, max: 12, message: '长度在 3 到 12 个字符之间', trigger: 'blur' },
			{ required: true, message: '请输入登陆名称', trigger: 'blur' }
		],
		// 验证密码
		password: [
			{ min: 6, max: 20, message: '长度在 6 到 20 个字符之间', trigger: 'blur' },
			{ required: true, message: '请输入登陆密码', trigger: 'blur' }
		]
	})

	// 组合式api中没有this概念，使用ref和unref获取对象的引用
	let loginFormRef = ref()
	// 登陆
	function login() {
		const form = unref(loginFormRef)
		form.validate(
			valid => {
				console.log(valid)
				if (!valid) ElMessageBox.alert('用户或密码错误', 'ERROR');
        else {
          let data = {
            username:loginForm.username,
            password:loginForm.password
          }
          axios.post('http://localhost:9090/user/login',data).then((res)=>{
            console.log(res)
          })
          console.log('登录成功')
        }

			}
		);
	}
	// 重置
	function resetLoginForm() {
		const form = unref(loginFormRef)
		console.log(loginFormRef.value);
		form.resetFields();
	}

	const router = useRouter()
	function goRegister() {
		router.push({
			path: '/register'
		})
	}
</script>

<style lang="less" scoped> 
// scoped:样式只在当前组件内生效

.login_container{
	height: 100%;
	background-image: url('../assets/pictures/background1.jpg');
	background-position: center;

	background-color: rgb(33, 177, 203);
}
.login_box{
	width: 450px;
	height: 300px;
	background-color: #fff;
	border-radius: 10px;
	position: absolute;
	left: 50%;
	top: 50%;
	transform: translate(-50%,-50%);

	.avator_box{ // 嵌套定义样式
		width: 130px;
		height: 130px;
		border: 1px solid #eee;
		border-radius: 50%;
		padding: 10px;
		box-shadow: 0 0 10px #ddd;
		// 定义位置
		position: absolute;
		left: 50%;
		transform: translate(-50%, -50%);
		
		background-color: #fff;
		img{
			width: 100%;
			height: 100%;
			border-radius: 50%;
			background-color: #eee;
		}
	}
}

.login_form{
	position: absolute;
	bottom: 10%;
	width: 100%;
	padding: 0 20px;
	box-sizing: border-box; 
	// 默认的box-sizing: content-box(边框和内边距宽度会增加到内容区的宽度上)
	.el-form-item {
		margin: 5% 0;
	}
}

.bots{
	justify-content: flex-end;
}
</style>
