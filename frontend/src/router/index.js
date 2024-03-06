import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import HomeLayout from '../layout/HomeLayout.vue'
import LoginLayout from '../layout/LoginLayout.vue'
import SignUp from '../views/SignUp.vue'
import LoginVue from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import AdminLayout from '../layout/AdminLayout.vue'
import Dashboard from '../views/admin/Dashboard.vue'
import Search from '../views/Search.vue'
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      meta:{
        layout: HomeLayout
      },
      component: HomeView
    },
    {
      path: '/about/:id',
      name: 'about',
      meta:{
        layout: HomeLayout
      },
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    },
    {
      path:'/search',
      name: 'search',
      meta:{
        layout: HomeLayout
      },
      component: Search
    },
    {
      path: '/login',
      name: 'login',
      meta:{
        layout: LoginLayout
      },
      component: LoginVue

    },
    {
      path: "/logout", // Địa chỉ URL cho trang đăng xuất
      name: "Logout",
      meta:{
        layout: LoginLayout
      },
      component: Logout,
    },
    {
      path: '/signup',
      name: 'signup',
      meta:{
        layout: LoginLayout,
      },
      component: SignUp
    },
    {
      path: '/post',
      name : 'post',
      meta:{
        layout: HomeLayout
      },
      component: ()=> import('../views/PostView.vue')
    },
    {
      path: '/admin',
      name: 'dashboard',
      meta:{
        layout: AdminLayout
      },
      component: Dashboard
    }
  ]
})

export default router
