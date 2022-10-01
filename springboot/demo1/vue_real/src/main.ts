import { createApp } from 'vue'
import App from './App.vue'
// 使用router路由
import router from './router'
// 使用ElementPlus
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

// 导入字体图标
import './assets/icons/font_2cf2621a7by/iconfont.css'
// 导入全局样式
import './assets/css/global.css'

const app = createApp(App)
app.use(router)
app.use(ElementPlus)
app.mount('#app')
