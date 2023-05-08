package com.example.Student_Library_Mangement_System.DTOs;

public class StudentMobRequestDto {
    private int id;
    private String mobNo;

    // Dto depends on APIs being called , and u can add attribute as required

    public StudentMobRequestDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }
}
