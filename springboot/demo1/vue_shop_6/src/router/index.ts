import { createRouter, createWebHashHistory, RouteRecordRaw } from 'vue-router'
import Login from '../components/Login.vue'
import Test from '../components/Test.vue'
import Register from '../components/Register.vue'
import Home from '../components/Home.vue'
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
  {
    path: '/login',
    name: 'Login',
    component: Login,
  },
  { path: '/test', component: Test},
  { path: '/register', component: Register},
  { path: '/shop/mShopPage', component: MShopPage},
  {
    path: '/userPage', // 设置这一级的路由展示页面
    redirect: '/userPage/overview', // 自动重定向到overview
    meta: { authRequired: true },
    children: [
      { path: 'overview', component: OverView},
      { path: 'details', component: Details},
      { path: 'payway', component: PayWay},
      { path: 'security', component: Security},
      { path: 'shopcart', component: ShopCart},
      { path: 'history', component: History},
    ]
  },
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

router.beforeEach((to, from, next) => {
  const token = localStorage.getItem('token');
  if (to.meta.authRequired && to.name !== 'Login' && !token) next({ name: 'Login' })
  else next()
})

export default router
