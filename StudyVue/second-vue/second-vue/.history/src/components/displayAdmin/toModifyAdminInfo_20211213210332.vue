<template>
    <div>
        <div>
            adminId:
            <el-input
                placeholder="请输入内容"
                v-model="input"
  :disabled="true">
</el-input>
        </div>
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