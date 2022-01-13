<template>
    <div id="modifyDoctorInfoDiv">

    </div>
</template>

<script>
import qs from 'qs'
export default {
    props:["doctorId", "patientId"],
    data: function() {
        
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
                that.$emit('changePatientId', response.data.patientId);
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