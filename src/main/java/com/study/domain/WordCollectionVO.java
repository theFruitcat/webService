package com.study.domain;

public class WordCollectionVO extends WordCollectionVOKey {
    //单词名称
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}