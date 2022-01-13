<template>
    <div id="modifyAdminInfo">
        <el-form ref="form" :model="form" label-width="80px">
            <el-form-item label="活动名称">
            <el-input v-model="form.name"></el-input>
        </el-form-item>
    </div>
</template>

<script>
  export default {
    data() {
      return {
        form: {
          name: '',
          region: '',
          date1: '',
          date2: '',
          delivery: false,
          type: [],
          resource: '',
          desc: ''
        }
      }
    },
    methods: {
      onSubmit() {
        console.log('submit!');
      }
    }
  }
</script>


<style scoped>

</style>