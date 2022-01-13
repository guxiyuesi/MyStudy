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