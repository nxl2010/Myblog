<template>
    <div>
      {{ message }}
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        message: "Logging out...",
      };
    },
    async mounted() {
      // Xóa token khỏi localStorage hoặc thực hiện xử lý đăng xuất khác
      localStorage.removeItem("token");
  
      // Đợi 30 giây trước khi chuyển hướng đến trang đăng nhập
      await this.delay(1000); // 30000 milliseconds = 30 seconds
  
      // Chuyển hướng đến trang đăng nhập sau khi đợi 30 giây
      this.$router.push("/login");
    },
    methods: {
      delay(ms) {
        return new Promise(resolve => setTimeout(resolve, ms));
      },
    },
  };
  </script>
  