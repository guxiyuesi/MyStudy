<template>
    <div >
        <component
        @changeSonView="theSonView"
        :sonView="sonView"
        :is="sonView"></component>
    </div>
</template>