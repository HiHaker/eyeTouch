<template>
  <div id="searchDetail">
    <div class="navs">
      <div class="navBox">
        <div class="type">妆品分类</div>
        <div class="infos">
          <li>眼影</li>
          <li>眼线</li>
        </div>
      </div>
      <div class="navBox">
        <div class="type">适用人群</div>
        <div class="infos">
          <li>男士</li>
          <li>女士</li>
        </div>
      </div>
      <div class="navBox">
        <div class="type">适用肤质</div>
        <div class="infos">
          <li>中性皮肤</li>
          <li>敏感皮肤</li>
        </div>
      </div>
      <div class="navBox">
        <div class="type">使用效果</div>
        <div class="infos">
          <li>柔和</li>
          <li>持久</li>
        </div>
      </div>
    </div>
    <div class="navbar">
      <el-button plain size="mini">
        综合
        <i class="el-icon-arrow-down el-icon--right"></i>
      </el-button>
      <el-button plain size="mini">
        销量
        <i class="el-icon-arrow-down el-icon--right"></i>
      </el-button>
      <el-button plain size="mini">
        评价
        <i class="el-icon-arrow-down el-icon--right"></i>
      </el-button>
      <el-button plain size="mini">
        价格
        <i class="el-icon-arrow-down el-icon--right"></i>
      </el-button>
    </div>
    <div class="product-main">
      <cosmetic-item/>
    </div>
    <div class="return" @click="returnLastPage">
      <el-button 
      icon="el-icon-arrow-left" 
      circle
      title="返回上一页">
      </el-button>
    </div>
  </div>
</template>

<script>
import CosmeticItem from '@/components/pubComponents/cosmeticItem'

export default {
  name: 'searchDetail',
  data(){
    return {

    }
  },
  methods: {
    toSearchDetailPage(){
      this.$router.push({name:'SearchDetail'});
    },
    returnLastPage(){
      this.$router.go(-1);
    }
  },
  components:{
    CosmeticItem
  },
  beforeMount(){
    document.documentElement.scrollTop = 0
  }
};
</script>

<style lang="scss">
  @import "../../../assets/scss/mall/searchDetail/index.scss";
</style>