<template>
  <div id="youLike">
    <div class="title">
      猜你喜欢
    </div>
    <ul class="items">
      <li v-for="item in 8">人生若只如初见人生若只如初见</li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'youLike',
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
  @import "../../assets/scss/community/youLike.scss";
</style>