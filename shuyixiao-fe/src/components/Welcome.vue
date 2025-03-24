<template>
  <div>主页信息</div>
</template>

<script lang='ts' setup>
  import { onMounted } from "vue";
  import storage from "../utils/storage"

  onMounted(() => {
    storage.setItem("shuyixiao", {id : 1,desc: "shuyixiao"});
    console.log(storage.getItem("shuyixiao"))
  })
</script>

<style scoped>
</style>
