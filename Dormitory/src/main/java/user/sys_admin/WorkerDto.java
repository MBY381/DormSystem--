package com.xjtu.dormitory.user.sys_admin;

import com.xjtu.dormitory.common.PageParam;

public class WorkerDto extends PageParam {

    private String w_id;
    private String w_name;

    public String getW_id() {
        return w_id;
    }

    public void setW_id(String w_id) {
        this.w_id = w_id;
    }

    public String getW_name() {
        return w_name;
    }

    public void setW_name(String w_name) {
        this.w_name = w_name;
    }
}
