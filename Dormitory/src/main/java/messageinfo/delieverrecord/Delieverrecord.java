package com.xjtu.dormitory.messageinfo.delieverrecord;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public
class Delieverrecord {
    public
    String getDorm_id () {
        return dorm_id;
    }

    public
    void setDorm_id ( String dorm_id ) {
        this.dorm_id = dorm_id;
    }

    public
    String getU_id () {
        return u_id;
    }

    public
    void setU_id ( String u_id ) {
        this.u_id = u_id;
    }

    public
    String getDeliever_status () {
        return deliever_status;
    }

    public
    void setDeliever_status ( String deliever_status ) {
        this.deliever_status = deliever_status;
    }

    public
    Date getTime_begin () {
        return time_begin;
    }

    public
    void setTime_begin ( Date time_begin ) {
        this.time_begin = time_begin;
    }

    public
    Date getTime_finish () {
        return time_finish;
    }

    public
    void setTime_finish ( Date time_finish ) {
        this.time_finish = time_finish;
    }

    public
    String getDeliever_id () {
        return deliever_id;
    }

    public
    void setDeliever_id ( String deliever_id ) {
        this.deliever_id = deliever_id;
    }

    public
    Date getTime_actual () {
        return time_actual;
    }

    public
    void setTime_actual ( Date time_actual ) {
        this.time_actual = time_actual;
    }

    public
    String getWater_id () {
        return water_id;
    }

    public
    void setWater_id ( String water_id ) {
        this.water_id = water_id;
    }

    public
    String getDetails () {
        return details;
    }

    public
    void setDetails ( String details ) {
        this.details = details;
    }

    public String dorm_id;
    public String u_id;
    public String deliever_status;

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date time_begin;

    @JsonFormat( pattern = "yyyy-MM-dd")
    public Date time_finish;

    public String deliever_id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date time_actual;
    public  String water_id;
    public String details;
}
