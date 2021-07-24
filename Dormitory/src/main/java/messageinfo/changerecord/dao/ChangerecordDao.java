package com.xjtu.dormitory.messageinfo.changerecord.dao;

import com.xjtu.dormitory.common.CurrentUser;
import com.xjtu.dormitory.messageinfo.changerecord.Changerecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public
interface ChangerecordDao {


     List<Changerecord> findChangerecordList ( CurrentUser currentUser );
}
