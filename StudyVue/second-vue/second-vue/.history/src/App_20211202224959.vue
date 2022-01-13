<template>
  <div id="test">
    {{message}}
  </div>
</template>



<script>
export default {
  name: 'App'
};
new Vue({
  el: '#test',
  data : {
    message : 'hello'
  }
})
</script>

<style>

</style>
