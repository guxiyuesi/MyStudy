<template>
    <div >
        <component
        :is="sonView"></component>
    </div>
</template>

<script>
import doctorInfo from "../components/displayDoctor/doctorInfo.vue"
import modifyDoctorInfo from "../components/display"
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