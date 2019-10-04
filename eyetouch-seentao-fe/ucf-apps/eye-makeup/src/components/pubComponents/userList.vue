<template>
  <div id="userList">
    <div class="userList-li" v-for="item in 12">
      <div class="user">
        <div class="userInfo">
          <div class="avatar">
            <img src="@/assets/images/avatar.jpg">
          </div>
          <div class="name-signature">
            <div class="name">浅笑半离兮</div>
            <div class="signature">人生若只如初见</div>
          </div>
        </div>
        <div class="attent">
          <!-- <el-button size="mini" type="primary">关注TA</el-button> -->
        </div>
      </div>
    </div>
  </div>
</template>

<script>

export default {
  name: 'userList',
  data(){
    return {

    }
  }
};
</script>

<style lang="scss">
  @import "../../assets/scss/pubComponents/userList.scss";
</style>