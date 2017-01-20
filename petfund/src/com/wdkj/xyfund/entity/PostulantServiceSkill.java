package com.wdkj.xyfund.entity;

public class PostulantServiceSkill {
    private Integer id;

    private Integer dictionaryId;

    private Integer postulantId;

    private String other;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDictionaryId() {
        return dictionaryId;
    }

    public void setDictionaryId(Integer dictionaryId) {
        this.dictionaryId = dictionaryId;
    }

    public Integer getPostulantId() {
        return postulantId;
    }

    public void setPostulantId(Integer postulantId) {
        this.postulantId = postulantId;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }
}