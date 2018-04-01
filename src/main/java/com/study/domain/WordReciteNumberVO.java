package com.study.domain;
/**
 * 单词背诵序号实体类
 * */
public class WordReciteNumberVO extends WordReciteNumberVOKey {
    //单词序号
    private Integer number;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}