<template>
  <div id="myProfile">
    <div class="myProfile-box">
      <div class="myProfile-title">
        我的资料
      </div>
      <div class="myProfile-main">
        <ul class="myProfile-main-ul">
          <li>
            <div class="item-name">用户名</div>
            <div class="item-body">
              <div>
                1784618478
                <el-button plain size="mini">修改密码</el-button>
              </div>
            </div>
          </li>
          <li>
            <div class="item-name">昵称</div>
            <div class="item-body">
              <el-input v-model="nickName" size="small">
                浅笑半离兮
              </el-input>
            </div>
          </li>
          <li>
            <div class="item-name">性别</div>
            <div class="item-body">
              <el-radio v-model="sex" label="1">男</el-radio>
              <el-radio v-model="sex" label="2">女</el-radio>
            </div>
          </li>
          <li>
            <div class="item-name">邮箱</div>
            <div class="item-body">
              <el-input v-model="email" size="small">
                浅笑半离兮
              </el-input>
            </div>
          </li>
          <li>
            <div class="item-name">城市</div>
            <div class="item-body">
              <el-input v-model="adress" size="small">
                浅笑半离兮
              </el-input>
            </div>
          </li>
          <li>
            <div class="item-name">生日</div>
            <div class="item-body">
              <el-date-picker
                v-model="birthday"
                type="date"
                :placeholder="birthday">
              </el-date-picker>
            </div>
          </li>
          <li>
            <div class="item-name">个性签名</div>
            <div class="item-body">
              <el-input
                type="textarea"
                autosize
                placeholder="请输入内容"
                v-model="signiture">
              </el-input>
            </div>
          </li>
          <li>
            <div class="item-name">个人描述</div>
            <div class="item-body">
              <el-input
                type="textarea"
                autosize
                placeholder="请输入内容"
                :autosize="{ minRows: 3, maxRows: 5}"
                v-model="desc">
              </el-input>
            </div>
          </li>
        </ul>
      </div>
      <div class="submit">
        <el-button type="primary" size="small">提交</el-button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'myProfile',
  data(){
    return {
      sex: '1',
      nickName: '浅笑半离兮',
      email: '2434740987@qq.com',
      adress: '云南 大理',
      birthday: '',
      signiture: '人生若只如初见，何事秋风悲画扇。',
      desc: ''
    }
  },
  methods: {

  },
  components:{

  },
  beforeMount(){
    document.documentElement.scrollTop = 0
  }
};
</script>

<style lang="scss">
  @import "../../../assets/scss/mine/myProfile/index.scss";
</style>