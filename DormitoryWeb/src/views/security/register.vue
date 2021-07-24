<template>
  <a-page-header
    style="border: 1px solid rgb(235, 237, 240)"
    title="职工注册"
  />
  <div>
    <a-form :model="user" :label-col="labelCol" :wrapper-col="wrapperCol">
      <a-form-item
        label="职工号"
        has-feedback
        :validateStatus="type1"
        :help="message1"
        style="font-weight: bold;"
      >
        <a-input
          v-model:value="user.u_id"
          placeholder="请输入职工号"
          @change="checkId"
        />
      </a-form-item>

      <a-form-item
        label="密码"
        has-feedback
        :validate-status="type"
        :help="message3"
        style="font-weight: bold;"
      >
        <a-input-password
          v-model:value="user.u_pwd"
          @change="checkPwd"
          placeholder="请输入密码"
        />
      </a-form-item>

      <a-form-item
        label="确认密码密码"
        has-feedback
        :validate-status="type2"
        :help="message2"
        style="font-weight: bold;"
      >
        <a-input-password
          v-model:value="user.u_pwd2"
          @change="checkPwd2"
          placeholder="请重复密码"
        />
      </a-form-item>
    </a-form>
  </div>
  <div>
    <a-radio-group
    v-model:value="user.temp"
    @change="changeTheButton"
    style="margin-left: 300px;"
  >
    <a-radio :value="3" style="font-weight: bold;"> 送水工</a-radio>
    <a-radio :value="2" style="font-weight: bold;"> 维修员 </a-radio>
    <a-radio :value="1" style="font-weight: bold;"> 检察员 </a-radio>
    <a-radio :value="0" style="font-weight: bold;"> 辅导员 </a-radio>
  </a-radio-group>
  </div>


  <a-button
    :disabled="buttonStatus"
    style="margin-left: 400px;margin-top: 20px;font-weight: bold;color:black"
    @click="register"
    >完成注册</a-button
  >
</template>

<script setup >
///////////////////////////////////////////////////////////引入
import { reactive, ref } from "vue";
import { post, setLocalToken } from "@/common";
import { useRouter } from "vue-router";
import { get } from "@/common";
import { message } from "ant-design-vue";
////////////////////////////////////////////////////////////变量
const user = reactive({
  u_id: "",
  u_pwd: "",
  u_pwd2: "",
  role_id: "",
  temp:""
});

const labelCol = {
  span: 4,
};
const wrapperCol = {
  span: 14,
};

const type1 = ref("");
const message1 = ref("");

const type = ref("");
const message3 = ref("");

const type2 = ref("");
const message2 = ref("");

const buttonStatus = ref(true);

const router = useRouter();

////////////////////////////////////////////////////////////
const checkId = () => {
  if (user.u_id.length > 0) {
    type1.value = "success";
    message1.value = "";
  } else {
    type1.value = "error";
    message1.value = "账户不为空！";
  }
};

const checkPwd = () => {
  if (user.u_pwd.length >= 6) {
    type.value = "success";
    message3.value = "";
  } else {
    type.value = "error";
    message3.value = "密码不少于6位!";
  }
};

const checkPwd2 = () => {
  if (user.u_pwd == user.u_pwd2) {
    type2.value = "success";
    message2.value = "";
  } else {
    type2.value = "error";
    message2.value = "密码输入不相同！";
  }
};

const changeTheButton = () => {
  buttonStatus.value = false;
  if(user.temp == "0"){
    user.role_id = "teacher";
  }
  if(user.temp == "1"){
    user.role_id = "scorer";
  }
  if(user.temp == "2"){
    user.role_id = "repairer";
  }
  if(user.temp == "3"){
    user.role_id = "deliever";
  }
};

const register = () => {
  post("/security/register",user).then((res)=>{
    if(res.success){
      message.success(res.message);
      router.push({path:'/'})
    }else{
      message.error(res.message);
    }
  });
};

///////////////////////////////////////////////////////////
</script>

<style>
</style>