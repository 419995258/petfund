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

import com.wdkj.xyfund.controller.vo.LinkVo;
import com.wdkj.xyfund.controller.vo.Message;
import com.wdkj.xyfund.controller.vo.NewsVo;
import com.wdkj.xyfund.controller.vo.PublictiyVo;
import com.wdkj.xyfund.controller.vo.ResultVo;
import com.wdkj.xyfund.entity.Abount;
import com.wdkj.xyfund.service.IOtherManageService;

@RestController
@RequestMapping("/othermanageC")
@Scope("prototype")
public class OtherManageController {

	@Resource(name = "othermanageService")
	private IOtherManageService otherManageService;
	
	/**
	 * 
	 * 查询关于我们信息
	 * @param newsVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/showAboutData", method = RequestMethod.POST)
	public Abount showAboutData(@RequestBody Abount abount) throws Exception {
		return otherManageService.query(abount);
	}
	
	/**
	 * 更新关于我们
	 * @param abount
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateAboutData", method = RequestMethod.PUT)
	public Message updateAboutData(@RequestBody Abount abount) throws Exception{
		return otherManageService.update(abount);
	}
	
	/**
	 * 添加公开透明信息
	 */
	@RequestMapping(value="/addPublictiy",method = RequestMethod.PUT)
	public Message addPublictiy(@RequestBody PublictiyVo publictiyVo) throws Exception{
		return otherManageService.addPublictiy(publictiyVo);
	}
	
	/**
	 * 查询所有的公开透明信息
	 * 
	 */
	@RequestMapping(value="/showPublictiy",method = RequestMethod.POST)
	public ResultVo showPublictiy(@RequestBody ResultVo param) throws Exception{
		return otherManageService.selectPublictiy(param);
	}
	

	/**
	 * 查询公开透明具体信息Byid
	 * 
	 */
	
	@RequestMapping(value="/showPublictiyData", method = RequestMethod.POST)
	public PublictiyVo showPublictiyData(@RequestBody PublictiyVo publictiyVo) throws Exception {
		return otherManageService.showPublictiyData(publictiyVo);
	}
	
	/**
	 * 更新公开透明
	 */
	@RequestMapping(value="/updatePublictiy",method = RequestMethod.PUT)
	public Message updatePublictiy(@RequestBody PublictiyVo publictiyVo) throws Exception{
		return otherManageService.updatePublictiy(publictiyVo);
	}
	
	/**
	 * 删除公开透明信息
	 */
	@RequestMapping(value="/deletePublictiy",method = RequestMethod.PUT)
	public Message deletePublictiy(@RequestBody PublictiyVo publictiyVo) throws Exception{
		return otherManageService.deletePublictiy(publictiyVo);
	}
	
	/**
	 * 添加友情链接信息
	 */
	@RequestMapping(value="/addLink",method = RequestMethod.PUT)
	public Message addLink(@RequestBody LinkVo linkVo) throws Exception{
		return otherManageService.addLink(linkVo);
	}
	
	/**
	 * 查询所有的友情链接信息
	 * 
	 */
	@RequestMapping(value="/showLink",method = RequestMethod.POST)
	public ResultVo showLink(@RequestBody ResultVo param) throws Exception{
		return otherManageService.selectLink(param);
	}
	

	/**
	 * 查询友情链接具体信息Byid
	 * 
	 */
	
	@RequestMapping(value="/showLinkData", method = RequestMethod.POST)
	public LinkVo showLinkData(@RequestBody LinkVo linkVo) throws Exception {
		return otherManageService.showLinkData(linkVo);
	}
	
	/**
	 * 更新友情链接
	 */
	@RequestMapping(value="/updateLink",method = RequestMethod.PUT)
	public Message updateLink(@RequestBody LinkVo linkVo) throws Exception{
		return otherManageService.updateLink(linkVo);
	}
	
	/**
	 * 删除公开透明信息
	 */
	@RequestMapping(value="/deleteLink",method = RequestMethod.PUT)
	public Message deleteLink(@RequestBody LinkVo linkVo) throws Exception{
		return otherManageService.deleteLink(linkVo);
	}
	
	/**
	 * 添加友情链接信息
	 */
	@RequestMapping(value="/addThanks",method = RequestMethod.PUT)
	public Message addThanks(@RequestBody LinkVo linkVo) throws Exception{
		return otherManageService.addThanks(linkVo);
	}
	
	/**
	 * 更新友情链接
	 */
	@RequestMapping(value="/updateThanks",method = RequestMethod.PUT)
	public Message updateThanks(@RequestBody LinkVo linkVo) throws Exception{
		return otherManageService.updateThanks(linkVo);
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
			Message m = otherManageService.saveTempFiles(file);
			
			dataMap.put("success", m.getSuccess());
			if (m.getSuccess()) {
				dataMap.put("fileId", m.getResult().get("fileId"));
				dataMap.put("fileUrl", m.getResult().get("fileUrl"));
			}
			return dataMap;
	    }
}
