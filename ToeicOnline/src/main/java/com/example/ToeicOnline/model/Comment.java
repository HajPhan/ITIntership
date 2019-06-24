package com.example.ToeicOnline.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Comment {
    private long commentid;
    private String content;
    private Long userid;
    private Long listenguidelineid;
    private Timestamp createddate;

    @Id
    @Column(name = "commentid")
    public long getCommentid() {
        return commentid;
    }

    public void setCommentid(long commentid) {
        this.commentid = commentid;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "userid")
    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "listenguidelineid")
    public Long getListenguidelineid() {
        return listenguidelineid;
    }

    public void setListenguidelineid(Long listenguidelineid) {
        this.listenguidelineid = listenguidelineid;
    }

    @Basic
    @Column(name = "createddate")
    public Timestamp getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Timestamp createddate) {
        this.createddate = createddate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (commentid != comment.commentid) return false;
        if (content != null ? !content.equals(comment.content) : comment.content != null) return false;
        if (userid != null ? !userid.equals(comment.userid) : comment.userid != null) return false;
        if (listenguidelineid != null ? !listenguidelineid.equals(comment.listenguidelineid) : comment.listenguidelineid != null)
            return false;
        if (createddate != null ? !createddate.equals(comment.createddate) : comment.createddate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (commentid ^ (commentid >>> 32));
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (listenguidelineid != null ? listenguidelineid.hashCode() : 0);
        result = 31 * result + (createddate != null ? createddate.hashCode() : 0);
        return result;
    }
}
