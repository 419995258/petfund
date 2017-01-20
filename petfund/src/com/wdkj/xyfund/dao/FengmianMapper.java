package com.wdkj.xyfund.dao;

import com.wdkj.xyfund.entity.Fengmian;
import com.wdkj.xyfund.entity.FengmianExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FengmianMapper {
    int deleteByExample(FengmianExample example);

    int insert(Fengmian record);

    int insertSelective(Fengmian record);

    List<Fengmian> selectByExample(FengmianExample example);

    int updateByExampleSelective(@Param("record") Fengmian record, @Param("example") FengmianExample example);

    int updateByExample(@Param("record") Fengmian record, @Param("example") FengmianExample example);
    
    int updateFengmian(Fengmian record);
}