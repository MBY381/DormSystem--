package com.xjtu.dormitory.user.adminStu.impl;

import com.xjtu.dormitory.common.Utils;
import com.xjtu.dormitory.user.adminStu.AdminStuService;
import com.xjtu.dormitory.user.adminStu.UsersDto;
import com.xjtu.dormitory.user.adminStu.dao.AdminStuDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;


@Service
@Transactional
public class AdminStuServiceImpl implements AdminStuService {


    @Resource
    private AdminStuDao adminStuDao;

    @Override
    public Map<String, Object> getUserList(UsersDto dto) {
        return Utils.getPage(dto,()->adminStuDao.findUserList(dto));
    }

    @Override
    public void updStudent(UsersDto dto) {
        adminStuDao.updStudent(dto);
        System.out.println("_________________");
    }


}
