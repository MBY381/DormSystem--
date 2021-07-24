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
            <a-menu-item key="9" @click="userinfo3">个人信息</a-menu-item>

          </a-sub-menu>
          <a-sub-menu key="sub1">
            <template #title>
              <span>
                <user-outlined />
                送水功能
              </span>
            </template>
            <a-menu-item key="1" @click="allup()" >一键送水</a-menu-item>
             <a-menu-item key="2" @click="alldel()" >一键删除</a-menu-item>
            
          </a-sub-menu>
         
          
        </a-menu>
      </a-layout-sider>
      <a-layout style="padding: 0 24px 24px">
        <a-breadcrumb style="margin: 16px 0">
          <a-breadcrumb-item>主页面</a-breadcrumb-item>
          <a-breadcrumb-item>送水工页面</a-breadcrumb-item>
          
        </a-breadcrumb>
        <a-layout-content
          :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '600px' }"
        >
           <a-table
    :columns="columns"
    :data-source="page.list"
    :pagination="pagination"
    @change="handleTableChange"
  >
    <template #cusid="{ text }"> 编号：{{ text }} </template>
     <template #deliever_status="{text}">
    {{Status[text]}}
    </template>
    <template #opr="{ record }">
     <a-button @click="addwater(record.water_id)">送水</a-button>
      <a-divider type="vertical" />
      <a-button type="danger" @click="execDel(record.water_id)" >删除</a-button>
     

    </template>
  </a-table>

        </a-layout-content>
      </a-layout>
    </a-layout>
 
  </template>
  
 

<script setup>
import { ref,reactive} from "vue";
import {get, post, put, del, tip } from "@/common";

const columns = [
  {
    dataIndex: "water_id", //服务端数据
    title: "序号", //表头项名称
    
  },
  {
    dataIndex: "dorm_id", //服务端数据
    title: "宿舍号", //表头项名称
  },
  {
    dataIndex: "u_id", //服务端数据
    title: "申请人id", //表头项名称
  },
  {
   dataIndex: "deliever_status", //服务端数据
    title: "状态", //表头项名称
    slots:{
      customRender:"deliever_status"
    },
  },
   {
   dataIndex: "time_begin", //服务端数据
    title: "申请时间", //表头项名称
  },
   {
   dataIndex: "time_finish", //服务端数据
    title: "截止时间", //表头项名称
  },
   {
   dataIndex: "time_actual", //服务端数据
    title: "实际送水时间", //表头项名称
  },
   {
   dataIndex: "deliever_id", //服务端数据
    title: "送水员工号", //表头项名称
  },
  {key:'orp',
  title:"操作",
  slots: {
      customRender: "opr", //定义插槽名称，即以cusid为名插槽的数据插入该列位置
    },
  },
];
const Status={
  0:'未送达',
  1:'已送达',
};

//获取当前分页
//分页处理-start
const query = reactive({
  u_id:'',
});//定义查询参数

const page = ref({});//接收服务端返回的分页对象

//分页引擎
const pagination = reactive({
  current: 1,//当前页
  pageSize: 10,//每页记录数
  total: 0,//总记录数
  pageSizeOptions: ["2", "3", "5", "10", "20", "30", "100"],//每页记录下拉框的选型
  showSizeChanger: true,//是否展示每页记录数下拉框
  showQuickJumper: true,//是否展示快速跳转
  showTotal: (total, range) => {//展示总页数等文字说明信息的
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

  get('/deliever', query).then(res => {
    page.value = res.data;//将服务端传来的分页数据赋值予page

    //更新分页引擎
    pagination.current=page.value.current
    pagination.pageSize=page.value.pageSize
    pagination.total=page.value.total
    
  });
};
getPage(1);//页面加载是，首先加载第一页

//当分页发送变化时（如：页码、每页记录数变化时）
const handleTableChange = (pagi, filters, sorter, { currentDataSource }) => {
    
	pagination.current=pagi.current
  pagination.pageSize=pagi.pageSize
  pagination.total=pagi.total

	getPage(pagination.current)
};


//更新
const allup=()=>{
  put('/deliever').then(res=>{
    tip.success("送水成功");
    getpage(page.value.current);
  });
};
const execDel=(water_id)=>{
del('/deliever/'+water_id).then(res=>{
        tip.success("删除成功！");
        getPage(page.value.current);
    });
};
 const addwater=(water_id)=>{
put('/deliever/'+water_id).then(res=>{
        tip.success("送水成功！");
        getPage(page.value.current);
    });
};
const alldel=()=>{
  del('/deliever').then(res=>{
    tip.success("删除成功");
    getpage(page.value.current);
  });
};
const user = reactive({
  louhao: "",
  u_sex: "",
  u_dormid: "",
});

import {useRouter} from 'vue-router';
const router = useRouter();

const changePwd = ()=>{
    router.push({path:'/security/changePwd'});
}
const login = ()=>{
    router.push({path:'/security/login'});
}
const userinfo3 = ()=>{
    router.push({path:'/messageinfo/userinfo3'});
}

</script>

<style scoped>
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