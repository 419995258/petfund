package com.wdkj.xyfund.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wdkj.xyfund.controller.vo.HelpApplyVo;
import com.wdkj.xyfund.controller.vo.HelpVo;
import com.wdkj.xyfund.controller.vo.Message;
import com.wdkj.xyfund.controller.vo.ResultVo;
import com.wdkj.xyfund.entity.File;
import com.wdkj.xyfund.entity.HelpApply;
import com.wdkj.xyfund.service.IHelpManageService;


@RestController
@RequestMapping("/helpmanageC")
@Scope("prototype")
public class HelpManageController {

	@Resource(name = "helpmanageService")
	private IHelpManageService helpManageService;
	
	/**
	 * 查询所有help信息
	 * 
	 */
	@RequestMapping(value="/showHelp", method = RequestMethod.POST)
	public ResultVo ShowAllHelp(@RequestBody ResultVo param) throws Exception {
		return helpManageService.showAllHelpApply(param);
	}
	
	
	/**
	 * 删除helpApplyById
	 */
	@RequestMapping(value="/deleteHelpApply",method = RequestMethod.PUT)
	public Message deleteHelpApply(@RequestBody HelpApplyVo helpApplyVo) throws Exception{
		return helpManageService.deleteHelpApply(helpApplyVo);
	}
	
	
	
	/**
	 * 查询helpApply具体信息Byid
	 * 
	 */
	
	@RequestMapping(value="/showHelpApplyData", method = RequestMethod.POST)
	public HelpApplyVo showHelpApplyData(@RequestBody HelpApplyVo helpApplyVo) throws Exception {
		return helpManageService.selectHelpApplyData(helpApplyVo);
	}
	
	
	
	/**
	 * 查询所有的紧急筹款
	 * 
	 */
	@RequestMapping(value="/showChouKuan",method = RequestMethod.POST)
	public ResultVo showChouKuan(@RequestBody ResultVo param) throws Exception{
		return helpManageService.selectChouKuan(param);
	}
	
	/**
	 * 删除紧急筹款
	 */
	@RequestMapping(value="/deleteChouKuan",method = RequestMethod.PUT)
	public Message deleteChouKuan(@RequestBody HelpVo helpVo) throws Exception{
		return helpManageService.deleteChouKuan(helpVo);
	}
	
	/**
	 * 查询help-紧急筹款具体信息Byid
	 * 
	 */
	
	@RequestMapping(value="/showChouKuanData", method = RequestMethod.POST)
	public HelpVo showChouKuanData(@RequestBody HelpVo helpVo) throws Exception {
		return helpManageService.showChouKuanData(helpVo);
	}
	
	
	/**
	 * 添加紧急筹款信息
	 */
	@RequestMapping(value="/addChouKuan",method = RequestMethod.PUT)
	public Message addChouKuan(@RequestBody HelpVo helpVo) throws Exception{
		return helpManageService.addChouKuan(helpVo);
	}
	
	
	/**
	 * 上传图片临时保存文件
	 * @param file
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/uploadTemp",method = RequestMethod.POST)
	 public Map<String, Object> uploadTemp(@RequestParam("imgs") MultipartFile[] file) throws Exception {
			Map dataMap = new HashMap();
			//Integer orgId = (Integer) session.getAttribute("currentOrgId");
			Message m = helpManageService.saveTempFiles(file);
			
			dataMap.put("success", m.getSuccess());
			if (m.getSuccess()) {
				dataMap.put("fileId", m.getResult().get("fileId"));
				dataMap.put("fileUrl", m.getResult().get("fileUrl"));
			}
			return dataMap;
	    }
	
	/**
	 * 更新紧急筹款信息
	 */
	@RequestMapping(value="/updateChouKuan",method = RequestMethod.PUT)
	public Message updateChouKuan(@RequestBody HelpVo helpVo) throws Exception{
		return helpManageService.updateChouKuan(helpVo);
	}
	

	/**
	 * 添加汇聚，传递信息
	 */
	@RequestMapping(value="/addHuiJuOrChuanDi",method = RequestMethod.PUT)
	public Message addHuiJuOrChuanDi(@RequestBody HelpVo helpVo) throws Exception{
		return helpManageService.addHuiJuOrChuanDi(helpVo);
	}
	
	/**
	 * 查询所有的汇聚，传递信息
	 * 
	 */
	@RequestMapping(value="/showHuiJuOrChuanDi",method = RequestMethod.POST)
	public ResultVo showHuiJuOrChuanDi(@RequestBody ResultVo param) throws Exception{
		return helpManageService.selectHuiJuOrChuanDi(param);
	}
	

	/**
	 * 查询help-汇聚，传递具体信息Byid
	 * 
	 */
	
	@RequestMapping(value="/showHuiJuOrChuanDiData", method = RequestMethod.POST)
	public HelpVo showHuiJuOrChuanDiData(@RequestBody HelpVo helpVo) throws Exception {
		return helpManageService.showHuiJuOrChuanDiData(helpVo);
	}
	
	/**
	 * 更新汇聚，传递信息
	 */
	@RequestMapping(value="/updateHuiJuOrChuanDi",method = RequestMethod.PUT)
	public Message updateHuiJuOrChuanDi(@RequestBody HelpVo helpVo) throws Exception{
		return helpManageService.updateHuiJuOrChuanDi(helpVo);
	}
	
	/**
	 * 删除汇聚，传递信息
	 */
	@RequestMapping(value="/deleteHuiJuOrChuanDi",method = RequestMethod.PUT)
	public Message deleteHuiJuOrChuanDi(@RequestBody HelpVo helpVo) throws Exception{
		return helpManageService.deleteHuiJuOrChuanDi(helpVo);
	}
	
	/**
	 * 删除申请志愿者的临时文件
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delPayFiles", method = RequestMethod.PUT)
	public Message delPayFiles(@RequestBody File param) throws Exception {
		return helpManageService.deleteTempFile(param);
	}
	
	/**
	 * 更新置顶筹款
	 */
	@RequestMapping(value="/topChouKuan",method = RequestMethod.PUT)
	public Message topChouKuan(@RequestBody HelpVo helpVo) throws Exception{
		return helpManageService.topChouKuan(helpVo);
	}
	
	/**
	 * 更新置顶汇聚传递
	 */
	@RequestMapping(value="/topHuiJuOrChuanDi",method = RequestMethod.PUT)
	public Message topHuiJuOrChuanDi(@RequestBody HelpVo helpVo) throws Exception{
		return helpManageService.topHuiJuOrChuanDi(helpVo);
	}
	
	
	/**
	 * 删除紧急筹款
	 */
	@RequestMapping(value="/passHelp",method = RequestMethod.PUT)
	public Message passHelp(@RequestBody HelpApply helpApply) throws Exception{
		return helpManageService.passHelp(helpApply);
	}
}
