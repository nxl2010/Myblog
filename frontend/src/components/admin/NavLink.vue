<template>
    <nav class="dark:bg-gray-700 border-gray-500 border-b">
        <div class="max-w-screen-xl px-4 py-2 mx-auto">
            <div class="flex ml-12 items-center">
                <ul class="flex flex-row font-medium mt-0 mr-6 space-x-3 text-sm">
                    <li v-for="(link, index) in navigationLinks" :key="index" :class="{ 'rounded-md': true, 'px-2 py-1 bg-gray-200': activeLinkIndex !== index, 'px-2 py-1 bg-blue-500': activeLinkIndex === index }">
                        <a
                            href="#"
                            class="text-gray-900 dark:text-white hover:underline"
                            aria-current="page"
                            @click="setActiveLink(index)"
                        >
                            {{ link.name }}
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</template>
<script setup>
const navigationLinks = [
    { name: 'Home' },
    { name: 'User' },
    { name: 'Category' },
    { name: 'Post' },
    { name: 'TagName' },
    { name: 'Blank' },
];
let activeLinkIndex = null;

const setActiveLink = (index) => {
    if (activeLinkIndex === index) {
        activeLinkIndex = null;
    } else {
        activeLinkIndex = index;
    }
};
</script>