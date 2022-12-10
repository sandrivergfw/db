import { createApp } from 'vue'
import App from './App.vue'
// 使用router路由
import router from './router'
// 使用ElementPlus
import ElementPlus from 'element-plus'
import 'element-ui/lib/theme-chalk/index.css'
import 'element-plus/dist/index.css'
import axios from "axios";
import JwChat from 'jwchat';
import TDesigner from 'tdesign-vue-next'

// 导入字体图标
import './assets/icons/font_2cf2621a7by/iconfont.css'
// 导入全局样式
import './assets/css/global.css'

// 设置与向后端axios拦截发送token
axios.interceptors.request.use(
    config => {
        if (localStorage.getItem('token')) {
            // @ts-ignore
            config.headers.token = localStorage.getItem('token');
        }
        return config;
    },
    error => {
        return Promise.reject(error);
    });


const app = createApp(App)
app.use(router)
app.use(ElementPlus)
app.use(JwChat)
app.mount('#app')
