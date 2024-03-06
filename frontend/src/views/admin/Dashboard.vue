<template>
  <Ckeditor></Ckeditor>
  <div class="container mx-auto p-4">
    <h1 class="text-2xl font-bold mb-4">CRUD Example</h1>
    <button @click="toggleCreateForm" class="mb-2 bg-blue-500 hover:bg-blue-600 text-white px-3 py-2 rounded-lg">
      {{ showCreateForm ? 'Hide Form' : 'Add New Item' }}
    </button>
    <!-- Create Form -->
    <div v-if="showCreateForm"
      class="fixed top-0 left-0 w-full h-full flex items-center justify-center bg-opacity-50 bg-gray-800">
      <div class="bg-white w-3/4 max-w-md p-4 rounded-lg shadow-lg">
        <div class="flex justify-end">
          <button @click="toggleCreateForm"
            class="text-gray-600 hover:text-gray-800 text-xl leading-none">&times;</button>
        </div>
        <h2 class="text-xl font-semibold mb-2">Create Item</h2>

        <form @submit.prevent="addCategory" class="mb-4">
          <div class="flex space-x-2">
            <input v-model="newCategory.name" type="text" class="w-1/3 px-2 py-1 border rounded-lg" placeholder="Name"
              required>
            <input v-model="newCategory.entry" type="text" class="w-1/3 px-2 py-1 border rounded-lg" placeholder="Entry"
              required>
            <input v-model="newCategory.decribe" type="text" class="w-1/3 px-2 py-1 border rounded-lg"
              placeholder="Description" required>
          </div>
          <div class="flex space-x-2 mt-2">
            <input v-model="newCategory.image" type="text" class="w-2/3 px-2 py-1 border rounded-lg"
              placeholder="Image URL" required>
            <button type="submit" class="bg-blue-500 hover:bg-blue-600 text-white px-3 py-2 rounded-lg">Add</button>
          </div>
        </form>

      </div>
    </div>
    <div class="overflow-x-auto">
      <table class="min-w-full">
        <thead>
          <tr>
            <th class="px-2 py-3 bg-gray-100 text-left">ID</th>
            <th class="px-2 py-3 bg-gray-100 text-left">Name</th>
            <th class="px-2 py-3 bg-gray-100 text-left">Entry</th>
            <th class="px-2 py-3 bg-gray-100 text-left">Description</th>
            <th class="px-2 py-3 bg-gray-100 text-left">Image</th>
            <th class="px-2 py-3 bg-gray-100 text-left">Action</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="category in categories" :key="category.id" class="border-b hover:bg-gray-100">
            <td class="px-2 py-4">{{ category.id }}</td>
            <td class="px-2 py-4">{{ category.name }}</td>
            <td class="px-2 py-4">{{ category.entry }}</td>
            <td class="px-2 py-4 max-w-lg">{{ category.decribe }}</td>
            <td class="px-2 py-4">
              <img :src="category.image" alt="Category Image" class="w-20 h-auto">
            </td>
            <td class="px-1 py-4 space-x-2">
              <button class="bg-green-500 hover:bg-green-600 text-white px-3 py-2 rounded-lg">Edit</button>
              <button class="bg-red-500 hover:bg-red-600 text-white px-3 py-2 rounded-lg">Delete</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>  
</template>
<script setup>
import Ckeditor from '../../components/Ckeditor.vue';
import { ref, onMounted } from 'vue';
import apiRequest from '../../service/api.js';
const showCreateForm = ref(false);
const categories = ref([]);
function toggleCreateForm() {
  showCreateForm.value = !showCreateForm.value;
}

const fetchCategories = async () => {
  try {
    const response = await apiRequest('GET', 'http://localhost:8080/api/v3/category');
    categories.value = response.data;
  } catch (error) {
    console.error('Error fetching categories:', error);
  }
};
const newCategory = ref({
  name: '',
  entry: '',
  decribe: '',
  image: '',
});

const addCategory = async () => {
  // Kiểm tra xem tên và hình ảnh có được cung cấp không
  if (!newCategory.value.name || !newCategory.value.image) {
    console.error('Name and Image are required fields.');
    return;
  }

  try {
    const response = await apiRequest('POST', 'http://localhost:8080/api/v3/category', newCategory.value);
    // Kiểm tra mã trạng thái HTTP để xác định xem yêu cầu đã thành công hay không
    if (response.status === 201) {
      console.log('Category added:', response.data);

      // Đặt lại giá trị của newCategory về trạng thái mặc định sau khi thêm
      newCategory.value = {
        name: '',
        entry: '',
        decribe: '',
        image: '',
      };

    } else {
      console.error('Failed to add category. Status:', response.status);
    }
    fetchCategories();
  } catch (error) {
    console.error('Error adding category:', error);
  }
};

onMounted(() => {
  fetchCategories();
});
</script>