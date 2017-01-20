package com.wdkj.xyfund.dao;

import com.wdkj.xyfund.entity.Fangwen;
import com.wdkj.xyfund.entity.FangwenExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface FangwenMapper {
    int deleteByExample(FangwenExample example);

    int insert(Fangwen record);

    int insertSelective(Fangwen record);

    List<Fangwen> selectByExample(FangwenExample example);

    int updateByExampleSelective(@Param("record") Fangwen record, @Param("example") FangwenExample example);

    int updateByExample(@Param("record") Fangwen record, @Param("example") FangwenExample example);
    
    String selectTime();
    
    int updateTime(Fangwen record);
}