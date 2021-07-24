<template>

    <a-layout>
      <a-layout-sider width="200" style="background: #fff">
        <a-menu
          mode="inline"
          v-model:selectedKeys="selectedKeys2"
          v-model:openKeys="openKeys"
          :style="{ height: '100%', borderRight: 0 }"
        >
        <a-sub-menu key="sub3">
            <template #title>
              <span>
                <user-outlined />
                个人信息
              </span>
            </template>
            <a-menu-item key="9" @click="userinfo2">个人信息</a-menu-item>
          </a-sub-menu>
          
          <a-sub-menu key="sub1">
            <template #title>
              <span>
                <user-outlined />
                学生信息
              </span>
            </template>
            <a-menu-item key="1" @click="allinfo" >所有寝室得分</a-menu-item>
            
          </a-sub-menu>
         
          
        </a-menu>
      </a-layout-sider>
      <a-layout style="padding: 0 24px 24px">
        <a-breadcrumb style="margin: 16px 0">
          <a-breadcrumb-item>主页面</a-breadcrumb-item>
          <a-breadcrumb-item>教师页面</a-breadcrumb-item>
          
        </a-breadcrumb>
        <a-layout-content
          :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '600px' }"
        >
          
        </a-layout-content>
      </a-layout>
    </a-layout>

   

</template>

<script setup >


import {useRouter} from 'vue-router';
const router = useRouter();

const allinfo = ()=>{
    router.push({path:'/messageinfo/allinfo'});
}
const changePwd = ()=>{
    router.push({path:'/security/changePwd'});
}
const login = ()=>{
    router.push({path:'/security/login'});
}
const userinfo = ()=>{
    router.push({path:'/messageinfo/userinfo'});
}
const userinfo2 = ()=>{
    router.push({path:'/messageinfo/userinfo2'});
}


</script>

<style>
#components-layout-demo-top-side-2 .logo {
  float: left;
  width: 120px;
  height: 31px;
  margin: 16px 24px 16px 0;
  background: rgba(255, 255, 255, 0.3);
}

.ant-row-rtl #components-layout-demo-top-side-2 .logo {
  float: right;
  margin: 16px 0 16px 24px;
}

.site-layout-background {
  background: #fff;
}
</style>