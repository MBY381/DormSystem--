package com.xjtu.dormitory.messageinfo.student.dao;

import com.xjtu.dormitory.common.CurrentUser;
import com.xjtu.dormitory.messageinfo.student.Student;
import com.xjtu.dormitory.messageinfo.student.Studentdto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public
interface StudentDao {
     List<Student> findStudentList ( CurrentUser currentUser );
}
