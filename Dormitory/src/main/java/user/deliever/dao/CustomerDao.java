package com.xjtu.dormitory.user.deliever.dao;

import com.xjtu.dormitory.user.deliever.Customer;
import com.xjtu.dormitory.user.deliever.CustomerDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CustomerDao {
    @Select("select * from water_deliever")
    List<Customer> findCustomerList(CustomerDto dto);

    //@Insert("insert into water_deliever(cus_id,cus_name,cus_remark) values(#{cus_id},#{cus_name},#{cus_remark})")
    //void insertCustomer(Integer id);

    @Update("update water_deliever set deliever_status=1,time_actual=#{time_actual},deliever_id=#{deliver_id} where deliever_status=0")
    void allCustomer(CustomerDto dto);

    @Delete("delete from water_deliever where water_id=#{id} and deliever_status=1")
    void deleteCustomer(Integer id);
    @Select("select count(water_id) from water_deliever where water_id=#{id} and deliever_status=1")
    Integer selectCustomer(Integer id);

    @Select("select count(dorm_id) from water_deliever where dorm_id=#{id} and deliever_status=0")
     Integer selectCustomers(String id);
   // @Update("update water_deliever set deliever_status=1 where water_id=#{id}")
   // void addCustomer(Integer id);

    @Update("update water_deliever set deliever_id=#{deliver_id},time_actual=#{time_actual},deliever_status=1 where water_id=#{water_id}")
    void addsCustomer(CustomerDto dto);

    @Delete("delete from water_deliever where deliever_status=1")
    void deleteCustomer1();

    @Update("update water_deliever set water_id=water_id-1 where water_id>#{id}")
    void updateall(Integer id);

    @Select("select dorm_id from user where u_id=#{u_id}")
    String finddorm(String u_id);
    @Select("select max(water_id)+1 from water_deliever")
    Integer findmaxwater();

    @Insert("insert into water_deliever (u_id,dorm_id,deliever_status,time_begin,time_finish,water_id) values (#{u_id},#{dorm_id},0,#{time_begin},#{time_finish},#{water_id})")
    void insertwater(CustomerDto dto);
}
