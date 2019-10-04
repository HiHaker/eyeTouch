<template>
  <div id="myPosts">
    <div class="post-li">
      <post-list/>
    </div>
  </div>
</template>

<script>
import PostList from "@/components/community/postList"

export default {
  name: 'myPosts',
  data(){
    return {

    }
  },
  methods: {

  },
  components:{
    PostList
  },
  beforeMount(){
    document.documentElement.scrollTop = 0
  }
};
</script>

<style lang="scss">
  @import "../../../assets/scss/mine/myPosts/index.scss";
</style>