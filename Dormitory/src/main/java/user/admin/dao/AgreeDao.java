package com.xjtu.dormitory.user.admin.dao;

import com.xjtu.dormitory.user.admin.reacordDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AgreeDao {
    @Update("update dormitory set student_num=student_num-1 where dorm_id=#{dorm_id}")
    void deleteNum(reacordDto dto);

    @Update("update dormitory set student_num=student_num+1 where dorm_id=#{newdorm_id} ")
    void plusNum(reacordDto dto);

    @Update("update user set dorm_id=#{newdorm_id} where u_id=#{u_id}")
    void changeDrom(reacordDto dto);

    @Update("update changerecord set change_status='1' where u_id=#{u_id}")
    void changeStatus(reacordDto dto);
}
