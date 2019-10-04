<template>
  <div id="styleMigration">
    <div class="container">
      <div class="sectionA">
        <div class="example">
          <div class="pic1">
            <img src="@/assets/images/10.jpg">
          </div>
          <div class="add">
            <svg t="1569489148358" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="4683" width="64" height="64"><path d="M512 70.283c-244.514 0-442.732 197.763-442.732 441.717s198.218 441.717 442.732 441.717 442.732-197.763 442.732-441.717-198.218-441.717-442.732-441.717M735.045 558.604h-176.442v176.442c0 25.738-20.866 46.604-46.604 46.604s-46.604-20.866-46.604-46.604v-176.442h-176.442c-25.738 0-46.604-20.866-46.604-46.604s20.866-46.604 46.604-46.604h176.442v-176.442c0-25.738 20.866-46.604 46.604-46.604s46.604 20.866 46.604 46.604v176.442h176.442c25.738 0 46.604 20.866 46.604 46.604s-20.866 46.604-46.604 46.604z" fill="#ff6f6f" p-id="4684"></path></svg>
          </div>
          <div class="pic2">
            <img src="@/assets/images/4.png">
          </div>
          <div class="arrow">
            <svg t="1569489267620" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="9086" width="64" height="64"><path d="M514 114.3c-219.9 0-398.8 178.9-398.8 398.8 0 220 178.9 398.9 398.8 398.9s398.8-178.9 398.8-398.9c0-219.8-178.9-398.8-398.8-398.8z m232.1 440.4L582 718.8c-22.9 22.9-60.2 22.9-83.1 0-11.5-11.5-17.2-26.5-17.2-41.5s5.7-30.1 17.2-41.5l63.8-63.8H334c-32.5 0-58.8-26.3-58.8-58.8s26.3-58.8 58.8-58.8h228.7l-63.8-63.8c-22.9-22.9-22.9-60.2 0-83.1 22.9-22.9 60.2-22.9 83.1 0l164.1 164.1c22.9 23 22.9 60.2 0 83.1z" p-id="9087" fill="#ff6f6f"></path></svg>
          </div>
          <div class="pic3">
            <img src="@/assets/images/a.jpg">
          </div>
        </div>
        <!-- 原图 -->
        <div class="myPicture">
          <div class="title">选择您的照片</div>
          <div class="select">
            <div class="image">
              <img src="@/assets/images/10.jpg">
            </div>
            <div class="dragUpload">
              <el-upload
                class="upload-demo"
                drag
                action="https://jsonplaceholder.typicode.com/posts/">
                <i class="el-icon-upload"></i>
                <div class="el-upload__text">将图片拖到此处，或<em>点击上传</em></div>
                <div class="el-upload__tip" slot="tip">只能上传jpg/png文件，且不超过500kb</div>
              </el-upload>
            </div>
          </div>
        </div>
        <!-- 融合图 -->
        <div class="tempPicture">
          <div class="title">选择模板照片</div>
          <div class="select">
            <div class="image">
              <img src="@/assets/images/4.png">
            </div>
            <div class="tempSelect">
              <div class="head">选择您想要融合的眼妆</div>
              <ul class="images">
                <li v-for="item in 5">
                  <img src="@/assets/images/4.png">
                </li>
              </ul>
              <div class="pagenation">
                <el-pagination
                  small
                  layout="prev, pager, next"
                  :total="50">
                </el-pagination>
              </div>
              <div class="selectPictrue">
                <div class="tip">没有喜欢的？选择图片上传</div>
                <el-upload
                  class="upload-demo"
                  action="https://jsonplaceholder.typicode.com/posts/"
                  :on-change="handleChange">
                  <el-button size="small" type="primary">点击上传</el-button>
                </el-upload>
              </div>
            </div>
          </div>
        </div>
        <!-- 生成眼妆按钮 -->
        <div class="submit">
          <el-button type="primary" size="small">生成眼妆</el-button>
        </div>
      </div>
    </div>
    <div class="return" @click="returnLastPage">
      <el-button 
      icon="el-icon-arrow-left" 
      circle
      title="返回上一页">
      </el-button>
    </div>
  </div>
</template>

<script>
import Img from '@/assets/images/yz.jpeg'

export default {
  name: 'styleMigration',
  data(){
    return {
      imageUrl: Img,
      fileList: [{
        name: 'food.jpeg',
        url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'
      }, {
        name: 'food2.jpeg',
        url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'
      }]
    }
  },
  methods: {
    returnLastPage(){
      this.$router.go(-1);
    }
  },
  components:{

  },
  beforeMount(){
    document.documentElement.scrollTop = 0
  }
};
</script>

<style lang="scss">
  @import "../../assets/scss/index/styleMigration.scss";
</style>