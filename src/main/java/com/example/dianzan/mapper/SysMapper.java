package com.example.dianzan.mapper;

import com.example.dianzan.dao.Sys;
import com.example.dianzan.dao.SysExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysMapper {
    int deleteByPrimaryKey(Long sysId);

    int insert(Sys record);

    int insertSelective(Sys record);

    List<Sys> selectByExample(SysExample example);

    Sys selectByPrimaryKey(Long sysId);

    int updateByExampleSelective(@Param("record") Sys record, @Param("example") SysExample example);

    int updateByExample(@Param("record") Sys record, @Param("example") SysExample example);

    int updateByPrimaryKeySelective(Sys record);

    int updateByPrimaryKey(Sys record);
}
