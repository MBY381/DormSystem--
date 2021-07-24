package com.xjtu.dormitory.messageinfo.allinfo.dao;

import com.xjtu.dormitory.messageinfo.allinfo.Allinfo;
import com.xjtu.dormitory.messageinfo.allinfo.Allinfodto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AllinfoDao {
    List<Allinfo> findAllinfoList ( Allinfodto dto );
}
