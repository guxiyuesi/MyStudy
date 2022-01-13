<template>
    <div id="signUp_box">
        <h1>注册</h1>
        <el-form  ref="form" :model="form" :rules="rules">
            <el-form-item label="账号" label-width="80px" prop="account">
                <el-input type="text" v-model="form.account" placeholder="请输入账号"/>
            </el-form-item>
            <el-form-item label="密码" label-width="80px" prop="password">
                <el-input type="password" v-model="form.password" placeholder="请输入密码"/>
            </el-form-item>
        
            <el-form-item>
                <el-button type="primary" @click="signUp">注册</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>


<script>

export default {
    name:'signUp',
    data() {
        return {
            form: {
            account : '',
            password : ''
            },
            rules: {
                account: [
                    { required: true, message: '请输入账号', trigger: 'blur' },
                    { min:11, max:11, message: '长度为11个字符', trigger: 'blur' }
                ],
                password: [
                    { required: true, message: '请输入密码', trigger: 'blur' },
                    { min:8, max:20, message: '长度为8-20个字符', trigger: 'blur' }
                ]
            }
        }
    },
    methods : {
        signUp() {
            let param = qs.stringify({
                account:this.form.account,
                password:this.form.password
            });
            const that = this;
            const axios = require('axios');
            axios({
                method:'post',
                url:'http://localhost:8080/enterSytem'
            })
        }
    }
}
</script>

<style scoped>
#signUp_box {
    text-align: center;
    width: 350px;
    border: 2px solid #DCDFE6;
    border-radius: 4px;
    margin: 130px auto;
    padding: 50px;
    padding-bottom: 20px;
    padding-top: 50px;
    padding-left: 0px;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)
}

h1 {
    padding-left: 50px;
}
</style>
