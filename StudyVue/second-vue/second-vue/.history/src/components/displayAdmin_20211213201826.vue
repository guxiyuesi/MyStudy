<template>
    <div >
        <component :is="currentView"></component>
    </div>
</template>

<script>
export default {
    name:"displayAd"
}
</script>