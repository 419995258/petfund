package com.wdkj.xyfund.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.StringUtil;
import com.wdkj.xyfund.controller.vo.ContributionVo;
import com.wdkj.xyfund.controller.vo.HelpApplyVo;
import com.wdkj.xyfund.controller.vo.HelpVo;
import com.wdkj.xyfund.controller.vo.Message;
import com.wdkj.xyfund.controller.vo.ResultVo;
import com.wdkj.xyfund.controller.vo.UserVo;
import com.wdkj.xyfund.entity.Help;
import com.wdkj.xyfund.service.IHelpService;
import com.wdkj.xyfund.util.StringContentUtil;

/**
 * 
 * <p>
 * Title: HelpController
 * </p>
 * <p>
 * Description: 平台中捐助信息的维护
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author Steven
 * @date 2016年7月31日 下午10:58:50
 */
@RestController
@RequestMapping("/helpC")
@Scope("prototype")
public class HelpController extends BasicController {
	@Resource(name = "helpService")
	private IHelpService helpService;

	/**
	 * 按类型查询平台求助信息(分页)
	 * 
	 * @param param
	 * @param session
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryHelp", method = RequestMethod.POST)
	public ResultVo queryHelp(@RequestBody ResultVo param, HttpSession session)
			throws Exception {
		return helpService.queryByType(param, param.getQueryType());
	}

	/**
	 * 查询求助信息详情
	 * @param helpId
	 * @param session
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryHelpById", method = RequestMethod.POST)
	public HelpVo queryHelpById(@RequestBody Integer helpId, HttpSession session)
			throws Exception {
		return helpService.queryById(helpId);
	}
	
	/**
	 * 查询首页平台求助信息
	 * 
	 * @param type
	 * @param session
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryHelpIndex", method = RequestMethod.POST)
	public List<HelpVo> queryHelpIndex(@RequestBody Integer type,
			HttpSession session) throws Exception {
		ResultVo param = new ResultVo();
		param.setPageSize("6");
		param.setCurrentpage("1");
		param.setStatus(0);
		ResultVo r = helpService.queryByType(param, type);
		return r.getRows();
	}

	/**
	 * 查询首页统计信息
	 * 
	 * @param helpVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryMessageIndex", method = RequestMethod.POST)
	public HelpVo queryMessageIndex(@RequestBody HelpVo helpVo)
			throws Exception {

		return helpService.queryMessageIndex(helpVo);
	}

	/**
	 * 查询置顶信息
	 * 
	 * @param type
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryHelpIsTop", method = RequestMethod.POST)
	public HelpVo queryHelpIsTop(@RequestBody Integer type) throws Exception {
		return helpService.queryHelpIsTop(type);
	}

	/**
	 * 查询友情链接
	 * 
	 * @param type
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryThanks", method = RequestMethod.POST)
	public ResultVo queryThanks(@RequestBody Integer type) throws Exception {
		return helpService.queryLink(type);
	}
	
	/**
	 * 查询志愿者
	 * @param type
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryVol", method = RequestMethod.POST)
	public ResultVo queryVol() throws Exception {
		return helpService.queryVol();
	}
	
	/**
	 * 查询右边最新捐款
	 * @param type
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryLatest", method = RequestMethod.POST)
	public ResultVo queryLatest() throws Exception {
		return helpService.queryLatest();
	}
	
	/**
	 * 查询右边栏已被救助的小孩
	 * @param type
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryHelped", method = RequestMethod.POST)
	public ResultVo queryHelped() throws Exception {
		return helpService.queryHelped();
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
	@RequestMapping(value = "/uploadTemp/{type}", method = RequestMethod.POST)
	public Map<String, Object> uploadTemp(
			@RequestParam("imgs") MultipartFile[] file,
			@PathVariable Integer type, HttpSession session) throws Exception {
		Map dataMap = new HashMap();
		// Integer orgId = (Integer) session.getAttribute("currentOrgId");
		Message m = helpService.saveTempFiles(file, type,loginedUserInfo(session).getId());

		dataMap.put("success", m.getSuccess());
		if (m.getSuccess()) {
			dataMap.put("fileId", m.getResult().get("fileId"));
			dataMap.put("fileUrl", m.getResult().get("fileUrl"));
			dataMap.put("type",  m.getResult().get("type"));
		}
		return dataMap;
	}

	/**
	 * 添加help申请
	 * @param helpVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addHelp", method = RequestMethod.PUT)
	public Message addHelp(@RequestBody HelpApplyVo helpApplyVo,HttpSession session) throws Exception {
		
		/*return null;*/
		
		return helpService.addHelp(helpApplyVo,loginedUserInfo(session).getId(),loginedUserInfo(session).getUsername());
	}

	/**
	 * 保存捐助信息
	 * @param contributionVo
	 * @param session
	 * @throws Exception
	 */
	@RequestMapping(value = "/addContribution", method = RequestMethod.PUT)
	public Message addContribution(@RequestBody ContributionVo contributionVo,HttpSession session) throws Exception {
		UserVo uvo = loginedUserInfo(session);
		if (uvo != null) {
			contributionVo.setUserId(uvo.getId());
			contributionVo.setName(uvo.getRealname());
			contributionVo.setTel(uvo.getTel());
		}
		return helpService.saveContribution(contributionVo);
	}
	
	/**
	 * 查询孩子信息信息
	 * 
	 */
	@RequestMapping(value="/showChild", method = RequestMethod.POST)
	public ResultVo showChild(@RequestBody ResultVo param) throws Exception {
		return helpService.showChild(param);
	}
}
