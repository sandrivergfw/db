<template>
  <div class="common-layout">
    <link href="../../assets/icons/font_2cf2621a7by/iconfont.css">
    <el-container  class="std_container">
      <el-main style="background-color: #f1f1f1">
        <div style="width: 80%;margin: 2% 10% 2% 10%;background-color: #666666">
          <Card style="min-height: 800px">
            <TTabs :placement="placement" :value="value"  @change="handlerChange" >
              <TTabPanel value="first">
                <template #label> <ChatIcon name="comment" class="tabs-icon-margin" />
                  <Badge :count=commentNum >
                  评论
                  </Badge>
                </template>
                <div v-for="item in comments" :key="item.commentId">
                  <Card style="width: 95%;margin-left: 4%" @click="enterProduct">
                  <Comment
                      :avatar="item.avatar"
                      :author="item.ownerName"
                      :datetime="item.outTime"
                      :content="item.content"
                  >
                    <template #actions>
                      <TSpace key="thumbUp" :size="6">
                        <ThumbUpIcon/>
                        <span>{{item.likeNum}}</span>
                      </TSpace>
                      <TSpace key="thumbDown" :size="6">
                        <ThumbDownIcon/>
                        <span>{{item.dislikeNum}}</span>
                      </TSpace>
                      <TSpace key="chat" :size="6">
                        <ChatIcon />
                        <span>回复</span>
                      </TSpace>
                    </template>
                  </Comment>
                  <!--被引用的片段 可以是帖子也可以是个人的评论 这个框里就展示最外层的发布内容或是帖子内容-->
                  <Card style="margin-left: 10%;margin-top: 2%;background-color: #f6f6f6">
                    <el-image
                        :src='item.src'
                        style="width:20%;float: left;margin-left: 2%;margin-top: 2%"
                        fit="scale"
                    />
                    <div style="margin:3%;align-self: center;float:left;width:70%">
                      <span style="font-size: 20px;margin-left:5%;margin-top: 5%"><b>{{ item.title }}</b></span>
                      <TDivider></TDivider>
                      <div style="float: right">
                        <span style="font-size: 8px;color: #969896">{{ item.wantNum }}人想要 &nbsp;&nbsp;</span>
                        <span style="font-size: 8px;color: #969896">{{ item.collectNum}}人收藏 &nbsp;&nbsp;</span>
                        <span style="font-size: 8px;color: #969896">发布于{{ item.productOutTime }}</span>
                      </div>
                    </div>
                  </Card>
                </Card>
                </div>
              </TTabPanel>
              <TTabPanel value="second">
                <template #label> <ThumbUpIcon name="like" class="tabs-icon-margin" />
                  <Badge :count=likeNum >
                  点赞
                  </Badge>
                </template>
                <div v-for="(item,index) in likes" :key="index">
                  <Card style="width: 95%;margin-left: 4%" @click="enterProduct">
                  <Comment
                      :avatar="item.avatar"
                      :author="item.ownerName"
                      :datetime="item.outTime"
                      content="赞了你"
                  >
                  </Comment>
                  <!--被引用的片段 可以是帖子也可以是个人的评论 这个框里就展示最外层的发布内容或是帖子内容-->
                  <Card style="margin-left: 10%;margin-top: 2%;background-color: #f6f6f6">
                    <el-image
                        :src="item.src"
                        style="width:20%;float: left;margin-left: 2%;margin-top: 2%"
                        fit="scale"
                    />
                    <div style="margin:3%;align-self: center;float:left;width:70%">
                      <span style="font-size: 20px;margin-left:5%;margin-top: 5%"><b>{{ item.title }}</b></span>
                      <TDivider></TDivider>
                      <div style="float: right">
                        <span style="font-size: 8px;color: #969896">{{item.wantNum}}}人想要 &nbsp;&nbsp;</span>
                        <span style="font-size: 8px;color: #969896">{{ item.collectNum }}人收藏 &nbsp;&nbsp;</span>
                        <span style="font-size: 8px;color: #969896">发布于{{ item.productOutTime }}</span>
                      </div>
                    </div>
                  </Card>
                </Card>
                </div>
              </TTabPanel>
              <TTabPanel value="third">
                <template #label> <MailIcon name="chat" class="tabs-icon-margin" />
                  <Badge :count=chatNum  @click="turnToChatwindow">
                  聊天
                  </Badge>
                </template>
                <!---聊天-->
                <!---显示近期的聊天窗口--->
                <Card style="width: 85%;margin-left: 5%" shadow="true">
                  <el-avatar :size="70"
                             style="float:left"
                             src-set="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.166.net%2Freunionpub%2Fds%2Fnbot%2F20220919%2F163359-5riwkamfe1.jpeg%3FimageView%26tostatic%3D0%26thumbnail%3D272y272&refer=http%3A%2F%2Fimg.166.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1672717076&t=db399166ffb8ad8879c13e8a20b9d448"
                  />
                  <TSpace direction="vertical" style="margin-left: 1.5%">
                    <div style="margin-top: 5px;">
                      <div style="font-size: 20px;float:left;"><b>Mann</b></div>
                      <div style="float:right;font-size: 10px;margin-right:-10%;color: #969896">昨天 下午11:00</div>
                    </div>
                    <div style="margin-top: 0.5%;">
                      <div style="color: #969896;">There ain't no one in this world you can trust more than yourself. Don't use us as crutches, or you'll die. </div>
                      <Badge count='1' style="float: right ;margin-right: -10%" :offset="[10, -15]"/>
                    </div>
                  </TSpace>
                </Card>

              </TTabPanel>
              <TTabPanel value="forth">
                <template #label> <NotificationIcon name="notification" class="tabs-icon-margin" />
                  <Badge :count=notificationNum >
                    通知
                  </Badge>
                </template>
                <!---通知---->
                <Card style="width: 80%;margin-left:10% ;margin-top: 2%">
                  <el-avatar :size="100"
                             style="float:left"
                             src-set="https://img2.baidu.com/it/u=615401468,2658546862&fm=253&fmt=auto&app=138&f=JPEG?w=256&h=256"
                              />
                  <p style="float: left;margin: 40px 30px;font-size: 18px">TopLapTop正式发布</p>
                  <p style="float:right;margin: 40px ;color: #969896">2022/11/26 &nbsp; 20:32</p>

                </Card>
              </TTabPanel>

            </TTabs>
          </Card>

        </div>
      </el-main>
      <el-footer>
        Powered By Vue3.0
      </el-footer>
    </el-container>
  </div>
</template>

<script lang="ts" >
import {TimeIcon,DiscountIcon,AppIcon,LocationIcon,ThumbUpIcon,ThumbDownIcon,
  UserIcon,UserCircleIcon,UserAddIcon,HeartFilledIcon,
  TimeFilledIcon,HeartIcon,StarFilledIcon,HomeIcon,InternetIcon,LogoWindowsFilledIcon,CircleIcon,StarIcon,ChatIcon,NotificationIcon,MailIcon} from 'tdesign-icons-vue-next'
import {Button as TButton} from 'tdesign-vue-next'
import {Card,Avatar,Swiper,Comment,Tooltip,Badge,Tag,Tabs as TTabs,TabPanel as TTabPanel} from 'tdesign-vue-next'
import {Space as TSpace,Divider as TDivider} from 'tdesign-vue-next'
import { useRouter } from 'vue-router';
import {NH2,NH3,NH4,NH5} from 'naive-ui';
import { ref, unref,defineComponent } from 'vue';
import 'tdesign-vue-next/es/style/index.css'

import App from "@/App.vue";
import {Icon} from "element-ui";
import axios from 'axios';
// 切换页面的路由
export default defineComponent({
  name:"App",
  components:{
    TimeIcon,DiscountIcon,AppIcon,LocationIcon,ThumbUpIcon,ThumbDownIcon,
    UserIcon,UserCircleIcon,UserAddIcon,HeartFilledIcon,
    TimeFilledIcon,HeartIcon,StarFilledIcon,HomeIcon,InternetIcon,LogoWindowsFilledIcon,CircleIcon,StarIcon,ChatIcon,NotificationIcon,MailIcon,
    TButton,Card,Avatar,Swiper,Comment,Tooltip,Badge,Tag,TTabs,TTabPanel,
    TSpace,TDivider,axios
  },
  setup(){
    const router = useRouter();
    const owner =ref({
      id: 1,
      name:"LUCY",
      fans:114514,
      rate:5.0,
      enter_time:"2022/10/01"
    })
    const tj_datas = () => {
      return {
        notices:[],
        news:[],
        real_time_datas:{
          ApiShop_count:0,
          UnReadNews_count:0,
          RunCase_count:0,
          Import_count:0
        },
      }
    }
    // 检查token
    let haveToken = false;
    if (localStorage.getItem("token") != null) {
      haveToken = true;
    }
    const value = ref('first');
    const placement = ref('left');

    const handlerChange = (newValue: string) => {
      value.value = newValue;
    };
    const commentNum = ref(1);
    const likeNum = ref(5);
    const dislikeNum = ref(10);
    const chatNum = ref(10);
    const notificationNum = ref(99);

    const comments = ref([
      {
        commentId:1,
        ownerId:3,
        avatar:"http://ci.xiaohongshu.com/f2f11e87-f9ec-567c-2897-aa67e3ee359c?imageView2/2/w/1080/format/jpg",
        ownerName:"Rebecca",
        outTime: "2077/05/20 21:03" ,//评论发布时间
        content:"Besides you, I got nothing left.But you still have a dream to stick around for. I need you to see it through.That's my dream. Honestly,nothing else ever really mattered",
        likeNum:6,
        dislikeNum:0,
        productId:1,
        src:"https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fi2.hdslb.com%2Fbfs%2Farchive%2Fe40d8896a24a39aa0d5cc84c4c5120da4118bd65.jpg&refer=http%3A%2F%2Fi2.hdslb.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1671712876&t=ee3f70674181a35f2958150a9ccadc09",
        title:"Moon",
        wantNum:100,
        collectNum:700,
        productOutTime:"2077/11/28" //原商品发布时间
      }
    ]);
    const likes=ref([
      {
        ownerId:3,
        avatar:"http://ci.xiaohongshu.com/f2f11e87-f9ec-567c-2897-aa67e3ee359c?imageView2/2/w/1080/format/jpg",
        ownerName:"Rebecca",
        outTime: "2077/05/20 21:03" ,//评论发布时间
        src:"https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fi2.hdslb.com%2Fbfs%2Farchive%2Fe40d8896a24a39aa0d5cc84c4c5120da4118bd65.jpg&refer=http%3A%2F%2Fi2.hdslb.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1671712876&t=ee3f70674181a35f2958150a9ccadc09",
        title:"Moon",
        wantNum:100,
        collectNum:700,
        productOutTime:"2077/11/28" //原商品发布时间
      }
    ])
    function turnToChatwindow(){
      //跳转到聊天页面
    }
    function enterProduct(){
      //传入一个productId然后跳转到该产品所对应的详情页
    }


    return{
      value,
      tj_datas,
      placement,
      handlerChange,
      commentNum,
      likeNum,dislikeNum,chatNum,notificationNum,comments,likes,turnToChatwindow,enterProduct
    }
  },
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