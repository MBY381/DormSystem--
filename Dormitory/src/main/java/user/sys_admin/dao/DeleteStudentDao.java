package com.xjtu.dormitory.user.sys_admin.dao;

import com.xjtu.dormitory.user.sys_admin.StudentDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeleteStudentDao {
    @Delete("delete from user where u_id=#{u_id}")
    void deleteStudent(StudentDto dto);
}
