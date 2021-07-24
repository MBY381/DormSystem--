package com.xjtu.dormitory.user.sys_admin.dao;

import com.xjtu.dormitory.user.sys_admin.Worker;
import com.xjtu.dormitory.user.sys_admin.WorkerDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GetWorkerListDao {

    @Select("select * from worker")
    List<Worker> findWorker(WorkerDto dto);
}
