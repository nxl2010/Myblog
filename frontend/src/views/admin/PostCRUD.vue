<template>
    <div class="min-h-screen flex items-center justify-center bg-gray-100">
        <div class="max-w-md w-full p-6 bg-white rounded shadow-lg">
            <h2 class="text-xl font-semibold mb-4">Tạo Bài Viết Mới</h2>
            <form @submit.prevent="submitPost">
                <div class="mb-4">
                    <label for="title" class="block text-gray-700">Tiêu đề:</label>
                    <input type="text" id="title" v-model="post.title" class="mt-1 p-2 w-full border rounded-md">
                </div>
                <div class="mb-4">
                    <label for="content" class="block text-gray-700">Nội dung:</label>
                    <textarea id="content" v-model="post.content" rows="6"
                        class="mt-1 p-2 w-full border rounded-md"></textarea>
                </div>
                <button type="submit" class="px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-600">Đăng
                    Bài</button>
            </form>
        </div>
    </div>
    <Ckeditor></Ckeditor>
</template>

<script setup>
import { ref } from 'vue';
import Ckeditor from '../../components/Ckeditor.vue';

const post = ref({
    title: '',
    content: ''
});

const submitPost = () => {
    // Xử lý logic khi submit bài viết
}
</script>
