<template>
  <div id="login">
    <div class="master">
      <div class="loginbox">
        <div class="form">
          <div class="title">
            登录
          </div>
          <el-form 
          :model="loginInfo" 
          status-icon 
          :rules="rules" 
          ref="ruleForm" 
          label-width="70px"
          label-position="left" 
          class="demo-ruleForm"
          size="small">
            <el-form-item 
            label="用户名" 
            prop="username"
            style="margin-bottom: 20px;">
              <el-input 
              type="text" 
              v-model="loginInfo.username" 
              autocomplete="off"
              size="medium"></el-input>
            </el-form-item>
            <el-form-item 
            label="密码" 
            prop="password">
              <el-input 
              type="password" 
              v-model="loginInfo.password" 
              autocomplete="off"
              size="medium"></el-input>
            </el-form-item>
          </el-form>
          <div class="operate">
            <el-button 
            size="small" 
            type="primary" 
            @click="login">登录</el-button>
            <div class="tip">
              <div class="words">
                还没有账号？去
                <span class="link" 
                @click="toRegisterPage">注册</span>
              </div>
            </div>
          </div>
          <i class="el-icon-close" @click="sendUnLogin"></i>
        </div>
        <div class="info">
          
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'login',
  data() {
    let checkUsername = (rule, value, callback) => {
      if (value === '') {
        return callback(new Error('请输入用户名'));
      }
    };
    let validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'));
      } else {
        if (this.loginInfo.checkPassword !== '') {
          this.$refs.loginInfo.validateField('checkPass');
        }
        callback();
      }
    };
    return {
      msg: false,
      toRegisterInfo: {
        isMask: true,
        isLogin: false,
        isRegister: true
      },
      /*登录信息*/
      loginInfo: {
        username: '',
        password: '',
        last_login_time: ''
      },
      rules: {
        username: [
          { validator: checkUsername, trigger: 'blur' }
        ],
        password: [
          { validator: validatePass, trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    /*点击右上角的取消图标*/
    sendUnLogin(){
      this.$router.go(-1);
    },
    /*点击去注册*/
    toRegisterPage(){
      this.$router.push({name:'Register'});
    },
    /*登录成功后给nav组件发送传递信息*/
    sendLoginInfo(){
      
    },
    success() {
      this.$message({
        message: '登录成功',
        type: 'success'
      });
    },
    fail() {
      this.$message({
        message: '登录失败, 密码错误',
        type: 'error'
      });
    },
    error() {
      this.$message({
        message: '登录失败',
        type: 'error'
      });
    },
    login(){
      if(this.ruleForm.username!=''&&this.ruleForm.password!=''){
        /*任何一项为空时不允许提交，并执行表单验证*/
        let _this = this
        _this.ruleForm.last_login_time = getDate()
        signin(_this.ruleForm)
        .then(res => {
          //将后台获取到的userInfo存到store
          _this.$store.dispatch('getUserInfo', res.data.user) 
          if(res.data.code === 0){
            _this.success()       //"登录成功"消息提示
            _this.sendLoginInfo() //将登录信息发送给父组件
            _this.sendUnLogin()   //关闭登录框
          }else{
            _this.fail()          //"密码错误"消息提示
          }
        })
        .catch(() => {
          _this.error()          //网络或服务器错误时"登录失败"消息提示
        })
      }else{
        this.$refs.ruleForm.validate()
      }
    }
  },
  components:{
    
  },
  beforeMount(){
    
  }
};
</script>

<style lang="scss">
  @import "../../assets/scss/login/index.scss";
</style>