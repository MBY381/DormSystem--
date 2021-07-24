package com.xjtu.dormitory.messageinfo.repairrecord;

import com.fasterxml.jackson.annotation.JsonFormat;


import java.util.Date;

public
class Repairrecord {

    public String dorm_id;
    public String u_id;
    public String repair_status;

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date time_begin;

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date time_finish;
    public String repairer_id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date time_actual;
    public String repair_id;

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
    String getRepair_status () {
        return repair_status;
    }

    public
    void setRepair_status ( String repair_status ) {
        this.repair_status = repair_status;
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
    String getRepairer_id () {
        return repairer_id;
    }

    public
    void setRepairer_id ( String repairer_id ) {
        this.repairer_id = repairer_id;
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
    String getRepair_id () {
        return repair_id;
    }

    public
    void setRepair_id ( String repair_id ) {
        this.repair_id = repair_id;
    }
}
