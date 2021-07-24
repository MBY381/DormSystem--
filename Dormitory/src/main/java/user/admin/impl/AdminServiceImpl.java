package com.xjtu.dormitory.user.admin.impl;

import com.xjtu.dormitory.common.Utils;
import com.xjtu.dormitory.user.admin.AdminDto;
import com.xjtu.dormitory.user.admin.AdminService;
import com.xjtu.dormitory.user.admin.dao.AdminDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

@Service @Transactional
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminDao adminDao;

    @Override
    public Map<String, Object> getRoleList(AdminDto dto) {
        return Utils.getPage(dto,()->adminDao.findRoleList(dto));
    }

    @Override
    public void deleteRole(String id) {

        adminDao.deleteRole(id);
    }
}
