package com.wdkj.xyfund.dao;

import com.wdkj.xyfund.controller.vo.FileVo;
import com.wdkj.xyfund.entity.File;
import com.wdkj.xyfund.entity.FileExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FileMapper {
    int deleteByExample(FileExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(File record);

    int insertSelective(File record);

    List<File> selectByExample(FileExample example);

    File selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") File record, @Param("example") FileExample example);

    int updateByExample(@Param("record") File record, @Param("example") FileExample example);

    int updateByPrimaryKeySelective(File record);

    int updateByPrimaryKey(File record);
    
    List<File> selectFileUrlFromPostulantByPrimaryKey(Integer id);
    
    List<File> selectFileUrlFromHelpByPrimaryKey(Integer id);
    
    List<File> selectFileUrlFromLinkByPrimaryKey(Integer id);
    
    List<File> selectFileUrlFromHelpApp(Integer id);
    
    /*List<File> selectFileUrlFromHelpApplyByTypeKey(Integer id);*/
}