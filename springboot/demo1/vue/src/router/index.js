import Vue from 'vue'
import VueRouter from 'vue-router'
import book from "@/views/book";
import HomeView from '../views/HomeView.vue'
import customer from "@/views/Customer";
import Customer from "@/views/Customer";
import Cart from "@/views/Cart";
import Products from "@/views/Products";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/book',
    component: book
  },
  {
    path: '/Customer',
    component: Customer
  },
  {
    path: "/Cart",
    component: Cart
  },
  {
    path: "/Products",
    component: Products
  }
]

const router = new VueRouter({
  routes
})

export default router
