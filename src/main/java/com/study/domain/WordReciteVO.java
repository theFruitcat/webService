package com.study.domain;
/**
 * µ•¥ ±≥À– µÃÂ¿‡
 *
 * */
public class WordReciteVO extends WordReciteVOKey {
    //…˘“Ùµÿ÷∑
    private String voiceAddress;
    //Õº∆¨µÿ÷∑
    private String pictureAddress;
    // Õ“Â
    private String explanation;
    //¿˝æ‰
    private String exampleSentence;
    //¿˝æ‰ Õ“Â
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