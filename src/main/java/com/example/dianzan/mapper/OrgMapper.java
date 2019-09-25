package com.example.dianzan.mapper;

import com.example.dianzan.dao.Org;
import com.example.dianzan.dao.OrgExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OrgMapper {
    int deleteByPrimaryKey(Long orgId);

    int insert(Org record);

    int insertSelective(Org record);

    List<Org> selectByExample(OrgExample example);

    Org selectByPrimaryKey(Long orgId);

    int updateByExampleSelective(@Param("record") Org record, @Param("example") OrgExample example);

    int updateByExample(@Param("record") Org record, @Param("example") OrgExample example);

    int updateByPrimaryKeySelective(Org record);

    int updateByPrimaryKey(Org record);
}
