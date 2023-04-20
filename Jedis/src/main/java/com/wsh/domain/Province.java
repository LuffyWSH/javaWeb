package com.wsh.domain;

public class Province {
    private int id;
    private String name;

    public Province() {
    }

    public Province(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
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

    public String toString() {
        return "Province{id = " + id + ", name = " + name + "}";
    }
}
