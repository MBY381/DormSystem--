<template>
  <a-breadcrumb style="font-size: 18px; font-weight: bold; margin-bottom: 20px">
    <a-breadcrumb-item @click="toStudent"><a>学生管理</a></a-breadcrumb-item>
    <a-breadcrumb-item @click="toDorm"><a>宿舍管理</a></a-breadcrumb-item>
    <a-breadcrumb-item @click="toRole"><a>用户管理</a></a-breadcrumb-item>
    <a-breadcrumb-item><a>投诉处理</a></a-breadcrumb-item>
    <a-breadcrumb-item>功能</a-breadcrumb-item>
  </a-breadcrumb>
  <a-table
    :columns="columns"
    :data-source="page.list"
    :pagination="pagination"
    @change="handleTableChange"
  >
    <template #cusid="{ text }"> 编号：{{ text }} </template>

    <template #opr="{ record }">
      <a-button type="danger" @click="execDel(record.tousu_id)"
        >处理投诉</a-button
      >
    </template>
  </a-table>
</template>

<script setup>
import { ref, reactive } from "vue";
import { get, post, put, del, tip } from "@/common";
import { useRouter } from "vue-router";

const columns = [
  {
    dataIndex: "tousu_id", //服务端数据
    title: "序号", //表头项名称
  },
  {
    dataIndex: "tousu", //服务端数据
    title: "投诉内容", //表头项名称
  },
  {
    dataIndex: "u_id", //服务端数据
    title: "投诉人id", //表头项名称
  },
  {
    dataIndex: "status", //服务端数据
    title: "处理状态", //表头项名称
  },
  {
    key: "orp",
    title: "操作",
    slots: {
      customRender: "opr", //定义插槽名称，即以cusid为名插槽的数据插入该列位置
    },
  },
];
//获取当前分页
//分页处理-start
const router = useRouter();

const query = reactive({
  u_id: "",
}); //定义查询参数

const page = ref({}); //接收服务端返回的分页对象

//分页引擎
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

//获取当前分页
const getPage = (pageNum = 1) => {
  query.pageNum = pageNum;
  query.pageSize = pagination.pageSize;

  get("/tousu", query).then((res) => {
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

//处理投诉
const execDel = (tousu_id) => {
  put("/tousu/" + tousu_id).then((res) => {
    tip.success("处理成功！");
    getPage(page.value.current);
  });
};
const toDorm = () => {
  router.push({ path: "/user/adminDorm" });
};

const toStudent = () => {
  router.push({ path: "/user/adminStu" });
};

const toRole = () => {
  router.push({ path: "/user/admin" });
};

const user = reactive({
  louhao: "",
  u_sex: "",
  u_dormid: "",
});
</script>

<style scoped>
</style>