package com.example.dianzan.mapper;

import com.example.dianzan.dao.OrgRole;
import com.example.dianzan.dao.OrgRoleExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OrgRoleMapper {
    int deleteByPrimaryKey(Long orgRoleId);

    int insert(OrgRole record);

    int insertSelective(OrgRole record);

    List<OrgRole> selectByExample(OrgRoleExample example);

    OrgRole selectByPrimaryKey(Long orgRoleId);

    int updateByExampleSelective(@Param("record") OrgRole record, @Param("example") OrgRoleExample example);

    int updateByExample(@Param("record") OrgRole record, @Param("example") OrgRoleExample example);

    int updateByPrimaryKeySelective(OrgRole record);

    int updateByPrimaryKey(OrgRole record);
}
