<template>
  <div id="app">
    {{message}}
  </div>
</template>



<script>
export default {
  name: 'App'
};
new Vue({
  el: '#app',
  data : {
    message : 'hello'
  }
})
</script>

<style>

</style>
