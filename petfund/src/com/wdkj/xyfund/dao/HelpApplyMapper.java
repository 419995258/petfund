package com.wdkj.xyfund.dao;

import com.wdkj.xyfund.entity.HelpApply;
import com.wdkj.xyfund.entity.HelpApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HelpApplyMapper {
    int deleteByExample(HelpApplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HelpApply record);

    int insertSelective(HelpApply record);

    List<HelpApply> selectByExampleWithBLOBs(HelpApplyExample example);

    List<HelpApply> selectByExample(HelpApplyExample example);

    HelpApply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HelpApply record, @Param("example") HelpApplyExample example);

    int updateByExampleWithBLOBs(@Param("record") HelpApply record, @Param("example") HelpApplyExample example);

    int updateByExample(@Param("record") HelpApply record, @Param("example") HelpApplyExample example);

    int updateByPrimaryKeySelective(HelpApply record);

    int updateByPrimaryKeyWithBLOBs(HelpApply record);

    int updateByPrimaryKey(HelpApply record);
}