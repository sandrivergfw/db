# JwChat

<!-- <p align="center">
  <a href="https://gitee.com/CodeGI/chat" rel="nofollow">
    <img src="https://img.shields.io/badge/JwChat-NPM-red" alt="JwChat css js vue 聊天组件">
  </a>
</p> -->

#### 介绍

**一款基于Vue和ElementUI极简的聊天框组件**
本项目是一款极简的数据驱动为主的聊天框组件。
新增表情包可自动匹配微信表情。
新增聊天窗口配置组件，可以自由配置 顶部状态栏 和 右侧信息栏

![](https://img-blog.csdnimg.cn/20210307230254986.gif)


![](https://img-blog.csdnimg.cn/20210307230254368.gif)

#### 安装

* 使用 `npm` 安装

  ``` bash
  npm install jwchat
  ```

* 使用 `yarn` 安装

  ``` bash
  yarn add jwchat
  ```

#### 使用

1. 因为本组件是基于 `element-ui` 开发。首先需要引入  `element-ui`。

   ```bash
   npm install element-ui
   ```

2. 在 `main.js` 中引入组件

   ``` js
   import ElementUI from 'element-ui';
   import 'element-ui/lib/theme-chalk/index.css';
   Vue.use(ElementUI);
   
   import Chat from 'jwchat';
   /* 在 0.2.041 之前的版本需要引入 css */
   // import 'jwchat/lib/JwChat.css';
   Vue.use(Chat)
   ```

3. 在 `*.vue` 中引入

   ``` vue
   <JwChat-index
        :taleList="list"
        @enter="bindEnter"
        v-model="inputMsg"
        :toolConfig="tool"
    />
   ```
   
#### 文档
* [**官方文档**](https://codegi.gitee.io/jwchatdoc/)

#### 跟新公告

- `/ 修改` 样式优化

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request

#### 推荐项目

* [AVue](https://avuejs.com/) **本代码借鉴项目**
* [JPower](https://gitee.com/gdzWork/JPower)

#### 交流学习

* QQ群 ：235689934