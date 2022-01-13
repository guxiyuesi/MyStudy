<template>
    <div id="doctorInfoDiv">
        <el-button id="add" type="primary" round @click="addDoctor">新增</el-button>
        <el-table
        :data="tableData"
        border
        style="width: 70%"
        height="735"
        >
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
                <el-button @click="handleClick(scope.row)" type="text" size="small">编辑</el-button>
            </template>
        </el-table-column>

        </el-table>
    </div>
</template>

<script>
import qs from 'qs'
  export default {
    props:["sonView", "rowValue"],
    mounted(){
        const that = this;
        this.$axios.post('http://localhost:8080/admin/doctors')
        .then(function(response){
            that.tableData = response.data;
        });
    },
    methods: {
      handleClick(row) {
        this.$emit('changeRowValue', row);
        this.$emit('changeSonView', 'modifyDoctorInfo');
      },
      addDoctor() {
        console.log('hello world!');
        this.$emit('changeSonView', 'addDoctor');
      }
    },

    data() {
      return {
        tableData: []
      }
    } 

  }
</script>

<style scoped>
#doctorInfoDiv{
    margin-left: 10px;
}

#add {
    margin-top: 15px;
}
</style>