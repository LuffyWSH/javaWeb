package com.wsh.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class Student {
    private String name;
    private String gender;

   // @JsonIgnore //Java对象转json时忽略该属性
    @JsonFormat(pattern = "yy-MM-dd")
    private Date birthday;

    public Student() {
    }

    public Student(String name, String gender, Date birthday) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取
     * @return birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String toString() {
        return "Student{name = " + name + ", gender = " + gender + ", birthday = " + birthday + "}";
    }
}
