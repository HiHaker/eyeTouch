<template>
  <div id="community">
    <div class="container">
      <div class="navs">
        <dl class="teachList">
          <dt>化妆教程</dt>
          <dd :class="{navActive: status === 0}" @click="change(0)">最新</dd>
          <dd :class="{navActive: status === 1}" @click="change(1)">热门</dd>
          <dd :class="{navActive: status === 2}" @click="change(2)">图文</dd>
          <dd :class="{navActive: status === 3}" @click="change(3)">视频</dd>
        </dl>
        <!-- <el-divider></el-divider> -->
        <dl class="cusList">
          <dt>妆容分享</dt>
          <dd :class="{navActive: status === 4}" @click="change(4)">最新</dd>
          <dd :class="{navActive: status === 5}" @click="change(5)">热门</dd>
          <dd :class="{navActive: status === 6}" @click="change(6)">图文</dd>
          <dd :class="{navActive: status === 7}" @click="change(7)">视频</dd>
        </dl>
        <!-- <el-divider></el-divider> -->
        <div class="aboutMe">
          <el-badge :value="100" :max="10" class="item">
            与我相关
          </el-badge>
        </div>
      </div>
      <div class="main">
        <ul class="posts">
          <div class="publish">
            <div class="publishDesc">
              <img src="@/assets/images/123.png">
            </div>
            <div class="publishBtn">
              <publish-page/>
            </div>
          </div>
          <!-- 帖子列表组件 -->
          <post-list/><!--  :arrayList="postList" -->
        </ul>
      </div>
      <div class="aside">
        <div class="youLike">
          <!-- 猜你喜欢组件 -->
          <you-like/><!--  :arrayList="youLikeList" -->
        </div>
        <div class="recommend">
          <!-- 热门推荐组件 -->
          <hot-recommend/><!--  :arrayList="hotRecommendList" -->
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import PublishPage from '@/components/community/publish'
import PostList from '@/components/community/postList'
import YouLike from '@/components/community/youLike'
import HotRecommend from '@/components/community/hotRecommend'

export default {
  name: 'community',
  data(){
    return {
      status: 0,
      postList: [],
      youLikeList: [],
      hotRecommendList: []
    }
  },
  components:{
    PublishPage,
    PostList,
    YouLike,
    HotRecommend
  },
  methods: {
    // 切换类型
    change(i){
      this.status = i
    }
  },
  
  beforeMount(){
    document.documentElement.scrollTop = 0
  }
};
</script>

<style lang="scss">
  @import "../../assets/scss/community/index.scss";
</style>