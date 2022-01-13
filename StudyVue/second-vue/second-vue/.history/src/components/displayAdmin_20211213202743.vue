<template>
    <div >
        <component
        :data="sonView" 
        :is="sonView"></component>
    </div>
</template>

<script>
import adminInfo from "../components/adminInfo.vue"
import modifyAdminInfo from "../components/ad"
export default {
    name:"displayAdmin",
    components:{adminInfo},
    data: function() {
        return {
            sonView:'adminInfo'
        }
    }
}
</script>