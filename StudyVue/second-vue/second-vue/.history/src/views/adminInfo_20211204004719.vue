<template>
    <div id="adminInfo">
        <div id="adminName" class="adminInfo">adminName</div>
        <div id="adminGender">
            <div v-if="gender == '男'">
                <i class="el-icon-male"></i>
            </div>
            <div v-else>
                <i class="el-icon-female"></i>
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
new Vue({})
</script>

<style scoped>
#adminInfo {
    height: calc(50vh);
    margin-left: 350px;
    margin-right: 100px;
    background-color: red;
    width: 800px;
    display: flex;
    flex-wrap: wrap;
    align-content: flex-start
}

#divider {
    background-color: black;
    width: 800px;

}

.adminInfo {
    margin-left: 10px;
    font-size: 20px;
    font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
}

#adminName {
    margin-top: 15px;
    font-size: 50px;
}

#adminGender {
    font-size: 30px;
}

</style>