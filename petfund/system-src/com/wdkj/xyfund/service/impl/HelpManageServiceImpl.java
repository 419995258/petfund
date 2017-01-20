package com.wdkj.xyfund.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.math.BigDecimal;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wdkj.xyfund.controller.vo.FileVo;
import com.wdkj.xyfund.controller.vo.HelpApplyVo;
import com.wdkj.xyfund.controller.vo.HelpVo;
import com.wdkj.xyfund.controller.vo.Message;
import com.wdkj.xyfund.controller.vo.ResultVo;
import com.wdkj.xyfund.dao.FileMapper;
import com.wdkj.xyfund.dao.HelpApplyFilesMapper;
import com.wdkj.xyfund.dao.HelpApplyMapper;
import com.wdkj.xyfund.dao.HelpFilesMapper;
import com.wdkj.xyfund.dao.HelpMapper;
import com.wdkj.xyfund.entity.FileExample;
import com.wdkj.xyfund.entity.Help;
import com.wdkj.xyfund.entity.HelpApply;
import com.wdkj.xyfund.entity.HelpApplyExample;
import com.wdkj.xyfund.entity.HelpApplyWithBLOBs;
import com.wdkj.xyfund.entity.HelpExample;
import com.wdkj.xyfund.entity.HelpExample.Criteria;
import com.wdkj.xyfund.entity.HelpFiles;
import com.wdkj.xyfund.entity.HelpFilesExample;
import com.wdkj.xyfund.entity.HelpWithBLOBs;
import com.wdkj.xyfund.service.IHelpManageService;
import com.wdkj.xyfund.util.DateUtil;
import com.wdkj.xyfund.util.FileOperationUtil;
import com.wdkj.xyfund.util.ObjectUtil;
import com.wdkj.xyfund.util.StringContentUtil;

@Service("helpmanageService")
public class HelpManageServiceImpl implements IHelpManageService {

	@Autowired
	private HelpApplyMapper helpApplyMapper;

	@Autowired
	private HelpMapper helpMapper;

	@Autowired
	private FileMapper fileMapper;

	@Autowired
	private HelpFilesMapper helpFilesMapper;

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
	 * 查询所有helpApply信息
	 * 
	 */
	@Override
	public ResultVo showAllHelpApply(ResultVo param) throws Exception {
		// TODO 查询所有helpApply信息
		ResultVo resultVo = new ResultVo();
		List<HelpApplyVo> helpApplyVos = new ArrayList<HelpApplyVo>();

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

		HelpApplyExample helpApplyExample = new HelpApplyExample();

		// 查询不同种类
		com.wdkj.xyfund.entity.HelpApplyExample.Criteria cr = helpApplyExample
				.createCriteria();

		// 查询不同种类
		Integer queryType = param.getQueryType();

		if (queryType == 1) {
			cr.andApplyDateEqualTo(DateUtil.parseDate(DateUtil.DATE_STYLE4,
					param.getQueryText()));
		} else if (queryType == 2) {
			cr.andApplyUsernameLike(param.getQueryText());
		} else if (queryType == 3) {
			cr.andChildLike(param.getQueryText());
		} else if (queryType == 4) {
			cr.andGuardianLike(param.getQueryText());
		} else if (queryType == 5) {
			cr.andTelLike(param.getQueryText());
		}

		helpApplyExample.setOrderByClause("id desc");
		cr.andStatusNotEqualTo(0);
		List<HelpApply> helps = helpApplyMapper
				.selectByExample(helpApplyExample);

		if (!ObjectUtil.collectionIsEmpty(helps)) {

			for (Iterator iterator = helps.iterator(); iterator.hasNext();) {
				HelpApply helpApply = (HelpApply) iterator.next();
				HelpApplyVo temp = new HelpApplyVo();
				BeanUtils.copyProperties(temp, helpApply);
				Date applyTime = helpApply.getApplyDate();
				temp.setApplyDateStr(DateUtil.getDateStr(DateUtil.DATE_STYLE4,
						applyTime));
				if(helpApply.getStatus() == 1){
					temp.setHasPassHelp(false);
				}else if(helpApply.getStatus() == 2){
					temp.setHasPassHelp(true);
				}
				helpApplyVos.add(temp);
			}

		}

		this.setReturnPageInfo(psize, pageNum, helps, resultVo);
		resultVo.setRows(helpApplyVos);
		return resultVo;
	}

	/**
	 * 删除HelpApply的申请
	 */

	@Override
	public Message deleteHelpApply(HelpApplyVo helpApplyVo) throws Exception {
		// TODO 删除HelpApply的申请
		Message message = new Message();
		//int id = helpApplyVo.getId();
		HelpApply helpApply = new HelpApply();
		BeanUtils.copyProperties(helpApply, helpApplyVo);
		helpApply.setStatus(0);
		int record = helpApplyMapper.updateByPrimaryKey(helpApply);
		if (record > 0) {
			message.setSuccess(true);
		}

		return message;
	}

	/**
	 * 查询helpApply申请的详细
	 * 
	 */
	@Override
	public HelpApplyVo selectHelpApplyData(HelpApplyVo helpApplyVo)
			throws Exception {
		// TODO 查询helpApply申请的详细
		/*
		 * PostulantVo postulantVo = new PostulantVo(); Postulant postulant =
		 * new Postulant(); int id = userVo.getId(); PostulantExample queryEx =
		 * new PostulantExample();
		 * queryEx.createCriteria().andUserIdEqualTo(id); List<Postulant>
		 * postulants = postulantMapper.selectByExample(queryEx);
		 * 
		 * if (!ObjectUtil.collectionIsEmpty(postulants)) { postulant =
		 * postulants.get(0);
		 * 
		 * BeanUtils.copyProperties(postulantVo, postulant);
		 * 
		 * List<File> postulantFilesUrl =
		 * fileMapper.selectFileUrlByPrimaryKey(postulant.getId());
		 * postulantVo.setPostulantFilesUrl(postulantFilesUrl); }
		 * 
		 * return postulantVo;
		 */

		int id = helpApplyVo.getId();
		HelpApply helpApply = new HelpApply();
		HelpApplyExample helpApplyExample = new HelpApplyExample();
		helpApplyExample.createCriteria().andIdEqualTo(id);
		List<HelpApply> helpApplys = helpApplyMapper
				.selectByExampleWithBLOBs(helpApplyExample);

		if (!ObjectUtil.collectionIsEmpty(helpApplys)) {

			helpApply = helpApplys.get(0);
			BeanUtils.copyProperties(helpApplyVo, helpApply);
			Date applyDate = helpApply.getApplyDate();
			Date inDate = helpApply.getInDate();
			Date birthday = helpApply.getBirthday();
			helpApplyVo.setApplyDateStr(DateUtil.getDateStr(
					DateUtil.DATE_STYLE4, applyDate));
			helpApplyVo.setInDateStr(DateUtil.getDateStr(DateUtil.DATE_STYLE4,
					inDate));
			helpApplyVo.setBirthdayStr(DateUtil.getDateStr(
					DateUtil.DATE_STYLE4, birthday));

			List<com.wdkj.xyfund.entity.File> helpApplyFiles = fileMapper
					.selectFileUrlFromHelpApp(id);

			List<FileVo> f1 = new ArrayList<FileVo>();
			List<FileVo> f2 = new ArrayList<FileVo>();
			List<FileVo> f3 = new ArrayList<FileVo>();
			List<FileVo> f4 = new ArrayList<FileVo>();
			List<FileVo> f5 = new ArrayList<FileVo>();
			List<FileVo> f6 = new ArrayList<FileVo>();

			if (!ObjectUtil.collectionIsEmpty(helpApplyFiles)) {
				for (Iterator iterator = helpApplyFiles.iterator(); iterator
						.hasNext();) {
					com.wdkj.xyfund.entity.File file = (com.wdkj.xyfund.entity.File) iterator
							.next();
					FileVo fvo = new FileVo();
					BeanUtils.copyProperties(fvo, file);

					switch (file.getType()) {
					case 1:
						f1.add(fvo);
						break;
					case 2:
						f2.add(fvo);
						break;
					case 3:
						f3.add(fvo);
						break;
					case 4:
						f4.add(fvo);
						break;
					case 5:
						f5.add(fvo);
						break;
					case 6:
						f6.add(fvo);
						break;
					default:
						break;
					}
				}
			}

			Map<String, List<FileVo>> picFiles = new HashMap<String, List<FileVo>>();
			picFiles.put("p1", f1);
			picFiles.put("p2", f2);
			picFiles.put("p3", f3);
			picFiles.put("p4", f4);
			picFiles.put("p5", f5);
			picFiles.put("p6", f6);
			helpApplyVo.setPicFiles(picFiles);
		}

		// BeanUtils.copyProperties(helpApplyVo, helpApply);

		return helpApplyVo;
	}

	/**
	 * 添加紧急筹款
	 * 
	 */

	@Override
	public Message addChouKuan(HelpVo helpVo) throws Exception {
		// TODO 添加紧急筹款
		Message message = new Message();
		HelpWithBLOBs helpWithBLOBs = new HelpWithBLOBs();
		helpVo.setStatus(1);
		Date createTime = DateUtil.getCurrentDate(DateUtil.DATE_STYLE4);
		helpVo.setCreateTime(createTime);
		helpVo.setType(1);
		helpVo.setTotal(0);
		helpVo.setIsTop(false);
		helpVo.setMoneyOff(BigDecimal.valueOf(0));
		BeanUtils.copyProperties(helpWithBLOBs, helpVo);

		int record = helpMapper.insert(helpWithBLOBs);
		if (record > 0) {
			List<Integer> fileIds = helpVo.getFileIds();
			Integer helpId = helpWithBLOBs.getId();
			for (Iterator iterator = fileIds.iterator(); iterator.hasNext();) {
				Integer integer = (Integer) iterator.next();
				HelpFiles helpFiles = new HelpFiles();
				helpFiles.setFileId(integer);
				helpFiles.setHelpId(helpId);
				helpFilesMapper.insert(helpFiles);
			}
			message.setSuccess(true);
		}

		return message;
	}

	/**
	 * 查询紧急筹款的条数信息
	 */

	@Override
	public ResultVo selectChouKuan(ResultVo param) throws Exception {
		// TODO 查询紧急筹款的条数信息
		ResultVo resultVo = new ResultVo();
		List<HelpVo> helpVos = new ArrayList<HelpVo>();

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

		HelpExample helpExample = new HelpExample();
		Criteria cr = helpExample.createCriteria();
		helpExample.setOrderByClause("id desc");
		// 紧急筹款状态
		cr.andTypeEqualTo(1);
		//查询正在求救的
		cr.andStatusEqualTo(1);
		// 查询不同种类
		Integer queryType = param.getQueryType();

		if (queryType == 1) {
			cr.andCreateTimeEqualTo(DateUtil.parseDate(DateUtil.DATE_STYLE4,
					param.getQueryText()));
		} else if (queryType == 2) {
			cr.andChildNameLike(param.getQueryText());
		} else if (queryType == 3) {
			cr.andPersonNameLike(param.getQueryText());
		}

		List<Help> helps = helpMapper.selectByExample(helpExample);

		if (!ObjectUtil.collectionIsEmpty(helps)) {

			for (Iterator iterator = helps.iterator(); iterator.hasNext();) {
				Help help = (Help) iterator.next();
				HelpVo temp = new HelpVo();
				BeanUtils.copyProperties(temp, help);
				Date createTime = help.getCreateTime();
				temp.setCreateTimeStr(DateUtil.getDateStr(DateUtil.DATE_STYLE4,
						createTime));
				helpVos.add(temp);
			}

		}

		this.setReturnPageInfo(psize, pageNum, helps, resultVo);
		resultVo.setRows(helpVos);
		return resultVo;
	}

	/**
	 * 
	 * 删除紧急筹款
	 * 
	 */
	@Override
	public Message deleteChouKuan(HelpVo helpVo) throws Exception {
		// TODO 删除紧急筹款
		Message message = new Message();
	/*	int id = helpVo.getId();

		// 查询所有文件从help_file
		HelpFilesExample helpFilesExample = new HelpFilesExample();
		helpFilesExample.createCriteria().andHelpIdEqualTo(id);
		List<HelpFiles> helpFilesList = helpFilesMapper
				.selectByExample(helpFilesExample);
		if (!ObjectUtil.collectionIsEmpty(helpFilesList)) {
			for (Iterator iterator = helpFilesList.iterator(); iterator
					.hasNext();) {
				HelpFiles helpFiles = (HelpFiles) iterator.next();
				com.wdkj.xyfund.entity.File file = new com.wdkj.xyfund.entity.File();
				file = fileMapper.selectByPrimaryKey(helpFiles.getFileId());
				// 删除helpfile表
				int record = helpFilesMapper.deleteByPrimaryKey(helpFiles
						.getId());
				// 删除file表
				if (record > 0) {
					fileMapper.deleteByPrimaryKey(file.getId());
					FileOperationUtil.deleteFile2(file.getFileurl());
				}
			}
		}*/

		Help help = new Help();
		BeanUtils.copyProperties(help, helpVo);
		help.setStatus(0);
		int record = helpMapper.updateByPrimaryKey(help);
		if (record > 0) {
			message.setSuccess(true);
		}

		return message;
	}

	/**
	 * 
	 * 查询紧急筹款的具体信息
	 * 
	 **/
	@Override
	public HelpVo showChouKuanData(HelpVo helpVo) throws Exception {
		// TODO 查询紧急筹款的具体信息
		int id = helpVo.getId();
		HelpWithBLOBs helpWithBLOBs = new HelpWithBLOBs();
		HelpExample helpExample = new HelpExample();
		helpExample.createCriteria().andIdEqualTo(id);
		List<HelpWithBLOBs> helps = helpMapper
				.selectByExampleWithBLOBs(helpExample);
		if (!ObjectUtil.collectionIsEmpty(helps)) {

			helpWithBLOBs = helps.get(0);
			BeanUtils.copyProperties(helpVo, helpWithBLOBs);
			Date createTime = helpWithBLOBs.getCreateTime();
			helpVo.setCreateTimeStr(DateUtil.getDateStr(DateUtil.DATE_STYLE4,
					createTime));
			List<com.wdkj.xyfund.entity.File> helpFilesUrls = fileMapper
					.selectFileUrlFromHelpByPrimaryKey(helpWithBLOBs.getId());
			List<FileVo> helpFilesUrl = new ArrayList<FileVo>();
			if (!ObjectUtil.collectionIsEmpty(helpFilesUrls)) {
				for (Iterator iterator = helpFilesUrls.iterator(); iterator
						.hasNext();) {
					com.wdkj.xyfund.entity.File file = (com.wdkj.xyfund.entity.File) iterator
							.next();
					FileVo fileVo = new FileVo();
					BeanUtils.copyProperties(fileVo, file);
					fileVo.setFileurl(file.getFileurl());
					helpFilesUrl.add(fileVo);
				}
			}
			helpVo.setHelpFilesUrl(helpFilesUrl);
		}
		return helpVo;
		/*
		 * HelpWi help = new Help(); HelpExample helpExample = new
		 * HelpExample(); helpExample.createCriteria().andIdEqualTo(id);
		 * List<Help> helps = helpMapper.selectByExample(helpExample); if
		 * (!ObjectUtil.collectionIsEmpty(helps)) {
		 * 
		 * help = helps.get(0); BeanUtils.copyProperties(helpVo, help); Date
		 * createTime = help.getCreateTime();
		 * helpVo.setCreateTimeStr(DateUtil.getDateStr(DateUtil.DATE_STYLE4,
		 * createTime)); } return helpVo;
		 */
	}

	/**
	 * 
	 * 保存临时文件
	 */
	@Override
	public Message saveTempFiles(MultipartFile[] file) throws Exception {
		// TODO 保存临时文件
		Message message = new Message();
		Map<String, Object> fm = new HashMap<String, Object>();

		if (file != null && file.length > 0) {
			// Date createTime = DateUtil.getCurrentDate(DateUtil.DATE_STYLE5);

			for (int i = 0; i < file.length; i++) {
				MultipartFile f = file[i];
				String fileName = f.getOriginalFilename(); // 文件名
				String diskFileName = StringContentUtil.getUuid(); // 保存后的文件名
				CommonsMultipartFile cf = (CommonsMultipartFile) f;
				DiskFileItem fi = (DiskFileItem) cf.getFileItem();
				File f1 = fi.getStoreLocation();
				Message m = FileOperationUtil.saveFileToDisk(f1, fileName,
						diskFileName, "helpFile");

				/*
				 * 保存数据库逻辑
				 */

				if (m.getSuccess()) {
					try {
						// 保存文件记录
						com.wdkj.xyfund.entity.File temp = new com.wdkj.xyfund.entity.File();
						temp.setName(fileName);
						temp.setFileurl(".."
								+ (String) m.getResult().get("filePath"));
						temp.setFiletype(f.getContentType());
						temp.setSize(f.getSize());
						/* temp.setUserId(userId); */
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
	 * 
	 * 
	 * 修改更新加紧筹款
	 */
	@Override
	public Message updateChouKuan(HelpVo helpVo) throws Exception {
		// TODO 修改更新加紧筹款
		Message message = new Message();

		if (helpVo.getOldFileIds() != null) {
			// 删除旧文件记录
			HelpFilesExample helpFilesExample = new HelpFilesExample();
			helpFilesExample.createCriteria().andFileIdEqualTo(
					helpVo.getOldFileIds());
			helpFilesMapper.deleteByExample(helpFilesExample);
		}

		HelpWithBLOBs helpWithBLOBs = new HelpWithBLOBs();

		BeanUtils.copyProperties(helpWithBLOBs, helpVo);

		int record = helpMapper.updateByPrimaryKeyWithBLOBs(helpWithBLOBs);
		if (record > 0) {
			List<Integer> fileIds = helpVo.getFileIds();
			if (fileIds != null) {

				Integer helpId = helpWithBLOBs.getId();
				for (Iterator iterator = fileIds.iterator(); iterator.hasNext();) {
					Integer integer = (Integer) iterator.next();
					HelpFiles helpFiles = new HelpFiles();
					helpFiles.setFileId(integer);
					helpFiles.setHelpId(helpId);
					helpFilesMapper.insert(helpFiles);
				}
				message.setSuccess(true);
			}
		}

		return message;
	}

	/**
	 * 
	 * 添加汇聚，传递
	 */
	@Override
	public Message addHuiJuOrChuanDi(HelpVo helpVo) throws Exception {
		// TODO 添加汇聚，传递
		Message message = new Message();
		HelpWithBLOBs helpWithBLOBs = new HelpWithBLOBs();
		helpVo.setStatus(1);
		Date createTime = DateUtil.getCurrentDate(DateUtil.DATE_STYLE4);
		helpVo.setCreateTime(createTime);
		helpVo.setType(helpVo.getType());
		helpVo.setIsTop(false);
		helpVo.setTotal(0);
		helpVo.setMoneyOff(BigDecimal.valueOf(0));
		BeanUtils.copyProperties(helpWithBLOBs, helpVo);

		int record = helpMapper.insert(helpWithBLOBs);
		if (record > 0) {
			List<Integer> fileIds = helpVo.getFileIds();
			Integer helpId = helpWithBLOBs.getId();
			for (Iterator iterator = fileIds.iterator(); iterator.hasNext();) {
				Integer integer = (Integer) iterator.next();
				HelpFiles helpFiles = new HelpFiles();
				helpFiles.setFileId(integer);
				helpFiles.setHelpId(helpId);
				helpFilesMapper.insert(helpFiles);
			}

			message.setSuccess(true);
		}

		return message;
	}

	/**
	 * 查询汇聚，传递信息
	 * 
	 */
	@Override
	public ResultVo selectHuiJuOrChuanDi(ResultVo param) throws Exception {
		// TODO 查询汇聚，传递信息
		ResultVo resultVo = new ResultVo();
		List<HelpVo> helpVos = new ArrayList<HelpVo>();

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
		HelpExample helpExample = new HelpExample();
		// 根据id倒序排序
		helpExample.setOrderByClause("id desc");
		Criteria cr = helpExample.createCriteria();
		// 紧急筹款状态
		cr.andTypeEqualTo(param.getType());
		//查询正在求救的
		cr.andStatusEqualTo(1);
		// 查询不同种类
		Integer queryType = param.getQueryType();

		if (queryType == 1) {
			cr.andCreateTimeEqualTo(DateUtil.parseDate(DateUtil.DATE_STYLE4,
					param.getQueryText()));
		} else if (queryType == 2) {
			cr.andChildNameLike(param.getQueryText());
		} else if (queryType == 3) {
			cr.andPersonNameLike(param.getQueryText());
		}

		List<Help> helps = helpMapper.selectByExample(helpExample);

		if (!ObjectUtil.collectionIsEmpty(helps)) {

			for (Iterator iterator = helps.iterator(); iterator.hasNext();) {
				Help help = (Help) iterator.next();
				HelpVo temp = new HelpVo();
				BeanUtils.copyProperties(temp, help);
				Date createTime = help.getCreateTime();
				temp.setCreateTimeStr(DateUtil.getDateStr(DateUtil.DATE_STYLE4,
						createTime));
				helpVos.add(temp);
			}

		}

		this.setReturnPageInfo(psize, pageNum, helps, resultVo);
		resultVo.setRows(helpVos);
		return resultVo;
	}

	/**
	 * 
	 * 删除汇聚，传递信息
	 * 
	 */
	@Override
	public Message deleteHuiJuOrChuanDi(HelpVo helpVo) throws Exception {
		// TODO 删除汇聚，传递信息
		Message message = new Message();
		int id = helpVo.getId();
		/*// 查询所有文件从help_file
		HelpFilesExample helpFilesExample = new HelpFilesExample();
		helpFilesExample.createCriteria().andHelpIdEqualTo(id);
		List<HelpFiles> helpFilesList = helpFilesMapper
				.selectByExample(helpFilesExample);
		if (!ObjectUtil.collectionIsEmpty(helpFilesList)) {
			for (Iterator iterator = helpFilesList.iterator(); iterator
					.hasNext();) {
				HelpFiles helpFiles = (HelpFiles) iterator.next();
				com.wdkj.xyfund.entity.File file = new com.wdkj.xyfund.entity.File();
				file = fileMapper.selectByPrimaryKey(helpFiles.getFileId());
				// 删除helpfile表
				int record = helpFilesMapper.deleteByPrimaryKey(helpFiles
						.getId());
				// 删除file表
				if (record > 0) {
					fileMapper.deleteByPrimaryKey(file.getId());
					FileOperationUtil.deleteFile2(file.getFileurl());
				}
			}
		}*/

		Help help = new Help();
		BeanUtils.copyProperties(help, helpVo);
		help.setStatus(0);
		int record = helpMapper.updateByPrimaryKey(help);
		if (record > 0) {
			message.setSuccess(true);
		}
		return message;
	}

	/**
	 * 
	 * 查询help汇聚，传递的详细信息
	 */

	@Override
	public HelpVo showHuiJuOrChuanDiData(HelpVo helpVo) throws Exception {
		// TODO 查询help汇聚，传递的详细信息

		int id = helpVo.getId();
		HelpWithBLOBs helpWithBLOBs = new HelpWithBLOBs();
		HelpExample helpExample = new HelpExample();
		helpExample.createCriteria().andIdEqualTo(id);
		List<HelpWithBLOBs> helps = helpMapper
				.selectByExampleWithBLOBs(helpExample);
		if (!ObjectUtil.collectionIsEmpty(helps)) {

			helpWithBLOBs = helps.get(0);
			BeanUtils.copyProperties(helpVo, helpWithBLOBs);
			Date createTime = helpWithBLOBs.getCreateTime();
			helpVo.setCreateTimeStr(DateUtil.getDateStr(DateUtil.DATE_STYLE4,
					createTime));

			List<com.wdkj.xyfund.entity.File> helpFilesUrls = fileMapper
					.selectFileUrlFromHelpByPrimaryKey(helpWithBLOBs.getId());
			List<FileVo> helpFilesUrl = new ArrayList<FileVo>();
			if (!ObjectUtil.collectionIsEmpty(helpFilesUrls)) {
				for (Iterator iterator = helpFilesUrls.iterator(); iterator
						.hasNext();) {
					com.wdkj.xyfund.entity.File file = (com.wdkj.xyfund.entity.File) iterator
							.next();
					FileVo fileVo = new FileVo();
					BeanUtils.copyProperties(fileVo, file);
					fileVo.setFileurl(file.getFileurl());
					helpFilesUrl.add(fileVo);
				}
			}
			helpVo.setHelpFilesUrl(helpFilesUrl);

		}
		return helpVo;
	}

	/**
	 * 
	 * 
	 * 更新help汇聚，传递的详细信息
	 */

	@Override
	public Message updateHuiJuOrChuanDi(HelpVo helpVo) throws Exception {
		// TODO 更新help汇聚，传递的详细信息
		Message message = new Message();

		if (helpVo.getOldFileIds() != null) {
			// 删除旧文件记录
			HelpFilesExample helpFilesExample = new HelpFilesExample();
			helpFilesExample.createCriteria().andFileIdEqualTo(
					helpVo.getOldFileIds());
			helpFilesMapper.deleteByExample(helpFilesExample);
		}
		HelpWithBLOBs helpWithBLOBs = new HelpWithBLOBs();

		BeanUtils.copyProperties(helpWithBLOBs, helpVo);

		int record = helpMapper.updateByPrimaryKeyWithBLOBs(helpWithBLOBs);
		if (record > 0) {
			List<Integer> fileIds = helpVo.getFileIds();
			if (fileIds != null) {
				Integer helpId = helpWithBLOBs.getId();
				for (Iterator iterator = fileIds.iterator(); iterator.hasNext();) {
					Integer integer = (Integer) iterator.next();
					HelpFiles helpFiles = new HelpFiles();
					helpFiles.setFileId(integer);
					helpFiles.setHelpId(helpId);
					helpFilesMapper.insert(helpFiles);
				}
				message.setSuccess(true);
			}
		}

		return message;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wdkj.xyfund.service.IHelpManageService#deleteTempFile(com.wdkj.xyfund
	 * .entity.File)
	 */
	@Override
	public Message deleteTempFile(com.wdkj.xyfund.entity.File param)
			throws Exception {
		// TODO Auto-generated method stub
		Message message = new Message();

		FileExample fe = new FileExample();
		fe.createCriteria().andIdEqualTo(param.getId());

		HelpFilesExample helpFilesExample = new HelpFilesExample();
		helpFilesExample.createCriteria().andFileIdEqualTo(param.getId());

		boolean b = FileOperationUtil.deleteFile2(param.getFileurl());

		if (b) {
			int record = fileMapper.deleteByExample(fe);
			int record2 = helpFilesMapper.deleteByExample(helpFilesExample);
			if (record > 0 && record2 > 0) {
				message.setSuccess(true);
			} else {
				throw new RuntimeException("删除申请志愿者附件文件失败");
			}
		}
		return message;
	}

	@Override
	public Message topChouKuan(HelpVo helpVo) throws Exception {
		// TODO Auto-generated method stub
		HelpExample helpExample = new HelpExample();
		helpExample.createCriteria().andIsTopEqualTo(true).andTypeEqualTo(1);
		List<Help> helpList = helpMapper.selectByExample(helpExample);
		if (!ObjectUtil.collectionIsEmpty(helpList)) {
			Help help = helpList.get(0);
			help.setIsTop(false);
			helpMapper.updateByPrimaryKey(help);
		}

		Message message = new Message();
		int id = helpVo.getId();
		HelpWithBLOBs helpWithBLOBs = new HelpWithBLOBs();
		helpWithBLOBs = helpMapper.selectByPrimaryKey(id);
		if (helpWithBLOBs != null) {
			helpWithBLOBs.setIsTop(true);
			int record = helpMapper.updateByPrimaryKeyWithBLOBs(helpWithBLOBs);
			if (record > 0) {
				message.setSuccess(true);

			}
		}
		return message;

	}

	/**
	 * 置顶汇聚传递
	 * 
	 */

	public Message topHuiJuOrChuanDi(HelpVo helpVo) throws Exception {
		HelpExample helpExample = new HelpExample();
		helpExample.createCriteria().andIsTopEqualTo(true)
				.andTypeEqualTo(helpVo.getType());
		List<Help> helpList = helpMapper.selectByExample(helpExample);
		if (!ObjectUtil.collectionIsEmpty(helpList)) {
			Help help = helpList.get(0);
			help.setIsTop(false);
			helpMapper.updateByPrimaryKey(help);
		}

		Message message = new Message();
		int id = helpVo.getId();
		HelpWithBLOBs helpWithBLOBs = new HelpWithBLOBs();
		helpWithBLOBs = helpMapper.selectByPrimaryKey(id);
		if (helpWithBLOBs != null) {
			helpWithBLOBs.setIsTop(true);
			int record = helpMapper.updateByPrimaryKeyWithBLOBs(helpWithBLOBs);
			if (record > 0) {
				message.setSuccess(true);

			}
		}
		return message;
	}

	@Override
	public Message passHelp(HelpApply helpApply) throws Exception {
		// TODO Auto-generated method stub
		Message message = new Message();
		
		if(helpApply.getStatus() == 1){
			helpApply.setStatus(2);
		}else if(helpApply.getStatus() == 2){
			helpApply.setStatus(1);
		}
		int record = helpApplyMapper.updateByPrimaryKey(helpApply);
		if(record>0){
			message.setSuccess(true);
		}
		return message;
	}

}
