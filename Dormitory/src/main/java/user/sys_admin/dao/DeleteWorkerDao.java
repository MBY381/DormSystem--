package com.xjtu.dormitory.user.sys_admin.dao;

import com.xjtu.dormitory.user.sys_admin.WorkerDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeleteWorkerDao {
    @Delete("delete from worker where w_id=#{w_id}")
    void deleteWorker(WorkerDto dto);
}
