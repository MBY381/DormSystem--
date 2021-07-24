package com.xjtu.dormitory.messageinfo.studentinfo.impl;


import com.xjtu.dormitory.common.CurrentUser;
import com.xjtu.dormitory.common.Utils;
import com.xjtu.dormitory.messageinfo.studentinfo.StudentinfoService;
import com.xjtu.dormitory.messageinfo.studentinfo.dao.StudentinfoDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

@Service
@Transactional
public class StudentinfoServiceImpl implements StudentinfoService {

    @Resource
    private StudentinfoDao studentinfoDao;




    @Override
    public
    Map<String, Object> getStudentinfoList ( CurrentUser currentUser ) {
        return Utils.getPage(currentUser,()->studentinfoDao.findStudentinfoList(currentUser));
    }
}
