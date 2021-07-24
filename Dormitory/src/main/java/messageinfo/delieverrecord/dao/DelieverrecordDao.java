package com.xjtu.dormitory.messageinfo.delieverrecord.dao;


import com.xjtu.dormitory.common.CurrentUser;
import com.xjtu.dormitory.messageinfo.delieverrecord.Delieverrecord;
import com.xjtu.dormitory.messageinfo.delieverrecord.DelieverrecordDto;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface DelieverrecordDao {
     List<Delieverrecord> findDelieverrecordList ( CurrentUser currentUser );




}
