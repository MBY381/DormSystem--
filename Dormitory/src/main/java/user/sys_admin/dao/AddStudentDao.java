package com.xjtu.dormitory.user.sys_admin.dao;

import com.xjtu.dormitory.user.sys_admin.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddStudentDao {

    @Insert("insert into user values (#{u_id},'student','111111','0000','',#{u_name},'','','')")
    void insertStudent(Student dto);
}
