package com.wdkj.xyfund.dao;

import com.wdkj.xyfund.entity.PostulantFiles;
import com.wdkj.xyfund.entity.PostulantFilesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PostulantFilesMapper {
    int deleteByExample(PostulantFilesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PostulantFiles record);

    int insertSelective(PostulantFiles record);

    List<PostulantFiles> selectByExample(PostulantFilesExample example);

    PostulantFiles selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PostulantFiles record, @Param("example") PostulantFilesExample example);

    int updateByExample(@Param("record") PostulantFiles record, @Param("example") PostulantFilesExample example);

    int updateByPrimaryKeySelective(PostulantFiles record);

    int updateByPrimaryKey(PostulantFiles record);
    
    void addTrainRecordBatch(List l);
}