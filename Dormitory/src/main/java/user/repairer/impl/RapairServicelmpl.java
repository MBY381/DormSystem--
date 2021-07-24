package com.xjtu.dormitory.user.repairer.impl;

import com.xjtu.dormitory.common.Utils;
import com.xjtu.dormitory.user.repairer.RapairDto;
import com.xjtu.dormitory.user.repairer.RapairService;
import com.xjtu.dormitory.user.repairer.dao.RapairDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

@Service
@Transactional
public class RapairServicelmpl implements RapairService {

    @Resource
    private RapairDao rapairDao;

    @Override
    public Map<String, Object> getCustomerList(RapairDto dto) {
        return Utils.getPage(dto, ()-> rapairDao.findCustomerList(dto));
    }

   // @Override
    //public void addCustomer(Integer id) {
    //    customerDao.addCustomer(id);
   // }

   // @Override
    public  void  addsCustomer(RapairDto dto){
        rapairDao.addsCustomer(dto);
    }

   @Override
    public void deleteCustomer(Integer id) {
        rapairDao.deleteCustomer(id);
    }

    ///@Override
    //public void updateCustomer() {customerDao.updateCustomer();}

    @Override
    public void deleteCustomer(){rapairDao.deleteCustomer1();}

 @Override
public  void allCustomer(RapairDto dto){
    rapairDao.allCustomer(dto);
 }
@Override
public  void updateall(Integer id) {
    rapairDao.updateall(id);
}

@Override
public Integer selectCustomer(Integer id) {
   return rapairDao.selectCustomer(id);
}

@Override
public String finddorm(String u_id){
        return rapairDao.finddorm(u_id);
};
    @Override
     public Integer findmax_waterid(){
        return rapairDao.findmaxwater();
    }

    @Override
   public void insertCustomer(RapairDto dto) {
        rapairDao.insertwater(dto);
    };

    @Override
    public  Integer selectCustomer(String id){
        return rapairDao.selectCustomers(id);
    };
}

