<template>
    <div id="patientInfoDiv">
        <div class="input">
        <label>医生姓名:</label>
        <el-input type="text" readonly="readonly" v-model="doctorName"></el-input>
        <label>病人姓名:</label>
        <el-input type="text" readonly="readonly" v-model="patientName"></el-input>
        <label>病情描述:</label>
        <el-input type="textarea" :rows=4 readonly="readonly" v-model="illnessDescription"></el-input>
        </div>

        <div class="input" id="table">
        <el-table
        :data="tableData"
        border
        style="width: 50%"
        height="300"
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

        <div class="input" id="buttons">
            <el-button type="primary">before</el-button>
            <el-button type="primary">after</el-button>
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
        tableData: [],
        doctorName:'',
        patientName:'',
        illnessDescription:'',
        medicalRecord
      }
    } 

  }
</script>

<style scoped>
#patientInfoDiv{
    margin-left: 10px;
}



.input {
    width: 50%;
    position: absolute;
    margin-left: 302px;
}

#table {
    margin-top: 250px;
    width: 64.6%;
}

#buttons {
    margin-top: 560px;
}

</style>