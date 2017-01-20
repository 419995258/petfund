package com.wdkj.xyfund.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.wdkj.xyfund.controller.vo.DictionaryVo;
import com.wdkj.xyfund.dao.DictionaryMapper;
import com.wdkj.xyfund.dao.PostulantMapper;
import com.wdkj.xyfund.entity.Dictionary;
import com.wdkj.xyfund.entity.DictionaryExample;
import com.wdkj.xyfund.entity.Postulant;
import com.wdkj.xyfund.entity.PostulantExample;
import com.wdkj.xyfund.service.IDictionaryService;
import com.wdkj.xyfund.util.ObjectUtil;

@Repository("dictionaryService")
@Scope("prototype")
public class DictionaryServiceImpl implements IDictionaryService {
	@Autowired
	private DictionaryMapper dictionaryMapper;
	
	@Autowired
	private PostulantMapper postulantMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wdkj.xyfund.service.IDictionaryService#queryByType(java.lang.String)
	 */
	public List<DictionaryVo> queryByType(String type) throws Exception {
		List<DictionaryVo> result = new ArrayList<DictionaryVo>();

		DictionaryExample dicEx = new DictionaryExample();
		dicEx.createCriteria().andTypeEqualTo(type);
		List<Dictionary> temp = dictionaryMapper.selectByExample(dicEx);

		for (Iterator iterator = temp.iterator(); iterator.hasNext();) {
			Dictionary dictionary = (Dictionary) iterator.next();
			DictionaryVo dvo = new DictionaryVo();
			BeanUtils.copyProperties(dvo, dictionary);
			result.add(dvo);
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wdkj.xyfund.service.IDictionaryService#querySkill(java.lang.Integer)
	 */
	public List<DictionaryVo> querySkill(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Postulant postulant = new Postulant();
		PostulantExample postulantExample = new PostulantExample();
		postulantExample.createCriteria().andUserIdEqualTo(id);
		List<Postulant> postulants = new ArrayList<>();
		postulants = postulantMapper.selectByExample(postulantExample);
		if(!ObjectUtil.collectionIsEmpty(postulants)){
			postulant = postulants.get(0);
		}
		Integer pid = postulant.getId();
		
		List<DictionaryVo> skillList = dictionaryMapper.selectSkill(pid);

		return skillList;
	}

	
	public List<DictionaryVo> queryService(Integer id) throws Exception {
		Postulant postulant = new Postulant();
		PostulantExample postulantExample = new PostulantExample();
		postulantExample.createCriteria().andUserIdEqualTo(id);
		List<Postulant> postulants = new ArrayList<>();
		postulants = postulantMapper.selectByExample(postulantExample);
		if(!ObjectUtil.collectionIsEmpty(postulants)){
			postulant = postulants.get(0);
		}
		Integer pid = postulant.getId();
		
		
		List<DictionaryVo> serviceList = dictionaryMapper.selectService(pid);

		return serviceList;
	}
}
