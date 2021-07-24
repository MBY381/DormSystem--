package com.xjtu.dormitory.user.repairer;

import java.util.Map;

public interface RapairService {
    Map<String, Object> getCustomerList(RapairDto dto);

   //void addCustomer(Integer id);

    void deleteCustomer(Integer id);

    //void updateCustomer();

    void addsCustomer(RapairDto dto);

    void deleteCustomer();

    void allCustomer(RapairDto dto);

    void updateall(Integer id);

    Integer selectCustomer(Integer id);
    Integer selectCustomer(String id);

    String finddorm(String u_id);
    Integer findmax_waterid();

    void insertCustomer(RapairDto dto);
}
