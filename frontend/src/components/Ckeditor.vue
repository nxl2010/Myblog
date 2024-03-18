<script setup>
import Editor from '@tinymce/tinymce-vue'
</script>

<template>
  <main id="sample">
    <img alt="Vue logo" class="logo" src="./assets/logo.svg" width="125" height="125" />
    <Editor
      api-key="fx6eje7n5iktth72nd9cinlo9fwm6v8umv88lvpm7l89jyv0"
      :init="{
        plugins: 'lists link image table code help wordcount'
      }"
    />
  </main>
</template>

<style scoped>
.logo {
  display: block;
  margin: 0 auto 2rem;
}

@media (min-width: 1024px) {
  #sample {
    display: flex;
    flex-direction: column;
    place-items: center;
    width: 1000px;
  }
}
</style>