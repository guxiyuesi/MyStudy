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
        let param = qs.stringify({
            doctorId : this.doctorId
        });
        console.log(param);
        this.$axios.post('http://localhost:8080/doctor/getCurrentNumber', param)
            .then(function(response){
                that.number = response.data  
            });
    },
    methods: {
        next() {
            const that = this;
            that.number = that.number + 1;
            let param0 = qs.stringify({
                doctorId : that.doctorId
            })
            that.$axios.post('http://localhost:8080/doctor/updateCurrentNumber', param0)
                .then(function(){
                    let param = qs.stringify({
                        doctorCurrentNumber : that.number
                    })

                that.$axios.post("http://localhost:8080/doctor/getPatientId", param)
                .then(function(response){
                    that.$emit('changePatientId', response.data)
                })
            })
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