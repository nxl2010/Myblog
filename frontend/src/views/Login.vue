<template>
    <div class="flex items-center justify-center min-h-screen bg-gray-100">
      <div class="bg-white p-8 rounded shadow-md w-full sm:w-1/2 md:w-1/3 lg:w-1/4">
        <h2 class="text-2xl font-semibold mb-6">Sign In</h2>
        <form @submit.prevent="signIn" class="space-y-4">
          <div>
            <label for="email" class="block font-medium mb-1">Email</label>
            <input v-model="email" type="text" id="email" class="w-full rounded border-gray-300 focus:border-blue-500 focus:ring focus:ring-blue-200 transition duration-300">
          </div>
          <div>
            <label for="password" class="block font-medium mb-1">Password</label>
            <input v-model="password" type="password" id="password" class="w-full rounded border-gray-300 focus:border-blue-500 focus:ring focus:ring-blue-200 transition duration-300">
          </div>
          <button type="submit" class="w-full py-2 px-4 bg-blue-500 text-white rounded hover:bg-blue-600 transition duration-300">Sign In</button>
        </form>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref } from 'vue';
  import axios from 'axios';
  import router from '../router/index';
  
  const email = ref('');
  const password = ref('');
  
  const signIn = async () => {
    try {
      const response = await axios.post('http://localhost:8080/api/v1/auth/authenticate', {
        userName: email.value,
        password: password.value,
      });
  
      const jwt = response.data.token;
      const now = Date.now();
      const time = now + 1000 * 60 * 60 * 24;
      const token = {
        jwt: jwt,
        exp: time
      };
  
      localStorage.setItem('token', JSON.stringify(token));
      alert('Logged in successfully!');
      router.push('/');
    } catch (error) {
      alert('Invalid credentials. Please try again.');
      console.error(error);
    }
  };
  </script>
  
  <style>
  /* Add your custom styles here if needed */
  </style>
  