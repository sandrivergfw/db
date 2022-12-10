<template xmlns:data-app="http://www.w3.org/1999/xhtml">
  <div class="common-layout">
    <link href="../assets/icons/font_2cf2621a7by/iconfont.css">
    <el-container  class="std_container">
      <el-main style="background-color: #f1f1f1;height: 100%">

          <div style="width: 80%;margin-left: 10%;background-color: #ffffff;min-height: 700px;float: left" >
            <div style="height: 50px;background-color:  #4e91f5;color: #e7e4e4;text-align: center">
            <div style="padding-top: 15px">
              没有找到感兴趣的圈子？不如自己创建一个！

              <TDialog
                  v-model:visible="visible"
                  attach="#app"
                  header="创建圈子"
                  destroy-on-close
                  confirm-btn="确认创建"
                  cancel-btn="关闭"
                  :on-confirm="onConfirm"
                  :on-close="close"
                >
                <template #body>
                  <el-form  id="app">
                    <el-form-item label="圈名" >
                      <el-input autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="分类" >
                      <el-select  placeholder="请选择活动区域">
                        <el-option label="区域一" value="shanghai"></el-option>
                        <el-option label="区域二" value="beijing"></el-option>
                      </el-select>
                    </el-form-item>
                    <el-form-item label="个性宣言" >
                      <el-input autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="上传圈子头像" >
                      <el-input autocomplete="off"></el-input>
                    </el-form-item>
                  </el-form>
                  <div>我是被挂载到body元素的对话框</div>
                  <div>我是内容</div>
                  <div>我是内容</div>
                  <div>我是内容</div>
                  <div>我是内容</div>
              </template>
              </TDialog>

              <TButton style="float:right;margin-top: -5px;margin-right: 5%;color: #3d50fc" shape="round" variant="outline" theme="default" @click="visible = true">我要创建</TButton>
            </div>
            </div>
            <TTabs :placement="placement" :value="value"  @change="handlerChange" >
              <TTabPanel value="first">
                <template #label>
                  &nbsp;推荐&nbsp;
                </template>

                <Card style="height: 150px;width: 96%;margin: 1% 2% "  shadow="true">
                  <div style="padding-top: 18px">
                    <!---基本信息--->
                    <el-avatar shape="square"
                               style="float: left"
                               :size="80"
                               src="https://img0.baidu.com/it/u=3949167345,1106147299&fm=253&fmt=auto&app=120&f=JPEG?w=888&h=500"
                    />

                    <TSpace direction="vertical" style="margin-left: 2%">
                      <div style="font-size: 20px;color: #050505">客制化小白聚集地 &nbsp;</div>
                      <div >
                        <TSpace direction="horizontal" >
                          <TavatarGroup>
                            <Avatar  image="https://img2.baidu.com/it/u=3974060588,2848759048&fm=253&fmt=auto&app=120&f=JPEG?w=800&h=500"/>
                            <Avatar image="https://img0.baidu.com/it/u=620845691,3278768172&fm=253&fmt=auto&app=120&f=JPEG?w=800&h=500"/>
                            <Avatar >+1</Avatar>
                          </TavatarGroup>
                          <div style="color: #646363;font-size: 13px;margin-top: 8px">"欢迎每一位发烧友"</div>
                        </TSpace>
                      </div>
                    </TSpace>
                    <TButton style="float:right;margin-right: 5%;color: #3d50fc" shape="round" variant="outline" theme="default">加入</TButton>
                  </div>
                </Card>
                <Card style="height: 150px;width: 96%;margin: 1% 2% "  shadow="true">
                  <div style="padding-top: 18px">
                    <!---基本信息--->
                    <el-avatar shape="square"
                               style="float: left"
                               :size="80"
                               src="https://img0.baidu.com/it/u=3949167345,1106147299&fm=253&fmt=auto&app=120&f=JPEG?w=888&h=500"
                    />

                    <TSpace direction="vertical" style="margin-left: 2%">
                      <div style="font-size: 20px;color: #050505">客制化小白聚集地 &nbsp;</div>
                      <div >
                        <TSpace direction="horizontal" >
                          <TavatarGroup>
                            <Avatar  image="https://img2.baidu.com/it/u=3974060588,2848759048&fm=253&fmt=auto&app=120&f=JPEG?w=800&h=500"/>
                            <Avatar image="https://img0.baidu.com/it/u=620845691,3278768172&fm=253&fmt=auto&app=120&f=JPEG?w=800&h=500"/>
                            <Avatar >+1</Avatar>
                          </TavatarGroup>
                          <div style="color: #646363;font-size: 13px;margin-top: 8px">"欢迎每一位发烧友"</div>
                        </TSpace>
                      </div>
                    </TSpace>
                    <TButton style="float:right;margin-right: 5%;color: #3d50fc" shape="round" variant="outline" theme="default">加入</TButton>
                  </div>
                </Card>
                <Card style="height: 150px;width: 96%;margin: 1% 2% "  shadow="true">
                  <div style="padding-top: 18px">
                    <!---基本信息--->
                    <el-avatar shape="square"
                               style="float: left"
                               :size="80"
                               src="https://img0.baidu.com/it/u=3949167345,1106147299&fm=253&fmt=auto&app=120&f=JPEG?w=888&h=500"
                    />

                    <TSpace direction="vertical" style="margin-left: 2%">
                      <div style="font-size: 20px;color: #050505">客制化小白聚集地 &nbsp;</div>
                      <div >
                        <TSpace direction="horizontal" >
                          <TavatarGroup>
                            <Avatar  image="https://img2.baidu.com/it/u=3974060588,2848759048&fm=253&fmt=auto&app=120&f=JPEG?w=800&h=500"/>
                            <Avatar image="https://img0.baidu.com/it/u=620845691,3278768172&fm=253&fmt=auto&app=120&f=JPEG?w=800&h=500"/>
                            <Avatar >+1</Avatar>
                          </TavatarGroup>
                          <div style="color: #646363;font-size: 13px;margin-top: 8px">"欢迎每一位发烧友"</div>
                        </TSpace>
                      </div>
                    </TSpace>
                    <TButton style="float:right;margin-right: 5%;color: #3d50fc" shape="round" variant="outline" theme="default">加入</TButton>
                  </div>
                </Card>
              </TTabPanel>
              <TTabPanel value="second">
                <template #label>
                  &nbsp;电脑&nbsp;
                </template>

              </TTabPanel>
              <TTabPanel value="third">
                <template #label>
                  &nbsp;键鼠&nbsp;
                </template>
                内容3

              </TTabPanel>
              <TTabPanel value="forth">
                <template #label>
                  &nbsp;耳机&nbsp;
                </template>
                <!---通知---->
                内容
              </TTabPanel>
            </TTabs>
          </div>



      </el-main>
      <el-footer>
        Powered By Vue3.0
      </el-footer>
    </el-container>
  </div>
</template>

<script lang="ts">

import {TimeIcon,DiscountIcon,AppIcon,LocationIcon,ThumbUpIcon,AddIcon,ThumbDownIcon,
  UserIcon,UserCircleIcon,UserAddIcon,HeartFilledIcon,ArrowLeftIcon,
  TimeFilledIcon,HeartIcon,StarFilledIcon,HomeIcon,InternetIcon,LogoWindowsFilledIcon,CircleIcon,StarIcon,ChatIcon,NotificationIcon,MailIcon} from 'tdesign-icons-vue-next'
import {Button as TButton} from 'tdesign-vue-next'
import {Dialog as TDialog,Card,Avatar,Swiper,Comment,Tooltip,Badge,Tag,Tabs as TTabs,TabPanel as TTabPanel,AvatarGroup as TavatarGroup} from 'tdesign-vue-next'
import {Space as TSpace,Textarea,Divider as TDivider,Menu as TMenu,MenuItem as TMenuItem,Input as TInput} from 'tdesign-vue-next'
import { useRouter } from 'vue-router';
import {NH2,NH3,NH4,NH5} from 'naive-ui';
import {defineComponent, ref, unref} from 'vue';
import 'tdesign-vue-next/es/style/index.css'

import App from "@/App.vue";
import {Icon} from "element-ui";
export default defineComponent({
  name: "App",
  components: {
    TDialog,
    ThumbUpIcon,
    AddIcon,
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
    TButton,
    TavatarGroup
  },
  setup() {
    const value = ref('first');
    const placement = ref('left');
    const visible = ref(false);

    const close = () => {
      visible.value = false;
    };

    const handlerChange = (newValue: string) => {
      value.value = newValue;
    };
    function handleClose() {
      visible.value=false;
    }
    function onConfirm() {
      visible.value=false;
      alert('成功创建~');
    }
    return{
      value,
      placement,
      handlerChange,
      visible,
      close,
      handleClose,
      onConfirm
    }
  }
})
</script>

<style scoped lang="less">
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