package com.wdkj.xyfund.service;

import com.wdkj.xyfund.controller.vo.NewsVo;
import com.wdkj.xyfund.controller.vo.ResultVo;

public interface INewsService {
	
	/**
	 * 按类型查询新闻
	 * @param param
	 * @throws Exception
	 */
	public ResultVo queryByType(ResultVo param) throws Exception;
	
	/**
	 * 按id查询新闻
	 * @param id
	 * @throws Exception
	 */
	public NewsVo queryById(Integer id) throws Exception;
}
