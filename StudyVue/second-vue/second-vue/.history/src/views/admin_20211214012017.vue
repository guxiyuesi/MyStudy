<template>
    <div id="admin-div">
        <el-col :span="12" id="el-col">
            <el-menu default-active="2" class="el-menu-vertical-demo"
                @open="handleOpen" @close="handleClose"
                background-color="#545c64" text-color="#fff" 
                active-text-color="#ffd04b">
                <el-menu-item index="1"  @click="info('displayAdmin')">
                    <i class="el-icon-s-custom"></i>
                    <span slot="title">个人信息</span>
                </el-menu-item>
                <el-menu-item index="2" @click="info('displayDoctor')">
                    <i class="el-icon-user"></i>
                    <span slot="title">医生信息</span>
                </el-menu-item>
                <el-menu-item index="3" @click="info('displayPatient')">
                    <i class="el-icon-s-order"></i>
                    <span slot="title">病人信息</span>
                </el-menu-item>
                <el-menu-item index="4" @click="info('displayDrug')">
                    <i class="el-icon-first-aid-kit"></i>
                    <span slot="title">药品信息</span>
                </el-menu-item>
            </el-menu>
        </el-col>

        <div>
            <component :is="currentView"></component>
        </div>
    </div>
</template>

<script>

  import displayAdmin from "../components/displayAdmin.vue"
  import displayDoctor from "../components/displayDoctor.vue"
  import displayPatient from "../components/dispalyPatient.vue"
  import displayDrug from "../components/displayDrug.vue"

  let id = this.$route.query.adminId;
  alert(id);
  export default {
  components: { displayAdmin, displayDoctor, displayPatient, displayDrug },
    data: function(){
        return {
            currentView:'',
            data:''
        }
    },
    created() {
    },
    methods: {
      handleOpen() {
      },
      handleClose() {
      }, 
      info(displayView) {
          this.currentView = displayView;
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