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
import drugInfo from "../components/displayDrug/drugInfo.vue"
import modifyDoctorInfo from "../components/displayDrug/toModifyDrugInfo.vue"
import addDoctor from "../components/displayDrug/insertDrug.vue"
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