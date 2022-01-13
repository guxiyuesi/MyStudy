<template>
    <div id="adminInfo">
        <div id="adminName" class="adminInfo">adminName</div>
        <el-divider id="divider"></el-divider>
        <div id="adminId" class="adminInfo">adminId</div>
        <div id="adminGender" class="adminInfo">女</div>
        <div id="adminPhoneNumber" class="adminInfo">15346875489</div>
        <div id="adminAccount" class="adminInfo">71457623548</div>
        <div id="adminPassword" class="adminInfo">339558yymy</div>
    </div>
</template>



<script>

</script>

<style scoped>
#adminInfo {
    height: calc(50vh);
    margin-left: 350px;
    margin-right: 100px;
    background-color: red;
    width: 800px;
    display: flex;
}

#divider {
    background-color: black;
    margin-top: 5px;
    width: 800px;
}

#adminName {
    font-size: 50px;
    margin-left: 20px;
    padding-top: 15px;
    width: 800;
}
</style>