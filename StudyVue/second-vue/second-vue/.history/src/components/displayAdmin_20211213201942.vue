<template>
    <div >
        <component :is="currentView"></component>
    </div>
</template>

<script>
import adminInfo from "../components/adminInfo.vue"
export default {
    name:"displayAdmin",
    components
    data: function() {
        return {
            
        }
    }
}
</script>