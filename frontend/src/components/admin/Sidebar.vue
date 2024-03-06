<template>
    <div id="sidebar" class=" w-16 bg-white h-screen fixed rounded-none border-none transition-all duration-200 ease-in-out overflow-hidden">
   
    <div class="p-2 space-y-4">
        <!-- Inicio -->
        <button class="relative px-3 py-3 flex items-center space-x-4 justify-start text-gray-500 rounded-lg group" onclick="highlightSidebarItem(this)">
            <i class="fas fa-home text-lg"></i>
        </button>

        <!-- Autorizaciones -->
        <button class="relative px-3 py-3 flex items-center space-x-4 justify-start text-gray-500 rounded-lg group" onclick="highlightSidebarItem(this)">
            <i class="fas fa-check-circle"></i>
          
        </button>

        <!-- Usuarios -->
        <button class="relative px-3 py-3 flex items-center space-x-4 justify-start text-gray-500 rounded-lg group" onclick="highlightSidebarItem(this)">
            <i class="fas fa-users"></i>
          
        </button>

        <!-- Comercios -->
        <button class="relative px-3 py-3 flex items-center space-x-4 justify-start text-gray-500 rounded-lg group" onclick="highlightSidebarItem(this)">
            <i class="fas fa-store"></i>
          
        </button>

        <!-- Transacciones -->
        <button class="relative px-3 py-3 flex items-center space-x-4 justify-start text-gray-500 rounded-lg group" onclick="highlightSidebarItem(this)">
            <i class="fas fa-exchange-alt"></i>
          
        </button>

        <!-- Cerrar sesión -->
        <button class="relative px-3 py-3 flex items-center space-x-4 justify-start text-gray-500 rounded-lg group" onclick="highlightSidebarItem(this)">
            <i class="fas fa-sign-out-alt"></i>
        
        </button>
    </div>
</div>
</template>