package com.xjtu.dormitory.user.student.impl;

import com.xjtu.dormitory.common.Utils;
import com.xjtu.dormitory.user.repairer.RapairDto;
import com.xjtu.dormitory.user.student.dao.TousuDao;
import com.xjtu.dormitory.user.student.TousuDtt;
import com.xjtu.dormitory.user.student.TousuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

@Service
 @Transactional
public class TousuServicelmpl implements TousuService {
    @Resource TousuDao tousuDao;
    @Override
    public Integer  findmax_tousuid() {
        return tousuDao.findmaxtousu();
    }
    @Override
    public void insertCustomer(TousuDtt dd){
        tousuDao.inserttousu(dd);
    }
    @Override
    public Map<String, Object>gettousu (TousuDtt dtt) {
        return Utils.getPage(dtt, ()-> tousuDao.gettousu(dtt));}
        @Override
                public  void change(Integer id){
            tousuDao.change(id);
        };

}