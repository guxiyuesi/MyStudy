<template>
    <div id="modifyDoctorInfoDiv">
        <el-form ref="form"  label-width="80px">
            <el-form-item label="doctorId: " class="item">
                <el-input readonly="readonly"></el-input>
            </el-form-item>

            <el-form-item label="doctorName: " class="item">
                <el-input ></el-input>
            </el-form-item>

            <el-form-item label="doctorGender: ">
                <el-input ></el-input>
            </el-form-item>

            <el-form-item label="doctorPhone: ">
                <el-input ></el-input>
            </el-form-item>
        </el-form>
    </div>
</template>

<style scoped>
#modifyDoctorInfoDiv{
    display: block;
    border: solid 2px black;
    width: 30%;
    height: 735px;
    position: relative;
    margin-left: 350px;
}
</style>