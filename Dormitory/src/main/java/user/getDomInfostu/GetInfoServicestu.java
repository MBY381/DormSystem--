package com.xjtu.dormitory.user.getDomInfostu;

import com.xjtu.dormitory.user.repairer.RapairDto;

import java.util.Map;

public interface GetInfoServicestu {
    Map<String, Object> getInfoList(RapairDto ddd);


    String getdormid(String userId);

    String getusex(String userId);
}
