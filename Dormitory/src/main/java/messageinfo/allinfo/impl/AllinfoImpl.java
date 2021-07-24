package com.xjtu.dormitory.messageinfo.allinfo.impl;

import com.xjtu.dormitory.common.Utils;
import com.xjtu.dormitory.messageinfo.allinfo.AllinfoService;
import com.xjtu.dormitory.messageinfo.allinfo.Allinfodto;
import com.xjtu.dormitory.messageinfo.allinfo.dao.AllinfoDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

@Service
@Transactional
public
class AllinfoImpl implements AllinfoService {

    @Resource
    private AllinfoDao allinfoDao;



    @Override
    public
    Map<String, Object> getAllInfoList ( Allinfodto dto ) {
        return Utils.getPage(dto,()->allinfoDao.findAllinfoList(dto));
    }
}
