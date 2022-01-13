<template>
    <div id="signUp_box">
        <h1>登录</h1>
        <el-form  ref="form" :model="form" :rules="rules">
            <el-form-item label="账号" label-width="80px" prop="account">
                <el-input type="text" v-model="form.account" placeholder="请输入账号"/>
            </el-form-item>
            <el-form-item label="密码" label-width="80px" prop="password">
                <el-input type="password" v-model="form.password" placeholder="请输入密码"/>
            </el-form-item>
        
            <el-form-item>
                <el-button @click="signUp">注册</el-button>
            </el-form-item>    
        </el-form>
    </div>
</template>