package com.wdkj.xyfund.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wdkj.xyfund.controller.vo.AdminLoginLogVo;
import com.wdkj.xyfund.controller.vo.Message;
import com.wdkj.xyfund.controller.vo.ResultVo;
import com.wdkj.xyfund.controller.vo.UserVo;
import com.wdkj.xyfund.dao.AdminLoginLogMapper;
import com.wdkj.xyfund.dao.UserMapper;
import com.wdkj.xyfund.entity.AdminLoginLog;
import com.wdkj.xyfund.entity.AdminLoginLogExample;
import com.wdkj.xyfund.entity.User;
import com.wdkj.xyfund.entity.UserExample;
import com.wdkj.xyfund.entity.UserExample.Criteria;
import com.wdkj.xyfund.service.IAdminService;
import com.wdkj.xyfund.util.DateUtil;
import com.wdkj.xyfund.util.ObjectUtil;
import com.wdkj.xyfund.util.StringContentUtil;

@Repository("adminService")
@Scope("prototype")
public class AdminServiceImpl implements IAdminService {
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private AdminLoginLogMapper adminLoginLogMapper;

	public Message login(User lu) throws Exception {
		Message message = new Message();
		
		UserExample luExample = new UserExample();
		luExample.createCriteria().andUsernameEqualTo(lu.getUsername()).andPasswordEqualTo(lu.getPassword()).andIsSuperuserEqualTo(true);
		List<User> lulist = userMapper.selectByExample(luExample);
		
		if (lulist.size()!=0) {
			Map<String,User> result = new HashMap<String,User>();
			User u = lulist.get(0);
			result.put("user", u);
			//message.setMessage(u.getType());
			message.setResult(result);
			message.setSuccess(true);
			
			AdminLoginLog all = new AdminLoginLog();
			all.setLoginDate(new Date());
			all.setUserId(u.getId());
			all.setUsername(u.getUsername());
			all.setRealname(u.getRealname());
			adminLoginLogMapper.insert(all);
		} else {
			message.setSuccess(false);
		}
		return message;
	}

	
	/**
	 * 设置分页初始信息
	 * 
	 * @param pagesize
	 * @param currentpage
	 */
	@Override
	public void setPageInfo(Integer pagesize, Integer currentpage) {
		// TODO Auto-generated method stub
		if (pagesize != null || currentpage != null) {// 分页信息设置
			if (pagesize == null) {
				pagesize = 10;
			}
			if (currentpage == null) {
				currentpage = 1;
			}
			PageHelper.startPage(currentpage, pagesize);
		}

	}

	/**
	 * 设置返回的分页信息
	 * 
	 * @param pagesize
	 * @param currentpage
	 * @param pos
	 * @param resultVo
	 */
	@Override
	public void setReturnPageInfo(Integer pagesize, Integer currentpage,
			List pos, ResultVo resultVo) throws Exception {
		// TODO Auto-generated method stub
		if (pagesize != null || currentpage != null) {
			// 分页信息设置
			Page p = (Page) pos;

			resultVo.setCurrentpage(ObjectUtil.convToString(p.getPageNum()));
			resultVo.setTotal(ObjectUtil.convToString(p.getTotal()));

			resultVo.setPageNum(ObjectUtil.convToString(p.getPageNum()));

			resultVo.setPageSize(ObjectUtil.convToString(p.getPageSize()));

			int pages = p.getPages();
			resultVo.setPages(ObjectUtil.convToString(pages));
		}

	}
	
	/*
	 * (non-Javadoc)
	 * @see com.wdkj.xyfund.service.IAdminService#showLoginLog(com.wdkj.xyfund.controller.vo.ResultVo)
	 */
	public ResultVo showLoginLog(ResultVo param) throws Exception {
		// TODO Auto-generated method stub
		ResultVo resultVo = new ResultVo();
		List<AdminLoginLogVo> AdminLoginLogVos = new ArrayList<AdminLoginLogVo>();

		/*
		 * Integer pagesize = Integer.parseInt(param.getPageSize()); Integer
		 * currentpage = Integer.parseInt(param.getCurrentpage());
		 */
		String pagesize = param.getPageSize();
		String currentpage = param.getCurrentpage();

		int pageNum = 1;
		int psize = 10;

		if (StringContentUtil.isNoEmpty(pagesize)) {
			psize = ObjectUtil.convToInteger(pagesize);
		}

		if (StringContentUtil.isNoEmpty(currentpage)) {
			pageNum = ObjectUtil.convToInteger(currentpage);
		}
		this.setPageInfo(psize, pageNum);
		
		AdminLoginLogExample adminLoginLogExample= new AdminLoginLogExample();
		adminLoginLogExample.setOrderByClause("id desc");
		/*//查询不同种类
				Integer queryType = param.getQueryType();
				
				if (queryType == 1) {
					cr.andRegisterDateEqualTo(DateUtil.parseDate(DateUtil.DATE_STYLE4, param.getQueryText()));
				} else if (queryType == 2) {
					cr.andRealnameLike(param.getQueryText());
				}else if(queryType ==3){
					cr.andEmailLike(param.getQueryText());
				}else if(queryType ==4){
					cr.andTelLike(param.getQueryText());
				}
				
		*/
		List<AdminLoginLog> logs= adminLoginLogMapper.selectByExample(adminLoginLogExample);

		if (!ObjectUtil.collectionIsEmpty(logs)) {

			for (Iterator iterator = logs.iterator(); iterator.hasNext();) {
				AdminLoginLog adminLoginLog= (AdminLoginLog) iterator.next();
				AdminLoginLogVo temp = new AdminLoginLogVo();
				BeanUtils.copyProperties(temp, adminLoginLog);
				Date loginDate = adminLoginLog.getLoginDate();
				temp.setLoginDateStr(DateUtil.getDateStr(
						DateUtil.DATE_STYLE5, loginDate));
				AdminLoginLogVos.add(temp);
			}

		}

		this.setReturnPageInfo(psize, pageNum, logs, resultVo);
		resultVo.setRows(AdminLoginLogVos);
		return resultVo;
	}
	
	
	
	
}
