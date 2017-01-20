package com.wdkj.xyfund.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wdkj.xyfund.controller.vo.Message;
import com.wdkj.xyfund.controller.vo.ResultVo;
import com.wdkj.xyfund.entity.User;
import com.wdkj.xyfund.service.IAdminService;
import com.wdkj.xyfund.service.IHelpService;

@RestController
@RequestMapping("/adminC")
@Scope("prototype")
public class AdminController {
	@Resource(name = "adminService")
	private IAdminService adminService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Message getUsers(@RequestBody User lu,HttpServletRequest request,HttpServletResponse response) throws Exception{
		Message message = new Message();
		message = adminService.login(lu);
		if (message.getSuccess()) {
			this.conSession(request, message);
			
			HttpSession se = request.getSession();
			Map m = message.getResult();
			m.put("currentYear", se.getAttribute("currentYear"));
			message.setResult(m);
		}
		return message;
	}
	
	@RequestMapping(value="ckLogined", method = RequestMethod.POST)
	public Message ckLogined(HttpServletRequest request,HttpServletResponse response) throws Exception {
		Message message = new Message();
		HttpSession se = request.getSession();
		Object lu = se.getAttribute("user");
		
		if (lu != null) {
			Map<String, User> result = new HashMap<String, User>();
			result.put("user", (User) lu);
			message.setResult(result);
			message.setSuccess(true);
		} else {
			message.setSuccess(false);
		}
		return message;
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.POST)
	public Message logout(HttpServletRequest request) throws Exception {
		/*UserVo userVo = new UserVo();
		userVo.setMobile(mobile);
		userVo.setToken(token);
		Message message =  userManagerService.logout(userVo);
		
		if (message.getSuccess()) {
			HttpSession se = request.getSession();
			UserVo uvo = (UserVo) message.getResult().get("user");
			se.removeAttribute("user");
		}
		HttpSession se = request.getSession();
		se.setAttribute("user", null);*/
		
		//userManagerService.logout((UserVo)sessionLogined(request));
		sessionLogout(request);
		Message message = new Message();
		message.setSuccess(true);
		
		return message;
	}
	
	
	private void conSession(HttpServletRequest request, Message message) throws Exception {
		HttpSession se = request.getSession();
		User uvo = (User) message.getResult().get("user");
		se.setAttribute("user", uvo);
	}
	
	private Object sessionLogined(HttpServletRequest request) {
		HttpSession se = request.getSession();
		return se.getAttribute("user");
	}
	
	private void sessionLogout(HttpServletRequest request) {
		HttpSession se = request.getSession();
		se.removeAttribute("user");
	}
	
	/**
	 * 查询所有日志信息
	 * 
	 */
	@RequestMapping(value="/showLoginLog", method = RequestMethod.POST)
	public ResultVo showLoginLog(@RequestBody ResultVo param) throws Exception {
		return adminService.showLoginLog(param);
	}
	
}
