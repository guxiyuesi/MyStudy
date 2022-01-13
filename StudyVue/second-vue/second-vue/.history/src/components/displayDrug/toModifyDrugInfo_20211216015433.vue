<template>
    <div id="modifyInfoDiv">
        <div class="item">
            <label>drugId: </label>
            <el-input readonly="readonly" v-model="drugId"></el-input>
        </div>

        <div class="item">
            <label>drugName: </label>
            <el-input v-model="drugName"></el-input>
        </div>

        <div class="item">
            <label>drugDescription: </label>
            <el-input type="textarea"
                      :rows="4"      
                      v-model="drugDescription"></el-input>
        </div>

        <div class="item">
            <label>drugNumber: </label>
            <el-input v-model="drugNumber"></el-input>
        </div>

        <el-checkbox-group v-model="checkList" id="checkbox" >
            <el-checkbox label="骨科" border></el-checkbox>
            <el-checkbox label="儿科" border></el-checkbox>
            <el-checkbox label="心内科" border></el-checkbox>
            <el-checkbox label="内分泌科" border></el-checkbox>
        </el-checkbox-group>

        <div class="item" id="button">
                <el-button type="danger" round @click="modify">修改</el-button>
                <el-button type="info" round @click="cancel">取消</el-button>
        </div>
    </div>
</template>

<script>
import qs from 'qs'

let oldSelect;

export default {
    props:["sonView", "rowValue"],
    data:function() {
        return {
            drugId:'',
            drugName:'',
            drugDescription:'',
            drugNumber:'',
            checkList:[]
        }
    }, 
    mounted() {
        const that = this;
        that.drugId = that.rowValue.drugId;
        that.drugName = that.rowValue.drugName;
        that.drugDescription = that.rowValue.drugDescription;
        that.drugNumber = that.rowValue.drugNumber;

        let param = qs.stringify({
            drugId:that.drugId
        });

        this.$axios.post("http://localhost:8080/admin/departmentsForDrug", param)
                    .then(function(response) {
                        that.checkList = response.data;
                        oldSelect = new Map();
                        for(let i = 1; i <= response.data.length; ++i) {
                            oldSelect.set(, )
                        }
                    })
    },
    methods: {
        modify() {
            const that = this;

            let myMap = new Map();

            let param = qs.stringify({
                drugId : that.drugId,
                drugName : that.drugName,
                drugDescription : that.drugDescription,
                drugNumber : that.drugNumber,
                departments : that.checkList
            })

            this.$axios.post("http://localhost:8080/admin/test", param)
                    .then(function(response) {
                        that.checkList = response.data;
                    })

            this.$emit('changeSonView', 'drugInfo');
        }, 
        cancel() {
            this.$emit('changeSonView', 'drugInfo');
        }
        
    }
}
</script>



<style scoped>
#modifyInfoDiv{
    display: block;
    width: 50%;
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

#checkbox {
    margin-top: 15px;
    margin-bottom: 10px;
}
</style>