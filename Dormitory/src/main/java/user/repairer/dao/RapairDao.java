package com.xjtu.dormitory.user.repairer.dao;

import com.xjtu.dormitory.user.repairer.rapair;
import com.xjtu.dormitory.user.repairer.RapairDto;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface RapairDao {
    @Select("select * from repair")
    List<rapair> findCustomerList(RapairDto dto);

    //@Insert("insert into water_deliever(cus_id,cus_name,cus_remark) values(#{cus_id},#{cus_name},#{cus_remark})")
    //void insertCustomer(Integer id);

    @Update("update repair set repair_status=1,time_actual=#{time_actual},repairer_id=#{repairer_id} where repair_status=0")
    void allCustomer(RapairDto dto);

    @Delete("delete from repair where repair_id=#{id} and repair_status=1")
    void deleteCustomer(Integer id);
    @Select("select count(repair_id) from repair where repair_id=#{id} and repair_status=1")
    Integer selectCustomer(Integer id);

    @Select("select count(dorm_id) from repair where dorm_id=#{id} and repair_status=0")
     Integer selectCustomers(String id);
   // @Update("update water_deliever set deliever_status=1 where water_id=#{id}")
   // void addCustomer(Integer id);

    @Update("update repair set repairer_id=#{repairer_id},time_actual=#{time_actual},repair_status=1 where repair_id=#{repair_id}")
    void addsCustomer(RapairDto dto);

    @Delete("delete from repair where repair_status=1")
    void deleteCustomer1();

    @Update("update repair set repair_id=repair_id-1 where repair_id>#{id}")
    void updateall(Integer id);

    @Select("select dorm_id from user where u_id=#{u_id}")
    String finddorm(String u_id);
    @Select("select max(repair_id)+1 from repair")
    Integer findmaxwater();

    @Insert("insert into repair (u_id,dorm_id,repair_status,time_begin,time_finish,repair_id) values (#{u_id},#{dorm_id},0,#{time_begin},#{time_finish},#{repair_id})")
    void insertwater(RapairDto dto);
}
