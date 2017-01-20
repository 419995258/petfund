package com.wdkj.xyfund.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wdkj.xyfund.controller.vo.Message;
import com.wdkj.xyfund.controller.vo.PostulantVo;
import com.wdkj.xyfund.entity.File;
import com.wdkj.xyfund.entity.Postulant;
import com.wdkj.xyfund.entity.PostulantFiles;
import com.wdkj.xyfund.entity.User;
import com.wdkj.xyfund.service.IVolunteerService;
import com.wdkj.xyfund.util.Const;

@RestController
@RequestMapping("/volunC")
@Scope("prototype")
public class VolunteerController extends BasicController {
	@Resource(name = "volunteerService")
	private IVolunteerService volunteerService;

	/**
	 * 志愿者申请验证
	 * 
	 * @param user
	 * @param postulant
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/volunRegister", method = RequestMethod.PUT)
	public Message volunteerRegister(@RequestBody PostulantVo param,
			HttpSession session) throws Exception {
		Message message = new Message();
		try {
			int userId = loginedUserInfo(session).getId();
			param.setUserId(userId);
			message = volunteerService.volunteerRegisteer(param);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return message;

	}

	public Message saveVolun(PostulantFiles postulantFiles) throws Exception {
		Message message = new Message();
		try {
			message = volunteerService.saveVolun(postulantFiles);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return message;

	}

	/**
	 * 上传图片临时保存文件
	 * 
	 * @param file
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/uploadTemp", method = RequestMethod.POST)
	public Map<String, Object> uploadTemp(
			@RequestParam("imgs") MultipartFile[] file, HttpSession session)
			throws Exception {
		Map dataMap = new HashMap();
		Message m = volunteerService.saveTempFiles(file,
				loginedUserInfo(session).getId());

		dataMap.put("success", m.getSuccess());
		if (m.getSuccess()) {
			dataMap.put("fileId", m.getResult().get("fileId"));
			dataMap.put("fileUrl",  m.getResult().get("fileUrl"));
		}
		return dataMap;
	}

	/**
	 * 删除申请志愿者的临时文件
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delPayFiles", method = RequestMethod.PUT)
	public Message delPayFiles(@RequestBody File param) throws Exception {
		return volunteerService.deleteTempFile(param);
	}

	/**
	 * 获取登录的session信息
	 * 
	 * @param session
	 * @return
	 */
	/*
	 * private User loginedUserInfo(HttpSession session) { Object o =
	 * session.getAttribute(Const.SESSION_CUSTOMER_USER);
	 * 
	 * User u = null;
	 * 
	 * if (o != null) { u = (User) o; }
	 * 
	 * return u; }
	 */

}
