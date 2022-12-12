package com.semana07.simpledb;

public class Student {

    private long id;
    private String name;

    public Student(){

    }

    public void setId(long i){
        this.id = i;
    }

    public void setName(String n){
        this.name = n;
    }

    public long getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }

    @Override
    public String toString(){
        return name;
    }
}
