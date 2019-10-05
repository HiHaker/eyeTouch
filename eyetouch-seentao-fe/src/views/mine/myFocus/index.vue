<template>
  <div id="myFocus">
    <user-list/>
  </div>
</template>

<script>
import UserList from '@/components/pubComponents/userList'

export default {
  name: 'myFocus',
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
  @import "../../../assets/scss/mine/myFocus/index.scss";
</style>