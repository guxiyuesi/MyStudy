<template>
    <div id="patientInfoDiv">
            <div id="IDNumber">
                <label>请输入身份证号:</label>
                <el-input v-model="IDNumber"></el-input>
                <el-button type="primary" round @click="select">查询</el-button>
            </div>
        <div id="table" >
            <el-table
            :data="tableData"
            border
            style="width: 70%"
            height="500"
            >

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

<script>
import qs from 'qs'
export default {
    data:function() {
        return {
            tableData: [],
            IDNumber: '',
        }
    },
    mounted() {
        that.$set(that.tableData, 0, []);
    },
    methods: {
        select() {
            const that = this;
            let param = qs.stringify({
                patientIDNumber : this.IDNumber
            }); 

            this.$axios.post('http://localhost:8080/admin/selectPatientByIDNumber', param)
            .then(function(response){
                if(response.data === null) {
                    alert('查询失败');
                    that.$set(that.tableData, 0, []);
                } else {
                    alert('查询成功');
                    that.$set(that.tableData, 0, response.data);
                }
            });

        },
        handleClick(row) {
            this.$emit('changeRowValue', row);
            this.$emit('changeSonView', 'modifyDoctorInfo');
        }
    }
}
</script>

<style scoped>

#IDNumber {
    display: block;
    width: 30%;
    position: relative;
    margin-left: 350px;
}

#table {
    display: block;
    width: 85%;
    position: relative;
    margin-left: 350px;
}
</style>

