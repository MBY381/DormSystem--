package com.xjtu.dormitory.messageinfo.repairrecord;

import com.xjtu.dormitory.common.CurrentUser;

import java.util.Map;

public
interface RepairrecordService {
    Map<String, Object> getRepairrecordList (CurrentUser currentUser);
}
