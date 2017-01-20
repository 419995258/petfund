package com.wdkj.xyfund.dao;

import com.wdkj.xyfund.entity.Publictiy;
import com.wdkj.xyfund.entity.PublictiyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PublictiyMapper {
    int deleteByExample(PublictiyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Publictiy record);

    int insertSelective(Publictiy record);

    List<Publictiy> selectByExampleWithBLOBs(PublictiyExample example);

    List<Publictiy> selectByExample(PublictiyExample example);

    Publictiy selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Publictiy record, @Param("example") PublictiyExample example);

    int updateByExampleWithBLOBs(@Param("record") Publictiy record, @Param("example") PublictiyExample example);

    int updateByExample(@Param("record") Publictiy record, @Param("example") PublictiyExample example);

    int updateByPrimaryKeySelective(Publictiy record);

    int updateByPrimaryKeyWithBLOBs(Publictiy record);

    int updateByPrimaryKey(Publictiy record);
}