<template>
  <div id="myFanses">
    <user-list/>
  </div>
</template>

<script>
import UserList from '@/components/pubComponents/userList'

export default {
  name: 'myFanses',
  data(){
    return {

    }
  },
  methods: {

  },
  components:{
    UserList
  },
  beforeMount(){
    document.documentElement.scrollTop = 0
  }
};
</script>

<style lang="scss">
  @import "../../../assets/scss/mine/myFanses/index.scss";
</style>