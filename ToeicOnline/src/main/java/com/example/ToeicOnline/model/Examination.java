package com.example.ToeicOnline.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Examination {
    private long examinationid;
    private String name;
    private Timestamp createddate;
    private Timestamp modifieddate;

    @Id
    @Column(name = "examinationid")
    public long getExaminationid() {
        return examinationid;
    }

    public void setExaminationid(long examinationid) {
        this.examinationid = examinationid;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        Examination that = (Examination) o;

        if (examinationid != that.examinationid) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (createddate != null ? !createddate.equals(that.createddate) : that.createddate != null) return false;
        if (modifieddate != null ? !modifieddate.equals(that.modifieddate) : that.modifieddate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (examinationid ^ (examinationid >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (createddate != null ? createddate.hashCode() : 0);
        result = 31 * result + (modifieddate != null ? modifieddate.hashCode() : 0);
        return result;
    }
}
