<template>
    <div id="login_box">
        <el-form id="test" ref="form" :model="form" label-width="80px">
            <el-form-item >
                <el-input type="text" v-model="form.account" placeholder="请输入账号"/>
            </el-form-item>
            <el-form-item >
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
    background-color: red;
}

#test {
    back
}
</style>