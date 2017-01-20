package com.wdkj.xyfund.dao;

import com.wdkj.xyfund.controller.vo.DictionaryVo;
import com.wdkj.xyfund.entity.Dictionary;
import com.wdkj.xyfund.entity.DictionaryExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DictionaryMapper {
    int deleteByExample(DictionaryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Dictionary record);

    int insertSelective(Dictionary record);

    List<Dictionary> selectByExample(DictionaryExample example);

    Dictionary selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Dictionary record, @Param("example") DictionaryExample example);

    int updateByExample(@Param("record") Dictionary record, @Param("example") DictionaryExample example);

    int updateByPrimaryKeySelective(Dictionary record);

    int updateByPrimaryKey(Dictionary record);
    
    List<DictionaryVo> selectService(Integer id);
    List<DictionaryVo> selectSkill(Integer id);
}