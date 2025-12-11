package com.example.member_spring.controller.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class MemberUpdateDto {
    @NotNull
    private String name;
    @Min(0)
    private int age;
    @Email
    private String email;

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
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
}
