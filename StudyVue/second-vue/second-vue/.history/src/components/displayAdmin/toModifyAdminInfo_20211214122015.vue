<template>
    <div >
        <form id="adminForm">
            <div class="adminInfo">
                adminId:
                <input type="text" name="adminId" id="adminId" disabled=false v-model="theId">
            </div>
            <div class="adminInfo">
                adminName:
                <input type="text" name="adminName" id="adminName" v-model="name">
            </div>
            <div class="adminInfo">
                adminGender:
                <input type="text" name="adminGender" id="adminGender" v-model="gender">
            </div>
            <div class="adminInfo">
                adminPhone:
                <input type="text" name="adminPhone" id="adminPhone" v-model="phone">
            </div>
            <div class="adminInfo">
                adminAccount:
                <input type="text" name="adminAccount" id="adminAccount" disabled=false v-model="account">
            </div>
            <div class="adminInfo">
                adminPassword:
                <input type="text" name="adminPassword" id="adminPassword" v-model="password">
            </div>
        </form>
          <el-button type="warning" round @click="modify">修改</el-button>
          <el-button type="info" round @click="cancel">取消</el-button>
    </div>
</template>

<script>

export default {
    data:function() {
        return {
            theId:'',
            name: '',
            gender: '',
            phone:'',
            account:'',
            password:''
        }
    }
    props:["sonView"],
    mounted() {

    },
    methods: {
        modify() {
            this.$emit('changeSonView', 'adminInfo');            
        },
        cancel() {
            this.$emit('changeSonView', 'adminInfo');
        }
    }
}
</script>

<style scoped>
.adminInfo {
    display: block;
}

#adminForm {
    font-size: 25px;
    margin: 10px 10px 5px 5px;
}
</style>
