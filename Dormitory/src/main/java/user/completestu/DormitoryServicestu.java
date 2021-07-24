package com.xjtu.dormitory.user.completestu;

import com.xjtu.dormitory.user.repairer.RapairDto;

public interface DormitoryServicestu {

    String getdormid(String userId);

    Integer getmaxid();

    void insertall(RapairDto ddd);

    Integer getnum(String time_finish);

    Integer getid(String u_id);
}
