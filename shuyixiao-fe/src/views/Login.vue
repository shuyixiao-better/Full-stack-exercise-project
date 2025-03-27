<template>
  <div class="login-wrapper">
    <div class="modal-content">
      <el-form>
        <div class="title">舒一笑系统</div>
        <el-form-item>
          <el-input type="text" placeholder="用户名称" prefix-icon="User"></el-input>
        </el-form-item>
        <el-form-item>
          <el-input type="password" placeholder="用户密码" prefix-icon="View"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" class="login-btn">登录按钮</el-button>
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
  height: 100vh;
  background-color: #888888;
}
.modal-content{
  width: 500px;
  padding: 50px;
  background-color: #ffffff;
  border-radius: 8px;
  box-shadow: 0 0 10px 3px #999;
}
.title{
  font-size: 40px;
  line-height: 1.5;
  margin-bottom: 30px;
}
.login-btn{
  width: 100%;
  height: 40px;
}

</style>