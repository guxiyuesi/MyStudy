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
            height="470">

                <el-table-column
                fixed
                prop="drugName"
                label="name"
                width="150">
                <template slot-scope="scope">
                    <el-input v-model=""></el-input>
                </template>

                <el-input v-model="input" placeholder="数量" @></el-input>
                </el-table-column>

                <el-table-column
                fixed
                prop="drugNum"
                label="num"
                width="145">
                    <template slot-scope="scope">
                        
                    </template>
                </el-table-column>

                <el-table-column
                fixed
                label="操作"
                width="150">
                <template slot-scope="scope">
                    <el-button  @click="handleClick(scope.row)" type="text" size="small">取消</el-button>
                </template>
                </el-table-column>
            </el-table>
        </div>
        
        <div class="query">
            <el-input></el-input>
            
            <el-button id="selectButton" type="primary">查询</el-button>
        </div>
        <div class="query" id="drugTable">
            <el-table
            :data="tableAllData"
            border

            height="470">

                <el-table-column
                fixed
                prop="drugAllName"
                label="allName"
                width="150">
                </el-table-column>
                <el-table-column
                fixed
                prop="drugAllNum"
                label="AllNumber"
                width="150">
                </el-table-column>

                <template slot-scope="scope">
                    <el-button  @click="cancel(scope.row)" type="text" size="small">选择</el-button>
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
            tableData:[{
                drugName: '111',
                drugNum: '222'
            }, {
                drugName: '333',
                drugNum: '444'
            }],
            tableAllData:[],
            doctorName:'',
            patientName:'',
            illnessDescription:'',
            input:''
        }
    }, 
    
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
    margin-bottom: 10px;
}

#drugTable {
    margin-top: -620px;
}
</style>