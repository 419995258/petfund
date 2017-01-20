package com.wdkj.xyfund.service;

import java.util.List;

import com.wdkj.xyfund.controller.vo.Message;
import com.wdkj.xyfund.controller.vo.PostulantVo;
import com.wdkj.xyfund.controller.vo.ResultVo;
import com.wdkj.xyfund.controller.vo.UserVo;
import com.wdkj.xyfund.entity.User;


public interface IUserManageService {

	/**
     * 设置分页初始信息
     * @param pagesize
     * @param currentpage
     */
    public  void setPageInfo(Integer pagesize,Integer currentpage);
    
    /**
     * 设置返回的分页信息
     * @param pagesize
     * @param currentpage
     * @param pos
     * @param resultVo
     */
    public	void  setReturnPageInfo(Integer pagesize,Integer currentpage,List pos,ResultVo resultVo) throws Exception;
    
    /**
     * 检索所有用户
     * @return
     */
    public ResultVo showAllUsers(ResultVo param) throws Exception;
    
    /**
     * 删除用户
     * @param param
     * @return
     * @throws Exception
     */
    public Message deleteUserById(UserVo param) throws Exception;
    
    /**
     * 检索所有user表的postulant志愿者信息
     * @param param
     * @return
     * @throws Exception
     */
    public ResultVo selectAllPostulant(ResultVo param) throws Exception;
    
    /**
     * 删除用户志愿者身份
     * @param param
     * @return
     * @throws Exception
     */
    public Message deletePostulantById(UserVo userVo) throws Exception;
    
    /**
     * 检索postulant具体信息
     * @return
     */
    public PostulantVo showPostulant(UserVo userVo) throws Exception;
    
    
    /**
     * 认证志愿者
     * @param postulantVo
     * @return
     * @throws Exception
     */
    public Message surePostulant(User user) throws Exception;
    
}
