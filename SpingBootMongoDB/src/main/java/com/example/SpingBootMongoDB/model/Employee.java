package com.example.SpingBootMongoDB.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(collection = "employee")
public class Employee {

//    @Field(value = "_id")
//    private int id;

    @Field(value = "fullname")
    private String fullName;

    @Field(value = "sex")
    private String sex;

    @Field(value = "birthday")
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
    private Date birthDay;

    @Field(value = "address")
    private String address;

    @Field(value = "phone")
    private String phone;

    public Employee() {
    }

    public Employee(String fullName, String sex, Date birthDay, String address, String phone) {
        this.fullName = fullName;
        this.sex = sex;
        this.birthDay = birthDay;
        this.address = address;
        this.phone = phone;
    }

    //    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
