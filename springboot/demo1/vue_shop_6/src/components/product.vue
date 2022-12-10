<template>
  <div class="common-layout">
    <link href="../assets/icons/font_2cf2621a7by/iconfont.css">
    <router-view :key="key"/>
      <el-container>
        <el-main style="background-color: #f1f1f1">
          <div style="margin-left: 10%;margin-top: 30px;height: 80%">
            <Card style="float:left;width: 50%;">
              <Badge count="￥200" :offset="[-40,15]">
                <div style="font-size: 20px;margin-top: 15px;color:#99CCFF"><b>BUAA LAPTOP</b></div>
              </Badge>

              <div class="basicInfo" style="margin-top: 10px">
                <TimeIcon/>
                <a style="color: #8f8f8f;font-size: 10px">&nbsp {{ product.out_time }} &nbsp &nbsp</a>
                <AppIcon/>
                <a style="color: #8f8f8f;font-size: 10px">&nbsp {{ product.type }} &nbsp &nbsp</a>
                <DiscountIcon/>
                <a style="color: #8f8f8f;font-size: 10px">&nbsp {{ product.discount }} &nbsp &nbsp</a>
                <LocationIcon/>
                <a style="color: #8f8f8f;font-size: 10px">&nbsp {{ product.position }} &nbsp &nbsp</a>
              </div>
              <div class="imgshow" style="margin-top: 30px">
                <el-carousel trigger="click">
                  <el-carousel-item v-for="item in product.photo" :key="item.url">
                    <el-image :src="item.url" :fit="'cover'"/>
                  </el-carousel-item>
                </el-carousel>
              </div>
              <div>
                <!--信息展示-->
                <div style="color: #666666;font-size: 20px;margin: 50px 10px 10px 10px">
                  <b>Spesification</b>
                </div>
                <TDivider></TDivider>
                <!--
                <div style="margin-left: 50px;font-size: 15px">

                  <div class="list-info">
                    <CircleIcon />
                    Display : 14 inch Gorilla Glass
                  </div>

                  <div class="list-info">
                    <CircleIcon />
                    Processor : Intel Core i7</div>

                  <div class="list-info">
                    <CircleIcon />
                    Memory : 4GB
                  </div>

                  <div class="list-info">
                    <CircleIcon />
                    Storage : 320 GB
                  </div>

                  <div class="list-info">
                    <CircleIcon />
                    Baterai : Good
                  </div>

                </div> ----->

                <div class="mainIntroduction">
                  {{
                    product.description
                  }}
                </div>
                <TDivider></TDivider>
                <div class="footer-info">
                  <!--收藏产品/留言-->
                  <Popup>
                    <t-button variant="outline"><ChatIcon style="color: #969896" />
                      <span style="font-size: 10px ;color: #969896">留言</span></t-button>
                    <!-- <div slot="content">触发元素是指触发浮层内容显示的元素</div> -->
                    <template #content>
                      <div>
                        <TInput
                            v-model="commentText"
                            style="width: 500px"
                            :maxlength="100"
                            show-limit-number
                            placeholder="限制评论长度100字"
                        ></TInput>
                        <TButton class="sendComment" @click="commentToProduct">发送</TButton>
                      </div>
                    </template>
                  </Popup>
                  <StarIcon id="star" style="float: right;margin:10px" :size="20"
                            v-if="fav"
                            @click="changeFav"/>
                  <StarFilledIcon id="starfilled" style="float: right;margin:10px" :size="20"
                                  v-if="!fav"
                                  @click="changeFav"/>
                </div>
              </div>
            </Card>
            <Card style="float:left;width:25%;height:60% ;margin-left: 30px">
              <div style="color: #6699CC;font-size: 20px;margin-top:15px;margin-bottom: -10px"><b>SELLER</b></div>
              <TDivider></TDivider>
              <div style="align-self: center;float: bottom"  @click="infoShow">
                <el-avatar :size="100"
                           src-set="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.18183.com%2Fuploads%2Fallimg%2F220919%2F462-220919113641-50.jpg%40%2118183&refer=http%3A%2F%2Fimg.18183.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1671506918&t=311b98569dfabfc82a08fddd5680fce7"
                           style="float: left"/>
                <div class="userName" style="float:left;margin-top:40px;margin-left: 10px;font-size: 25px;color: #333366">{{owner.name}}</div>
              </div>
              <div style="margin-top: 150px;align-content: center">
                <HeartFilledIcon :size="20" style="margin: 10px"/>
                <a>&nbsp 粉丝数：{{ owner.fans }} &nbsp &nbsp</a>
                <br>
                <TimeFilledIcon :size="20" style="margin: 10px"/>
                <a>&nbsp 加入时间： {{ owner.enter_time }} &nbsp &nbsp</a>
                <br>
                <StarFilledIcon :size="20" style="margin: 10px" />
                <a>&nbsp 信誉评分：{{owner.rate}} &nbsp &nbsp</a>
                <br>
                <HomeIcon :size="20" style="margin: 10px"/>
                <a @click="infoShow" style="color: #3962b0">&nbsp more &nbsp &nbsp</a>
                <div style="margin-bottom: 10px"></div>
                <TButton variant="outline" theme="primary" v-if="!isFollow" @click="follow()">
                  &nbsp; &nbsp; &nbsp; &thinsp; +关注  &nbsp; &nbsp; &nbsp; &nbsp; &thinsp;
                </TButton>
                <TButton  theme="primary" v-if="isFollow" @click="follow()">
                  &nbsp; &nbsp; &nbsp; &thinsp; 已关注  &nbsp; &nbsp; &nbsp; &nbsp; &thinsp;
                </TButton>
                <TButton variant="outline" theme= "warning" style="float: right" @click="turnToChat">
                  &nbsp; &nbsp; &nbsp; &nbsp; &thinsp; 对话 &nbsp; &nbsp; &nbsp; &nbsp; &thinsp;
                </TButton>
              </div>


            </Card>
            <Card style="float:left;width:15%;height:30% ;margin-left: 30px">
              <div style="color:#FFCC99;font-size: 20px;margin-top:15px;margin-bottom: -10px"><b>LABEL</b></div>
              <TDivider></TDivider>
              <Tag
                  style="margin: 5px"
                  shape ="round"
                  size="large"
                  v-for="(tag, index) in tags"
                  :key="index"
                  :theme="tag.type"
                  :closable="tag.showClose"
              >
                {{ tag.name }}
              </Tag>
            </Card>
          </div>

          <!----评论区-->
          <Card style="margin-left: 10%;margin-top: 30px;margin-bottom:60px;float:left;width: 45%; min-height: 40%">
            <div style="color: #666699;font-size: 20px;margin: 30px 10px 10px 10px">
              <b>COMMENTS</b>
            </div>
            <TDivider></TDivider>
            <div v-for="item in comments" :key="item.commentId">
              <Comment
                :avatar='item.avatar'
                :author='item.author'
                :datetime='item.datetime'
                :content="item.content"
            >
              <template #actions>
                <Space key="thumbUp" :size="6" @click="likeComment">
                  <ThumbUpIcon/>
                  <span>{{item.like}}</span>
                </Space>
                <Space key="thumbDown" :size="6" @click="dislikeComment">

                  <ThumbDownIcon/>
                  <span>{{item.dislike}}</span>
                </Space>
                <Space key="chat" :size="6">
                  <Popup>
                    <t-button variant="outline"><ChatIcon style="color: #969896" />
                      <span style="font-size: 10px ;color: #969896">回复</span></t-button>
                    <!-- <div slot="content">触发元素是指触发浮层内容显示的元素</div> -->
                    <template #content>
                      <div>
                        <TInput
                            v-model="commentText"
                            style="width: 500px"
                            :maxlength="100"
                            show-limit-number
                            placeholder="限制评论长度100字"
                        ></TInput>
                        <TButton class="sendComment" @click="commentToProduct">发送</TButton>
                      </div>
                    </template>
                  </Popup>
                </Space>
              </template>
            </Comment>
              <Comment v-for="item2 in childComments" :key="item2.commentId"
                     :avatar='item2.avatar'
                     :author='item2.author'
                     :datetime='item2.datetime'
                     :content="item2.content"
                     style="padding-left: 80px;padding-bottom: 20px"
            >
              <template #actions>
                <Space key="thumbUp" :size="6" @click="like">
                  <ThumbUpIcon/>
                  <span>{{item.like}}</span>
                </Space>
                <Space key="thumbDown" :size="6" @click="dislike">
                  <ThumbDownIcon/>
                  <span>{{item.dislike}}</span>
                </Space>
                <Space key="chat" :size="6">
                  <Popup>
                    <t-button variant="outline"><ChatIcon style="color: #969896" />
                      <span style="font-size: 10px ;color: #969896">回复</span></t-button>
                    <!-- <div slot="content">触发元素是指触发浮层内容显示的元素</div> -->
                    <template #content>
                      <div>
                        <TInput
                            v-model="commentText"
                            style="width: 500px"
                            :maxlength="100"
                            show-limit-number
                            placeholder="限制评论长度100字"
                        ></TInput>
                        <TButton class="sendComment" @click="commentToComment">发送</TButton>
                      </div>
                    </template>
                  </Popup>
                </Space>
              </template>
            </Comment>
            </div>
          </Card>

        </el-main>
        <el-footer>
          Powered By Vue3.0
        </el-footer>
      </el-container>
  </div>
</template>

<script lang="ts">
import {
  ArrowDown,
  Check,
  CircleCheck,
  CirclePlus,
  CirclePlusFilled,
  Plus,
} from '@element-plus/icons-vue'
import { manifest } from 'tdesign-icons-vue-next/lib/manifest'

import {Button as TButton,Icon as TIcon,Input as TInput} from 'tdesign-vue-next'
import {} from 'tdesign-vue-next'
import {Space as TSpace,Divider as TDivider,Popup,Textarea} from 'tdesign-vue-next'
import { useRouter } from 'vue-router';
import {NH2,NH3,NH4,NH5} from 'naive-ui';
import { ref, unref } from 'vue';
import 'tdesign-vue-next/es/style/index.css'
import 'tdesign-vue-next'
import 'tdesign-icons-vue-next'

import App from "@/App.vue";
import {Avatar , Badge , Card , Divider , Tag , Tooltip , Space ,Swiper, Comment} from "tdesign-vue-next";

// 切换页面的路由
// 检查token

import { computed,defineComponent} from "vue"
import {$ref} from "vue/macros";
import {TimeIcon,DiscountIcon,AppIcon,LocationIcon,ThumbUpIcon,ThumbDownIcon,HeartFilledIcon,
  TimeFilledIcon,StarFilledIcon,HomeIcon,StarIcon,ChatIcon} from "tdesign-icons-vue-next";

export default defineComponent({
  name:"App",
  components: {
    ThumbUpIcon,
    ThumbDownIcon,
    HomeIcon,
    TimeFilledIcon,
    HeartFilledIcon, StarFilledIcon, StarIcon, ChatIcon, LocationIcon, DiscountIcon, AppIcon, TimeIcon,
    Card,Avatar,Swiper,Comment,Tooltip,Badge,Tag,
    Space,TDivider,Popup,Textarea,TButton,TInput,TIcon
  },
  setup(){
    const isFollow= ref(false);
    const followMsg = ref("+关注");
    const router = useRouter()
    let haveToken = false;
    const commentText = ref("");
    if (localStorage.getItem("token") != null) {
      haveToken = true;
    }
    const imgwarp = ref([
      {url:require("../assets/pictures/laptops/1.jpg")},
      {url:require("../assets/pictures/laptops/2.jpg")},
      {url:require("../assets/pictures/laptops/3.jpg")},
      {url:require("../assets/pictures/laptops/4.jpg")},
      {url:require("../assets/pictures/laptops/5.jpg")},
      {url:require("../assets/pictures/laptops/6.jpg")},
    ])
    const tags = ref([
      {
        name: 'label1',
        type: 'primary',
      },
      {
        name: 'label2',
        type: 'success',
      },
      {
        name: 'label3',
        type: 'warning', //返回标签名和对应的类型，不同的类型对应了不同的基本type类型
      },
    ]);
    const product = ref({
      id: 1,
      title: "TITLE",
      photo: [
        {url: "https://img1.baidu.com/it/u=1993906374,404731341&fm=253&fmt=auto&app=120&f=JPEG?w=640&h=340"},
        {url: "https://img1.baidu.com/it/u=4249977665,2401571261&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500"},
        {url: "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpicnew10.photophoto.cn%2F20160605%2Fbijibendiannaoyangjishejisucai-24698904_1.jpg&refer=http%3A%2F%2Fpicnew10.photophoto.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1672106021&t=f4652fb42d727d28e30ec333c1a01478"},
      ],
      price: 10000,
      out_time: "2022/11/20",
      type: "desktop",
      discount: '90%',
      position: "学院路",
      description: "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium,\n" +
          "                totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.\n" +
          "                Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt.\n" +
          "                Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit,\n" +
          "                sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem.\n" +
          "                Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur?\n" +
          "                Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur,\n" +
          "                vel illum qui dolorem eum fugiat quo voluptas nulla pariatur",
      ownerId: 1,
    });
    const owner =ref({
      id: 1,
      name:"LUCY",
      fans:114514,
      rate:5.0,
      enter_time:"2022/10/01"
    })
    const comments=ref([
      {
        commentId:1,
        avatar:"http://ci.xiaohongshu.com/7a582653-7d9c-4b91-9e0e-5cf7f1f0f4ab?imageView2/2/w/1080/format/jpg",
        author:"lucy",
        datetime:"2077/05/20 21:05",
        content:"This is it. It's the end of the line for me. But not for you. Fast is what you do best, ain't it? Now, run.",
        like:6,
        dislike:0,
        child_comments:10, //下属评论个数
      },
      {
        commentId:2,
        avatar:"http://ci.xiaohongshu.com/f2f11e87-f9ec-567c-2897-aa67e3ee359c?imageView2/2/w/1080/format/jpg",
        author:"Rebecca",
        style:"padding-left: 80px ;margin-right: 50px",
        datetime:"2077/05/20 21:03",
        content:"Besides you, I got nothing left.But you still have a dream to stick around for. I need you to see it through.That's my dream. Honestly,nothing else ever really mattered.",
        like:10,
        dislike: 2,
        child_comments: 0
      }
    ])
    const childComments = ref([
      {
        commentId: 1,
        avatar: "http://ci.xiaohongshu.com/7a582653-7d9c-4b91-9e0e-5cf7f1f0f4ab?imageView2/2/w/1080/format/jpg",
        author: "lucy",
        datetime: "2077/05/20 21:05",
        content: "This is it. It's the end of the line for me. But not for you. Fast is what you do best, ain't it? Now, run.",
        like: 6,
        dislike: 0,
        child_comments: 10, //下属评论个数
      },
    ]);
    function infoShow(){
      // window.location.reload()
      router.push({
        path:'/userPage/infoShow'
      })
    }
//user是否收藏 初始化的时候从数据库中得到
    const fav = ref(false) ;
    function changeFav(){
      console.log("111")
      fav.value=!fav.value;
      console.log(fav.value);
    }
    function commentToProduct(){
      //发表对产品的评价 获取到输入框内容并更新数据库 同时产生新的通知
      console.log(commentText.value);//输出评论文字
    }
    function likeComment(){
      //根据commentId和userId对数据库更新 产生新的通知
    }
    function dislikeComment(){
      //同上
    }
    function commentToComment(){
      //发表对评论的评价 获取到输入框内容并更新数据库 同时产生新的通知
    }
    function turnToChat(){
      //跳转到对话的路由页面
    }
    const follow = ()=>{
      if (isFollow.value){
        followMsg.value= "+关注";
      }else {
        followMsg.value="已关注";
      }
      isFollow.value=!isFollow.value;
      console.log(followMsg.value);
    }

    return {
      isFollow,
      followMsg,
      commentText,
      follow,
      router,
      imgwarp,
      tags,
      product,
      owner,
      comments,
      childComments,
      infoShow,
      fav,
      changeFav,
      commentToProduct,
      commentToComment,
      likeComment,
      dislikeComment,
      turnToChat
    }
  }
})

</script>

<style lang="less" scoped>
// 最外部element plus框架 ******************************************
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
.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 150px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}
.list-info{
  font-size: 15px;
  margin-bottom: 5px;
}
.mainIntroduction{
  margin: 30px 20px 20px 20px;
  line-height: 30px;
  text-indent:2em;
}
.paragraph{
  text-indent: 2em;
}
.sendComment{
  margin-left: 72% ;
  margin-top: 2%;
  float: right;
}
</style>