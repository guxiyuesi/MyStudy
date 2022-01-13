<template>
    <div id="modifyDoctorInfoDiv">

        <div class="item">
            <label>doctorName: </label>
            <el-input v-model="doctorName" readonly="readonly"></el-input>
        </div>

        <div class="item">
            <label>patientName: </label>
            <el-input v-model="patientName" readonly="readonly"></el-input>
        </div>

        <div class="item">
            <label>illnessDescription: </label>
            <el-input type="textarea"
                      :rows="4" v-model="illnessDescription" ></el-input>
        </div>


        <div class="item">
            <el-table
            :data="tableData"
            border
            style="width: 70%"
            height="665">

            <el-table-column
            fixed
            prop="doctorId"
            label="id"
            width="150">
        </el-table-column>
        </div>
        

    </div>
</template>

<script>
import qs from 'qs'
export default {
    props:["doctorId"],
    data: function() {
        return {
            patientName:'',
            patientGender:'',
            patientAge:''
        }
    }, 
    mounted() {
        const that = this;
        let param = qs.stringify({
            id:this.doctorId
        });

        this.$axios.post('http://localhost:8080/doctor/currentPatient', param)
            .then(function(response){
                that.patientName=response.data.patientName;
                that.patientGender=response.data.patientGender;
                that.patientAge = response.data.patientAge;
            })
    }
}
</script>





<style scoped>
#modifyDoctorInfoDiv{
    display: block;
    width: 30%;
    height: 735px;
    position: relative;
    margin-left: 350px;
}

.item{
    margin: 2px 2px 2px 2px;
    font-size: 20px;
    color:#606266;
}

#button {
    margin-top: 15px;
}
</style>