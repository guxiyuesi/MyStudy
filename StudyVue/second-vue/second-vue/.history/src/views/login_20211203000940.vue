<template>
    <div id="login_box">
        <div><h1>登录</h1></div>
        <el-form  ref="form" :model="form" r>
            <el-form-item label="账号" label-width="40px">
                <el-input type="text" v-model="form.account" placeholder="请输入账号"/>
            </el-form-item>
            <el-form-item label="密码" label-width="40px">
                <el-input type="password" v-model="form.password" placeholder="请输入密码"/>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="login">登录</el-button>
                <el-button>注册</el-button>
            </el-form-item>
        </el-form>   
    </div>
</template>

<script>
export default {
    name:'login',
    data() {
        return {
            form: {
            account : '',
            password : ''
            }
        }
    },
    methods : {
        login() {
            alert("hello world");
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
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)
}
</style>