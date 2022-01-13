<template>
    <div id="modifyDoctorInfoDiv">
        <div class="item">
            <label>doctorId: </label>
            <el-input readonly="readonly" v-model="theDoctorId"></el-input>
        </div>

        <div class="item">
            <label>doctorName: </label>
            <el-input v-model="doctorName" readonly="readonly"></el-input>
        </div>

        <div class="item">
            <label>doctorGender: </label>
            <el-input v-model="doctorGender"></el-input>
        </div>

        <div class="item">
            <label>doctorPhoneNumber: </label>
            <el-input v-model="doctorPhoneNumber"></el-input>
        </div>

        <div class="item">
            <label>doctorAge: </label>
            <el-input v-model="doctorAge"></el-input>
        </div>

        <div class="item">
            <label>departmentName: </label><br/>
            <el-input v-model="departmentName" readonly="readonly"></el-input>
        </div>

        <div class="item">
            <label>doctorDefaultAllNumber: </label>
            <el-input v-model="doctorDefaultAllNumber" readonly="readonly"></el-input>
        </div>

        <div class="item">
            <label>doctorPassword: </label>
            <el-input v-model="doctorPassword"></el-input>
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
            theDoctorId:'',
            doctorName:'',
            doctorGender:'',
            doctorPhoneNumber:'',
            doctorAge:'',
            departmentName:'',
            doctorDefaultAllNumber:'',
            doctorPassword:''

        }
    },
    mounted() {
        const that = this;
        let param = qs.stringify({
                id : this.doctorId
        });
        this.$axios.post('http://localhost:8080/doctor/doctorById', param)
        .then(function(response) {
            console.log(response.data);
            that.theDoctorId = response.data.doctorId;
            that.doctorName = response.data.doctorName;
            that.doctorGender = response.data.doctorGender;
            that.doctorPhoneNumber = response.data.doctorPhoneNumber;
            that.doctorAge = response.data.doctorAge;
            that.departmentName = response.data.departmentName;
            that.doctorDefaultAllNumber = response.data.doctorDefaultAllNumber;
            that.doctorPassword = response.data.doctorPassword;
        });


    }, 
    methods: {
        modify() {
            const that = this;
            let param = qs.stringify({
                doctorId : that.doctorId,
                doctorName : that.doctorName,
                doctorGender : that.doctorGender,
                doctorPhoneNumber : that.doctorPhoneNumber,
                doctorAge : that.doctorAge,
                departmentId : that.department,
                doctorDefaultAllNumber : that.doctorDefaultAllNumber,
                doctorPassword : that.doctorPassword,
                isDoctor : that.isDoctor
            }); 

            this.$axios.post('http://localhost:8080/admin/updateDoctor', param)
            .then(function(response){
                console.log(typeof response.data)
                if(response.data == '1') {
                    alert('修改成功');
                } else {
                    alert('修改失败');
                }
            })  

            this.$emit('changeSonView', 'doctorInfo');
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