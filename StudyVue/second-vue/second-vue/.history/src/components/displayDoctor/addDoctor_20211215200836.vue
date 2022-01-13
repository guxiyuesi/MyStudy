<template>
    <div id="modifyDoctorInfoDiv">
        <div class="item">
            <label>doctorId: </label>
            <el-input readonly="readonly" v-model="doctorId"></el-input>
        </div>

        <div class="item">
            <label>doctorName: </label>
            <el-input v-model="doctorName"></el-input>
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
            <el-select placeholder="请选择科室" v-model="department" >
                <el-option label="心内科" value="1"></el-option>
                <el-option label="骨科" value="2"></el-option>
                <el-option label="内分泌科" value="3"></el-option>
                <el-option label="儿科" value="4"></el-option>
            </el-select>
        </div>

        <div class="item">
            <label>doctorDefaultAllNumber: </label>
            <el-input v-model="doctorDefaultAllNumber"></el-input>
        </div>

        <div class="item">
            <label>doctorPassword: </label>
            <el-input v-model="doctorPassword"></el-input>
        </div>

        <div class="item">
            <label>isDoctor: </label>
            <el-input v-model="isDoctor"></el-input>
        </div>

        <div class="item" id="button">
                <el-button type="success" round @click="">确认</el-button>
                <el-button type="info" round @click="cancel">取消</el-button>
        </div>
    </div>
</template>

<script>
import qs from 'qs'
export default {
    props:["sonView", "rowValue"],
    data: function() {
        return {
            doctorId:'',
            doctorName:'',
            doctorGender:'',
            doctorPhoneNumber:'',
            doctorAge:'',
            department:0,
            doctorDefaultAllNumber:'',
            doctorPassword:'',
            isDoctor:0

        }
    },
    mounted() {
        // console.log("---");
        // console.log(this.rowValue);
        this.doctorId = this.rowValue.doctorId;
        this.doctorName = this.rowValue.doctorName;
        this.doctorGender = this.rowValue.doctorGender;
        this.doctorPhoneNumber = this.rowValue.doctorPhoneNumber;
        this.doctorAge = this.rowValue.doctorAge;
        this.department = this.rowValue.departmentId;
        this.doctorDefaultAllNumber = this.rowValue.doctorDefaultAllNumber;
        this.doctorPassword = this.rowValue.doctorPassword;
        this.isDoctor = this.rowValue.isDoctor;
    }, 
    methods: {
        cancel() {

            this.$emit('changeSonView', 'doctorInfo');
        },
        modify() {
            const that = this;
            console.log(that.department);
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