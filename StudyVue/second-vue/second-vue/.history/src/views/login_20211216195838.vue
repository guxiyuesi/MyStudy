<template>
    <div>
        <div >
             <img :src="imgSrc" width="100%" height="100%" alt="" />
        </div>
        <div id="login_box">
            <h1>登录</h1>
            <el-form  ref="form" :model="form" :rules="rules">
                <el-form-item label="账号" label-width="80px" prop="account">
                    <el-input type="text" v-model="form.account" placeholder="请输入账号"/>
                </el-form-item>
                <el-form-item label="密码" label-width="80px" prop="password">
                    <el-input type="password" v-model="form.password" placeholder="请输入密码"/>
                </el-form-item>

                <el-form-item label="角色" label-width="80px">
                    <el-select v-model="form.character" placeholder="请选择角色">
                        <el-option label="医生" value="doctor" />
                        <el-option label="病人" value="patient" />
                        <el-option label="管理员" value="admin" />
                    </el-select>
                </el-form-item>

                <el-form-item>
                    <el-button type="primary" @click="login">登录</el-button>
                    <el-button @click="signUp">注册</el-button>
                </el-form-item>
            </el-form>  
        </div>
    </div>
</template>

<script>
import qs from 'qs'
export default {
    name:'login',
    data() {
        return {
            form: {
            account : '',
            password : '',
            character: '',
            imgSrc: require('../')
            },
            rules: {
                account: [
                    { required: true, message: '请输入账号', trigger: 'blur' },
                    { min:11, max:11, message: '长度为11个字符', trigger: 'blur' }
                ],
                password: [
                    { required: true, message: '请输入密码', trigger: 'blur' },
                    { min:6, max:20, message: '长度为6-20个字符', trigger: 'blur' }
                ]
            }
        }
    },
    methods : {
        login() {
            let param = qs.stringify({
                account:this.form.account,
                password:this.form.password,
                radio:this.form.character
            });
            const that = this;
            const axios = require('axios');
            axios({
                method: 'post',
                url: 'http://localhost:8080/enterSystem/login',
                data: param
            })
              .then(function(response){
                  if(response.data === 'login false') {
                      alert('账号或密码错误');
                  }
                  else {
                      if(that.form.character === 'admin') {
                        that.$router.push({
                            path:'/admin',
                            query:{
                                adminId:response.data
                            }
                        })
                      } else if(that.form.character === 'doctor') {
                          that.$router.push({
                              path:'/doctor',
                              query:{
                                  doctorId:response.data
                              }
                          })
                      } else {
                          that.$router.push({
                              path:'/patient',
                              query:{
                                  patientId:response.data
                              }
                          })
                      }
                  }
              })
            ;
        },
        signUp() {
            //跳转到注册页面
            this.$router.push('/signUp')
        }
    }
}
</script>

<style scoped>
#login_box {
    text-align: center;
    width: 350px;
    border: 2px solid #DCDFE6;
    border-radius: 4px;
    margin: 130px auto;
    padding: 50px;
    padding-bottom: 20px;
    padding-top: 20px;
    padding-left: 0px;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)
    
}

h1 {
    padding-left: 50px;
}
</style>