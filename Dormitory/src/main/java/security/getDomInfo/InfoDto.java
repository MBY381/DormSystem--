package com.xjtu.dormitory.security.getDomInfo;

import com.xjtu.dormitory.common.PageParam;

public class InfoDto extends PageParam {

    private String dorm_id;

    public String getDorm_id() {
        return dorm_id;
    }

    public void setDorm_id(String dorm_id) {
        this.dorm_id = dorm_id;
    }
}
