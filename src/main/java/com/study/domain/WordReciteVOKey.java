package com.study.domain;
/**
 *  背诵单词主键实体类
 * */
public class WordReciteVOKey {
    //类别ID
    private Integer catagoryId;
    //单词名称
    private String name;

    public Integer getCatagoryId() {
        return catagoryId;
    }

    public void setCatagoryId(Integer catagoryId) {
        this.catagoryId = catagoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}