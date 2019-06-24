package com.example.ToeicOnline.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Exercise {
    private long exerciseid;
    private String name;
    private Timestamp createddate;
    private Timestamp modifieddate;
    private String type;

    @Id
    @Column(name = "exerciseid")
    public long getExerciseid() {
        return exerciseid;
    }

    public void setExerciseid(long exerciseid) {
        this.exerciseid = exerciseid;
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

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exercise exercise = (Exercise) o;

        if (exerciseid != exercise.exerciseid) return false;
        if (name != null ? !name.equals(exercise.name) : exercise.name != null) return false;
        if (createddate != null ? !createddate.equals(exercise.createddate) : exercise.createddate != null)
            return false;
        if (modifieddate != null ? !modifieddate.equals(exercise.modifieddate) : exercise.modifieddate != null)
            return false;
        if (type != null ? !type.equals(exercise.type) : exercise.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (exerciseid ^ (exerciseid >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (createddate != null ? createddate.hashCode() : 0);
        result = 31 * result + (modifieddate != null ? modifieddate.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
