<template>
<div class="loginhome">
  <div class="login">
  <div class="left">
    <img class="img" src="./image_sec/left.png"/>
    </div>
  <div class="right">
  <div class="loginhome-nav">
  <a-menu v-model:selectedKeys="current"  mode="horizontal" class="menu">
    <a-sub-menu>
      <template #icon>
        <setting-outlined />
      </template>
      <template #title>
        <div class="choice">选择登录选项</div>
      </template>
      <a-menu-item-group>
        <a-menu-item key="setting:1" @click="ID">切换至账号登录</a-menu-item>
        <a-menu-item key="setting:2" @click="NetID">切换至NetId登录</a-menu-item>
      </a-menu-item-group>
    </a-sub-menu>
  </a-menu>
  </div>

    <div class="loginmenu">
      <router-view></router-view>
    </div>
  </div>
  </div>
</div>
</template>

<script setup >
import { defineComponent, ref } from 'vue';
import { MailOutlined, AppstoreOutlined, SettingOutlined } from '@ant-design/icons-vue';

const current = ref(['mail']);

import {useRouter} from 'vue-router';

const router = useRouter();

const ID = ()=>{
    router.push({path:'/security/login'})
};

const NetID = ()=>{
    router.push({path:'/security/loginByNetid'})
}


</script>

<style>
.loginhome{
  width: 100%;
  height: 100%;
}
.login{
  width: 800px;
  height: 500px;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  margin-top: 120px; 
  margin-left: 350px;
  border-radius: 250px;
}
.left{
  width: 400px;
  height: 100%;
}
.img{
  height: 100%;
  width: 100%;
}
.right{
  width: 400px;
  height: 100%;
  background-image: url("./image_sec/right.jpg");
}
.loginhome-nav{
  height:48px;
  width: 100%;
  text-align: center;
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 5px;
}
.choice{
  font-size: 40px;
  font-family: 宋体;
  font-weight: bolder;
}
.loginmenu{
  padding-top: 90px;
}
</style>



