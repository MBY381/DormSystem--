package com.xjtu.dormitory.messageinfo.student;

import com.xjtu.dormitory.common.CurrentUser;

import java.util.Map;

public interface StudentService {
    Map<String, Object> getStudentList ( CurrentUser currentUser );
}
