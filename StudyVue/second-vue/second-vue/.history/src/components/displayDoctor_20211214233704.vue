<template>
    <div >
        <component
        :is="sonView"></component>
    </div>
</template>

<script>
import doctorInfo from "../components/displayDoctor/doctorInfo.vue"
import modifyDoctorInfo from "../components/displayDoctor/toModyfyDoctorInfo.vue"
export default {
    name:"displayAdmin",
    components:{doctorInfo, modifyAdminInfo},
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