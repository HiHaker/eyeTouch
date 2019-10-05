<template>
  <div id="index">
    <div class="container">
      <div class="banner">
        <div class="picStyle" @click="toStyleMigrationPage">
          风格迁移页入口
        </div>
        <!--****************** 幻灯片 ******************-->
        <div class="slide">
          <el-carousel
           :interval="4000" 
           arrow="always">
            <el-carousel-item 
            v-for="item in 5" 
            :key="item">
              <img src="http://tva1.sinaimg.cn/large/0060lm7Tly1g64rb3s5djj32f80rs7gw.jpg">
            </el-carousel-item>
          </el-carousel>
        </div>
      </div>
      <div class="main">
        <div class="list youLike">
          <div class="title">
            猜你喜欢
          </div>
          <div class="youLikeList">
            <div class="youLikeList-items">
              <!--****************** 帖子列表 ******************-->
              <post-item/>
            </div>
            <div class="youLikeList-items">
              <!--****************** 妆品列表 ******************-->
              <cosmetic-item/>
            </div>
          </div>
        </div>
        <el-divider></el-divider>
        <div class="list hotPosts">
          <div class="title">
            热门帖子
          </div>
          <ul class="hotPostsList">
            <!--****************** 帖子列表 ******************-->
            <post-item/>
          </ul>
        </div>
        <el-divider></el-divider>
        <div class="list hotCosmetics">
          <div class="title">
            热门妆品
          </div>
          <ul class="hotCosmeticsList">
            <!--****************** 妆品列表 ******************-->
            <cosmetic-item/>
          </ul>
        </div>
      </div>          
    </div>
  </div>
</template>

<script>
import PostItem from '@/components/pubComponents/postItem'
import CosmeticItem from '@/components/pubComponents/cosmeticItem'

export default {
  name: 'index',
  data(){
    return {

    }
  },
  methods: {
    // 跳转到图像风格迁移页
    toStyleMigrationPage(){
      this.$router.push({name:'StyleMigration'});
    }
  },
  components:{
    PostItem,
    CosmeticItem
  },
  beforeMount(){
    document.documentElement.scrollTop = 0
  }
};
</script>

<style lang="scss">
  @import "../../assets/scss/index/index.scss";
</style>