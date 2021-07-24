package com.xjtu.dormitory.security.loginByNetid.dao;

import com.xjtu.dormitory.security.loginByNetid.LoginByNetidDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginByNetidDao {


    @Select("select count(u_id) from user where u_netid=#{u_id} and u_pwd = #{u_pwd}")
    int checkNetId(LoginByNetidDto dto);


    @Select("select role_web from user,role_model where user.role_id=role_model.role_id and user.u_netid = #{u_id}")
    String findRoleWeb(LoginByNetidDto dto);

    @Select("select u_id from user where u_netid = #{u_id}")
    String getUserId(LoginByNetidDto dto);
}
