package com.xjtu.dormitory.user.admin;

import com.xjtu.dormitory.common.PageParam;

public class reacordDto extends PageParam {
    private String u_id;
    private String dorm_id;
    private String newdorm_id;


    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getDorm_id() {
        return dorm_id;
    }

    public void setDorm_id(String dorm_id) {
        this.dorm_id = dorm_id;
    }

    public String getNewdorm_id() {
        return newdorm_id;
    }

    public void setNewdorm_id(String newdorm_id) {
        this.newdorm_id = newdorm_id;
    }
}
