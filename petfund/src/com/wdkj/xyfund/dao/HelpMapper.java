package com.wdkj.xyfund.dao;

import com.wdkj.xyfund.controller.vo.HelpVo;
import com.wdkj.xyfund.controller.vo.HelpWithBLOBsVo;
import com.wdkj.xyfund.entity.Contribution;
import com.wdkj.xyfund.entity.Help;
import com.wdkj.xyfund.entity.HelpExample;
import com.wdkj.xyfund.entity.HelpWithBLOBs;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface HelpMapper {
    int deleteByExample(HelpExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HelpWithBLOBs record);

    int insertSelective(HelpWithBLOBs record);

    List<HelpWithBLOBs> selectByExampleWithBLOBs(HelpExample example);

    List<Help> selectByExample(HelpExample example);

    HelpWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HelpWithBLOBs record, @Param("example") HelpExample example);

    int updateByExampleWithBLOBs(@Param("record") HelpWithBLOBs record, @Param("example") HelpExample example);

    int updateByExample(@Param("record") Help record, @Param("example") HelpExample example);

    int updateByPrimaryKeySelective(HelpWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(HelpWithBLOBs record);

    int updateByPrimaryKey(Help record);
    
    List<HelpWithBLOBsVo> selectByContribution(Contribution param);
    
    List<HelpVo> selectAndFile(Help record);
    
    List<HelpVo> selectAndFileIsTop(Integer type);
    
    List<HelpVo> selectAndFileById(Integer id);
    
    long selectProject();
    
    long selectMoney();
    
    long selectConTime();

	List<HelpVo> selectHelped();
}