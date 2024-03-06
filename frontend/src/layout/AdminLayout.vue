<template>
    <header class=" sticky top-0 left-0 bg-white">
        <Header></Header>
        <NavLink></NavLink>

    </header>
    <SideBar></SideBar>
    <div class="ml-16">
        <slot></slot>
    </div>
    
</template>
<script setup>
import Header from '../components/admin/Header.vue';
import SideBar from '../components/admin/Sidebar.vue';
import NavLink from '../components/admin/NavLink.vue';
</script>