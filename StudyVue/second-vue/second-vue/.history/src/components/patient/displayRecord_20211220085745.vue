<template>
    <div id="patientInfoDiv">
        <div class="input">
        <el-input type="text"></el-input>
        </div>
        <div>
        <el-table
        :data="tableData"
        border
        style="width: 50%"
        height="665"
        >

        <el-table-column
        prop="drugName"
        label="drugName"
        width="220">
        </el-table-column>

        <el-table-column
        prop="drugNumber"
        label="drugNumber"
        width="270">
        </el-table-column>

        </el-table> 
        </div>
    </div>
</template>

<script>
import qs from 'qs'
  export default {
    props:["doctorId", "patientId"],
    mounted(){
        

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

.input {
    width: 30%;
}
</style>