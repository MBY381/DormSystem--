package com.xjtu.dormitory.security.register.dao;

import com.xjtu.dormitory.security.register.RegisterDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RegisterDao {
    @Select("select count(w_id) from worker where w_id=#{u_id}")
    int findWorker(RegisterDto dto);

    @Insert("insert into user values(#{u_id},#{role_id},#{u_pwd},'0000','','','','','')")
    void insertUser(RegisterDto dto);
}
