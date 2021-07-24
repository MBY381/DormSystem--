<template>
  <div>
    <a-form :model="user" :label-col="labelCol" :wrapper-col="wrapperCol">
    <template #title>prompt text</template>
    <a-form-item
      label="账号"
      has-feedback
      :validateStatus="type1"
      :help="message1"
      class="zhanghao"
    >
      <a-input
        v-model:value="user.u_id"
        placeholder="请输入学号或职工账号"
        @change="checkId"
      />
    </a-form-item>
    
    <a-form-item
      label="密码"
      has-feedback
      :validate-status="type"
      :help="message"
      class="mima"
    >
      <a-input-password
        v-model:value="user.u_pwd"
        @change="check"
        placeholder="请输入密码"
      />
    </a-form-item>

    <a href="http://localhost/security/register" style="margin-left: 240px;">
      注册职工
    </a>
    <!-- <a href="http://localhost/security/changePwd" style="margin-left: 113px">
      忘记密码
    </a> -->

    <a-form-item :wrapper-col="{ span: 14, offset: 4 }">
      <a-button
        type="default"
        @click="login"
        id="button"
        style="margin-left: 85px"
        >登录</a-button
      >
    </a-form-item>
  </a-form>
  </div>
</template>

<script setup>
import { reactive, ref } from "vue";
import { post, setLocalToken } from "@/common";
import { useRouter } from "vue-router";

const type1 = ref("");

const message1 = ref("");

const type = ref("");

const message = ref("密码不得少于6位");

const router = useRouter();

const checkId = () => {
  if (user.u_id.length > 0) {
    type1.value = "success";
    message1.value = "";
  } else {
    type1.value = "error";
    message1.value = "请输入账号";
  }
};

const check = () => {
  if (user.u_pwd.length >= 6) {
    type.value = "success";
    message.value = "";
  } else {
    type.value = "error";
    message.value = "密码不得少于6位！";
  }
};

const login = () => {
  post("/security/login", user).then((res) => {
    const token = res.data;

    setLocalToken(token);

    const web = res.message;

    if (web == "/user/student" && user.u_pwd == "111111") {
      router.push({ path: "/security/complete" });
    } else {
      router.push({ path: web });
    }
  });
};

const user = reactive({
  u_id: "",
  u_pwd: "",
});

//一行24列
const labelCol = {
  span: 4,
};
const wrapperCol = {
  span: 14,
};
</script>

<style>
.zhanghao{
  font-size: 20px;
  font-weight: bold;
}
.mima{
  font-size: 20px;
  font-weight: bold;
}

</style>

