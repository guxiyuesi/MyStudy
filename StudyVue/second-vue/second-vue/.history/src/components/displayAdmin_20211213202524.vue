<template>
    <div >
        <component
        :data="sonView" 
        :is=""></component>
    </div>
</template>

<script>
import adminInfo from "../components/adminInfo.vue"
export default {
    name:"displayAdmin",
    components:{adminInfo},
    data: function() {
        return {
            sonView:'adminInfo',
            currentView: sonView
        }
    }
}
</script>