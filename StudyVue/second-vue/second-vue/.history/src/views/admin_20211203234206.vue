<template>
    <div id="admin-div">
        <el-col :span="12" id="el-col">
            <el-menu default-active="2" class="el-menu-vertical-demo"
                @open="handleOpen" @close="handleClose"
                background-color="#545c64" text-color="#fff" 
                active-text-color="#ffd04b">
                <el-menu-item index="1"  @click="info(1)">
                    <i class="el-icon-s-custom"></i>
                    <span slot="title">个人信息</span>
                </el-menu-item>
                <el-menu-item index="2" @click="info(2)">
                    <i class="el-icon-user"></i>
                    <span slot="title">医生信息</span>
                </el-menu-item>
                <el-menu-item index="3" @click="info(3)">
                    <i class="el-icon-s-order"></i>
                    <span slot="title">病人信息</span>
                </el-menu-item>
                <el-menu-item index="4" @click="info(4)">
                    <i class="el-icon-first-aid-kit"></i>
                    <span slot="title">药品信息</span>
                </el-menu-item>
            </el-menu>
        </el-col>

        <div>
            <div v-if="flag==1"></div>
            <div v-else-if=""></div>
        </div>
    </div>
</template>

<script>
  export default {
    data: function(){
        return {
            flag:0
        }
    },
    methods: {
      handleOpen() {
      },
      handleClose() {
      }, 
      info(index) {
          this.flag = index;
      }
    }
  }
</script>

<style scoped>
    #el-col {
        height: calc(98vh);
        width: 230px;
        background-color: #545c64;
    }

    #admin-div {
        height: calc(98vh);

    }
</style>