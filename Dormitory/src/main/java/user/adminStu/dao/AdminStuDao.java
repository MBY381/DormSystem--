package com.xjtu.dormitory.user.adminStu.dao;

import com.xjtu.dormitory.user.adminStu.Users;
import com.xjtu.dormitory.user.adminStu.UsersDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


@Mapper
public interface AdminStuDao {

    @Update(
            "update user set u_pwd =#{u_pwd} where u_id = #{u_id}"
    )
    void updStudent(UsersDto dto);

    @Select("select u_id,role_id,u_pwd from user where role_id = 'student'")
    List<Users> findUserList(UsersDto dto);
}
