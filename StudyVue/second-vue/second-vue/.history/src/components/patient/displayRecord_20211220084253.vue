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
        label="doctorName"
        width="220">
        </el-table-column>


        <el-table-column
        prop="doctorCurrentNum"
        label="currentNumber"
        width="255">
        </el-table-column>



        <el-table-column
        prop="patientCurrentNum"
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
        const that = this;
        let param = qs.stringify({
            patientId : that.patientId
        });

        this.$axios.post('http://localhost:8080/patient/getRegistrationInfo', param)
            .then(function(response){
                console.log(response.data);
                that.tableData = response.data;
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