<template>
    <div >
        <component
        :data="sonView" 
        :is="currentView"></component>
    </div>
</template>

<script>
import adminInfo from "../components/adminInfo.vue"
export default {
    name:"displayAdmin",
    components:{adminInfo},
    data: function() {
        return {
            sonView
            currentView: "adminInfo"
        }
    }
}
</script>