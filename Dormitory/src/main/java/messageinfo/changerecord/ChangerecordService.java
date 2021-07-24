package com.xjtu.dormitory.messageinfo.changerecord;

import com.xjtu.dormitory.common.CurrentUser;

import java.util.Map;

public
interface ChangerecordService {
    Map<String, Object> getChangerecordList ( CurrentUser currentUser );
}
