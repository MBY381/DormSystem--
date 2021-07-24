package com.xjtu.dormitory.messageinfo.changerecord.impl;

import com.xjtu.dormitory.common.CurrentUser;
import com.xjtu.dormitory.common.Utils;
import com.xjtu.dormitory.messageinfo.changerecord.ChangerecordService;
import com.xjtu.dormitory.messageinfo.changerecord.dao.ChangerecordDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

@Service
@Transactional
public
class ChangerecordServiceImpl implements ChangerecordService {
    @Override
    public
    Map<String, Object> getChangerecordList ( CurrentUser currentUser ) {
        return Utils.getPage(currentUser,()->changerecordDao.findChangerecordList(currentUser));


    }
    @Resource
    private ChangerecordDao changerecordDao;
}
