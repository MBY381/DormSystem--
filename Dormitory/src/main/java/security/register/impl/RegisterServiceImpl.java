package com.xjtu.dormitory.security.register.impl;

import com.xjtu.dormitory.security.register.RegisterDto;
import com.xjtu.dormitory.security.register.RegisterService;
import com.xjtu.dormitory.security.register.dao.RegisterDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service @Transactional
public class RegisterServiceImpl implements RegisterService {

    @Resource
    private RegisterDao registerDao;

    @Override
    public boolean findWorkerId(RegisterDto dto) {
        int count = registerDao.findWorker(dto);
        return count>0;
    }

    @Override
    public boolean insertUser(RegisterDto dto) {
        try {
            registerDao.insertUser(dto);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
