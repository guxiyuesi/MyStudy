<template>
    <div>
        <div>
            adminId:
        </div>
        <el-input
  type="textarea"
  :rows="2"
  placeholder="请输入内容"
  v-model="textarea" />
    </div>
</template>

<script>
export default {
  data() {
    return {
      input: ''
    }
  }
}
</script>