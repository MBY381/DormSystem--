package com.xjtu.dormitory.user.completestu.impl;

import com.xjtu.dormitory.user.completestu.DormitoryServicestu;
import com.xjtu.dormitory.user.completestu.dao.DormitoryDaostu;
import com.xjtu.dormitory.user.repairer.RapairDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service @Transactional
public class DormitoryServiceImplstu implements DormitoryServicestu {

    @Resource
    private DormitoryDaostu dormitoryDaostu;

    @Override
   public  String getdormid(String userId){
        return  dormitoryDaostu.getdormid(userId);
    };
    @Override
     public Integer getmaxid(){
        return  dormitoryDaostu.getmaxid();
    };
    @Override
   public void insertall(RapairDto ddd){
        try {
            dormitoryDaostu.insertall(ddd);
        }catch (Exception e){
            e.printStackTrace();
        }
    };
    @Override
    public Integer getnum(String time_finish){
         return  dormitoryDaostu.getnum(time_finish);
    };
    @Override
    public  Integer getid(String u_id){
        return  dormitoryDaostu.getid(u_id);
    };
}
