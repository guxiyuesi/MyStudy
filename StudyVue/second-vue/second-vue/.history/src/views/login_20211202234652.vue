<template>
    <div id="login_box">
        <h1>登录</h1>
        <el-form ref="form" :model="form" label-width="80px">
            <el-form-item label="账号">
                <el-input v-model="form.account"/>
            </el-form-item>
            <el-form-item label="密码">
                <el-input v-model="form.password" />
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
    border: 2px solid black;
    margin:150px auto;

    padding: 20px;
}
</style>