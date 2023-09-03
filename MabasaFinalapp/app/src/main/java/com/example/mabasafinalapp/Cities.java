package com.example.mabasafinalapp;

public class Cities {
    private String name;
    private  int picId;

    public Cities(String name, int picId){
        this.name = name;
        this.picId = picId;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getPicId(){
        return picId;
    }
    public void setPicId(int picId){
        this.picId = picId;
    }
}
