package com.study.domain;
/**
 * ���ʱ���ʵ����
 *
 * */
public class WordReciteVO extends WordReciteVOKey {
    //������ַ
    private String voiceAddress;
    //ͼƬ��ַ
    private String pictureAddress;
    //����
    private String explanation;
    //����
    private String exampleSentence;
    //��������
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