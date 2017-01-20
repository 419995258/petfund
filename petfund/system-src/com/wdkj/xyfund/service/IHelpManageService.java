package com.wdkj.xyfund.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.wdkj.xyfund.controller.vo.HelpApplyVo;
import com.wdkj.xyfund.controller.vo.HelpVo;
import com.wdkj.xyfund.controller.vo.Message;
import com.wdkj.xyfund.controller.vo.ResultVo;
import com.wdkj.xyfund.entity.HelpApply;

public interface IHelpManageService {
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
     * 检索所有求助helpApply信息
     * @return
     */
    public ResultVo showAllHelpApply(ResultVo param) throws Exception;
    
    /**
     * 
     * 删除helpApply
     */
    
    public Message deleteHelpApply(HelpApplyVo helpApplyVo) throws Exception;
    
    
    /**
     * 查询helpApply申请的详细信息
     * 
     */
    
    public HelpApplyVo selectHelpApplyData(HelpApplyVo helpApplyVo)throws Exception;
    
    /**
     * 添加紧急筹款
     * 
     */
    
    public Message addChouKuan(HelpVo helpVo)throws Exception;
    
    
    /**
     * 查询紧急筹款信息
     * 
     */
    public ResultVo selectChouKuan(ResultVo param) throws Exception;
    
    /**
     * 删除紧急筹款
     */
    public Message deleteChouKuan(HelpVo helpVo) throws Exception;
    
    /**
     * 查询help紧急筹款的详细信息
     * 
     */
    
    public HelpVo showChouKuanData(HelpVo helpVo)throws Exception;
    
    
    /**
     * 保存临时文件
     */
    public Message saveTempFiles(MultipartFile[] file)throws Exception; 
    
    

    /**
     * 更新紧急筹款
     * 
     */
    
    public Message updateChouKuan(HelpVo helpVo)throws Exception;
    
    /**
     * 
     * 添加汇聚，传递
     */
    public Message addHuiJuOrChuanDi(HelpVo helpVo )throws Exception;
    
    /**
     * 查询汇聚，传递信息
     * 
     */
    public ResultVo selectHuiJuOrChuanDi(ResultVo param) throws Exception;
    
    /**
     * 删除汇聚，传递信息
     */
    public Message deleteHuiJuOrChuanDi(HelpVo helpVo) throws Exception;
    
    /**
     * 查询help汇聚，传递的详细信息
     * 
     */
    
    public HelpVo showHuiJuOrChuanDiData(HelpVo helpVo)throws Exception;
    
    /**
     * 更新汇聚，传递的详细信息
     * 
     */
    
    public Message updateHuiJuOrChuanDi(HelpVo helpVo)throws Exception;
    
    /**
     * 删除临时文件
     * @param param
     * @return
     * @throws Exception
     */
    public Message deleteTempFile(com.wdkj.xyfund.entity.File param) throws Exception;
    
    /**
     * 置顶紧急筹款
     * 
     */
    
    public Message topChouKuan(HelpVo helpVo)throws Exception;
    
    
    /**
     * 置顶汇聚传递
     * 
     */
    
    public Message topHuiJuOrChuanDi(HelpVo helpVo)throws Exception;
    
    /**
     * 通过求助申请
     * 
     */
    
    public Message passHelp(HelpApply helpApply)throws Exception;
}
