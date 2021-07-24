package com.xjtu.dormitory.user.admin.dao;

import com.xjtu.dormitory.user.admin.RecordList;
import com.xjtu.dormitory.user.admin.reacordDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RecrodDao {

    @Select("select changerecord.u_id,u_name,changerecord.dorm_id,newdorm_id from user,changerecord where user.u_id=changerecord.u_id and changerecord.change_status='0'")
    List<RecordList> findRecordList(reacordDto dto);
}
