<template>
  <div class="container">
    <div class="side"></div>
    <div class="content-right">
      <div class="nav-top">
        <div class="menu">舒一笑的菜单</div>
        <div class="userName">舒一笑的admin</div>
      </div>
      <div class="wrapper">
        <div class="main-page">
          <router-view></router-view>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang='ts' setup>

</script>

<style scoped>
  .container{
    position: relative;
  }

  .side{
    position: fixed;
    width: 250px;
    height: 100%;
    color: white;
    background-color: #8b7b7b;
  }

  .content-right{
    margin-left: 250px;
  }

  .nav-top{
    height: 66px;
    line-height: 66px;
    display: flex;
    justify-content: space-between; /* 两端对齐*/
    padding: 0 20px;
  }
  .menu{
    color: #f5f5f5;
  }

  .userName{
    color: #f5f5f5;
  }

  .wrapper{
    background-color: #eef0f3;
    height: calc(100vh - 66px);
    padding: 20px;
  }

  .main-page{
    background-color: white;
    height: 100%;
    padding: 20px;
  }

</style>
