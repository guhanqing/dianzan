package com.example.dianzan.mapper;

import com.example.dianzan.dao.SysOrg;
import com.example.dianzan.dao.SysOrgExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysOrgMapper {
    int deleteByPrimaryKey(Long sysOrgId);

    int insert(SysOrg record);

    int insertSelective(SysOrg record);

    List<SysOrg> selectByExample(SysOrgExample example);

    SysOrg selectByPrimaryKey(Long sysOrgId);

    int updateByExampleSelective(@Param("record") SysOrg record, @Param("example") SysOrgExample example);

    int updateByExample(@Param("record") SysOrg record, @Param("example") SysOrgExample example);

    int updateByPrimaryKeySelective(SysOrg record);

    int updateByPrimaryKey(SysOrg record);
}
