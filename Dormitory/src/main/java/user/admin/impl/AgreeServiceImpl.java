package com.xjtu.dormitory.user.admin.impl;

import com.xjtu.dormitory.user.admin.AgreeService;
import com.xjtu.dormitory.user.admin.dao.AgreeDao;
import com.xjtu.dormitory.user.admin.reacordDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service @Transactional
public class AgreeServiceImpl implements AgreeService {

    @Resource
    private AgreeDao agreeDao;

    @Override
    public boolean deleteNum(reacordDto dto) {
        try {
            agreeDao.deleteNum(dto);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean plusNum(reacordDto dto) {
        try {
            agreeDao.plusNum(dto);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean changeDorm(reacordDto dto) {
        try {
            agreeDao.changeDrom(dto);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean changeStatus(reacordDto dto) {
        try {
            agreeDao.changeStatus(dto);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
