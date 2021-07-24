<template>
<div style="width:100%;height:100%;background-color:white;">
  <div style="width:100%;background-color:white;" >
    <a-button style="margin-left:300px;" @click="openStudentAdd">新增学员信息</a-button>
    <a-button style="margin-left:400px;" @click="openWorkerAdd">新增职工员信息</a-button>
  </div>
<div style="background-color: white;">
  <a-page-header
    style="background-color:white;"
    title="系统管理员"
    sub-title="管理学员名单"
  />
  <a-table
    :columns="columns"
    :data-source="page.list"
    :pagination="pagination"
    @change="handleTableChange"
  >
    <template #dormid="{ text }"> ID：{{ text }} </template>

    <template #num="{ text }"> 姓名：{{ text }} </template>

    <template #action="{ record }">
      <span>
        <a @click="deleteStudent(record)">删除</a>
      </span>
    </template>
  </a-table >
</div>

<div style="background-color: white;">
<a-page-header
    style="background-color: white;"
    sub-title="管理职工名单"
  />

  <a-table
    :columns="columns2"
    :data-source="page2.list"
    :pagination="pagination2"
    @change="handleTableChange2"
  >
    <template #dormid="{ text }"> ID：{{ text }} </template>

    <template #num="{ text }"> 姓名：{{ text }} </template>

    <template #action2="{ record }">
      <span>
        <a @click="deleteWorker(record)">删除</a>
      </span>
    </template>
  </a-table>
  
</div>
</div>

<a-modal v-model:visible="visible1" title="新增学员" @ok="addStudent">
    <a-form-item
      label="学号"
      has-feedback
      :validateStatus="type1"
      :help="message1"
    >
      <a-input
        v-model:value="student.u_id"
        placeholder="请输入学生学号"
        @change="checkId"
      />
    </a-form-item>

    <a-form-item
      label="姓名"
      has-feedback
      :validateStatus="type2"
      :help="message2"
    >
      <a-input
        v-model:value="student.u_name"
        placeholder="请输入学生姓名"
        @change="checkId2"
      />
    </a-form-item>
  </a-modal>

<a-modal v-model:visible="visible2" title="新增职工" @ok="addWorker">
        <a-form-item
      label="工号"
      has-feedback
      :validateStatus="type3"
      :help="message3"
    >
      <a-input
        v-model:value="worker.w_id"
        placeholder="请输入职工号"
        @change="checkId3"
      />
    </a-form-item>

    <a-form-item
      label="姓名"
      has-feedback
      :validateStatus="type4"
      :help="message4"
    >
      <a-input
        v-model:value="worker.w_name"
        placeholder="请输入职工姓名"
        @change="checkId4"
      />
    </a-form-item>
  </a-modal>

</template>

<script setup >
///////////////////////////////////////////////////////////引入 
import { reactive, ref } from "vue";
import { post, setLocalToken } from "@/common";
import { useRouter } from "vue-router";
import { get } from "@/common";
import { message } from 'ant-design-vue';
////////////////////////////////////////////////////////////变量
const columns = [
  {
    dataIndex: "u_id", //
    title: "学号",
    slots: {
      customRender: "dormid",
    },
  },
  {
    dataIndex: "u_name", //
    title: "学生姓名",
    slots: {
      customRender: "num",
    },
  },
  {
    title: "操作",
    key: "action",
    slots: {
      customRender: "action",
    },
  },
];

const columns2 = [
  {
    dataIndex: "w_id", //
    title: "职工号",
    slots: {
      customRender: "dormid",
    },
  },
  {
    dataIndex: "w_name", //
    title: "职工姓名",
    slots: {
      customRender: "num",
    },
  },
  {
    title: "操作",
    key: "action2",
    slots: {
      customRender: "action2",
    },
  },
];

const page = ref({});
const page2 = ref({});

const visible1 = ref(false);
const visible2 = ref(false);

const student = reactive({
  u_id:"",
  u_name:""
});

const worker = reactive({
  w_id:"",
  w_name:"",
})

const type1 = ref("error");
const message1 = ref("学号不为空！！");

const type2 = ref("error");
const message2 = ref("姓名不为空！！");

const type3 = ref("error");
const message3 = ref("职工号不为空！！");

const type4 = ref("error");
const message4 = ref("姓名不为空！！");

////////////////////////////////////////////////////////////方法
const checkId = ()=>{
  if((student.u_id).length > 0 ){
    type1.value=("success");
    message1.value=("");
  }else{
    type1.value=("error");
    message1.value=("学号不为空！！");
  }
};

const checkId2 = ()=>{
  if((student.u_name).length > 0 ){
    type2.value=("success");
    message2.value=("");
  }else{
    type2.value=("error");
    message2.value=("姓名不为空！！");
  }
};

const checkId3 = ()=>{
  if((worker.w_id).length > 0 ){
    type3.value=("success");
    message3.value=("");
  }else{
    type3.value=("error");
    message3.value=("职工号不为空！！");
  }
};

const checkId4 = ()=>{
  if((worker.w_name).length > 0 ){
    type4.value=("success");
    message4.value=("");
  }else{
    type4.value=("error");
    message4.value=("姓名不为空！！");
  }
};

const addStudent = ()=>{
  post("/user/sys_admin/addStudent",student).then((res)=>{
    if(res.success){
      message.success(res.message);
    }else{
      message.error(res.message);
    }

    getPage(1);
    visible1.value=false;

  });
};

const addWorker = ()=>{
  post("/user/sys_admin/addWorker",worker).then((res)=>{
    if(res.success){
      message.success(res.message);
    }else{
      message.error(res.message);
    }

    getPage1(1);

    visible2.value=false;
  });
};

const deleteStudent = (record) =>{
  student.u_id=record.u_id;
  post("/user/sys_admin/deleteStudent",student).then((res)=>{
    if(res.success){
      message.success(res.message);
    }else{
      message.error(res.message);
    }

    getPage(1);
  });
};

const deleteWorker = (record) =>{
  worker.w_id=record.w_id;
  post("/user/sys_admin/deleteWorker",worker).then((res)=>{
    if(res.success){
      message.success(res.message);
    }else{
      message.error(res.message);
    }

    getPage1(1);
  });
};

///////////////////////////////////////////////////////
const pagination2 = reactive({
  current: 1, //当前页
  pageSize: 2, //每页记录数
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
      pagination2.current +
      "页" +
      (range[1] - range[0] + 1) +
      "条记录"
    );
  },
});

const getPage1 = (pageNum = 1) => {

  worker.pageNum = pageNum;
  worker.pageSize = pagination2.pageSize;

  get("/user/sys_admin/getWorkerInfo", worker).then((res) => {
    page2.value = res.data; //将服务端传来的分页数据赋值予page

    //更新分页引擎
    pagination2.current = page2.value.current;
    pagination2.pageSize = page2.value.pageSize;
    pagination2.total = page2.value.total;
  });
};

getPage1(1);

const handleTableChange2 = (pagi, filters, sorter, { currentDataSource }) => {
  pagination2.current = pagi.current;
  pagination2.pageSize = pagi.pageSize;
  pagination2.total = pagi.total;

  getPage1(pagination2.current);
};
/////////////////////////////////////////////////////////////////
const pagination = reactive({
  current: 1, //当前页
  pageSize: 2, //每页记录数
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

const getPage = (pageNum = 1) => {

  student.pageNum = pageNum;
  student.pageSize = pagination.pageSize;

  get("/user/sys_admin/getStudentInfo", student).then((res) => {
    page.value = res.data; //将服务端传来的分页数据赋值予page

    //更新分页引擎
    pagination.current = page.value.current;
    pagination.pageSize = page.value.pageSize;
    pagination.total = page.value.total;
  });
};

getPage(1);

const handleTableChange = (pagi, filters, sorter, { currentDataSource }) => {
  pagination.current = pagi.current;
  pagination.pageSize = pagi.pageSize;
  pagination.total = pagi.total;

  getPage(pagination.current);
};


/////////////////////////////////////////////////////////////////
const openStudentAdd = ()=>{
  visible1.value=true;

};

const openWorkerAdd = ()=>{
  visible2.value=true;
};



////////////////////////////////////////////////////////////
</script>

<style>

</style>