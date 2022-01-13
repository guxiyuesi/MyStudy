<template>
    <div id="admin-div">
        <el-col :span="12" id="el-col">
            <el-menu default-active="2" class="el-menu-vertical-demo"
                @open="handleOpen" @close="handleClose"
                background-color="#545c64" text-color="#fff" 
                active-text-color="#ffd04b">
                <el-menu-item index="1"  @click="info('patient')">
                    <i class="el-icon-s-custom"></i>
                    <span slot="title">个人信息</span>
                </el-menu-item>
                <el-menu-item index="2" @click="info('doctor')">
                    <i class="el-icon-user"></i>
                    <span slot="title">医生信息</span>
                </el-menu-item>
                <el-menu-item index="3" @click="info('registration')">
                    <i class="el-icon-s-order"></i>
                    <span slot="title">挂号信息</span>
                </el-menu-item>
                <el-menu-item index="4" @click="info('record')">
                    <i class="el-icon-first-aid-kit"></i>
                    <span slot="title">病历记录</span>
                </el-menu-item>
            </el-menu>
        </el-col>

        <div>
            <component 
            :patientAccount='patientAccount'
            @changePatientAccount="thePatientAccount"
            :is='currentView'></component>
        </div>
    </div>
</template>

<script>
  import patient from "../components/patient/displayPatient.vue"
  import doctor from "../components/patient/displayDoctor.vue"
  import registration from "../components/patient/displayRegistration.vue"
  import record from "../components/patient/displayRecord.vue"

  export default {
  components: { patient, doctor, registration, record },
    data: function(){
        return {
            currentView:'',
            patientAccount:''
        }
    },
    created() {
        let that = this;
        const axios = require('axios');
        let patientAccount = that.$route.query.patientAccount;
        that.patientAccount = patientAccount;
    },
    methods: {
      handleOpen() {
      },
      handleClose() {
      }, 
      info(displayView) {
          this.currentView = displayView;
      },
      thePatientId(param) {
          this.patientAccount = param;
      }
    }
  }
</script>

<style scoped>
    #el-col {
        height: calc(98vh);
        width: 300px;
        background-color: #545c64;
        text-align: center;
    }

    #admin-div {
        height: calc(98vh);
    }
</style>