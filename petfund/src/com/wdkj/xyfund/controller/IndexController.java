package com.wdkj.xyfund.controller;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wdkj.xyfund.controller.vo.ResultVo;
import com.wdkj.xyfund.util.Const;

/**
 * 
* <p>Title: 网站打开后默认跳转到主页</p>
* <p>Description: </p>
* <p>Company: </p>
* @author YCJ
* @date 2016年7月30日 下午1:21:31
 */
@Controller
@RequestMapping(value = "/")
@Scope("prototype")
public class IndexController extends BasicController {
	
	@RequestMapping
	public String index(HttpSession session) {
		if (session.getAttribute(Const.SESSION_CUSTOMER_USER) != null) {
			return "forward:/views/001_index.html";
		} else {
			return "redirect:/views/001_index.html";
			//return "forward:/views/MD020102_003_login.html"
		}
	}
	
	
}
