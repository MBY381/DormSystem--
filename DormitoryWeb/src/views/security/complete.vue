<template>
<div style="background-color:white;">
  <div class="home">
    <a-steps
      progress-dot
      :current="stepCurrent"
      size="small"
      style="margin-top: 30px; margin-left: 240px; width: 1000px"
    >
      <a-step title="新生完成登录" />
      <a-step title="完善信息与宿舍选择" />
      <a-step title="等待审核" />
    </a-steps>
    <a-divider style="background-color: rgba(0, 100, 255, 0.5)"></a-divider>
  </div>

  <div>
    <a-form :model="user" :label-col="labelCol" :wrapper-col="wrapperCol">
      <a-form-item
        label="请输入新密码"
        has-feedback
        :validate-status="type"
        :help="help"
      >
        <a-input-password v-model:value="user.u_pwd" @change="check" />
      </a-form-item>

      <a-form-item label="请输入自定义的NetID">
        <a-input v-model:value="user.u_netid" />
      </a-form-item>

      <a-form-item label="请输入姓名">
        <a-input v-model:value="user.u_name" />
      </a-form-item>

      <a-form-item
        label="请选择期望的宿舍楼号"
        defaultChecked="boolean"
      >
        <a-radio-group
          v-model:value="user.louhao"
          @change="changeTheRadioStatus"
        >
          <a-radio :value="9"> 东九 </a-radio>
          <a-radio :value="8"> 东八 </a-radio>
          <a-radio :value="7"> 东七(女) </a-radio>
        </a-radio-group>
      </a-form-item>

      <a-form-item label="性别">
        <a-radio-group
          v-model:value="user.u_sex"
          @change="getPage(1)"
          :disabled="theRaidoStatus"
        >
          <a-radio :value="0"> 男 </a-radio>
          <a-radio :value="1"> 女 </a-radio>
        </a-radio-group>

        <a-tooltip>
          <template #title>请先选择性别与宿舍楼</template>
          <a-button
            type="default"
            id="button"
            style="margin-left: 100px"
            @click="getPage(1)"
            >查询宿舍信息</a-button
          >
        </a-tooltip>


      </a-form-item>

      <a-divider style="background-color: rgba(0, 100, 255, 0.5)"></a-divider>
    </a-form>
  </div>
  </div>
  <a-table
    :columns="columns"
    :data-source="page.list"
    :pagination="pagination"
    @change="handleTableChange"
  >
    <template #dormid="{ text }"> 宿舍号：{{ text }} </template>

    <template #num="{ text }"> 已有人数：{{ text }} </template>

    <template #action="{ record }">
      <span>
        <a @click="openInfo(record)">查看宿舍</a>
        <a-divider
          type="vertical"
          style="background-color: rgba(0, 100, 255, 0.5)"
        />
        <a @click="confirm(record)">确认选择</a>
      </span>
    </template>
  </a-table>

  <a-row style="margin-left: 800px; margin-top: 20px">
    <a-col :span="12">
      <a-statistic title="" :value="dormitory" style="margin-right: 50px">
        <template #prefix> 宿舍 <HomeOutlined />： </template>
      </a-statistic>
    </a-col>

    <a-button @click="commit" :disabled="tempbutton">完成最终信息</a-button>
  </a-row>

  <a-modal v-model:visible="visible" title="宿舍成员信息" @ok="closeInfo">
    <a-table :columns="columns2" :data-source="page2.list"></a-table>
  </a-modal>
</template>

<script setup >
/////////////////////////////////////////////////////////////////////////////////////引入
import { reactive, ref } from "vue";
import { post, setLocalToken } from "@/common";
import { useRouter } from "vue-router";
import { get } from "@/common";
import { message } from 'ant-design-vue';
import { HomeOutlined } from '@ant-design/icons-vue';

/////////////////////////////////////////////////////////////////////////////////////变量定义

const user = reactive({
  u_pwd: "",
  u_name: "",
  u_netid: "",
  louhao: "",
  u_sex: "",
  u_dormid: "",
});

const checkInfo = reactive({
  sex: "",
  louhao1: "",
});

const boolean = true;

const type = ref("");

const help = ref("");

const columns = [
  {
    dataIndex: "dorm_id", //
    title: "可选的宿舍号",
    slots: {
      customRender: "dormid",
    },
  },
  {
    dataIndex: "student_num", //
    title: "宿舍已有人数",
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
    dataIndex: "u_name", //
    title: "学生姓名",
  },
  {
    dataIndex: "u_id", //
    title: "学生学号",
  },
];

const check = () => {
  if (user.u_pwd.length >= 6) {
    type.value = "success";
    help.value = "";
  } else {
    type.value = "error";
    help.value = "新密码不得少于6位";
  }
};

const query = reactive({});

const page = ref({});

const page2 = ref({});

const dormitory = ref("");

const theRaidoStatus = ref(true);

const tempbutton = ref(true);

const stepCurrent = ref("1");

//////////////////////////////////////////////////////////////////////////// 方法：

//更改性别raido状态方法：

const changeTheRadioStatus = () => {
  theRaidoStatus.value = false;
};

//确认选择的方法

const confirm = (dorm) => {
  user.u_dormid = dorm.dorm_id;

  dormitory.value = dorm.dorm_id;

  tempbutton.value = false;
};

//完成最终信息的方法：

const commit = ()=>{
  post("/security/completeInfo",user).then((res)=>{
    
    stepCurrent.value="2";

    if(res.success){
      message.success(res.message);
    }else{
      message.error(res.message);
    }

    router.push({ path:"/security/login"});


  });
};

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
  user.u_dormid = "";

  checkInfo.louhao1 = user.louhao;

  checkInfo.sex = user.u_sex;

  dormitory.value = "0";

  checkInfo.pageNum = pageNum;
  checkInfo.pageSize = pagination.pageSize;

  get("/security/complete", checkInfo).then((res) => {
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

const router = useRouter();

const labelCol = {
  span: 4,
};
const wrapperCol = {
  span: 8,
};

////////////////////////
const visible = ref(false);

const Info = reactive({
  dorm_id: "",
});

const closeInfo = () => {
  visible.value = false;
};

const openInfo = (dorm) => {
  visible.value = true;

  Info.dorm_id = dorm.dorm_id;

  get("/security/getInfo", Info).then((res) => {
    page2.value = res.data;
  });
};
</script>

<style scoped>
.home {
  height: 100px;
  width: 100%;
}
</style>