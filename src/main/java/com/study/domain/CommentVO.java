package com.study.domain;

import java.util.Date;
/**
 * 评论实体类
 * */
public class CommentVO extends CommentVOKey {
    //评论人名称
    private String name;
    //评论时间
    private Date commentTime;
    //评论人ID
    private String commentPeopleId;
    //评论内容
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