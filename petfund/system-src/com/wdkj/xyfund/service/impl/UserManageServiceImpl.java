package com.wdkj.xyfund.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wdkj.xyfund.controller.vo.FileVo;
import com.wdkj.xyfund.controller.vo.Message;
import com.wdkj.xyfund.controller.vo.PostulantVo;
import com.wdkj.xyfund.controller.vo.ResultVo;
import com.wdkj.xyfund.controller.vo.UserVo;
import com.wdkj.xyfund.dao.FileMapper;
import com.wdkj.xyfund.dao.PostulantFilesMapper;
import com.wdkj.xyfund.dao.PostulantMapper;
import com.wdkj.xyfund.dao.PostulantServiceSkillMapper;
import com.wdkj.xyfund.dao.UserMapper;
import com.wdkj.xyfund.entity.File;
import com.wdkj.xyfund.entity.FileExample;
import com.wdkj.xyfund.entity.Postulant;
import com.wdkj.xyfund.entity.PostulantExample;
import com.wdkj.xyfund.entity.PostulantFiles;
import com.wdkj.xyfund.entity.PostulantFilesExample;
import com.wdkj.xyfund.entity.PostulantServiceSkillExample;
import com.wdkj.xyfund.entity.User;
import com.wdkj.xyfund.entity.UserExample;
import com.wdkj.xyfund.entity.UserExample.Criteria;
import com.wdkj.xyfund.service.IUserManageService;
import com.wdkj.xyfund.util.DateUtil;
import com.wdkj.xyfund.util.FileOperationUtil;
import com.wdkj.xyfund.util.ObjectUtil;
import com.wdkj.xyfund.util.StringContentUtil;

@Service("usermanageService")
public class UserManageServiceImpl implements IUserManageService {
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private PostulantMapper postulantMapper;
	
	@Autowired
	private PostulantFilesMapper postulantFilesMapper;
	
	@Autowired
	private FileMapper fileMapper;
	
	@Autowired
	private PostulantServiceSkillMapper postulantServiceSkillMapper;
	

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

	/**
	 * 查询 所有user
	 */
	@Override
	public ResultVo showAllUsers(ResultVo param) throws Exception {
		// TODO Auto-generated method stub
		ResultVo resultVo = new ResultVo();
		List<UserVo> userVos = new ArrayList<UserVo>();

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
		
		UserExample userExample = new UserExample();
		Criteria cr = userExample.createCriteria();
		cr.andStatusEqualTo(1).andIdNotEqualTo(1);
		userExample.setOrderByClause("id desc");
		//查询不同种类
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
				
		
		List<User> users = userMapper.selectByExample(userExample);

		if (!ObjectUtil.collectionIsEmpty(users)) {

			for (Iterator iterator = users.iterator(); iterator.hasNext();) {
				User user = (User) iterator.next();
				UserVo temp = new UserVo();
				BeanUtils.copyProperties(temp, user);
				Date registerDate = user.getRegisterDate();
				temp.setRegisterDateStr(DateUtil.getDateStr(
						DateUtil.DATE_STYLE4, registerDate));
				userVos.add(temp);
			}

		}

		this.setReturnPageInfo(psize, pageNum, users, resultVo);
		resultVo.setRows(userVos);
		return resultVo;
	}

	/**
	 * 删除用户user
	 * 
	 */
	@Override
	public Message deleteUserById(UserVo param) throws Exception {
		// TODO Auto-generated method stub
		Message message = new Message();
		User user = new User();
		BeanUtils.copyProperties(user, param);
		user.setStatus(0);

		// 删除登记信息
		int record = userMapper.updateByPrimaryKey(user);
		if (record > 0) {
			message.setSuccess(true);
		}

		return message;
	}

	/**
	 * 检索所有user表的postulant志愿者信息
	 */
	@Override
	public ResultVo selectAllPostulant(ResultVo param) throws Exception {
		// TODO Auto-generated method stub
		
		
		ResultVo resultVo = new ResultVo();
		List<UserVo> userVos = new ArrayList<UserVo>();

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
		UserExample userExample = new UserExample();
		Criteria cr = userExample.createCriteria();
		cr.andTypeEqualTo(2);
		userExample.setOrderByClause("id desc");
		
		//查询不同种类
		Integer queryType = param.getQueryType();
		
		if (queryType == 1) {
			cr.andRegisterDateEqualTo(DateUtil.parseDate(DateUtil.DATE_STYLE4, param.getQueryText()));
		} else if (queryType == 2) {
			cr.andEmailLike(param.getQueryText());
		}else if(queryType ==3){
			cr.andRealnameLike(param.getQueryText());
		}else if(queryType ==4){
			cr.andTelLike(param.getQueryText());
		}
		
		List<User> users = userMapper.selectByExample(userExample);
		
		if (!ObjectUtil.collectionIsEmpty(users)) {

			for (Iterator iterator = users.iterator(); iterator.hasNext();) {
				User user = (User) iterator.next();
				UserVo temp = new UserVo();
				BeanUtils.copyProperties(temp, user);
				Date registerDate = user.getRegisterDate();
				temp.setRegisterDateStr(DateUtil.getDateStr(
						DateUtil.DATE_STYLE4, registerDate));
				userVos.add(temp);
			}

		}
		
		/*if (!ObjectUtil.collectionIsEmpty(postulants)) {

			for (Iterator iterator = postulants.iterator(); iterator.hasNext();) {
				Postulant postulant= (Postulant) iterator.next();
				PostulantVo temp = new PostulantVo();
				BeanUtils.copyProperties(temp, postulant);
				Date registerDate = user.getRegisterDate();
				temp.setRegisterDateStr(DateUtil.getDateStr(
						DateUtil.DATE_STYLE4, registerDate));
				userVos.add(temp);
			}*/

		this.setReturnPageInfo(psize, pageNum, users, resultVo);
		resultVo.setRows(userVos);
		return resultVo;
		
	}
	  /**
     * 删除用户志愿者身份
     * @param param
     * @return
     * @throws Exception
     */
	@Override
	public Message deletePostulantById(UserVo userVo) throws Exception {
		Message message = new Message();
		int id = userVo.getId();
		User user = new User();
		user = userMapper.selectByPrimaryKey(id);
		if(user != null){
			user.setIsPostulant(false);
			user.setType(1);
			
			int record = userMapper.updateByPrimaryKey(user);
			//删除postulant_file表
			PostulantExample postulantExample = new PostulantExample();
			postulantExample.createCriteria().andUserIdEqualTo(id);//获取postulant的Id
			Postulant postulant = new Postulant();
			List<Postulant> postulants = postulantMapper.selectByExample(postulantExample);
			int postulantId = 0;
			if(!ObjectUtil.collectionIsEmpty(postulants)){
				postulant = postulants.get(0);
				postulantId = postulant.getId();
				postulantFilesMapper.deleteByPrimaryKey(postulantId);
			}
			//删除postulant_file_skill表
			if(postulantId != 0){
				PostulantServiceSkillExample postulantServiceSkillExample = new PostulantServiceSkillExample();
				postulantServiceSkillExample.createCriteria().andPostulantIdEqualTo(postulantId);
				int x = postulantServiceSkillMapper.deleteByExample(postulantServiceSkillExample);
			}
			//删除postulant表
			int record2 = postulantMapper.deleteByExample(postulantExample);
			if(record2>0){
			//删除文件
			FileExample fileExample = new FileExample();
			fileExample.createCriteria().andUserIdEqualTo(id);
			File file = new File();
			List<File> files = new ArrayList<>();
			files = fileMapper.selectByExample(fileExample);
			if(!ObjectUtil.collectionIsEmpty(files)){
				for (Iterator iterator = files.iterator(); iterator.hasNext();) {
					file = (File) iterator.next();
					FileOperationUtil.deleteFile2(file.getFileurl());
				}
			}
			fileMapper.deleteByExample(fileExample);
			}
			
			
			if (record > 0 &&record2 > 0) {
				message.setSuccess(true);
			}
		}
		return message;
	}

	/**
     * 检索postulant具体信息
     * @return
     */
	
	@Override
	public PostulantVo showPostulant(UserVo userVo) throws Exception {
		PostulantVo postulantVo = new PostulantVo();
		Postulant postulant = new Postulant();
		int id = userVo.getId();
		PostulantExample queryEx = new PostulantExample();
		queryEx.createCriteria().andUserIdEqualTo(id);
		List<Postulant> postulants = postulantMapper.selectByExample(queryEx);
		
		if (!ObjectUtil.collectionIsEmpty(postulants)) {
			postulant = postulants.get(0);
			BeanUtils.copyProperties(postulantVo, postulant);
			Date date1 = postulant.getBirthday();
			Date date2 = postulant.getIsServiceDate();
			Date date3 = postulant.getServiceDate();
			Date date4 = postulant.getTrainingDate();
			if(date1 != null){
				postulantVo.setBirthdayStr(DateUtil.getDateStr(DateUtil.DATE_STYLE4,date1));
			}
			
			if(date2 != null){
				postulantVo.setIsServiceDateStr(DateUtil.getDateStr(DateUtil.DATE_STYLE4,date2));
			}
			if(date3!=null){
				postulantVo.setServiceDateStr(DateUtil.getDateStr(DateUtil.DATE_STYLE4,date3));
			}
			if(date4!=null){
				postulantVo.setTrainingDateStr(DateUtil.getDateStr(DateUtil.DATE_STYLE4,date4));
			}
			
			List<File> postulantFilesUrls = fileMapper.selectFileUrlFromPostulantByPrimaryKey(postulant.getId());
			List<FileVo> postulantFilesUrl = new ArrayList<FileVo>();
			
			if(!ObjectUtil.collectionIsEmpty(postulantFilesUrls)){
				for (Iterator iterator = postulantFilesUrls.iterator();
						iterator.hasNext();) {
					File file = (File) iterator.next();
					FileVo fileVo = new FileVo();
					BeanUtils.copyProperties(fileVo, file);
					fileVo.setFileurl(file.getFileurl());
					postulantFilesUrl.add(fileVo);
				}
			}
			 
			postulantVo.setPostulantFilesUrl(postulantFilesUrl);
		}
		
		return postulantVo;

	}

	
	
	
	/*
	 * (non-Javadoc)
	 * @see com.wdkj.xyfund.service.IUserManageService#surePostulant(com.wdkj.xyfund.entity.User)
	 */
	@Override
	public Message surePostulant(User user) throws Exception {
		// TODO Auto-generated method stub
		Message message = new Message();
		if(user.getIsPostulant() == true){
			user.setIsPostulant(false);	
		}else{
			user.setIsPostulant(true);
		}
		userMapper.updateByPrimaryKey(user);
		message.setSuccess(true);
		return message;
	}
	
	

}
