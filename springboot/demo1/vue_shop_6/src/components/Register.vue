<template>
	<div class="register_container">
		<div class="register_box">
			<div class="avator_box">
				<!--头像区域--> 
				<img src="../assets/logo.png" alt=""> 
			</div>

			<el-form
			:model="registerForm" 
			:rules="registerFormRule" 
			ref="registerFormRef" 
			label-width="0px" 
			class="register_form">
				<!--用户名 </el-input>-->
				<el-form-item prop="username">
					<el-input v-model="registerForm.username" placeholder="User Name"></el-input>
					<!--注意icon图标的引用格式-->
				</el-form-item>
				<!--密码-->
				<el-form-item prop="password">
					<el-input v-model="registerForm.password" placeholder="Password"
					type="password"></el-input>
				</el-form-item>
				<el-form-item prop="password_again">
					<el-input v-model="registerForm.password_again" placeholder="Password Again"
					type="password"></el-input>
				</el-form-item>
				<!--按钮区域-->
				<el-form-item class="bots">
					<el-button type="primary" plain @click="registe">注册</el-button>
					<span class="tips_1">已有账户？</span>
					<el-button text type="info" plain @click="returnToLogin">登陆</el-button>
				</el-form-item>
			</el-form>

		</div>
	</div>
</template>

<script setup lang="ts">
	import { reactive } from 'vue';
	import { useRouter } from 'vue-router';
	import { ref, unref } from "vue"; // 引入组件
	import { ElMessage, ElMessageBox } from 'element-plus';
	import type { FormInstance } from 'element-plus'


	// 这是注册表单的数据绑定对象
	const registerForm = reactive({
		username: '',
		password: '',
		password_again: '',
	})
	// 这是表单的验证规则对象
	const registerFormRef = ref<FormInstance>()
	const validatePass1 = (rule: any, value: string, callback: any) => {
		if (value === '') {
			callback(new Error('请输入密码'))
		} else if (value.length < 6 || value.length > 20){
			callback(new Error('长度在 6 到 20 个字符之间'))
		} else{
			if (registerForm.password_again !== '') {
				if (!registerFormRef.value) return
				registerFormRef.value.validateField('password_again', () => null)
			}
			callback()
		}
	}
	const validatePass2 = (rule: any, value: string, callback: any) => {
		if (value === '') {
			callback(new Error('请再次输入密码'))
		} else if (value.length < 6 || value.length > 20) {
			callback(new Error('长度在 6 到 20 个字符之间'))
		} else if (value !== registerForm.password) {
			callback(new Error("两次输入密码不一致"))
		} else {
			callback()
		}
	}
	const registerFormRule = reactive({
		// 验证用户名
		username: [
			{ min: 3, max: 12, message: '长度在 3 到 12 个字符之间', trigger: 'blur' },
			{ required: true, message: '请输入用户名', trigger: 'blur' }
		],
		// 验证密码
		password: [
			{ validator: validatePass1, trigger: 'blur'}
		],
		// 再次验证密码
		password_again: [
			{ validator: validatePass2, trigger: 'blur'}
		]
	})

	// 组合式api中没有this概念，使用ref和unref获取对象的引用
	// 登陆
	function registe() {
		if (!registerFormRef.value) return
		registerFormRef.value.validate(
      (valid: boolean) => {
				console.log(valid)
				if (!valid) ElMessageBox.alert('注册信息格式不正确', 'ERROR');
				else ElMessageBox.alert('注册成功', 'SUCCESS');
			}
		);
	}

	const router = useRouter()
	function returnToLogin() {
		router.push({
			path: '/login'
		})
	}

</script>

<style lang="less" scoped>
.register_container{
	height: 100%;
	background-image: url('../assets/pictures/background1.jpg');
	background-position: center;

	background-color: rgb(33, 177, 203);
}
.register_box{
	width: 450px;
	height: 350px;
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

.register_form{
	position: absolute;
	bottom: 5%;
	width: 100%;
	padding: 0 20px;
	box-sizing: border-box; 
	// 默认的box-sizing: content-box(边框和内边距宽度会增加到内容区的宽度上)
	.el-form-item {
		margin: 25px 0;
	}
}

.bots{
	.el-button{
		margin: 0 0 0 30px;
	}
	:first-child{
		margin: 0;
	}
}

.tips_1{
	margin-left: 30px;
	color: grey;
}
</style>
