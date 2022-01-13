<template>
    <div >
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
</template>

<script>
export default {

}
</script>