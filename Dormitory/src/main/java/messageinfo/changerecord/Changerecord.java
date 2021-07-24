package com.xjtu.dormitory.messageinfo.changerecord;

public
class Changerecord {
    public
    String getU_id () {
        return u_id;
    }

    public
    void setU_id ( String u_id ) {
        this.u_id = u_id;
    }

    public
    String getDorm_id () {
        return dorm_id;
    }

    public
    void setDorm_id ( String dorm_id ) {
        this.dorm_id = dorm_id;
    }

    public
    String getNewdorm_id () {
        return newdorm_id;
    }

    public
    void setNewdorm_id ( String newdorm_id ) {
        this.newdorm_id = newdorm_id;
    }

    public
    String getChange_status () {
        return change_status;
    }

    public
    void setChange_status ( String change_status ) {
        this.change_status = change_status;
    }

    public String u_id;
      public String dorm_id;
      public String newdorm_id;
      public String change_status;
}
