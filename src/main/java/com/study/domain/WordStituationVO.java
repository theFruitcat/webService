package com.study.domain;
/**
 * �龳����ʵ����
 *
 * */
public class WordStituationVO {
    //��������
    private String name;
    //������ַ
    private String voiceAddress;
    //ͼƬ��ַ
    private String pictureAddress;
    //���ķ���
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