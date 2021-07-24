package com.xjtu.dormitory.user.student.dao;

import com.xjtu.dormitory.user.repairer.RapairDto;
import com.xjtu.dormitory.user.student.TousuDtt;
import com.xjtu.dormitory.user.student.stud;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface TousuDao {
    @Select("select * from tousubiao")
    List<stud> gettousu(TousuDtt dtt);

    @Select("select max(tousu_id)+1 from tousubiao")
    Integer findmaxtousu();

    @Insert("insert into tousubiao (tousu_id,tousu,u_id,status) values(#{tousu_id},#{tousu},#{u_id},0)")
    void inserttousu(TousuDtt dd);
     @Update("update tousubiao set status=1 where tousu_id=#{id}")
    void change(Integer id);
}
