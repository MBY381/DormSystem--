package com.xjtu.dormitory.user.student;

import java.util.Map;

public interface TousuService {
      void insertCustomer(TousuDtt dd);

     Integer findmax_tousuid() ;

    Map<String, Object> gettousu(TousuDtt dtt);

    void change(Integer id);
}
