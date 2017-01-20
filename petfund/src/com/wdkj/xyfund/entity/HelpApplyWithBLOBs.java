package com.wdkj.xyfund.entity;

public class HelpApplyWithBLOBs extends HelpApply {
    private byte[] relation;

    private String cause;

    public byte[] getRelation() {
        return relation;
    }

    public void setRelation(byte[] relation) {
        this.relation = relation;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause == null ? null : cause.trim();
    }
}