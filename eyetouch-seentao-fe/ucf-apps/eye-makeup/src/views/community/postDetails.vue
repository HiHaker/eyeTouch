<template>
  <div id="postDetail">
    <div class="container">
      <div class="detail-title">
        帖子详情
      </div>
      <div class="post">
        <li class="postList-li">
          <div class="user">
            <div class="userInfo">
              <div class="avatar">
                <img src="@/assets/images/avatar.jpg">
              </div>
              <div class="name-time">
                <div class="name">浅笑半离兮</div>
                <div class="time">2019-8-12 11:48:56</div>
              </div>
            </div>
            <div class="attent">
              <el-button type="primary" size="mini">关注TA</el-button>
            </div>
          </div>
          <div class="body">
            <p>东风夜放花千树，更吹落，星如雨。宝马雕车香满路。凤箫声动，玉壶光转，一夜鱼龙舞。蛾儿雪柳黄金缕，笑语盈盈暗香去。众里寻他千百度，蓦然回首，那人却在，灯火阑珊处。</p>
          </div>
          <!-- <div class="images">
            <el-image 
              :src="item"
              :preview-src-list="images"
              :fit="cover"
              v-for="item in images">
            </el-image>
          </div> -->
          <div class="video">
            <video src="http://fengblog.xyz/videos/test.mp4" width="100%" controls="controls">
              您的浏览器不支持 video 标签。
            </video>
          </div>
          <div class="operate">
            <div class="like" title="点赞">
              <img src="@/assets/icons/like.png" class="like">
              <div>334</div>
            </div>
            <div class="collection" title="收藏">
              <img src="@/assets/icons/collection.png" class="collection">
              <div>223</div>
            </div>
            <div class="forward" title="转发">
              <img src="@/assets/icons/forward.png" class="forward">
              <div>135</div>
            </div>
          </div>
          <div class="comments">
            <div class="title">评论</div>
            <div class="tocomment">
              <el-input
                type="textarea"
                autosize
                placeholder="我也要评论..."
                v-model="textarea">
              </el-input>
              <el-button 
              type="primary"
              size="mini">
                评论
              </el-button>
            </div>
            <li 
            class="commentList" 
            v-for="item in 15"
            title="回复TA"
            @click="openMessageBox('张凤云')">
              <span class="obj">
                <span>张凤云</span>
                回复
                <span>杨伟艺</span>
                :&nbsp;
              </span>哈哈哈哈哈哈哈哈哈哈或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或
            </li>
          </div>
        </li>
      </div>
      <div class="return" @click="returnLastPage">
        <el-button 
        icon="el-icon-arrow-left" 
        circle
        title="返回上一页">
        </el-button>
      </div>
    </div>
  </div>
</template>

<script>
import PostList from '@/components/community/postList'
import YouLike from '@/components/community/youLike'
import HotRecommend from '@/components/community/hotRecommend'

export default {
  name: 'postDetail',
  data(){
    return {
      postList: [],
      textarea: "",
      images: [
        "@/assets/images/1.jpg",
        "@/assets/images/2.jpg",
        "@/assets/images/3.jpg"
      ]
    }
  },
  methods: {
    // 跳转到社区页
    returnLastPage(){
      this.$router.go(-1);
    },
    openMessageBox(i){
      this.$prompt('回复  '+i, {
        confirmButtonText: '提交',
        cancelButtonText: '取消',
        // beforeClose: 
      }).then(({ value }) => {
        this.$message({
          type: 'success',
          message: '回复成功'
        });
      }).catch(() => {
             
      });
    }
  },
  components:{
    PostList,
    YouLike,
    HotRecommend
  },
  beforeMount(){
    document.documentElement.scrollTop = 0
  }
};
</script>

<style lang="scss">
  @import "../../assets/scss/community/postDetails.scss";
</style>