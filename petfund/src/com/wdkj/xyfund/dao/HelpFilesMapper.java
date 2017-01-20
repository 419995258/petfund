package com.wdkj.xyfund.dao;

import com.wdkj.xyfund.entity.HelpFiles;
import com.wdkj.xyfund.entity.HelpFilesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HelpFilesMapper {
    int deleteByExample(HelpFilesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HelpFiles record);

    int insertSelective(HelpFiles record);

    List<HelpFiles> selectByExample(HelpFilesExample example);

    HelpFiles selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HelpFiles record, @Param("example") HelpFilesExample example);

    int updateByExample(@Param("record") HelpFiles record, @Param("example") HelpFilesExample example);

    int updateByPrimaryKeySelective(HelpFiles record);

    int updateByPrimaryKey(HelpFiles record);
}