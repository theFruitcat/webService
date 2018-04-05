package com.study.domain;
/**
 * 背诵单词编号实体类
 * */
public class WordReciteNumberVO extends WordReciteNumberVOKey {
    //单词编号
    private Integer number;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}