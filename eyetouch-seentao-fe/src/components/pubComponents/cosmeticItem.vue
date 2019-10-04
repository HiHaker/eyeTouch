<template>
  <div id="cosmeticItem">
    <li class="youLikeList-item" v-for="item in 12" @click="toDetailPage">
      <div class="image">
        <img src="http://tva1.sinaimg.cn/large/0060lm7Tly1g64usg9qfpj30rs0ku410.jpg" alt="">
      </div>
      <div class="cosmetic-info">
        <div class="desc">
        精致的眼妆品
        </div>
        <div class="price">
          ￥<span>298</span>
        </div>
      </div>
    </li>
  </div>
</template>

<script>

export default {
  name: 'cosmeticItem',
  data(){
    return {

    }
  },
  props: {

  },
  methods: {
    toDetailPage(){
      this.$router.push({name:'ProductDetail'});
    }
  }
};
</script>

<style lang="scss">
  @import "../../assets/scss/pubComponents/cosmeticItem.scss";
</style>