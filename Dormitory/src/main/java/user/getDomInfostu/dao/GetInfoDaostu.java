package com.xjtu.dormitory.user.getDomInfostu.dao;

import com.xjtu.dormitory.user.getDomInfostu.Infostu;
import com.xjtu.dormitory.user.repairer.RapairDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GetInfoDaostu {

    @Select("select dorm_id,student_num from dormitory where dorm_id!=#{dorm_id} and dorm_sex=#{u_sex}")
    List<Infostu> findInfoList(RapairDto ddd);

    @Select("select dorm_id from user where u_id=#{dormid}")
    String finddormid(String dormid);

    @Select("select u_sex from user where u_id=#{userId} ")
    String findusex(String userId);
}
