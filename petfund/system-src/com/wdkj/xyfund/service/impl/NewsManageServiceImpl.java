package com.wdkj.xyfund.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wdkj.xyfund.controller.vo.Message;
import com.wdkj.xyfund.controller.vo.NewsVo;
import com.wdkj.xyfund.controller.vo.ResultVo;
import com.wdkj.xyfund.dao.FengmianMapper;
import com.wdkj.xyfund.dao.NewsMapper;
import com.wdkj.xyfund.entity.Fengmian;
import com.wdkj.xyfund.entity.FengmianExample;
import com.wdkj.xyfund.entity.News;
import com.wdkj.xyfund.entity.NewsExample.Criteria;
import com.wdkj.xyfund.entity.NewsExample;
import com.wdkj.xyfund.service.INewsManageService;
import com.wdkj.xyfund.util.DateUtil;
import com.wdkj.xyfund.util.FileOperationUtil;
import com.wdkj.xyfund.util.ObjectUtil;
import com.wdkj.xyfund.util.StringContentUtil;

@Service("newsmanageService")
public class NewsManageServiceImpl implements INewsManageService {

	@Autowired
	private NewsMapper newsMapper;
	
	@Autowired
	private FengmianMapper fengmianMapper;
	
	/**
     * 设置分页初始信息
     * @param pagesize
     * @param currentpage
     */
	@Override
	public void setPageInfo(Integer pagesize, Integer currentpage) {
		// TODO 设置分页初始信息
		if (pagesize != null || currentpage != null) {// 分页信息设置
			if (pagesize == null) {
				pagesize = 10;
			}
			if (currentpage == null) {
				currentpage = 1;
			}
			PageHelper.startPage(currentpage, pagesize);
		}
		
	}
	
	 /**
     * 设置返回的分页信息
     * @param pagesize
     * @param currentpage
     * @param pos
     * @param resultVo
     */
	@Override
	public void setReturnPageInfo(Integer pagesize, Integer currentpage,
			List pos, ResultVo resultVo) throws Exception {
		// TODO 设置返回的分页信息
		
		if (pagesize != null || currentpage != null) {
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
	
	/**
     * 
     * 添加news
     */
	@Override
	public Message addNews(NewsVo newsVo) throws Exception {
		// TODO 添加news
		Message message = new Message();
		News news = new News();
		newsVo.setStatus(1);
		Date createTime = DateUtil.getCurrentDate(DateUtil.DATE_STYLE4);
		newsVo.setCreateTime(createTime);
		BeanUtils.copyProperties(news, newsVo);

		int record = newsMapper.insert(news);
		if (record > 0) {
			message.setSuccess(true);
			}
		return message;
	}

	/**
     * 查询news信息
     * 
     */
	@Override
	public ResultVo selectNews(ResultVo param) throws Exception {
		// TODO 查询news信息
		ResultVo resultVo = new ResultVo();
		List<NewsVo> newsVos = new ArrayList<NewsVo>();

		String pagesize = param.getPageSize();
		String currentpage = param.getCurrentpage();

		int pageNum = 1;
		int psize = 10;

		if (StringContentUtil.isNoEmpty(pagesize)) {
			psize = ObjectUtil.convToInteger(pagesize);
		}

		if (StringContentUtil.isNoEmpty(currentpage)) {
			pageNum = ObjectUtil.convToInteger(currentpage);
		}
		this.setPageInfo(psize, pageNum);
		
		NewsExample newsExample = new NewsExample();
		newsExample.setOrderByClause("id desc");
		Criteria cr = newsExample.createCriteria();
		// 紧急筹款状态
		cr.andTypeEqualTo(param.getType());
		
		
		//查询不同种类
		Integer queryType = param.getQueryType();
		if(queryType == null){
			queryType = 0;
		}
		
		if (queryType == 1) {
			cr.andCreateTimeEqualTo(DateUtil.parseDate(DateUtil.DATE_STYLE4, param.getQueryText()));
		} else if (queryType == 2) {
			cr.andTitleLike(param.getQueryText());
		}
		
		List<News> newsList = newsMapper.selectByExample(newsExample);

		if (!ObjectUtil.collectionIsEmpty(newsList)) {

			for (Iterator iterator = newsList.iterator(); iterator.hasNext();) {
				News news= (News) iterator.next();
				NewsVo temp = new NewsVo();
				BeanUtils.copyProperties(temp, news);
				Date createTime = news.getCreateTime();
				temp.setCreateTimeStr(DateUtil.getDateStr(DateUtil.DATE_STYLE4,
						createTime));
				newsVos.add(temp);
			}

		}

		this.setReturnPageInfo(psize, pageNum, newsList, resultVo);
		resultVo.setRows(newsVos);
		return resultVo;
	}

	/**
     * 删除news信息
     */
	@Override
	public Message deleteNews(NewsVo newsVo) throws Exception {
		// TODO 删除news信息
		Message message = new Message();
		int id = newsVo.getId();

		int record = newsMapper.deleteByPrimaryKey(id);
		if (record > 0) {
			message.setSuccess(true);
		}
		return message;
	}

	/**
     * 查询news详细信息
     * 
     */
	@Override
	public NewsVo showNewsData(NewsVo newsVo) throws Exception {
		// TODO 查询news详细信息
		int id = newsVo.getId();
		News news = new News();
		NewsExample newsExample = new NewsExample();
		newsExample.createCriteria().andIdEqualTo(id);
		List<News> newsList = newsMapper
				.selectByExampleWithBLOBs(newsExample);
		if (!ObjectUtil.collectionIsEmpty(newsList)) {

			news = newsList.get(0);
			BeanUtils.copyProperties(newsVo, news);
			Date createTime = news.getCreateTime();
			newsVo.setCreateTimeStr(DateUtil.getDateStr(DateUtil.DATE_STYLE4,
					createTime));
			
		}
		return newsVo;
	}

	/**
     * 更新news详细信息
     * 
     */
    
	@Override
	public Message updateNews(NewsVo newsVo) throws Exception {
		// TODO 更新news详细信息
		Message message = new Message();
		News news = new News();

		BeanUtils.copyProperties(news, newsVo);

		int record = newsMapper.updateByPrimaryKeyWithBLOBs(news);
		if (record > 0) {
			message.setSuccess(true);
			}

		return message;
	}

	/**
	 * 保存临时文件
	 */
	@Override
	public Message saveTempFiles(MultipartFile[] file,Integer type) throws Exception {
		// TODO Auto-generated method stub
		// TODO 保存临时文件
				Message message = new Message();
				Map<String, Object> fm = new HashMap<String, Object>();

				if (file != null && file.length > 0) {
					// Date createTime = DateUtil.getCurrentDate(DateUtil.DATE_STYLE5);

					for (int i = 0; i < file.length; i++) {
						MultipartFile f = file[i];
						String fileName = f.getOriginalFilename(); // 文件名
						String diskFileName = StringContentUtil.getUuid(); // 保存后的文件名
						CommonsMultipartFile cf = (CommonsMultipartFile) f;
						DiskFileItem fi = (DiskFileItem) cf.getFileItem();
						File f1 = fi.getStoreLocation();
						Message m = FileOperationUtil.saveFileToDisk(f1, fileName,
								diskFileName, "fengmianFile");

						/*
						 * 保存数据库逻辑
						 */

						if (m.getSuccess()) {
							try {
								// 保存文件记录
								int id = 0 ;
								String path = null;
								Fengmian fengmian = new Fengmian();
								fengmian.setType(type);
								FengmianExample fengmianExample = new FengmianExample();
								fengmianExample.createCriteria().andTypeEqualTo(type);
								List<Fengmian> fengmianList = fengmianMapper.selectByExample(fengmianExample);
								if(ObjectUtil.collectionIsEmpty(fengmianList)){
									fengmianMapper.insert(fengmian);
									id = fengmian.getId();
								}else{
									id = fengmianList.get(0).getId();
									path =  fengmianList.get(0).getUrl();
								}
								fengmian.setId(id);
								fengmian.setUrl(".." + (String) m.getResult().get("filePath"));
								int record = fengmianMapper.updateFengmian(fengmian);
								if(record > 0 && id !=0){
									FileOperationUtil.deleteFile2(path);
								}
								/*Fengmian temp = new Fengmian();
								temp.setType(type);
								temp.setUrl((String) m.getResult().get("filePath"));
								
								int records = fengmianMapper.upda
								if (records > 0) {
									fm.put("fileId", temp.getId());
									fm.put("fileUrl", temp.getFileurl());
									message.setSuccess(true);
								}*/
							} catch (Exception e) {
								Object o = m.getResult().get("savefile");

								File ef = (File) o;
								if (ef.exists()) {
									ef.delete();
								}
								throw e;
							}
						}
					}
				}
				message.setResult(fm);

				return message;
			}

	/*
	 * (non-Javadoc)
	 * @see com.wdkj.xyfund.service.INewsManageService#queryFengmian(java.lang.Integer)
	 */
	public Message queryFengmian(Integer type) throws Exception {
		// TODO Auto-generated method stub
		Message message = new Message();
		FengmianExample fengmianExample = new FengmianExample();
		fengmianExample.createCriteria().andTypeEqualTo(type);
		List<Fengmian> fengmianList = fengmianMapper.selectByExample(fengmianExample);
		Fengmian fengmian = fengmianList.get(0);
		message.setMessage(fengmian.getUrl());
		message.setSuccess(true);
		return message;
	}

	

}
