<template>
    <div id="modifyDoctorInfoDiv">
        <div class="item">
            <label>doctorId: </label>
            <el-input readonly="readonly"></el-input>
        </div>

        <div class="item">
            <label>doctorName: </label>
            <el-input></el-input>
        </div>

        <div class="item">
            <label>doctorGender: </label>
            <el-input></el-input>
        </div>

        <div class="item">
            <label>doctorPhoneNumber: </label>
            <el-input></el-input>
        </div>

        <div class="item">
            <label>doctorAge: </label>
            <el-input></el-input>
        </div>

        <div class="item">
            <label>departmentName: </label><br/>
            <el-select placeholder="请选择科室">
                <el-option label="" value="q"></el-option>
                <el-option label="" value=""></el-option>
            </el-select>
        </div>

        <div class="item">
            <label>doctorDefaultAllNumber: </label>
            <el-input></el-input>
        </div>

        <div class="item">
            <label>doctorPassword: </label>
            <el-input></el-input>
        </div>
    </div>
</template>

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