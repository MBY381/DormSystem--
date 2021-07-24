<template>

<a-page-header
    style="border: 1px solid rgb(235, 237, 240)"
    title="修改密码"
    sub-title="输入不重复的密码以更改密码"
  />

  <a-form
      :model="changePwdObj"
      :label-col="{ span: 5 }"
      :wrapper-col="{ span: 14 }"
      style="position:relative;
      right:200px;
      top:10px;"
    >
    <a-form-item label="新密码">
        <a-input-password v-model:value="changePwdObj.u_pwd1" placeholder="新密码" 
        style="width: 300px;border-bottom: 1px solid rgb(240, 240, 240);margin-right: 200px;"/>
      </a-form-item>
      <a-form-item label="确认新密码">
        <a-input-password v-model:value="changePwdObj.u_pwd2" placeholder="请确保输入一致" 
        style="width: 300px;border-bottom: 1px solid rgb(240, 240, 240);margin-right: 200px;"/>
      </a-form-item>
    </a-form>
  <a-button @click="exChangePwd" type="primary" ghost 
  style="
  position:relative;
  left:290px;
  ">确认</a-button>
  <a-button @click="backHome" type="default"  
  style="
  position:relative;
  left:300px;
  
  ">取消</a-button>

</template>

<script setup >

import { get, del, post, getBlob, tip, removeLocalToken } from "@/common";
import {ref,reactive} from"vue";
import { useRoute, useRouter } from "vue-router";


const router = useRouter();

const currUser = ref({});
const getCurrUser = () => {
  get("/common/get_curr-user",{},{loading:false}).then((res) => {
    currUser.value = res.data;
  });
};

getCurrUser();

const changePwdObj = reactive({
  user_id : "",
  u_pwd1:"",
  u_pwd2:""
})

const exChangePwd = () =>{
  // changePwdObj.user_id=currUser.value.userId;
  if(changePwdObj.u_pwd1 != changePwdObj.u_pwd2){
    tip.error("两次输入密码不一致！");
    return;
  }
  post("/common/changePwd",changePwdObj).then((res)=>{
    tip.success("修改成功，请重新登录");
    removeLocalToken();
    router.push({ path: "/security/login"})
  })
}
const backHome = () =>{
  window.history.go(-1);
}
</script>

<style>

</style>