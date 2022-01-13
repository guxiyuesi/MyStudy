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
                      :rows="4" v-model="illnessDescription" ></el-input>
        </div>


        <div class="item">
            <el-table
            :data="tableData"
            border
            style="width: 67.5%"
            height="470">

                <el-table-column
                fixed
                prop="drugName"
                label="name"
                width="150">
                </el-table-column>

                <el-table-column
                fixed
                prop="drugNum"
                label="num"
                width="150">
                    <el-input></el-input>
                </el-table-column>
            </el-table>
        </div>
        
        <div class="query">
            <el-input></el-input>
            <el-button type="primary">查询</el-button>
        </div>
        <div class="query" id="drugTable">
            <el-table
            :data="tableDataALL"
            border
            style="width: 67.5%"
            height="470">

                <el-table-column
                fixed
                prop="drugName"
                label="name"
                width="150">
                </el-table-column>

                <el-table-column
                fixed
                prop="drugNum"
                label="AllNumber"
                width="150">
                </el-table-column>

                <template slot-scope="scope">
                    <el-button id="selectButton" @click="handleClick(scope.row)" type="text" size="small">选择</el-button>
                </template>
            </el-table>
        </div>
    </div>
</template>

<script>
import qs from 'qs'
export default {
    props:["doctorId"],
    data: function() {
        return {
            tableData:[[1, 2], [2, 3]]
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

.query {
    position: fixed;
    /* border: solid 2px black; */
    height: 735px;
    width: 30%;
    margin-left: 550px;
    margin-top: -735px;
    z-index: 99;
}

#selectButton {
    margin-top: 10px;
    margin
}

#drugTable {
    margin-top: -620px;
}
</style>