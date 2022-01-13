<template>
    <div id="patientInfoDiv">
        <el-table
        :data="tableData"
        border
        style="width: 50%"
        height="665"
        >

        <el-table-column
        prop="doctorName"
        label="name"
        width="220">
        </el-table-column>


        <el-table-column
        prop="doctorCurrentNumber"
        label="currentNumber"
        width="255">
        </el-table-column>



        <el-table-column
        prop="patientNumber"
        label="patientNumber"
        width="270">
        </el-table-column>

        </el-table> 
    </div>
</template>

<script>
import qs from 'qs'
  export default {
    props:["doctorId", "patientId"],
    mounted(){
        let param = qs.stringify({
            patientId : this.patientId
        });

        this.$axios.post('http://localhost:8080/patient/getRegistrationInfo', param)
            .then(function(response){
                
            })

    },

    data() {
      return {
        tableData: []
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