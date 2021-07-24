package com.xjtu.dormitory.user.sys_admin.dao;

import com.xjtu.dormitory.user.sys_admin.Student;
import com.xjtu.dormitory.user.sys_admin.StudentDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GetStudentListDao {


    @Select("select u_id,u_name from user where role_id='student'")
    List<Student> findStudent(StudentDto dto);
}
