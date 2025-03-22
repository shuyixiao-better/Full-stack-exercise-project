<template>
  <h1>欢迎来到vue3+vite 世界</h1>
  <el-button>
    <router-link to="detail">去详情页</router-link>
  </el-button>
  <el-button>
    <router-link to="welcome">去主页</router-link>
  </el-button>
  <router-view></router-view>
</template>

<script lang='ts' setup>

</script>

<style scoped>
</style>
