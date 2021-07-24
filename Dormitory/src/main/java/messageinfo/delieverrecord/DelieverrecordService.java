package com.xjtu.dormitory.messageinfo.delieverrecord;

import com.xjtu.dormitory.common.CurrentUser;


import java.util.Map;

public
interface DelieverrecordService {
    Map<String, Object> getDelieverrecordList ( CurrentUser currentUser);



}
