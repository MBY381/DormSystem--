package com.xjtu.dormitory.user.sys_admin.impl;

import com.xjtu.dormitory.user.sys_admin.AddWorkerService;
import com.xjtu.dormitory.user.sys_admin.WorkerDto;
import com.xjtu.dormitory.user.sys_admin.dao.AddWorkerDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service @Transactional
public class AddWorkerServiceImpl implements AddWorkerService {

    @Resource
    private AddWorkerDao addWorkerDao;

    @Override
    public boolean addWorkerInfo(WorkerDto dto) {
        try {
            addWorkerDao.insertWorker(dto);
            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
