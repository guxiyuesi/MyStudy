<template>
    <div id="adminInfo" @click="toModifyAdminInfo">
        <div id="adminNameAndGender">
            <div id="adminName" >Name</div>
            <div id="adminGender">
                <div v-if="gender == '男'">
                    <i class="el-icon-male"></i>
                </div>
                <div v-else>
                    <i class="el-icon-female"></i>
                </div>
            </div>
        </div>
        <el-divider id="divider"></el-divider>
        <div id="adminId" class="adminInfo">adminId</div>
        
        <div id="adminPhoneNumber" class="adminInfo">15346875489</div>
        <div id="adminAccount" class="adminInfo">71457623548</div>
        <div id="adminPassword" class="adminInfo">339558yymy</div>
    </div>
</template>



<script>

export default {
    data: function() {
        return {
            gender: ''
        }
    },
    methods: {
        toModify
    }
}
</script>

<style scoped>
#adminInfo {
    height: calc(45vh);
    margin-left: 350px;
    margin-right: 100px;
    width: 800px;
    border: solid 1px #909399;
}

#adminNameAndGender{
    display: flex;
    flex-wrap: wrap;
    align-content: flex-start;
}

#divider {
    background-color: black;
    width: 800px;

}

.adminInfo {
    margin-top: 10px;
    margin-bottom: 10px;
    margin-left: 10px;
    font-size: 30px;
    font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
}

#adminName {
    margin-top: 15px;
    margin-left: 10px;
    font-size: 50px;
}

#adminGender {
    font-size: 30px;
    margin-left: 10px;
    margin-top: 15px;
}

</style>







