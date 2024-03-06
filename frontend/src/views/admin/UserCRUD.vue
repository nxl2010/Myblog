<template>
     <div class="container mx-auto p-4">
    <h1 class="text-2xl font-bold mb-4">User CRUD</h1>

    <!-- Create Form -->
    <div class="mb-4">
      <h2 class="text-xl font-semibold mb-2">Create User</h2>
      <form class="space-y-2">
        <input type="text" class="px-3 py-2 border rounded-lg w-full" placeholder="Full Name" required>
        <input type="email" class="px-3 py-2 border rounded-lg w-full" placeholder="Email" required>
        <input type="text" class="px-3 py-2 border rounded-lg w-full" placeholder="Status" required>
        <input type="password" class="px-3 py-2 border rounded-lg w-full" placeholder="Password" required>
        <button type="button" class="bg-blue-500 hover:bg-blue-600 text-white px-4 py-2 rounded-lg w-full">Create</button>
      </form>
    </div>

    <!-- User List Table -->
    <table class="w-full border">
      <thead>
        <tr class="bg-gray-200">
          <th class="border p-2">Full Name</th>
          <th class="border p-2">Email</th>
          <th class="border p-2">Status</th>
          <th class="border p-2">Password</th>
          <th class="border p-2">Actions</th>
        </tr>
      </thead>
      <tbody>
        <tr class="bg-white">
          <td class="border p-2">John Doe</td>
          <td class="border p-2">johndoe@example.com</td>
          <td class="border p-2">Active</td>
          <td class="border p-2">********</td>
          <td class="border p-2">
            <button class="bg-red-500 hover:bg-red-600 text-white px-3 py-1 rounded-lg">Delete</button>
          </td>
        </tr>
        <!-- More users can be added here -->
      </tbody>
    </table>
  </div>
</template>
<script setup>

</script>