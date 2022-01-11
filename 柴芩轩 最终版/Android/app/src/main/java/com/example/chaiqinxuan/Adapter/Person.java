package com.example.chaiqinxuan.Adapter;

public class Person {

    private String id;
    private String name;
    private String num;
    private String value;
    private String m;

    public Person(String id, String name,String num,String value, String m) {
        super();
        this.id = id;
        this.name = name;
        this.num = num;
        this.value = value;
        this.m = m;
    }

    public String get_id() {
        return id;
    }

    public void set_id(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    @Override
    public String toString() {
        return  id + "," + name + "," + num + "," + value+ "," + m ;
    }

}