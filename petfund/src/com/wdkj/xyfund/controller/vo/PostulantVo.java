package com.wdkj.xyfund.controller.vo;

import java.util.Date;
import java.util.List;

import com.wdkj.xyfund.entity.File;
import com.wdkj.xyfund.entity.Postulant;
import com.wdkj.xyfund.entity.PostulantFiles;


public class PostulantVo {
	private Integer id;

    private String name;

    private String idNumber;

    private Integer idType;

    private String tel;

    private Date birthday;

    private String country;

    private String nation;

    private String zzmm;

    private String school;

    private String level;

    private String professionType;

    private String profession;

    private String cLanguage;

    private String eLanguage;

    private String eLanguageLevel;

    private Integer bloodGroup;

    private String nativePlace;

    private String zone;

    private String address;

    private String zipCode;

    private String telephone;

    private String otherTel;

    private String title;

    private String unit;

    private String unitTradeType;

    private String unitType;

    private String serviceArea;

    private String serviceObject;

    private Date isServiceDate;

    private Date serviceDate;

    private Date trainingDate;

    private Integer status;

    private Integer sex;
    
	private Integer postulantId;
	private Integer fileId;
	private List<Postulant> postulantItems;
	private List<Integer> fileIds;
	
	private String birthdayStr;
	private String isServiceDateStr;
	private String serviceDateStr;
	private String trainingDateStr;
	private Integer userId;

	private List<File> postulantFilesIds;
	private List<FileVo> postulantFilesUrl;

	private List<DictionaryVo> services; //服务项目
	private List<DictionaryVo> skills;//专业技能
	
	private String head;
	
	public String getIsServiceDateStr() {
		return isServiceDateStr;
	}

	public void setIsServiceDateStr(String isServiceDateStr) {
		this.isServiceDateStr = isServiceDateStr;
	}

	public String getServiceDateStr() {
		return serviceDateStr;
	}

	public void setServiceDateStr(String serviceDateStr) {
		this.serviceDateStr = serviceDateStr;
	}

	public String getTrainingDateStr() {
		return trainingDateStr;
	}

	public void setTrainingDateStr(String trainingDateStr) {
		this.trainingDateStr = trainingDateStr;
	}

	public List<File> getPostulantFilesIds() {
		return postulantFilesIds;
	}

	public void setPostulantFilesIds(List<File> postulantFilesIds) {
		this.postulantFilesIds = postulantFilesIds;
	}

	public List<FileVo> getPostulantFilesUrl() {
		return postulantFilesUrl;
	}

	public void setPostulantFilesUrl(List<FileVo> postulantFilesUrl) {
		this.postulantFilesUrl = postulantFilesUrl;
	}

	public List<Integer> getFileIds() {
		return fileIds;
	}

	public void setFileIds(List<Integer> fileIds) {
		this.fileIds = fileIds;
	}

	public Integer getPostulantId() {
		return postulantId;
	}

	public void setPostulantId(Integer postulantId) {
		this.postulantId = postulantId;
	}

	public Integer getFileId() {
		return fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public List<Postulant> getPostulantItems() {
		return postulantItems;
	}

	public void setPostulantItems(List<Postulant> postulantItems) {
		this.postulantItems = postulantItems;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public Integer getIdType() {
		return idType;
	}

	public void setIdType(Integer idType) {
		this.idType = idType;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getZzmm() {
		return zzmm;
	}

	public void setZzmm(String zzmm) {
		this.zzmm = zzmm;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getProfessionType() {
		return professionType;
	}

	public void setProfessionType(String professionType) {
		this.professionType = professionType;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getcLanguage() {
		return cLanguage;
	}

	public void setcLanguage(String cLanguage) {
		this.cLanguage = cLanguage;
	}

	public String geteLanguage() {
		return eLanguage;
	}

	public void seteLanguage(String eLanguage) {
		this.eLanguage = eLanguage;
	}

	public String geteLanguageLevel() {
		return eLanguageLevel;
	}

	public void seteLanguageLevel(String eLanguageLevel) {
		this.eLanguageLevel = eLanguageLevel;
	}

	public Integer getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(Integer bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getOtherTel() {
		return otherTel;
	}

	public void setOtherTel(String otherTel) {
		this.otherTel = otherTel;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getUnitTradeType() {
		return unitTradeType;
	}

	public void setUnitTradeType(String unitTradeType) {
		this.unitTradeType = unitTradeType;
	}

	public String getUnitType() {
		return unitType;
	}

	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}

	public String getServiceArea() {
		return serviceArea;
	}

	public void setServiceArea(String serviceArea) {
		this.serviceArea = serviceArea;
	}

	public String getServiceObject() {
		return serviceObject;
	}

	public void setServiceObject(String serviceObject) {
		this.serviceObject = serviceObject;
	}

	public Date getIsServiceDate() {
		return isServiceDate;
	}

	public void setIsServiceDate(Date isServiceDate) {
		this.isServiceDate = isServiceDate;
	}

	public Date getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(Date serviceDate) {
		this.serviceDate = serviceDate;
	}

	public Date getTrainingDate() {
		return trainingDate;
	}

	public void setTrainingDate(Date trainingDate) {
		this.trainingDate = trainingDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getBirthdayStr() {
		return birthdayStr;
	}

	public void setBirthdayStr(String birthdayStr) {
		this.birthdayStr = birthdayStr;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<DictionaryVo> getServices() {
		return services;
	}

	public void setServices(List<DictionaryVo> services) {
		this.services = services;
	}

	public List<DictionaryVo> getSkills() {
		return skills;
	}

	public void setSkills(List<DictionaryVo> skills) {
		this.skills = skills;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}
	
}
