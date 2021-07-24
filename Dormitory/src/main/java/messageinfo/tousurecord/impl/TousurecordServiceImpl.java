package com.xjtu.dormitory.messageinfo.tousurecord.impl;

import com.xjtu.dormitory.common.CurrentUser;
import com.xjtu.dormitory.common.Utils;
import com.xjtu.dormitory.messageinfo.tousurecord.TousurecordDto;
import com.xjtu.dormitory.messageinfo.tousurecord.TousurecordService;
import com.xjtu.dormitory.messageinfo.tousurecord.dao.TousurecordDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

@Service
@Transactional
public
class TousurecordServiceImpl implements TousurecordService {

    @Resource
    private TousurecordDao tousurecordDao;


    @Override
    public
    Map<String, Object> getTousurecordList ( CurrentUser currentUser ) {
        return Utils.getPage(currentUser,()->tousurecordDao.findTousurecordList(currentUser));
    }
}
