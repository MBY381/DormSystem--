package com.xjtu.dormitory.messageinfo.tousurecord.dao;

import com.xjtu.dormitory.common.CurrentUser;
import com.xjtu.dormitory.messageinfo.tousurecord.Tousurecord;
import com.xjtu.dormitory.messageinfo.tousurecord.TousurecordDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public
interface TousurecordDao {
     List<Tousurecord> findTousurecordList ( CurrentUser currentUser  );
}
