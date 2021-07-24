package com.xjtu.dormitory.user.deliever;

import java.util.Map;

public interface CustomerService {
    Map<String, Object> getCustomerList(CustomerDto dto);

   //void addCustomer(Integer id);

    void deleteCustomer(Integer id);

    //void updateCustomer();

    void addsCustomer(CustomerDto dto);

    void deleteCustomer();

    void allCustomer(CustomerDto dto);

    void updateall(Integer id);

    Integer selectCustomer(Integer id);
    Integer selectCustomer(String id);

    String finddorm(String u_id);
    Integer findmax_waterid();

    void insertCustomer(CustomerDto dto);
}
