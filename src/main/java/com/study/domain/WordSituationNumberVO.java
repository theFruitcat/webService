package com.study.domain;
/**
 * 单词情境序号实体类
 * */
public class WordSituationNumberVO {
    //单词名称
    private String name;
    //单词情境
    private String situation;
    //单词编号
    private Integer number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation == null ? null : situation.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}