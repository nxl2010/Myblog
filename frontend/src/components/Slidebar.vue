<template>
    <div class="bg-gray-100 py-3 px-4 rounded-lg shadow-md">
        <h2 class="text-2xl font-semibold mb-2 border-b-2 pb-2">Liên hệ</h2>
        <div class="flex space-x-2 items-center">
            <i class="fab fa-facebook text-blue-600 text-2xl"></i>
            <a href="https://www.facebook.com/nxlzero" class="text-blue-600 hover:no-underline">Facebook</a>
        </div>
        <div class="flex space-x-2 items-center mt-2">
            <i class="fab fa-instagram text-pink-600 text-2xl"></i>
            <a href="https://www.instagram.com/nxlzero" class="text-pink-600 hover:no-underline">Instagram</a>
        </div>
        <div class="flex space-x-2 items-center mt-2">
            <i class="fab fa-github text-gray-800 text-2xl"></i>
            <a href="https://github.com/nxlzero" class="text-gray-800 hover:no-underline">GitHub</a>
        </div>
        <div class="flex space-x-2 items-center mt-2">
            <i class="far fa-envelope text-gray-600 text-2xl  "></i>
            <a href="mailto:xuanlamzero@example.com" class="text-gray-600 hover:no-underline">xuanlamzer@gmail.com</a>
        </div>
    </div>

    <div class="bg-gray-100 p-4 rounded-lg shadow-md mt-4">
        <h2 class="text-2xl font-semibold mb-2 border-b-2 pb-2">Câu nói hay</h2>
        <p class=" font-mono italic text-neutral-500">" {{ quotes.content }}"</p>
        <p class=" font-sans text-neutral-500 text-xs float-right">{{ quotes.author }}</p>
    </div>
    
    <div class="bg-gray-100 p-4 rounded-lg shadow-md mt-4">
        <h2 class="text-2xl font-semibold mb-2 border-b-2 pb-2">Bài viết gần đây</h2>
        <div v-for="(post, index) in recentPosts" :key="index" class="mb-4">
            <h3 class="text-lg font-medium">{{ post.title }}</h3>
            <p class="text-gray-600">{{ post.date }}</p>
        </div>
    </div>

    <div class="bg-gray-100 p-4 rounded-lg shadow-md mt-4">
        <h2 class="text-2xl font-semibold mb-2 border-b-2 pb-2">HashTag</h2>
        <div class="flex flex-wrap gap-2">
            <span v-for="(tagName,index) in tagNames" :key="index"
            class=" bg-gray-400 rounded-lg py-1 px-1 text-gray-100 font-medium">{{ tagName.name }}</span>
        </div>
    </div>
</template>
<script setup>
import { recentPosts, quotes, tagNames, initializeData } from '../service/sidebar';

// Gọi hàm initializeData để khởi động dữ liệu khi component được mounted
initializeData();
</script>
