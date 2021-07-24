package com.xjtu.dormitory.user.sys_admin;

import com.xjtu.dormitory.common.PageParam;

public class StudentDto extends PageParam {

    private String u_id;
    private String u_name;

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }
}
