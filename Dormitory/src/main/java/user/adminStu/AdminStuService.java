package com.xjtu.dormitory.user.adminStu;

import java.util.Map;

public interface AdminStuService {
    Map<String, Object> getUserList(UsersDto dto);


    void updStudent(UsersDto dto);
}
