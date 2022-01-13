<template>
    <div id="modifyDoctorInfoDiv">
        <label >当前号数:</label>
        <el-input v-model="number" readonly="readonly"></el-input>
        <el-button @click="next" type="primary" id="nextButton">叫号</el-button>
    </div>
</template>

<script>
import qs from 'qs'
export default {
    props:["doctorId", "patientId"],
    data:function() {
        return {
            number:''
        }
    },
    mounted() {
        const that = this;
        theDoctorId = that.doctorId;
        console.log()
        let param = qs.stringify({
            doctorId : that.doctorId
        });
        console.log(param);
        this.$axios.post('http://localhost:8080/doctor/doctorById', param)
            .then(function(response){
                console.log(response.data);
                
            })
    },
    methods: {
        next() {

        }
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
    font-size: 20px;
}

#nextButton {
    margin-top: 10px;
}
</style>