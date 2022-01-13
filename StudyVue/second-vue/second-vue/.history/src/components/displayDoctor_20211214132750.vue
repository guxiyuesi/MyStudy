<template>
    <div >
        <component
        @changeSonView="theSonView"
        :sonView="sonView" 
        :adminId="adminId"
        :is="sonView"></component>
    </div>
</template>