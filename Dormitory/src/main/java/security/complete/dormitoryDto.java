package com.xjtu.dormitory.security.complete;

import com.xjtu.dormitory.common.PageParam;

public class dormitoryDto extends PageParam {
    private String louhao1;
    private String sex;

    public String getLouhao1() {
        return louhao1;
    }

    public void setLouhao1(String louhao1) {
        this.louhao1 = louhao1;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
