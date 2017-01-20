package com.wdkj.xyfund.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.wdkj.xyfund.controller.vo.Message;
import com.wdkj.xyfund.controller.vo.NewsVo;
import com.wdkj.xyfund.controller.vo.UserVo;
import com.wdkj.xyfund.dao.NewsMapper;
import com.wdkj.xyfund.dao.UserMapper;
import com.wdkj.xyfund.entity.News;
import com.wdkj.xyfund.entity.User;
import com.wdkj.xyfund.entity.UserExample;
import com.wdkj.xyfund.service.IUserService;
import com.wdkj.xyfund.util.Const;
import com.wdkj.xyfund.util.DateUtil;
import com.wdkj.xyfund.util.FileOperationUtil;
import com.wdkj.xyfund.util.ObjectUtil;
import com.wdkj.xyfund.util.StringContentUtil;

@Repository("userService")
@Scope("prototype")
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private NewsMapper newsMapper;

	/**
	 * 新增用户
	 * 
	 * @param user
	 * @throws Exception
	 */
	public Message userRegister(User user) throws Exception {
		Message message = new Message();
		
		if (user != null) {
			UserExample ue = new UserExample();
			ue.createCriteria().andUsernameEqualTo(user.getUsername());
			List<User> userlist = userMapper.selectByExample(ue);
			if (userlist.size() > 0) {
				message.setMessage("该邮箱已注册,请登录");
				message.setSuccess(false);
			}
			
			ue.createCriteria().andTelEqualTo(user.getTel());
			userlist = userMapper.selectByExample(ue);
			if (userlist.size() > 0) {
				message.setMessage("该手机号已注册,请登录");
				message.setSuccess(false);
			}
			
			Date registerDate = DateUtil.getCurrentDate(DateUtil.DATE_STYLE4);
			user.setEmail(user.getUsername());
			user.setRegisterDate(registerDate);
			user.setIsPostulant(false);
			user.setIsSuperuser(false);
			user.setStatus(1);
			user.setType(1);
			user.setCount(0);
			user.setCardNumber("");
			user.setRealname("");
			
			int record = userMapper.insert(user);
			
			if (record > 0) {
				Map result = new HashMap();
				result.put("user", user);
				message.setResult(result);
				message.setSuccess(true);
			}
		}
		
		return message;
	}

	/**
	 * 验证用户是否已经存在
	 * @param user
	 * @throws Exception
	 */
	public Message checkUsername(User user) throws Exception {
		Message message = new Message();
		UserExample ue = new UserExample();
		//查询是否存在相同用户名
		ue.createCriteria().andUsernameEqualTo(user.getUsername());
		List<User> userlist = userMapper.selectByExample(ue);
		if (userlist.size() == 0) {
			message.setSuccess(true);
		} else {
			message.setMessage("用户名重复");
			message.setSuccess(false);
		}
		
		return message;
	}

	/**
	 * 验证用户手机号是否已经存在
	 * @param user
	 * @throws Exception
	 */
	public Message checkUseTel(User user) throws Exception {
		// TODO Auto-generated method stub
		UserExample ue = new UserExample();
		Message message = new Message();
		try {
			//查询是否存在相同手机号
			ue.createCriteria().andTelEqualTo(user.getTel());
			List<User> userlist = userMapper.selectByExample(ue);
			if (userlist.size() == 0) {
				message.setSuccess(true);
			} else {
				message.setMessage("手机号重复");
				message.setSuccess(false);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return message;
	}

	

	/**
	 * 验证用户登录
	 * 
	 * @param user
	 * @throws Exception
	 */
	public User userLogin(User user) throws Exception {
		// TODO Auto-generated method stub
		UserExample ue = new UserExample();
		//查询是否存在用户和密码
		ue.or().andUsernameEqualTo(user.getUsername())
				.andPasswordEqualTo(user.getPassword());
		List<User> userlist = userMapper.selectByExample(ue);
		if (userlist.size() != 1) {
			System.out.println("登录失败");
			return null;
		} else {
			user = userlist.get(0);
			System.out.println("登录成功");
			return user;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.wdkj.xyfund.service.IUserService#updateUserInfo(com.wdkj.xyfund.controller.vo.UserVo)
	 */
	public Message updateUserInfo(UserVo user) throws Exception {
		Message result = new Message();
		User u = new User();
		BeanUtils.copyProperties(u, user);
		MultipartFile file = user.getUploadfile();
		
		if (file != null) {
			String icontype = file.getContentType();
			if(!icontype.startsWith("image")){//判断是否是图片格式
				result.setSuccess(false);
				result.setMessage("errorimgType");
				return result;
			}
			
			String fileName = file.getOriginalFilename(); //文件名
			String diskFileName = StringContentUtil.getUuid(); //保存后的文件名
			
	        CommonsMultipartFile cf= (CommonsMultipartFile)file; 
	        DiskFileItem fi = (DiskFileItem)cf.getFileItem(); 
	        File f1 = fi.getStoreLocation(); 
	        
	        if (StringContentUtil.isNoEmpty(user.getIconUrl())) {
	        	String iconUrl = user.getIconUrl();
	        	FileOperationUtil.deleteFile3(iconUrl.substring(iconUrl.indexOf("/"), iconUrl.length()));
	        }
	        
			Message m = FileOperationUtil.saveFileToDisk(f1, fileName, diskFileName, "userHead/" + user.getId());
			
			if (m.getSuccess()) {
				u.setIconUrl((String) m.getResult().get("filePath"));
			} else {
				return result;
			}
			
		}
		
		int record = userMapper.updateByPrimaryKeySelective(u);
		
		if (record > 0) {
			UserVo uvo = new UserVo();
			BeanUtils.copyProperties(uvo, u);
			Map map = new HashMap();
			map.put("user", uvo);
			result.setResult(map);
			result.setSuccess(true);
		}
		
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see com.wdkj.xyfund.service.IUserService#queryById(java.lang.Integer)
	 */
	public UserVo queryById(Integer userId) throws Exception {
		UserVo uvo = new UserVo();
		User u = userMapper.selectByPrimaryKey(userId);
		BeanUtils.copyProperties(uvo, u);
		return uvo;
	}

	/*
	 * (non-Javadoc)
	 * @see com.wdkj.xyfund.service.IUserService#queryByType(java.lang.Integer)
	 */
	public List<UserVo> queryByType(Integer type) throws Exception {
		UserExample userEx = new UserExample();
		userEx.createCriteria().andIsPostulantEqualTo(true);
		List<User> users = userMapper.selectByExample(userEx);
		
		List<UserVo> persons = new ArrayList<UserVo>();
		for (Iterator iterator = users.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			UserVo uvo = new UserVo();
			BeanUtils.copyProperties(uvo, user);
			persons.add(uvo);
		}
		
		return persons;
	}

	/**
	 * 查询客服的具体信息
	 */
	/*
	 * (non-Javadoc)
	 * @see com.wdkj.xyfund.service.IUserService#showCustomServiceData(java.lang.Integer)
	 */
	public News showCustomServiceData(Integer id) throws Exception {
		// TODO Auto-generated method stub
		News news  = new News();
		news = newsMapper.selectByPrimaryKey(id);
		return news;
	}

	/*
	 * (non-Javadoc)
	 * @see com.wdkj.xyfund.service.IUserService#selectPassword(java.lang.String)
	 */
	@Override
	public Message selectPassword(String username) throws Exception {
		// TODO Auto-generated method stub
		Message message = new Message();
		Map<String, String> result = new HashMap<>();
		UserExample userExample = new UserExample();
		userExample.createCriteria().andUsernameEqualTo(username);
		List<User> userList = userMapper.selectByExample(userExample);
		if(!ObjectUtil.collectionIsEmpty(userList)){
			User user = new User();
			user = userList.get(0);
			result.put("password", user.getPassword());
			message.setResult(result);
			message.setMessage("密码已经找到");
			message.setSuccess(true);
		}else{
			message.setMessage("账号不存在");
			message.setSuccess(false);
		}
		return message;
	}
}
