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
            <el-select placeholder="请选择科室" v-model="department">
                <el-option label="心内科" value="1"></el-option>
                <el-option label="骨科" value="2"></el-option>
                <el-option label="内分泌" value="3"></el-option>
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
    </div>
</template>

<script>
export default {
    name: modifyDoctorInfo,
    props:["sonView", "rowValue"],
    data: function() {
        return {
            doctorId:'',
            doctorName:'',
            doctorGender:'',
            doctorPhoneNumber:'',
            doctorAge:'',
            department:'',
            doctorDefaultAllNumber:'',
            doctorPassword:''
        }
    },
    mounted() {
        con
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
</style>