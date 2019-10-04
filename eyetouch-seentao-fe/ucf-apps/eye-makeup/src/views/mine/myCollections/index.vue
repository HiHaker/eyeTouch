<template>
  <div id="myCollection">
    <el-tabs v-model="activeName">
      <el-tab-pane label="帖子" name="post">
        <post-item/>
      </el-tab-pane>
      <el-tab-pane label="妆品" name="commodity">
        <cosmetic-item/>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
import PostItem from '@/components/pubComponents/postItem'
import CosmeticItem from '@/components/pubComponents/cosmeticItem'

export default {
  name: 'myCollection',
  data(){
    return {
      activeName: 'post'
    }
  },
  methods: {

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
  @import "../../../assets/scss/mine/myCollections/index.scss";
</style>