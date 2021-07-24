package com.xjtu.dormitory.user.student;

import com.xjtu.dormitory.common.PageParam;

public class TousuDtt extends PageParam {
    private String u_id;
    private String tousu;
    private  Integer tousu_id;

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getTousu() {
        return tousu;
    }

    public void setTousu(String tousu) {
        this.tousu = tousu;
    }

    public Integer getTousu_id() {
        return tousu_id;
    }

    public void setTousu_id(Integer tousu_id) {
        this.tousu_id = tousu_id;
    }
}
