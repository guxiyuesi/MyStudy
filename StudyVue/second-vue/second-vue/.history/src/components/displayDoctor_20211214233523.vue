<template>
    <div >
        <component
        :is="sonView"></component>
    </div>
</template>

<script>
import doctorInfo from "../"
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