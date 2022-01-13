<template>
    <div >
        <component :is="currentView"></component>
    </div>
</template>

<script>
import adminInfo from "../"

export default {
    name:"displayAdmin",
    data: function() {
        return {
            
        }
    }
}
</script>