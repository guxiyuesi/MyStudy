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
import addDrug from "../components/displayDrug/addDrug"
export default {
    name:"displayDrug",
    components:{drugInfo, modifyDrugInfo, addDrug},
    data: function() {
        return {
            sonView:'drugInfo',
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