<template>
    <div >
        <component
        @changeSonView="changeSonView"
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
    },
    methods: {
        changeSonView(param) {
            this.sonView = param;
        }
    }
}
</script>