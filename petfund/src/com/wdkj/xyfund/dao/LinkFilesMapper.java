package com.wdkj.xyfund.dao;

import com.wdkj.xyfund.entity.LinkFiles;
import com.wdkj.xyfund.entity.LinkFilesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LinkFilesMapper {
    int deleteByExample(LinkFilesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LinkFiles record);

    int insertSelective(LinkFiles record);

    List<LinkFiles> selectByExample(LinkFilesExample example);

    LinkFiles selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LinkFiles record, @Param("example") LinkFilesExample example);

    int updateByExample(@Param("record") LinkFiles record, @Param("example") LinkFilesExample example);

    int updateByPrimaryKeySelective(LinkFiles record);

    int updateByPrimaryKey(LinkFiles record);
}