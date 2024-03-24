<template>
  <main id="sample" class="px-2">
    <Editor api-key="fx6eje7n5iktth72nd9cinlo9fwm6v8umv88lvpm7l89jyv0" :init="{
      selector: 'textarea#file-picker',
      toolbar_mode: 'sliding',
        plugins: 'anchor code preview help autolink charmap codesample emoticons image link lists media searchreplace table visualblocks wordcount linkchecker save',
        toolbar: 'undo redo | preview save |blocks fontfamily fontsize | link image table | align lineheight | numlist bullist indent outdent | emoticons charmap ',
     
      image_title: true,
   
      automatic_uploads: true,
      /*
        URL of our upload handler (for more details check: https://www.tiny.cloud/docs/configure/file-image-upload/#images_upload_url)
        images_upload_url: 'postAcceptor.php',
        here we add custom filepicker only to Image dialog
      */
      file_picker_types: 'image',
      /* and here's our custom image picker*/
      file_picker_callback: filePickerCallback
    }" />
  </main>
</template>
<script setup>
import Editor from '@tinymce/tinymce-vue'
const filePickerCallback = function (cb, value, meta) {
  var input = document.createElement('input');
  input.setAttribute('type', 'file');
  input.setAttribute('accept', 'image/*');

  input.onchange = function () {
    var file = this.files[0];

    var reader = new FileReader();
    reader.onload = function () {
      var id = 'blobid' + (new Date()).getTime();
      var blobCache = tinymce.activeEditor.editorUpload.blobCache;
      var base64 = reader.result.split(',')[1];
      var blobInfo = blobCache.create(id, file, base64);
      blobCache.add(blobInfo);

      /* call the callback and populate the Title field with the file name */
      cb(blobInfo.blobUri(), { title: file.name });
    };
    reader.readAsDataURL(file);
  };

  input.click();
};
</script>
