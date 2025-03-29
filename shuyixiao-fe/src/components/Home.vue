<template>
  <div class="container">
    <div class="side"></div>
    <div class="content-right">
      <div class="nav-top">
        <div class="menu">
          <el-icon><Fold /></el-icon>
          <span>舒一笑的菜单</span>
        </div>
        <div class="userInformation">
          <el-badge is-dot class="notice"><el-icon><Comment /></el-icon></el-badge>
          <el-dropdown>
          <span class="el-dropdown-link">
          {{ user.name }}
          </span>
            <template #dropdown>
              <el-dropdown-menu>
                <el-dropdown-item>邮箱：{{ user.email }}</el-dropdown-item>
                <el-dropdown-item>退出</el-dropdown-item>
              </el-dropdown-menu>
            </template>
          </el-dropdown>
        </div>
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
import {ref} from "vue";
const user = ref({
  name: '舒一笑',
  email: 'yixiaoshu88@163.com'
})
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
    display: flex;
    align-items: center;
    color: #f5f5f5;
  }
  .userInformation{
    display: flex;
    align-items: center;
    color: #f5f5f5;
  }

  .menu span{
    margin-left: 10px;
    font-size: 18px;
  }
  .el-dropdown-link{
    font-size: 18px;
    color: #f5f5f5;
  }

  .userInformation{
    color: #f5f5f5;
    font-size: 18px;
  }
  .userInformation .notice{
    margin-right: 13px;
    align-items: center;
  }

  .userInformation .notice{
    line-height: 18px;
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
