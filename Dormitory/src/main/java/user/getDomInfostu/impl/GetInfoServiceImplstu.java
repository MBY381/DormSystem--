package com.xjtu.dormitory.user.getDomInfostu.impl;

import com.xjtu.dormitory.common.Utils;
import com.xjtu.dormitory.user.getDomInfostu.GetInfoServicestu;
import com.xjtu.dormitory.user.getDomInfostu.dao.GetInfoDaostu;
import com.xjtu.dormitory.user.repairer.RapairDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;



@Service @Transactional
public class GetInfoServiceImplstu implements GetInfoServicestu {

    @Resource
    private GetInfoDaostu dao;

    @Override
    public Map<String, Object> getInfoList(RapairDto ddd) {
        return Utils.getPage(ddd,() -> dao.findInfoList(ddd));
    }
        @Override
      public  String getdormid(String dormid){
            return  dao.finddormid(dormid);
        };
        @Override
    public String getusex(String userId){
            return  dao.findusex(userId);
        };
    }
