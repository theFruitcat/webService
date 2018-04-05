package com.study.domain;
/**
 * 背诵单词实体类
 *
 * */
public class WordReciteVO extends WordReciteVOKey {
    //ַ声音地址
    private String voiceAddress;
    //图片地址
    private String pictureAddress;
    //释义
    private String explanation;
    //例句
    private String exampleSentence;
    //例句释义
    private String sentenceTranslate;

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

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation == null ? null : explanation.trim();
    }

    public String getExampleSentence() {
        return exampleSentence;
    }

    public void setExampleSentence(String exampleSentence) {
        this.exampleSentence = exampleSentence == null ? null : exampleSentence.trim();
    }

    public String getSentenceTranslate() {
        return sentenceTranslate;
    }

    public void setSentenceTranslate(String sentenceTranslate) {
        this.sentenceTranslate = sentenceTranslate == null ? null : sentenceTranslate.trim();
    }
}