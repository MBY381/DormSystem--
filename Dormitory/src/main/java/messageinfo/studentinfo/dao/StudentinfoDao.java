package com.xjtu.dormitory.messageinfo.studentinfo.dao;

import com.xjtu.dormitory.common.CurrentUser;
import com.xjtu.dormitory.messageinfo.studentinfo.Studentinfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public
interface StudentinfoDao {
     List<Studentinfo> findStudentinfoList ( CurrentUser currentUser);
}
