package com.study.domain;
/**
 * �����龳���ʵ����
 * */
public class WordSituationNumberVO {
    //��������
    private String name;
    //�����龳
    private String situation;
    //���ʱ��
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