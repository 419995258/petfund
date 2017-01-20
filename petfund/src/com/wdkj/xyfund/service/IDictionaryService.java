package com.wdkj.xyfund.service;

import java.util.List;

import com.wdkj.xyfund.controller.vo.DictionaryVo;
import com.wdkj.xyfund.controller.vo.Message;
import com.wdkj.xyfund.entity.Dictionary;
import com.wdkj.xyfund.entity.File;

public interface IDictionaryService {
	/**
	 * 根据类型查询数据
	 * @param type
	 * @throws Exception
	 */
	public List<DictionaryVo> queryByType(String type) throws Exception;
	
	/**
	 * 查询选中的skill
	 * @param id
	 * @throws Exception
	 */
	public List<DictionaryVo> querySkill(Integer id) throws Exception;
	
	/**
	 *查询选中的service
	 * @param id
	 * @throws Exception
	 */
	public List<DictionaryVo> queryService(Integer id) throws Exception;
}
