<template>
    <div >
        <component
        v-on:changeSonView="theSonView"
        :sonView="sonView" 
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
        theSonView(param) {
            alert(param);
            this.sonView = param;
        }
    }
}
</script>