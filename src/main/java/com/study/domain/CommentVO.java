package com.study.domain;

import java.util.Date;
/**
 * ����ʵ����
 * */
public class CommentVO extends CommentVOKey {
    //����������
    private String name;
    //����ʱ��
    private Date commentTime;
    //������ID
    private String commentPeopleId;
    //��������
    private String commentContent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public String getCommentPeopleId() {
        return commentPeopleId;
    }

    public void setCommentPeopleId(String commentPeopleId) {
        this.commentPeopleId = commentPeopleId == null ? null : commentPeopleId.trim();
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }
}