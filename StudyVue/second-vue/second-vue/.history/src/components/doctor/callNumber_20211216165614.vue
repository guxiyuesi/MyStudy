<template>
    <div id="modifyDoctorInfoDiv">
        <label >当前号数:</label>
        <el-input v-model="number" readonly="readonly"></el-input>
        <el-button @click="next"></el-button>
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

.item{
    margin: 2px 2px 2px 2px;
    font-size: 20px;
    color:#606266;
}

#button {
    margin-top: 15px;
}
</style>