package com.wdkj.xyfund.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.wdkj.xyfund.controller.vo.DictionaryVo;
import com.wdkj.xyfund.controller.vo.HelpApplyVo;
import com.wdkj.xyfund.controller.vo.HelpVo;
import com.wdkj.xyfund.controller.vo.HelpWithBLOBsVo;
import com.wdkj.xyfund.controller.vo.Message;
import com.wdkj.xyfund.controller.vo.PostulantVo;
import com.wdkj.xyfund.controller.vo.ResultVo;
import com.wdkj.xyfund.dao.ContributionMapper;
import com.wdkj.xyfund.dao.FileMapper;
import com.wdkj.xyfund.dao.HelpApplyMapper;
import com.wdkj.xyfund.dao.HelpMapper;
import com.wdkj.xyfund.dao.PostulantFilesMapper;
import com.wdkj.xyfund.dao.PostulantMapper;
import com.wdkj.xyfund.dao.PostulantServiceSkillMapper;
import com.wdkj.xyfund.dao.UserMapper;
import com.wdkj.xyfund.entity.Contribution;
import com.wdkj.xyfund.entity.ContributionExample;
import com.wdkj.xyfund.entity.Dictionary;
import com.wdkj.xyfund.entity.FileExample;
import com.wdkj.xyfund.entity.Help;
import com.wdkj.xyfund.entity.HelpApply;
import com.wdkj.xyfund.entity.HelpApplyExample;
import com.wdkj.xyfund.entity.HelpExample;
import com.wdkj.xyfund.entity.Postulant;
import com.wdkj.xyfund.entity.PostulantFiles;
import com.wdkj.xyfund.entity.PostulantServiceSkill;
import com.wdkj.xyfund.entity.User;
import com.wdkj.xyfund.service.IVolunteerService;
import com.wdkj.xyfund.util.BizUtil;
import com.wdkj.xyfund.util.DateUtil;
import com.wdkj.xyfund.util.FileOperationUtil;
import com.wdkj.xyfund.util.ObjectUtil;
import com.wdkj.xyfund.util.StringContentUtil;

@Repository("volunteerService")
@Scope("prototype")
public class VolunteerServiceImpl extends BasicService implements IVolunteerService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private PostulantMapper postulantMapper;
	
	@Autowired
	private FileMapper fileMapper;
	
	@Autowired
	private PostulantFilesMapper postulantFilesMapper;

	@Autowired
	private PostulantServiceSkillMapper postulantServiceSkillMapper;
	
	@Autowired
	private HelpMapper helpMapper;
	
	@Autowired
	private HelpApplyMapper helpApplyMapper;

	@Autowired
	private ContributionMapper contributionMapper;
	
	/**
	 * 申请志愿者
	 */
	public Message volunteerRegisteer(PostulantVo param) throws Exception {
		Message message = new Message();

		Postulant postulant = new Postulant();
		BeanUtils.copyProperties(postulant,param);
		int record = postulantMapper.insert(postulant);
		if(record > 0){
			//修改user表为申请志愿者状态
			User user =  userMapper.selectByPrimaryKey(param.getUserId());
			user.setType(2);
			userMapper.updateByPrimaryKey(user);
			
			List<Integer> fileIds = param.getFileIds();
			Integer postulantId = postulant.getId();
			List<PostulantFiles> pFiles = new ArrayList<PostulantFiles>();
			
			if (!ObjectUtil.collectionIsEmpty(fileIds)) {
				for (Iterator iterator = fileIds.iterator(); iterator.hasNext();) {
					Integer fid = (Integer) iterator.next();
					PostulantFiles postulantFiles = new PostulantFiles();
					postulantFiles.setFileId(fid);
					postulantFiles.setPostulantId(postulantId);
					pFiles.add(postulantFiles);
//					postulantFilesMapper.insert(postulantFiles);
				}
				
				postulantFilesMapper.addTrainRecordBatch(pFiles);
				
				com.wdkj.xyfund.entity.File f = new com.wdkj.xyfund.entity.File();
				f.setFileStatus(true);
				
				//修改文件为启用
				FileExample fEx = new FileExample();
				fEx.createCriteria().andIdIn(fileIds);
				fileMapper.updateByExampleSelective(f, fEx);
			}
			
			//保存服务项目
			List<DictionaryVo> services = param.getServices();
			List<PostulantServiceSkill> posServices = new ArrayList<PostulantServiceSkill>();
			
			for (Iterator iterator = services.iterator(); iterator.hasNext();) {
				DictionaryVo dictionary = (DictionaryVo) iterator.next();
				PostulantServiceSkill p = new PostulantServiceSkill();
				p.setDictionaryId(dictionary.getId());
				p.setPostulantId(postulantId);
				p.setOther(dictionary.getOther());
				posServices.add(p);
			}
			
			//保存技能
			List<DictionaryVo> skills = param.getSkills();
			List<PostulantServiceSkill> posSkills = new ArrayList<PostulantServiceSkill>();
			
			for (Iterator iterator = skills.iterator(); iterator.hasNext();) {
				DictionaryVo dictionary = (DictionaryVo) iterator.next();
				PostulantServiceSkill p = new PostulantServiceSkill();
				p.setDictionaryId(dictionary.getId());
				p.setPostulantId(postulantId);
				p.setOther(dictionary.getOther());
				posSkills.add(p);
			}
			
			postulantServiceSkillMapper.addTrainRecordBatch(posServices);
			postulantServiceSkillMapper.addTrainRecordBatch(posSkills);
			
			/*User updateUser = userMapper.selectByPrimaryKey(param.getUserId());
			updateUser.setType(BizUtil.USER_TYPE2);
			userMapper.updateByPrimaryKeySelective(updateUser);*/
			message.setSuccess(true);
		}

		return message;
	}

	/**
	 * 保存临时文件
	 */
	public Message saveTempFiles(MultipartFile[] file, Integer userId)
			throws Exception {
		Message message = new Message();
		Map<String, Object> fm = new HashMap<String, Object>();

		if (file != null && file.length > 0) {

			for (int i = 0; i < file.length; i++) {
				MultipartFile f = file[i];
				String fileName = f.getOriginalFilename(); // 文件名
				String diskFileName = StringContentUtil.getUuid(); // 保存后的文件名
				CommonsMultipartFile cf = (CommonsMultipartFile) f;
				DiskFileItem fi = (DiskFileItem) cf.getFileItem();
				File f1 = fi.getStoreLocation();
				Message m = FileOperationUtil.saveFileToDisk(f1, fileName,
						diskFileName, "postulantFile");

				/*
				 * 保存数据库逻辑
				 */
				if (m.getSuccess()) {
					try {
						// 保存文件记录
						com.wdkj.xyfund.entity.File temp = new com.wdkj.xyfund.entity.File();
						temp.setName(fileName);
						temp.setFileurl(".." + (String) m.getResult().get("filePath"));
						temp.setFiletype(f.getContentType());
						temp.setSize(f.getSize());
						temp.setUserId(userId);
						temp.setBucket("");
						temp.setAccessType("");
						temp.setType(0);
						temp.setFileStatus(false);
						int records = fileMapper.insertSelective(temp);
						if (records > 0) {
							fm.put("fileId", temp.getId());
							fm.put("fileUrl", temp.getFileurl());
							message.setSuccess(true);
						}
					} catch (Exception e) {
						Object o = m.getResult().get("savefile");

						File ef = (File) o;
						if (ef.exists()) {
							ef.delete();
						}
						throw e;
					}
				}
			}
		}
		message.setResult(fm);

		return message;
	}

	/**
	 * 完成用户与上传文件关系的保存
	 */
	@Override
	public Message saveVolun(PostulantFiles postulantFiles) throws Exception {
		// TODO Auto-generated method stub
		Message message = new Message();
		try {

			postulantFilesMapper.insert(postulantFiles);
			message.setSuccess(true);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return message;
	}

	/*
	 * non-Javadoc)
	 * @see com.wdkj.xyfund.service.IVolunteerService#deleteTempFile(com.wdkj.xyfund.entity.File)
	 */
	public Message deleteTempFile(com.wdkj.xyfund.entity.File param) throws Exception {
		Message message = new Message();
		
		FileExample fe = new FileExample();
		fe.createCriteria().andIdEqualTo(param.getId());
		
		boolean b = FileOperationUtil.deleteFile2(param.getFileurl());
		
		if (b) {
			int record = fileMapper.deleteByExample(fe);
			
			if (record > 0) {
				message.setSuccess(true);
			} else {
				throw new RuntimeException("删除申请志愿者附件文件失败");
			}
		}
		return message;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.wdkj.xyfund.service.IVolunteerService#queryOfficeListByUserId(com.wdkj.xyfund.controller.vo.ResultVo, com.wdkj.xyfund.entity.Contribution)
	 */
	public ResultVo queryOfficeListByUserId(ResultVo param, Contribution contribution) throws Exception {
		ResultVo result = new ResultVo();
		setPageInfo(param.getPageSize(), param.getCurrentpage());
		List<HelpWithBLOBsVo> helpInfos = helpMapper.selectByContribution(contribution);
		setReturnPageInfo(helpInfos, result);
		result.setRows(helpInfos);
		return result;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.wdkj.xyfund.service.IVolunteerService#queryGk(com.wdkj.xyfund.entity.Contribution)
	 */
	public Map queryGk(Contribution contribution) throws Exception {
		Map result = new HashMap();
		
		Date currentDate = DateUtil.getCurrentDate(DateUtil.DATE_STYLE4);
		
		Contribution param = new Contribution();
		param.setUserId(contribution.getUserId());
		param.setCreateTime(currentDate);
		
		long times = contributionMapper.selectCountFrequency(param);//查询行善次数
		long countMoney = contributionMapper.selectCountMoney(param);//查询总捐款数额
		long countChild = contributionMapper.selectCountChild(param);//查询总共捐过的患儿数量
		//查询捐助家庭数
		
		result.put("times", times);
		result.put("countMoney", countMoney);
		result.put("countChild", countChild);
		result.put("currentDate", DateUtil.getDateStr(DateUtil.DATE_STYLE4, currentDate));
		return result;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.wdkj.xyfund.service.IVolunteerService#queryHelpByUsername(com.wdkj.xyfund.controller.vo.ResultVo, java.lang.String)
	 */
	public ResultVo queryHelpById(ResultVo param, int  id) throws Exception {
		ResultVo result = new ResultVo();
		setPageInfo(param.getPageSize(), param.getCurrentpage());
		HelpApplyExample helpApplyExample = new HelpApplyExample();
		helpApplyExample.createCriteria().andUserIdEqualTo(id);
		helpApplyExample.setOrderByClause("id desc");
		List<HelpApply> helpApplyList = helpApplyMapper.selectByExampleWithBLOBs(helpApplyExample);
		setReturnPageInfo(helpApplyList, result);
		List<HelpApplyVo> helpApplyVos = new ArrayList<>();
		
		if (!ObjectUtil.collectionIsEmpty(helpApplyList)) {
			for (Iterator iterator = helpApplyList.iterator(); iterator.hasNext();) {
				HelpApply helpApply = (HelpApply) iterator.next();
				HelpApplyVo helpApplyVo = new HelpApplyVo();
				String applyDateStr = DateUtil.getDateStr(DateUtil.DATE_STYLE4, helpApply.getApplyDate());
				helpApplyVo.setApplyDateStr(applyDateStr);
				BeanUtils.copyProperties(helpApplyVo, helpApply);
				helpApplyVos.add(helpApplyVo);
			}
		}
		
		result.setRows(helpApplyVos);
		return result;
	}
}
