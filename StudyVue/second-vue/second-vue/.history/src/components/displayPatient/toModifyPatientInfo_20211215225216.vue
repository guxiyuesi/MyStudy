<template>
    <div id="modifypatientInfoDiv">
        <div class="item">
            <label>patientId: </label>
            <el-input readonly="readonly" v-model="patientId"></el-input>
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
            <label>patientAccount: </label>
            <el-input v-model="patientAccount"></el-input>
        </div>

        <div class="item">
            <label>patientPassword: </label>
            <el-input v-model="patientPassword"></el-input>
        </div>

        <div class="item">
            <label>patientIDNumber: </label>
            <el-input v-model="patientIDNumber"></el-input>
        </div>

        <div class="item" id="button">
                <el-button type="danger" round @click="modify">修改</el-button>
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
            patientId:'',
            patientName:'',
            patientGender:'',
            patientPhoneNumber:'',
            patientAge:'',
            patientPassword:'',
            patientAccount:'',
            patientIDNumber:''
        }
    },
    mounted() {
        // console.log("---");
        // console.log(this.rowValue);
        this.patientId = this.rowValue.patientId;
        this.patientName = this.rowValue.patientName;
        this.patientGender = this.rowValue.patientGender;
        this.patientPhoneNumber = this.rowValue.patientPhoneNumber;
        this.patientAge = this.rowValue.patientAge;
        this.patientPassword = this.rowValue.patientPassword;
        this.patientAccount = this.rowValue.patientAccount;
        this.patientIDNumber = this.rowValue.patientIDNumber;
    }, 
    methods: {
        cancel() {
            this.$emit('changeSonView', 'patientInfo');
        },
        modify() {
            const that = this;
            console.log(that.department);
            let param = qs.stringify({
                patientId : that.patientId,
                patientName : that.patientName,
                patientGender : that.patientGender,
                patientPhoneNumber : that.patientPhoneNumber,
                patientAge : that.patientAge,
                patientPassword : that.patientPassword,
                patientAccount : that.patientAccount,
                patient
            }); 

            this.$axios.post('http://localhost:8080/admin/updatepatient', param)
            .then(function(response){
                console.log(typeof response.data)
                if(response.data == '1') {
                    alert('修改成功');
                } else {
                    alert('修改失败');
                }
            })  

            this.$emit('changeSonView', 'patientInfo');
        }
    }

}
</script>

<style scoped>
#modifypatientInfoDiv{
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