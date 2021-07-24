package com.xjtu.dormitory.user.admin.dao;

import com.xjtu.dormitory.user.admin.reacordDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DisagreeDao {

    @Delete("delete from changerecord where u_id=#{u_id}")
    void deleteRecord(reacordDto dto);
}
