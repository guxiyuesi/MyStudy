<template>
    <div id="patientInfoDiv">
        <div>
            <div>
                <label>请输入身份证号:</label>
                <el-input>
            </div>
        </div>
        <div id="table">
            <el-table
            :data="tableData"
            border
            style="width: 70%"
            height="665">

            <el-table-column
            fixed
            prop="patientId"
            label="id"
            width="150">
            </el-table-column>

            <el-table-column
            prop="patientName"
            label="name"
            width="120">
            </el-table-column>

            <el-table-column
            prop="patientGender"
            label="gender"
            width="120">
            </el-table-column>

            <el-table-column
            prop="patientPhoneNumber"
            label="phone"
            width="120">
            </el-table-column>

            <el-table-column
            prop="patientAge"
            label="age"
            width="120">
            </el-table-column>


            <el-table-column
            prop="patientPassword"
            label="password"
            width="120">
            </el-table-column>

            <el-table-column
            fixed="right"
            label="操作"
            width="100">
                <template slot-scope="scope">
                    <el-button @click="handleClick(scope.row)" type="text" size="small">编辑</el-button>
                </template>
            </el-table-column>

            </el-table>
        </div>
    </div>
</template>

<style scoped>
#table{
    display: none;
}
</style>

