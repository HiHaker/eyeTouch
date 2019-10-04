<template>
  <div id="publishPage">
    <el-button 
    @click="dialogFormVisible = true" 
    type="primary" 
    icon="el-icon-edit" 
    title="发表帖子" 
    circle
    style="margin:0;"></el-button>
    <el-dialog 
    title="发表帖子" 
    :visible.sync="dialogFormVisible"
    :close-on-click-modal="false">
      <el-form :model="form">
        <el-form-item label="类型" :label-width="formLabelWidth">
          <el-radio v-model="post.style" label="1" value="眼妆教程">眼妆教程</el-radio>
          <el-radio v-model="post.style" label="2" value="妆容分享">妆容分享</el-radio>
        </el-form-item>
        <el-form-item label="风格" :label-width="formLabelWidth">
          <el-radio v-model="post.type" label="1" value="图片">图片</el-radio>
          <el-radio v-model="post.type" label="2" value="视频">视频</el-radio>
        </el-form-item>
        <el-form-item label="内容" :label-width="formLabelWidth">
          <el-input
            type="textarea"
            :autosize="{ minRows: 3}"
            placeholder="请输入帖子内容..."
            v-model="post.body">
          </el-input>
        </el-form-item>
        <el-form-item label="图片" 
        :label-width="formLabelWidth"
        v-if="post.type == '1'">
          <el-upload
            action="https://jsonplaceholder.typicode.com/posts/"
            list-type="picture-card"
            :on-preview="handlePictureCardPreview"
            :on-remove="handleRemove"
            multiple="true"
            limit="9">
            <i class="el-icon-plus"></i>
          </el-upload>
          <el-dialog :visible.sync="dialogVisible">
            <img width="100%" :src="dialogImageUrl" alt="">
          </el-dialog>
        </el-form-item>
        <el-form-item label="视频" 
        :label-width="formLabelWidth"
        v-if="post.type == '2'">
          <el-upload
            action="https://jsonplaceholder.typicode.com/posts/"
            list-type="picture-card"
            :on-preview="handlePictureCardPreview"
            :on-remove="handleRemove"
            multiple="false"
            limit="9">
            <i class="el-icon-plus"></i>
          </el-upload>
          <el-dialog :visible.sync="dialogVisible">
            <img width="100%" :src="dialogImageUrl" alt="">
          </el-dialog>
        </el-form-item>
      </el-form>
      
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false" size="mini">取 消</el-button>
        <el-button type="primary" @click="dialogFormVisible = false" size="mini">发表</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: 'publishPage',
  data() {
    return {
      gridData: [{
        date: '2016-05-02',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      }, {
        date: '2016-05-04',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      }, {
        date: '2016-05-01',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      }, {
        date: '2016-05-03',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      }],
      dialogTableVisible: false,
      dialogFormVisible: false,
      form: {
        name: '',
        region: '',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: ''
      },
      formLabelWidth: '120px',
      post: {
        style: '1',
        type: '1',
        body: ''
      },
      dialogImageUrl: '',
      dialogVisible: false,

    }
  },
  methods: {
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    }
  },
  components:{

  },
  beforeMount(){

  }
};
</script>

<style lang="scss">
  @import "../../assets/scss/community/publish.scss";
</style>