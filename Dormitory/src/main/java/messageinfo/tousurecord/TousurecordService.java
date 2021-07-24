package com.xjtu.dormitory.messageinfo.tousurecord;

import com.xjtu.dormitory.common.CurrentUser;

import java.util.Map;

public
interface TousurecordService {
    Map<String, Object> getTousurecordList ( CurrentUser currentUser );
}
