package com.study.domain;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * 用于生成单个试题,为前台提供测试题目
 * */
@Component
public class SingleChoiceWordVO {
    //试题类型
    private int type;
    //试题题目
    private String questionStem;
    //试题选项
    private List<String> options;
    //试题答案
    private List<String> answer;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getQuestionStem() {
        return questionStem;
    }

    public void setQuestionStem(String questionStem) {
        this.questionStem = questionStem;
    }

    public List<String> getAnswer() {
        return answer;
    }

    public void setAnswer(List<String> answer) {
        this.answer = answer;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}
