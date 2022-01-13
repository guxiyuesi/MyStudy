<template>
    <div id="modifyDoctorInfoDiv">
        <div class="item">
            <label>patientAccount: </label>
            <el-input v-model="patientAccount" readonly="readonly"></el-input>
        </div>

        <div class="item">
            <label>patientName: </label>
            <el-input v-model="patientName"></el-input>
        </div>

        <div class="item">
            <label>patientGender: </label>
            <el-input v-model="patientGender"></el-input>
        </div>

        <div class="item">
            <label>patientPhoneNumber: </label>
            <el-input v-model="patientPhoneNumber"></el-input>
        </div>

        <div class="item">
            <label>patientAge: </label>
            <el-input v-model="patientAge"></el-input>
        </div>

        <div class="item">
            <label>patientIDNumber: </label><br/>
            <el-input v-model="patientIDNumber"></el-input>
        </div>


        <div class="item">
            <label>patientPassword: </label>
            <el-input v-model="patientPassword"></el-input>
        </div>

        <div class="item" id="button">
                <el-button type="danger" round @click="modify">修改</el-button>
        </div>
    </div>
</template>

<script>
import qs from 'qs'
export default {
    props:["doctorId", "patientId"],
    data: function() {
        return {
            patientAccount:'',
            patientName:'',
            patientGender:'',
            patientPhoneNumber:'',
            patientAge:'',
            patientIDNumber:'',
            patientPassword:''    
        }
    },
    mounted() {
        const that = this;
        console.log(that.patientAccount);
        let param = qs.stringify({
                id : that.patientId
        });
        this.$axios.post('http://localhost:8080/patient/patientInfo', param)
        .then(function(response) {
            console.log(response.data);
            that.patientAccount = response.data.patientAccount;
            that.patientName = response.data.patientName;
            that.patientGender = response.data.patientGender;
            that.patientPhoneNumber = response.data.patientPhoneNumber;
            that.patientAge = response.data.patientAge;
            that.patientIDNumber = response.data.patientIDNumber;
            that.patientPassword = response.data.patientPassword;
        });


    }, 
    methods: {
        modify() {
            const that = this;
            let param = qs.stringify({
                patientId : that.patientId,
                patientAccount : that.patientAccount,
                patientName : that.patientName,
                patientGender : that.patientGender,
                patientPhoneNumber : that.patientPhoneNumber,
                patientAge : that.patientAge,
                patient
            }); 

            this.$axios.post('http://localhost:8080/doctor/updateDoctor', param)
            .then(function(response){
                console.log(response.data)
                if(response.data === '1') {
                    alert('修改失败');
                } else {
                    alert('修改成功');
                }
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