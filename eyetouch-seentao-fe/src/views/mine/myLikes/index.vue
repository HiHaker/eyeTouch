<template>
  <div id="myLikes">
    <post-item/>
  </div>
</template>

<script>
import PostItem from '@/components/pubComponents/postItem'

export default {
  name: 'myLikes',
  data(){
    return {

    }
  },
  methods: {

  },
  components:{
    PostItem
  },
  beforeMount(){
    document.documentElement.scrollTop = 0
  }
};
</script>

<style lang="scss">
  @import "../../../assets/scss/mine/myLikes/index.scss";
</style>