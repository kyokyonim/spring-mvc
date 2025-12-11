package com.example.member_spring.controller.dto;

public class MemberCreateDto {
    private String name;
    private int age;
    private String email;

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public void setName(String name){ this.name = name;}
    public void setAge(int age){ this.age = age;}

    public void setEmail(String email){ this.email = email;}
    public String getEmail(){return email;}
}
