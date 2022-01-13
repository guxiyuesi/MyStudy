<template>
    <div >
        <component
        @changeSonView="SonView"
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
        SonView(param) {
            this.sonView = param;
            alert(param);
        }
    }
}
</script>