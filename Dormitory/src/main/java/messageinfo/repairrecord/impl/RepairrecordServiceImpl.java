package com.xjtu.dormitory.messageinfo.repairrecord.impl;

import com.xjtu.dormitory.common.CurrentUser;
import com.xjtu.dormitory.common.Utils;
import com.xjtu.dormitory.messageinfo.repairrecord.RepairrecordDto;
import com.xjtu.dormitory.messageinfo.repairrecord.RepairrecordService;
import com.xjtu.dormitory.messageinfo.repairrecord.dao.RepairrecordDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

@Service
@Transactional
public
class RepairrecordServiceImpl implements RepairrecordService {

    @Resource
    private RepairrecordDao repairrecordDao;


    @Override
    public
    Map<String, Object> getRepairrecordList (CurrentUser currentUser) {
        return Utils.getPage(currentUser,()->repairrecordDao.findRepairrecordList(currentUser));
    }
}
