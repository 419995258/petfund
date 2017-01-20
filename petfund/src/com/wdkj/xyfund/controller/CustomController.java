package com.wdkj.xyfund.controller;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wdkj.xyfund.entity.News;
import com.wdkj.xyfund.service.IUserService;

@RestController
@RequestMapping("/customC")
@Scope("prototype")
public class CustomController extends BasicController{

	@Resource(name = "userService")
	private IUserService userService;


	/**
	 * 查询客服信息的具体信息信息
	 * 
	 */
	@RequestMapping(value="/showCustomServiceData", method = RequestMethod.POST)
	public News showCustomServiceData(@RequestBody Integer id) throws Exception {
		return userService.showCustomServiceData(id);
	}
	
}
