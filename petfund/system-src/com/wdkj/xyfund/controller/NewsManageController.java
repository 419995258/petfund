package com.wdkj.xyfund.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wdkj.xyfund.controller.vo.Message;
import com.wdkj.xyfund.controller.vo.NewsVo;
import com.wdkj.xyfund.controller.vo.ResultVo;
import com.wdkj.xyfund.service.INewsManageService;


@RestController
@RequestMapping("/newsmanageC")
@Scope("prototype")
public class NewsManageController {

	@Resource(name = "newsmanageService")
	private INewsManageService newsManageService;
	
	/**
	 * 添加汇聚，传递信息
	 */
	@RequestMapping(value="/addNews",method = RequestMethod.PUT)
	public Message addNews(@RequestBody NewsVo newsVo) throws Exception{
		return newsManageService.addNews(newsVo);
	}
	
	/**
	 * 查询所有的汇聚，传递信息
	 * 
	 */
	@RequestMapping(value="/showNews",method = RequestMethod.POST)
	public ResultVo showNews(@RequestBody ResultVo param) throws Exception{
		return newsManageService.selectNews(param);
	}
	

	/**
	 * 查询help-汇聚，传递具体信息Byid
	 * 
	 */
	
	@RequestMapping(value="/showNewsData", method = RequestMethod.POST)
	public NewsVo showNewsData(@RequestBody NewsVo newsVo) throws Exception {
		return newsManageService.showNewsData(newsVo);
	}
	
	/**
	 * 更新汇聚，传递信息
	 */
	@RequestMapping(value="/updateNews",method = RequestMethod.PUT)
	public Message updateNews(@RequestBody NewsVo newsVo) throws Exception{
		return newsManageService.updateNews(newsVo);
	}
	
	/**
	 * 删除汇聚，传递信息
	 */
	@RequestMapping(value="/deleteNews",method = RequestMethod.PUT)
	public Message deleteNews(@RequestBody NewsVo newsVo) throws Exception{
		return newsManageService.deleteNews(newsVo);
	}
	
	
	/**
	 * 上传图片临时保存文件
	 * @param file
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/uploadTemp/{type}",method = RequestMethod.POST)
	 public Map<String, Object> uploadTemp(@RequestParam("imgs") MultipartFile[] file,@PathVariable Integer type) throws Exception {
			Map dataMap = new HashMap();
			//Integer orgId = (Integer) session.getAttribute("currentOrgId");
			Message m = newsManageService.saveTempFiles(file, type);
			
			dataMap.put("success", m.getSuccess());
			if (m.getSuccess()) {
				dataMap.put("fileId", m.getResult().get("fileId"));
				dataMap.put("fileUrl", m.getResult().get("fileUrl"));
			}
			return dataMap;
	    }
	

	/**
	 * 查询封面url
	 * 
	 */
	
	@RequestMapping(value="/queryFengmian", method = RequestMethod.POST)
	public Message queryFengmian(@RequestBody Integer type) throws Exception {
		return newsManageService.queryFengmian(type);
	}
}
