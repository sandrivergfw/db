import { createRouter, createWebHashHistory, RouteRecordRaw } from 'vue-router'
import Login from '../components/Login.vue'
import Test from '../components/Test.vue'
import Register from '../components/Register.vue'
import Home from '../components/Home.vue'
import UserPage from '../components/UserPage.vue'

const routes = [
  { path: '/', redirect: '/home'}, // 根目录/ 重定向到 /home
  { path: '/home', component: Home},
  { path: '/login', component: Login},
  { path: '/test', component: Test},
  { path: '/register', component: Register},
  { path: '/userPage', component: UserPage}
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
