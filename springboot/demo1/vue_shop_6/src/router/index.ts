import { createRouter, createWebHashHistory, RouteRecordRaw } from 'vue-router'
import Login from '../components/Login.vue'
import Test from '../components/Test.vue'
import Register from '../components/Register.vue'
import Home from '../components/Home.vue'
import UserPage from '../components/UserPage.vue'
import OverView from '../components/UserPage/OverView.vue'
import Details from '../components/UserPage/Details.vue'
import PayWay from '../components/UserPage/PayWay.vue'
import Security from '../components/UserPage/Security.vue'
import ShopCart from '../components/UserPage/ShopCart.vue'
import History from '../components/UserPage/History.vue'
import MShopPage from '../components/Shop/MShopPage.vue'

const routes = [
  { path: '/', redirect: '/home'}, // 根目录/ 重定向到 /home
  { path: '/home', component: Home},
  { path: '/login', component: Login},
  { path: '/test', component: Test},
  { path: '/register', component: Register},
  { path: '/userPage', component: UserPage},
  { path: '/userPage/overview', component: OverView},
  { path: '/userPage/details', component: Details},
  { path: '/userPage/payway', component: PayWay},
  { path: '/userPage/security', component: Security},
  { path: '/userPage/shopcart', component: ShopCart},
  { path: '/userPage/history', component: History},
  { path: '/shop/mShopPage', component: MShopPage},
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
