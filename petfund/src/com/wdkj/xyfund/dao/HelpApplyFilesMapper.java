package com.wdkj.xyfund.dao;

import com.wdkj.xyfund.entity.HelpApplyFiles;
import com.wdkj.xyfund.entity.HelpApplyFilesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HelpApplyFilesMapper {
    int deleteByExample(HelpApplyFilesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HelpApplyFiles record);

    int insertSelective(HelpApplyFiles record);

    List<HelpApplyFiles> selectByExample(HelpApplyFilesExample example);

    HelpApplyFiles selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HelpApplyFiles record, @Param("example") HelpApplyFilesExample example);

    int updateByExample(@Param("record") HelpApplyFiles record, @Param("example") HelpApplyFilesExample example);

    int updateByPrimaryKeySelective(HelpApplyFiles record);

    int updateByPrimaryKey(HelpApplyFiles record);
}