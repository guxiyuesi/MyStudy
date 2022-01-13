<template>
    <div>
        <el-table
        :data="tableData"
        border
        style="width: 70%">
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

        <el-table-column
        prop="doctorGender"
        label="gender"
        width="120">
        </el-table-column>

        <el-table-column
        prop="doctorPhoneNumber"
        label="phone"
        width="120">
        </el-table-column>

        <el-table-column
        prop="doctorAge"
        label="age"
        width="120">
        </el-table-column>

        <el-table-column
        prop="departmentName"
        label="department"
        width="120">
        </el-table-column>

        <el-table-column
        prop="doctorDefaultAllNumber"
        label="number"
        width="120">
        </el-table-column>

        <el-table-column
        prop="doctorPassword"
        label="password"
        width="120">
        </el-table-column>

        <el-table-column
        prop="isDoctor"
        label="isDoctor"
        width="120">
        </el-table-column>

        <el-table-column
        fixed="right"
        label="操作"
        width="100">
            <template slot-scope="scope">
                <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
                <el-button type="text" size="small">编辑</el-button>
            </template>
        </el-table-column>

        </el-table>
    </div>
</template>

<script>
export default {
    
}
</script>