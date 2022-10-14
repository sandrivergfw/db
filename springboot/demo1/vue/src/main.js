import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import './assets/global.css'
import axios from 'axios'
import request from "@/utils/request";  //引入全局css

Vue.config.productionTip = false

Vue.use(ElementUI,{size:"small"});

Vue.prototype.request = request
new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
