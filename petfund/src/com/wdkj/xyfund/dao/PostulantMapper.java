package com.wdkj.xyfund.dao;

import com.wdkj.xyfund.controller.vo.PostulantVo;
import com.wdkj.xyfund.entity.Postulant;
import com.wdkj.xyfund.entity.PostulantExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PostulantMapper {
    int deleteByExample(PostulantExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Postulant record);

    int insertSelective(Postulant record);

    List<Postulant> selectByExample(PostulantExample example);

    Postulant selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Postulant record, @Param("example") PostulantExample example);

    int updateByExample(@Param("record") Postulant record, @Param("example") PostulantExample example);

    int updateByPrimaryKeySelective(Postulant record);

    int updateByPrimaryKey(Postulant record);

	List<PostulantVo> selectVol();
}