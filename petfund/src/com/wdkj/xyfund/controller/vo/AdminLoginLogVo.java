package com.wdkj.xyfund.controller.vo;

import java.util.Date;

public class AdminLoginLogVo {
    private Integer id;

    private Integer userId;

    private Date loginDate;

    private String username;

    private String realname;
    
    private String loginDateStr;
    
    

    public String getLoginDateStr() {
		return loginDateStr;
	}

	public void setLoginDateStr(String loginDateStr) {
		this.loginDateStr = loginDateStr;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }
}