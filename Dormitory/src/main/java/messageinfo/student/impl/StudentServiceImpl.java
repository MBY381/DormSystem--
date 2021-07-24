package com.xjtu.dormitory.messageinfo.student.impl;

import com.xjtu.dormitory.common.CurrentUser;
import com.xjtu.dormitory.common.Utils;
import com.xjtu.dormitory.messageinfo.student.StudentService;
import com.xjtu.dormitory.messageinfo.student.dao.StudentDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Override
    public
    Map<String, Object> getStudentList ( CurrentUser currentUser ) {
        return Utils.getPage(currentUser,()->studentDao.findStudentList(currentUser));


    }
    @Resource
    private StudentDao studentDao;
}
