<template>
    <div>
        <el-col :span="12">
            <el-menu default-active="2" class="el-menu-vertical-demo"
                @open="handleOpen" @close="handleClose"
                background-color="#545c64" text-color="#fff" 
                active-text-color="#ffd04b">
                <el-menu-item index="1">
                    <i class="el-icon-menu"></i>
                    <span slot="title">个人信息</span>
                </el-menu-item>
                <el-menu-item index="2">
                    <i class="el-icon-document"></i>
                    <span slot="title">医生信息</span>
                </el-menu-item>
                <el-menu-item index="3">
                    <i class="el-icon-setting"></i>
                    <span slot="title"></span>
                </el-menu-item>
                <el-menu-item index="4">
                    <i class="el-icon-setting"></i>
                    <span slot="title">导航四</span>
                </el-menu-item>
            </el-menu>
        </el-col>


    </div>
</template>