<template>
    <div id="admin-div">
        <el-col :span="12" id="el-col">
            <el-menu default-active="2" class="el-menu-vertical-demo"
                @open="handleOpen" @close="handleClose"
                background-color="#545c64" text-color="#fff" 
                active-text-color="#ffd04b">
                <el-menu-item index="1"  @click="info('displayDoctor')">
                    <i class="el-icon-s-custom"></i>
                    <span slot="title">个人信息</span>
                </el-menu-item>
                <el-menu-item index="2" @click="info('displayPatient')">
                    <i class="el-icon-user"></i>
                    <span slot="title">当前病人</span>
                </el-menu-item>
                <el-menu-item index="3" @click="info('writeRecord')">
                    <i class="el-icon-s-order"></i>
                    <span slot="title">门诊病历</span>
                </el-menu-item>
                <el-menu-item index="4" @click="info('callNumber')">
                    <i class="el-icon-first-aid-kit"></i>
                    <span slot="title">叫号</span>
                </el-menu-item>
            </el-menu>
        </el-col>

        <div>
            <component 
            :doctorId='doctorId'
            :patientId='patientId'
            @changePatientId="thePatientId"
            :is='currentView'></component>
        </div>
    </div>
</template>

<script>

  import displayDoctor from '../components/doctor/displayDoctor.vue'
  import displayPatient from '../components/doctor/dispalyPatient.vue'
  import numberumber from '../components/doctor/number.vue'
  import writeRecord from '../components/doctor/writeRecord.vue'

  export default {
  components: { number, displayDoctor, displayPatient, writeRecord },
    data: function(){
        return {
            currentView:'callNumber',
            doctorId:'',
            patientId:''
        }
    },
    created() {
        let that = this;
        const axios = require('axios');
        let doctorId = that.$route.query.doctorId;
        that.doctorId = doctorId;
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
          this.patientId = param;
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