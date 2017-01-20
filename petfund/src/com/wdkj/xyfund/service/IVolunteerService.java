package com.wdkj.xyfund.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.wdkj.xyfund.controller.vo.Message;
import com.wdkj.xyfund.controller.vo.PostulantVo;
import com.wdkj.xyfund.controller.vo.ResultVo;
import com.wdkj.xyfund.entity.Contribution;
import com.wdkj.xyfund.entity.Postulant;
import com.wdkj.xyfund.entity.PostulantFiles;

public interface IVolunteerService {
	/**
	 * 申请志愿者
	 * @param postulant
	 * @return
	 * @throws Exception
	 */
	public Message volunteerRegisteer(PostulantVo param) throws Exception;
	
	/**
	 * 保存临时文件
	 * @param file 文件
	 * @param userId 用户id
	 * @return
	 * @throws Exception
	 */
	public Message saveTempFiles(MultipartFile[] file, Integer userId) throws Exception;
	
	/**
	 * 
	 * 保存用户与上传文件的关系
	 * @param id 用户id
	 * @param fid 文件id
	 * @return
	 * @throws Exception
	 */
	public Message saveVolun(PostulantFiles postulantFiles) throws Exception;
	
	/**
	 * 删除申请志愿者临时文件
	 * @param param
	 * @throws Exception
	 */
	public Message deleteTempFile(com.wdkj.xyfund.entity.File param) throws Exception;
	
	/**
	 * 查询用户的捐赠记录(分页)
	 * @param resultVo
	 * @param contribution
	 * @throws Exception
	 */
	public ResultVo queryOfficeListByUserId(ResultVo resultVo, Contribution contribution) throws Exception;
	
	/**
	 * 查询截止当前时间登录人的捐赠概况
	 * @param contribution
	 * @throws Exception
	 */
	public Map queryGk(Contribution contribution) throws Exception;
	
	/**
	 * 查询我的求助信息(分页)
	 * @param resultVo
	 * @param username
	 * @throws Exception
	 */
	public ResultVo queryHelpById(ResultVo resultVo, int  id) throws Exception;
}
