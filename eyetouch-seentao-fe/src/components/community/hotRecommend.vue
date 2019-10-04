<template>
  <div id="hotRecommend">
    <div class="title">
      热门话题
    </div>
    <ul class="items">
      <li v-for="item in 10">人生若只如初见人生若只如初见</li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'hotRecommend',
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
  @import "../../assets/scss/community/hotRecommend.scss";
</style>