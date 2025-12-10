package com.example.member_spring.controller.dto;

public class MemberUpdateDto {
    private String name;
    private int age;

    public MemberUpdateDto() {

    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
