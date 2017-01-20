package com.wdkj.xyfund.service;

import java.util.List;

import com.wdkj.xyfund.controller.vo.Message;
import com.wdkj.xyfund.controller.vo.ResultVo;
import com.wdkj.xyfund.entity.User;

public interface IAdminService {

	Message login(User lu) throws Exception;
	
	  /**
     * 检索管理员登录日志
     * @return
     */
    public ResultVo showLoginLog(ResultVo param) throws Exception;

    public void setReturnPageInfo(Integer pagesize, Integer currentpage,
			List pos, ResultVo resultVo) throws Exception;
    
    public void setPageInfo(Integer pagesize, Integer currentpage);
}
