package com.xjtu.dormitory.user.sys_admin.dao;

import com.xjtu.dormitory.user.sys_admin.WorkerDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddWorkerDao {
    @Insert("insert into worker values (#{w_id},#{w_name})")
    void insertWorker(WorkerDto dto);
}
