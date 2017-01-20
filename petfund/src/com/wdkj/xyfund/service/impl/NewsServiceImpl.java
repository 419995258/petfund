package com.wdkj.xyfund.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.wdkj.xyfund.controller.vo.NewsVo;
import com.wdkj.xyfund.controller.vo.ResultVo;
import com.wdkj.xyfund.dao.FengmianMapper;
import com.wdkj.xyfund.dao.NewsMapper;
import com.wdkj.xyfund.entity.Fengmian;
import com.wdkj.xyfund.entity.FengmianExample;
import com.wdkj.xyfund.entity.News;
import com.wdkj.xyfund.entity.NewsExample;
import com.wdkj.xyfund.service.INewsService;
import com.wdkj.xyfund.util.DateUtil;
import com.wdkj.xyfund.util.ObjectUtil;

@Repository("newsService")
@Scope("prototype")
public class NewsServiceImpl extends BasicService implements INewsService {
	@Autowired
	private NewsMapper newsMapper;
	
	@Autowired
	private FengmianMapper fengmianMapper;
	
	/*
	 * (non-Javadoc)
	 * @see com.wdkj.xyfund.service.INewsService#queryByType(com.wdkj.xyfund.controller.vo.ResultVo)
	 */
	public ResultVo queryByType(ResultVo param) throws Exception {
		ResultVo result = new ResultVo();
		setPageInfo(param.getPageSize(), param.getCurrentpage());
		NewsExample newsEx = new NewsExample();
		newsEx.createCriteria().andTypeEqualTo(param.getType()).andStatusEqualTo(1);
		newsEx.setOrderByClause("id desc");
		List<News> newsTemp = newsMapper.selectByExample(newsEx);
		
		List<NewsVo> newsVos = new ArrayList<NewsVo>();
		if (!ObjectUtil.collectionIsEmpty(newsTemp)) {
			for (Iterator iterator = newsTemp.iterator(); iterator.hasNext();) {
				News temp = (News) iterator.next();
				NewsVo newsVo = new NewsVo();
				BeanUtils.copyProperties(newsVo, temp);
				Date createTime = temp.getCreateTime();
				newsVo.setCreateTimeStr(DateUtil.getDateStr(DateUtil.DATE_STYLE4, createTime));
				newsVos.add(newsVo);
			}
		}
		//查询封面图片
		FengmianExample fengmianExample = new FengmianExample();
		fengmianExample.createCriteria().andTypeEqualTo(param.getType());
		List<Fengmian> fengmianList = fengmianMapper.selectByExample(fengmianExample);
		Fengmian fengmian = new Fengmian();
		if(!ObjectUtil.collectionIsEmpty(fengmianList)){
			fengmian = fengmianList.get(0);
		}
		String url = fengmian.getUrl();
		
		setReturnPageInfo(newsTemp, result);
		
		result.setUrl(url);
		result.setRows(newsVos);
		return result;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.wdkj.xyfund.service.INewsService#queryById(java.lang.Integer)
	 */
	public NewsVo queryById(Integer id) throws Exception {
		NewsVo newsVo = new NewsVo();
		
		if (id != null) {
			News news = newsMapper.selectByPrimaryKey(id);
			BeanUtils.copyProperties(newsVo, news);
		}
		
		return newsVo;
	}
}
