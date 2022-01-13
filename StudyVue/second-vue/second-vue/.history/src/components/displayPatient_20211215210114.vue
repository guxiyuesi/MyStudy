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
import patientInfo from "../components/displayPatient/patientInfo.vue"
import modifyPatientInfo from "../components/displayPatient/toModifyPatientInfo.vue"
import addPatient from "../components/displayPatient/addPatient.vue"
export default {
    name:"displayPatient",
    components:{patientInfo, modifyPatientInfo, addPatient},
    data: function() {
        return {
            sonView:'patientInfo',
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