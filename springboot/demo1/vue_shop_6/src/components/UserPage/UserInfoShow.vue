<template>
  <div class="common-layout">
    <link href="../../assets/icons/font_2cf2621a7by/iconfont.css">
    <el-container>
      <el-main style="background-color: #f1f1f1">
        <div class="mainColumn" style="width: 80%;margin: 2% 10% 0 10%;float: left">
          <div class="blockTop">
            <!---第一部分-->
            <Card >
              <div style="height: 200px ;background-color: #666699">
                <!---背景图-->
                <el-image
                    :src="customer.backGroundImg"
                   fit="cover"
                    style="height: 200px ;width: 100%"
                />
              </div>
              <div style="height: 100px;width: 100%">
                <!---背景图-->
                <el-avatar
                    :size="130"
                    :src-set="customer.avatar"
                    style="float: left;margin-top:10px;margin-left: 10%"/>
                <div style="float:left">
                  <div >
                    <div id="userName" style="float:left;margin-left: 30px">
                      <div style="margin-top: 20px">
                        <a style="float: left;font-size: 30px;color: #111131;margin-bottom: 20px">
                          <b>{{customer.name}}</b>
                        </a>
                        <GenderFemaleIcon style="float: left;color: #e87890" v-if="customer.gender==='female'"  :size="20" />
                        <GenderMaleIcon style="float: left;color: #627fc9" v-if="customer.gender==='male'" :size="20" />

                        <br>
                        <div style="margin-top: 10px;clear:both">
                          <a>
                            <a style="color: #969896">
                            粉丝
                            </a> &nbsp; {{customer.followers}} &nbsp; &nbsp;&nbsp;
                            <a style="color: #969896">关注</a> &nbsp; {{customer.follows}} &nbsp; &nbsp;&nbsp;
                          </a>
                        </div>

                      </div>
                    </div>

                    <div style="float: right;margin-top: 3%" >
                      <TButton variant="outline" theme="primary" style="margin-left: 350px" v-if="!hasFollow" @click="follow">
                        &nbsp; &nbsp; &nbsp; &thinsp; +关注  &nbsp; &nbsp; &nbsp; &nbsp; &thinsp;
                      </TButton>
                      <TButton  theme="primary" v-if="hasFollow" style="margin-left: 350px" @click="follow">
                        &nbsp; &nbsp; &nbsp; &thinsp; 已关注  &nbsp; &nbsp; &nbsp; &nbsp; &thinsp;
                      </TButton>
                      <TButton variant="outline" theme= "warning" style="margin-left: 10px" @click="turnToChat">
                        &nbsp; &nbsp; &nbsp; &nbsp; &thinsp; 对话 &nbsp; &nbsp; &nbsp; &nbsp; &thinsp;
                      </TButton>
                    </div>
                  </div>
                  <!---下拉框-->
                  <div style="clear:both;margin-left: 30px">
                    <el-collapse>
                      <el-collapse-item title="more">
                        <a style="color: #666666">IP :&nbsp; {{ customer.IP }}</a>
                        <br>
                        <a style="color: #666666">birthday :&nbsp;{{ customer.birthday }}</a>
                        <br>
                        <a style="color: #666666">星座 :&nbsp; {{ customer.starSign }}</a>
                        <br>
                        <a style="color: #666666">信誉评分 :&nbsp; {{ customer.rate }}</a>
                      </el-collapse-item>
                    </el-collapse>

                  </div>
                  <!---下拉框-->
                </div>

              </div>
            </Card>
            <!---第二部分--->
            <div style="height: 50px"></div>
            <el-tabs type="border-card">
              <el-tab-pane :label="'发布('+num.productNum+')'">
                <div v-for="item in products" :key="item.productId">
                  <Card style="margin:3% 8%;align-self: auto" @click="enterProduct">
                    <el-image
                        :src='item.src'
                        style="width:20%;float: left;margin-left: 2%;margin-top: 2%"
                        fit="scale"
                    />
                    <div style="margin:3%;align-self: center;float:left;width:70%">
                      <span style="font-size: 20px;margin-left:5%;margin-top: 5%"><b>{{item.title}}</b></span>
                      <TDivider></TDivider>
                      <div style="float: right">
                        <span style="font-size: 8px;color: #969896">{{ item.wantNum }}人想要 &nbsp;&nbsp;</span>
                        <span style="font-size: 8px;color: #969896">{{ item.collectNum }}人收藏 &nbsp;&nbsp;</span>
                        <span style="font-size: 8px;color: #969896">发布于{{ item.outTime }}</span>
                      </div>
                    </div>
                  </Card>

                </div>

              </el-tab-pane>
              <el-tab-pane :label="'评价('+num.assessNum+')'">
                <div v-for="item in comments" :key="item.commentId">
                  <Card style="margin:3% 8%;align-self: auto">
                    <Rate :default-value="item.rate"
                          disabled="false"
                          size="15px"
                          allow-half
                          style="margin-bottom: 15px"
                    />
                    <Comment
                        :avatar='item.avatar'
                        :author='item.ownerName'
                        :datetime='item.outTime'
                        :content='item.content'
                    >
                      <template #actions>
                        <Space key="thumbUp" :size="6">
                          <ThumbUpIcon/>
                          <span>6</span>
                        </Space>
                        <Space key="thumbDown" :size="6">
                          <ThumbDownIcon/>
                          <span>0</span>
                        </Space>
                        <Space key="chat" :size="6">
                          <ChatIcon />
                          <span>回复</span>
                        </Space>
                      </template>
                    </Comment>

                  </Card>
                </div>
              </el-tab-pane>

              <el-tab-pane :label="'帖子('+num.postNum+')'">
                <div v-for="item in posts" :key="item.postId" @click="enterPost">
                  <Card style="margin:3% 8%;align-self: auto">
                    <el-image
                        :src='item.img'
                        style="width:20%;float: left;margin-left: 2%;margin-top: 2%"
                        fit="scale"
                    />
                    <div style="margin:3%;align-self: center;float:left;width:70%">
                      <span style="font-size: 20px;margin-left:5%;margin-top: 5%"><b>{{ item.title }}</b></span>
                      <TDivider></TDivider>
                      <div style="float: right">
                        <span style="font-size: 8px;color: #b7b7b7">发布于{{ item.outTime }} &nbsp;&nbsp;</span>
                      </div>
                    </div>
                  </Card>

                </div>
              </el-tab-pane>
            </el-tabs>
          </div>

          <div class="blockBottom">

          </div>
        </div>

      </el-main>
      <el-footer>
        Powered By Vue3.0
      </el-footer>
    </el-container>
  </div>
</template>

<script lang="ts" >
import { manifest } from 'tdesign-icons-vue-next/lib/manifest'
import { ref, unref ,defineComponent} from 'vue';
import 'tdesign-vue-next/es/style/index.css'
import App from "@/App.vue";
import {useRouter} from "vue-router";

import {Card,Avatar,Swiper,Comment,Tooltip,Badge,Tag,Button as TButton,Space,Image,CollapsePanel,Tabs as TTabs,TabPanel as TTabPanel,Divider as TDivider,Rate } from 'tdesign-vue-next'
import {
  DiscountIcon,
  GenderFemaleIcon, GenderMaleIcon,ThumbUpIcon,ThumbDownIcon,ChatIcon
} from 'tdesign-icons-vue-next'

export default defineComponent({
  name:"App",
  components:{
    Card,Avatar,Swiper,Comment,Tooltip,Badge,Tag,TButton,Space,Image,CollapsePanel,TTabs, TTabPanel,TDivider,Rate,
    DiscountIcon,
    GenderFemaleIcon, GenderMaleIcon,ThumbUpIcon,ThumbDownIcon,ChatIcon
  },
  setup(){
    const customer=ref({
      customerId:1,
      avatar:"https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.18183.com%2Fuploads%2Fallimg%2F220919%2F462-220919113641-50.jpg%40%2118183&refer=http%3A%2F%2Fimg.18183.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1671506918&t=311b98569dfabfc82a08fddd5680fce7",
      backGroundImg:"https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fi2.hdslb.com%2Fbfs%2Farchive%2F18670a9e5f73df1716c87f8e465b3d9c873a8f2b.jpg&refer=http%3A%2F%2Fi2.hdslb.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1671712876&t=c49c5be7fc951d327386e2af82af4253" ,
      name:"Lucy",
      gender:"female",
      followers:9999,
      follows: 1,
      IP:"Moon",
      birthday:"2077/11/22",
      starSign:"狮子座",
      rate:5.4
    });
    const num=ref({
      //统计数量
      productNum:1,
      assessNum:2,
      postNum:3
    });
    const products=ref([
      {
        productId:1,
        src:"https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fi2.hdslb.com%2Fbfs%2Farchive%2Fe40d8896a24a39aa0d5cc84c4c5120da4118bd65.jpg&refer=http%3A%2F%2Fi2.hdslb.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1671712876&t=ee3f70674181a35f2958150a9ccadc09",
        title:"Moon",
        wantNum:100,
        collectNum:700,
        outTime:"2077/11/28"
      },
    ]);
    const comments =ref([
      {
        commentId:1,
        ownerId:3,
        avatar:"http://ci.xiaohongshu.com/f2f11e87-f9ec-567c-2897-aa67e3ee359c?imageView2/2/w/1080/format/jpg",
        ownerName:"Rebecca",
        rate:4.0,//只能是2.5 3.5 1.0 这种，精确到0.5
        outTime: "2077/05/20 21:03" ,//发布时间
        content:"Besides you, I got nothing left.But you still have a dream to stick around for. I need you to see it through.That's my dream. Honestly,nothing else ever really mattered",
        likeNum:6,
        dislikeNum:0,
      }
    ]);
    const posts=ref([
      {
        postId:1,
        img:"https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fblog%2F202007%2F22%2F20200722113343_58a82.jpeg&refer=http%3A%2F%2Fc-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1671712876&t=3c9e9eb1846164d889c559146362b039",
        title:"Where is the Moon...",
        outTime:"2077/11/22 01:31"
      }
    ]);
    const hasFollow = ref(false); //用户是否关注了该用户
    function follow(){
      hasFollow.value=!hasFollow.value;
      console.log(hasFollow);
    }
    const router = useRouter()
    // 检查token
    let haveToken = false;
    if (localStorage.getItem("token") != null) {
      haveToken = true;
    }
    function turnToChat(){
      //跳转到对话的路由页面
    }
    function enterProduct(){
      //传入一个productId然后跳转到该产品所对应的详情页
    }
    function enterPost() {
      //传入一个postId然后跳转到帖子的详情页
    }
    return{
      customer,
      num,
      products,
      comments,
      posts,
      hasFollow,
      follow,
      turnToChat,
      enterProduct,
      enterPost
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
</style>