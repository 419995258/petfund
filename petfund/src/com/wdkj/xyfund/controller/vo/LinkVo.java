package com.wdkj.xyfund.controller.vo;

import java.util.Date;
import java.util.List;

import com.wdkj.xyfund.entity.File;

public class LinkVo {
    private Integer id;

    private String name;

    private String url;

    private Date date;

    private Integer status;

    private Integer type;

    private String dateStr;
    
    private List<Integer> fileIds;
	private List<File> linkFilesUrl;

	private String fileurl;
	
	private Integer oldFileIds;
	
	
    
    public Integer getOldFileIds() {
		return oldFileIds;
	}

	public void setOldFileIds(Integer oldFileIds) {
		this.oldFileIds = oldFileIds;
	}

	public List<Integer> getFileIds() {
		return fileIds;
	}

	public void setFileIds(List<Integer> fileIds) {
		this.fileIds = fileIds;
	}

	public List<File> getLinkFilesUrl() {
		return linkFilesUrl;
	}

	public void setLinkFilesUrl(List<File> linkFilesUrl) {
		this.linkFilesUrl = linkFilesUrl;
	}

	public String getDateStr() {
		return dateStr;
	}

	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
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
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

	public String getFileurl() {
		return fileurl;
	}

	public void setFileurl(String fileurl) {
		this.fileurl = fileurl == null ? "" : ".." + fileurl.trim();
	}
    
}