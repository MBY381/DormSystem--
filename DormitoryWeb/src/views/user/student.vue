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
            <a-menu-item key="9" @click="userinfo">个人信息</a-menu-item>
          </a-sub-menu>

          <a-sub-menu key="sub1">
            <template #title>
              <span>
                <user-outlined />
                寝室信息
              </span>
            </template>
            <a-menu-item key="1" @click="studentinfo">寝室得分</a-menu-item>
            <a-menu-item key="2" @click="delieverrecord">送水记录</a-menu-item>
            <a-menu-item key="3" @click="repairrecord">维修记录</a-menu-item>
            <a-menu-item key="4" @click="tousurecord">投诉记录</a-menu-item>
            <a-menu-item key="10" @click="changerecord">换宿记录</a-menu-item>
          </a-sub-menu>
          <a-sub-menu key="sub2">
            <template #title>
              <span>
                <laptop-outlined />
                功能
              </span>
            </template>
            <a-menu-item key="5" @click="changedorm">申请换宿</a-menu-item>
            <a-menu-item key="6" @click="exeAdd">申请送水</a-menu-item>
            <a-menu-item key="7" @click="exa">申请维修</a-menu-item>
            <a-menu-item key="8" @click="openAdd">提交投诉</a-menu-item>
          </a-sub-menu>
          
        </a-menu>
      </a-layout-sider>
      <a-layout style="padding: 0 24px 24px">
        <a-breadcrumb style="margin: 16px 0">
          <a-breadcrumb-item>主页面</a-breadcrumb-item>
          <a-breadcrumb-item>学生页面</a-breadcrumb-item>
          
        </a-breadcrumb>
        <a-layout-content
          :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '600px' }"
        >
          <a-modal v-model:visible="visible" title="投诉" @ok="execAdd">
    <a-form
      :model="addObj"
      :label-col="{ span: 5 }"
      :wrapper-col="{ span: 14 }"
    >
      <a-form-item label="投诉内容">
        <a-input v-model:value="addObj.tousu" />
      </a-form-item>
    </a-form>
  </a-modal>
        </a-layout-content>
      </a-layout>
    </a-layout>
 
   

</template>

<script setup >
import { reactive, ref } from "vue";
import { get, post, put, del, tip } from "@/common";

import {useRouter} from 'vue-router';
const router = useRouter();
const addObj = reactive({
  tousu: "",
});
const visible = ref(false);
const openAdd = () => {
  //打开窗口
  visible.value = true;
};
const execAdd = () => {
  //执行tousu
  post('/tousu',addObj).then((res) => {
    visible.value = false;
    addObj.tousu="";
    tip.success("投诉成功！");
    getPage(page.value.last + 1);
  });
};
const studentinfo = ()=>{
    router.push({path:'/messageinfo/studentinfo'});
}


const delieverrecord = ()=>{
    router.push({path:'/messageinfo/delieverrecord'});
}


const repairrecord = ()=>{
    router.push({path:'/messageinfo/repairrecord'});
}

const tousurecord = ()=>{
    router.push({path:'/messageinfo/tousurecord'});
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
const changedorm = ()=>{
    router.push({path:'/security/changedorm'});
}
const changerecord = ()=>{
    router.push({path:'/messageinfo/changerecord'});
}
const exeAdd = () => {
  post("/deliever").then((res) => {
    tip.success("申请送水成功！送水员会在规定时间内送水！");
  });
};
const exa = () => {
  post("/repairer").then((res) => {
    tip.success("申请维修成功！维修工会在规定时间内维修！");
  });
};
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