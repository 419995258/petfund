package com.wdkj.xyfund.dao;

import com.wdkj.xyfund.controller.vo.LinkVo;
import com.wdkj.xyfund.entity.Link;
import com.wdkj.xyfund.entity.LinkExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface LinkMapper {
    int deleteByExample(LinkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Link record);

    int insertSelective(Link record);

    List<Link> selectByExample(LinkExample example);

    Link selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Link record, @Param("example") LinkExample example);

    int updateByExample(@Param("record") Link record, @Param("example") LinkExample example);

    int updateByPrimaryKeySelective(Link record);

    int updateByPrimaryKey(Link record);
    
    List<LinkVo> selectAndFiles(Link link);
}