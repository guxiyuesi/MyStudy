<template>
    <div>
        <el-table
        :data="tableData"
        border
        style="width: 80%">
        <el-table-column
        fixed
        prop="doctorId"
        label="id"
        width="150">
        </el-table-column>

        <el-table-column
        prop="doctorName"
        label="name"
        width="120">
        </el-table-column>
        </el-table>
    </div>
</template>

<script>
export default {
    
}
</script>