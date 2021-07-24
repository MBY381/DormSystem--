package com.xjtu.dormitory.security.loginByNetid.impl;

import com.xjtu.dormitory.security.loginByNetid.LoginByNetidDto;
import com.xjtu.dormitory.security.loginByNetid.LoginService;
import com.xjtu.dormitory.security.loginByNetid.dao.LoginByNetidDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service
@Transactional
public class LoginByNetidServiceImpl implements LoginService {

    @Resource
    private LoginByNetidDao loginByNetidDao;

    @Override
    public boolean CheckLoginByNetID(LoginByNetidDto dto) {
        int count = loginByNetidDao.checkNetId(dto);
        return count>0;
    }

    @Override
    public String findRoleWeb(LoginByNetidDto dto) {
        String role_web = loginByNetidDao.findRoleWeb(dto);
        return role_web;
    }

    @Override
    public String getUserId(LoginByNetidDto dto) {
        String userId = loginByNetidDao.getUserId(dto);
        return userId;
    }

}
