package com.xjtu.dormitory.messageinfo.tousurecord;

import com.xjtu.dormitory.common.PageParam;

public
class TousurecordDto extends PageParam {
    public
    String getTousu_id () {
        return tousu_id;
    }

    public
    void setTousu_id ( String tousu_id ) {
        this.tousu_id = tousu_id;
    }

    public
    String getTousu () {
        return tousu;
    }

    public
    void setTousu ( String tousu ) {
        this.tousu = tousu;
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
    String getStatus () {
        return status;
    }

    public
    void setStatus ( String status ) {
        this.status = status;
    }

    public
    String getDetails () {
        return details;
    }

    public
    void setDetails ( String details ) {
        this.details = details;
    }

    public String tousu_id;
    public String tousu;
    public String u_id;
    public String status;
    public String details;
}
