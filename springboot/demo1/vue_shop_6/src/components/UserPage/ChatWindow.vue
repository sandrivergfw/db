<template>
  <div class="common-layout">
    <link href="../../assets/icons/font_2cf2621a7by/iconfont.css">
    <el-container  class="std_container">
      <el-main style="background-color: #f1f1f1;height: 100%">
        <Card style="min-height: 650px ;width: 80%;margin-left: 10%" shadow="true">
          <!--加一个顶栏--->
          <div style="font-size: 30px;margin-top:15px;margin-bottom: -10px">
            <ArrowLeftIcon size="30"/>
            <b>&nbsp;Rebeca</b>
          </div>
          <TDivider></TDivider>
          <div style="min-height: 300px">
            <!---展示对话信息-->
            <!---一个消息框-->
            <div style="height: 70px ;width: auto;">
              <el-avatar
                  :size="80"
                  src-set="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fi0.hdslb.com%2Fbfs%2Farchive%2F926103a2fd1c572dd781c4e30612b83faf63b30d.jpg&refer=http%3A%2F%2Fi0.hdslb.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1672477125&t=40f347c5f6511222ff21d053815ac77e"
                  style="float: left;margin-left: 1% ;margin-right: 1%"/>
              <div style="padding-top: 0.5% ;margin-left: 1%;font-size: 5px;color: #969896;">@17:39pm</div>

              <div style="width: auto;">

              </div>
              <Card class="divWidth" shadow="true" >
                你个傻逼
              </Card>

            </div>
            <div style="height: 70px ;width: auto;">
              <el-avatar
                  :size="80"
                  src-set="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fi2.hdslb.com%2Fbfs%2Farchive%2Fb804ff527bc778d14bdfc21959ea694afe4ee05b.jpg&refer=http%3A%2F%2Fi2.hdslb.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1672477125&t=06b4410d9d2deaa68571b292a52c1e60"
                  style="float: right;margin-left: 1% ;margin-right: 1%"/>
              <div style="">
                <div style="padding-top: 0.5% ;margin-left: 85%;font-size: 5px;color: #969896;">@17:39pm</div>

                <Card class="divWidth" shadow="true" style="float: right">
                  你才傻逼
                </Card>
              </div>


            </div>


          </div>
          <TDivider></TDivider>
          <TSpace direction="vertical">
            <Textarea
                v-model="input1"
                placeholder="请遵守社区公约，文明交流"
                name="description"
                :autosize="{ minRows: 7, maxRows: 20}"
                style="width:1170px"
            />
            <TButton style="float:right;">发送</TButton>
          </TSpace>
        </Card>
      </el-main>
      <el-footer>
        Powered By Vue3.0
      </el-footer>
    </el-container>
  </div>
</template>

<script lang="ts" >

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
  name:"App",
  components:{
    TMenu,TMenuItem,Card,TInput,Avatar,Swiper,Comment,Tooltip,Badge,Tag,TTabs,TTabPanel,TDivider,ArrowLeftIcon,
    TSpace,Textarea,TButton
  },
  setup(){
    // 检查token
    const input1= ref("");
    let haveToken = false;
    if (localStorage.getItem("token") != null) {
      haveToken = true;
    }
    const people = ref([
      {
        customerId:1,
        customerName:"badMan",
        avatar:"https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg9.doubanio.com%2Fview%2Fphoto%2Fl%2Fpublic%2Fp2880821536.jpg&refer=http%3A%2F%2Fimg9.doubanio.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1672477044&t=f7524959c2f750e957ed134ef9d57984",
      },
      {
        customerId: 2,
        customerName: "rebeca",
        avatar: "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fi0.hdslb.com%2Fbfs%2Farchive%2F926103a2fd1c572dd781c4e30612b83faf63b30d.jpg&refer=http%3A%2F%2Fi0.hdslb.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1672477125&t=40f347c5f6511222ff21d053815ac77e",
      }
    ])
    //实时获取到信息
    const messages = () => {
      return getData();
    }
    function getData(){
      $.ajax({
        method:"post",
        url:"",//目标url
        timeout:50000,
        success:function (data: any){
          console.log(data);
          getData();
        },
        error:function (res: any){
          getData();
        }
      })
    }
    return{
      people,
      input1,
      messages,
      getData
    }
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
.divWidth{
  margin-top: 1%;
  display: inline-block;
  width: auto;
  min-width: 80px;
  max-width: 30%;
  word-break: break-all;
  word-wrap: break-word //自动换行
}
.chat-content{
  width: 100%;
  padding: 20px;
  .word{
    display: flex;
    margin-bottom: 20px;
    img{
      width: 40px;
      height: 40px;
      border-radius: 50%;
    }
    .info{
      margin-left: 10px;
      .time{
        font-size: 12px;
        color: rgba(51,51,51,0.8);
        margin: 0;
        height: 20px;
        line-height: 20px;
        margin-top: -5px;
      }
      .info-content{
        padding: 10px;
        font-size: 14px;
        background: #fff;
        position: relative;
        margin-top: 8px;
      }
      //小三角形
      .info-content::before{
        position: absolute;
        left: -8px;
        top: 8px;
        content: '';
        border-right: 10px solid #FFF;
        border-top: 8px solid transparent;
        border-bottom: 8px solid transparent;
      }
    }
  }

  .word-my{
    display: flex;
    justify-content:flex-end;
    margin-bottom: 20px;
    img{
      width: 40px;
      height: 40px;
      border-radius: 50%;
    }
    .info{
      width: 90%;
      margin-left: 10px;
      text-align: right;
      .time{
        font-size: 12px;
        color: rgba(51,51,51,0.8);
        margin: 0;
        height: 20px;
        line-height: 20px;
        margin-top: -5px;
        margin-right: 10px;
      }
      .info-content{
        max-width: 70%;
        padding: 10px;
        font-size: 14px;
        float: right;
        margin-right: 10px;
        position: relative;
        margin-top: 8px;
        background: #A3C3F6;
        text-align: left;
      }
      //小三角形
      .info-content::after{
        position: absolute;
        right: -8px;
        top: 8px;
        content: '';
        border-left: 10px solid #A3C3F6;
        border-top: 8px solid transparent;
        border-bottom: 8px solid transparent;
      }
    }
  }

}
</style>