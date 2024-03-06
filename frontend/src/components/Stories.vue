<template>
    <div class="max-w-7xl mt-8 border-t-2 border-b-2 pb-8 pt-2">
        <div class="p-2 flex justify-between items-center ml-3">
            <div class="flex">
                <i class="fa-regular fa-images p-1 text-xl" style="color: #16e3e0;"></i>
            <h2 class="text-2xl font-normal ml-1">Stories</h2>
            </div>
            
            <div>
                <div class="flex">
                <!-- Previous Button -->
                <a href="#"
                    class="flex items-center justify-center px-3 h-8 mr-3 text-sm font-medium text-gray-500 bg-white border border-gray-300 rounded-lg hover:bg-gray-100 hover:text-gray-700 dark:bg-gray-800 dark:border-gray-700 dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white">
                    <svg class="w-3.5 h-3.5 mr-2" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none"
                        viewBox="0 0 14 10">
                        <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                            d="M13 5H1m0 0 4 4M1 5l4-4" />
                    </svg>
                    Previous
                </a>
                <a href="#"
                    class="flex items-center justify-center px-3 h-8 text-sm font-medium text-gray-500 bg-white border border-gray-300 rounded-lg hover:bg-gray-100 hover:text-gray-700 dark:bg-gray-800 dark:border-gray-700 dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white">
                    Next
                    <svg class="w-3.5 h-3.5 ml-2" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none"
                        viewBox="0 0 14 10">
                        <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                            d="M1 5h12m0 0L9 1m4 4L9 9" />
                    </svg>
                </a>
            </div>
            </div>
           
        </div>
        <div class="grid grid-cols-2 lg:grid-cols-5 gap-2 px-2">
            <div v-for="(item, index) in data" :key="index" class="col-span-1">
                <div class="bg-black h-96 rounded-xl">
                    <img class="h-96 rounded-xl" :src="item.image" alt="">
                </div>
                <p class="font-medium">{{ item.title }}</p>
                <p>20 lượt xem</p>
            </div>
        </div>
    </div>
</template>
  
<script setup>
import { ref } from 'vue';
const data = [
    {
        image: 'https://tieusu.com/wp-content/uploads/2023/06/tieu-su-Jisoo-BlackPink-7.jpg',
        title: 'Hello, my friend'
    },
    {
        image: 'https://ss-images.saostar.vn/pc/1603940981652/EZMxPj-UcAElur2.jpg',
        title: 'Hello, đây là video 2 của tôi test xuống dòng'
    },
    {
        image: 'https://pbs.twimg.com/media/DCwPJejV0AAysky.jpg',
        title: 'Hello, my friendsss'
    },
    {
        image: 'https://tieusu.com/wp-content/uploads/2023/06/tieu-su-Jisoo-BlackPink-7.jpg',
        title: 'Hello, my friend'
    },
    {
        image: 'https://upload.wikimedia.org/wikipedia/commons/thumb/2/27/20211127_Han_Hyo-joo_%ED%95%9C%ED%9A%A8%EC%A3%BC_BH_Entertainment_%285%29.jpg/800px-20211127_Han_Hyo-joo_%ED%95%9C%ED%9A%A8%EC%A3%BC_BH_Entertainment_%285%29.jpg',
        title: 'Hello, my friend'
    }
];
</script>
  