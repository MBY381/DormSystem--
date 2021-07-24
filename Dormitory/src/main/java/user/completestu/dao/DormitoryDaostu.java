package com.xjtu.dormitory.user.completestu.dao;

import com.xjtu.dormitory.user.repairer.RapairDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DormitoryDaostu {

    @Select("select dorm_id from user where u_id=#{userId}")
    String getdormid(String userId);

    @Select("select max(change_id)+1 from changerecord")
    Integer getmaxid();
    @Insert("insert into changerecord values(#{dorm_id},#{u_id},#{repair_id},#{ u_sex},#{time_finish})")
    void insertall(RapairDto ddd);

    @Select("select student_num from dormitory where dorm_id=#{time_finish}")
    Integer getnum(String time_finish);

    @Select(("select count(u_id) from changerecord where u_id=#{u_id} and change_status=0"))
    Integer getid(String u_id);
}
