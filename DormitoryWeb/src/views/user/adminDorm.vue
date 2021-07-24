<template>
  <a-breadcrumb style="font-size: 18px;font-weight: bold; background-color:white;">
    <a-breadcrumb-item @click="toStudent"><a >学生管理</a></a-breadcrumb-item>
    <a-breadcrumb-item @click="toDorm"><a >宿舍管理</a></a-breadcrumb-item>
    <a-breadcrumb-item @click="toRole"><a >用户管理</a></a-breadcrumb-item>
        <a-breadcrumb-item @click="tousu"><a>投诉处理</a></a-breadcrumb-item>
    <a-breadcrumb-item >功能</a-breadcrumb-item>
  </a-breadcrumb>
  <!-- <a-page-header
    style="border: 1px solid rgb(235, 237, 240)"
    title="宿管"
    sub-title="管理宿舍申请"
  /> -->

  <a-table
    :columns="columns"
    :data-source="page.list"
    :pagination="pagination"
    @change="handleTableChange"
  >
    <template #action="{ record }">
      <span>
        <a @click="agree(record)">同意</a>

        <a-divider
          type="vertical"
          style="background-color: rgba(0, 100, 255, 0.5)"
        />
        <a @click="disagree(record)">拒绝</a>
      </span>
    </template>
  </a-table>
</template>

<script setup >
//////////////////////////////////////////////////////引入
import { reactive, ref } from "vue";
import { post, setLocalToken } from "@/common";
import { useRouter } from "vue-router";
import { get } from "@/common";
import { message } from "ant-design-vue";
/////////////////////////////////////////////////////变量


const columns = [
  {
    dataIndex: "u_id", //
    title: "学号",
  },
  {
    dataIndex: "u_name", //
    title: "学生姓名",
    slots: {
      customRender: "name",
    },
  },
  {
    dataIndex: "dorm_id", //
    title: "旧宿舍",
    slots: {
      customRender: "old",
    },
  },
  {
    dataIndex: "newdorm_id", //
    title: "新宿舍",
    slots: {
      customRender: "new",
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

const page = ref({});

const user = reactive({
  u_id: "",
  dorm_id: "",
  newdorm_id: "",
});

const query = reactive({});

/////////////////////////////////////////////////////方法
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

const getPage = (pageNum = 1) => {
  query.pageNum = pageNum;
  query.pageSize = pagination.pageSize;

  get("/user/admin/getChangeRecord", query).then((res) => {
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

const agree = (info) =>{
    user.u_id=info.u_id;
    user.dorm_id=info.dorm_id;
    user.newdorm_id=info.newdorm_id;

    post("/user/admin/agreeChange",user).then((res)=>{
    if(res.success){
      message.success(res.message);
    }else{
      message.error(res.message);
    }

    getPage(1);

  });
};

const disagree = (info) =>{
    user.u_id=info.u_id;
    user.dorm_id=info.dorm_id;
    user.newdorm_id=info.newdorm_id;

    post("/user/admin/disagreeChange",user).then((res)=>{
    if(res.success){
      message.success(res.message);
    }else{
      message.error(res.message);
    }

    getPage(1);

  });
};

const router = useRouter();

const toDorm = ()=>{
  router.push({path:'/user/adminDorm'});
}

const toStudent = ()=>{
  router.push({path:'/user/adminStu'});
}

const toRole = ()=>{
  router.push({path:'/user/admin'});
}

const tousu=()=>{
  router.push({path:"/user/admintousu"})
}

//////////////////////////////////////////////////////
</script>

<style scoped>
</style>