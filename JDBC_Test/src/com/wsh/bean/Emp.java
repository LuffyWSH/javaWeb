package com.wsh.domain;

public class Emp {
    private  Integer id;
    private  String name;
    private  String gender;
    private  Double salary;
    private  String join_date;
    private  Integer dept_id;


    public Emp() {
    }

    public Emp(Integer id, String name, String gender, Double salary, String join_date, Integer dept_id) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.join_date = join_date;
        this.dept_id = dept_id;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
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
     * @return salary
     */
    public Double getSalary() {
        return salary;
    }

    /**
     * 设置
     * @param salary
     */
    public void setSalary(Double salary) {
        this.salary = salary;
    }

    /**
     * 获取
     * @return join_date
     */
    public String getJoin_date() {
        return join_date;
    }

    /**
     * 设置
     * @param join_date
     */
    public void setJoin_date(String join_date) {
        this.join_date = join_date;
    }

    /**
     * 获取
     * @return dept_id
     */
    public Integer getDept_id() {
        return dept_id;
    }

    /**
     * 设置
     * @param dept_id
     */
    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    public String toString() {
        return "Emp{id = " + id + ", name = " + name + ", gender = " + gender + ", salary = " + salary + ", join_date = " + join_date + ", dept_id = " + dept_id + "}";
    }
}
