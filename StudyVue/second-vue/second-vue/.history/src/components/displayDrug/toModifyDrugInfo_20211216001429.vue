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
            <el-input v-model="drugDescription"></el-input>
        </div>

        

        <div class="item" id="button">
                <el-button type="danger" round @click="modify">修改</el-button>
                <el-button type="info" round @click="cancel">取消</el-button>
        </div>
    </div>
</template>



<style scoped>
#modifyInfoDiv{
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