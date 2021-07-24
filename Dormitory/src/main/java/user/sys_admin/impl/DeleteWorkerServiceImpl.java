package com.xjtu.dormitory.user.sys_admin.impl;

import com.xjtu.dormitory.user.sys_admin.DeleteWorkerService;
import com.xjtu.dormitory.user.sys_admin.WorkerDto;
import com.xjtu.dormitory.user.sys_admin.dao.DeleteWorkerDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service @Transactional
public class DeleteWorkerServiceImpl implements DeleteWorkerService {

    @Resource
    private DeleteWorkerDao deleteWorkerDao;


    @Override
    public boolean deleteWorkerInfo(WorkerDto dto) {
        try {
            deleteWorkerDao.deleteWorker(dto);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
