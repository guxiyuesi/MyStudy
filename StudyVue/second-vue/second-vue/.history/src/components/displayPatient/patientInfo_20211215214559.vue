<template>
    <div id="patientInfoDiv">
        <div>
            <div id="IDNumber">
                <label>请输入身份证号:</label>
                <el-input v-model="IDNumber"></el-input>
                <el-button type="primary" round @click="select">查询</el-button>
            </div>
        </div>
        <div id="table" :style="{display:">
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

<script>
import qs from 'qs'
export default {
    data:function() {
        return {
            tableData: [],
            IDNumber: ''
        }
    },
    methods: {
        select() {
            const that = this;
            let param = qs.stringify({
                patientIDNumber : this.IDNumber
            }); 

            this.$axios.post('http://localhost:8080/admin/selectPatientByIDNumber', param)
            .then(function(response){
                console.log(typeof response.data)
                if(response.data == '1') {
                    alert('查询成功');
                    // 通过setAttribute 修改style属性值
                    let attributeBtn = document.getElementById("table");
                    attributeBtn.addEventListener('click', function(e) {
                        testNode.setAttribute('style', 'display:block;')
                    }, false)
                } else {
                    alert('查询失败');
                    let attributeBtn = document.getElementById("table");
                    attributeBtn.addEventListener('click', function(e) {
                        testNode.setAttribute('style', 'display:none;')
                    }, false)
                }
            })  

            this.$emit('changeSonView', 'doctorInfo'); 
        }
    }
}
</script>

<style scoped>
#table{
    display: none;
}

#IDNumber {
    display: block;
    width: 30%;
    height: 735px;
    position: relative;
    margin-left: 350px;
}
</style>

