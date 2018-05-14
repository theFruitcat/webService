package com.study.domain;

import org.springframework.stereotype.Component;

import java.security.PrivateKey;
import java.util.List;
/**
 *
 * 试卷类试题
 * */
public class ExaminationVO {
    //试卷标题
    private String title;
    //试卷信息
    private String info;
    //试卷题目
    private List<SingleChoiceWordVO> values;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<SingleChoiceWordVO> getValues() {
        return values;
    }

    public void setValues(List<SingleChoiceWordVO> values) {
        this.values = values;
    }
}
