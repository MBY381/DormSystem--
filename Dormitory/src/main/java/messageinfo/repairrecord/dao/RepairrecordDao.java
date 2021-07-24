package com.xjtu.dormitory.messageinfo.repairrecord.dao;

import com.xjtu.dormitory.common.CurrentUser;
import com.xjtu.dormitory.messageinfo.repairrecord.Repairrecord;
import com.xjtu.dormitory.messageinfo.repairrecord.RepairrecordDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RepairrecordDao {
     List<Repairrecord> findRepairrecordList (CurrentUser currentUser);
}
