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
import modifyDrugInfo from "../components/displayDrug/toModifyDrugInfo.vue"
import addDrug from "../components/displayDrug/insertDrug.vue"
export default {
    name:"displayDoctor",
    components:{drugInfo, modifyDrugInfo, addDoctor},
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