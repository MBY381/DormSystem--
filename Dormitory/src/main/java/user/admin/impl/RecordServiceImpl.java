package com.xjtu.dormitory.user.admin.impl;

import com.xjtu.dormitory.common.Utils;
import com.xjtu.dormitory.user.admin.RecordService;
import com.xjtu.dormitory.user.admin.dao.RecrodDao;
import com.xjtu.dormitory.user.admin.reacordDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

@Service @Transactional
public class RecordServiceImpl implements RecordService {

    @Resource
    private RecrodDao recrodDao;

    @Override
    public Map<String, Object> getRecordList(reacordDto dto) {
        return Utils.getPage(dto,()-> recrodDao.findRecordList(dto));
    }
}
