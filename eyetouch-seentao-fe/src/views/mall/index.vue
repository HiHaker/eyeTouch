<template>
  <div id="mall">
    <div class="header">
      <div class="container">
        <div class="title">
          眼妆商城
        </div>
        <div class="search">
          <div class="input">
            <el-input 
            placeholder="搜索眼妆品" 
            v-model="input" 
            class="input-with-select"
            size="small">
              <el-button 
              slot="append" 
              icon="el-icon-search"
              @click="toSearchDetailPage"></el-button>
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
      </div>
    </div>
    <div class="main">
      <!-- 二级级路由 -->
      <router-view/>
    </div>
  </div>
</template>

<script>

export default {
  name: 'mall',
  data(){
    return {
      input: ""
    }
  },
  methods: {
    toSearchDetailPage(){
      this.$router.push({name:'SearchDetail'});
    }
  },
  components:{
    
  },
  beforeMount(){
    document.documentElement.scrollTop = 0
  }
};
</script>

<style lang="scss">
  @import "../../assets/scss/mall/index.scss";
</style>