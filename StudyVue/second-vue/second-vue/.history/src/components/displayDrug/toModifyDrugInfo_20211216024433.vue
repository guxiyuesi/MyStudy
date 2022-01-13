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

let oldSelect = new Map(), newSelect = new Map();
let oldList = [];

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
                        oldList = response.data;

                        oldSelect.clear();

                        for(let i = 0; i < response.data.length; ++i) {
                            oldSelect.set(response.data[i], false);
                        }
                    })
    },
    methods: {
        modify() {
            const that = this;
            newSelect.clear();
            let mySelect = new Map();
            //记录以前有但被删除的, 被删除的value为false
            for(let i = 0; i < that.checkList[i].length; ++i) {
                mySelect.set(that.checkList[i], true);
                if(Object.prototype.hasOwnProperty.call(oldSelect, that.checkList[i])) {
                    oldSelect.set(that.checkList[i], true);
                }
            }
            console.log("1111111");
            for(let key of oldSelect.keys()) {
                if(!oldSelect.get(key)) {
                    newSelect.set(key, false);
                }
            }
            console.log("22222222");
            //记录以前没有的, 但现在增加的, 增加的value为true
            for(let i = 0; i < oldList.length; ++i) {
                if(mySelect.hasOwnProperty(oldList[i])) {
                    mySelect.set(oldList[i], false);
                }
            }
            console.log("333333333");
            for(let key of mySelect.keys()) {
                if(mySelect.get(key)) {
                    newSelect.set(key, true);
                }
            }
            console.log("22222222");
            let param = qs.stringify({
                drugId : that.drugId,
                drugName : that.drugName,
                drugDescription : that.drugDescription,
                drugNumber : that.drugNumber,
                departments : newSelect
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