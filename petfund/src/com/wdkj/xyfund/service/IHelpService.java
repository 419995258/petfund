package com.wdkj.xyfund.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.wdkj.xyfund.controller.vo.ContributionVo;
import com.wdkj.xyfund.controller.vo.HelpApplyVo;
import com.wdkj.xyfund.controller.vo.HelpVo;
import com.wdkj.xyfund.controller.vo.Message;
import com.wdkj.xyfund.controller.vo.ResultVo;
import com.wdkj.xyfund.entity.Help;

public interface IHelpService {
	
	/**
	 * 根据类型查询未完成的求助情况(分页)
	 * @param param
	 * @param type
	 * @throws Exception
	 */
	public ResultVo queryByType(ResultVo param, Integer type) throws Exception;
	
	/**
	 * 按照id查询求助信息
	 * @param id
	 * @throws Exception
	 */
	public HelpVo queryById(Integer id) throws Exception;
	
	/**
	 * 查询首页相关统计信息
	 * @param helpVo
	 * @return
	 * @throws Exception
	 */
	public HelpVo queryMessageIndex(HelpVo helpVo) throws Exception;
	
	/**
	 * 查询置顶信息
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public HelpVo queryHelpIsTop(Integer type) throws Exception;
	
	/**
	 * 查询友情链接感恩有你
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public ResultVo queryLink(Integer type) throws Exception;
	
	/**
	 * 保存上传信息
	 * @param file
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public Message saveTempFiles(MultipartFile[] file,Integer type,Integer userId) throws Exception;
	
	/**
	 * 添加紧急求助
	 * @param helpVo
	 * @return
	 * @throws Exception
	 */
	public Message addHelp(HelpApplyVo helpApplyVo,Integer userId,String username) throws Exception;
	
	public ResultVo queryHelped() throws Exception;

	public ResultVo queryLatest() throws Exception;

	public ResultVo queryVol() throws Exception;
	
	/**
	 * 保存捐助信息
	 * @param contributionVo
	 * @throws Exception
	 */
	public Message saveContribution(ContributionVo contributionVo) throws Exception;
	
	
	public ResultVo showChild(ResultVo param)throws Exception;
	
	
	//public ResultVo queryByType(ResultVo param, Integer type) throws Exception;
}
