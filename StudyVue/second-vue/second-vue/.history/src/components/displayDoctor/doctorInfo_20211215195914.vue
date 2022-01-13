<template>
    <div id="doctorInfoDiv">
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
                <el-button
                @click.native.prevent="deleteRow(scope.$index, tableData)"
                type="text"
                size="small">
                移除
                </el-button>
            </template>
        </el-table-column>

        </el-table>
    </div>
</template>

<script>
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
      deleteRow(index, rows) {
        rows.splice(index, 1);
        
        const that = this;
        let param = qs.stringify({
            doctorId : that.rows[index].doctorId
        }); 

        this.$axios.post('http://localhost:8080/admin/deleteDoctor', param)
        .then(function(response){
            console.log(typeof response.data)
            if(response.data == '1') {
                alert('修改成功');
            } else {
                alert('修改失败');
            }
        });
      }
    },

    data() {
      return {
        tableData: [],
      }
    } 

  }
</script>

<style scoped>
#doctorInfoDiv{
    margin-left: 10px;
}
</style>