<template>
    <div id="drugInfoDiv">
        <el-button id="add" type="primary" round @click="addDrug">新增</el-button>
        <el-table
        :data="tableData"
        border
        style="width: 70%"
        height="665"
        @change="thisChange"
        >
        <el-table-column
        fixed
        prop="drugId"
        label="id"
        width="150">
        </el-table-column>

        <el-table-column
        prop="drugName"
        label="name"
        width="120">
        </el-table-column>

        <el-table-column
        prop="drugDescription"
        label="description"
        width="600">
        </el-table-column>

        <el-table-column
        fixed="right"
        label="操作"
        width="100">
            <template slot-scope="scope">
                <el-button @click="handleClick(scope.row)" type="text" size="small">编辑</el-button>
            </template>
        </el-table-column>

        </el-table>
    </div>
</template>

<script>
  export default {
    props:["sonView", "rowValue"],
    mounted(){
        const that = this;
        this.$axios.post('http://localhost:8080/admin/drugs')
        .then(function(response){
            that.tableData = response.data;
        });
    },
    methods: {
      handleClick(row) {
        this.$emit('changeRowValue', row);
        this.$emit('changeSonView', 'modifyDrugInfo');
      },
      addDrug() {
        this.$emit('changeSonView', 'addDrug');
      },
      thisChange() {
        this.$forceUpdate
      }
    },

    data() {
      return {
        tableData: []
      }
    } 

  }
</script>

<style scoped>
#drugInfoDiv{
    margin-left: 10px;
}

#add {
    margin-top: 15px;
    margin-bottom: 15px;
}
</style>