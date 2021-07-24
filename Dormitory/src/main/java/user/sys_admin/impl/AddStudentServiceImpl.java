package com.xjtu.dormitory.user.sys_admin.impl;

import com.xjtu.dormitory.user.sys_admin.AddStudentService;
import com.xjtu.dormitory.user.sys_admin.Student;
import com.xjtu.dormitory.user.sys_admin.dao.AddStudentDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service @Transactional
public class AddStudentServiceImpl implements AddStudentService {

    @Resource
    private AddStudentDao addStudentDao;

    @Override
    public boolean addStudentInfo(Student dto) {
        try {
            addStudentDao.insertStudent(dto);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
