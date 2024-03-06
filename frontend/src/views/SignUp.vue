<template>
    <div class="flex items-center justify-center min-h-screen bg-gray-100">
        <div class="bg-white p-8 rounded shadow-md w-full sm:w-1/2 md:w-1/3 lg:w-1/4">
            <h2 class="text-2xl font-semibold mb-6">Sign Up</h2>
            <form @submit.prevent="signup" class="space-y-4">
                <div>
                    <label for="fullname" class="block font-medium mb-1">Fullname</label>
                    <input v-model="fullname" type="text" id="fullname"
                        class="w-full rounded border-gray-300 focus:border-blue-500 focus:ring focus:ring-blue-200 transition duration-300">
                </div>
                <div>
                    <label for="username" class="block font-medium mb-1">Username</label>
                    <input v-model="username" type="text" id="username"
                        class="w-full rounded border-gray-300 focus:border-blue-500 focus:ring focus:ring-blue-200 transition duration-300">
                </div>
                <div>
                    <label for="password" class="block font-medium mb-1">Password</label>
                    <input v-model="password" type="password" id="password"
                        class="w-full rounded border-gray-300 focus:border-blue-500 focus:ring focus:ring-blue-200 transition duration-300">
                </div>
                <button type="submit"
                    class="w-full py-2 px-4 bg-blue-500 text-white rounded hover:bg-blue-600 transition duration-300">Sign
                    Up</button>
            </form>
        </div>
    </div>
</template>

<script setup>
import { ref } from 'vue';
import apiRequest from '../service/api';
import router from '../router/index';

const fullname = ref('');
const username = ref('');
const password = ref('');

const signup = async () => {
  try {
    const response = await apiRequest('POST', 'http://localhost:8080/api/v1/auth/register', {
      fullName: fullname.value,
      password: password.value,
	  userName: username.value
    });

    if (response.status === 200) {
      alert('Đăng ký thành công:', response.data);
	  router.push('/login');
      // Chuyển người dùng đến trang đăng nhập hoặc thực hiện hành động khác
    } else {
      console.error('Lỗi đăng ký:', response.data);
    }
  } catch (error) {
    console.error('Lỗi:', error);
  }
};
</script>