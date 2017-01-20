package com.wdkj.xyfund.dao;

import com.wdkj.xyfund.controller.vo.ContributionVo;
import com.wdkj.xyfund.entity.Contribution;
import com.wdkj.xyfund.entity.ContributionExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ContributionMapper {
    int deleteByExample(ContributionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Contribution record);

    int insertSelective(Contribution record);

    List<Contribution> selectByExample(ContributionExample example);

    Contribution selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Contribution record, @Param("example") ContributionExample example);

    int updateByExample(@Param("record") Contribution record, @Param("example") ContributionExample example);

    int updateByPrimaryKeySelective(Contribution record);

    int updateByPrimaryKey(Contribution record);
    
    List<ContributionVo> selectAndHelp(Contribution param);
    
    //统计行善次数
    long selectCountFrequency(Contribution record);
    
    //统计行善总金额
    long selectCountMoney(Contribution record);
    
    //统计移动捐赠了多少个孩子
    long selectCountChild(Contribution record);

	List<ContributionVo> selectLatestWithHead();
}