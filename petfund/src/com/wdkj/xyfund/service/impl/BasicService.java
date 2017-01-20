package com.wdkj.xyfund.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wdkj.xyfund.controller.vo.ResultVo;
import com.wdkj.xyfund.util.ObjectUtil;
import com.wdkj.xyfund.util.StringContentUtil;

import java.util.List;

public class BasicService {
	/**
	 * 设置分页初始信息
	 * 
	 * @param pagesize
	 * @param currentpage
	 * @throws Exception 
	 */
	protected void setPageInfo(String pagesize, String currentpage) throws Exception {
		int pageNum = 1;
		int psize = 10;

		if (StringContentUtil.isNoEmpty(pagesize)) {
			psize = ObjectUtil.convToInteger(pagesize);
		}

		if (StringContentUtil.isNoEmpty(currentpage)) {
			pageNum = ObjectUtil.convToInteger(currentpage);
		}
		
		PageHelper.startPage(pageNum, psize);
	}

	/**
	 * 设置返回的分页信息
	 * 
	 * @param pagesize
	 * @param currentpage
	 * @param pos
	 * @param resultVo
	 */
	protected void setReturnPageInfo(List pos, ResultVo resultVo) throws Exception {
		// 分页信息设置
		Page p = (Page) pos;

		resultVo.setCurrentpage(ObjectUtil.convToString(p.getPageNum()));
		resultVo.setTotal(ObjectUtil.convToString(p.getTotal()));

		resultVo.setPageNum(ObjectUtil.convToString(p.getPageNum()));

		resultVo.setPageSize(ObjectUtil.convToString(p.getPageSize()));

		int pages = p.getPages();
		resultVo.setPages(ObjectUtil.convToString(pages));
	}
}
