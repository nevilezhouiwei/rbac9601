package com.nevile.base.dao;

import com.nevile.base.pojo.resource;
import com.nevile.base.pojo.resourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface resourceMapper {
    long countByExample(resourceExample example);

    int deleteByExample(resourceExample example);

    int deleteByPrimaryKey(String resourceId);

    int insert(resource record);

    int insertSelective(resource record);

    List<resource> selectByExample(resourceExample example);

    resource selectByPrimaryKey(String resourceId);

    int updateByExampleSelective(@Param("record") resource record, @Param("example") resourceExample example);

    int updateByExample(@Param("record") resource record, @Param("example") resourceExample example);

    int updateByPrimaryKeySelective(resource record);

    int updateByPrimaryKey(resource record);
}