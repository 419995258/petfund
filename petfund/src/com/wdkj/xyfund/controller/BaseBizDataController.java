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
import com.wdkj.xyfund.controller.vo.UserVo;
import com.wdkj.xyfund.entity.Dictionary;
import com.wdkj.xyfund.service.IDictionaryService;
import com.wdkj.xyfund.service.IUserService;
import com.wdkj.xyfund.util.BizUtil;

/**
 * 
* <p>Title: BaseBizDataController</p>
* <p>Description: 平台使用的基础业务数据查询的控制层</p>
* <p>Company: </p>
* @author Steven
* @date 2016年7月31日 下午12:38:50
 */
@RestController
@RequestMapping("/baseBizDataC")
@Scope("prototype")
public class BaseBizDataController extends BasicController {
	@Resource(name = "dictionaryService")
	private IDictionaryService dictionaryService;
	
	@Resource(name = "userService")
	private IUserService userService;
	
	/**
	 * 查询平台中的服务项目和专业技能字典数据
	 * @return
	 * @throws Exception
	 */
	 @RequestMapping(value = "/queryServiceAndSkill", method = RequestMethod.POST)
	public Map<String, List<DictionaryVo>> queryServiceAndSkill()throws Exception{
		List<DictionaryVo> services = dictionaryService.queryByType(BizUtil.DIC_TYPE1);//查询服务项目字典数据
		List<DictionaryVo> skills = dictionaryService.queryByType(BizUtil.DIC_TYPE2);//查询专业技能字典数据
		
		Map<String, List<DictionaryVo>> dics = new HashMap<String, List<DictionaryVo>>();
		dics.put("servcies", services);
		dics.put("skills", skills);
		
		return dics;
	}
	 
	/**
	 * 根据用户类型查询用户信息
	 * @param type
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryPersons", method = RequestMethod.POST)
	public List<UserVo> queryPersons(@RequestBody Integer type)throws Exception{
		return userService.queryByType(type);
	}
	
	
	/**
	 * 查询平台中的服务项目和专业技能
	 * @return
	 * @throws Exception
	 */
	 @RequestMapping(value = "/queryServiceSkill", method = RequestMethod.POST)
	public Map<String, List<DictionaryVo>> queryServiceSkill(@RequestBody Integer id)throws Exception{
		List<DictionaryVo> services = dictionaryService.queryService(id);//查询服务项目字典数据
		List<DictionaryVo> skills = dictionaryService.querySkill(id);//查询专业技能字典数据
		
		Map<String, List<DictionaryVo>> dics = new HashMap<String, List<DictionaryVo>>();
		dics.put("servcies", services);
		dics.put("skills", skills);
		
		return dics;
	}
}
