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
                寝室信息
              </span>
            </template>
            <a-menu-item key="1" @click="allinfo" >所有寝室得分</a-menu-item>
            
          </a-sub-menu>
         
          
        </a-menu>
      </a-layout-sider>
      <a-layout style="padding: 0 24px 24px">
        <a-breadcrumb style="margin: 16px 0">
          <a-breadcrumb-item>主页面</a-breadcrumb-item>
          <a-breadcrumb-item @click="teacher">教师页面</a-breadcrumb-item>
          <a-breadcrumb-item>个人信息</a-breadcrumb-item>
          
        </a-breadcrumb>
        <a-layout-content
          :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '600px' }"
        >
          
          
<a-table
    :columns="columns"
    :data-source="page.list"
    :pagination="pagination"
    @change="handleTableChange">

<template #u_sex="{text}">
    {{Sex[text]}}
    </template>

</a-table>
        </a-layout-content>
      </a-layout>
    </a-layout>

   

</template>


<script setup >
import {ref,reactive} from 'vue';
import {get} from '@/common';

const columns = [
  
  {
    dataIndex: "u_id", //服务端数据
    title: "学号", //表头项名称
   
  },
  {
    dataIndex: "u_name", //服务端数据
    title: "姓名", //表头项名称
  },
  {
    dataIndex: "u_sex", //服务端数据
    title: "性别", //表头项名称
    slots:{
      customRender:"u_sex"
    },
  },
  {
    dataIndex: "role_id", //服务端数据
    title: "角色", //表头项名称
  },
 
  {
    dataIndex: "dorm_id", //服务端数据
    title: "寝室号", //表头项名称
  },
   {
    dataIndex: "u_pwd", //服务端数据
    title: "密码", //表头项名称
  },
 
];

const Sex={
  0:'男',
  1:'女',
};





//分页处理-start
const query = reactive({}); //定义查询参数

const page = ref({}); //接收服务端返回的分页对象

//分页引擎
const pagination = reactive({
  current: 1, //当前页
  pageSize: 10, //每页记录数
  total: 0, //总记录数
  pageSizeOptions: ["2", "3", "5", "10", "20", "30", "100"], //每页记录下拉框的选型
  showSizeChanger: true, //是否展示每页记录数下拉框
  showQuickJumper: true, //是否展示快速跳转
  showTotal: (total, range) => {
    //展示总页数等文字说明信息的
    return (
      "共" +
      total +
      "条记录,当前第" +
      pagination.current +
      "页" +
      (range[1] - range[0] + 1) +
      "条记录"
    );
  },
});

//获取当前分页
const getPage = (pageNum = 1) => {
  query.pageNum = pageNum;
  query.pageSize = pagination.pageSize;

  get("/messageinfo/student", query).then((res) => {
    page.value = res.data; //将服务端传来的分页数据赋值予page

    //更新分页引擎
    pagination.current = page.value.current;
    pagination.pageSize = page.value.pageSize;
    pagination.total = page.value.total;
  });
};
getPage(1); //页面加载是，首先加载第一页

//当分页发送变化时（如：页码、每页记录数变化时）
const handleTableChange = (pagi, filters, sorter, { currentDataSource }) => {
  pagination.current = pagi.current;
  pagination.pageSize = pagi.pageSize;
  pagination.total = pagi.total;

  getPage(pagination.current);
};

//分页处理-end

import {useRouter} from 'vue-router';
const router = useRouter();

const teacher = ()=>{
    router.push({path:'/user/teacher'});
}
const allinfo = ()=>{
    router.push({path:'/messageinfo/allinfo'});
}
const changePwd = ()=>{
    router.push({path:'/security/changePwd'});
}
const login = ()=>{
    router.push({path:'/security/login'});
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