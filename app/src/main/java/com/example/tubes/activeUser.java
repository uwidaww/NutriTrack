package com.example.tubes;

public class activeUser {
    static Integer userID;
    static String name;
    static String gender;
    static int BB;
    static int TB;

    public activeUser(){

    }

    public activeUser(Integer id, String name, String gender, Integer BB, Integer TB){
        this.userID = id;
        this.name = name;
        this.gender = gender;
        this.BB = BB;
        this.TB = TB;
    }

    public void setTB(int TB) {
        this.TB = TB;
    }

    public void setBB(int BB) {
        this.BB = BB;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

