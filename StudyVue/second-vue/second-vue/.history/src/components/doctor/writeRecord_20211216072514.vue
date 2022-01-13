<template>
    <div id="modifyDoctorInfoDiv">

        <div class="item">
            <label>doctorName: </label>
            <el-input v-model="doctorName" readonly="readonly"></el-input>
        </div>

        <div class="item">
            <label>patientName: </label>
            <el-input v-model="patientName" readonly="readonly"></el-input>
        </div>

        <div class="item">
            <label>illnessDescription: </label>
            <el-input type="textarea"
                      :rows="4" v-model="illnessDescription" readonly="readonly"></el-input>
        </div>

        <div class="item">
            <label>illnessDescription: </label>
            <el-input type="textarea"
                      :rows="4" v-model="illnessDescription" readonly="readonly"></el-input>
        </div>

         <el-table ref="singleTable" :data="reqMsgSetForm.data" border style="width: 100%" max-height="250">
                        <el-table-column type="selection"></el-table-column>
                        <el-table-column type="index" :resizable="true"></el-table-column>
                        <el-table-column label="字段id" :resizable="true" prop="fldId"></el-table-column>
                        <el-table-column label="保存值" :resizable="true" prop="fixVal"></el-table-column>
                        <el-table-column label="字段名" :resizable="true">
                            <template scope="scope">
                                <el-input v-model="scope.row.fldNm"></el-input>
                            </template>
                        </el-table-column>
                        <el-table-column label="字段描述" :resizable="true">
                            <template scope="scope">
                                <el-input v-model="scope.row.fldDesc"></el-input>
                            </template>
                        </el-table-column>
                        <el-table-column label="默认值" :resizable="true">
                            <template scope="scope">
                                <el-input v-model="scope.row.defVal"></el-input>
                            </template>
                        </el-table-column>
                        <el-table-column v-for="col in cols" :label="col.label">
                            <template scope="scope">
                                <el-input v-model="scope.row[col.prop]" placeholder="请输入内容"></el-input>
                            </template>
                        </el-table-column>
                    </el-table>

    </div>
</template>

<script>
import qs from 'qs'
export default {
    props:["doctorId"],
    data: function() {
        return {
            patientName:'',
            patientGender:'',
            patientAge:''
        }
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