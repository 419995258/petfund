package com.wdkj.xyfund.controller;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wdkj.xyfund.controller.vo.Message;
import com.wdkj.xyfund.controller.vo.PostulantVo;
import com.wdkj.xyfund.controller.vo.ResultVo;
import com.wdkj.xyfund.controller.vo.UserVo;
import com.wdkj.xyfund.entity.User;
import com.wdkj.xyfund.service.IUserManageService;

@RestController
@RequestMapping("/usermanageC")
@Scope("prototype")
public class UsersManageController extends BasicController {

	@Resource(name = "usermanageService")
	private IUserManageService userManageService;
	
	
	
	/**
	 * 查询所有user信息
	 * 
	 */
	@RequestMapping(value="/showUser", method = RequestMethod.POST)
	public ResultVo ShowAllUser(@RequestBody ResultVo param) throws Exception {
		return userManageService.showAllUsers(param);
	}
	
	/**
	 * 删除userById
	 */
	@RequestMapping(value="/deleteUser",method = RequestMethod.PUT)
	public Message deleteUser(@RequestBody UserVo user) throws Exception{
		return userManageService.deleteUserById(user);
	}


	/**
	 * 查询所有是postulant的user
	 * 
	 */
	@RequestMapping(value="/showPostulantUser",method = RequestMethod.POST)
	public ResultVo showPostulantUser(@RequestBody ResultVo param) throws Exception{
		return userManageService.selectAllPostulant(param);
	}
	
	/**
	 * 删除user的志愿者身份
	 */
	@RequestMapping(value="/deleteIsPostulant",method = RequestMethod.PUT)
	public Message deleteIsPostulant(@RequestBody UserVo userVo) throws Exception{
		return userManageService.deletePostulantById(userVo);
	}
	

	/**
	 * 查询postulant的具体信息
	 * 
	 */
	@RequestMapping(value="/showPostulantData",method = RequestMethod.POST)
	public PostulantVo showPostulant(@RequestBody UserVo userVo) throws Exception{
		return userManageService.showPostulant(userVo);
	}
	
	/**
	 * 认证user的志愿者身份
	 */
	@RequestMapping(value="/surePostulant",method = RequestMethod.PUT)
	public Message surePostulant(@RequestBody User user) throws Exception{
		return userManageService.surePostulant(user);
	}
	
}
