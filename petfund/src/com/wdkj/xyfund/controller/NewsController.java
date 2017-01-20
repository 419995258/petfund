package com.wdkj.xyfund.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wdkj.xyfund.controller.vo.DictionaryVo;
import com.wdkj.xyfund.controller.vo.Message;
import com.wdkj.xyfund.controller.vo.NewsVo;
import com.wdkj.xyfund.controller.vo.ResultVo;
import com.wdkj.xyfund.entity.Dictionary;
import com.wdkj.xyfund.service.IDictionaryService;
import com.wdkj.xyfund.service.INewsService;
import com.wdkj.xyfund.util.BizUtil;

/**
 * 
* <p>Title: BaseBizDataController</p>
* <p>Description: 新闻中心控制层</p>
* <p>Company: </p>
* @author Steven
* @date 2016年7月31日 下午12:38:50
 */
@RestController
@RequestMapping("/newsC")
@Scope("prototype")
public class NewsController extends BasicController {
	@Resource(name = "newsService")
	private INewsService newsService;
	
	/**
	 * 查询新闻
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryNews", method = RequestMethod.POST)
	public ResultVo queryNews(@RequestBody ResultVo param, HttpSession session)throws Exception{
		return newsService.queryByType(param);
	}
	
	/**
	 * 查询新闻(首页)
	 * @param param
	 * @param session
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryNewsIndex", method = RequestMethod.POST)
	public ResultVo queryNewsIndex(@RequestBody ResultVo param, HttpSession session)throws Exception{
		param.setPageSize("7");
		param.setCurrentpage("1");
		return newsService.queryByType(param);
	}
	
	/**
	 * 查询单条新闻
	 * @param id
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryInfo", method = RequestMethod.POST)
	public NewsVo queryInfo(@RequestBody Integer id, HttpSession session)throws Exception{
		return newsService.queryById(id);
	}
}
