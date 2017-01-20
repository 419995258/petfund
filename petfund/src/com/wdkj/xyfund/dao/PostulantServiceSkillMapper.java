package com.wdkj.xyfund.dao;

import com.wdkj.xyfund.entity.PostulantServiceSkill;
import com.wdkj.xyfund.entity.PostulantServiceSkillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PostulantServiceSkillMapper {
    int deleteByExample(PostulantServiceSkillExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PostulantServiceSkill record);

    int insertSelective(PostulantServiceSkill record);

    List<PostulantServiceSkill> selectByExample(PostulantServiceSkillExample example);

    PostulantServiceSkill selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PostulantServiceSkill record, @Param("example") PostulantServiceSkillExample example);

    int updateByExample(@Param("record") PostulantServiceSkill record, @Param("example") PostulantServiceSkillExample example);

    int updateByPrimaryKeySelective(PostulantServiceSkill record);

    int updateByPrimaryKey(PostulantServiceSkill record);
    
    void addTrainRecordBatch(List l);
}