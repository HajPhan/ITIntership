package com.example.ToeicOnline.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Result {
    private long resultid;
    private int listenscore;
    private int readingscore;
    private long examinationid;
    private long userid;
    private Timestamp createddate;
    private Timestamp modifieddate;

    @Id
    @Column(name = "resultid")
    public long getResultid() {
        return resultid;
    }

    public void setResultid(long resultid) {
        this.resultid = resultid;
    }

    @Basic
    @Column(name = "listenscore")
    public int getListenscore() {
        return listenscore;
    }

    public void setListenscore(int listenscore) {
        this.listenscore = listenscore;
    }

    @Basic
    @Column(name = "readingscore")
    public int getReadingscore() {
        return readingscore;
    }

    public void setReadingscore(int readingscore) {
        this.readingscore = readingscore;
    }

    @Basic
    @Column(name = "examinationid")
    public long getExaminationid() {
        return examinationid;
    }

    public void setExaminationid(long examinationid) {
        this.examinationid = examinationid;
    }

    @Basic
    @Column(name = "userid")
    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "createddate")
    public Timestamp getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Timestamp createddate) {
        this.createddate = createddate;
    }

    @Basic
    @Column(name = "modifieddate")
    public Timestamp getModifieddate() {
        return modifieddate;
    }

    public void setModifieddate(Timestamp modifieddate) {
        this.modifieddate = modifieddate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result = (Result) o;

        if (resultid != result.resultid) return false;
        if (listenscore != result.listenscore) return false;
        if (readingscore != result.readingscore) return false;
        if (examinationid != result.examinationid) return false;
        if (userid != result.userid) return false;
        if (createddate != null ? !createddate.equals(result.createddate) : result.createddate != null) return false;
        if (modifieddate != null ? !modifieddate.equals(result.modifieddate) : result.modifieddate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (resultid ^ (resultid >>> 32));
        result = 31 * result + listenscore;
        result = 31 * result + readingscore;
        result = 31 * result + (int) (examinationid ^ (examinationid >>> 32));
        result = 31 * result + (int) (userid ^ (userid >>> 32));
        result = 31 * result + (createddate != null ? createddate.hashCode() : 0);
        result = 31 * result + (modifieddate != null ? modifieddate.hashCode() : 0);
        return result;
    }
}
