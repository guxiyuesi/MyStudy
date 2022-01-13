<template>
    <div id="modifyDoctorInfoDiv">

        <div class="item">
            <label>patientName: </label>
            <el-input v-model="patientName" readonly="readonly"></el-input>
        </div>

        <div class="item">
            <label>patientGender: </label>
            <el-input v-model="patientGender" readonly="readonly"></el-input>
        </div>

        <div class="item">
            <label>patientAge: </label>
            <el-input v-model="patientAge" readonly="readonly"></el-input>
        </div>

    </div>
</template>

<script>
export default {
    props:['']
    data: function() {
        return {
            patientName:'',
            patientGender:'',
            patientAge:''
        }
    }, 
    mounted() {

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