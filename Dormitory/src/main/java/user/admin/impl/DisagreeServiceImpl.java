package com.xjtu.dormitory.user.admin.impl;

import com.xjtu.dormitory.user.admin.DisagreeSerivce;
import com.xjtu.dormitory.user.admin.dao.DisagreeDao;
import com.xjtu.dormitory.user.admin.reacordDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service @Transactional
public class DisagreeServiceImpl implements DisagreeSerivce {

    @Resource
    private DisagreeDao disagreeDao;

    @Override
    public boolean deleteRecord(reacordDto dto) {
        try {
            disagreeDao.deleteRecord(dto);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
