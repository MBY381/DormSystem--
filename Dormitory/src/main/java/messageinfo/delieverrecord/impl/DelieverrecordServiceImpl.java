package com.xjtu.dormitory.messageinfo.delieverrecord.impl;

import com.xjtu.dormitory.common.CurrentUser;
import com.xjtu.dormitory.common.Utils;
import com.xjtu.dormitory.common.model.User.User;
import com.xjtu.dormitory.messageinfo.delieverrecord.Delieverrecord;
import com.xjtu.dormitory.messageinfo.delieverrecord.DelieverrecordDto;
import com.xjtu.dormitory.messageinfo.delieverrecord.DelieverrecordService;
import com.xjtu.dormitory.messageinfo.delieverrecord.dao.DelieverrecordDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.Resource;
import java.util.Map;

@Service
@Transactional
public
class DelieverrecordServiceImpl implements DelieverrecordService {

    @Resource
    private DelieverrecordDao delieverrecordDao;


    @Override
    public
    Map<String, Object> getDelieverrecordList ( CurrentUser currentUser ) {
        return Utils.getPage(currentUser,()->delieverrecordDao.findDelieverrecordList(currentUser));
    }
}




