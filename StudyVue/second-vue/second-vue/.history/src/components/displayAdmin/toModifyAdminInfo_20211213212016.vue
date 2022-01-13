<template>
    <div id="modifyAdminInfo">
        <el-form  ref="form" :model="form" >
            <el-form-item label="adminId" label-width="80px">
                <el-input type="text" v-model="form.adminId" />
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
export default {
    name:'modifyAdminInfo',
    data() {
        return {
            form: {
                adminId: ''
            }
        }
    }
}
</script>

<style scoped>

</style>