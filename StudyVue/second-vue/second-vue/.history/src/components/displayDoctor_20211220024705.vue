<template>
    <div >
        <component
        @changeRowValue="theRowValue"
        @changeSonView="theSonView"
        :sonView="sonView"
        :rowValue="rowValue"
        :is="sonView"></component>
    </div>
</template>

<script>
import doctorInfo from "../components/displayDoctor/doctorInfo.vue"
import modifyDoctorInfo from "../components/displayDoctor/toModyfyDoctorInfo.vue"
import addDoctor from "../components/displayDoctor/addDoctor.vue"
import number from "../components"
export default {
    name:"displayDoctor",
    components:{doctorInfo, modifyDoctorInfo, addDoctor},
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
            console.log(this.rowValue);
        }
    }
}
</script>