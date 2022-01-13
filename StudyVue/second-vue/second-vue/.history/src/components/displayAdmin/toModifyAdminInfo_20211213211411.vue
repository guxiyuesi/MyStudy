<template>
    <div id="modifyAdminInfo">
        <el-form  ref="form" :model="form" >
            <el-form-item label="账号" label-width="80px" prop="account">
                <el-input type="text" v-model="form.account" placeholder="请输入账号"/>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="login">登录</el-button>
                <el-button @click="signUp">注册</el-button>
            </el-form-item>
        </el-form>   
    </div>
</template>

<script>
export default {
    name:'login'
}
</script>

<style scoped>

</style>