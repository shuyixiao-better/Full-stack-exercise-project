<template>
  <div class="login-wrapper">
    <div class="modal-content">
      <el-form>
        <div class="title">一笑管理系统</div>
        <el-form-item>
          <el-input type="text" placeholder="用户名"/>
        </el-form-item>
        <el-form-item>
          <el-input type="password" placeholder="密码"/>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" class="login-btn">登录</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script setup>

</script>


<style scoped>

.login-wrapper{
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
  background-color: #888888;
}

</style>