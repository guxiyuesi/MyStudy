<template>
    <div >
        <component
        @changeSonView="theSonView"
        :sonView="sonView"
        :row="row"
        :is="sonView"></component>
    </div>
</template>

<script>
import doctorInfo from "../components/displayDoctor/doctorInfo.vue"
import modifyDoctorInfo from "../components/displayDoctor/toModyfyDoctorInfo.vue"
export default {
    name:"displayDoctor",
    components:{doctorInfo, modifyDoctorInfo},
    data: function() {
        return {
            sonView:'doctorInfo',
            row
        }
    },
    methods: {
        theSonView(param) {
            this.sonView = param;
        }
    }
}
</script>