package com.xjtu.dormitory.security.completeInfo.dao;

import com.xjtu.dormitory.security.completeInfo.UserDto;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CompleteInfoDao {

    @Update("update user set u_pwd=#{dto.u_pwd},u_name=#{dto.u_name},u_netid=#{dto.u_netid},u_sex=#{dto.u_sex} where u_id=#{uid}")
    void updateUser(@Param("dto") UserDto dto, @Param("uid") String u_id);

    @Select("select max(change_id)+1 from changerecord")
    Integer getNewId();

    @Insert("insert into changerecord values ('0000',#{uid},#{id},'0',#{dto.u_dormid})")
    void updateChangeRecord(@Param("dto") UserDto dto, @Param("uid") String u_id, @Param("id") Integer recordId);
}
