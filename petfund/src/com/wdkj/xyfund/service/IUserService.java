package com.wdkj.xyfund.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wdkj.xyfund.controller.vo.Message;
import com.wdkj.xyfund.controller.vo.NewsVo;
import com.wdkj.xyfund.controller.vo.ResultVo;
import com.wdkj.xyfund.controller.vo.UserVo;
import com.wdkj.xyfund.entity.News;
import com.wdkj.xyfund.entity.User;

public interface IUserService {
	/**
	 * 用户注册
	 * @param user
	 * @throws Exception
	 */
	public Message userRegister (User user) throws Exception;
	
	
	/**
	 * 验证用户是否已经存在
	 * @param user
	 * @throws Exception
	 */
	public Message checkUsername (User user) throws Exception;
	
	/**
	 * 验证用户手机号是否已经存在
	 * @param user
	 * @throws Exception
	 */
	public Message checkUseTel (User user) throws Exception;
	
	/**
	 * 验证用户登录
	 * @param user
	 * @throws Exception
	 */
	public User userLogin (User user) throws Exception;
	
	/**
	 * 修改用户信息
	 * @param user
	 * @throws Exception
	 */
	public Message updateUserInfo (UserVo user) throws Exception;
	
	/**
	 * 按用户id查询用户信息
	 * @param userId
	 * @throws Exception
	 */
	public UserVo queryById(Integer userId) throws Exception;
	
	/**
	 * 按类型查询用户信息
	 * @param type
	 * @throws Exception
	 */
	public List<UserVo> queryByType(Integer type) throws Exception;
	
	/**
	 * 查询客服信息的具体信息
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public News showCustomServiceData(Integer id) throws Exception;
	
	/**
	 * 查询密码
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public Message selectPassword(String username) throws Exception;
}
