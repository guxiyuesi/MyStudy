<template>
    <div >
        <component :is="currentView"></component>
    </div>
</template>

<script>
import adminInfo

export default {
    name:"displayAdmin",
    data: function() {
        return {
            
        }
    }
}
</script>