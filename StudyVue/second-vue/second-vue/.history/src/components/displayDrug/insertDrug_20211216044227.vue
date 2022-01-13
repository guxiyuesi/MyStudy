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
                <el-button type="primary" round @click="modify">增加</el-button>
                <el-button type="info" round @click="cancel">取消</el-button>
        </div>
    </div>
</template>

<script>
import qs from 'qs'

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
    
    methods: {
        modify() {
            const that = this;
            newSelect.clear();
            let mySelect = new Map();
            //记录以前有但被删除的, 被删除的value为false
            for(let i = 0; i < that.checkList.length; ++i) {
                mySelect.set(that.checkList[i], true);
                if(oldSelect.get(that.checkList[i]) != undefined) {
                    oldSelect.set(that.checkList[i], true);
                }
            }
            for(let key of oldSelect.keys()) {
                if(!oldSelect.get(key)) {
                    newSelect.set(key, false);
                }
            }
            //记录以前没有的, 但现在增加的, 增加的value为true
            for(let i = 0; i < oldList.length; ++i) {
                // console.log("----------");
                // console.log(oldList[i]);
                
                if(mySelect.get(oldList[i]) != undefined) {
                    mySelect.set(oldList[i], false);

                }
            }

            for(let key of mySelect.keys()) {
                if(mySelect.get(key)) {
                    newSelect.set(key, true);
                }
            }

            let getObj = function() {
                let obj= Object.create(null);
                for (let key of newSelect.keys()) {
                    obj[key] = newSelect.get(key);
                }
                return obj;
            }
            let obj = getObj();

            let myDepartments = JSON.stringify(obj);
            console.log(myDepartments);

            let param = qs.stringify({
                drugId : that.drugId,
                drugName : that.drugName,
                drugDescription : that.drugDescription,
                drugNumber : that.drugNumber,
                departments : myDepartments
            })
             this.$axios.post("http://localhost:8080/admin/updateDrug", param)
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