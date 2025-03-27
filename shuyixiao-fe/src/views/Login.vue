<template>
  <div class="login-wrapper">
    <div class="modal-content">
      <el-form
          ref="formRef"
          :model="ruleForm"
          :rules="rules"
      >
        <div class="title">舒一笑系统</div>
        <el-form-item prop="userName">
          <el-input type="text"
                    placeholder="用户名名称"
                    prefix-icon="User"
                    v-model="ruleForm.userName"
          ></el-input>
        </el-form-item>
        <el-form-item prop="passWord">
          <el-input type="password"
                    placeholder="用户密码"
                    prefix-icon="View"
                    v-model="ruleForm.passWord"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" class="login-btn" @click="submitForm(formRef)">登录</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script setup>
import {ref,reactive} from "vue";
import { login } from '../api'
import router from "../router/index.js";
const ruleForm = reactive({
  userName:"",
  passWord:""
})
// 获取原生表单句柄
const formRef = ref(null);
const rules = reactive({
  userName: [
    { required: true, message: '请输入用户名', trigger: 'blur' },
    { min: 3, max: 6, message: '长度在 3 到 6 个字符', trigger: 'blur' }
  ],
  passWord: [
    { required: true, message: '请输入密码', trigger: 'blur' },
    { min: 3, max: 12, message: '长度在 3 到 12 个字符', trigger: 'blur' }

  ]
})

// const login1 = (formRef) => {
//   if (!formRef) return;
//   formRef.validate((valid) => {
//     if (valid) {
//       console.log("11111111111111");
//     } else {
//       console.log("22222222222222");
//       return false;
//     }
//   });
// }
const submitForm = (formRef) => {
  console.log(formRef)
  formRef.validate((valid) => {
    console.log("444444");
    if (valid) {
      console.log("333333333");
      login(ruleForm).then(res => {
        router.push("/welcome")

      })
    } else {
      console.log("22222222222222");
      return false;
    }
  });
};
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