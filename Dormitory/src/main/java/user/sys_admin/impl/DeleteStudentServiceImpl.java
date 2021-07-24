package com.xjtu.dormitory.user.sys_admin.impl;

import com.xjtu.dormitory.user.sys_admin.DeleteStudentService;
import com.xjtu.dormitory.user.sys_admin.StudentDto;
import com.xjtu.dormitory.user.sys_admin.dao.DeleteStudentDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service @Transactional
public class DeleteStudentServiceImpl implements DeleteStudentService {

    @Resource
    private DeleteStudentDao deleteStudentDao;

    @Override
    public boolean deleteServiceInfo(StudentDto dto) {
        try {
            deleteStudentDao.deleteStudent(dto);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
