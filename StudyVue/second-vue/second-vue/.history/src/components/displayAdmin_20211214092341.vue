<template>
    <div >
        <component
        @changeSonView="theSonView"
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
    props:['adminId'],
    data: function() {
        return {
            sonView:'adminInfo'
        }
    },
    mounted() {
        
    },
    methods: {
        theSonView(param) {
            this.sonView = param;
        }
    }
}
</script>