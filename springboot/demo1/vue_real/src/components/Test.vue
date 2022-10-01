<script setup>

const text = 'a'

</script>

<template>
    <input :value="text" @input="onInput" placeholder="Type here">
    <p>{{ text }}</p>
</template>