package com.example.demo.entity;

public class Name {
    private String name;
    private int age;
    private String address;
    private boolean sex;

    public Name(String name, int age, String address, boolean sex) {
        this.name= name;
        this.age = age;
        this.address = address;
        this.sex = sex;
    }

    public Name() {
    }

    public String getName() {
        return name;
    }

    public void setName(String nameTest) {
        this.name = nameTest;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}
