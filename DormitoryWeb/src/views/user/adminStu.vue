<template>
  <div>
  <a-breadcrumb style="font-size: 18px; font-weight: bold; background-color:white;">
    <a-breadcrumb-item @click="toStudent"><a>学生管理</a></a-breadcrumb-item>
    <a-breadcrumb-item @click="toDorm"><a>宿舍管理</a></a-breadcrumb-item>
    <a-breadcrumb-item @click="toRole"><a>用户管理</a></a-breadcrumb-item>
        <a-breadcrumb-item @click="tousu"><a>投诉处理</a></a-breadcrumb-item>
    <a-breadcrumb-item>功能</a-breadcrumb-item>
  </a-breadcrumb>
  </div>

  <a-table
    :columns="columns"
    :data-source="page.list"
    :pagination="pagination"
    @change="handleTableChange"
  >
    <template #opr="{ record }">
      <a-button @click="openUpd(record)" type="primary">修改密码</a-button>
  
    </template>
  </a-table>
  <a-modal v-model:visible="visible" title="修改密码" @ok="execUpd">
    <a-form :model="updObj" :label-col="{span:5}" :wrapper-col="{span:14}">

     <a-input v-model:value="updObj.u_pwd" />
    </a-form>
  </a-modal>
</template>

<script setup >
import { reactive, ref } from "vue";
import { post, setLocalToken } from "@/common";
import { useRouter } from "vue-router";
import { get, del, tip,put } from "@/common";
import { message } from "ant-design-vue";

/////////////////////////////////////////


const columns = [
  {
    dataIndex: "u_id", //服务端数据
    title: "学生名称", //表头项名称
  },
  {
    dataIndex: "role_id", //服务端数据
    title: "角色", //表头项名称
  },
  {
    dataIndex: "u_pwd", //服务端数据
    title: "学生密码", //表头项名称
  },
  {
    key: "opr",
    title: "操作",
    slots: {
      customRender: "opr",
    },
  },
];

const query = reactive({});
const page = ref({});
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

  get("/user/adminStu", query).then((res) => {
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

////////////////////////////////////////////////////////////////////
const router = useRouter();

const toDorm = () => {
  router.push({ path: "/user/adminDorm" });
};

const toStudent = () => {
  router.push({ path: "/user/adminStu" });
};

const toRole = () => {
  router.push({ path: "/user/admin" });
};

const tousu=()=>{
  router.push({path:"/user/admintousu"})
}
//////////////////////////////////////////////////////////
//修改密码
const updObj = reactive({
    u_pwd:"",
    u_id:"",

});
const visible = ref(false);
const openUpd = (u) => {
    updObj.u_pwd=u.u_pwd;
    updObj.u_id=u.u_id;
  visible.value = true;
};
const execUpd = () => {
    post("/user/adminStu",updObj).then((res)=>{
        updObj.u_pwd = "";
        updObj.u_id="";
        visible.value = false;
        tip.success("修改密码成功！");
        getPage(page.value.current);
    });
};
</script>
<style scoped>
</style>