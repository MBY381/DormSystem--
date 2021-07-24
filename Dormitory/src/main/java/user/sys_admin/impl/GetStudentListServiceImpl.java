package com.xjtu.dormitory.user.sys_admin.impl;

import com.xjtu.dormitory.common.Utils;
import com.xjtu.dormitory.user.sys_admin.GetStudentListService;
import com.xjtu.dormitory.user.sys_admin.StudentDto;
import com.xjtu.dormitory.user.sys_admin.dao.GetStudentListDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;


@Service @Transactional
public class GetStudentListServiceImpl implements GetStudentListService {

    @Resource
    private GetStudentListDao getStudentListDao;

    @Override
    public Map<String, Object> getStudentListInfo(StudentDto dto) {
        return Utils.getPage(dto,()-> getStudentListDao.findStudent(dto));
    }
}
