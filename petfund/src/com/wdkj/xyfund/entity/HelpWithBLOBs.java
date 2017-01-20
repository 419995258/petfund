package com.wdkj.xyfund.entity;

public class HelpWithBLOBs extends Help {
    private String content;

    private String caseInfo;

    private String thanks;

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
}