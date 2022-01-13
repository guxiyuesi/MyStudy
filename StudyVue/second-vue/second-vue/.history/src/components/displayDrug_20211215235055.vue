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
import modifydrugInfo from "../components/d"
import adddrug from "../components/displaydrug/adddrug.vue"
export default {
    name:"displaydrug",
    components:{drugInfo, modifydrugInfo, adddrug},
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