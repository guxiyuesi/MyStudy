<template>
    <div >
        <component
        :
        :data="sonView" 
        :is="sonView"></component>
    </div>
</template>

<script>
import adminInfo from "./displayAdmin/adminInfo.vue"
import modifyAdminInfo from "./displayAdmin/toModifyAdminInfo.vue"
export default {
    name:"displayAdmin",
    components:{adminInfo, modifyAdminInfo},
    data: function() {
        return {
            sonView:'adminInfo'
        }
    }
}
</script>