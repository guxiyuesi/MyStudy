<template>
  <div id="app">
    {{message}}
  </div>
</template>



<script>
import Vue from 'vue';
export default {
  name: 'App'
};
new Vue({
  data:{
    el:'#app',
    message:''
  }
})
</script>

<style>

</style>
