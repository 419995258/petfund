package com.wdkj.xyfund.service.impl;

import java.io.File;
import java.math.BigDecimal;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.wdkj.xyfund.controller.vo.FileVo;
import com.wdkj.xyfund.controller.vo.ContributionVo;
import com.wdkj.xyfund.controller.vo.HelpApplyVo;
import com.wdkj.xyfund.controller.vo.HelpVo;
import com.wdkj.xyfund.controller.vo.LinkVo;
import com.wdkj.xyfund.controller.vo.Message;
import com.wdkj.xyfund.controller.vo.PostulantVo;
import com.wdkj.xyfund.controller.vo.ResultVo;
import com.wdkj.xyfund.controller.vo.UserVo;
import com.wdkj.xyfund.dao.ContributionMapper;
import com.wdkj.xyfund.dao.FangwenMapper;
import com.wdkj.xyfund.dao.FileMapper;
import com.wdkj.xyfund.dao.HelpApplyFilesMapper;
import com.wdkj.xyfund.dao.HelpApplyMapper;
import com.wdkj.xyfund.dao.HelpMapper;
import com.wdkj.xyfund.dao.LinkMapper;
import com.wdkj.xyfund.dao.PostulantMapper;
import com.wdkj.xyfund.dao.UserMapper;
import com.wdkj.xyfund.entity.Contribution;
import com.wdkj.xyfund.entity.Fangwen;
import com.wdkj.xyfund.entity.FangwenExample;
import com.wdkj.xyfund.entity.Fengmian;
import com.wdkj.xyfund.entity.FengmianExample;
import com.wdkj.xyfund.entity.Help;
import com.wdkj.xyfund.entity.HelpApply;
import com.wdkj.xyfund.entity.HelpApplyFiles;
import com.wdkj.xyfund.entity.HelpExample;
import com.wdkj.xyfund.entity.HelpFiles;
import com.wdkj.xyfund.entity.HelpWithBLOBs;
import com.wdkj.xyfund.entity.Link;
import com.wdkj.xyfund.entity.User;
import com.wdkj.xyfund.entity.UserExample;
import com.wdkj.xyfund.service.IHelpService;
import com.wdkj.xyfund.util.DateUtil;
import com.wdkj.xyfund.util.FileOperationUtil;
import com.wdkj.xyfund.util.ObjectUtil;
import com.wdkj.xyfund.util.StringContentUtil;

@Repository("helpService")
@Scope("prototype")
public class HelpServiceImpl extends BasicService implements IHelpService {

	@Autowired
	private HelpMapper helpMapper;

	@Autowired
	private FangwenMapper fangwenMapper;

	@Autowired
	private LinkMapper linkMapper;

	@Autowired
	private HelpApplyFilesMapper helpApplyFilesMapper;

	@Autowired
	private FileMapper fileMapper;

	@Autowired
	private HelpApplyMapper helpApplyMapper;

	@Autowired
	private PostulantMapper postulantMapper;

	@Autowired
	private ContributionMapper contributionMapper;

	@Autowired
	private UserMapper userMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wdkj.xyfund.service.IHelpService#queryByType(com.wdkj.xyfund.controller
	 * .vo.ResultVo, java.lang.Integer)
	 */
	public ResultVo queryByType(ResultVo param, Integer type) throws Exception {
		ResultVo result = new ResultVo();
		setPageInfo(param.getPageSize(), param.getCurrentpage());

		Help queryParam = new Help();
		queryParam.setType(type);

		if (param.getStatus() != null) {
			queryParam.setIsTop(param.getStatus() == 0 ? false : true);
		}

		List<HelpVo> helpVo = helpMapper.selectAndFile(queryParam);

		if (!ObjectUtil.collectionIsEmpty(helpVo)) {
			for (Iterator iterator = helpVo.iterator(); iterator.hasNext();) {
				HelpVo helpVo2 = (HelpVo) iterator.next();
				Integer initiateNum = helpVo2.getInitiateNum();
				Integer total = helpVo2.getTotal();

				if (initiateNum == null) {
					helpVo2.setInitiateNum(0);
				}

				if (total == null) {
					helpVo2.setTotal(0);
				}
				
				BigDecimal a = helpVo2.getMoney().subtract(helpVo2.getMoneyOff());
				helpVo2.setMoneyNeed(a);
			}
		}

		setReturnPageInfo(helpVo, result);
		result.setRows(helpVo);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wdkj.xyfund.service.IHelpService#queryById(java.lang.Integer)
	 */
	public HelpVo queryById(Integer id) throws Exception {
		HelpVo hVo = new HelpVo();

		if (id != null) {
			List<HelpVo> helps = helpMapper.selectAndFileById(id);
			if (!ObjectUtil.collectionIsEmpty(helps)) {
				hVo = helps.get(0);
				HelpWithBLOBs helpWithBLOBs = helpMapper.selectByPrimaryKey(id);
				BeanUtils.copyProperties(hVo, helpWithBLOBs);
			}
		}

		return hVo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wdkj.xyfund.service.IHelpService#queryMessageIndex(com.wdkj.xyfund
	 * .controller.vo.HelpVo)
	 */
	public HelpVo queryMessageIndex(HelpVo helpVo) throws Exception {
		// TODO Auto-generated method stub
		/* HelpExample helpExample = new HelpExample(); */

		// 累计发布allProject
		long allProject = helpMapper.selectProject();
		helpVo.setAllProject(allProject);


		// 累计捐款人次selectConTime
		long selectConTime = helpMapper.selectConTime();
		helpVo.setSelectConTime(selectConTime);
		
		if(selectConTime > 0){
			// 累计捐款额selectMoney
			long selectMoney = helpMapper.selectMoney();
			helpVo.setSelectMoney(selectMoney);
			
		}else{
			helpVo.setSelectMoney(0);
		}
		

		String time = fangwenMapper.selectTime();
		if (time == null) {
			Fangwen fangwen = new Fangwen();
			fangwen.setTime("0");
			fangwenMapper.insert(fangwen);
		}
		long selectTime = Integer.parseInt(time) + 1;
		Fangwen record = new Fangwen();
		record.setId(1);
		record.setTime(Long.toString(selectTime));
		fangwenMapper.updateTime(record);

		// 累计访问量selectTime
		helpVo.setSelectTime(selectTime);

		return helpVo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wdkj.xyfund.service.IHelpService#queryHelpIsTop(java.lang.Integer)
	 */
	public HelpVo queryHelpIsTop(Integer type) throws Exception {
		// TODO Auto-generated method stub
		List<HelpVo> helpVo = helpMapper.selectAndFileIsTop(type);
		HelpVo helpVo2 = new HelpVo();
		if (!ObjectUtil.collectionIsEmpty(helpVo)) {
			helpVo2 = helpVo.get(0);
			Integer initiateNum = helpVo2.getInitiateNum();
			Integer total = helpVo2.getTotal();

			if (initiateNum == null) {
				helpVo2.setInitiateNum(0);
			}

			if (total == null) {
				helpVo2.setTotal(0);
			}
			
			BigDecimal a = helpVo2.getMoney().subtract(helpVo2.getMoneyOff());
			helpVo2.setMoneyNeed(a);
		}
		return helpVo2;
	}

	@Override
	public ResultVo queryLink(Integer type) throws Exception {
		// TODO Auto-generated method stub
		Link link = new Link();
		link.setType(type);
		List<LinkVo> linkList = linkMapper.selectAndFiles(link);
		ResultVo resultVo = new ResultVo();
		resultVo.setRows(linkList);
		return resultVo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wdkj.xyfund.service.IHelpService#saveTempFiles(org.springframework
	 * .web.multipart.MultipartFile[], java.lang.Integer)
	 */
	@Override
	public Message saveTempFiles(MultipartFile[] file, Integer type,
			Integer userId) throws Exception {
		// TODO Auto-generated method stub
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
						diskFileName, "fengmianFile");

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
						temp.setType(type);
						temp.setUserId(userId);
						temp.setFileStatus(false);
						int records = fileMapper.insertSelective(temp);
						if (records > 0) {
							fm.put("fileId", temp.getId());
							fm.put("fileUrl", temp.getFileurl());
							fm.put("type", temp.getType());
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wdkj.xyfund.service.IHelpService#addHelp(com.wdkj.xyfund.controller
	 * .vo.HelpVo)
	 */
	public Message addHelp(HelpApplyVo helpApplyVo, Integer userId,
			String username) throws Exception {
		// TODO Auto-generated method stub
		Message message = new Message();
		HelpApply helpApply = new HelpApply();
		Date createTime = DateUtil.getCurrentDate(DateUtil.DATE_STYLE4);
		helpApplyVo.setApplyDate(createTime);
		helpApplyVo.setStatus(1);
		helpApplyVo.setUserId(userId);
		helpApplyVo.setApplyUsername(username);
		// helpApplyVo.setBirthday(createTime);
		/* helpApplyVo.setInDate(DateUtil)); */
		BeanUtils.copyProperties(helpApply, helpApplyVo);
		int record = helpApplyMapper.insert(helpApply);
		Integer helpApplyId = helpApply.getId();
		if (record > 0) {
			List<FileVo> fileList = helpApplyVo.getHelpFilesUrl();
			for (Iterator iterator = fileList.iterator(); iterator.hasNext();) {
				FileVo fileVo = (FileVo) iterator.next();
				HelpApplyFiles helpApplyFiles = new HelpApplyFiles();
				helpApplyFiles.setType(fileVo.getType());
				helpApplyFiles.setHelpApplyId(helpApplyId);
				helpApplyFiles.setFileId(fileVo.getId());
				helpApplyFilesMapper.insert(helpApplyFiles);

			}
			/*
			 * List<Integer> typeList = helpApplyVo.getTypes(); List<Integer>
			 * fileIdList = helpApplyVo.getFileIds(); for (Iterator iterator =
			 * typeList.iterator(); iterator.hasNext();) { Integer type =
			 * (Integer) iterator.next(); for (Iterator iterator2 =
			 * fileIdList.iterator(); iterator2.hasNext();) { Integer fileId =
			 * (Integer) iterator2.next(); HelpApplyFiles helpApplyFiles = new
			 * HelpApplyFiles(); helpApplyFiles.setType(type);
			 * helpApplyFiles.setHelpApplyId(helpApplyId);
			 * helpApplyFiles.setFileId(fileId);
			 * helpApplyFilesMapper.insert(helpApplyFiles); } }
			 */

			message.setSuccess(true);
		}
		return message;
	}

	public ResultVo queryHelped() throws Exception {
		ResultVo re = new ResultVo();
		List<HelpVo> temp = helpMapper.selectHelped();
		Integer toIndex = 10;
		if (temp.size() < 10) {
			toIndex = temp.size();
		}
		List<HelpVo> rows = temp.subList(0, toIndex);
		re.setRows(rows);
		return re;
	}

	public ResultVo queryLatest() throws Exception {
		ResultVo re = new ResultVo();
		List<ContributionVo> temp = contributionMapper.selectLatestWithHead();
		Integer toIndex = 10;
		if (temp.size() < 10) {
			toIndex = temp.size();
		}
		List<ContributionVo> rows = temp.subList(0, toIndex);
		for (int a = 0; a < rows.size(); a++) {
			rows.get(a).setTimeString(
					DateUtil.getDateStr(DateUtil.DATE_STYLE5, rows.get(a)
							.getCreateTime()));
		}
		re.setRows(rows);
		return re;
	}

	public ResultVo queryVol() throws Exception {
		ResultVo re = new ResultVo();
		UserExample userExample = new UserExample();
		userExample.createCriteria().andIsPostulantEqualTo(true);
		userExample.setOrderByClause("id desc");
		List<User> temp = userMapper.selectByExample(userExample);
		List<UserVo> lists = new ArrayList<>();
		// List<PostulantVo> temp = postulantMapper.selectVol();
		if (!ObjectUtil.collectionIsEmpty(temp)) {
			for (Iterator iterator = temp.iterator(); iterator.hasNext();) {
				User user = (User) iterator.next();
				Date rigDate = user.getRegisterDate();
				UserVo userVo = new UserVo();
				userVo.setRegisterDateStr(DateUtil.getDateStr(DateUtil.DATE_STYLE4, rigDate));
				BeanUtils.copyProperties(userVo, user);
				lists.add(userVo);
			}
		}
		Integer toIndex = 5;
		if (lists.size() < 5) {
			toIndex = lists.size();
		}
		List<UserVo> rows = lists.subList(0, toIndex);
		re.setRows(rows);
		return re;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wdkj.xyfund.service.IHelpService#saveContribution(com.wdkj.xyfund
	 * .controller.vo.ContributionVo)
	 */
	public Message saveContribution(ContributionVo contributionVo)
			throws Exception {
		Message result = new Message();
		//查询捐款用户
		int userId = contributionVo.getUserId();
		User user = new User();
		user = userMapper.selectByPrimaryKey(userId);
		
		Date currentTime = DateUtil.getCurrentDate(DateUtil.DATE_STYLE4);
		
		Contribution cb = new Contribution();
		BeanUtils.copyProperties(cb, contributionVo);
		cb.setCreateTime(currentTime);
		cb.setStatus(1);
		int record = contributionMapper.insertSelective(cb);

		if (record > 0) {
			HelpWithBLOBs hw = helpMapper.selectByPrimaryKey(contributionVo
					.getInfoId());
			Integer total = hw.getTotal();
			hw.setTotal(total + 1);

			BigDecimal moneyOff = hw.getMoneyOff();

			if (moneyOff == null) {
				hw.setMoneyOff(contributionVo.getMoney());
			} else {
				hw.setMoneyOff(moneyOff.add(contributionVo.getMoney()));
			}

			record = helpMapper.updateByPrimaryKeySelective(hw);
			 
			if (record > 0) {
				result.setSuccess(true);
				//添加捐款用户捐款次数
				user.setCount(user.getCount() + 1);
				userMapper.updateByPrimaryKey(user);
					moneyOff =hw.getMoneyOff();
					BigDecimal money = hw.getMoney();
					if(moneyOff.subtract(money).doubleValue()>0){
						hw.setStatus(2);
						helpMapper.updateByPrimaryKey(hw);
					}
			} else {
				throw new RuntimeException();
			}
		}

		return result;
	}

	// 查询孩子
	public ResultVo showChild(ResultVo param) throws Exception {
		// TODO Auto-generated method stub
		ResultVo result = new ResultVo();
		setPageInfo(param.getPageSize(), param.getCurrentpage());
		List<Help> childList = new ArrayList<>();
		HelpExample helpExample = new HelpExample();
		helpExample.createCriteria().andChildNameLike(param.getQueryText()).andTypeEqualTo(1);
		childList = helpMapper.selectByExample(helpExample);
		List<HelpVo> helpVos = new ArrayList<>();
		if(!ObjectUtil.collectionIsEmpty(childList)){
			for (Iterator iterator = childList.iterator(); iterator.hasNext();) {
				Help help = (Help) iterator.next();
				HelpVo helpVo = new HelpVo();
				BeanUtils.copyProperties(helpVo, help);
				helpVos.add(helpVo);
			}
		}
		
		setReturnPageInfo(childList, result);
		result.setRows(helpVos);
		return result;
		
		/*Message message = new Message();
		List<Help> childList = new ArrayList<>();
		HelpExample helpExample = new HelpExample();
		helpExample.createCriteria().andChildNameLike("%" + param + "%");
		childList = helpMapper.selectByExample(helpExample);
		Map<String, Object> result = new HashMap<>();
		result.put("childList", childList);
		message.setResult(result);
		message.setSuccess(true);
		return message;*/
	}
}
