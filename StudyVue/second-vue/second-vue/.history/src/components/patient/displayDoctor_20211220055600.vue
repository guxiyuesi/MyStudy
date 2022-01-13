<template>
    <div id="patientInfoDiv">
        <div id="checkbox">
            <el-checkbox-group @change="test" v-model="checkList" >
                <el-checkbox label="骨科" border></el-checkbox>
                <el-checkbox label="儿科" border></el-checkbox>
                <el-checkbox label="心内科" border></el-checkbox>
                <el-checkbox label="内分泌科" border></el-checkbox>
            </el-checkbox-group>
        </div>
        <el-table
        :data="tableData"
        border
        style="width: 70%"
        height="665"
        >

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
        prop="doctorCurrentNumber"
        label="number"
        width="120">
        </el-table-column>

        <el-table-column
        prop="doctorCurrentAllNumber"
        label="number"
        width="120">
        </el-table-column>

        <el-table-column
        fixed="right"
        label="操作"
        width="100">
            <template slot-scope="scope">
                <el-button @click="handleClick(scope.row)" type="text" size="small">挂号</el-button>
            </template>
        </el-table-column>

        </el-table> 
    </div>
</template>

<script>
import qs from 'qs'
  export default {
    props:["doctorId", "patientId"],
    mounted(){

    },
    methods: {
        handleClick(row) {
       
        },
        test() {
            let param = qs.string
        }
    },

    data() {
      return {
        tableData: [],
        checkList:[]
      }
    } 

  }
</script>

<style scoped>
#patientInfoDiv{
    margin-left: 10px;
}

#checkbox {
    margin-top: 15px;
    margin-bottom: 15px;
}
</style>