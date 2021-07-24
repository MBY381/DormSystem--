package com.xjtu.dormitory.security.completeInfo.impl;

import com.xjtu.dormitory.security.completeInfo.CompleteInfoService;
import com.xjtu.dormitory.security.completeInfo.UserDto;
import com.xjtu.dormitory.security.completeInfo.dao.CompleteInfoDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service @Transactional
public class CompleteInfoServiceImpl implements CompleteInfoService {

    @Resource
    private CompleteInfoDao completeInfoDao;

    @Override
    public boolean updateUserInfo(UserDto dto, String u_id) {
        try {
            completeInfoDao.updateUser(dto,u_id);

            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Integer getRecordId() {
        Integer id = completeInfoDao.getNewId();
        return id;
    }

    @Override
    public boolean offerChangeDorm(UserDto dto, String u_id, Integer recordId) {
        try {
            completeInfoDao.updateChangeRecord(dto,u_id,recordId);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }


    }
}
