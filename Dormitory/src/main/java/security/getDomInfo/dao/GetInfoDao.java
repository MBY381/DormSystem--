package com.xjtu.dormitory.security.getDomInfo.dao;

import com.xjtu.dormitory.security.getDomInfo.Info;
import com.xjtu.dormitory.security.getDomInfo.InfoDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GetInfoDao {

    @Select("select u_id,u_name from user where dorm_id = #{dorm_id}")
    List<Info> findInfoList(InfoDto dto);
}
