package com.study.domain;
/**
 * 情境单词实体类
 *
 * */
public class WordSituationVO {
    //单词名称
    private String name;
    //声音地址
    private String voiceAddress;
    //图片地址
    private String pictureAddress;
    //中文翻译
    private String chineseTranslation;
    //情境
    private String situation;
    //单词编号
    private Integer number;

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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getVoiceAddress() {
        return voiceAddress;
    }

    public void setVoiceAddress(String voiceAddress) {
        this.voiceAddress = voiceAddress == null ? null : voiceAddress.trim();
    }

    public String getPictureAddress() {
        return pictureAddress;
    }

    public void setPictureAddress(String pictureAddress) {
        this.pictureAddress = pictureAddress == null ? null : pictureAddress.trim();
    }

    public String getChineseTranslation() {
        return chineseTranslation;
    }

    public void setChineseTranslation(String chineseTranslation) {
        this.chineseTranslation = chineseTranslation == null ? null : chineseTranslation.trim();
    }
}