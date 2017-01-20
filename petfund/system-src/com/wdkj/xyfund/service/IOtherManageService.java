package com.wdkj.xyfund.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.wdkj.xyfund.controller.vo.LinkVo;
import com.wdkj.xyfund.controller.vo.Message;
import com.wdkj.xyfund.controller.vo.NewsVo;
import com.wdkj.xyfund.controller.vo.PublictiyVo;
import com.wdkj.xyfund.controller.vo.ResultVo;
import com.wdkj.xyfund.entity.Abount;

public interface IOtherManageService {
	
	/**
	 * 
	 * 查询关于我们
	 * @param abount
	 * @return
	 * @throws Exception
	 */
	public Abount query(Abount abount) throws Exception;
	
	/**
	 * 更新关于我们
	 */
	public Message update(Abount abount) throws Exception;
	
	/**
     * 设置分页初始信息
     * @param pagesize
     * @param currentpage
     */
	public void setPageInfo(Integer pagesize, Integer currentpage);
	
	
	/**
     * 设置返回的分页信息
     * @param pagesize
     * @param currentpage
     * @param pos
     * @param resultVo
     */
	public void setReturnPageInfo(Integer pagesize, Integer currentpage,
			List pos, ResultVo resultVo) throws Exception;
	
	/**
	 * 添加公开透明
	 * @param publictiyVo
	 * @return
	 * @throws Exception
	 */
	public Message addPublictiy(PublictiyVo publictiyVo) throws Exception;
	
	/**
	 * 查询公开透明
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public ResultVo selectPublictiy(ResultVo param) throws Exception;
	
	/**
	 * 删除公开透明
	 * @param publictiyVo
	 * @return
	 * @throws Exception
	 */
	public Message deletePublictiy(PublictiyVo publictiyVo) throws Exception;
	
	/**
	 * 查询公开透明具体信息
	 * @param publictiyVo
	 * @return
	 * @throws Exception
	 */
	public PublictiyVo showPublictiyData(PublictiyVo publictiyVo) throws Exception;
	
	/**
	 * 更新公开透明
	 * @param publictiyVo
	 * @return
	 * @throws Exception
	 */
	public Message updatePublictiy(PublictiyVo publictiyVo) throws Exception;
	
	
	/**
	 * 添加友情链接
	 * @param LinkVo
	 * @return
	 * @throws Exception
	 */
	public Message addLink(LinkVo linkVo) throws Exception;
	
	/**
	 * 查询友情链接、感恩有你
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public ResultVo selectLink(ResultVo param) throws Exception;
	
	/**
	 * 删除友情链接，感恩有你
	 * @param linkVo
	 * @return
	 * @throws Exception
	 */
	public Message deleteLink(LinkVo linkVo) throws Exception;
	
	/**
	 * 查询友情链接具体信息
	 * @param linkVo
	 * @return
	 * @throws Exception
	 */
	public LinkVo showLinkData(LinkVo linkVo) throws Exception;
	
	/**
	 * 更新友情链接
	 * @param linkVo
	 * @return
	 * @throws Exception
	 */
	public Message updateLink(LinkVo linkVo) throws Exception;
	
	/**
	 * 添加感谢有你
	 * @param LinkVo
	 * @return
	 * @throws Exception
	 */
	public Message addThanks(LinkVo linkVo) throws Exception;
	
	/**
	 * 更新感谢有你
	 * @param linkVo
	 * @return
	 * @throws Exception
	 */
	public Message updateThanks(LinkVo linkVo) throws Exception;
	
	
	/**
	 * 保存临时文件
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public Message saveTempFiles(MultipartFile[] file) throws Exception;
}

