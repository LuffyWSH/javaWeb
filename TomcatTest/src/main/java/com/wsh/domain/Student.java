package com.wsh.domain;

public class Student {
    private String name;
    private String age;
    private String gender;
    private String main;
    private String main2;

    public Student() {
    }

    public Student(String name, String age) {
        this.name = name;
        this.age = age;
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
     * @return age
     */
    public String getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(String age) {
        this.age = age;
    }




    public String toString() {
        return "Student{name = " + name + ", age = " + age + "}";
    }
}
