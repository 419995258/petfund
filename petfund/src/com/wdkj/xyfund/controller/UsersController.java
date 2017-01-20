package com.wdkj.xyfund.controller;

import java.io.File;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wdkj.xyfund.controller.vo.Message;
import com.wdkj.xyfund.controller.vo.ResultVo;
import com.wdkj.xyfund.controller.vo.UserVo;
import com.wdkj.xyfund.entity.Contribution;
import com.wdkj.xyfund.entity.User;
import com.wdkj.xyfund.service.IUserService;
import com.wdkj.xyfund.service.IVolunteerService;
import com.wdkj.xyfund.service.impl.MailService;
import com.wdkj.xyfund.util.BizUtil;
import com.wdkj.xyfund.util.Const;



@RestController
@RequestMapping("/userC")
@Scope("prototype")
public class UsersController extends BasicController {

	@Resource(name = "userService")
	private IUserService userService;
	
	@Resource(name = "volunteerService")
	private IVolunteerService volunteerService;
	
	@Resource(name = "mailService")
	private MailService mailService;
	
	/*private MailService mailService;*/

	/**
	 * 用户注册
	 */
	@RequestMapping(value = "/registerController", method = RequestMethod.PUT)
	public Message userRegister(@RequestBody User user, HttpSession session) throws Exception {
		Message message = new Message();
		try {
			message = userService.userRegister(user);
			if (message.getSuccess()) {
				UserVo uvo = new UserVo();
				BeanUtils.copyProperties(uvo, user);
				conInfoToSession(session, Const.SESSION_CUSTOMER_USER, uvo);
			}
		} catch (Exception e) {
			message.setSuccess(false);
		}
		return message;

	};

	/**
	 * 用户登录验证
	 * 
	 * @param user
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/userLogin", method = RequestMethod.PUT)
	public Message userLogin(@RequestBody User user, HttpSession session)
			throws Exception {
		Message message = new Message();

		try {
			User userpo = userService.userLogin(user);
			if (userpo != null) {
				message.setSuccess(true);
				Map result = new HashMap();
				UserVo uvo = new UserVo();
				BeanUtils.copyProperties(uvo, userpo);
				result.put("user", uvo);
				message.setResult(result);
				conInfoToSession(session, Const.SESSION_CUSTOMER_USER, uvo);
			}

		} catch (Exception e) {
		}
		return message;

	}

	/**
	 * 用户登出
	 * @param session
	 * @throws Exception
	 */
	@RequestMapping(value = "/logOut", method = RequestMethod.PUT)
	public Message logOut(HttpSession session) throws Exception {
		Message message = new Message();
		clearSession(session, Const.SESSION_CUSTOMER_USER);
		message.setSuccess(true);
		return message;

	}

	/**
	 * 检查用户是否登录
	 * @param session
	 * @throws Exception
	 */
	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
	public Message checkLogin(HttpSession session) throws Exception {
		Message message = new Message();
		if (loginedUserInfo(session) != null) {
			message.setSuccess(true);
			Map<String, Object> result = new HashMap<>();
			result.put("username", loginedUserInfo(session).getUsername());
			result.put("id", loginedUserInfo(session).getId());
			result.put("isPostulant", loginedUserInfo(session).getIsPostulant());
			message.setResult(result);
		}
		return message;

	}
	

	/**
	 * 在线求助
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/seek", method = RequestMethod.PUT)
	public Message seek(@RequestBody User user) throws Exception {
		Message message = new Message();
		try {
		} catch (Exception e) {
			// TODO: handle exception
		}
		return message;

	};

	/**
	 * 查询当前登录人的详细信息
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/queryUserInfo", method = RequestMethod.POST)
	public UserVo queryUserInfo(HttpSession session) throws Exception {
		return userService.queryById(loginedUserInfo(session).getId());
	}
	
	
	/**
	 * 修改用户信息(带头像)
	 * @param uservo
	 * @param request
	 * @param session
	 * @throws Exception
	 */
	@RequestMapping(value="/updateUserInfoAndHard" ,method= RequestMethod.POST)
	public Message updateUserInfoAndHard(@RequestParam("file") MultipartFile file, @RequestParam("realname") String realname, @RequestParam("cardNumber") String cardNumber, HttpSession session)throws Exception{
		UserVo user = loginedUserInfo(session);
		UserVo userInfo = new UserVo();
		userInfo.setId(user.getId());//设置修改人的ID
		userInfo.setRealname(realname);//设置修改人的ID
		userInfo.setIconUrl(user.getIconUrl());
		userInfo.setUploadfile(file);
		userInfo.setCardNumber(cardNumber);
		Message message = new Message();
		message = userService.updateUserInfo(userInfo);
		if (message.getSuccess()) {
			conInfoToSession(session, Const.SESSION_CUSTOMER_USER, (UserVo)message.getResult().get("user"));
		}
		return message;
	}
	
	/**
	 * 修改用户信息
	 * @param userInfo
	 * @param session
	 * @throws Exception
	 */
	@RequestMapping(value="/updateUserInfo", method = RequestMethod.PUT)
	public Message updateUserInfo(@RequestBody UserVo userInfo, HttpSession session) throws Exception {
		Message message = new Message();
		UserVo user = loginedUserInfo(session);
		userInfo.setId(user.getId());//设置修改人的ID
		message = userService.updateUserInfo(userInfo);
		if (message.getSuccess()) {
			conInfoToSession(session, Const.SESSION_CUSTOMER_USER, (UserVo)message.getResult().get("user"));
		}
		return message;
	}
	
	/**
	 * 查询我的捐助记录
	 * @param rVo
	 * @param session
	 * @throws Exception
	 */
	@RequestMapping(value="/queryMyContribution", method = RequestMethod.POST)
	public ResultVo queryMyContribution(@RequestBody ResultVo rVo, HttpSession session) throws Exception {
		Contribution param = new Contribution();
		param.setUserId(loginedUserInfo(session).getId());
		//param.setContributionType(BizUtil);
		return volunteerService.queryOfficeListByUserId(rVo, param);
	}
	
	/**
	 * 查询我的捐赠概况
	 * @param rVo
	 * @param session
	 * @throws Exception
	 */
	@RequestMapping(value="/queryMyGk", method = RequestMethod.POST)
	public Map queryMyGk(HttpSession session) throws Exception {
		Contribution param = new Contribution();
		param.setUserId(loginedUserInfo(session).getId());
		//param.setContributionType(BizUtil);
		return volunteerService.queryGk(param);
	}
	
	/**
	 * 查询我的求助信息
	 * @param rVo
	 * @param session
	 * @throws Exception
	 */
	@RequestMapping(value="/queryMyHelp", method = RequestMethod.POST)
	public ResultVo queryMyHelp(@RequestBody ResultVo rVo, HttpSession session) throws Exception {
		return volunteerService.queryHelpById(rVo, loginedUserInfo(session).getId());
	}
	
	
	/**
	 * 找回密码
	 * @param username
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/recoveryPass", method = RequestMethod.PUT)
	public Message recoveryPass(@RequestBody String username) throws Exception {
		Message message = new Message();
		message = userService.selectPassword(username);
		Map<String, String> result = message.getResult();
		String password = result.get("password");
		mailService.sendMail(username, password);
		
		return message;
	}
	
}
