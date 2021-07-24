package com.xjtu.dormitory.security.getDomInfo.impl;

import com.xjtu.dormitory.common.Utils;
import com.xjtu.dormitory.security.getDomInfo.GetInfoService;
import com.xjtu.dormitory.security.getDomInfo.InfoDto;
import com.xjtu.dormitory.security.getDomInfo.dao.GetInfoDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;



@Service @Transactional
public class GetInfoServiceImpl implements GetInfoService {

    @Resource
    private GetInfoDao dao;

    @Override
    public Map<String, Object> getInfoList(InfoDto dto) {
        return Utils.getPage(dto,()-> dao.findInfoList(dto));

    }
}
