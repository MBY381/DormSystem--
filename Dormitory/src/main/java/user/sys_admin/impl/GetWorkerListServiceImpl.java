package com.xjtu.dormitory.user.sys_admin.impl;

import com.xjtu.dormitory.common.Utils;
import com.xjtu.dormitory.user.sys_admin.GetWorkerListService;
import com.xjtu.dormitory.user.sys_admin.WorkerDto;
import com.xjtu.dormitory.user.sys_admin.dao.GetWorkerListDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

@Service @Transactional
public class GetWorkerListServiceImpl implements GetWorkerListService {

    @Resource
    private GetWorkerListDao getWorkerListDao;

    @Override
    public Map<String, Object> getWorkerListInfo(WorkerDto dto) {
        return Utils.getPage(dto,()-> getWorkerListDao.findWorker(dto));
    }
}
