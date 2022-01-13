<template>
    <div id="modifyDoctorInfoDiv">
        hell o
        <!-- <label >当前号数:</label>
        <el-input v-model="number" readonly="readonly"></el-input> -->
        <!-- <el-button @click="next" id="nextButton">叫号</el-button> -->
    </div>
</template>

<script>
import qs from 'qs'
export default {
    props:["doctorId", "patientId"],
    data: function() {
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

#nextButton {
    margin-top: 10px;
}
</style>