<template>
  <div class="container">
    <div :class="['side' , isCollapse ? 'collapse' : 'expand']">
      <div class="logo">
        <img src="https://shuyixiao.oss-cn-hangzhou.aliyuncs.com/%E4%B8%80%E7%AC%91%E5%8D%9A%E5%AE%A2logo/%E5%BE%AE%E7%AC%91.png"/>
        <span v-if="!isCollapse">manager</span>
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
      <tree-menu :userMenuList="userMenuList"></tree-menu>
      </el-menu>
    </div>
    <div :class="['content-right' , isCollapse ? 'collapse' : 'expand']">
      <div class="nav-top">
        <div class="menu">
          <el-icon @click="isCollapse = !isCollapse"><Fold /></el-icon>
          <span>
            <BreadCrumb ></BreadCrumb>
          </span>
        </div>
        <div class="userInformation">
          <el-badge :is-dot="notifyCount > 0" class="notice"><el-icon><Comment /></el-icon></el-badge>
          <el-dropdown @command="handleQuit">
          <span class="el-dropdown-link">
          {{ user.userName }}
          </span>
            <template #dropdown>
              <el-dropdown-menu>
                <el-dropdown-item command="email">邮箱：{{ user.userEmail }}</el-dropdown-item>
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
import {ref,computed,reactive} from "vue";
import {useRouter} from "vue-router"
import {useStore} from "vuex"
import {notify,menuList} from "../api"
import TreeMenu from "./TreeMenu.vue"
import BreadCrumb from "./BreadCrumb.vue"
const store = useStore();
const router = useRouter();
const notifyCount = ref(0);
const isCollapse = ref(false);
const userMenuList = reactive([]);
const user = computed(() => store.state.userInfo.data)

function handleQuit(command) {
  if (command === 'logout') {
    store.commit("saveUserInfo","")
    router.push('/login')
  }
}

async function getNotifyCount() {
 await notify().then(res => {
    notifyCount.value = res.data.count
  })
}
getNotifyCount()

async function getMenuList() {
  const res = await menuList();
  userMenuList.push(...res.data.menuList)
}
getMenuList()
</script>

<style scoped>

  .el-menu-vertical{
    height: calc(100vh - 98px);
    border-right: none;
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
    transition: width .5s;
  }

  .side.collapse{
    width: 70px;
  }

  .side.expand{
    width: 250px;
  }

  .content-right{
    margin-left: 250px;
  }

  .content-right.collapse{
    margin-left: 70px;
  }

  .content-right.expand{
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
    display: flex;
    margin-top: 10px;
    margin-left: 6px;
    padding-bottom: 28px;
  }

  .logo img{
    width: 60px;
    height: 60px;
  }

  .logo span{
    font-size: 20px;
    padding-left: 20px;
    line-height: 65px;
  }

</style>
