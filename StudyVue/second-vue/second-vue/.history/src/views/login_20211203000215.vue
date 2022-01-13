<template>
    <div id="login_box">
        <el-form  ref="form" :model="form" label-width="40px">
            <el-form-item label="账号">
                <el-input type="text" v-model="form.account" placeholder="请输入账号"/>
            </el-form-item>
            <el-form-item label="密码">
                <el-input type="password" v-model="form.password" placeholder="请输入密码"/>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="login">立即创建</el-button>
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
    width: 350px;
    border: 2px solid #DCDFE6;
    border-radius: 4px;
    margin: 130px auto;
}
</style>