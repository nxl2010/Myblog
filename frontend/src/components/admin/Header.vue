<template>
        <div class=" flex flex-row justify-between items-center px-6">
            <!-- Ícono de Menú (cyan) -->
            <button id="menu-button" onclick="expandSidebar()">
                <i class="fas fa-bars text-cyan-500 text-lg"></i>
            </button>
            <!-- Logo (centrado) -->
            <div class="mx-auto">
                <p class="text-4xl font-semibold">NXLZero</p>
            </div>
            <!-- Ícono de Notificación y Perfil -->
            <div class="space-x-4">
                <button>
                    <i class="fas fa-bell text-cyan-500 text-lg"></i>
                </button>
                <!-- Botón de Perfil -->
                <button>
                    <i class="fas fa-user text-cyan-500 text-lg"></i>
                </button>
            </div>
        </div>
</template>