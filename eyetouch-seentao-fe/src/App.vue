<template>
  <div id="app">
    <el-container>
      <!-- 主模板头部 -->
      <el-header>
        <g-header/>
      </el-header>
      <!-- 主体 -->
      <el-main>
        <!-- 一级路由 -->
        <router-view/>
      </el-main>
      <!-- 主模板底部 -->
      <el-footer>
        <g-footer/>
      </el-footer>
    </el-container>
  </div>
</template>

<script>
import GHeader from '@/components/header'
import GFooter from '@/components/footer'

export default {
  name: 'App',
  components: {
    GHeader,
    GFooter
  }
};
</script>

<style lang="scss">
  @import "./assets/scss/public/variables.scss";

  * {
    margin: 0;
    padding: 0;
  }
  .el-container{
    .el-header,
    .el-main,
    .el-footer{
      padding: 0;
      margin: 0;
    }
    .el-header{
      z-index: 100;
    }
    .el-main{
      // background-image: url('~@/assets/images/bg1.jpg');
      // background-size: 100vw 100vh;
      // background-origin: top left;
      // background-attachment: fixed;
      background-color: $theme-color;
    }
  }
  
</style>
