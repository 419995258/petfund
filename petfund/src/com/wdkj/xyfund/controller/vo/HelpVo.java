package com.wdkj.xyfund.controller.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class HelpVo {
	private Integer id;

	private String title;//求助标题

	private String childName;//被救助的孩子姓名,标题，病名

	private Integer sex;//性别

	private Integer age;//年龄

	private String cityNum;//城市

	private BigDecimal money;//目标金额

	private String personName;//发起人名称

	private Integer status;

	private Date createTime;//创建时间

	private Integer type;//求助类型 1:紧急筹款 2:将爱汇聚 3:让爱传递

	private BigDecimal moneyOff;//已完成捐助的金额

	private Boolean isTop;//是否置顶

	private String content;//详细介绍

	private String caseInfo;//病例

	private String thanks;//父母感言
	
	private String payPas;

	private String createTimeStr;//创建时间前台显示用
	
	private List<Integer> fileIds;
	private List<Integer> types;
	private List<FileVo> helpFilesUrl;
	
	private BigDecimal jzmoney;//捐助人捐助的金额
	
	private String fileurl;//图片文件路径
	
	private Integer total; //在捐款人数

    private Integer personId; //发起人id
    
    private Integer initiateNum; //发起了多少项目
    
    private long allProject;
    
    private long selectMoney;
    
    private long selectConTime;
    
    private long selectTime;
    
    private String time;
    
    private Integer oldFileIds;
    
    private BigDecimal moneyNeed;
    
    
    
    
    
    

	public BigDecimal getMoneyNeed() {
		return moneyNeed;
	}

	public void setMoneyNeed(BigDecimal moneyNeed) {
		this.moneyNeed = moneyNeed;
	}

	public List<Integer> getTypes() {
		return types;
	}

	public void setTypes(List<Integer> types) {
		this.types = types;
	}

	public Integer getOldFileIds() {
		return oldFileIds;
	}

	public void setOldFileIds(Integer oldFileIds) {
		this.oldFileIds = oldFileIds;
	}

	public long getSelectTime() {
		return selectTime;
	}

	public void setSelectTime(long selectTime) {
		this.selectTime = selectTime;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public long getSelectConTime() {
		return selectConTime;
	}

	public void setSelectConTime(long selectConTime) {
		this.selectConTime = selectConTime;
	}

	public long getSelectMoney() {
		return selectMoney;
	}

	public void setSelectMoney(long selectMoney) {
		this.selectMoney = selectMoney;
	}

	public long getAllProject() {
		return allProject;
	}

	public void setAllProject(long allProject) {
		this.allProject = allProject;
	}

	public List<FileVo> getHelpFilesUrl() {
		return helpFilesUrl;
	}

	public void setHelpFilesUrl(List<FileVo> helpFilesUrl) {
		this.helpFilesUrl = helpFilesUrl;
	}

	public List<Integer> getFileIds() {
		return fileIds;
	}

	public void setFileIds(List<Integer> fileIds) {
		this.fileIds = fileIds;
	}

	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public String getCaseInfo() {
		return caseInfo;
	}

	public void setCaseInfo(String caseInfo) {
		this.caseInfo = caseInfo == null ? null : caseInfo.trim();
	}

	public String getThanks() {
		return thanks;
	}

	public void setThanks(String thanks) {
		this.thanks = thanks == null ? null : thanks.trim();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName == null ? null : childName.trim();
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCityNum() {
		return cityNum;
	}

	public void setCityNum(String cityNum) {
		this.cityNum = cityNum == null ? null : cityNum.trim();
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName == null ? null : personName.trim();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public BigDecimal getMoneyOff() {
		return moneyOff;
	}

	public void setMoneyOff(BigDecimal moneyOff) {
		this.moneyOff = moneyOff;
	}

	public Boolean getIsTop() {
		return isTop;
	}

	public void setIsTop(Boolean isTop) {
		this.isTop = isTop;
	}

	public BigDecimal getJzmoney() {
		return jzmoney;
	}

	public void setJzmoney(BigDecimal jzmoney) {
		this.jzmoney = jzmoney;
	}

	public String getFileurl() {
		return fileurl;
	}

	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public Integer getInitiateNum() {
		return initiateNum;
	}

	public void setInitiateNum(Integer initiateNum) {
		this.initiateNum = initiateNum;
	}

    public String getPayPas() {
        return payPas;
    }

    public void setPayPas(String payPas) {
        this.payPas = payPas;
    }
	
}