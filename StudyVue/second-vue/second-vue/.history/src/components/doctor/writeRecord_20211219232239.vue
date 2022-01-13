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
                prop="theDrugId"
                label="id"
                width="50">
                </el-table-column>

                <el-table-column
                prop="theDrugName"
                label="name"
                width="220">
                </el-table-column>

                <el-table-column
                prop="theDrugNumber"
                label="num"
                width="145">
                    <template slot-scope="scope">
                        <el-input @input="input(scope.row.theDrugNumber)" v-model="newData"></el-input>
                    </template>
                </el-table-column>

                <el-table-column
                fixed="right"
                label="操作"
                width="70">
                <template slot-scope="scope">
                    <el-button  @click.native.prevent="deleteRow(scope.$index, tableData)" type="text" size="small">取消</el-button>
                </template>
                </el-table-column>
            </el-table>
        </div>
        
            <!-- <div class="query">
                <el-input></el-input>
                
                <el-button id="selectButton" type="primary">查询</el-button>
            </div> -->
        <div class="query" id="drugTable">
            <el-table
            :data="tableAllData"
            border

            height="470">

                <el-table-column
                prop="drugId"
                label="drugId"
                width="50">
                </el-table-column>

                <el-table-column
                prop="drugName"
                label="allName"
                width="200">
                </el-table-column>
                <el-table-column
                prop="drugNumber"
                label="AllNumber"
                width="100">
                </el-table-column>

                <el-table-column
                fixed="right"
                label="操作"
                width="70">
                <template slot-scope="scope">
                    <el-button  @click="select(scope.row)" type="text" size="small">选择</el-button>
                </template>
                </el-table-column>

            </el-table>
            <el-button type="primary" id="affirm" @click="affirm">确认</el-button>
        </div>
    </div>
</template>

<script>
import qs from 'qs'
export default {
    props:["doctorId", "patientId"],
    data: function() {
        return {
            newData:0,
            tableData:[],       
            tableAllData:[],
            doctorName:'',
            patientName:'',
            illnessDescription:'',
            drugNum:'',
            departmentId:'',
            drugAllId:'',
            drugId:'',
            theDrugId:'',
            theDrugName:'',
            theDrugNumber:''

        }
    }, 
    mounted() {
        const that = this;
        let param = qs.stringify({
            theDoctorId : that.doctorId,
            thePatientId : that.patientId
        });

        this.$axios.post('http://localhost:8080/doctor/doctorAndPatient', param)
            .then(function(response) {
                that.departmentId = response.data.departmentId;
                that.doctorName = response.data.doctorName;
                that.patientName = response.data.patientName;

                let param2 = qs.stringify({
                    theDepartmentId: that.departmentId
                });

                that.$axios.post('http://localhost:8080/doctor/getDrugsByDepartmentId', param2)
                .then(function(response){
                    that.tableAllData = response.data;
                })
            });
    },
    methods: {
        input(number){
            theDrugNumber = that.newData;
        },
        select(row) {
            const that = this;
            let theDrugs = {
                theDrugId : '',
                theDrugName : '',
                theDrugNumber : ''
            };
            theDrugs.theDrugId = row.drugId;
            theDrugs.theDrugName = row.drugName;
            theDrugs.theDrugNumber = 0;
            
            let table = that.tableData;
            for(let arr of table) {
                if(arr.theDrugId === theDrugs.theDrugId) {
                    return;
                }
            }
            table.push(theDrugs);
            that.tableData = table;
        }, 
        deleteRow(index, row) {
            row.splice(index, 1);
        },
        affirm() {
            const that = this;
            let param = qs.stringify({
                doctorId : that.doctorId,
                patientId : that.patientId,
                drugs: JSON.stringify(that.tableData)
            })

            this.$axios.post("http://localhost:8080/doctor/writeRecord", param)
                .then(function(response) {

                })
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

#affirm {
    margin-top: 80px;
}
</style>