<template>
    <div >
        <component
        :data="c" 
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
            currentView: "adminInfo"
        }
    }
}
</script>