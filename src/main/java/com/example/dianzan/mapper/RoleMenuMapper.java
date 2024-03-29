package com.example.dianzan.mapper;

import com.example.dianzan.dao.RoleMenu;
import com.example.dianzan.dao.RoleMenuExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RoleMenuMapper {
    int deleteByPrimaryKey(Long roleMenuId);

    int insert(RoleMenu record);

    int insertSelective(RoleMenu record);

    List<RoleMenu> selectByExample(RoleMenuExample example);

    RoleMenu selectByPrimaryKey(Long roleMenuId);

    int updateByExampleSelective(@Param("record") RoleMenu record, @Param("example") RoleMenuExample example);

    int updateByExample(@Param("record") RoleMenu record, @Param("example") RoleMenuExample example);

    int updateByPrimaryKeySelective(RoleMenu record);

    int updateByPrimaryKey(RoleMenu record);
}
