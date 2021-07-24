package com.xjtu.dormitory.user.deliever.impl;

import com.xjtu.dormitory.common.Utils;
import com.xjtu.dormitory.user.deliever.CustomerDto;
import com.xjtu.dormitory.user.deliever.CustomerService;
import com.xjtu.dormitory.user.deliever.dao.CustomerDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

@Service @Transactional
public class
CustomerServicelmpl implements CustomerService {

    @Resource
    private CustomerDao customerDao;

    @Override
    public Map<String, Object> getCustomerList(CustomerDto dto) {
        return Utils.getPage(dto, ()-> customerDao.findCustomerList(dto));
    }

   // @Override
    //public void addCustomer(Integer id) {
    //    customerDao.addCustomer(id);
   // }

   // @Override
    public  void  addsCustomer(CustomerDto dto){
        customerDao.addsCustomer(dto);
    }

   @Override
    public void deleteCustomer(Integer id) {
        customerDao.deleteCustomer(id);
    }

    ///@Override
    //public void updateCustomer() {customerDao.updateCustomer();}

    @Override
    public void deleteCustomer(){customerDao.deleteCustomer1();}

 @Override
public  void allCustomer(CustomerDto dto){
    customerDao.allCustomer(dto);
 }
@Override
public  void updateall(Integer id) {
    customerDao.updateall(id);
}

@Override
public Integer selectCustomer(Integer id) {
   return customerDao.selectCustomer(id);
}

@Override
public String finddorm(String u_id){
        return customerDao.finddorm(u_id);
};
    @Override
     public Integer findmax_waterid(){
        return customerDao.findmaxwater();
    }

    @Override
   public void insertCustomer(CustomerDto dto) {
        customerDao.insertwater(dto);
    };

    @Override
    public  Integer selectCustomer(String id){
        return customerDao.selectCustomers(id);
    };
}

