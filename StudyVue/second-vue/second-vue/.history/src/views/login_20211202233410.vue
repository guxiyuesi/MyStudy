<template>
    <div>
        <el-form ref="form" :model="form" label-width="80px">
            <el-form-item label="账号">
                <el-input v-model="form.name"/>
            </el-form-item>
        </el-form>   
    </div>
</template>

<script>
export default {
    name:'login'
}
</script>