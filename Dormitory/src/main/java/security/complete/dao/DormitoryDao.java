package com.xjtu.dormitory.security.complete.dao;

import com.xjtu.dormitory.security.complete.Dormitory;
import com.xjtu.dormitory.security.complete.dormitoryDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DormitoryDao {
    @Select("select dorm_id,student_num from dormitory where dorm_sex = #{sex} and dorm_id like concat(#{louhao1},'%') and student_num < 4")
    List<Dormitory> findDormitoryList(dormitoryDto dto);
}
