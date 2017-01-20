package com.wdkj.xyfund.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.wdkj.xyfund.controller.vo.Message;
import com.wdkj.xyfund.controller.vo.NewsVo;
import com.wdkj.xyfund.controller.vo.ResultVo;

public interface INewsManageService {
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
     * 
     * 添加news
     */
    public Message addNews(NewsVo newsVo )throws Exception;
    
    /**
     * 查询news信息
     * 
     */
    public ResultVo selectNews(ResultVo param) throws Exception;
    
    /**
     * 删除news信息
     */
    public Message deleteNews(NewsVo newsVo) throws Exception;
    
    /**
     * 查询news详细信息
     * 
     */
    
    public NewsVo showNewsData(NewsVo newsVo)throws Exception;
    
    /**
     * 更新news详细信息
     * 
     */
    
    public Message updateNews(NewsVo newsVo)throws Exception;
    
     /**
      * 保存临时文件
      * @param file
      * @return
      * @throws Exception
      */
    public Message saveTempFiles(MultipartFile[] file,Integer type) throws Exception;
    
    /**
     * 查询封面url信息
     * 
     */
    
    public Message queryFengmian(Integer type)throws Exception;
}
