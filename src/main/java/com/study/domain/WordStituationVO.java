package com.study.domain;
/**
 * 情境单词实体类
 *
 * */
public class WordStituationVO {
    //单词名称
    private String name;
    //声音地址
    private String voiceAddress;
    //图片地址
    private String pictureAddress;
    //中文翻译
    private String chineseTranslation;

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