<template>
  <div class="common-layout">
    <link href="../assets/icons/font_2cf2621a7by/iconfont.css">
    <el-container  class="std_container">
      <el-main style="background-color: #f1f1f1;height: 100%">
        <div style="width: 80%;margin-left: 10%;background-color: #0e0e33;min-height: 700px">
          <!--背景图-->
          <div style="z-index: 9999; padding:5% 5% 5% 5%">
            <!---基本信息--->
            <el-avatar shape="square"
                       style="float: left"
                       :size="80"
                       src="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Ftva1.sinaimg.cn%2Flarge%2F0073YlnVgy1h656jq0s46j312e0kqamu.jpg&refer=http%3A%2F%2Ftva1.sinaimg.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1672772283&t=fa9a6577f820e002b5edbaa9da075945"/>

            <TSpace direction="vertical" style="margin-left: 2%">
              <div style="font-size: 25px;color: #e8e8e8"><b>BUAA</b> &nbsp;<span style="font-size: 15px">with 10w人</span></div>
              <div style="color: #9f9f9f;font-size: 15px">
                <el-avatar
                           style="float: left"
                           :size="30"
                           src="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Ftva1.sinaimg.cn%2Flarge%2F0073YlnVgy1h656jq0s46j312e0kqamu.jpg&refer=http%3A%2F%2Ftva1.sinaimg.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1672772283&t=fa9a6577f820e002b5edbaa9da075945"/>

                圈主@匿蝶:"查询大学生精神状态"
              </div>
            </TSpace>
            <TButton style="float:right;margin-right: 5%;color: #3d50fc" shape="round" variant="outline" theme="default">加入</TButton>
          </div>
          <Card style=";min-height: 500px">
            <div>
              <el-avatar
                         style="float: left"
                         :size="50"
                         src="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Ftva1.sinaimg.cn%2Flarge%2F0073YlnVgy1h656jq0s46j312e0kqamu.jpg&refer=http%3A%2F%2Ftva1.sinaimg.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1672772283&t=fa9a6577f820e002b5edbaa9da075945"/>

              <TSpace direction="vertical" style="margin-left: 2%">
                <div style="font-size: 20px;margin-bottom: -5px">tomato</div>
                <div style="font-size: 10px; color: #969896">
                   发布于2022/12/5 03:22
                </div>
              </TSpace>
              <div>
                <div class="description" style="margin-top: 20px">
                  这是一篇内容
                </div>
                <el-image
                    src="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fi1.hdslb.com%2Fbfs%2Farchive%2Fed1e73bbaf9be4973c9cbc7c101468794a1d0917.jpg&refer=http%3A%2F%2Fi1.hdslb.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1672772283&t=c41b2d15ff6eddf485a0086c1e39850a"
                    fit="cover"
                    style="height:250px;width: 80% ;margin:1% 20% 0 0"
                />
                <div style="margin-top: 1%;margin-bottom: 2%">
                  <TInput style="width: 70% ;float: left;margin-right: 30px"/>
                  <TButton shape="round">发送</TButton>
                  <div style="float:right;margin-right: 3% ;color: #3c4677;">
                    <ChatIcon size="20"/>
                    <span>10 &nbsp;&nbsp;&nbsp;&nbsp;</span>
                    <ThumbUpIcon size="20"/>
                    <span>90 &nbsp;</span>
                  </div>
                </div>


              </div>
              <TDivider></TDivider>
            </div>
          </Card>
        </div>
      </el-main>
      <el-footer>
        Powered By Vue3.0
      </el-footer>
    </el-container>
  </div>
</template>

<script lang="ts">

import {TimeIcon,DiscountIcon,AppIcon,LocationIcon,ThumbUpIcon,ThumbDownIcon,
  UserIcon,UserCircleIcon,UserAddIcon,HeartFilledIcon,ArrowLeftIcon,
  TimeFilledIcon,HeartIcon,StarFilledIcon,HomeIcon,InternetIcon,LogoWindowsFilledIcon,CircleIcon,StarIcon,ChatIcon,NotificationIcon,MailIcon} from 'tdesign-icons-vue-next'
import {Button as TButton} from 'tdesign-vue-next'
import {Card,Avatar,Swiper,Comment,Tooltip,Badge,Tag,Tabs as TTabs,TabPanel as TTabPanel} from 'tdesign-vue-next'
import {Space as TSpace,Textarea,Divider as TDivider,Menu as TMenu,MenuItem as TMenuItem,Input as TInput} from 'tdesign-vue-next'
import { useRouter } from 'vue-router';
import {NH2,NH3,NH4,NH5} from 'naive-ui';
import {defineComponent, ref, unref} from 'vue';
import 'tdesign-vue-next/es/style/index.css'

import App from "@/App.vue";
import {Icon} from "element-ui";
// 切换页面的路由
const router = useRouter()
export default defineComponent({
  name: "App",
  components: {
    ThumbUpIcon,
    ChatIcon,
    TMenu,
    TMenuItem,
    Card,
    TInput,
    Avatar,
    Swiper,
    Comment,
    Tooltip,
    Badge,
    Tag,
    TTabs,
    TTabPanel,
    TDivider,
    ArrowLeftIcon,
    TSpace,
    Textarea,
    TButton
  },
  setup() {
  }
})
</script>

<style lang="less" scoped>
.common-layout {
  height: 100%;
}

// 主体 ******************************************
   .el-main {
     height: 1000px;
     padding: 0;
   //background-image: url('../assets/pictures/background1.jpg');
   //background-image: linear-gradient(to bottom right, #3d50fc, #7AFFAF);
     background-color: rgb(255, 255, 255);
     background-position: center;
   }

// 页脚 ******************************************
   .el-footer {
     background-color: rgb(0, 0, 0);
     text-align: center;
     color: rgb(216, 212, 212);
   }
</style>