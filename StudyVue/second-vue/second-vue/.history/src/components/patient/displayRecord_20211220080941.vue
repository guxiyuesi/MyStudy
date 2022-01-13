<template>
    <div id="patientInfoDiv">
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
        prop="doctorCurrentNumber"
        label="currentNumber"
        width="120">
        </el-table-column>



        <el-table-column
        prop="patientNumber"
        label="patientNumber"
        width="120">
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
            if(row.registrationNumber > row.doctorCurrentAllNumber) {
                alert("挂号已满!请选择其他医生");
                return;
            }
            let param = qs.stringify({
                doctorId : row.doctorId,
                patientId : this.patientId,
                patientCurrentNum : row.registrationNumber
            });

            this.$axios.post('http://localhost:8080/patient/registration', param)
                .then(function(){
                    alert("挂号成功!");
                })
        },
        test() {
            const that = this;
            let param = qs.stringify({
                departmentsString : JSON.stringify(that.checkList)
            })
            console.log(this.checkList);
            this.$axios.post('http://localhost:8080/patient/getDoctorsByDepartments', param)
                .then(function(response) {
                    that.tableData = response.data;
                });
            
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