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

        <el-checkbox-group v-model="checkList" id="checkbox">
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
        const
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