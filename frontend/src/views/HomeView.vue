<template>
    <div class="background-container">
        <div class="flex h-full items-center justify-center">
          
            <ul class="flex space-x-7 h-96 justify-center mx-2">
                <li v-for="category in  categorys " :key="category.id">
                    <router-link :to="`/about/${ category.entry }`" style="text-decoration: none;">
                        <div class="bg-white h-full w-72 flex flex-col items-center rounded-xl p-4">
                            <div class="mt-4 flex items-center justify-center mb-4">
                                <img class="h-28 w-28 rounded-full" :src=" category.image " alt="">
                            </div>
                            <div class="rounded-xl" :style="{ backgroundColor: category.color }">
                                <h3 class="mx-2 text-gray-200 font-medium">{{ category.entry }}</h3>
                            </div>
                            <h3 class="text-lg font-semibold">{{ category.name }}</h3>
                            <p class=" mt-2 text-gray-400 text-center">{{ category.decribe }}</p>
                        </div>
                    </router-link>
                </li>
            </ul>



        </div>
    </div>
    <div id="about" class="relative overflow-hidden mt-16">
        <div class="max-w-7xl mx-auto">
            <div class="relative z-10 pb-8 bg-white sm:pb-16 md:pb-20 lg:max-w-2xl lg:w-full lg:pb-28 xl:pb-32">
                <svg class="hidden lg:block absolute right-0 inset-y-0 h-full w-48 text-white transform translate-x-1/2"
                    fill="currentColor" viewBox="0 0 100 100" preserveAspectRatio="none" aria-hidden="true">
                    <polygon points="50,0 100,0 50,100 0,100"></polygon>
                </svg>

                <div class="pt-1"></div>

                <main class="mt-10 mx-auto max-w-xl px-4 sm:mt-12 sm:px-6 md:mt-16 lg:mt-20 lg:px-8 xl:mt-28">
                    <div class="sm:text-center lg:text-left">
                        <h2 class="my-6 text-2xl tracking-tight font-extrabold text-gray-900 sm:text-3xl md:text-4xl">
                            About me
                        </h2>

                        <p>
                            Xin chào! Tôi là một người đam mê công nghệ và đang sống cuộc đời của mình theo triết lý "Học suốt đời". Tôi luôn tò mò về cách mà công nghệ có thể tạo ra sự thay đổi tích cực trong cuộc sống của chúng ta. 
                            Từ khi bắt đầu học lập trình và thiết kế web cách đây nhiều năm, tôi đã tạo ra một loạt các dự án trực tuyến để chia sẻ kiến thức của mình và kết nối với cộng đồng trên khắp thế giới.
                        </p>
                    </div>
                </main>
            </div>
        </div>
        <div class="lg:absolute lg:inset-y-0 lg:right-0 lg:w-1/2">
            <img class="h-56 w-full object-cover object-top sm:h-72 md:h-96 lg:w-full lg:h-full"
                src="https://cdn.sforum.vn/sforum/wp-content/uploads/2022/03/jisoo-dien-vien-e1647139857345.jpg" alt="">
        </div>
        
    </div>
    <stories></stories>

</template>
<script setup>

import { ref, onMounted } from 'vue';
import stories from '../components/Stories.vue'

import axios from 'axios';
const categorys = ref([]);
// Function to fetch quotes from API
const fetchCategory = async () => {
    try {
        const response = await axios.get('http://localhost:8080/api/v3/category'); // Adjust the URL as needed
        categorys.value = response.data;
    } catch (error) {
        console.error('Error fetching quotes:', error);
    }
};

// Fetch quotes when the component is mounted
onMounted(() => {
    fetchCategory();
});
</script>
<style>
.background-container {
    z-index: 1;
    width: 100%;
    height: 100vh;
    background-image: url('https://antimatter.vn/wp-content/uploads/2022/05/background-dep-1.jpg');
    background-size: cover;
    background-position: center;
}

</style>
