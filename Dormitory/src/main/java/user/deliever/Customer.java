package com.xjtu.dormitory.user.deliever;

public class Customer {
    private Integer water_id;
    private String dorm_id;
    private String u_id;
    private Integer deliever_status;
    private String time_begin;
    private String time_finish;
    private String time_actual;
    private String deliever_id;

    public Integer getWater_id() {
        return water_id;
    }

    public void setWater_id(Integer water_id) {
        this.water_id = water_id;
    }

    public String getDorm_id() {
        return dorm_id;
    }

    public void setDorm_id(String dorm_id) {
        this.dorm_id = dorm_id;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public Integer getDeliever_status() {
        return deliever_status;
    }

    public void setDeliever_status(Integer deliever_status) {
        this.deliever_status = deliever_status;
    }

    public String getTime_begin() {
        return time_begin;
    }

    public void setTime_begin(String time_begin) {
        this.time_begin = time_begin;
    }

    public String getTime_finish() {
        return time_finish;
    }

    public void setTime_finish(String time_finish) {
        this.time_finish = time_finish;
    }

    public String getTime_actual() {
        return time_actual;
    }

    public void setTime_actual(String time_actual) {
        this.time_actual = time_actual;
    }

    public String getDeliever_id() {
        return deliever_id;
    }

    public void setDeliever_id(String deliver_id) {
        this.deliever_id = deliver_id;
    }
}
