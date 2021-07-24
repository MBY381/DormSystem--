package com.xjtu.dormitory.security.completeInfo;

public interface CompleteInfoService {
    boolean updateUserInfo(UserDto dto, String u_id);

    Integer getRecordId();

    boolean offerChangeDorm(UserDto dto, String u_id, Integer recordId);
}
