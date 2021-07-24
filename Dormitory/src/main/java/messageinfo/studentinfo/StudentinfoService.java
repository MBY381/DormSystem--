package com.xjtu.dormitory.messageinfo.studentinfo;


import com.xjtu.dormitory.common.CurrentUser;

import java.util.Map;

public interface StudentinfoService {



    Map<String, Object> getStudentinfoList ( CurrentUser currentUser );
}
