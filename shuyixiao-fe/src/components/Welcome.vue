<template>
  <div class="welcome">
    <div class="content">
      <div class="sub-title">欢迎体验</div>
      <div class="title">舒一笑不秃头出品必是精品~</div>
      <div class="describe">全栈练习项目</div>
    </div>
    <div class="picture">

    </div>
  </div>
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
  .welcome {
    display: flex;
    align-items: center;
    justify-content: center;
    height: 100%;
    background-color: #e9bebe
  }

  .welcome .sub-title {
    text-align: left;
    font-size: 35px;
    line-height: 45px;
    color: #1a1a1a;
  }

  .welcome .title {
    font-size: 40px;
    line-height: 65px;
    color: #333354;
  }

  .welcome .describe {
    font-size: 15px;
    color: #333222;
    text-align: right;
  }

  .welcome .picture {
    background-image: url("https://shuyixiao.oss-cn-hangzhou.aliyuncs.com/%E4%B8%80%E7%AC%91%E5%8D%9A%E5%AE%A2logo/%E9%A6%96%E9%A1%B5.jpeg");
    background-size: cover;
    width: 640px;
    height: 360px;

  }

</style>
