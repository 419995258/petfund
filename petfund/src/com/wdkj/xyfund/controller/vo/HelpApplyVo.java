package com.wdkj.xyfund.controller.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class HelpApplyVo {
	private Integer id;

	private String child;

	private Integer sex;

	private Date birthday;

	private String nation;

	private String nativePlace;

	private String guardian;

	private Integer guardianAge;

	private String guardianIdNum;

	private String occupation;

	private String tel;

	private Integer isAgr;

	private Integer familys;

	private String incomeStream;

	private BigDecimal yearIncome;

	private BigDecimal peopleYearIncome;

	private BigDecimal money;

	private String diagnosis;

	private String hospital;

	private String doctor;

	private String doctorTel;

	private BigDecimal hoBudget;

	private BigDecimal peBudget;

	private BigDecimal applyBudget;

	private Date inDate;

	private String number;

	private Double reimbursementRatio;

	private Integer status;

	private Integer userId;

	private String applyUsername;

	private Date applyDate;

	private String applyDateStr;

	private String birthdayStr;

	private String inDateStr;
	
	private String relaApply;
	
	 private String cause;
	
	private List<Integer> fileIds;
	private List<Integer> types;
	private List<FileVo> helpFilesUrl;
	
	private Map<String, List<FileVo>> picFiles;

	private boolean hasPassHelp;
	
	
	
	
	
	

	public boolean isHasPassHelp() {
		return hasPassHelp;
	}

	public void setHasPassHelp(boolean hasPassHelp) {
		this.hasPassHelp = hasPassHelp;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public List<Integer> getFileIds() {
		return fileIds;
	}

	public void setFileIds(List<Integer> fileIds) {
		this.fileIds = fileIds;
	}

	public List<Integer> getTypes() {
		return types;
	}

	public void setTypes(List<Integer> types) {
		this.types = types;
	}

	public List<FileVo> getHelpFilesUrl() {
		return helpFilesUrl;
	}

	public void setHelpFilesUrl(List<FileVo> helpFilesUrl) {
		this.helpFilesUrl = helpFilesUrl;
	}

	public String getRelaApply() {
		return relaApply;
	}

	public void setRelaApply(String relaApply) {
		this.relaApply = relaApply;
	}

	public String getBirthdayStr() {
		return birthdayStr;
	}

	public void setBirthdayStr(String birthdayStr) {
		this.birthdayStr = birthdayStr;
	}

	public String getInDateStr() {
		return inDateStr;
	}

	public void setInDateStr(String inDateStr) {
		this.inDateStr = inDateStr;
	}

	public String getApplyDateStr() {
		return applyDateStr;
	}

	public void setApplyDateStr(String applyDateStr) {
		this.applyDateStr = applyDateStr;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getChild() {
		return child;
	}

	public void setChild(String child) {
		this.child = child == null ? null : child.trim();
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation == null ? null : nation.trim();
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace == null ? null : nativePlace.trim();
	}

	public String getGuardian() {
		return guardian;
	}

	public void setGuardian(String guardian) {
		this.guardian = guardian == null ? null : guardian.trim();
	}

	public Integer getGuardianAge() {
		return guardianAge;
	}

	public void setGuardianAge(Integer guardianAge) {
		this.guardianAge = guardianAge;
	}

	public String getGuardianIdNum() {
		return guardianIdNum;
	}

	public void setGuardianIdNum(String guardianIdNum) {
		this.guardianIdNum = guardianIdNum == null ? null : guardianIdNum
				.trim();
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation == null ? null : occupation.trim();
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel == null ? null : tel.trim();
	}

	public Integer getIsAgr() {
		return isAgr;
	}

	public void setIsAgr(Integer isAgr) {
		this.isAgr = isAgr;
	}

	public Integer getFamilys() {
		return familys;
	}

	public void setFamilys(Integer familys) {
		this.familys = familys;
	}

	public String getIncomeStream() {
		return incomeStream;
	}

	public void setIncomeStream(String incomeStream) {
		this.incomeStream = incomeStream == null ? null : incomeStream.trim();
	}

	public BigDecimal getYearIncome() {
		return yearIncome;
	}

	public void setYearIncome(BigDecimal yearIncome) {
		this.yearIncome = yearIncome;
	}

	public BigDecimal getPeopleYearIncome() {
		return peopleYearIncome;
	}

	public void setPeopleYearIncome(BigDecimal peopleYearIncome) {
		this.peopleYearIncome = peopleYearIncome;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis == null ? null : diagnosis.trim();
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital == null ? null : hospital.trim();
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor == null ? null : doctor.trim();
	}

	public String getDoctorTel() {
		return doctorTel;
	}

	public void setDoctorTel(String doctorTel) {
		this.doctorTel = doctorTel == null ? null : doctorTel.trim();
	}

	public BigDecimal getHoBudget() {
		return hoBudget;
	}

	public void setHoBudget(BigDecimal hoBudget) {
		this.hoBudget = hoBudget;
	}

	public BigDecimal getPeBudget() {
		return peBudget;
	}

	public void setPeBudget(BigDecimal peBudget) {
		this.peBudget = peBudget;
	}

	public BigDecimal getApplyBudget() {
		return applyBudget;
	}

	public void setApplyBudget(BigDecimal applyBudget) {
		this.applyBudget = applyBudget;
	}

	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number == null ? null : number.trim();
	}

	public Double getReimbursementRatio() {
		return reimbursementRatio;
	}

	public void setReimbursementRatio(Double reimbursementRatio) {
		this.reimbursementRatio = reimbursementRatio;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getApplyUsername() {
		return applyUsername;
	}

	public void setApplyUsername(String applyUsername) {
		this.applyUsername = applyUsername == null ? null : applyUsername
				.trim();
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public Map<String, List<FileVo>> getPicFiles() {
		return picFiles;
	}

	public void setPicFiles(Map<String, List<FileVo>> picFiles) {
		this.picFiles = picFiles;
	}
	
}