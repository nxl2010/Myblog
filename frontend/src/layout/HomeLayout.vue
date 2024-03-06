<template>
   <header class=" sticky top-0 left-0 w-full bg-gray-50 text-black p-3 z-50">
     <Header></Header>
   </header>
   <main>
    <slot></slot>
   </main>
   <footer class="bg-white dark:bg-gray-900">
    <Footer></Footer>
   </footer>
</template>
<script setup>
    import Header from '../components/Header.vue';
    import Footer from '../components/Footer.vue';
</script>