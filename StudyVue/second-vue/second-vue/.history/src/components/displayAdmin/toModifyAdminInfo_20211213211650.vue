<template>
    <div id="modifyAdminInfo">
        <el-form  ref="form" :model="form" >
            <el-form-item label="adminId" label-width="80px">
                <el-input type="text" v-model="adminId" />
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
    name:'login',
    data:function() {
        return {
            form
        }
    }
}
</script>

<style scoped>

</style>