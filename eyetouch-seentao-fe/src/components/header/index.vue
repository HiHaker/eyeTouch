<template>
  <div id="g-header">
    <el-row>
      <el-col :span="2">
        <div class="logo">
          <router-link to="/index">
            <img src="../../assets/images/logo.png" alt="logo">
          </router-link>
        </div>
      </el-col>
      <el-col :span="6">
        <div class="search">
          <div class="input">
            <el-input
              size="small"
              width="90%"
              placeholder="搜索您想要的内容···"
              suffix-icon="el-icon-search"
              v-model="input">
            </el-input>
            <!-- 搜索框推荐 -->
            <div class="hoverRecommendCon">
              <div class="hoverRecommend">
                <div class="hotSearch">
                  <div class="h-title">热门搜索</div>
                  <ul>
                    <li v-for="item in 15">新化妆品</li>
                  </ul>
                </div>
                <div class="youLike">
                  <div class="y-title">猜你喜欢</div>
                  <ul>
                    <li v-for="item in 5">柔和眼妆品</li>
                  </ul>
                </div>
              </div> 
            </div>
          </div>
        </div>
      </el-col>
      <el-col :span="12">
        <div class="nav">
          <ul>
            <router-link to="/index"><li>首页</li></router-link>
            <router-link to="/community"><li>社区</li></router-link>
            <router-link to="/mall/mallIndex"><li>眼妆商城</li></router-link>
            <!-- <router-link to="/mine/myPosts"><li>个人中心</li></router-link> -->
          </ul>
        </div>
      </el-col>
      <!-- <el-col :span="4">
        <div class="me-1">
          <span @click="toLoginPage">登录</span>&nbsp;/
          <span @click="toRegisterPage">注册</span>
        </div>
      </el-col> -->
      <el-col :span="4">
        <div class="me-2" @click="toMine()">
          <div class="avatar">
            <img src="@/assets/images/avatar.jpg">
          </div>
          <div class="nickName">
            浅笑半离兮
          </div>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: 'g-header',
  data(){
    return {
      input: ''
    }
  },
  methods: {
    // tabbar跳转
    /*changeLink(i){
      this.status = i
      console.log(this.status)
    },*/
    toMine(){
      this.$router.push({name:'Mine'})
    },
    // 跳转到登录页
    toLoginPage(){
      this.$router.push({name:'Login'})
    },
    // 跳转到注册页
    toRegisterPage(){
      this.$router.push({name:'Register'})
    }
  },
  components:{

  },
  beforeMount(){
    this.status = 1
  }
};
</script>

<style lang="scss">
  @import "../../assets/scss/header/header.scss";
</style>