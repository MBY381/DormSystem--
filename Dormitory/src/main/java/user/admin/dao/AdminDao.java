package com.xjtu.dormitory.user.admin.dao;

import com.xjtu.dormitory.user.admin.AdminDto;
import com.xjtu.dormitory.user.admin.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminDao {
    List<Role> findRoleList(AdminDto dto) ;

    @Delete("delete from user where u_id = #{uid}")
    void deleteRole(String id);
}
