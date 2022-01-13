<template>
    <div >
        <component
        @changeSonView="theSonView"
        :sonView="sonView" 
        :adminId="adminId"
        :is="sonView"></component>
    </div>
</template>

<script>
import adminInfo from "./displayAdmin/adminInfo.vue"
import modifyAdminInfo from "./"
export default {
    name:"displayAdmin",
    components:{adminInfo, modifyAdminInfo},
    props:['adminId'],
    data: function() {
        return {
            sonView:'adminInfo'
        }
    },
    methods: {
        theSonView(param) {
            this.sonView = param;
        }
    }
}
</script>