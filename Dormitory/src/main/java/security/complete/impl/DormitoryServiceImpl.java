package com.xjtu.dormitory.security.complete.impl;

import com.xjtu.dormitory.common.Utils;
import com.xjtu.dormitory.security.complete.DormitoryService;
import com.xjtu.dormitory.security.complete.dao.DormitoryDao;
import com.xjtu.dormitory.security.complete.dormitoryDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

@Service @Transactional
public class DormitoryServiceImpl implements DormitoryService {

    @Resource
    private DormitoryDao dormitoryDao;

    @Override
    public Map<String, Object> getDormitoryList(dormitoryDto dto) {
        return Utils.getPage(dto,()-> dormitoryDao.findDormitoryList(dto));
    }
}
