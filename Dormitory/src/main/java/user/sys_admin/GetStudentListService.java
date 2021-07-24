package com.xjtu.dormitory.user.sys_admin;

import java.util.Map;

public interface GetStudentListService {
    Map<String, Object> getStudentListInfo(StudentDto dto);
}
