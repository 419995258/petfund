package com.wdkj.xyfund.dao;

import com.wdkj.xyfund.entity.Abount;
import com.wdkj.xyfund.entity.AbountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AbountMapper {
    int deleteByExample(AbountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Abount record);

    int insertSelective(Abount record);

    List<Abount> selectByExampleWithBLOBs(AbountExample example);

    List<Abount> selectByExample(AbountExample example);

    Abount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Abount record, @Param("example") AbountExample example);

    int updateByExampleWithBLOBs(@Param("record") Abount record, @Param("example") AbountExample example);

    int updateByExample(@Param("record") Abount record, @Param("example") AbountExample example);

    int updateByPrimaryKeySelective(Abount record);

    int updateByPrimaryKeyWithBLOBs(Abount record);
}