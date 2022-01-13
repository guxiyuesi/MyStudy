<template>
    <div >
        <component
        @changeSonView="theSonView"
        :sonView="sonView"
        :rowValue="rowValue"
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
            rowValue:[]
        }
    },
    methods: {
        theSonView(param) {
            this.sonView = param;
        }, 
        theRowValue(param) {
            this.rowValue = param;
        }
    }
}
</script>