<template>
  <div id="register">
    <div class="master">
      <div class="loginbox">
        <div class="form">
          <div class="title">
            注册
          </div>
          <el-form 
          :model="ruleForm" 
          status-icon 
          :rules="rules" 
          ref="ruleForm" 
          label-width="70px"
          label-position="left" 
          class="demo-ruleForm"
          size="small">
            <el-form-item label="邮箱" prop="username">
              <el-input type="text" v-model="ruleForm.username" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="验证码" prop="nickname">
              <el-input type="text" v-model="ruleForm.nickname" autocomplete="off">
                <el-button slot="append">获取验证码</el-button>
              </el-input>
            </el-form-item>
            <el-form-item label="密码" prop="password">
              <el-input type="password" v-model="ruleForm.password" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="确认密码" prop="checkPassword">
              <el-input type="password" v-model="ruleForm.checkPassword" autocomplete="off"></el-input>
            </el-form-item>
          </el-form>
          <div class="operate">
            <el-button size="small" type="primary" @click="register">提交</el-button>
            <el-button size="small" @click="resetForm('ruleForm')">重置</el-button>
            <div class="tip">
              <div class="words">
                已经有账号？去
                <span class="link" @click="toLogin">登录</span>
              </div>
            </div>
          </div>
          <i class="el-icon-close" @click="sendUnRegister"></i>
        </div>
        <div class="info">
          
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'register',
  data() {
    let checkUsername = (rule, value, callback) => {
      if (value === '') {
        return callback(new Error('请输入用户名'));
      }
    };
    let checkNickname = (rule, value, callback) => {
      if (value === '') {
        return callback(new Error('请输入昵称'));
      }
    };
    let validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'));
      } else {
        if (this.ruleForm.checkPassword !== '') {
          this.$refs.ruleForm.validateField('checkPass');
        }
        callback();
      }
    };
    let validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'));
      } else if (value !== this.ruleForm.password) {
        callback(new Error('两次密码输入不一致!'));
      } else {
        callback();
      }
    };
    return {
      msg: false,
      toLoginInfo: {
        isMask: true,
        isLogin: true,
        isRegister: false
      },
      ruleForm: {
        username: '',
        password: '',
        checkPassword: '',
        nickname: '',
        create_time: ''
      },
      rules: {
        username: [
          { validator: checkUsername, trigger: 'blur' }
        ],
        password: [
          { validator: validatePass, trigger: 'blur' }
        ],
        checkPassword: [
          { validator: validatePass2, trigger: 'blur' }
        ],
        nickname: [
          { validator: checkNickname, trigger: 'blur' }
        ]
      }
    };
  },
  methods: {
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    /*点击右上角的取消图标*/
    sendUnRegister(){
      this.$router.go(-1);
    },
    /*点击去登录*/
    toLogin(){
      this.$router.push({name:'Login'});
    },
    /*注册成功后给nav组件发送传递信息*/
    sendRegisterInfo(){
      this.$emit('registerInfo',this.$store.state.userInfo)
    },
    registerSuccess() {
      this.$message({
        message: '注册成功',
        type: 'success'
      });
    },
    loginSuccess() {
      this.$message({
        message: '自动登录成功',
        type: 'success'
      });
    },
    fail() {
      this.$message({
        message: '注册失败, 该用户名已存在',
        type: 'error'
      });
    },
    error() {
      this.$message({
        message: '注册失败',
        type: 'error'
      });
    },
    register(){
      if(this.ruleForm.username != ''
        &&this.ruleForm.password != ''
        &&this.ruleForm.checkPassword !=''
        &&this.ruleForm.nickname != ''){
        /*任何一项为空时不允许提交，并执行表单验证*/
        let _this = this
        _this.ruleForm.create_time = getDate()
        signup(_this.ruleForm)
        .then(res => {
          console.log(res)
          //将后台获取到的userInfo存到store
          _this.$store.dispatch('getUserInfo', res.data.user) 
          console.log(_this.$store.state.userInfo)
          if(res.data.code === 0){
            _this.registerSuccess()      //"注册成功"消息提示
            setTimeout(() => {
              _this.loginSuccess()       //"自动登录成功"消息提示
              _this.sendRegisterInfo()     //将登录信息发送给父组件
              _this.sendUnRegister()       //关闭登录框
            }, 1000)
          }else{
            _this.fail()                 //"注册失败，用户名已存在"消息提示
          }
        })
        .catch(() => {
          _this.error()             //网络或服务器错误时"登注册失败"消息提示
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
  @import "../../assets/scss/register/index.scss";
</style>