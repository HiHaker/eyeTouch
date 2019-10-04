<template>
  <div id="navbar2">
    <div class="navbar2Box" v-for="item in 5">
      <div class="title">
        <div>夏季</div>
        <i class="el-icon-arrow-right"></i>
      </div>
      <div class="navbar2-ul">
        <li>眼线笔</li>
        <li>眼线笔</li>
        <li>眼线笔</li>
        <li>眼线笔</li>
        <li>眼线笔</li>
        <li>眼线笔</li>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'navbar2',
  data(){
    return {

    }
  },
  methods: {

  },
  components:{

  },
  beforeMount(){

  }
};
</script>

<style lang="scss">
  @import "../../assets/scss/mall/mallIndex/navbar2.scss";
</style>