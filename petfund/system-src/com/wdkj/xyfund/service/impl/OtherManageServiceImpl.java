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
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wdkj.xyfund.controller.vo.LinkVo;
import com.wdkj.xyfund.controller.vo.Message;
import com.wdkj.xyfund.controller.vo.PublictiyVo;
import com.wdkj.xyfund.controller.vo.ResultVo;
import com.wdkj.xyfund.dao.AbountMapper;
import com.wdkj.xyfund.dao.FileMapper;
import com.wdkj.xyfund.dao.LinkFilesMapper;
import com.wdkj.xyfund.dao.LinkMapper;
import com.wdkj.xyfund.dao.PublictiyMapper;
import com.wdkj.xyfund.entity.Abount;
import com.wdkj.xyfund.entity.AbountExample;
import com.wdkj.xyfund.entity.FileExample;
import com.wdkj.xyfund.entity.HelpFiles;
import com.wdkj.xyfund.entity.HelpFilesExample;
import com.wdkj.xyfund.entity.HelpWithBLOBs;
import com.wdkj.xyfund.entity.Link;
import com.wdkj.xyfund.entity.LinkExample;
import com.wdkj.xyfund.entity.LinkFiles;
import com.wdkj.xyfund.entity.LinkFilesExample;
import com.wdkj.xyfund.entity.Publictiy;
import com.wdkj.xyfund.entity.PublictiyExample.Criteria;
import com.wdkj.xyfund.entity.PublictiyExample;
import com.wdkj.xyfund.service.IOtherManageService;
import com.wdkj.xyfund.util.DateUtil;
import com.wdkj.xyfund.util.FileOperationUtil;
import com.wdkj.xyfund.util.ObjectUtil;
import com.wdkj.xyfund.util.StringContentUtil;

@Service("othermanageService")
public class OtherManageServiceImpl implements IOtherManageService {

	@Autowired
	private AbountMapper abountMapper;

	@Autowired
	private PublictiyMapper publictiyMapper;

	@Autowired
	private LinkMapper linkMapper;

	@Autowired
	private FileMapper fileMapper;

	@Autowired
	private LinkFilesMapper linkFilesMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wdkj.xyfund.service.IOtherManageService#query(com.wdkj.xyfund.entity
	 * .Abount)
	 */
	public Abount query(Abount abount) throws Exception {
		// TODO 查询关于我们
		// int id = abount.getId();
		AbountExample abountExample = new AbountExample();
		// abountExample.createCriteria().andIdEqualTo(id);
		List<Abount> abountList = abountMapper
				.selectByExampleWithBLOBs(abountExample);
		if (!ObjectUtil.collectionIsEmpty(abountList)) {
			abount = abountList.get(0);

		}

		return abount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wdkj.xyfund.service.IOtherManageService#update(com.wdkj.xyfund.entity
	 * .Abount)
	 */
	public Message update(Abount abount) throws Exception {
		// TODO 更新关于我们
		Message message = new Message();

		int record = abountMapper.updateByPrimaryKeyWithBLOBs(abount);

		if (record > 0) {
			message.setSuccess(true);
		}
		return message;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wdkj.xyfund.service.IOtherManageService#setPageInfo(java.lang.Integer
	 * , java.lang.Integer)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wdkj.xyfund.service.IOtherManageService#setReturnPageInfo(java.lang
	 * .Integer, java.lang.Integer, java.util.List,
	 * com.wdkj.xyfund.controller.vo.ResultVo)
	 */
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
	 * 
	 * @see
	 * com.wdkj.xyfund.service.IOtherManageService#addPublictiy(com.wdkj.xyfund
	 * .controller.vo.PublictiyVo)
	 */
	public Message addPublictiy(PublictiyVo publictiyVo) throws Exception {
		// TODO Auto-generated method stub
		Message message = new Message();
		Publictiy publictiy = new Publictiy();
		publictiyVo.setStatus(0);
		BeanUtils.copyProperties(publictiy, publictiyVo);
		publictiy.setTime(DateUtil.parseDate(DateUtil.DATE_STYLE4,
				publictiyVo.getTimeStr()));
		int record = publictiyMapper.insert(publictiy);
		if (record > 0) {
			message.setSuccess(true);
		}
		return message;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wdkj.xyfund.service.IOtherManageService#selectPublictiy(com.wdkj.
	 * xyfund.controller.vo.ResultVo)
	 */
	public ResultVo selectPublictiy(ResultVo param) throws Exception {
		// TODO Auto-generated method stub
		ResultVo resultVo = new ResultVo();
		List<PublictiyVo> publictiyVos = new ArrayList<PublictiyVo>();

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
		PublictiyExample publictiyExample = new PublictiyExample();
		publictiyExample.setOrderByClause("id desc");
		Criteria cr = publictiyExample.createCriteria();

		// 查询不同种类
		Integer queryType = param.getQueryType();

		if (queryType == 1) {
			cr.andTimeEqualTo(DateUtil.parseDate(DateUtil.DATE_STYLE4,
					param.getQueryText()));
		} else if (queryType == 2) {
			cr.andNameLike(param.getQueryText());
		}

		List<Publictiy> publictiysList = publictiyMapper
				.selectByExampleWithBLOBs(publictiyExample);

		if (!ObjectUtil.collectionIsEmpty(publictiysList)) {

			for (Iterator iterator = publictiysList.iterator(); iterator
					.hasNext();) {
				Publictiy publictiy = (Publictiy) iterator.next();
				PublictiyVo temp = new PublictiyVo();
				BeanUtils.copyProperties(temp, publictiy);
				Date time = publictiy.getTime();
				temp.setTimeStr(DateUtil.getDateStr(DateUtil.DATE_STYLE4, time));
				publictiyVos.add(temp);
			}

		}

		this.setReturnPageInfo(psize, pageNum, publictiysList, resultVo);
		resultVo.setRows(publictiyVos);
		return resultVo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wdkj.xyfund.service.IOtherManageService#deletePublictiy(com.wdkj.
	 * xyfund.controller.vo.PublictiyVo)
	 */
	public Message deletePublictiy(PublictiyVo publictiyVo) throws Exception {
		// TODO Auto-generated method stub
		Message message = new Message();
		int id = publictiyVo.getId();

		int record = publictiyMapper.deleteByPrimaryKey(id);
		if (record > 0) {
			message.setSuccess(true);
		}
		return message;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wdkj.xyfund.service.IOtherManageService#showPublictiyData(com.wdkj
	 * .xyfund.controller.vo.PublictiyVo)
	 */
	public PublictiyVo showPublictiyData(PublictiyVo publictiyVo)
			throws Exception {
		// TODO Auto-generated method stub
		int id = publictiyVo.getId();
		Publictiy publictiy = new Publictiy();
		PublictiyExample publictiyExample = new PublictiyExample();
		publictiyExample.createCriteria().andIdEqualTo(id);
		List<Publictiy> publictiyList = publictiyMapper
				.selectByExampleWithBLOBs(publictiyExample);
		if (!ObjectUtil.collectionIsEmpty(publictiyList)) {

			publictiy = publictiyList.get(0);
			BeanUtils.copyProperties(publictiyVo, publictiy);
			Date Time = publictiy.getTime();
			publictiyVo.setTimeStr(DateUtil.getDateStr(DateUtil.DATE_STYLE4,
					Time));

		}
		return publictiyVo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wdkj.xyfund.service.IOtherManageService#updatePublictiy(com.wdkj.
	 * xyfund.controller.vo.PublictiyVo)
	 */
	public Message updatePublictiy(PublictiyVo publictiyVo) throws Exception {
		// TODO Auto-generated method stub
		Message message = new Message();
		Publictiy publictiy = new Publictiy();

		BeanUtils.copyProperties(publictiy, publictiyVo);
		publictiy.setTime(DateUtil.parseDate(DateUtil.DATE_STYLE4,
				publictiyVo.getTimeStr()));

		int record = publictiyMapper.updateByPrimaryKeyWithBLOBs(publictiy);
		if (record > 0) {
			message.setSuccess(true);
		}

		return message;
	}

	public Message addLink(LinkVo linkVo) throws Exception {
		// TODO Auto-generated method stub
		Message message = new Message();
		Link link = new Link();
		linkVo.setStatus(0);
		linkVo.setType(2);
		Date date = DateUtil.getCurrentDate(DateUtil.DATE_STYLE4);
		linkVo.setDate(date);
		BeanUtils.copyProperties(link, linkVo);

		int record = linkMapper.insert(link);
		if (record > 0) {
			message.setSuccess(true);
		}
		return message;
	}

	public ResultVo selectLink(ResultVo param) throws Exception {
		// TODO Auto-generated method stub
		ResultVo resultVo = new ResultVo();
		List<LinkVo> linkVos = new ArrayList<LinkVo>();

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
		/*
		 * LinkExample linkExample= new LinkExample();
		 * com.wdkj.xyfund.entity.LinkExample.Criteria cr =
		 * linkExample.createCriteria(); cr.andTypeEqualTo(param.getType());
		 * 
		 * //查询不同种类 Integer queryType = param.getQueryType();
		 * 
		 * if (queryType == 1) {
		 * cr.andDateEqualTo(DateUtil.parseDate(DateUtil.DATE_STYLE4,
		 * param.getQueryText())); } else if (queryType == 2) {
		 * cr.andNameLike(param.getQueryText()); }else if(queryType ==3) {
		 * cr.andUrlLike(param.getQueryText()); }
		 */

		/*
		 * List<Link> linkList= linkMapper.selectByExample(linkExample);
		 * 
		 * if (!ObjectUtil.collectionIsEmpty(linkList)) {
		 * 
		 * for (Iterator iterator = linkList.iterator(); iterator.hasNext();) {
		 * Link link= (Link) iterator.next(); LinkVo temp = new LinkVo();
		 * BeanUtils.copyProperties(temp, link); Date date = link.getDate();
		 * temp.setDateStr(DateUtil.getDateStr(DateUtil.DATE_STYLE4, date));
		 * List<com.wdkj.xyfund.entity.File> linkFileUrl =
		 * fileMapper.selectFileUrlFromLinkByPrimaryKey(temp.getId());
		 * temp.setLinkFilesUrl(linkFileUrl); linkVos.add(temp); }
		 * 
		 * }
		 */
		Integer queryType = param.getQueryType();

		Link link = new Link();
		link.setType(param.getType());

		if (queryType == 1) {
		} else if (queryType == 2) {
			link.setName("%" + param.getQueryText() + "%");
		} else if (queryType == 3) {
			link.setUrl("%" + param.getQueryText() + "%");
		}

		List<LinkVo> linkList = linkMapper.selectAndFiles(link);
		if (!ObjectUtil.collectionIsEmpty(linkList)) {
			for (Iterator iterator = linkList.iterator(); iterator.hasNext();) {
				LinkVo linkVo = (LinkVo) iterator.next();
				/*
				 * LinkVo temp = new LinkVo(); BeanUtils.copyProperties(temp,
				 * linkVo);
				 */
				Date date = linkVo.getDate();
				linkVo.setDateStr(DateUtil.getDateStr(DateUtil.DATE_STYLE4,
						date));
				// linkList.add(linkVo);

			}

		}
		this.setReturnPageInfo(psize, pageNum, linkList, resultVo);
		resultVo.setRows(linkList);
		return resultVo;
	}

	public Message deleteLink(LinkVo linkVo) throws Exception {
		// TODO Auto-generated method stub
		Message message = new Message();
		int id = linkVo.getId();

		if (linkVo.getType() == 1) {
			// 获取fileId
			LinkFilesExample linkFilesExample = new LinkFilesExample();
			linkFilesExample.createCriteria().andLinkIdEqualTo(id);
			List<LinkFiles> linkList = linkFilesMapper
					.selectByExample(linkFilesExample);
			LinkFiles linkFiles = new LinkFiles();
			int fileId = 0;
			if (!ObjectUtil.collectionIsEmpty(linkList)) {
				linkFiles = linkList.get(0);
				fileId = linkFiles.getFileId();
			}

			// 删除file表
			if (fileId != 0) {
				com.wdkj.xyfund.entity.File file = new com.wdkj.xyfund.entity.File();
				FileExample fileExample = new FileExample();
				fileExample.createCriteria().andIdEqualTo(fileId);
				List<com.wdkj.xyfund.entity.File> files = fileMapper
						.selectByExample(fileExample);
				if (!ObjectUtil.collectionIsEmpty(files)) {
					file = files.get(0);
				}

				int record = fileMapper.deleteByPrimaryKey(fileId);

				// 删除文件
				if (record > 0) {
					FileOperationUtil.deleteFile2(file.getFileurl());
				}
			}
		}
		// 删除link表
		int record = linkMapper.deleteByPrimaryKey(id);
		if (record > 0) {
			message.setSuccess(true);
		}
		return message;
	}

	public LinkVo showLinkData(LinkVo linkVo) throws Exception {
		// TODO Auto-generated method stub
		int id = linkVo.getId();
		Link link = new Link();
		LinkExample linkExample = new LinkExample();
		linkExample.createCriteria().andIdEqualTo(id);
		List<Link> linkList = linkMapper.selectByExample(linkExample);
		if (!ObjectUtil.collectionIsEmpty(linkList)) {

			link = linkList.get(0);
			BeanUtils.copyProperties(linkVo, link);
			Date Date = link.getDate();
			linkVo.setDateStr(DateUtil.getDateStr(DateUtil.DATE_STYLE4, Date));
			List<com.wdkj.xyfund.entity.File> linkFileUrl = fileMapper
					.selectFileUrlFromLinkByPrimaryKey(id);
			linkVo.setLinkFilesUrl(linkFileUrl);
		}
		return linkVo;
	}

	public Message updateLink(LinkVo linkVo) throws Exception {
		// TODO Auto-generated method stub
		Message message = new Message();
		Link link = new Link();

		BeanUtils.copyProperties(link, linkVo);

		int record = linkMapper.updateByPrimaryKey(link);
		if (record > 0) {
			message.setSuccess(true);
		}

		return message;
	}

	public Message addThanks(LinkVo linkVo) throws Exception {
		// TODO Auto-generated method stub

		Message message = new Message();
		Link link = new Link();
		linkVo.setStatus(0);
		linkVo.setType(1);
		Date date = DateUtil.getCurrentDate(DateUtil.DATE_STYLE4);
		linkVo.setDate(date);
		BeanUtils.copyProperties(link, linkVo);

		int record = linkMapper.insert(link);
		if (record > 0) {
			List<Integer> fileIds = linkVo.getFileIds();
			Integer linkId = link.getId();
			for (Iterator iterator = fileIds.iterator(); iterator.hasNext();) {
				Integer integer = (Integer) iterator.next();
				LinkFiles linkFiles = new LinkFiles();
				linkFiles.setFileId(integer);
				linkFiles.setLinkId(linkId);
				linkFilesMapper.insert(linkFiles);
			}
			message.setSuccess(true);
		}
		return message;
	}

	public Message updateThanks(LinkVo linkVo) throws Exception {
		// TODO Auto-generated method stub
		Message message = new Message();

		if (linkVo.getOldFileIds() != null) {
			// 删除旧文件记录

			LinkFilesExample linkFilesExample = new LinkFilesExample();
			linkFilesExample.createCriteria().andFileIdEqualTo(
					linkVo.getOldFileIds());
			linkFilesMapper.deleteByExample(linkFilesExample);
		}

		Link link = new Link();

		BeanUtils.copyProperties(link, linkVo);

		int record = linkMapper.updateByPrimaryKey(link);
		if (record > 0) {
			List<Integer> fileIds = linkVo.getFileIds();
			Integer linkId = link.getId();
			for (Iterator iterator = fileIds.iterator(); iterator.hasNext();) {
				Integer integer = (Integer) iterator.next();
				LinkFiles linkFiles = new LinkFiles();
				linkFiles.setFileId(integer);
				linkFiles.setLinkId(linkId);
				linkFilesMapper.insert(linkFiles);
			}
			message.setSuccess(true);
		}

		return message;
	}

	public Message saveTempFiles(MultipartFile[] file) throws Exception {
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
						diskFileName, "linkFile");

				/*
				 * 保存数据库逻辑
				 */

				if (m.getSuccess()) {
					try {
						// 保存文件记录
						com.wdkj.xyfund.entity.File temp = new com.wdkj.xyfund.entity.File();
						temp.setName(fileName);
						temp.setFileurl((String) m.getResult().get("filePath"));
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

}
