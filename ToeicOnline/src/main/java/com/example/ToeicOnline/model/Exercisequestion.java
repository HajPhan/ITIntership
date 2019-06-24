package com.example.ToeicOnline.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Exercisequestion {
    private long exercisequestionid;
    private String image;
    private String audio;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String correctanswer;
    private long exerciseid;
    private Timestamp createddate;
    private Timestamp modifieddate;

    @Id
    @Column(name = "exercisequestionid")
    public long getExercisequestionid() {
        return exercisequestionid;
    }

    public void setExercisequestionid(long exercisequestionid) {
        this.exercisequestionid = exercisequestionid;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "audio")
    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    @Basic
    @Column(name = "question")
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Basic
    @Column(name = "option1")
    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    @Basic
    @Column(name = "option2")
    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    @Basic
    @Column(name = "option3")
    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    @Basic
    @Column(name = "option4")
    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    @Basic
    @Column(name = "correctanswer")
    public String getCorrectanswer() {
        return correctanswer;
    }

    public void setCorrectanswer(String correctanswer) {
        this.correctanswer = correctanswer;
    }

    @Basic
    @Column(name = "exerciseid")
    public long getExerciseid() {
        return exerciseid;
    }

    public void setExerciseid(long exerciseid) {
        this.exerciseid = exerciseid;
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

        Exercisequestion that = (Exercisequestion) o;

        if (exercisequestionid != that.exercisequestionid) return false;
        if (exerciseid != that.exerciseid) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        if (audio != null ? !audio.equals(that.audio) : that.audio != null) return false;
        if (question != null ? !question.equals(that.question) : that.question != null) return false;
        if (option1 != null ? !option1.equals(that.option1) : that.option1 != null) return false;
        if (option2 != null ? !option2.equals(that.option2) : that.option2 != null) return false;
        if (option3 != null ? !option3.equals(that.option3) : that.option3 != null) return false;
        if (option4 != null ? !option4.equals(that.option4) : that.option4 != null) return false;
        if (correctanswer != null ? !correctanswer.equals(that.correctanswer) : that.correctanswer != null)
            return false;
        if (createddate != null ? !createddate.equals(that.createddate) : that.createddate != null) return false;
        if (modifieddate != null ? !modifieddate.equals(that.modifieddate) : that.modifieddate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (exercisequestionid ^ (exercisequestionid >>> 32));
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (audio != null ? audio.hashCode() : 0);
        result = 31 * result + (question != null ? question.hashCode() : 0);
        result = 31 * result + (option1 != null ? option1.hashCode() : 0);
        result = 31 * result + (option2 != null ? option2.hashCode() : 0);
        result = 31 * result + (option3 != null ? option3.hashCode() : 0);
        result = 31 * result + (option4 != null ? option4.hashCode() : 0);
        result = 31 * result + (correctanswer != null ? correctanswer.hashCode() : 0);
        result = 31 * result + (int) (exerciseid ^ (exerciseid >>> 32));
        result = 31 * result + (createddate != null ? createddate.hashCode() : 0);
        result = 31 * result + (modifieddate != null ? modifieddate.hashCode() : 0);
        return result;
    }
}
