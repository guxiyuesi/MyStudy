<template>
    <div >
        <component
        @changeSonView="theSonView"
        :sonView="sonView"
        :is="sonView"></component>
    </div>
</template>

<script>
import doctorInfo from "../components/displayDoctor/doctorInfo.vue"
import modifyDoctorInfo from "../components/displayDoctor/toModyfyDoctorInfo.vue"
export default {
    name:"displayAdmin",
    components:{doctorInfo, modifyDoctorInfo},
    data: function() {
        return {
            sonView:'doctorInfo'
        }
    },
    methods: {
        theSonView(param) {
            this.sonView = param;
        }
    }
}
</script>