<template>
  <div class="container">
    <div class="side">
      <div class="logo">
        <img src="https://shuyixiao.oss-cn-hangzhou.aliyuncs.com/%E4%B8%80%E7%AC%91%E5%8D%9A%E5%AE%A2logo/%E5%BE%AE%E7%AC%91.png"/>
        <span>manager</span>
      </div>
      <!--导航菜单-->
      <el-menu
          default-active="2"
          class="el-menu-vertical"
          :collapse="isCollapse"
          background-color="#8b7b7b"
          text-color="#fff"
          router
      >
        <el-sub-menu index="1">
          <template #title>
            <el-icon><el-icon><Tools /></el-icon></el-icon>
            <span>系统管理</span>
          </template>
          <el-menu-item-group>
            <el-menu-item index="1-1">用户管理</el-menu-item>
            <el-menu-item index="1-2">菜单管理</el-menu-item>
            <el-menu-item index="1-3">角色管理</el-menu-item>
            <el-menu-item index="1-4">部门管理</el-menu-item>
          </el-menu-item-group>
        </el-sub-menu>
        <el-sub-menu index="2">
          <template #title>
            <el-icon><el-icon><Promotion /></el-icon></el-icon>
            <span>审批管理</span>
          </template>
          <el-menu-item-group>
            <el-menu-item index="2-1">休假管理</el-menu-item>
            <el-menu-item index="2-2">待我审批</el-menu-item>
          </el-menu-item-group>
        </el-sub-menu>
      </el-menu>

    </div>
    <div class="content-right">
      <div class="nav-top">
        <div class="menu">
          <el-icon><Fold /></el-icon>
          <span>舒一笑的菜单</span>
        </div>
        <div class="userInformation">
          <el-badge is-dot class="notice"><el-icon><Comment /></el-icon></el-badge>
          <el-dropdown @command="handleQuit">
          <span class="el-dropdown-link">
          {{ user.name }}
          </span>
            <template #dropdown>
              <el-dropdown-menu>
                <el-dropdown-item command="email">邮箱：{{ user.email }}</el-dropdown-item>
                <el-dropdown-item command="logout">退出</el-dropdown-item>
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
import {useRouter} from "vue-router"
import {useStore} from "vuex"

const store = useStore();
const router = useRouter();
const user = ref({
  name: '舒一笑',
  email: 'yixiaoshu88@163.com'
})

function handleQuit(command) {
  if (command === 'logout') {
    store.commit("saveUserInfo","")
    router.push('/login')
  }
}
</script>

<style scoped>

  .el-menu{
    border-right: none;
  }
  .el-menu-vertical{
    height: calc(100vh - 98px);
  }
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

  .logo{
    margin-top: 10px;
    padding-bottom: 28px;
  }
  .logo img{
    width: 60px;
    height: 60px;
  }
  .logo span{
    font-size: 20px;
    padding-left: 20px;
  }

</style>
